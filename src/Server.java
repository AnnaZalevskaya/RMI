import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Replacement {
    public static void main(String[] args) {
        Server server = new Server();
        try {
            Replacement stub = (Replacement) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1087);
            registry.bind("task", stub);
            System.out.println("Server is ready");
        } catch (RemoteException | AlreadyBoundException e) { e.printStackTrace(); }
    }

    @Override public String replaceAllVowelsOnStars(String str) {
        String regex = "[aeiouаеоуыэияюё]";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String s = "" + c;
            if (s.matches(regex)){
                output.append('*');
            }
            else { output.append(c); }
        }
        return output.toString();
    }
}