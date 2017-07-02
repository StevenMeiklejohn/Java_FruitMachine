package example.codeclan.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 30/06/2017.
 */

public class TestMachine {

    private Machine machine;
    private Reel reel1;
    private Reel reel2;
    private Reel reel3;
    private ArrayList<Reel> reels;
    private Ui ui;

    @Before
    public void before() {
        reel1 = new Reel();
        reel2 = new Reel();
        reel2 = new Reel();
        reels = new ArrayList<>();
        reels.add(reel1);
        reels.add(reel2);
        reels.add(reel3);
        ui = new Ui();
        machine = new Machine(10000, reels, 1000, ui);
    }

    @Test
    public void testMachineHasReels() {
        assertEquals(3, machine.getReels().size());
    }

    @Test
    public void machineCanPayout(){
        assertEquals(1000.0, machine.payOut("star"), 0.1);
        assertEquals(9000.0, machine.getMoney());
    }

    @Test
    public void machineCanAcceptMoney(){
        machine.insertCoin(5);
        assertEquals(10005, machine.getMoney(), 0.1);
    }

    @Test
    public void machineHasCredits(){
        machine.insertCoin(5);
        assertEquals(5, machine.getCredits(), 0.1);
    }

    @Test
    public void machineCanPlay(){

    }

}
