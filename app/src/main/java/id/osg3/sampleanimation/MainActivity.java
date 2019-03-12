package id.osg3.sampleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup transitionsContainer = findViewById(R.id.transitions_container);
        final ImageView imageView = findViewById(R.id.image);

        imageView.setOnClickListener(new View.OnClickListener() {
            boolean mExpanded;
            @Override
            public void onClick(View v) {
                mExpanded = !mExpanded;
                TransitionManager.beginDelayedTransition(transitionsContainer, new TransitionSet()
                        .addTransition(new ChangeBounds())
                        .addTransition(new ChangeImageTransform()));

                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = mExpanded ? ViewGroup.LayoutParams.WRAP_CONTENT :
                        ViewGroup.LayoutParams.WRAP_CONTENT;
                imageView.setLayoutParams(params);

                imageView.setScaleType(mExpanded ? ImageView.ScaleType.CENTER_CROP :
                        ImageView.ScaleType.FIT_CENTER);
            }
        });

    }

    public void clockwise(View view){
        ImageView image = findViewById(R.id.image);
        Animation clockwiseAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(clockwiseAnim);
    }

    public void zoom(View view){
        ImageView image = findViewById(R.id.image);
        Animation zoomAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        image.startAnimation(zoomAnim);
    }

    public void fade(View view){
        ImageView image = findViewById(R.id.image);
        Animation fadeAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(fadeAnim);
    }

    public void blink(View view){
        ImageView image = findViewById(R.id.image);
        Animation blinkAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(blinkAnim);
    }

    public void move(View view){
        ImageView image = findViewById(R.id.image);
        Animation moveAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(moveAnim);
    }

    public void slide(View view){
        TextView textView = findViewById(R.id.textSlide);
        Animation slideAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        textView.startAnimation(slideAnim);
    }

}