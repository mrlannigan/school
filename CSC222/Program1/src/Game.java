import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Available difficulties
     */
    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    };

    /**
     * Marker to describe who won the game or if it's still ongoing
     */
    public enum Winner {
        USER,
        CPU,
        NONE
    }

    /**
     * Maintain a class instance of Scanner
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * Do the same thing for the random number generator
     */
    private final Random random = new Random();

    /**
     * Current game's random number target
     */
    private int target;

    /**
     * Game's target lower bound (inclusive)
     */
    private final int minTarget;

    /**
     * Game's target upper bound (inclusive)
     */
    private final int maxTarget;

    /**
     * Selected difficulty for current game
     */
    private Difficulty difficulty;

    /**
     * Current game's winner if any
     */
    private Winner winner = Winner.NONE;

    /**
     * Game constructor to assign target number and bounds
     * @param minTarget lower target bound
     * @param maxTarget upper target bound
     */
    Game(int minTarget, int maxTarget) {
        setTarget(random.nextInt(minTarget, maxTarget));
        this.minTarget = minTarget;
        this.maxTarget = maxTarget;
    }

    public static void main(String[] args) {
        // Basic scoreboard
        int userScore = 0;
        int cpuScore = 0;

        // loop controller
        boolean shouldPlayAgain;

        // Main program loop that runs N times games
        do {
            // create game with a guess range of 1 to 100 (inclusive)
            Game game = new Game(1, 100);

            // run that game's game loop
            game.run();

            // identify who won the game. The game loop will not exit until a winner is found.
            switch (game.getWinner()) {
                case USER:
                    userScore += 1;
                    break;
                case CPU:
                    cpuScore += 1;
                    break;
            }

            // show the scoreboard
            showScoreboard(userScore, cpuScore);

            // query the user if they want to play again
            shouldPlayAgain = game.askToPlayAgain();
        } while (shouldPlayAgain);
    }

    public static void showScoreboard(int userScore, int cpuScore) {
        System.out.println("************************ SCOREBOARD ************************");
        System.out.printf("Your score: %dpts\n", userScore);
        System.out.printf("CPU score: %dpts\n", cpuScore);
        System.out.println("************************************************************");
    }

    /**
     * Ask the user if they want to begin another game
     */
    public boolean askToPlayAgain() {
        System.out.print("Would you like to play again? (y)es or (n)o ");
        // get the next character from the input
        char selection = input.next().charAt(0);

        if (selection == 'y') {
            return true;
        }

        System.out.println("Thank you for playing!");

        return false;
    }

    public void run() {
        // Ask for the desired difficulty every game
        askUserForDifficulty();

        // loop until we have a winner
        while (getWinner() == Winner.NONE) {
            // get the user's guess
            int userGuess = askUserForGuess();

            // load the target locally
            int target = getTarget();

            // User guessed correct, set winner
            if (userGuess == target) {
                System.out.println("Correct!");
                setWinner(Winner.USER);
                continue;
            } else if (userGuess < target) {
                System.out.println("Too Low");
            } else {
                System.out.println("Too High");
            }

            // Start CPU Guesses
            for (int i = 0; i < getCPUGuessCount(); i += 1) {
                // cpu guess
                int currentCPUGuess = random.nextInt(minTarget, maxTarget);

                System.out.printf("CPU Guess: %d\t.....", currentCPUGuess);

                if (currentCPUGuess == target) {
                    // CPU guess correct, set the winner and break out of the for loop
                    setWinner(Winner.CPU);
                    System.out.println("\tCorrect!");
                    break;
                } else {
                    // CPU guess was incorrect, continue the for loop
                    System.out.println("\tIncorrect");
                }
            }
        }
    }

    /**
     * Ask the user for the difficulty of the game
     */
    public void askUserForDifficulty() {
        System.out.println("************************ DIFFICULTY ************************");
        System.out.println("Pleb (5 guesses) .............................. press 1");
        System.out.println("I like brisk walks on the beach (10 guesses) .. press 2");
        System.out.println("I'm basically John Wick (20 guesses) .......... press 3");
        System.out.println("************************************************************");
        System.out.print("Choose your path: ");
        int difficultyInput = input.nextInt();

        // Convert user input into a proper difficulty
        switch (difficultyInput) {
            case 1:
                setDifficulty(Difficulty.EASY);
                break;
            case 2:
                setDifficulty(Difficulty.MEDIUM);
                break;
            case 3:
                setDifficulty(Difficulty.HARD);
                break;
            default:
                System.out.println();
                System.out.println("  Invalid difficulty choice; Defaulting to Pleb and maybe on");
                System.out.println("  your next game you'll get this simply menu correct. You can");
                System.out.println("  count to 3 right?");
                setDifficulty(Difficulty.EASY);
        }

        System.out.println("************************************************************");
    }

    /**
     * Ask the user for a guess into they select an int within the bounds of the game
     */
    public int askUserForGuess() {
        System.out.printf("Pick a number between %d-%d: ", minTarget, maxTarget);
        int userGuess = input.nextInt();

        if (userGuess < minTarget || userGuess > maxTarget) {
            System.out.println("Invalid number, try again.");
            // recursive ask
            return askUserForGuess();
        }

        return userGuess;
    }

    public int getCPUGuessCount() {
        // This is a switch expression which allows us to return
        // a value from the switch statement. This is the same as a if-else-else
        // set of statements.
        return switch (getDifficulty()) {
            case HARD -> 20;
            case MEDIUM -> 10;
            default -> 5;
        };
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}
