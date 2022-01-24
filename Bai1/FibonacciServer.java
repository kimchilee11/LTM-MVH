package Bai1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FibonacciServer {
	public static void main(String[] args){
		try (DatagramSocket serverSocket = new DatagramSocket(7979)){
			System.out.println("Server is started!");
			while(true) {
				byte[] receiveData = new byte[4096];
	            byte[] sendData;
	            
	            DatagramPacket receivePacket = 
	            		new DatagramPacket(receiveData, receiveData.length); 

	            serverSocket.receive(receivePacket);

	            InetAddress IPAddress = receivePacket.getAddress();
	            int port = receivePacket.getPort(); 
	            
	            String rq = new String(receivePacket.getData());
				String st = rq.trim();
	            String s = isFibonacci(Integer.parseInt(st)) ? "La so Fibonacci" : "Khong phai so Fibonacci";

				sendData = s.trim().getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

	            serverSocket.send(sendPacket); 
			}
		} catch (IOException e) {
			
		}
		
	}
	
    static  boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }
      
    static boolean isFibonacci(int n)
    {
        return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
    }
}
