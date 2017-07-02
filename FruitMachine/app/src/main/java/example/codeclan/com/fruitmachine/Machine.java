package example.codeclan.com.fruitmachine;

import java.util.ArrayList;
import java.util.Scanner;

import static android.R.attr.value;

/**
 * Created by user on 30/06/2017.
 */

public class Machine {
    private ArrayList<Reel> reels;
    private double money;
    private double maxPrize;
    private double credits;
    private Ui ui;
    private Scanner sc;
    private char selection;
    private User user;

    public Machine(double money, ArrayList<Reel> reels, double maxPrize, Ui ui, User user){
        this.money = money;
        this.reels = reels;
        this.maxPrize = maxPrize;
        this.credits = 0;
        this.ui = new Ui();
        sc = new Scanner(System.in);
        this.user = new User("Player", 100);
    }

    public ArrayList<Reel> getReels() {
        System.out.println(reels);
        return reels;
    }

    public Reel getReel(int index){
        Reel reel = this.reels.get(index);
        return reel;
    }

    public double getMoney() {
        return this.money;
    }

    public double getCredits(){
        return this.credits;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void insertCoin(){
        ui.insertCoin();
        int selection = sc.nextInt();
        for(int i = 0; i < selection; i++){
            this.money += 1;
            this.credits += 1;
            this.user.spendMoney(-1);
        }
        pressPlay();
    }

    public void pressPlay(){
        ui.pressPlay();
        char c = sc.next().charAt(0);
        if(c == 'p'){
            play();
        }
    }

    public double payOut(String type){
        if(type == "star"){
            this.money -= this.maxPrize;
            return this.maxPrize;
        }
        if(type == "tier2"){
            this.money -= 50;
            return 50;
        }
        else{
            this.money -= 20;
            return 20;
        }
    }



    public void play() {
        if (this.credits > 1) {
            for (Reel reel : reels) {
                reel.spin();
            }

            this.credits -= 1;
            ui.displayReels(reels);
            ui.showCredits(this.credits);
            pressPlay();
        } else {
            insertCoin();
        }
    }


    public boolean checkJackpot() {
        int counter = 0;
        String checkValue = "StarPrize";
       for(Reel reel: reels){
           if(reel.getSymbolAtCurrentPosition().equals(checkValue)){
               counter += 1;
           }
       }
       if(counter == 3){
           return true;
       }
       else{
           return false;
       }
    }



    public void checkWin(){

    }
}
