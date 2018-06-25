package com.muhaiminurabir.circularprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private static CustomProgressBar progressBar3 = new CustomProgressBar();
    ProgressBar progressBar;
    Button start;
    Button end;
    FrameLayout frameLayout;
    DelayedProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.prog);
        frameLayout=(FrameLayout)findViewById(R.id.ProgressBarWrapper01);
        start=(Button)findViewById(R.id.start);
        end=(Button)findViewById(R.id.end);
        progressDialog = new DelayedProgressDialog();
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar3.show(MainActivity.this,"Loading..");
                //progressBar.setVisibility(View.VISIBLE);
                //frameLayout.setVisibility(View.VISIBLE);
                //progressDialog.show(getSupportFragmentManager(), "tag");
                //progressDialog.setCancelable(false);
                /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);*/

            }
        });
        end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar3.getDialog().dismiss();
                //frameLayout.setVisibility(View.GONE);
                //progressDialog.cancel();
            }
        });
    }
}
