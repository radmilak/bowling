import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a bowling game, accepts a sequence of rolls and computes the final score
 *
 * @author Radmila Kompova (radka@sjux.net)
 */
public class BowlingGame {
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame = null;

    /**
     * Save knocked pins in one roll
     * @param knockedPins
     */
    public void roll(int knockedPins) {
        if (currentFrame == null || currentFrame.isCompleted()) {
            currentFrame = new Frame();
            frames.add(currentFrame);
        }
        currentFrame.setKnockedPins(knockedPins);
    }

    /**
     * Get score of a valid sequence of rolls in bowling
     * @returnscore for the game
     */
    public int getScore() {
        int score = 0;
        for (int i = 0; i < Constants.NUM_OF_ROUNDS; i++) {
            Frame frame = frames.get(i);
            //if frame is strike, add values of the next two rolls
            if (frame.isStrike()) {
                Frame nextFrame = frames.get(i+1);
                score += Constants.NUM_OF_PINS + frames.get(i+1).getKnockedPins();
                //if the frame was strike, it only counts as one roll, so have to add value of the next one as well
                if (nextFrame.isStrike()) {
                    score += frames.get(i+2).getKnockedPinsInFirstRoll();
                }

            }
            //if frame is spare, add value of the next roll
            else if (frame.isSpare()) {
                score += Constants.NUM_OF_PINS + frames.get(i+1).getKnockedPinsInFirstRoll();
            } else {
                score += frame.getKnockedPins();
            }
        }

        return score;
    }
}
