package huffmancodinglabterminal;
//Screen 2
// use to make a piority Queue
public class PiorityQueue {
    // size of piority Queue
    private int size;
    // Node Array for piority queue
    private Node[] arrayPQ;
    /* Contructor intiallize the arrayPQ with  the parameter size is 
    the size of the BT element*/
    public PiorityQueue(int size) {
        arrayPQ = new Node[size];
        this.size = 0;
    }
    // Check if piority queue is full
    boolean isFull() { return size == arrayPQ.length-1; }
    // Check if piority queue is empty
    boolean isEmpty() { return size == 0; }
    // insert value(chatracterData with its frequency) in Piority Queue
    public void insert(int freq, char data) {
        if(isFull())
            System.out.println("Queue is Full");
        else {
            arrayPQ[++size] = new Node(data,freq);
            heapifyInsertingNode();
        }
    }
    // insert a Binary tree node in Piority Queue
    public void insert(Node n) {
        if(isFull())
            System.out.println("Queue is Full");
        else {
            arrayPQ[++size] = n;
            heapifyInsertingNode();
        }
    }
    /*Use to Heapify the inserted Node at the last check Piority Queue 
    Concept for this understanding*/
    private void heapifyInsertingNode(){
        /*size / 2 is the parent of current added node min heapify parent then again i=i/2
    go to grand parent and min heapify them*/
        for(int i= size/2 ; i>=1 ; i= i/2) {
            minHeapify(arrayPQ, i, size);
        }
    }
    /* size/2 to 0(is all parent) to min heapify all them*/
    public void buildHeap() {
        for(int i= size/2 ; i>=1 ; i--) {
            minHeapify(arrayPQ, i, size);
        }
    }
    
    private void maxHeapify(Node[] a, int i, int n) {
        int left = 2*i;
        int right = (2*i)+1;
        int largest;
        if(left<=n && a[left].freq>a[i].freq)
            largest = left;
        else 
            largest = i;
        if(right<=n && a[right].freq>a[largest].freq)
            largest = right;
        if(largest != i) {
            Node temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest, n);
        }
    }
    //Min Heapify go And learn concept of MinHeapify for better understanding(parent< both child)
    private void minHeapify(Node[] a, int parent, int size) {
        // left child is locate at 2*i and right child is next to them
        int left = 2*parent;
        int right =  (2*parent)+1;
        // initialize smallest with parent as in min heapify parent is always small
        int smallest=parent;
        /*check if left index < size as parent have left child or not? if yes then
        it is small then parent so change smallest*/
        if(left<=size && a[left].freq<a[parent].freq)
            smallest = left;
        /*check if right index <= size as parent have right child or not? if yes then
        it is small that previos smallest variable(left or parent) so change smallest */
        if(right<=size && a[right].freq<=a[smallest].freq)
            smallest = right;
        /*if smallest is not the parent then left or right is smallest change it 
        with parent and call minHeapify again for the previous parent change with 
        either left or right*/
        if(smallest != parent) {
            Node temp = a[parent];
            a[parent] = a[smallest];
            a[smallest] = temp;
            minHeapify(a, smallest, size);
        }
    }
    
    public void display() {
        
        for(int i=1 ; i<=size ; i++)
            System.out.print(arrayPQ[i].data + " - "+arrayPQ[i].freq);
        System.out.println("");
    }
    /* remove the first root element from piority queue as it is the smallest in it
        save the root node 
        change the last node with root 
        min heapify root  
        return the previous save root node*/
    public Node removeMin() {
        Node temp = null;
        if(isEmpty()) {
            return temp;
        }
        //store root node in temp
        temp = arrayPQ[1];
        //change the last node with root 
        arrayPQ[1] = arrayPQ[size];
        // decrement array size as one element(the last one) remove 
        size--;
        // min heapify root
        minHeapify(arrayPQ, 1, size);
        //return the previous save root node
        return temp;
    }
    
    public int length () {
        return size;
    }
    
    public int peek() {
        int temp = 0;
        if(isEmpty())
            System.out.println("Queue is Empty");
        else 
            temp = arrayPQ[1].freq;
        return temp;
    }
    
    public void clear() {
        size = 0;
    }
    /*By using pre-order-traversing in Binary Tree insert each traversing node 
    from Binary Tree to piority Queue*/
    public void generatePQFromBT(Node n) {
        
        if (n != null) {
            insert(n.freq, n.data);
            generatePQFromBT(n.left);
            generatePQFromBT(n.right);
        }

    }
    
}
