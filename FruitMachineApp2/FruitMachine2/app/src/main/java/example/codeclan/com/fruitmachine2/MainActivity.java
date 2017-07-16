package example.codeclan.com.fruitmachine2;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.button;
import static android.R.id.button1;



public class MainActivity extends AppCompatActivity {

    Button b_roll, button1Hold, button2Hold, button3Hold, button1Nudge, button2Nudge, button3Nudge, buttontmp;
    ImageView image1, image2, image3, image1Top, image2Top, image3Top, image1Bot, image2Bot, image3Bot;
    Random r;
    int img1, img2, img3, randomDelay, time;
    ArrayList<AnimationDrawable> reel1, reel2, reel3;
    ArrayList<Button> buttons;
    ArrayList<ImageView> images;
    Boolean reel1Active, reel2Active, reel3Active;
    AnimationDrawable drawableToStop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();
        b_roll = (Button) findViewById(R.id.b_roll);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image1Top = (ImageView) findViewById(R.id.image1Top);
        image2Top = (ImageView) findViewById(R.id.image2Top);
        image3Top = (ImageView) findViewById(R.id.image3Top);
        image1Bot = (ImageView) findViewById(R.id.image1Bot);
        image2Bot = (ImageView) findViewById(R.id.image2Bot);
        image3Bot = (ImageView) findViewById(R.id.image3Bot);
        button1Hold = (Button) findViewById(R.id.button1Hold);
        button2Hold = (Button) findViewById(R.id.button2Hold);
        button3Hold = (Button) findViewById(R.id.button3Hold);
        button1Nudge = (Button) findViewById(R.id.button1Nudge);
        button2Nudge = (Button) findViewById(R.id.button2Nudge);
        button3Nudge = (Button) findViewById(R.id.button3Nudge);
        buttons = new ArrayList<Button>();
        images = new ArrayList<ImageView>();
        buttons.add(button1Hold);
        buttons.add(button2Hold);
        buttons.add(button3Hold);
        buttons.add(button1Nudge);
        buttons.add(button2Nudge);
        buttons.add(button3Nudge);
        reel1 = new ArrayList<AnimationDrawable>();
        reel2 = new ArrayList<AnimationDrawable>();
        reel3 = new ArrayList<AnimationDrawable>();
        reel1Active = true;
        reel2Active = true;
        reel3Active = true;


        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearImages();
                reel1Go();
                reel2Go();
                reel3Go();
//                getScore();
//                resetReelActives();
            }
        });
