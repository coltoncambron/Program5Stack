
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Functions {

    public static boolean isDigits(String inString){
        if (inString == null || inString.isEmpty()) 
            return false;
        for (char c : inString.toCharArray()) {
            if (!Character.isDigit(c)) 
               return false;
        }
        return true;
    }
    //PRE: Words must be the same forwards and backwards to be considered a palindrome
    //POST: Prints and writes to the output whether each word in the list is a palindrome
    public static void testPalindrome(PrintWriter out){
        System.out.println("\nSTACK 1: PALINDROME");
        out.println("\nSTACK 1: PALINDROME");
        
        MyStack<Character> stack = new MyStack<>();
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("tacocat", "bubba","a", "mom","abba", "abccba", "abcba" ));
        for (String word : wordList) {
            for (char c : word.toCharArray()) {
                stack.push(c);
            }
            boolean isPalindrome = true;
            for (char c : word.toCharArray()) {
                if (stack.pop() != c) {
                    isPalindrome = false;
                    break;
                }
            }
            stack.clear(); // Clear the stack for the next word
            String line = String.format("%-10s is a palindrome: %b", word, isPalindrome);
            System.out.println(line);
            out.println(line);
        }

    }

    public static void testPostFixExpression(PrintWriter out) {
        System.out.println("\nSTACK 2: POSTFIX EVALUATOR");
        out.println("\nSTACK 2: POSTFIX EVALUATOR");       

        ArrayList<String> expList = new ArrayList<>(Arrays.asList(
            "5 7 * 15 + 25 *", 
            "5 0 / 4 +", 
            "15 2 * 3 / 15 +", 
            "3 5 7 + *", 
            "3 5 6"));

    }

    public static void testPreFixExpression(PrintWriter out) {
        System.out.println("\nSTACK 3: PREFIX EVALUATOR");
        out.println("\nSTACK 3: PREFIX EVALUATOR");
      
        ArrayList<String> expList = new ArrayList<>(Arrays.asList(
            "+ * 7 5 + 6 7",
            "- + 7 * 4 5 + 2 0",
            "- / 18 / 6 3 2",
            "* 25 + 15 * 7 5", 
            "+ 4 / 0 5", 
            "+ 15 / 3 * 2 15", 
            "* + 7 5 3", 
            "6 5 3"));

	}
    //PRE: Accepts a open printwriter for report file
    //POST: Prints and writes to the output the binary representation of each number
    public static void testDecToBinary(PrintWriter out) {
        System.out.println("\nSTACK 5: DECIMAL TO BINARY EVALUATOR");
        out.println("\nSTACK 5: DECIMAL TO BINARY EVALUATOR");

        ArrayList<Integer> binary = new ArrayList<>(Arrays.asList(15, 81, 105, 255, 256, 0, 1 ));
        
        for(int i =0; i< binary.size(); i++) {
            int num = binary.get(i);
            MyStack<Integer> stack = new MyStack<>();
            while (num != 0) {
                stack.push(num % 2);
                num /= 2;
            }
            StringBuilder binaryStr = new StringBuilder();
            while (!stack.isEmpty()) {
                binaryStr.append(stack.pop());
            }
            if(binaryStr.isEmpty()){
                binaryStr.append("0");
            }
            String line = String.format("The decimal value %-5d is %-12s in binary", binary.get(i), binaryStr.toString());
            System.out.println(line);
            out.println(line);
        }
 
    }
    //PRE:  accepts an open PrintWriter for the report file
    //POST: opening brackets ( [ { are pushed and each closing bracket must
    //      match the top of the stack; an expression is balanced only if no
    //      mismatch occurs and the stack is empty at the end; one result line
    //      per expression is written to the console and the report file
    public static void testIsBalanced(PrintWriter out) {
        System.out.println("\nSTACK 4: PARENTHESIS IS BALANCED EVALUATOR");
        out.println("\nSTACK 4: PARENTHESIS IS BALANCED EVALUATOR");

        ArrayList<String> expList = new ArrayList<>(Arrays.asList(
            "[7 + (4 - 3)] - (3 * 4)",
            "[7 + (4 - 3] - (3 * 4)",
            "4 + 6 - 7", 
            "([x + y] + {z * w})",
            "{(1 + [2 * 3]) - 4}",
            "([x + y] + z}"));
        MyStack<Character> stack = new MyStack<>();

        for(String exp : expList){
            boolean balanced = true;
            stack.clear();
            for(char ch : exp.toCharArray()) {
                if(ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else if(ch == ')' || ch == ']' || ch == '}') {
                    if(stack.isEmpty() || (ch == ')' && stack.peek() != '(') || (ch == ']' && stack.peek() != '[') || (ch == '}' && stack.peek() != '{')) {
                        balanced = false;
                        break;
                    }
                    char top = stack.peek();
                    if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
                        stack.pop();
                    }
                }
            }

            String result;
            if(stack.isEmpty() && balanced) {
                result = "is balanced";
            } else {
                result = "is not balanced";
            }
            String line = String.format("The expression %-25s %s", exp, result);
            System.out.println(line);
            out.println(line);
        }
    }


    public static void testUndoRedo(PrintWriter out) {
        System.out.println("\nSTACK 6: UNDO REDO FUNCTION EVALUATOR");
        out.println("\nSTACK 6: UNDO REDO FUNCTION EVALUATOR");

        ArrayList<String> expList = new ArrayList<>(Arrays.asList(
            "D add a", "D add b", "D add c", "R", "U","U","R","U","D add d", "U", "U", "U", "R", "F", "Q"));

    }

}
