import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Balanced {
    public static void main(String[] args) throws FileNotFoundException {
        // Import the input file and read it into memory
        File f = new File("in.txt");
        Scanner sc = new Scanner(f);

        // Initialize a counting variable
        int numBalance = 0;

        // Skip the first line of the text file
        sc.nextLine();

        // Read the input lines
        while(sc.hasNextLine()){

            // Get the next line
            String line = sc.nextLine();

            // Initialize a new stack
            Stack s = new Stack();

            // Look through each character in the input line
            for(int i = 0; i < line.length(); i++){
                // If character is a starting delimiter, add it to the stack
                if(line.charAt(i) == '{' || line.charAt(i) == '(' || line.charAt(i) == '['){
                    s.push(line.charAt(i));
                }

                // If this ending delimiter is found
                if(line.charAt(i) == '}'){
                    // and the stack has the starting delimiter on top, pop the stack
                    if(s.peek() != null && (char)s.peek() == '{'){
                        s.pop();
                    }else{ // else the expression is imbalanced
                        break;
                    }
                }

                if(line.charAt(i) == ']'){
                    if(s.peek() != null && (char)s.peek() == '['){
                        s.pop();
                    }else{
                        break;
                    }
                }

                if(line.charAt(i) == ')'){
                    if(s.peek() != null && (char)s.peek() == '('){
                        s.pop();
                    }else{
                        break;
                    }
                }

            }

            // If the stack is empty, the expression should be balanced
            if(s.empty()){
                // System.out.println(count);
                numBalance++;
            }

        }

        // Prints out the number of balanced expressions
        System.out.println(numBalance);
    }
}
