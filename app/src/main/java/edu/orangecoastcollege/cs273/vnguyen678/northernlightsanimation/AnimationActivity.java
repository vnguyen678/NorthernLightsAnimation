package edu.orangecoastcollege.cs273.vnguyen678.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;
    private AnimationDrawable framAnim;
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation custonAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightImageView);
    }

    public void toggleFrameAnim(View view)
    {
        // 1 Programmatiocally set the background of the image view to  @drawable/light1
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);
        // 2 Associate the framAnim with the animation in XML
        framAnim = (AnimationDrawable) lightsImageView.getBackground();
        // 3 start the animetion

        if(framAnim.isRunning())
            framAnim.stop();
        else
            framAnim.start();
    }

    public void rotateAnim(View view)
    {

        if(rotateAnim != null && rotateAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else
        {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        }
    }

    public void shakeAnim(View view)
    {
        if(shakeAnim != null && shakeAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }
        else
        {
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
            lightsImageView.startAnimation(shakeAnim);
        }
    }


}
