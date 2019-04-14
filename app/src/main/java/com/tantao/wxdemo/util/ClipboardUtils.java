package com.tantao.wxdemo.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * @author：tantao
 * @date：2019/4/6
 * desc : 剪贴板相关工具类
 */
public class ClipboardUtils {

    private ClipboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 复制文本到剪贴板
     *
     * @param text 文本
     */
    public static void copyText(final CharSequence text,Context mContext) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newPlainText("text", text));
    }

    /**
     * 获取剪贴板的文本
     *
     * @return 剪贴板的文本
     */
    public static CharSequence getText(Context mContext) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).coerceToText(mContext);
        }
        return null;
    }

    /**
     * 复制uri到剪贴板
     *
     * @param uri uri
     */
    public static void copyUri(final Uri uri,Context mContext) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newUri(mContext.getContentResolver(), "uri", uri));
    }

    /**
     * 获取剪贴板的uri
     *
     * @return 剪贴板的uri
     */
    public static Uri getUri(Context mContext) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).getUri();
        }
        return null;
    }

    /**
     * 复制意图到剪贴板
     *
     * @param intent 意图
     */
    public static void copyIntent(final Intent intent,Context mContext) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newIntent("intent", intent));
    }

    /**
     * 获取剪贴板的意图
     *
     * @return 剪贴板的意图
     */
    public static Intent getIntent(Context mContext) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).getIntent();
        }
        return null;
    }
}
