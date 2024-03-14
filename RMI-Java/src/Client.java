import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost");
      MessageService messageService = (MessageService) registry.lookup("MessageService");
      String response = messageService.sendMessage("Olá, servidor!");
      System.out.println("Resposta do servidor: " + response);
    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
  }
}
