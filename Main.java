//Created by Colton Cambron and William [Last Name]
//Project 5: Stack and Linked List Implementations
//Sources: Class lecture notes, claude Opus 5.5 



import java.io.IOException;
import java.io.PrintWriter;

public class Main {


    public static void main(String[] args) {

        try{
            PrintWriter out = new PrintWriter("report.txt");
            Functions.testPalindrome(out);
            Functions.testPostFixExpression(out);
            Functions.testPreFixExpression(out);
            Functions.testDecToBinary(out);
            Functions.testIsBalanced(out);
            Functions.testUndoRedo(out);
            out.close();
        }
        catch(IOException e){
            System.out.println("Error opening the file: " + e.getMessage());
        }
    }
}
