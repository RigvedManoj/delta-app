package com.example.user.deltatask1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout rl;
    int i,j,k;
    public static final String a1 = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPrefs1 = getApplicationContext().getSharedPreferences(a1, Context.MODE_PRIVATE);
        i= sharedPrefs1.getInt("counter1", 0);
        SharedPreferences sharedPrefs2 = getApplicationContext().getSharedPreferences(a1, Context.MODE_PRIVATE);
        j= sharedPrefs2.getInt("counter2", 0);
        SharedPreferences sharedPrefs3 = getApplicationContext().getSharedPreferences(a1, Context.MODE_PRIVATE);
        k= sharedPrefs3.getInt("counter3", 0);
        TextView m1 = (TextView) findViewById(R.id.textView2);
        m1.setText("RED: "+i);
        TextView m2 = (TextView) findViewById(R.id.textView3);
        m2.setText("GREEN: "+j);
        TextView m3 = (TextView) findViewById(R.id.textView);
        m3.setText("BLUE: "+k);
        rl = (RelativeLayout) this.findViewById(R.id.rellay);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
        SeekBar yourSeekBar=(SeekBar) findViewById(R.id.seekBar);
        yourSeekBar.setProgress(i);
        yourSeekBar.setOnSeekBarChangeListener(new yourListener());
        yourSeekBar=(SeekBar) findViewById(R.id.seekBar2);
        yourSeekBar.setProgress(j);
        yourSeekBar.setOnSeekBarChangeListener(new yourListener2());
        yourSeekBar=(SeekBar) findViewById(R.id.seekBar3);
        yourSeekBar.setProgress(k);
        yourSeekBar.setOnSeekBarChangeListener(new yourListener3());
    }
    private class yourListener implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // Log the progress
            Log.d("DEBUG", "Progress is: "+progress);
            //set textView's text
            SeekBar w1 = (SeekBar) findViewById(R.id.seekBar);
            TextView m1 = (TextView) findViewById(R.id.textView2);
            m1.setText("RED: "+progress);
            i=w1.getProgress();
            rl.setBackgroundColor(Color.argb(255,i, j, k));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {}

        public void onStopTrackingTouch(SeekBar seekBar) {}

    }
    private class yourListener2 implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // Log the progress
            Log.d("DEBUG", "Progress is: "+progress);
            //set textView's text
            SeekBar w1 = (SeekBar) findViewById(R.id.seekBar2);
            TextView m1 = (TextView) findViewById(R.id.textView3);
            m1.setText("GREEN: "+progress);
            j=w1.getProgress();
            rl.setBackgroundColor(Color.argb(255, i, j, k));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {}

        public void onStopTrackingTouch(SeekBar seekBar) {}

    }
    private class yourListener3 implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // Log the progress
            Log.d("DEBUG", "Progress is: "+progress);
            //set textView's text
            SeekBar w1 = (SeekBar) findViewById(R.id.seekBar3);
            TextView m1 = (TextView) findViewById(R.id.textView);
            m1.setText("BLUE: "+progress);
            k=w1.getProgress();
            rl.setBackgroundColor(Color.argb(255, i, j, k));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {}

        public void onStopTrackingTouch(SeekBar seekBar) {}

    }
    public void Reset(View view) {
        i=0;
        j=0;
        k=0;
        SeekBar w1 = (SeekBar) findViewById(R.id.seekBar);
        w1.setProgress(i);
        w1 = (SeekBar) findViewById(R.id.seekBar2);
        w1.setProgress(j);
        w1 = (SeekBar) findViewById(R.id.seekBar3);
        w1.setProgress(k);
        TextView m1 = (TextView) findViewById(R.id.textView2);
        m1.setText("RED: "+i);
        TextView m2 = (TextView) findViewById(R.id.textView3);
        m2.setText("GREEN: "+j);
        TextView m3 = (TextView) findViewById(R.id.textView);
        m3.setText("BLUE: "+k);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
    }
    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences(a1, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("counter1", i);
        editor.putInt("counter2", j);
        editor.putInt("counter3", k);
        editor.commit();
    }
}
