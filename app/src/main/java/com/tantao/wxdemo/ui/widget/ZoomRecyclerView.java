package com.tantao.wxdemo.ui.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.*;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author：tantao
 * @date：2019/3/25
 */
public class ZoomRecyclerView extends RecyclerView {

    private LinearLayoutManager mLayoutManager;
    private int mTouchSlop;
    private View zoomView;
    // 记录首次按下位置
    private float mFirstPosition = 0;
    // 是否正在放大
    private Boolean mScaling = false;

    LinearLayoutManager mLinearLayoutManager ;
    private int screenWidth;

    public ZoomRecyclerView(@NonNull Context context) {
        super(context);
    }

    public ZoomRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoomRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mLayoutManager = new LinearLayoutManager(context);
        setLayoutManager(mLayoutManager);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setZoomView(View v,int imgId, LinearLayoutManager linearLayoutManager) {
        //获取屏幕宽度
        WindowManager wm = (WindowManager)getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        //此处我的图片命名为img，大家根据实际情况修改
        ImageView img =(ImageView)v.findViewById(imgId);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) img.getLayoutParams();
        //获取屏幕宽度
        lp.width =screenWidth;
        //设置宽高比为16:9
        lp.height = screenWidth * 9 / 16;
        //给imageView重新设置宽高属性
        img.setLayoutParams(lp);
        this.zoomView = img;
        mLinearLayoutManager = linearLayoutManager ;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(zoomView !=null){
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) zoomView.getLayoutParams();
            //判断触摸事件
            switch (e.getAction()) {
                //触摸结束
                case MotionEvent.ACTION_UP:
                    mScaling = false;
                    replyImage();
                    break;
                //触摸中
                case MotionEvent.ACTION_MOVE:
                    //判断是否正在放大 mScaling 的默认值为false
                    if (!mScaling) {
                        //当图片也就是第一个item完全可见的时候，记录触摸屏幕的位置
                        if (mLinearLayoutManager.findViewByPosition(mLinearLayoutManager.findFirstVisibleItemPosition()).getTop() == 0) {
                            //记录首次按下位置
                            mFirstPosition = e.getY();
                        } else {
                            break;
                        }
                    }
                    // 滚动距离乘以一个系数
                    int distance = (int) ((e.getY() - mFirstPosition) * 0.4);
                    if (distance < 0) {
                        break;
                    }
                    // 处理放大
                    mScaling = true;

                    lp.width = zoomView.getWidth() + distance;
                    lp.height = (zoomView.getWidth()  + distance) * 9 / 16;
                    System.out.println( "宽度是 =  " +  lp.width + "高度是" + lp.height);
                    // 设置控件水平居中（如果不设置，图片的放大缩小是从图片顶点开始）
                    ((ViewGroup.MarginLayoutParams) lp).setMargins(-(lp.width -screenWidth) / 2, 0, 0, 0);
                    zoomView.setLayoutParams(lp);
                    return true; // 返回true表示已经完成触摸事件，不再处理
            }
        }

        return super.onTouchEvent(e);
    }

    private void replyImage() {
        final RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) zoomView.getLayoutParams();
        final float wPresent = zoomView.getLayoutParams().width;// 图片当前宽度
        final float hPresent = zoomView.getLayoutParams().height;// 图片当前高度

        final float width = screenWidth;// 图片原宽度
        final float heigh = screenWidth * 9 / 16;// 图片原高度

        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration(200);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                lp.width = (int) (wPresent - (wPresent - width) * cVal);
                lp.height = (int) (hPresent - (hPresent - heigh) * cVal);
                ((MarginLayoutParams) lp).setMargins(-(lp.width - screenWidth) / 2, 0, 0, 0);
                zoomView.setLayoutParams(lp);
            }
        });
        anim.start();
    }
}
