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
        return 0;//base case
      }
      return sqrooty(n, 1, tolerance);//call helper method
    }

    public static double sqrooty(double n, double guess, double tolerance){
      double pError = (Math.abs(((guess * guess) - n)) / n) * 100;//calculate percent error
      if(pError > tolerance){//compare percent error to tolerance
        double newGuess = ( n / guess + guess) / 2;//formula for new guess
        return sqrooty(n, newGuess, tolerance);//recursive step
      } else{
        return guess;//base case
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      return fibHelper(n, 0, 1);
    }

    public static int fibHelper(int n, int firstNum, int secondNum){
      if(n == 0){
        return firstNum;
      }
      if(n == 1){
        return secondNum;
      }
      return fibHelper(n - 1, secondNum, firstNum + secondNum);
    }

    /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> sums = new ArrayList<Integer>();
      makeAllSumsHelper(n, 0, sums);
      return sums;
    }

    public static void makeAllSumsHelper(int n, int currentSum, ArrayList<Integer> sums){
      if(n == 0){
        sums.add(currentSum);
      }else{
        makeAllSumsHelper(n - 1, currentSum + n, sums);
        makeAllSumsHelper(n - 1, currentSum, sums);
      }
    }

    public static void main(String[] args) {
      System.out.println("SQUARE ROOT TESTING");
      System.out.println(sqrt(100, 0.001));
      System.out.println(sqrt(100, 10));
      System.out.println(sqrt(2, 0.001));
      System.out.println(sqrt(0, 0.001));

      System.out.println("");

      System.out.println("FIBONNACI TESTING");
      System.out.println(fib(0));//should be 0
      System.out.println(fib(1));//should be 1
      System.out.println(fib(2));//should be 1
      System.out.println(fib(3));//should be 2
      System.out.println(fib(4));//should be 3
      System.out.println(fib(5));//should be 5

      System.out.println("");

      System.out.println(makeAllSums(3));
    }

}
