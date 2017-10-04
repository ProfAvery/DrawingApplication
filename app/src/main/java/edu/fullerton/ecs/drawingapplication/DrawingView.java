package edu.fullerton.ecs.drawingapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {

    private Paint foreground;
    private Paint background;

    private ArrayList<Float> xs;
    private ArrayList<Float> ys;

    public void addPoint(float x, float y) {
        this.xs.add(x);
        this.ys.add(y);
    }

    public DrawingView(Context context)  {
        this(context, null);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        xs = new ArrayList<>();
        ys = new ArrayList<>();

        background = new Paint();
        this.setBgColor(R.color.yellow);

        foreground = new Paint();
        this.setFgColor(R.color.blue);
    }

    public void setFgColor(int fgColor) {
        int color = ContextCompat.getColor(this.getContext(), fgColor);
        foreground.setColor(color);

        invalidate();
    }

    public void setBgColor(int bgColor) {
        int color = ContextCompat.getColor(this.getContext(), bgColor);
        background.setColor(color);

        invalidate();
    }

    private float dpToPixels(int dp) {
        return dp * getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPaint(background);

        for (int i = 0; i < xs.size(); i++) {
            canvas.drawCircle(xs.get(i), ys.get(i), dpToPixels(10), foreground);
        }

    }
}