//        getScore();
    }

    public void reel1Go() {
        int time = generateRandomDelay();
        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                spinReel1();
            }
            public void onFinish() {
                setImagesReel1();
            }
        }.start();
    }

    public void reel2Go() {
        int time = generateRandomDelay();
        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                spinReel2();
            }
            public void onFinish() {
                setImagesReel2();
            }
        }.start();
    }

    public void reel3Go() {
        int time = generateRandomDelay();
        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                spinReel3();
            }
            public void onFinish() {
                setImagesReel3();
                getScore();
            }
        }.start();

    }


    public void spinReel1() {

        if (reel1Active) {
//            clearImages();
            final ArrayList<AnimationDrawable> reel1 = new ArrayList<AnimationDrawable>();
            image1Top.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image1TopAnim = (AnimationDrawable) image1Top.getBackground();
            reel1.add(image1TopAnim);
            images.add(image1Top);
            image1TopAnim.start();


            image1.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image1anim = (AnimationDrawable) image1.getBackground();
            reel1.add(image1anim);
            images.add(image1);
            image1anim.start();


            image1Bot.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image1BotAnim = (AnimationDrawable) image1Bot.getBackground();
            reel1.add(image1BotAnim);
            images.add(image1Bot);
            image1BotAnim.start();
        }
    }

    public void spinReel2() {
//                animate second image
        if (reel2Active) {
            final ArrayList<AnimationDrawable> reel2 = new ArrayList<AnimationDrawable>();
            image2Top.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image2TopAnim = (AnimationDrawable) image2Top.getBackground();
            reel2.add(image2TopAnim);
            images.add(image2Top);
            image2TopAnim.start();

            image2.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image2anim = (AnimationDrawable) image2.getBackground();
            reel2.add(image2anim);
            images.add(image2);
            image2anim.start();

            image2Bot.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image2BotAnim = (AnimationDrawable) image2Bot.getBackground();
            reel2.add(image2BotAnim);
            images.add(image2Bot);
            image2BotAnim.start();
        }
    }

    public void spinReel3(){
//                animate third image
        if(reel3Active) {
//            clearImages();
            final ArrayList<AnimationDrawable> reel3 = new ArrayList<AnimationDrawable>();
            image3Top.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image3TopAnim = (AnimationDrawable) image3Top.getBackground();
            reel3.add(image3TopAnim);
            images.add(image3Top);
            image3TopAnim.start();



            image3.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image3anim = (AnimationDrawable) image3.getBackground();
//            drawables.add(image1anim);
            reel3.add(image3anim);
            images.add(image3);
            image3anim.start();



            image3Bot.setBackgroundResource(R.drawable.anim);
            final AnimationDrawable image3BotAnim = (AnimationDrawable) image3Bot.getBackground();
//            drawables.add(image1BotAnim);
            reel3.add(image3BotAnim);
            images.add(image3Bot);
            image3BotAnim.start();
        }
    }


    public void clearImages(){
        for(ImageView image:images){
            image.setImageDrawable(null);
        }
    }

    public void resetReelActives(){
        reel1Active = true;
        reel2Active = true;
        reel3Active = true;
    }

    public int generateRandomDelay(){
        randomDelay = r.nextInt(4000) + 1000;
        return randomDelay;
    }

    public void setImagesReel1() {
//      Randomize the images.
        img1 = r.nextInt(5) + 1;
//        deHighLightHoldNudge();
//        Set first image
        if (reel1Active) {
            switch (img1) {
                case 1:
                    image1Top.setBackgroundResource(R.drawable.seven);
                    image1.setBackgroundResource(R.drawable.bar);
                    image1Bot.setBackgroundResource(R.drawable.bell);
                    break;
                case 2:
                    image1Top.setImageResource(R.drawable.bar);
                    image1.setImageResource(R.drawable.bell);
                    image1Bot.setImageResource(R.drawable.cherry);
                    break;
                case 3:
                    image1Top.setImageResource(R.drawable.bell);
                    image1.setImageResource(R.drawable.cherry);
                    image1Bot.setImageResource(R.drawable.grape);
                    break;
                case 4:
                    image1Top.setImageResource(R.drawable.cherry);
                    image1.setImageResource(R.drawable.grape);
                    image1Bot.setImageResource(R.drawable.orange);
                    break;
                case 5:
                    image1Top.setImageResource(R.drawable.grape);
                    image1.setImageResource(R.drawable.orange);
                    image1Bot.setImageResource(R.drawable.seven);
                    break;
                case 6:
                    image1Top.setImageResource(R.drawable.orange);
                    image1.setImageResource(R.drawable.seven);
                    image1Bot.setImageResource(R.drawable.bar);
                    break;
            }
        }
    }

    public void setImagesReel2() {
        img2 = r.nextInt(5) + 1;
//        deHighLightHoldNudge();
        //        Set second image
        if (reel2Active) {
            switch (img2) {
                case 1:
                    image2Top.setBackgroundResource(R.drawable.seven);
                    image2.setBackgroundResource(R.drawable.bar);
                    image2Bot.setBackgroundResource(R.drawable.bell);
                    break;
                case 2:
                    image2Top.setImageResource(R.drawable.bar);
                    image2.setImageResource(R.drawable.bell);
                    image2Bot.setImageResource(R.drawable.cherry);
                    break;
                case 3:
                    image2Top.setImageResource(R.drawable.bell);
                    image2.setImageResource(R.drawable.cherry);
                    image2Bot.setImageResource(R.drawable.grape);
                    break;
                case 4:
                    image2Top.setImageResource(R.drawable.cherry);
                    image2.setImageResource(R.drawable.grape);
                    image2Bot.setImageResource(R.drawable.orange);
                    break;
                case 5:
                    image2Top.setImageResource(R.drawable.grape);
                    image2.setImageResource(R.drawable.orange);
                    image2Bot.setImageResource(R.drawable.seven);
                    break;
                case 6:
                    image2Top.setImageResource(R.drawable.orange);
                    image2.setImageResource(R.drawable.seven);
                    image2Bot.setImageResource(R.drawable.bar);
                    break;
            }
        }
    }

    public void setImagesReel3(){
        img3 = r.nextInt(5) + 1;
//        deHighLightHoldNudge();
        //        Set third image
        if (reel3Active){
            switch (img3) {
                case 1:
                    image3Top.setBackgroundResource(R.drawable.seven);
                    image3.setBackgroundResource(R.drawable.bar);
                    image3Bot.setBackgroundResource(R.drawable.bell);
                    break;
                case 2:
                    image3Top.setImageResource(R.drawable.bar);
                    image3.setImageResource(R.drawable.bell);
                    image3Bot.setImageResource(R.drawable.cherry);
                    break;
                case 3:
                    image3Top.setImageResource(R.drawable.bell);
                    image3.setImageResource(R.drawable.cherry);
                    image3Bot.setImageResource(R.drawable.grape);
                    break;
                case 4:
                    image3Top.setImageResource(R.drawable.cherry);
                    image3.setImageResource(R.drawable.grape);
                    image3Bot.setImageResource(R.drawable.orange);
                    break;
                case 5:
                    image3Top.setImageResource(R.drawable.grape);
                    image3.setImageResource(R.drawable.orange);
                    image3Bot.setImageResource(R.drawable.seven);
                    break;
                case 6:
                    image3Top.setImageResource(R.drawable.orange);
                    image3.setImageResource(R.drawable.seven);
                    image3Bot.setImageResource(R.drawable.bar);
                    break;
            }
    }
    }

    public void getScore(){
        if(img1 >=1 && img2 >= 1 && img3 >= 1) {
//        three of the same images;
            if (img1 == img2 && img2 == img3) {
                Toast.makeText(this, "Jackpot!! Congratulations!!", Toast.LENGTH_LONG).show();
            }
//        two of the same images;
            if (img1 == img2 || img2 == img3 || img1 == img3) {
                highLightHoldNudge();
                Toast.makeText(this, "Consolation Prize!! Congrats!!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void highLightHoldNudge(){
        for(Button btn: buttons) {
//            btn = (Button) findViewById(R.id.button1Hold);
            Animation mAnimation = new AlphaAnimation(1, 0);
            mAnimation.setDuration(200);
            mAnimation.setInterpolator(new LinearInterpolator());
            mAnimation.setRepeatCount(Animation.INFINITE);
            mAnimation.setRepeatMode(Animation.REVERSE);
            btn.startAnimation(mAnimation);
        }
    }

    public void deHighLightHoldNudge() {
        for (Button btn : buttons) {
             btn.clearAnimation();
        }
    }

    public void getHold(View view){
        buttontmp = (Button)findViewById(view.getId());
        switch (view.getId()) {
            case R.id.button1Hold:
                reel1Active = false;
//                buttontmp.clearAnimation();
                break;
            case R.id.button2Hold:
                reel2Active = false;
//                buttontmp.clearAnimation();
                break;
            case R.id.button3Hold:
                reel3Active = false;
//                buttontmp.clearAnimation();
                break;
        }
    }


    }



