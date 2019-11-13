/*
 *   Calculate the exponential value of a base number, using keyboard input for both base and power values
 * 
 *   Complete the calculation using iteration
 * 
 *  (c) 2019, Terri Davis
 * 
 */

import java.util.Scanner;                                               // facilitate retrieving keyboard input

public class Power_byIteration
{
   // Get user input and calculate results
   /************************************************************
   *   Method main
   *       Retrieve user input from keyboard
   *       Makes call to method integerPower
   ***********************************************************/ 
  public static void main( String args[] )
   {
      Scanner input = new Scanner( System.in );
      
      System.out.print( "Enter base as an integer value : " );          // must be integer value
      int base = input.nextInt();                                       // get base value from user

      System.out.print( "Enter exponent as an integer value: " );       // must be integer value
      int exponent = input.nextInt();                                   // get exponent from user

                                                                        // raise to exponent if appropriate
      if ( exponent > 0 )                                               // exponent must be a positive integer > 0
      {
        System.out.printf( "Calculating %d to the %d power\n", base, exponent);
         int result = integerPower( base, exponent );                   // invocation of iterative method
         System.out.printf( "Value is %d\n", result );                  // at this point, iteration has completed
      }                                                                 
      else
         System.out.println( "Invalid Exponent." );
   } // end main
  
    /************************************************************
   *   Method integerPower
   *       Iterative method for calculating the value of
   *       an integer x when raised to power y
   *   Input Parameters:
   *         base      -> base number x
   *         exponenet -> power y to which x is to be raised
   ***********************************************************/
  public static int integerPower( int base, int exponent )
   {
      if ( exponent == 1 )                                              // any number to the first power is itself
      {  
        System.out.println( "\nThe final answer is..." );
        return base;
      }  // end positive branch
      else
      { 
        int result = 1;                                                 // using zero here would create 'bad' output
        while( exponent >= 1 )                                          // continue until the exponent = 0; see above
        {
          result = result * base;                                       // multiply result by base... 
          exponent = exponent - 1;                                      // decrement exponent value... down to zero
        }  // end while loop
        return result;                                                  // after loop completes, return result
      }  // end negative branch
      
   }     // end method integerPower
  
} // end class Power_byIteration
