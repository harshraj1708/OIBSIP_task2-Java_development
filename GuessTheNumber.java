import java.util.Scanner;
import java.util.Random;

// GuessingGame class
class GuessingGame{
    int randomnumber;
    int userguess;
    int noOfGuesses = 0;

    // generating random number in default constructor
    GuessingGame() {
        Random random = new Random();
        this.randomnumber = random.nextInt(100) + 1;
    }


    // method to take user guesses
    public boolean takeUserGuess() {
        if ( noOfGuesses < 10 ) {
            System.out.print("Guess the number : ");
            this.userguess = GuessTheNumber.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        }
        else {
            System.out.println("Number of attempts finished...Better luck next time\n");
            return true;
        }
    }


    //method to check user guess status
    public boolean CorrectGuess() {

        if ( randomnumber == userguess ) {
            System.out.println("Congratulations, you guess the number " + randomnumber +
                    " in " + noOfGuesses + " guesses");
            switch(noOfGuesses) {
                case 1:
                    System.out.println("Your score is 100");
                    break;
                case 2:
                    System.out.println("Your score is 90");
                    break;
                case 3:
                    System.out.println("Your score is 80");
                    break;
                case 4:
                    System.out.println("Your score is 70");
                    break;
                case 5:
                    System.out.println("Your score is 60");
                    break;
                case 6:
                    System.out.println("Your score is 50");
                    break;
                case 7:
                    System.out.println("Your score is 40");
                    break;
                case 8:
                    System.out.println("Your score is 30");
                    break;
                case 9:
                    System.out.println("Your score is 20");
                    break;
                case 10:
                    System.out.println("Your score is 10");
                    break;
            }
            System.out.println();
            return true;
        }
        else if ( noOfGuesses < 10 && userguess > randomnumber ) {
            if ( userguess - randomnumber > 10 ) {
                System.out.println("Way more Longer than the number");
            }
            else {
                System.out.println("Just a little Higher than the number");
            }
        }
        else if ( noOfGuesses < 10 && userguess < randomnumber ) {
            if ( randomnumber - userguess > 10 ) {
                System.out.println("Way more shorter than the number");
            }
            else {
                System.out.println("Just a little lower than the number");
            }
        }
        return false;
    }
}

// main class
class GuessTheNumber {

    // static method to take integer input without any limit and exception error
    // exception handling and input limit handling
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while ( !flag ) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if ( flag && input > limit || input < 1 ) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e ) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }

    // main method
    public static void main(String[] args) {

        // input for start the game
        System.out.println("1.Let's Launch into the Game \n2. Exit");
        System.out.print("Enter your selected number : ");
        int choice = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRound = 0;

        if ( choice == 1 ) {

            // to check next round is there or not
            while ( nextRound == 1 ) {
                // creating object of Game class
                GuessingGame game = new GuessingGame();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nLet's begin the Round " + ++noOfRound );

                // to check correct guess and limit cross
                while ( !isMatched && !isLimitCross) {
                    isLimitCross = game.takeUserGuess();
                    isMatched = game.CorrectGuess();
                }
                // input for next round
                System.out.println("1. Next Round \n2. Exit");
                System.out.println("Enter your choice : ");
                nextRound = takeIntegerInput(2);
                if ( nextRound != 1 ) {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}