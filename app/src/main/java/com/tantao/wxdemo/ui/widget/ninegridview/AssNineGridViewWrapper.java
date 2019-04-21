package com.tantao.wxdemo.ui.widget.ninegridview;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.tantao.wxdemo.R;

/**
 * @author assionhonty
 * Created on 2018/9/19 9:10.
 * Email：assionhonty@126.com
 * Function:
 */
public class AssNineGridViewWrapper extends AppCompatImageView {

    /***显示更多的数量*/
    private int moreNum = 0;
    /***默认的遮盖颜色*/
    private int maskColor = 0x88000000;
    /***显示文字的大小单位sp*/
    private float textSize = 35;
    /***显示文字的颜色*/
    private int textColor = 0xFFFFFFFF;
    /***文字的画笔*/
    private TextPaint textPaint;
    /***要绘制的文字*/
    private String msg = "";

    private Bitmap loadView;

    //定义画笔
    private Paint paint;
    //倒计时的时间
    private int countDownTimeTotal = 1500;//总的倒计时默认是1.5秒
    //view默认的长度和高度
    private int defaultWidth = 200;
    private int defaultHeight = 300;
    //内外层圆弧的颜色，默认都为黑色
    private int outsideArcColor = Color.BLACK;
    private CountDownTimer countDownTimer;
    private float defaultStartAngle = 105;
    //计算改变之后的起始角度
    private float startAngle = defaultStartAngle;
    private float outsideArcWidth = 15f;
    private float outsideArcAngle = 330f;


    public AssNineGridViewWrapper(Context context) {
        this(context, null);
    }

    public AssNineGridViewWrapper(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AssNineGridViewWrapper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        loadView = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_tag);
        //转化单位
        textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSize, getContext().getResources().getDisplayMetrics());

        textPaint = new TextPaint();
        //文字居中对齐
        textPaint.setTextAlign(Paint.Align.CENTER);
        //抗锯齿
        textPaint.setAntiAlias(true);
        //设置文字大小
        textPaint.setTextSize(textSize);
        //设置文字颜色
        textPaint.setColor(textColor);

        initAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (moreNum > 0) {
            canvas.drawColor(maskColor);
            float baseY = getHeight() / 2 - (textPaint.ascent() + textPaint.descent()) / 2;
            canvas.drawText(msg, getWidth() / 2, baseY, textPaint);
        }

        int width = loadView.getWidth();
        int hight = loadView.getHeight();
        Paint photoPaint = new Paint();
        // 获取更清晰的图像采样，防抖动
        photoPaint.setDither(true);
        // 过滤一下，抗剧齿
        photoPaint.setFilterBitmap(true);
        Rect src = new Rect(0, 0, loadView.getWidth(), loadView.getHeight());// 创建一个指定的新矩形的坐标
        Rect dst = new Rect(0, 0, width, hight);// 创建一个指定的新矩形的坐标
        canvas.drawBitmap(loadView, src, dst, photoPaint);

        ////////////////////////
        initViewCitr(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                Drawable drawableUp = getDrawable();
                if (drawableUp != null) {
                    drawableUp.clearColorFilter();
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                break;
                default:
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }

    public int getMoreNum() {
        return moreNum;
    }

    public void setMoreNum(int moreNum) {
        this.moreNum = moreNum;
        msg = "+" + moreNum;
        invalidate();
    }

    public int getMaskColor() {
        return maskColor;
    }

    public void setMaskColor(int maskColor) {
        this.maskColor = maskColor;
        invalidate();
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        textPaint.setTextSize(textSize);
        invalidate();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        textPaint.setColor(textColor);
        invalidate();
    }

    private void initViewCitr(Canvas canvas){
        paint = new Paint();
        //首先绘制最外层的圆
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(outsideArcWidth);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(outsideArcColor);
        Path path = new Path();
        path.addArc(10, 10, defaultWidth - 10, defaultHeight - 10, startAngle, outsideArcAngle);
        canvas.drawPath(path, paint);
    }

    private void initAnim(){
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer.onFinish();
            countDownTimer = null;
        }
        countDownTimer = new CountDownTimer(countDownTimeTotal, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                //计算当前剩余时间的比例
                float radio = (float) millisUntilFinished / (float) countDownTimeTotal;

                float addAngle = 360 - 360 * radio;
                //根据比较改变开始位置的角度
                startAngle = defaultStartAngle;
                startAngle = defaultStartAngle + addAngle;

                invalidate();
            }

            @Override
            public void onFinish() {
                if(countDownTimer != null){
                    countDownTimer.start();
                }
            }
        };

        countDownTimer.start();
    }

    public void setFinish(){
        if(countDownTimer != null){
            countDownTimer.onFinish();
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

}
