package SingleThreaded;

import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
  
  public void run() throws UnknownHostException, IOException {
    int port = 8010;
    InetAddress address = InetAddress.getByName("localhost");
    Socket socket = new Socket(address, port);
    PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
    BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    toSocket.println("Hello from the client!");
    String response = fromSocket.readLine();
    System.out.println("Response from server: " + response);
    toSocket.close();
    fromSocket.close();
    socket.close();

  }

  public static void main(String[] args) {
    System.out.println("Client is running...");
    Client client = new Client();
    try{
      client.run();
    }catch (UnknownHostException e){
      e.printStackTrace();
    }catch (IOException e){
      e.printStackTrace();

    }
  }
  
}