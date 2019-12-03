package sysu.mobile.limk.indoormapview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import sysu.mobile.limk.library.indoormapview.MapView;
import sysu.mobile.limk.library.indoormapview.OnRealLocationMoveListener;
import sysu.mobile.limk.library.indoormapview.Position;


public class MainActivity extends AppCompatActivity {

    private MapView mMapView;
    private TextView mInfoTextView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = (MapView) findViewById(R.id.mapview);
        mInfoTextView = (TextView) findViewById(R.id.tv_current_location);

        try {
            mMapView.initNewMap(getAssets().open("gogo.png"), 1, 0, new Position(652, 684));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMapView.updateMyLocation(new Position(652, 684));
        mMapView.setOnRealLocationMoveListener(new OnRealLocationMoveListener() {
            @Override
            public void onMove(Position position) {
                mInfoTextView.setText(position.toString());
            }
        });


        /*
        simple way
        mMapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){

                    System.out.println(mMapView.touchX);
                    System.out.println(mMapView.touchY);
                    return true;
                }
                return false;
            }
        });

         */
    }
}
