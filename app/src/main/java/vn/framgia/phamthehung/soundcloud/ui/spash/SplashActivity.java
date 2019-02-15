package vn.framgia.phamthehung.soundcloud.ui.spash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import vn.framgia.phamthehung.soundcloud.MainActivity;
import vn.framgia.phamthehung.soundcloud.R;

public class SplashActivity extends AppCompatActivity {
    private static final int TIME_DELAY = 10000;
    private ImageView mImageView;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        mImageView = findViewById(R.id.image_view);
        mImageView.setVisibility(View.VISIBLE);
        mImageView.startAnimation(mAnimation);
        startThread();
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(TIME_DELAY);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private void startThread() {
        Thread thread = new Thread(mRunnable);
        thread.start();
    }
}
