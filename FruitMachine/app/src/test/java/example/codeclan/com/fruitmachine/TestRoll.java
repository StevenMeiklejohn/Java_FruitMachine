package example.codeclan.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;


public class TestRoll {

    private Reel reel;


    @Before
    public void before() {
        reel = new Reel();
//        reel.populateReel();
        reel.spin();

    }

    @Test
    public void testReelCanBePopulated() {
        assertEquals(10, reel.getReel().size());
    }

    @Test
    public void testReelContents(){
        assertEquals("Cherry", reel.getReel().get(0));
    }


    @Test
    public void testSpinReelReturnSymbol() {
        Reel spySymbols = Mockito.spy(reel);
        Mockito.when(spySymbols.spin()).thenReturn("Cherry");
        assertEquals("Cherry", spySymbols.getReel().get(0));
    }

    @Test
    public void testReelCanNudgeUp(){
        reel.setPosition(5);
        reel.nudgeUp();
        assertEquals("Grapes", reel.getSymbolAtCurrentPosition());
    }

    @Test
    public void testReelCanNudgeDown(){
        reel.setPosition(2);
        reel.nudgeDown();
        assertEquals("Pear", reel.getSymbolAtCurrentPosition());
    }

//    CHERRY("Cherry"),
//    PEAR("Pear"),
//    BANANA("Banana"),
//    BELL("Bell"),
//    SEVEN("Seven"),
//    WATERMELON("Watermelon"),
//    GRAPES("Grapes"),
//    LEMON("Lemon"),
//    STARPRIZE("Star Prize"),
//    HORSESHOE("Horseshoe");


}

