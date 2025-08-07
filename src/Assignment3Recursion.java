import java.io.File;

public class Assignment3Recursion {

    public static class ProductOfTwoIntergers {
        /*
         * Create a recursive algorithm to compute the product of two positive integers,
         *  m and n, using only addition and subtraction. Implement the Java or Python code.
         * Hint: You need subtraction to count down from m or n and addition to do the arithmetic
         * needed to get the right answer. Check linearSum method from Week 5 examples.
         * */
        public static int Products(int m, int n) {
            //base-case/ stopping condition code
            if (m == 0)
                return 0;
            else return n + Products((m - 1), n);
        }

    }//----------------------------------------------End of Exercise 1-------------------------------------------------------

    //----------------------------------------------Beginning of Exercise 2---------------------------------------------------

    public static class Palindrome {
        /*
         * Write a short recursive Java method that determines if a string s is a palindrome,
         * that is, it is equal to its reverse. Examples of palindromes include 'racecar'
         * and 'gohangasalamiimalasagnahog'.
         * Test the method by asking the user to provide string entries to be checked.
         * Hint: Check the equality of the first and last characters and recur
         * (but be careful to return the correct value for both odd and even-length strings).
         * */

        public static boolean isPalindrome(String s){
            //base-case code
            // check if a string is a palindrome
            if(s.isEmpty() || s.length() == 1){
                return true;
            }

            //check if each character of the string matches
            if (s.charAt(0) == s.charAt(s.length() - 1)){
                return isPalindrome(s.substring(1,s.length() - 1));
            }
            //additional base-case to handle non-palindromes
            return false;
        }
    }//-------------------------------------------------End of Exercise 2 ---------------------------------------------

//--------------------------------------------------Beginning of Exercise 3---------------------------------------------


    public class FindPath {

//    /*Question
//    * Implement a recursive method with calling signature find(path, filename) that reports all entries
//    * of the file system rooted at the given path having the given file name. Test the method with a real path,
//    * filename from your file system. Hint: Review use of the java.io.File class and the week 5 examples
//    * */


        public static void find(String path, String filename) {
            File startPath = new File(path);

            if (!startPath.exists()) {
                System.out.println("Path does not exist: " + path);
                return;
            }

            if (startPath.isFile()) {
                if (startPath.getName().equals(filename)) {
                    System.out.println("Found: " + startPath.getAbsolutePath());
                }
                return;
            }

            //is a directory
            File[] files = startPath.listFiles();
            if (files == null) return; // Permission issues or not a directory

            for (File file : files) {
                find(file.getAbsolutePath(), filename); // Recursive call
            }
        }

        public static void main(String[] args){


        }
    }



    //================================================Test Harness================================================================
    public static void main(String[] args){

        System.out.println("Exercise 1 Test");
        System.out.println(ProductOfTwoIntergers.Products(10,5));
        System.out.println();

        System.out.println("Exercise 2 Test");
        System.out.println(Palindrome.isPalindrome("racecar"));
        System.out.println(Palindrome.isPalindrome("Michelle"));
        System.out.println();

        System.out.println("Exercise 3 Test");
        String path = "C:\\2025\\Subsidy";
        String file = "Consent-Form.pdf";
        FindPath.find(path, file);

        //file does not exist
        String path1 = "C";
        String file1 = "Consent-Form.pdf";
        FindPath.find(path1, file1);



    }
}
