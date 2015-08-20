package com.chosenanimation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity2 extends ActionBarActivity {

    private ImageView image;
    private Animation fadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);
        image = (ImageView) findViewById(R.id.pic2);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        image.startAnimation(fadein);
    }

    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        runFadeOutAnim(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });
    }

    public void runFadeOutAnim(final Runnable endAction){
        image.animate()
             .setDuration(500)
             .scaleX(0).scaleY(0).alpha(0)
             .withEndAction(endAction);
    }
}
