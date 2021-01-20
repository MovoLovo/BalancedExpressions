import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Balanced {

    public static Stack s;
    public static void main(String[] args) throws FileNotFoundException {
        // Import the input file and read it into memory
        Scanner sc = new Scanner(new File("C:\\Users\\lol2f\\Desktop\\CodeProjects\\DataStructures\\BalancedExpressions\\in.txt"));
        // Scanner is acting odd and won't allow me to do relative paths, might be because I moved the project

        // Initialize a counting variable
        int numBalance = 0;

        // Skip the first line of the text file
        sc.nextLine();

        // Variable for debugging (tells you which line is evaluated as balanced)
//        int count = 2;

        // Read the input lines
        while(sc.hasNextLine()){

            // Get the next line
            String line = sc.nextLine();

            // Initialize a new stack
            s = new Stack();

            // Initial/reset a variable that keeps track of if the expression is balanced
            boolean balanced = true;

            // Look through each character in the input line
            for(int i = 0; i < line.length(); i++){

                // If character is a starting delimiter, add it to the stack
                if(line.charAt(i) == '{' || line.charAt(i) == '(' || line.charAt(i) == '['){
                    s.push(line.charAt(i));
                }

                // Run checks to see if expressions are balanced
                balanced = isBalanced('[', ']', line, i) // Checks if ] is the current char and if [ is on top of the stack
                        && isBalanced('{', '}', line, i) // Checks if { and } are balanced
                        && isBalanced('(', ')', line, i); // Checks if ( and ) are balanced

                // Break out of the loop if it isn't balanced
                if(!balanced){
                    break;
                }
            }

            // Checks if the expressions are balanced and if the stack is empty
            balanced = balanced && s.empty();

            // If balanced is true, the expression should be balanced
            if(balanced){
//                System.out.println(count);
                numBalance++;
            }

//            count++;
        }

        // Prints out the number of balanced expressions
        System.out.println(numBalance);
    }

    /**
     * Checks if the character at top of the stack balances with the character at i
     * If it does, pop() the stack
     * @param start starting delimiter character
     * @param end ending delimiter character
     * @param line the line being evaluated
     * @param i the iteration from the loop
     * @return If stack is popped or end delimiter is not found before start, return true. Otherwise false
     */
    public static boolean isBalanced(char start, char end, String line, int i){
        // Unfortunately, this is too long to effectively turn into an inline if statement

        // Checks if the current character is an end delimiter
        if(line.charAt(i) == end){

            // If the stack is empty, return false
            if(s.peek() == null){
                return false;
            }

            // If the character at the top of the stack is the start delimiter, pop() and return true
            if((char)s.peek() == start){
                s.pop();
                return true;
            }
            // Else return false
            return false;
        }

        // Else return true
        return true;
    }
}
