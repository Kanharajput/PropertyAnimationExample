package com.example.propertyanimationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.moving_button);    // reference of the button
        circle = findViewById(R.id.circle_image);
    }

    public void movingButton(View view) {

        ValueAnimator animation = ValueAnimator.ofFloat(0f, 520f);
        animation.setDuration(1000);
        animation.start();


        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {      // change the position of the button per millisecond. check the rules
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                // You can use the animated value in a property that uses the
                // same type as the animation. In this case, you can use the
                // float value in the translationX property.
                float animatedValue = (float)updatedAnimation.getAnimatedValue();
                button.setTranslationX(animatedValue);
            }
        });

        // with this we don't need onAnimationUpdate method , ObjectAnimator take care of that
        // also initial position is by default 0
        /*ObjectAnimator animation = ObjectAnimator.ofFloat(button, "translationX", 520f);
        animation.setDuration(500);
        animation.start();*/
    }

    public void ArcMotion(View view) {

        Path path = new Path();
        path.arcTo(0f,0f,1000f,1000f,270f,-180f,true);    // creating new path as we want it to move like this

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        animator.setDuration(2000);
        animator.start();

    }
}