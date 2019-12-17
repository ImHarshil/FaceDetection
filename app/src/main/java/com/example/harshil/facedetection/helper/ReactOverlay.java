package com.example.harshil.facedetection.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by ReactOverlay on 14-12-2019.
 */
public class ReactOverlay extends GraphicOverlay.Graphic {
    private  Rect rect;
    private  GraphicOverlay graphicOverlay;
    private int rect_color = Color.RED;
    private float STROKE_WIDTH = 4.0f;
    private Paint rectpaint;

    public ReactOverlay(GraphicOverlay graphicOverlay,Rect rect){
        super(graphicOverlay);
        rectpaint = new Paint();
        rectpaint.setColor(rect_color);
        rectpaint.setStyle(Paint.Style.STROKE);
        rectpaint.setStrokeWidth(STROKE_WIDTH);
        this.graphicOverlay = graphicOverlay;
        this.rect  = rect;
        postInvalidate();
    }

   /* public ReactOverlay(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    */
    @Override
    public void draw(Canvas canvas){
        RectF rectF = new RectF(rect);
        rectF.left = translateX(rectF.left);
        rectF.right = translateX(rectF.right);
        rectF.top = translateY(rectF.top);
        rectF.bottom = translateY(rectF.bottom);
        canvas.drawRect(rectF,rectpaint);
    }
}
