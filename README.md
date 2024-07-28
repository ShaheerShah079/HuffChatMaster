<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Huffman Coding Chat Application</h1>

  <h2>Overview</h2>
  <p>This project is developed as a semester project for the Data Structures and Algorithms course. It implements a chat application using Huffman coding for lossless data compression. It features a graphical user interface (GUI) for encoding and sending messages, as well as decoding received messages. The application also visualizes the Huffman coding table and supports network communication to send and receive messages.</p>

  <h2>Project Structure</h2>

  <h3>GUI Components</h3>
  <ul>
      <li><strong>Main Class (Main.java)</strong>
          <ul>
              <li>Provides the primary interface for encoding messages and sending them to a specified IP address.</li>
              <li>Listens for incoming messages from a specified port, decodes received data using Huffman coding, and displays results.</li>
              <li>Allows users to view the Huffman coding table.</li>
          </ul>
      </li>
      <li><strong>Table Class (Table.java)</strong>
          <ul>
              <li>Displays the Huffman coding table in a tabular format.</li>
              <li>Provides a way to view character frequencies and their corresponding Huffman codes.</li>
          </ul>
      </li>
  </ul>

  <h3>Algorithm Components</h3>
  <ul>
      <li><strong>Node Class</strong>: Represents a node in the Huffman tree, storing a character, its frequency, and its left and right children.</li>
      <li><strong>CharactersFrequencyCount Class</strong>: Counts characters frequencies in the message and creates a binary tree based on these character ascci value Also store frequency of each character</li>
      <li><strong>PriorityQueue Class</strong>: Implements a priority queue by traversing each nodes of the binary tree and store in Piority Queue, with nodes of lower frequency having higher priority as we use Min Heap.</li>
      <li><strong>Huffman Class</strong>: Constructs the Huffman tree from the priority queue and generates a Huffman coding Table</li>
      <li><strong>EncodeDecode Class</strong>: Encodes messages using the Huffman coding Table and decodes received encoded messages back to the original message using the same Huffman coding Table.</li>
  </ul>

  <h3>GUI Components</h3>
  <h4>Main.java</h4>
  <p>The <code>Main</code> class handles both sending and receiving encoded messages and generates and displays the Huffman chart.</p>

  <h5>Key Features:</h5>
  <ul>
      <li><strong>Message Encoding:</strong> Generates the Huffman coding tree from input text and encodes the message.</li>
      <li><strong>Message Sending:</strong> Connects to a specified IP address and sends the encoded data.</li>
      <li><strong>Message Receiving:</strong> Listens for incoming messages, decodes them, and displays the results.</li>
  </ul>

  <h5>Usage:</h5>
  <ol>
      <li><strong>Sending Messages:</strong>
          <ul>
              <li>Enter the message in the text area and specify the receiver's IP address.</li>
              <li>Click "Send" to encode and transmit the message.</li>
              <li>The encoded data and Huffman chart are sent to the receiver.</li>
          </ul>
      </li>
      <li><strong>Viewing Huffman Table:</strong>
          <ul>
              <li>Click "View Table" to open a new window displaying the Huffman coding table.</li>
          </ul>
      </li>
  </ol>

  <h5>Important Methods:</h5>
  <ul>
      <li><code>generateTree()</code>: Generates the Huffman tree and table from the input text.</li>
      <li><code>btnEncodeActionPerformed()</code>: Handles encoding and sending the message.</li>
      <li><code>btnViewTableActionPerformed()</code>: Opens the table view window.</li>
  </ul>

  <h4>Table.java</h4>
  <p>The <code>Table</code> class presents the Huffman coding chart in a table format.</p>

  <h5>Key Features:</h5>
  <ul>
      <li><strong>Table Display:</strong> Shows characters, their frequencies, and their Huffman codes.</li>
  </ul>

  <h5>Usage:</h5>
  <ul>
      <li>Click "Back" to return to the main screen.</li>
  </ul>

  
<h3>Algorithm Components</h3>

<h4>Node Class</h4>
<p>The <code>Node</code> class represents a node in the Huffman tree.</p>
<ul>
    <li><strong>Attributes:</strong>
        <ul>
            <li><code>Character</code>: The character of input Data stored in the node.</li>
            <li><code>Frequency</code>: The frequency of the character in the input data.</li>
            <li><code>Left Child</code>: Reference to the left child node in the tree.</li>
            <li><code>Right Child</code>: Reference to the right child node in the tree.</li>
        </ul>
    </li>
    
</ul>

