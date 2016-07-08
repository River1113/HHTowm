package com.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.graphics.BitmapCompat;

import com.squareup.picasso.Transformation;

/**
 * Created by Jimmy on 16/6/12.
 * 简洁版本(同时对4个角的处理)
 * 根据RoundedCornerTransFormation
 */
public class CornerImageTransFormation implements Transformation{
    //定义倒角的半径(影响绘制图片弧度的效果)
    private int mRadius;

    //定义构造方法
    public CornerImageTransFormation(int radius){
        mRadius = radius;
    }

    //图形转换的规则定义
    @Override
    public Bitmap transform(Bitmap source) {
        //需要使用到倒角的半径


        //1.需要提供Canvas画布 (自己new)
        //传递自己定义的Bitmap ,自己创建新的Bitmap 和原始的source进行区分 (现在会有2个Bitmap的产生)
        //通过createBitmap方法创建新的视图
        //可以实现截图的效果(通过调用5个参数的方法,重新定义x,y宽度和高度)
        //如果进行轴对称个,中心堆成效果可以配合Matrix使用
        //新的图片可以定义新的Config参数
        int width = source.getWidth();
        int height = source.getHeight();
        // 不能选565没有透明色的情况
        Bitmap newBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(newBitmap); //由Bitmap构建
        //2.画笔 (自己 new)
        Paint paint = new Paint();
        paint.setAntiAlias(true); //抗锯齿
        //处理图片的方式 (shader着色器,对图片的渲染效果)
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        //给图片绘制倒角 (具有倒角的矩形框)
        RectF rect = new RectF(0,0,width,height);
        canvas.drawRoundRect(rect, mRadius,mRadius,paint);
        source.recycle(); //Bitmap可以调用recycle进行回收,释放内存
        return newBitmap; //返回处理完毕的新的图片
    }

    //对处理完Bitmap的描述
    @Override
    public String key() {
        return "newBitmap--> conner:" + mRadius;
    }
}
