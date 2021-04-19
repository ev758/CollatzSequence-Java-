import java.util.*;

public class CollatzNode {

    Node head; //head node of linked list

    //linked list node
    //inner class made public static so main() from CollatzSequence can access it
    public static class Node {

        int collatz;
        Node nextCollatzNode;

        //Constructor
        Node(int collatzPar) {
            collatz = collatzPar;
            nextCollatzNode = null;
        }
    }

    public static CollatzNode addCollatzNode(CollatzNode collatzNumPar, int userInputPar) {
        boolean isOne = false;
        int counter = 1;

        while (isOne == false) {
            //creates a new node with the given input
            Node newCollatzNode = new Node(userInputPar);
            newCollatzNode.nextCollatzNode = null;
            //if the linked list is empty, then make the new node as head
            if (collatzNumPar.head == null) {
                collatzNumPar.head = newCollatzNode;
            }
            else {
                //else traverse the linked list until the last node is reached
                //and add the new node at the end of the linked list
                Node lastCollatzNode = collatzNumPar.head;
                while (lastCollatzNode.nextCollatzNode != null) {
                    lastCollatzNode = lastCollatzNode.nextCollatzNode;
                }
                    //the last term of the collatz sequence is placed into the new node
                    if (newCollatzNode.collatz == userInputPar) {
                        newCollatzNode.collatz = lastCollatzNode.collatz;
                    }

                    //calculations of the collatz sequence
                    if (newCollatzNode.collatz % 2 == 0) {
                        //the new node is the last node of the linked list
                        lastCollatzNode.nextCollatzNode = newCollatzNode;
                        lastCollatzNode = lastCollatzNode.nextCollatzNode;
                        lastCollatzNode.collatz = lastCollatzNode.collatz / 2;
                        counter++;
                    }
                    else if (newCollatzNode.collatz == 1){
                        isOne = true;
                        System.out.println("The number " + userInputPar
                                + " produces the longest Collatz sequence of "
                                + counter + " terms.");
                    }
                    else if (newCollatzNode.collatz % 2 == 1) {
                        //the new node is the last node of the linked list
                        lastCollatzNode.nextCollatzNode = newCollatzNode;
                        lastCollatzNode = lastCollatzNode.nextCollatzNode;
                        lastCollatzNode.collatz = ((3 * lastCollatzNode.collatz) + 1);
                        counter++;
                    }
            }
        }
        //returns collatz sequence linked list
        return collatzNumPar;
    }

    public static void displayCollatzSequence(CollatzNode collatzNumPar)
    {
        Node currCollatzNode = collatzNumPar.head;

        //traverse the linked list and displays each nodes' content
        System.out.println("Here are the terms:");
        while (currCollatzNode != null) {
            //displays the content of the current node
            System.out.print(currCollatzNode.collatz);
            if (currCollatzNode.nextCollatzNode != null) {
                System.out.print("->");
            }

            //goes to the next node
            currCollatzNode = currCollatzNode.nextCollatzNode;
        }
    }

}
