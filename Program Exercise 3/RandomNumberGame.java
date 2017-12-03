/*
 * Program: Number Guessing Game
 * File: RandomNumberGame.java
 * Summary: Simple number guessing game
 * Author: Vincent Christaldi
 * Date: 11/29/2017
*/
package randomnumbergame;

//import library file
import java.util.Scanner;

public class RandomNumberGame 
{

    public static void main(String[] args)
    {
        //Variables used in game
        int numOfTries, number, rangeMin, rangeMax;
        
        //set initial values
        rangeMin = 1;
        rangeMax = 10000;
        numOfTries = 0;
        
        //create input
        Scanner Guess = new Scanner(System.in);
         //set number to guess
        number = (int)(Math.random() * 9999 + 1);
    
        //initial prompt to user
        System.out.println("Welcome to the Number Guessing Game. I have "+
                 " selected a number between 1 and 10000. Can you guess what it is?");
        System.out.print("Enter your first guess: ");
        int userGuess = Guess.nextInt();
        
        //Begin game loop
        while (userGuess != number)
        {
            //print that it was a wrong guess
            System.out.println("I am sorry, that is the wrong answer.");
            
            //check if guess is lower or higher
            if (userGuess < number)
            {
               //guess is lower. Adujust range for user 
               rangeMin = userGuess;
               System.out.println("Your guess was too low. New range is " +
                       rangeMin + " to " + rangeMax + ". Please try again:");
            }
            else
            {
                //guess was too high. Adjust range for user
                rangeMax = userGuess;
                System.out.println("Your guess was too high. New range is " +
                       rangeMin + " to " + rangeMax + ". Please try again:");
            }
            //increment number of tries
            ++numOfTries;
            //get next try
            userGuess = Guess.nextInt();
        }
        
        //Prompt user on success
        System.out.println("Congratulations!! You figured it out. It took you " +
                numOfTries + " tries to get the number correct!!");
}
       
    }
        
