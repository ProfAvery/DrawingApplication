package edu.fullerton.ecs.drawingapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by AD\kavery on 9/26/17.
 */

public class DrawingView extends View {

    private Paint foreground;

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

        // watch this space
        xs = new ArrayList<Float>();
        ys = new ArrayList<Float>();

        foreground = new Paint();
        foreground.setColor(Color.BLUE);
    }

    private float dpToPixels(int dp) {
        return dp * getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.YELLOW);

        for (int i = 0; i < xs.size(); i++) {
            canvas.drawCircle(xs.get(i), ys.get(i), dpToPixels(10), foreground);
        }

    }
}
