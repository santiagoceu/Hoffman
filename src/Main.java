public class Main {
    public static void main(String [] args) {
        String text = "This is text to encode and decode.";
        Huffman huffman = new Huffman();

        String code = huffman.encode(text);
        System.out.println(huffman.getQueue().peek().toString());
        System.out.println(huffman.getQueue().toString());
        huffman.connectTree();
        System.out.println(huffman.getQueue().toString());
        System.out.println(code);
        System.out.println(huffman.getCodes());
        System.out.println(huffman.decode(code));

        //        String text1 = "100010111010110000101110100011100000110110000001111001111010010110" +
//                "0001101001110011010001011101011111110100001111001111110011110100011000110000" +
//                "00101101011110111111101110101101101110011101101111001111111001010010100101000001" +
//                "011010110001011001101000111001001011000011001000110101101010111111111110110111" +
//                "0111001000010010101100011111110001000111011001100101101000110111110101101000" +
//                "1101110000000111001001010100011111100001100101101011100110011110100011000110" +
//                "000001011010111110011100";
//        String text2 = "01101010110111001010001111010111001101110101101101000010001110101001" +
//                "011110100111111101110010100011110101110011011101011000011000100110100011100100" +
//                "10001100010110011001110010010000111101111010";
//        Huffman huffman = new Huffman();
//        huffman.addNode(new Node(11l,"A"));
//        huffman.addNode(new Node(2l,"B"));
//        huffman.addNode(new Node(4l,"C"));
//        huffman.addNode(new Node(3l,"D"));
//        huffman.addNode(new Node(14l,"E"));
//        huffman.addNode(new Node(3l,"G"));
//        huffman.addNode(new Node(6l,"I"));
//        huffman.addNode(new Node(6l,"L"));
//        huffman.addNode(new Node(3l,"M"));
//        huffman.addNode(new Node(6l,"N"));
//        huffman.addNode(new Node(7l,"O"));
//        huffman.addNode(new Node(4l,"P"));
//        huffman.addNode(new Node(1l,"Q"));
//        huffman.addNode(new Node(10l,"R"));
//        huffman.addNode(new Node(4l,"S"));
//        huffman.addNode(new Node(3l,"T"));
//        huffman.addNode(new Node(4l,"U"));
//        huffman.addNode(new Node(2l,"V"));
//        huffman.addNode(new Node(17l," "));
//        huffman.addNode(new Node(2l,","));
//        System.out.println(huffman.decode(text1));
//        System.out.println(huffman.decode(text2));
//        System.out.println("a".compareTo("z"));
    }
}
