package com.muhaiminurabir.circularprogressbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gmail.samehadar.iosdialog.IOSDialog;
import com.kaopiz.kprogresshud.KProgressHUD;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar progressBar1;
    private static CustomProgressBar progressBar3= new CustomProgressBar();
    DelayedProgressDialog progressBar4;
    Button prog_start1,prog_start2,prog_start3,prog_start4,prog_start5,prog_start6,prog_start7;
    Button prog_end1,prog_end2,prog_end3,prog_end4,prog_end5,prog_end6,prog_end7;
    FrameLayout frameLayout;

    private KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Progressbar One
        progressBar1=(ProgressBar)findViewById(R.id.prog1);
        frameLayout=(FrameLayout)findViewById(R.id.ProgressBarWrapper01);
        prog_start1=(Button)findViewById(R.id.prog_start1);
        prog_end1=(Button)findViewById(R.id.prog_end1);

        //Progressbar Two
        prog_start2=(Button)findViewById(R.id.prog_start2);
        prog_end2=(Button)findViewById(R.id.prog_end2);

        //Progressbar Three
        prog_start3=(Button)findViewById(R.id.prog_start3);
        prog_end3=(Button)findViewById(R.id.prog_end3);

        //Progressbar Four
        progressBar4 = new DelayedProgressDialog();
        prog_start4=(Button)findViewById(R.id.prog_start4);
        prog_end4=(Button)findViewById(R.id.prog_end4);

        //Progressbar Three
        prog_start5=(Button)findViewById(R.id.prog_start5);
        prog_end5=(Button)findViewById(R.id.prog_end5);

        //Progressbar Six
        prog_start6=(Button)findViewById(R.id.prog_start6);
        prog_end6=(Button)findViewById(R.id.prog_end6);

        //Progressbar Seven
        prog_start7=(Button)findViewById(R.id.prog_start7);
        prog_end7=(Button)findViewById(R.id.prog_end7);
        prog_start1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar1.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
            }
        });
        prog_end1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.GONE);
            }
        });
        prog_start2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new progressDialouge().execute("my string parameter");
            }
        });
        prog_end2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        prog_start3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar3.show(MainActivity.this,"Progress Bar Three");
            }
        });
        prog_end3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar3.getDialog().dismiss();
            }
        });
        prog_start4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar4.show(getSupportFragmentManager(), "tag");
                progressBar4.setCancelable(true);
                //getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        });
        prog_end4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar4.cancel();
            }
        });
        prog_start5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final IOSDialog dialog0 = new IOSDialog.Builder(MainActivity.this)
                        .setTitle("ProgressBar Five One")
                        .setTitleColorRes(R.color.gray)
                        .build();
                final IOSDialog dialog1 = new IOSDialog.Builder(MainActivity.this)
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                dialog0.show();
                            }
                        })
                        .setDimAmount(3)
                        .setSpinnerColorRes(R.color.colorPrimary)
                        .setMessageColorRes(R.color.colorAccent)
                        .setTitle(R.string.standard_title)
                        .setTitleColorRes(R.color.colorPrimary)
                        .setMessageContent("ProgressBar Five Two")
                        .setCancelable(true)
                        .setMessageContentGravity(Gravity.END)
                        .build();
                IOSDialog dialog2 = new IOSDialog.Builder(MainActivity.this)
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                dialog1.show();
                            }
                        })
                        .setSpinnerColorRes(R.color.ios_gray_text)
                        .setMessageColorRes(R.color.primaryDark)
                        .setTitleColorRes(R.color.accent)
                        .setMessageContent("ProgressBar Five Three")
                        .setCancelable(true)
                        .setSpinnerClockwise(false)
                        .setSpinnerDuration(120)
                        .setMessageContentGravity(Gravity.END)
                        .build();
                dialog2.show();
            }
        });
        prog_end5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        prog_start6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showSimpleIndeterminate(getCurrentFocus());
            }
        });
        prog_end6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
        prog_start7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ACProgressFlower dialog = new ACProgressFlower.Builder(MainActivity.this)
                        .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                        .themeColor(Color.WHITE)
                        .text("Progressbar Seven")
                        .fadeColor(Color.DKGRAY).build();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        });
        prog_end7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
        //for especial six
        Button indeterminate = (Button) findViewById(R.id.indeterminate);
        indeterminate.setOnClickListener(this);

        Button labelIndeterminate = (Button) findViewById(R.id.label_indeterminate);
        labelIndeterminate.setOnClickListener(this);

        Button detailIndeterminate = (Button) findViewById(R.id.detail_indeterminate);
        detailIndeterminate.setOnClickListener(this);

        Button graceIndeterminate = (Button) findViewById(R.id.grace_indeterminate);
        graceIndeterminate.setOnClickListener(this);

        Button determinate = (Button) findViewById(R.id.determinate);
        determinate.setOnClickListener(this);

        Button annularDeterminate = (Button) findViewById(R.id.annular_determinate);
        annularDeterminate.setOnClickListener(this);

        Button barDeterminate = (Button) findViewById(R.id.bar_determinate);
        barDeterminate.setOnClickListener(this);

        Button customView = (Button) findViewById(R.id.custom_view);
        customView.setOnClickListener(this);

        Button dimBackground = (Button) findViewById(R.id.dim_background);
        dimBackground.setOnClickListener(this);

        Button customColor = (Button) findViewById(R.id.custom_color_animate);
        customColor.setOnClickListener(this);
    }

    private class progressDialouge extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        ProgressDialog progressBar2;
        boolean running;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            // Do something like display a progress bar

            running = true;

            progressBar2 = ProgressDialog.show(MainActivity.this,"ProgressDialog Two","Wait!");

            progressBar2.setCanceledOnTouchOutside(false);
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            try {
                int i = 10;
                while(running){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(i-- == 0){
                        running = false;
                    }

                    //publishProgress(i);

                }

            }catch (Exception e){
                Log.d("Paisi send data 2",e.toString());
            }

            return "this string is passed to onPostExecute";
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            //progressDialog4.setMessage(String.valueOf(values[0]));
            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Do things like hide the progress bar or change a TextView
            progressBar2.dismiss();
        }
    }

    public void showSimpleIndeterminate(View v) {
        TimeConsumingTask t = new TimeConsumingTask();
        t.execute();
    }
    public class TimeConsumingTask extends AsyncTask<Void, String, Void> implements DialogInterface.OnCancelListener {
        ProgressHUD mProgressHUD;

        @Override
        protected void onPreExecute() {
            mProgressHUD = ProgressHUD.show(MainActivity.this,"Connecting", true,true,this);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                publishProgress("Connecting");
                Thread.sleep(2000);
                publishProgress("Downloading");
                Thread.sleep(5000);
                publishProgress("Done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mProgressHUD.setMessage(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void result) {
            mProgressHUD.dismiss();
            super.onPostExecute(result);
        }

        @Override
        public void onCancel(DialogInterface dialog) {
            this.cancel(true);
            mProgressHUD.dismiss();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.indeterminate:
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
                scheduleDismiss();
                break;
            case R.id.label_indeterminate:
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setCancellable(true);
                new DialogInterface.OnCancelListener() {
                    @Override public void onCancel(DialogInterface dialogInterface) {
                                Toast.makeText(MainActivity.this, "You " +
                                        "cancelled manually!", Toast
                                        .LENGTH_SHORT).show();
                    }
                };

                scheduleDismiss();
                break;
            case R.id.detail_indeterminate:
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setDetailsLabel("Downloading data");
                scheduleDismiss();
                break;
            case R.id.grace_indeterminate:
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setGraceTime(1000);
                scheduleDismiss();
                break;
            case R.id.determinate:
                hud = KProgressHUD.create(MainActivity.this)
                        .setStyle(KProgressHUD.Style.PIE_DETERMINATE)
                        .setLabel("Please wait");
                simulateProgressUpdate();
                break;
            case R.id.annular_determinate:
                hud = KProgressHUD.create(MainActivity.this)
                        .setStyle(KProgressHUD.Style.ANNULAR_DETERMINATE)
                        .setLabel("Please wait")
                        .setDetailsLabel("Downloading data");
                simulateProgressUpdate();
                break;
            case R.id.bar_determinate:
                hud = KProgressHUD.create(MainActivity.this)
                        .setStyle(KProgressHUD.Style.BAR_DETERMINATE)
                        .setLabel("Please wait");
                simulateProgressUpdate();
                break;
            case R.id.custom_view:
                ImageView imageView = new ImageView(this);
                imageView.setBackgroundResource(R.drawable.spin_animation);
                AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
                drawable.start();
                hud = KProgressHUD.create(this)
                        .setCustomView(imageView)
                        .setLabel("This is a custom view");
                scheduleDismiss();
                break;
            case R.id.dim_background:
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setDimAmount(0.5f);
                scheduleDismiss();
                break;
            case R.id.custom_color_animate:
                //noinspection deprecation
                hud = KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setWindowColor(getResources().getColor(R.color.colorPrimary))
                        .setAnimationSpeed(2);
                scheduleDismiss();
                break;
        }

        hud.show();
    }

    private void simulateProgressUpdate() {
        hud.setMaxProgress(100);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int currentProgress;
            @Override
            public void run() {
                currentProgress += 1;
                hud.setProgress(currentProgress);
                if (currentProgress == 80) {
                    hud.setLabel("Almost finish...");
                }
                if (currentProgress < 100) {
                    handler.postDelayed(this, 50);
                }
            }
        }, 100);
    }

    private void scheduleDismiss() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hud.dismiss();
            }
        }, 2000);
    }
}
