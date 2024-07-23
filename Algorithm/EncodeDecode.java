package huffmancodinglabterminal;
//Screen 4
/*It encode Data from Characters to its Proper huffman String using huffmn chart and 
decode from huffman string to actual characters from huffman chart
*/
public class EncodeDecode {
         
    public String decodeData(Node root, String data) {
        Node p = root;
        String s = "";
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '1')
                p = p.right;
            else if (data.charAt(i) == '0')
                p = p.left;
            // is leaf, if leaf then print it
            if (p.left == null && p.right == null) {
                s = s + p.data;
                p = root;
            }
        }
        return s;
    }
    /* make a empty string decodeData to store DecodedData in it pick one huffman string encode character(data) 
    store it in HuffmanCode and compare it with All hufman PathCode if character match 
    any pathcode add its corresponding actual character in decodeData empty the HuffmanCode 
    for the next decode character and if the HuffmanCode dont match with any chart PathCode
    append next inde huffman string character(data) in HuffmanCode and check again with all chart
    path code if again not match with any pathCode again pick another next character from 
    huffman string encoded character(data) and append to huffmanCode and Check Again
     */   
    public String decodeData(String[][]chart,String encodedData) {
//      String chart[][]=Huffman.chart;
//      make a empty string decodeData to store DecodedData in it
        String decodeData="";
        
        String HuffmanCode="";
        for (int i = 0; i < encodedData.length(); i++) {
           // pick one next huffmanEncodedString(data) character and store it in HuffmanCode
            HuffmanCode = HuffmanCode + encodedData.charAt(i);
            for (int j = 0; j < chart.length; j++) {
                //Check if character match any pathcode
               if(HuffmanCode.equals(chart[j][2])){
                    //Add its corresponding actual character in decodeData  
                   decodeData=decodeData+chart[j][0];
                   //empty the HuffmanCode for the next decode character
                   HuffmanCode="";
                   // break because no more checking in Chart as match found
                   break;
               } 
            }
        }
        return decodeData;
    }
    /* make a empty string encodeData to store EncodedData in it 
    Pick one character from decodedData compare it with All hufman charcter 
    if character match with any chart characters 
    Add its corresponding pathcode in encodeData 
    break because no more checking in Chart found
     */
    public String encodeData(String[][] chart,String decodedData) {
//        String chart[][]=Huffman.chart;
        String encodeData="";
        for (int i = 0; i < decodedData.length(); i++) {
            for (int j = 0; j < chart.length; j++) {
               if(Character.toString(decodedData.charAt(i)).equals(chart[j][0])){
                   encodeData=encodeData+chart[j][2];
                   break;
               } 
            }
        }
        return encodeData;
    }
}
