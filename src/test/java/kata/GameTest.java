package kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Game g;

    @Before
    public void initGame() {
        g = new Game();
    }

    private void rollMany(int pins, int rolls) {
        for (int i = 0; i < rolls; i++) {
            g.roll(pins);
        }

    }

    private void rollStrike() {
        g.roll(10);
    }

    @Test
    public void canRollGutterGame() {
        rollMany(0, 20);
        assertEquals (0, g.score());
    }

    @Test
    public void canRollAllOnes() {
        rollMany(1, 20);
        assertEquals (20, g.score());
    }

    @Test
    public void canRollOneSpare() {
        g.roll(5);
        g.roll(5);
        g.roll(3);
        rollMany(0, 17);
        assertEquals(16, g.score());
    }

    @Test
    public void canRollOneStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(0, 16);
        assertEquals(24, g.score());
    }

    @Test
    public void canRollPerfectGame() {
        rollMany(10, 12);
        assertEquals(300, g.score());
    }
}
