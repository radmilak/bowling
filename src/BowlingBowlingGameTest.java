import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing scoring of a bowling game
 *
 * @author Radmila Kompova (radka@sjux.net)
 */
public class BowlingBowlingGameTest {

    private BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void allMiss() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS; i++) {
            game.roll(0);
            game.roll(0);
        }
        Assert.assertEquals(0, game.getScore());
    }

    @Test
    public void noStrikeNoSpareNoMiss() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS; i++) {
            game.roll(5);
            game.roll(1);
        }
        Assert.assertEquals(60, game.getScore());
    }

    @Test
    public void noStrikeNoSpareWithMiss() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS; i++) {
            game.roll(5);
            game.roll(0);
        }
        Assert.assertEquals(50, game.getScore());
    }

    @Test
    public void allStrikes() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS; i++) {
            game.roll(10);
        }
        //bonus throws
        game.roll(10);
        game.roll(10);

        Assert.assertEquals(300, game.getScore());
    }

    @Test
    public void allSpares() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS; i++) {
            game.roll(5);
            game.roll(5);
        }
        //bonus throw
        game.roll(5);

        Assert.assertEquals(150, game.getScore());
    }

    @Test
    public void spareInFirstFrame() {
        game.roll(1);
        game.roll(9);

        for (int i = 0; i < Constants.NUM_OF_ROUNDS-1; i++) {
            game.roll(5);
            game.roll(0);
        }

        Assert.assertEquals(60, game.getScore());
    }

    @Test
    public void spareInLastFrame() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS-1; i++) {
            game.roll(5);
            game.roll(0);
        }
        //last frame
        game.roll(5);
        game.roll(5);
        //bonus throw
        game.roll(1);

        Assert.assertEquals(56, game.getScore());
    }

    @Test
    public void strikeInFirstFrame() {
        game.roll(10);

        for (int i = 0; i < Constants.NUM_OF_ROUNDS-1; i++) {
            game.roll(5);
            game.roll(1);
        }

        Assert.assertEquals(70, game.getScore());
    }

    @Test
    public void strikeInLastFrame() {
        for (int i = 0; i < Constants.NUM_OF_ROUNDS-1; i++) {
            game.roll(5);
            game.roll(1);
        }
        //last frame
        game.roll(10);
        //bonus throws
        game.roll(1);
        game.roll(1);

        Assert.assertEquals(66, game.getScore());
    }
}
