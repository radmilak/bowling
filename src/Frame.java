/**
 * This class represents a frame and holds information about pins that were knocked down
 *
 * @author Radmila Kompova (radka@sjux.net)
 */
public class Frame {

    private static final int NO_VALUE_ASSIGNED = -1;
    private int knockedDownInFirstRoll = NO_VALUE_ASSIGNED;
    private int knockedDownInSecondRoll = 0;
    private boolean isCompleted = false;

    public boolean isStrike() {
        return (knockedDownInFirstRoll == Constants.NUM_OF_PINS);
    }

    public boolean isSpare() {
        return !isStrike() && (knockedDownInFirstRoll + knockedDownInSecondRoll == Constants.NUM_OF_PINS);
    }

    public void setKnockedPins(int knockedPins){
        //if it is a new frame
        if (knockedDownInFirstRoll == NO_VALUE_ASSIGNED){
            knockedDownInFirstRoll = knockedPins;
            if (isStrike()) {
                isCompleted = true;
            }
        } else {
            knockedDownInSecondRoll = knockedPins;
            isCompleted = true;
        }
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public int getKnockedPins() {
        return knockedDownInFirstRoll + knockedDownInSecondRoll;
    }

    public int getKnockedPinsInFirstRoll() {
        return knockedDownInFirstRoll;
    }
}
