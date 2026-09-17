import java.io.*;
import java.net.*;

public class ClientUDP
{
	public static void main(String[] args)
	{
		try
		{
			InetAddress addr = InetAddress.getLocalHost();
			String s = "Hello World";
			byte[] data = s.getBytes();

			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
			DatagramSocket sock = new DatagramSocket();
			sock.send(packet);

			byte[] bufferReponse = new byte[1024];
			DatagramPacket packetReponse = new DatagramPacket(bufferReponse, bufferReponse.length);
			sock.receive(packetReponse);

			String recu = new String(packetReponse.getData(), 0, packetReponse.getLength());
			System.out.println("Reponse recue du serveur :" + recu);

			sock.close();
		}
		catch (Exception ex)
		{
			System.out.println("Erreur client UDP");
			ex.printStackTrace();
		}
	}
}
