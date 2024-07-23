package huffmancodinglabterminal;
//Screen 1
//get a string of message count the number of character in message
public class CharactersFrequencyCount {

    public Node rootBT;
    private int size;
//    public PiorityQueue pq;

    public CharactersFrequencyCount() {
        rootBT = null;
        size = 0;
//        pq = null;
    }
/* this function count the number of characters in the string it will create a binary tree 
    it has the insertInBinaryTree method that take a character compare it in the tree 
    if character already exit increment its frequency(so they count how many time a character exit)
    if it not exit create a new node in binary tree*/
    public void countCharacters(String message) {
        // Initialize first character of message with root node and freq 1
        rootBT = new Node(message.charAt(0), 1);
        //increment size as one node insert in Binary tree
        size++;
        //this for loop create binary tree to store number of each unique character in string 
        for (int i = 1; i < message.length(); i++)
            insertInBinaryTree(message.charAt(i));
//        return root;
        // generate piority queue from the binary tree
//        insertInPiorityQueue(root);
//        return new Huffman().generateHuffmanTree(pq);
    }
    
/* take a character use binary tree insertion logic (tree generated as if ascci of given character if less then root go to 
    left side other wise go to right side ) to check if its already exists increment its frequency other wise add 
   the character by form a new node to the left if ascci of new character is less then its parent and right 
    if ascii of new character is large then parents
    Starting Point: root of tree .
    
    Traversing Across Tree:
    Compare the new character’s ASCII value to the ASCII value of the current node (starting from the root).
    If the new character’s ASCII value is less than the current node’s ASCII value, move to the left side.
    If the new character’s ASCII value is greater than or equal to the current node’s ASCII value, move to the right side.
    
    Checking for Existing Character or not:
    If you reach a node where the character already exists, increase its frequency count.
    
    Inserting the New Node:
    If you reach an empty spot (no node) where you can insert the new character, create a new node with the 
    character and set its frequency to 1.
    When you find the correct empty spot (either left or right), create a new node with the character and put it there.
    */
    private void insertInBinaryTree(char item) {
        Node p, q;
        p = q = rootBT;
        while (q != null && item != p.data) {
            p = q;
            if (p.data > item)
                q = p.left;
            else
                q = p.right;
        }
        if (p.data == item)
            p.freq++;
        else if (p.data > item) {
            p.left = new Node(item, 1);
            // increase the size as new character node add in the tree
            size++; 
        } else {
            p.right = new Node(item, 1);
            // increase the size as new character node add in the tree
            size++; 
        }
    }
    public int length() {
        return size;
    }
}
