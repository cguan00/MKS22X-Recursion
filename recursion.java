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
      ArrayList<Integer> sums = new ArrayList<Integer>();//create arraylist that will store all the sums
      makeAllSumsHelper(n, 0, sums);//call helper method
      return sums;
    }

    public static void makeAllSumsHelper(int n, int currentSum, ArrayList<Integer> sums){
      if(n == 0){
        sums.add(currentSum);//base case
      }else{
        if(n > 0){//if n is positive
          makeAllSumsHelper(n - 1, currentSum + n, sums);//adding the number to the current sum
          makeAllSumsHelper(n - 1, currentSum, sums);//not adding the number to the current sum
        }else{//if n is a negative number
          makeAllSumsHelper(n + 1, currentSum + n, sums);//adding the number to the current sum
          makeAllSumsHelper(n + 1, currentSum, sums);//not adding the number to the current sum
        }
      }
    }

    public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{

      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
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

      System.out.println("MAKE ALL SUMS TESTING");
      System.out.println(makeAllSums(3));//should print [0, 3, 2, 5, 1, 4, 3, 6] (order is not important)
      System.out.println(makeAllSums(-3));//should print [0, -3, -2, -5, -1, -4, -3, -6] (order is not important)
      System.out.println(makeAllSums(0));//should print [0]
    }

}
