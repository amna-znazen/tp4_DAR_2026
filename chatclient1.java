package client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class chatclient1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom utilisateur : ");
        String user = sc.nextLine();
        while(true){
            String texte = sc.nextLine();
            if(texte.equalsIgnoreCase("exit")){
                System.out.println("Déconnexion...");
                socket.close();
                break;
            }
            String msg = "[" + user + "] : " + texte;
            byte[] data = msg.getBytes();
            DatagramPacket packet =new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1234);
            socket.send(packet);
        }
    }
}