import java.util.Scanner;
public class Blackjack
{
    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);
        P1Random Player = new P1Random();
        int total = 0;
        int win = 0;
        int tie = 0;
        int dWin = 0;
        int gamesPlayed = 0;
        int nextMove = 1;
        int firstNumber;
        //create new instances of the needed classes and initializing variables
        System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
        while(nextMove != 4)
        {
            while (nextMove == 1)
            {
                firstNumber = Player.nextInt(13) + 1;
                int cardValue = firstNumber;
                total += cNum(cardValue);
                blackJack(firstNumber, total);
                //draws a card, gets value of card and adds that total and prints it out for player
                if (total > 21)
                {
                    dWin++;
                    System.out.println("You exceeded 21! You lose.");
                    total = 0;
                    gamesPlayed++;
                    System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
                    //once the hand is over 21 player loses and a new game starts
                }
                else if(total == 21)
                {
                    System.out.println("BLACKJACK! You win!");
                    win++;
                    total = 0;
                    gamesPlayed++;
                    System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
                    //if total equals 21 player wins and new game starts
                }
                else
                {
                    System.out.println("1. Get another card" + "\n" + "2. Hold hand" + "\n" + "3. Print statistics" + "\n" + "4. Exit" + "\n" + "\n" + "Choose an option:");
                    nextMove = user.nextInt();
                    //prints out the options and asks for player input
                }
                //game starts and takes user input to play blackjack
            }
            if (nextMove == 2)
            {
                int dNum = Player.nextInt(11) + 16;
                System.out.println("Dealer's hand: " + dNum);
                System.out.println("Your hand is: " + total + "\n");
                //dealer draws a card and system prints out what dealers hand is vs the players
                if (dNum > 21)
                {
                    System.out.println("You win!" + "\n");
                    win++;
                    nextMove = 1;
                    gamesPlayed++;
                    System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
                    //if dealer hand exceeds 21 player wins and new game starts
                }
                else if (dNum == total)
                {
                    System.out.println("It's a tie! No one wins!");
                    tie++;
                    nextMove=1;
                    gamesPlayed++;
                    System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
                    //if dealer hand is equal to player hand game ends in a tie and a new game starts
                }
                else if (dNum > total)
                {
                    dWin++;
                    System.out.println("Dealer wins!");
                    nextMove = 1;
                    gamesPlayed++;
                    System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
                    //if dealer hand is greater than player hand player loses and a new game starts
                }
                else if (dNum < total)
                {
                    win++;
                    System.out.println("You Win!");
                    gamesPlayed++;
                    System.out.println("START GAME #" + (gamesPlayed + 1) + "\n");
                    //if dealer hand is less than player hand player wins and a new game starts
                }
                total = 0;
                nextMove=1;
                //user holds their card and dealer goes and depending on what dealer draws player will either win, lose, or draw
            }
            else if (nextMove == 3)
            {
                System.out.println("Number of Player wins: " + win + "\n" + "Number of Dealer wins: " + dWin + "\n" + "Number of tie games: "+ tie + "\n" + "Total # of games played is: " + (gamesPlayed) + "\n" + "Percentage of Player wins: " + ((double)win/gamesPlayed*100)+ "%");
                System.out.println("1. Get another card" + "\n" + "2. Hold hand" + "\n" + "3. Print statistics" + "\n" + "4. Exit" + "\n" + "\n" + "Choose an option:");
                nextMove = user.nextInt();
                //system prints out stats of the game and asks for player's next input

            }
            else if (nextMove == 4)
            {
                break;
                //ends the game
            }
            else
            {
                System.out.println("Invalid input!" + "\n" + "Please enter an integer value between 1 and 4.");
                System.out.println("1. Get another card" + "\n" + "2. Hold hand" + "\n" + "3. Print statistics" + "\n" + "4. Exit" + "\n" + "\n" + "Choose an option:");
                nextMove = user.nextInt();
                //player entered something that was not 1-4 and system asks players to select an option between 1-4
            }
        }

    }
    static String card(int num)
    {
        String whatCard="";
        if(num==1)
            whatCard="ACE";
        if(num>1&&num<11)
            whatCard=(""+num);
        if(num==11)
            whatCard="JACK";
        if(num==12)
            whatCard="QUEEN";
        if(num==13)
            whatCard="KING";
        return whatCard;
        //print the value or name of the "card" that was drawn
    }
    static int blackJack(int firstNumber, int total)
    {
        System.out.println("Your card is a " + card(firstNumber) + "!");
        System.out.println("Your hand is: " + total + "\n");
        return firstNumber;
        //tells player what card they drew and the total in their hand
    }
    static int cNum(int cardValue)
    {
        if (cardValue>= 11)
        {
            cardValue = 10;
        }
        return cardValue;
        //change any random that was drawn 11 and above to equal 10
    }

}
