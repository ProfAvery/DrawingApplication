package edu.fullerton.ecs.drawingapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_drawing, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                myView.setFgColor(R.color.red);
                return true;
            case R.id.menu_green:
                myView.setFgColor(R.color.green);
                return true;
            case R.id.menu_blue:
                myView.setFgColor(R.color.blue);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
