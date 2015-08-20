package com.chosenanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    private ImageView image;
    private Activity mThis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.pic1);
        mThis = this;
    }


    @Override
    protected void onResume() {
        super.onResume();
        image.animate().setDuration(500).scaleX(1).scaleY(1).alpha(1);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.animate().setDuration(500).scaleX(0).scaleY(0).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(MainActivity.this, Activity2.class);
                        startActivity(i);
                        mThis.overridePendingTransition(0, 0);
                    }
                });


            }
        });
    }

}
