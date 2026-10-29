package client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class chatclient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom utilisateur : ");
        String user = sc.nextLine();
        while(true){
            System.out.print("Message : ");
            String texte = sc.nextLine();
            if(texte.equalsIgnoreCase("exit")){
                System.out.println("Client arrêté.");
                break;
            }
            String msg = "[" + user + "] : " + texte;
            byte[] data = msg.getBytes();
            DatagramPacket packet =
                    new DatagramPacket(
                            data,
                            data.length,
                            InetAddress.getByName("localhost"),
                            1234);
            socket.send(packet);}
        socket.close();}
}