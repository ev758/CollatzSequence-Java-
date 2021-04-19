import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args){
        //declarations
        Scanner collSeqObj = new Scanner(System.in);
        CollatzNode nodeCollatzNum = new CollatzNode();
        int userInput;
        boolean inputCorrect = false;

        //get user input
        System.out.print("Enter an integer that is 100 or less: ");
        userInput = collSeqObj.nextInt();

        while (inputCorrect == false) {
            if (userInput > 100) {
                System.out.println("Incorrect Input, Enter an integer 100 or less");
                userInput = collSeqObj.nextInt();
                inputCorrect = false;
            }
            else {
                inputCorrect = true;
            }

        }
        nodeCollatzNum.addCollatzNode(nodeCollatzNum, userInput);

        //output
        nodeCollatzNum.displayCollatzSequence(nodeCollatzNum);

    }
}
