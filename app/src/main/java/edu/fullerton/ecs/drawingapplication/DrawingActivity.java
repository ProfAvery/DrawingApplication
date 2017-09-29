package edu.fullerton.ecs.drawingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawingActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String TAG = "DrawingActivity";

    private DrawingView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        myView = (DrawingView) findViewById(R.id.drawing_view);
        myView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //Log.d(TAG, motionEvent.toString());

        float x = motionEvent.getX();
        float y = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:
                myView.addPoint(x, y);
                myView.invalidate();
                break;
        }

        return true;
    }
}
