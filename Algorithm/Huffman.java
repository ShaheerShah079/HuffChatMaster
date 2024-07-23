package huffmancodinglabterminal;
//Screen 3
//Create a Huffman tree from the use of Piority Queue and then generate a Chart from it
public class Huffman {
    public int size;
    public String[][] chart;
    public Node huffmanTreeRoot;
    public Huffman(int arraySize){
        this.size=0;
        huffmanTreeRoot=null;
        chart = new String[arraySize][3];    
    }
//    static CharactersFrequencyCount chart = new CharactersFrequencyCount();
    
    /* Generate huffman tree from piority queue remove two minimum freq node from piority queue 
    create a new parent node of these two node with frequency addition of these two child 
    frequency repeat the process until the piority queue has only one element the
    last remaning node is huffman tree root*/ 
    public void generateHuffmanTree(PiorityQueue pq) {
        while (pq.length() > 1) { // repeat until only one element remain the hufman root
            //remove two minimum freq node from Piority Queue
            Node left = pq.removeMin();
            Node right = pq.removeMin();
            //create a new parent node of these two node with frequency addition of these two child frequency
            Node n = new Node(left.freq + right.freq, left, right);
            pq.insert(n);
        }
        //last remaning node is huffman tree root
        huffmanTreeRoot= pq.removeMin();
    }
    /* first we give the hufman tree root node to this function and it will 
    recursively create the chart from the hufman tree root and path string initialy have nothing*/
    public void generateChart(Node node, String PathCode) {
        if (node.left == null && node.right == null) {

            chart[size][0] = node.data + "";
            chart[size][1] = Integer.toString(node.freq);
            chart[size][2] = PathCode;
            size++;

            return;
        }
        /*by the use of pre order traversing we traverse each node in the huffman tree
          when go to left side add 0 in the previous PathCode and go left when go
        right side add 1 in previous PathCode and go right
        if the node is the child it both left and right side is null its the node have data 
        and PathCode is added accordingly as it go left or right
        */
        generateChart(node.left, PathCode + "0");
        generateChart(node.right, PathCode + "1");
    }

    public void displayArray(String[][] arr) {
        System.out.println("Char | \tFreq | \t Code");
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < 3; k++)
                System.out.print(arr[j][k] + "    |\t");
            System.out.println("\b\b");

        }
    }
}
