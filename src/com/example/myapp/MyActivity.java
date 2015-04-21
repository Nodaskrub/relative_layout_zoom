package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ScaleGestureDetector;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    private class OnPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener
    {
        float currentSpan;
        float startFocusX;
        float startFocusY;

        public boolean onScaleBegin(ScaleGestureDetector detector)
        {
            currentSpan = detector.getCurrentSpan();
            startFocusX = detector.getFocusX();
            startFocusY = detector.getFocusY();
            return true;
        }

        public boolean onScale(ScaleGestureDetector detector)
        {
            ZoomableRelativeLayout zoomableRelativeLayout= (ZoomableRelativeLayout) MyActivity.this.findViewById(R.id.zoomableRelativeLayout);

            zoomableRelativeLayout.relativeScale(detector.getCurrentSpan() / currentSpan, startFocusX, startFocusY);

            currentSpan = detector.getCurrentSpan();

            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector)
        {
            ZoomableRelativeLayout zoomableRelativeLayout= (ZoomableRelativeLayout) MyActivity.this.findViewById(R.id.zoomableRelativeLayout);

            zoomableRelativeLayout.release();
        }
    }
}
