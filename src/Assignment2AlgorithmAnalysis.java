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
    *
    * */

    //===========================================End of Exercise 1=================================================================
    //===========================================Beginning of Exercise 2===========================================================
    //===========================================End of Exercise 2=================================================================
    //===========================================Beginning of Exercise 3===========================================================
    //===========================================End of Exercise 3=================================================================







    //================================================ Test Harness - Main ======================================================
    public static void main(String[] args){

        int[] numbers = {1,2,3,4,5};
        example3(numbers);
    }
}
