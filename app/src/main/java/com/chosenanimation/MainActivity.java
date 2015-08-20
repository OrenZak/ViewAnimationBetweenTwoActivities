package com.chosenanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView image;
    private ImageView image2;
    private View squerred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         image = (ImageView) findViewById(R.id.pic1);
         image2 = (ImageView) findViewById(R.id.pic2);
         squerred = findViewById(R.id.square_red);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                 Pair<View, String> p1 = Pair.create((View)squerred, "trans");
                 Pair<View, String> p2 = Pair.create((View) image, "trans1");
                 Pair<View, String> p3 = Pair.create((View)image2, "trans2");
                 ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1, p2, p3);

                startActivity(i, options.toBundle());
            }
        });
    }
}
