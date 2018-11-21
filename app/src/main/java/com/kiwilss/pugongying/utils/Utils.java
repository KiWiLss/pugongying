package com.kiwilss.pugongying.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @author : Lss kiwilss
 * @FileName: Utils
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/21
 * @desc : ${DESCRIPTION}
 */
public class Utils {

    public static Bitmap drawTextToBitmap(Context gContext,
                                          int gResId,
                                          int gText) {
        String text = String.valueOf(gText);

        Resources resources = gContext.getResources();
        float scale = resources.getDisplayMetrics().density;
        Bitmap bitmap =
                BitmapFactory.decodeResource(resources, gResId);

        // resource bitmaps are imutable,
        // so we need to convert it to mutable one
        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextSize((int) (12*scale));
        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setTextAlign(gText > 9?Paint.Align.CENTER:Paint.Align.RIGHT);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int x = (bitmap.getWidth() - bounds.width())/2;
        int y = (bitmap.getHeight() - bounds.height())/2;
        canvas.drawText(text, x*2, y*2 , paint);
        return bitmap;
    }


}
