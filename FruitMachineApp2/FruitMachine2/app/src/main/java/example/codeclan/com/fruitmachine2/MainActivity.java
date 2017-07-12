package example.codeclan.com.fruitmachine2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    Button b_roll;
    ImageView image1, image2, image3;
    Random r;
    int img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();
        b_roll = (Button) findViewById(R.id.b_roll);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clear image views
                image1.setImageDrawable(null);
                image2.setImageDrawable(null);
                image3.setImageDrawable(null);

//                animate first image
                image1.setBackgroundResource(R.drawable.anim);
                final AnimationDrawable image1anim = (AnimationDrawable) image1.getBackground();
                image1anim.start();

//                animate second image
                image2.setBackgroundResource(R.drawable.anim);
                final AnimationDrawable image2anim = (AnimationDrawable) image2.getBackground();
                image2anim.start();

//                animate third image
                image3.setBackgroundResource(R.drawable.anim);
                final AnimationDrawable image3anim = (AnimationDrawable) image3.getBackground();
                image3anim.start();

//                stop the animation and apply the images
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image1anim.stop();
                        image2anim.stop();
                        image3anim.stop();
                        setImages();
                        getScore();

                    }
                }, 500);
            }
        });
    }

    public void setImages(){
//      Randomize the images.
        img1 = r.nextInt(5) + 1;
        img2 = r.nextInt(5) + 1;
        img3 = r.nextInt(5) + 1;

//        Set first image
        switch (img1) {
            case 1:
                image1.setBackgroundResource(R.drawable.bar);
                break;
            case 2:
                image1.setImageResource(R.drawable.bell);
                break;
            case 3:
                image1.setImageResource(R.drawable.cherry);
                break;
            case 4:
                image1.setImageResource(R.drawable.grape);
                break;
            case 5:
                image1.setImageResource(R.drawable.orange);
                break;
            case 6:
                image1.setImageResource(R.drawable.seven);
                break;
        }

        //        Set second image
        switch (img2) {
            case 1:
                image2.setBackgroundResource(R.drawable.bar);
                break;
            case 2:
                image2.setImageResource(R.drawable.bell);
                break;
            case 3:
                image2.setImageResource(R.drawable.cherry);
                break;
            case 4:
                image2.setImageResource(R.drawable.grape);
                break;
            case 5:
                image2.setImageResource(R.drawable.orange);
                break;
            case 6:
                image2.setImageResource(R.drawable.seven);
                break;
        }

        //        Set third image
        switch (img3) {
            case 1:
                image3.setBackgroundResource(R.drawable.bar);
                break;
            case 2:
                image3.setImageResource(R.drawable.bell);
                break;
            case 3:
                image3.setImageResource(R.drawable.cherry);
                break;
            case 4:
                image3.setImageResource(R.drawable.grape);
                break;
            case 5:
                image3.setImageResource(R.drawable.orange);
                break;
            case 6:
                image3.setImageResource(R.drawable.seven);
                break;
        }

    }

    public void getScore(){
//        three of the same images;
        if(img1 == img2 && img2 == img3){
            Toast.makeText(this, "Jackpot!! Congratulations!!", Toast.LENGTH_LONG).show();
        }
//        three of the same images;
        if(img1 == img2 || img2 == img3 || img1 == img3){
            Toast.makeText(this, "Consolation Prize!! Congrats!!", Toast.LENGTH_LONG).show();
        }
    }


}
