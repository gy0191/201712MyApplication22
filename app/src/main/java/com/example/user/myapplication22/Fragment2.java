package com.example.user.myapplication22;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment2 extends Fragment
{
    public Fragment2()
    {
        // required
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_fragment2,
                container, false);
        return layout;
    }

    public class ThreadExampleActivity  extends Activity {
        int mMainValue = 0;
        int mBackValue = 0;
        TextView mMainText, mBackText;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_fragment2);

            mMainText = (TextView) findViewById(R.id.mainvalue);
            mBackText = (TextView) findViewById(R.id.backvalue);

            BackRunnable runnable = new BackRunnable();
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
        }


        public void mOnClick(View v) {
            mMainValue++;
            mMainText.setText("MainValue : " + mMainValue);
            mBackText.setText("BackValue : " + mBackValue);
        }

        class BackRunnable implements Runnable {
            public void run() {
                while (true) {
                    mBackValue++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        ;
                    }
                }
            }
        }


    }

}


