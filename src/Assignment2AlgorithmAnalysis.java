import java.util.Arrays;

public class Assignment2AlgorithmAnalysis {

    //I created this outer class to contain all the nested classes for lab assignment 2 on github

    //===========================================Beginning of Exercise 1===========================================================

    /** Returns the sum of the integers in given array. */
    public static int example1(int[] arr) {//takes integer array
        int n = arr.length, total = 0;//n = length of the array, total is initialized to 0
        for (int j=0; j < n; j++)       // loop will run from 0 to n-1 times
            total += arr[j];  //add the index value of the array to total
        return total; // return the value of total
    }

    /*Big O Analysis
    - The loop runs exactly n-1 times
    - f(n) = c (total += arr[j]) => g(n) = 1 --> O(1) big O of constant time(1), this will take the same amount of time regardless of the size of n. It is independent.
      f(n) = c times g(n) ==> f(n) = cg(n) => O(g(n))
    - Total time complexity is O(1)

    Therefore time complexity
    * */


    /** Returns the sum of the integers with even index in given array. */
    public static int example2(int[] arr) { // takes an array integer
        int n = arr.length, total = 0; //n is the length of the array, total is initialized to 0
        for (int j=0; j < n; j += 2)    // runs j < 2 and increases by 2
            total += arr[j]; //add index value of j
        return total; //return the value of j
    }

    /* Big O analysis
    -  This algorithm starts at 0 and runs while j < n.
    - if total += arr[j] runs at a constant time of n/2 (because it increases by 2), then
    - f(n) n/2 * c => O(n)
    - => even half of the array elements are added, time complexity is linear in the size(n) of the array.
    * */

    /** Returns the sum of the prefix sums of given array. */
    public static int example3(int[] arr) { //takes an integer array
        int n = arr.length, total = 0; // n is the length of the array, total is initialized to 0
        for (int j=0; j < n; j++) {     // loops from 0 to n-1
            System.out.print(j);
            for (int k=0; k <= j; k++) {    // loops from 0 to j
                total += arr[j];
                System.out.print(k);
            }
            System.out.println();
        }
        return total;
    }

    /*Big O Analysis
    * Time complexity of the above code is big O(n^2).
    * The input size is linearly proportional to the time complexity of the algorithm.
    * The inner loop will run as many until n - 1. The first loop will run, then the second loop
    * will run as many times until k <= j => j = n -1
    * */


    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0; // runs constant time - O(1)
        for (int j=0; j < n; j++) {     // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

     /* Big O Analysis:
    /* All the lines of code runs at a constant time complexity.
    -  However, the entire algorithm will run at n times or (n-1) times.
    -  This means that the time complexity is O(n)
    - => time complexity is proportional (linear) to the input size because it will take the same amount of time for the
    code to run through each element.
    * */


    /** Returns the number of times second array stores sum of prefix sums from first. */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) {     // loop from 0 to n-1 => O(n)
            int total = 0;
            for (int j=0; j < n; j++)     // loop from 0 to n-1  => O(n)
                for (int k=0; k <= j; k++)  // loop from 0 to j  => O(n^2)
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }


    /* Big O Analysis:
    - Outer loop will run at O(n) time complexity
    - Middle loop will run also at O(n) time complexity
    - Inner loop will run at O(n^2)
    => Time complexity of the algorithm = O(n) * O(n)* O(n^2) = O(n^1+1+2)
    => time complexity = O(n^4) = quadratic time complexity
    * */

    //===========================================End of Exercise 1=================================================================
    //===========================================Beginning of Exercise 2===========================================================

    class PrefixAverage {

        /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
        public static double[] prefixAverage1(double[] x) {
            int n = x.length;   //n stores the length of x
            double[] a = new double[n];    // filled with zeros by default and is the length of x
            for (int j=0; j < n; j++) {
                double total = 0;            // begin computing x[0] + ... + x[j]
                for (int i=0; i <= j; i++)
                    total += x[i];
                a[j] = total / (j+1);        // record the average
            }
            return a;
        }

        /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
        public static double[] prefixAverage2(double[] x) {
            int n = x.length;
            double[] a = new double[n];    // filled with zeros by default
            double total = 0;              // compute prefix sum as x[0] + x[1] + ...
            for (int j=0; j < n; j++) {
                total += x[j];               // update prefix sum to include x[j]
                a[j] = total / (j+1);        // compute average based on current sum
            }
            return a;
        }

    }
    //===========================================End of Exercise 2=================================================================

    //===========================================Beginning of Exercise 3===========================================================

    static class Uniqueness {

        /** Returns true if there are no duplicate elements in the array. */
        public static boolean unique1(int[] data) {
            int n = data.length;
            for (int j=0; j < n-1; j++)
                for (int k=j+1; k < n; k++)
                    if (data[j] == data[k])
                        return false;                    // found duplicate pair
            return true;                           // if we reach this, elements are unique
        }

        /** Returns true if there are no duplicate elements in the array. */
        public static boolean unique2(int[] data) {
            int n = data.length;
            int[] temp = Arrays.copyOf(data, n);   // make copy of data
            Arrays.sort(temp);                     // and sort the copy
            for (int j=0; j < n-1; j++)
                if (temp[j] == temp[j+1])            // check neighboring entries
                    return false;                      // found duplicate pair
            return true;                           // if we reach this, elements are unique
        }

    }


    //===========================================End of Exercise 3=================================================================



    //================================================ Test Harness - Main ======================================================
    public static void main(String[] args){

        //Experimental analysis - Exercise 2:
        System.out.println("Experimental Analysis of Exercise 2");
        double[] numbers = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0};
        Double[] ave1Result = new Double[numbers.length];

        System.out.println("Testing prefixAverage 1...");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++) {

            ave1Result[i] = PrefixAverage.prefixAverage1(numbers)[i];
        }
        long endTime = System.currentTimeMillis();
        long timeEllapsed = endTime - startTime;

        System.out.println("Prefix Average 1: "+ Arrays.toString(ave1Result)+" took "+ timeEllapsed+" milliseconds");


        System.out.println("Testing prefixAverage 2...");
        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++) {

            ave1Result[i] = PrefixAverage.prefixAverage2(numbers)[i];
        }
        long endTime2 = System.currentTimeMillis();
        long timeElapsed2 = endTime2 - startTime2;

        System.out.println("Prefix Average 2: "+ Arrays.toString(ave1Result)+" took "+ timeElapsed2+" milliseconds");
        System.out.println();


        //Experimental Analysis of Exercise 3
        System.out.println("Experimental Analysis of Exercise 3");






    }
}

