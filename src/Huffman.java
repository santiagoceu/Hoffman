import java.security.Key;
import java.util.*;
import java.util.stream.Stream;


/**
 * Node object, points to a left node and a right node, may contain a character, and contains a frequency.
 */
class Node implements Comparable<Node> {
    char c;
    long frequency;
    Node left;
    Node right;

    @Override
    public int compareTo(Node n) {
        return Long.compare(this.frequency, n.frequency);
    }

    public Node(long frequency, char c) {
        this.frequency=frequency;
        this.c=c;

    }
    public Node(Node left, Node right) {

        if (left.compareTo(right)==-1) {
            this.left=left;
            this.right=right;
        } else if (left.compareTo(right)==1) {
            this.left=right;
            this.right=left;
        } else {
            int comparison = Character.compare(left.c,right.c);
            this.left = comparison == -1 || comparison == 0 ? left : right;
            this.right = comparison == 1 || comparison == 0 ? left : right;
        }

    }
    public String toString() {
        return Character.toString(c);
    }
}

public class Huffman {
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    public void addNode(Node n) {
        queue.add(n);
    }
    public PriorityQueue<Node> getQueue() {
        return queue;
    }

    public void connectTree() {
        for(int i=0;i<queue.size();i++) {

        }
    }
}
