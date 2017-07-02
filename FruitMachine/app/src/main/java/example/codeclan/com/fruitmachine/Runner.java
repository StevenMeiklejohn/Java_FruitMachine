package example.codeclan.com.fruitmachine;

import java.util.ArrayList;

/**
 * Created by user on 30/06/2017.
 */

public class Runner {

    Ui ui;
    Machine machine;
    User user;
    ArrayList<Reel> reels;

    public static void main(String[] args) {

        Ui ui = new Ui();
        User user = new User("Steve", 100);
        Reel reel1 = new Reel();
        Reel reel2 = new Reel();
        Reel reel3 = new Reel();
        ArrayList<Reel> reels = new ArrayList<Reel>();
        reels.add(reel1);
        reels.add(reel2);
        reels.add(reel3);
        Machine machine = new Machine(10000, reels, 1000, ui, user);
        machine.insertCoin();
        machine.play();

    }
}
