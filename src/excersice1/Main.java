package excersice1;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Node rootFolder = new Node("111");
        Node folder222 = new Node("222");
        Node folder333 = new Node("333");
        Node folder444 = new Node("444");
        Node folder555 = new Node("555");
        Node file1 = new Node("1.doc");
        Node file2 = new Node("2.doc");
        Node file3 = new Node("3.doc");
        Node file4 = new Node("4.doc");
        Node file5 = new Node("5.doc");


        rootFolder.insertChild(folder222);
        rootFolder.insertChild(folder333);
        folder222.insertChild(folder444);
        folder222.insertChild(folder555);
        folder444.insertChild(file1);
        folder444.insertChild(file2);
        folder333.insertChild(file3);
        folder333.insertChild(file4);
        folder333.insertChild(file5);

        file3.moveTo(folder555);
        file4.moveTo(folder555);
        folder333.deleteChild(file5);

        makeAssertion( 0 == folder333.getChildren().size() );
        makeAssertion( 2 == folder555.getChildren().size() );
        makeAssertion( folder555.getChildren().contains(file3) );
        makeAssertion( folder555.getChildren().contains(file4) );

        makeAssertion( folder222.equals(findCommonAncestor(folder444, folder555)) );

        System.out.println("All tests passed");
    }

    private static Node findCommonAncestor(Node firstNode, Node secondNode) {
        Set<Node> parents = new HashSet<>();
        Node firstParent = firstNode.getParent();
        Node secondParent = secondNode.getParent();
        while (firstParent != null || secondParent != null) {
            if (firstParent != null) {
                if (!parents.add(firstParent)) {
                    return firstParent;
                }
                firstParent = firstParent.getParent();
            }

            if (secondParent != null) {
                if (!parents.add(secondParent)) {
                    return secondParent;
                }
                secondParent = secondParent.getParent();
            }
        }
        return null;
    }

    private static void makeAssertion(boolean assertion) {
        if (!assertion) {
            throw new RuntimeException("Assertion failed");
        }
    }
}
