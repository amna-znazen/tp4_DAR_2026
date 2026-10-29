package serveur;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
public class chatserver1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(new InetSocketAddress(1234));
        System.out.println("Serveur démarré sur le port 1234");
        byte[] buffer = new byte[1024];
        while(true){
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message reçu de " + packet.getAddress() + ":" + packet.getPort() + " -> " + msg);
        }
    }
}