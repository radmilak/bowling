/**
 * User interface for BowlingGame that accepts command line arguments and passes them on
 */
public class BowlingScorer {

    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("--help") || args[0].equals("-h")) {
            System.out.println("The program accepts a sequence of valid rolls divided by space and returns a score for " +
                    "that sequence. Example: " +
                    "java BowlingScorer 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 1 ");
            return;
        }
        BowlingGame game = new BowlingGame();
        for (String arg: args) {
            int rollValue = Integer.parseInt(arg);
            game.roll(rollValue);
        }
        int score = game.getScore();
        System.out.println("Score is: " + score);
    }
}
