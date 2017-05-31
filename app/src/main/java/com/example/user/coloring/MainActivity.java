package com.example.user.coloring;

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
    int i=0,j=0,k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void red(View view) {
        if (i < 255)
            i++;
        else
            i=0;
        final TextView m1 = (TextView) findViewById(R.id.textView);
        m1.setText(""+i);
        rl = (RelativeLayout) this.findViewById(R.id.rellay);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
    }
    public void blue(View view) {
        if (k < 255)
            k++;
        else
            k=0;
        rl = (RelativeLayout) this.findViewById(R.id.rellay);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
        final TextView m2 = (TextView) findViewById(R.id.textView2);
        m2.setText(""+k);
    }
    public void green(View view) {
        if (j < 255)
            j++;
        else
            j=0;
        rl = (RelativeLayout) this.findViewById(R.id.rellay);
        rl.setBackgroundColor(Color.argb(255, i, j, k));
        final TextView m1 = (TextView) findViewById(R.id.textView3);
        m1.setText(""+j);
    }

}
