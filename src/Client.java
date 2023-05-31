import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() { }
    public static void main(String[] args) {
        try {
            String host = (args.length < 1) ? "127.0.0.1" : args[0];
            Scanner in = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry(host, 1087);
            Replacement stub = (Replacement) registry.lookup("task");
            while (true) {
                System.out.print("Enter a string: ");
                String str = in.nextLine();
                if (str.equals("0")) break;
                String response = stub.replaceAllVowelsOnStars(str);
                System.out.println("Response: " + response);
            }
        } catch (RemoteException | NotBoundException e) { e.printStackTrace(); }
    }
}