import java.util.ArrayList;
import java.util.List;

public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double sqrt(double n, double tolerance){
      if(n == 0){
        return 0;
      }
      return sqrooty(n, 1, tolerance);
    }

    public static double sqrooty(double n, double guess, double tolerance){
      double pError = (Math.abs(((guess * guess) - n)) / n) * 100;
      if(pError > tolerance){
        double newGuess = ( n / guess + guess) / 2;
        return sqrooty(n, newGuess, tolerance);
      } else{
        return guess;
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      return 0;
    }

    /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(){
      ArrayList<Integer> output = new ArrayList<Integer>();
      return output;
    }

    public static void main(String[] args) {
      System.out.println(sqrt(100, 0.001));
      System.out.println(sqrt(100, 10));
      System.out.println(sqrt(2, 0.001));
      System.out.println(sqrt(0, 0.001));
    }

}