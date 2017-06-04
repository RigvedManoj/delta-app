package com.example.user.coloring;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
        TextView m1 = (TextView) findViewById(R.id.textView);
        m1.setText(""+i);
        m1 = (TextView) findViewById(R.id.textView3);
        m1.setText(""+j);
        m1 = (TextView) findViewById(R.id.textView2);
        m1.setText(""+k);
        rl = (RelativeLayout) this.findViewById(R.id.rellay);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
    }
    public void Reset(View view) {
        i=0;
        j=0;
        k=0;
        TextView m1 = (TextView) findViewById(R.id.textView);
        m1.setText(""+i);
        TextView m2 = (TextView) findViewById(R.id.textView3);
        m2.setText(""+j);
        TextView m3 = (TextView) findViewById(R.id.textView2);
        m3.setText(""+k);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
    }
    public void red(View view) {
        if (i < 255)
            i++;
        else
            i=0;
        TextView m1 = (TextView) findViewById(R.id.textView);
        m1.setText(""+i);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
    }
    public void blue(View view) {
        if (k < 255)
            k++;
        else
            k=0;
        rl.setBackgroundColor(Color.argb(255, i, j, k));
        TextView m1 = (TextView) findViewById(R.id.textView2);
        m1.setText(""+k);
    }
    public void green(View view) {
        if (j < 255)
            j++;
        else
            j=0;
        rl.setBackgroundColor(Color.argb(255, i, j, k));
        final TextView m1 = (TextView) findViewById(R.id.textView3);
        m1.setText(""+j);
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
