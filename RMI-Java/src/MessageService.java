import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageService extends Remote {
  String sendMessage(String message) throws RemoteException;
}
