package example.codeclan.com.fruitmachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 30/06/2017.
 */

public class Ui {

    private Scanner sc;

    public Ui(){
        sc = new Scanner(System.in);
    }

    public void displayReels(ArrayList<Reel> reels){
        StringBuilder outPutString = new StringBuilder();
        for(Reel reel: reels) {
            outPutString.append(reel.getSymbolAtCurrentPosition());
            outPutString.append(" ");
//            System.out.println(reel.getSymbolAtCurrentPosition());
        }
        System.out.println(outPutString);
    }


    public void insertCoin(){
//        showCredits();
        System.out.println("Please insert coin");
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("To play, input the number of shmeckles you would like to piss up a wall.");
        System.out.println("===================");
        System.out.println("Press '0 to go and buy a Curly Wurly instead.");
        System.out.println("(Don't press '0'. Come on, one more...This could be your lucky day)");
    }

    public void pressPlay(){
        System.out.println("Press 'p' to take a spin and try your luck");
    }

    public void showCredits(double credits){
        System.out.println(credits + " Credits remaining:");
    }

    public void jackpot(){
        System.out.println("Congrats!!!! You have won the jackpot!!!");
        System.out.println("Feel free to fire it all back in!");
    }

}

