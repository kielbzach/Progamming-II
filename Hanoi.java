/*
 *  This is a simple solution for the Tower(s) of Hanoi algorithm. There are SEVERAL solutions available; 
 *   many, if not most, are more elegant than this. 
 *  This specific solution sets the number of 'towers' to three - users cannot change this. Many other 
 *   solutions will allow the user to choose the number of towers as well as the number of discs. Those
 *   solutions are somewhat more complicated.
 * 
 *  https://www.mathsisfun.com/games/towerofhanoi.html
 *  The above website contains a nice animation of the Tower(s) of Hanoi problem.
 * 
 * 
 */
import java.util.Scanner;                                      // for accepting input from user

public class Hanoi 
{
    /*
     *  The main method is carrying all the weight. Since this is a very simple solution, 
     *    we'll permit the poor coding structure...
     * 
     *  NOTE: 'Towers' are designated as "Origin", "Holding", and "Target" -- you could use 1, 2, and 3 instead, 
     *        although I recommend rendering the numbers as String values ("one","two", "three").
     * 
     *  The starting point of the game has all the discs on tower "Origin"; the goal will be to move them all to 
     *        tower "Target". The rules are:
     *              1. Only onde disc may be moved at a "turn".
     *              2. A larger disc cannot be placed on top of a smaller disc.
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner( System.in );           // instantiate Scanner; tie to keyboard
        int nbrDiscs;
        
        String origin  = "Origin";
        String holding = "Holding";
        String target  = "Target";
        
        System.out.printf( "How many discs to start?  " );  // Prompt for use input 
        nbrDiscs = input.nextInt( );                        // Store user input
                                                            
        System.out.printf( "\tYou've chosen %d discs.%n", nbrDiscs );  // Mirror input back to user

        System.out.printf( "\t\tBeginning play....%n" );    // Let user know that processing has begun.
        
        /*
         *  Initiate the RECURSION, passing
         *     * Current number of discs to be moved
         *     * Identifier for "origin" tower for THIS MOVE
         *     * Identifier for "holding" tower for THIS MOVE
         *     * Identifier for "target" tower for THIS MOVE
         */
        playHanoi ( nbrDiscs,
                    origin, 
                    holding, 
                    target );
        
    }  // end main

    /*
     *  This is the RECURSIVE METHOD.
     * 
     *  It will effectively move one disc at a time, and 'return' the new tower structure.
     *  Output will show the user the progress (and number) of recursive calls needed to 
     *   complete the solution.
     */
    private static void playHanoi(int    discs,             // number of discs left to be transferred
                                  String from,              // The disc's "origin" tower for this method execution
                                  String parking,           // The "holding" tower for this method execution
                                  String to)                // The disc's "target" tower for this method execution
    {
        if (discs == 0)                                     // There are no more discs to move = BASE CASE for recusion
            return;                                         // EXIT recursion
        
        if (discs > 0)      
        {// Otherwise, continue w/ a recursive call
          playHanoi( discs - 1,                              // Decrement the total number of discs to move
                     from,                                    
                     to,                                     // NOTE THAT THE ORDER OF TOWER VALUES HAS CHANGED!!
                     parking );
        }  // end if (no else branch here
        
        // Let the user know that another move will take place...
        System.out.printf("%n\t\t\tMove one disk from tower %s to tower %s ", from, to);
        
        playHanoi( discs - 1,                                      
                   parking, 
                   from,                                     // NOTE THAT THE ORDER OF TOWER VALUES HAS CHANGED (AGAIN)!!
                   to);
    } // end playHanoi

}  // end Hanoi