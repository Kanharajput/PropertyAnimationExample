package com.example.propertyanimationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);    // reference of the button
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
}