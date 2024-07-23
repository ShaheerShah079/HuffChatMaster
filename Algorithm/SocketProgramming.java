package huffmancodinglabterminal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketProgramming{
  //A Test File for Soccket Programming
    public void send() throws IOException
    {
        try{
            Socket s = new Socket("127.0.0.1", 1256);
            ObjectOutputStream outObj = new ObjectOutputStream(s.getOutputStream());
            String [][] str2= {{"S","00"},{"A","11"},{"M","100"}};
            BigInteger big =new BigInteger("101010101010101010101010101");
            outObj.writeObject(str2);
            outObj.writeObject(big);
              outObj.close();
              s.close();
        }
        catch (Exception ex)
        {
          ex.getMessage();
          System.out.println("error sender");
        }
    }

}
