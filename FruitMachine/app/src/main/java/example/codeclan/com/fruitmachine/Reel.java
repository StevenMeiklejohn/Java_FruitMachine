package example.codeclan.com.fruitmachine;

import java.util.ArrayList;
import java.util.Random;

import static android.media.CamcorderProfile.get;

/**
 * Created by user on 30/06/2017.
 */

public class Reel {

    private ArrayList<String> reel;
    private boolean hold;
    int position = 0;

    public Reel(){
        this.reel = new ArrayList<String>();
        populateReel();
//        this.hold = null;
    }

    public ArrayList<String> getReel(){
        return this.reel;

    }

    public void setHold(){
        this.hold = true;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void populateReel(){
        for(Symbol symbol: Symbol.values()){
          this.reel.add(symbol.getSymbol());
        }
//        System.out.println(reel);
    }


    public String spin(){
        if(!hold) {
            Random rand = new Random();
            int listSize = this.reel.size();
            int index = rand.nextInt(listSize);
            String symbol = this.reel.get(index);
            this.position = index;
//            System.out.println(symbol);
            return symbol;
        }else{
            return getSymbolAtCurrentPosition();
        }
    }

    public String getSymbolAtIndex(int index) {
        return this.reel.get(index);
    }

    public String getSymbolAtCurrentPosition() {
        return this.reel.get(this.position);
    }

    public String nudgeUp(){
        this.position += 1;
        return this.reel.get(this.position);
    }

    public String nudgeDown(){
        this.position -= 1;
        return this.reel.get(this.position);
    }





}
