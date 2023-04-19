public class Main {
    public static void main(String [] args) {
        Node a = new Node(10,'a');
        Node b = new Node(20,'b');
        System.out.println(b.compareTo(a));
        Huffman huffman = new Huffman();
        huffman.addNode(a);
        huffman.addNode(b);
        System.out.println(huffman.getQueue().peek().toString());
    }
}
