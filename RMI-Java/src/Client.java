import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost");
      MessageService messageService = (MessageService) registry.lookup("MessageService");
      boolean connect = true;
      while (connect) {

        Scanner sc = new Scanner(System.in);

	      System.out.print("Usuario: ");
	      String userMenssage = sc.nextLine();

        String response = messageService.sendMessage(userMenssage);
        System.out.println("Resposta do servidor: " + response);

        if (response.equals("Tchau") ) {
          connect = false;
        }
      }

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
  }
}
