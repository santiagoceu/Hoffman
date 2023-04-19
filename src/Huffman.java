import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Node object, points to a left node and a right node, may contain a character, and contains a frequency.
 */
class Node implements Comparable<Node> {
    String c;
    long frequency;
    Node left;
    Node right;

    @Override
    public int compareTo(Node n) {
        if (this.frequency!=n.frequency)
            return Long.compare(this.frequency, n.frequency);
//        else if (this.c==" ") {
//            return -999;
//        } else if (this.c==",") {
//            return -1000;
//        } else if (n.c==" ") {
//            return 999;
//        } else if (n.c==",") {
//            return 1000;
//        }
        else return CharSequence.compare(this.c,n.c);
    }

    public Node(long frequency, String c) {
        this.frequency=frequency;
        this.c=c;

    }
    public Node(Node left, Node right) {

        if (left.compareTo(right) < 0) {
            this.left=left;
            this.right=right;
        } else if (left.compareTo(right) > 0) {
            this.left=right;
            this.right=left;
        }
//        else {
//            int comparison = CharSequence.compare(left.c,right.c);
//            this.left = comparison == 1 || comparison == 0 ? left : right;
//            this.right = comparison == -1 || comparison == 0 ? left : right;
//        }

        this.frequency=left.frequency+right.frequency;
        this.c = CharSequence.compare(left.c,right.c)==-1 ? right.c.concat(left.c): left.c.concat(right.c);

    }
    public String toString() {
        return c;
    }
}

public class Huffman {
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    private static HashMap<String,String> codes = new HashMap<String, String>();


    public void addNode(Node n) {
        queue.add(n);
    }
    public PriorityQueue<Node> getQueue() {
        return queue;
    }
    public HashMap<String,String> getCodes() {return codes;}

    public void calculateFrequency(String text) {

        Set<Character> set = text.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.toSet());
        ArrayList<Character> charList=new ArrayList<>(set);
        HashMap<Character,Long> frequencyTable = (HashMap<Character, Long>) charList.stream().collect(Collectors.groupingBy(s -> s,
                Collectors.counting()));
        for (Character c:frequencyTable.keySet()) {
            Node n = new Node(frequencyTable.get(c),c.toString());
            queue.add(n);
        }
    }

    public void connectTree() {

        while (queue.size()>1) {
            Node a = queue.poll();
            Node b = queue.poll();
            Node node = new Node(a,b);
            queue.add(node);
            //System.out.println("A: "+a+" B: "+b);
        }
    }

    public void generateCodes(Node root,String s) {
        connectTree();
        if (root != null) {
            if (root.right != null) {
                generateCodes(root.right,s+"1");
            }
            if (root.left != null) {
                generateCodes(root.left,s+"0");
            }
            if (root.right==null&&root.left==null) {
                codes.put(root.c,s);
            }
        }
    }

    public String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        connectTree();
        Node root = getQueue().peek();
        for (int i=0;i<encoded.length();) {
            Node tmp = root;
            while (tmp.right!=null&&tmp.left!=null&&i<encoded.length()) {
                if (encoded.charAt(i)=='0') {
                    tmp = tmp.left;
                } else {
                    tmp = tmp.right;
                }
                i++;
            }
            decoded.append(tmp.c);
        }
        return decoded.toString();
    }
    public String encode(String input) {
        calculateFrequency(input);
        connectTree();
        generateCodes(queue.peek(),"");
        StringBuilder output = new StringBuilder();
        for (int i = 0;i<input.length();i++) {
            output.append(codes.get(Character.toString(input.charAt(i))));
        }
        return output.toString();
    }
}
