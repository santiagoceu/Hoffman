public class Main {
    public static void main(String [] args) {
        String text = "This is text to encode and decode.";
//        Node a = new Node(4,"a");
//        Node b = new Node(2,"b");
//        Node c = new Node(2,"c");
//        System.out.println(b.compareTo(a));
        Huffman huffman = new Huffman();
//        huffman.addNode(a);
//        huffman.addNode(b);
//        huffman.addNode(c);
        huffman.calculateFrequency(text);
        String code = huffman.encode(text);
        System.out.println(huffman.getQueue().peek().toString());
        System.out.println(huffman.getQueue().toString());
        huffman.connectTree();
        System.out.println(huffman.getQueue().toString());
        System.out.println(code);
        System.out.println(huffman.getCodes());
        System.out.println(huffman.decode(code));
    }
}