<h4>CharactersFrequencyCount Class</h4>
<p>The <code>CharactersFrequencyCount</code> class counts the frequency of each character in the input message and constructs a binary tree based on these frequencies.</p>
<ul>
    <li><strong>Attributes:</strong>
        <ul>
            <li><code>Character Frequencies</code>: A data structure (e.g., a hash map or array) to store character frequencies.</li>
            <li><code>Binary Tree</code>: A binary tree used to organize characters by frequency.</li>
        </ul>
    </li>
    <li><strong>Methods:</strong>
        <ul>
            <li><code>countCharacters(String message)</code>: Analyzes the input message and counts occurrences of each character, storing these frequencies.</li>
            <li><code>createBinaryTree()</code>: Constructs a binary tree based on character frequencies.</li>
        </ul>
    </li>
</ul>

<h4>PriorityQueue Class</h4>
<p>The <code>PriorityQueue</code> class implements a priority queue to store nodes of the Binary tree.</p>
<ul>
    <li><strong>Attributes:</strong>
        <ul>
            <li><code>Queue</code>: A priority queue data structure to manage nodes based on their frequencies. Nodes with lower frequencies have higher priority.</li>
        </ul>
    </li>
    <li><strong>Methods:</strong>
        <ul>
            <li><code>generatePQFromBT(Node root)</code>: Converts the binary tree into a priority queue, ensuring nodes with lower frequencies are processed first.</li>
            <li><code>insert(Node node)/((int freq, char data))</code>: Adds a node to the priority queue.</li>
            <li><code>removeMin()</code>: Retrieves and removes the node with the highest priority (i.e., lowest frequency).</li>
        </ul>
    </li>
</ul>

<h4>Huffman Class</h4>
<p>The <code>Huffman</code> class constructs the Huffman tree from the priority queue and generates a Huffman tree and Table.</p>
<ul>
    <li><strong>Attributes:</strong>
        <ul>
            <li><code>Huffman Tree</code>: Construct Huffman tree from the Priority Queue and assigned it to Huffman root node.</li>
                        <li><code>Huffman Table</code>: A mapping of characters to their corresponding Huffman codes.</li>
                    </ul>
                </li>
                <li><strong>Methods:</strong>
                    <ul>
                        <li><code>generateHuffmanTree(PriorityQueue pq)</code>: Constructs the Huffman tree by repeatedly combining the two nodes with the lowest frequencies from the
                          priority queue. A new parent node is created with a frequency equal to the sum of the frequencies of these two child nodes. This process is repeated until only
                          one node remains in the priority queue. The final remaining node represents the root of the Huffman tree.</li>
                        <li><code>generateChart(Node root, String code)</code>: Traverses the Huffman tree to create a Table mapping each character to its Huffman code with there frequency.</li>
                    </ul>
                </li>
            </ul>
            
  <h4>EncodeDecode Class</h4>
  <p>The <code>EncodeDecode</code> class handles encoding and decoding of messages using the Huffman coding Table</p>
  <ul>
      <li><strong>Attributes:</strong>
          <ul>
              <li><code>Encoding Table</code>: A Table or map providing the Huffman code for each character.</li>
          </ul>
      </li>
      <li><strong>Methods:</strong>
          <ul>
              <li><code>encodeData(Map<Character, String> Table, String message)</code>: Encodes the input message using the provided Huffman Table</li>
              <li><code>decodeData(Map<Character, String> Table, String encodedMessage)</code>: Decodes the encoded message back to its original form using the Huffman Table</li>
          </ul>
      </li>
  </ul>


<h3>Running the Project</h3>
  <ol>
      <li><strong>Compile the Project:</strong>
          <p>Ensure you have Java Development Kit (JDK) installed. Compile the Java files using:</p>
          <pre><code>javac -d bin src/huffmancodinglabterminal/GUIFrame/*.java</code></pre>
      </li>
      <li><strong>Run the Main Application:</strong>
          <p>Navigate to the <code>bin</code> directory and run the <code>Main</code> class:</p>
          <pre><code>java huffmancodinglabterminal.GUIFrame.Main</code></pre>
      </li>
  </ol>
  <h2>Network Communication</h2>
  <p>The project uses TCP/IP sockets for network communication:</p>
  <ul>
      <li><strong>Sending Port:</strong> 1256</li>
      <li><strong>Receiving Port:</strong> 1256</li>
  </ul>
  <p>Ensure that the receiving and sending applications are using the same port for communication.</p>

  <h2>Dependencies</h2>
  <ul>
      <li>Java Standard Edition (SE) for GUI and network programming.</li>
      <li><code>javax.swing</code> for GUI components.</li>
      <li><code>java.net</code> for networking.</li>
  </ul>
</body>
</html>
