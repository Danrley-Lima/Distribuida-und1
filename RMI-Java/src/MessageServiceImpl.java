import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import chatbot.ChatBot;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {

    protected MessageServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sendMessage(String message) throws RemoteException {
        ChatBot cBot = new ChatBot();

        System.out.println("Mensagem recebida do cliente: " + message);

        return cBot.Mensagem(message);
        //return "Mensagem recebida com sucesso: " + message;
    }

    public static void main(String[] args) {
        try {
            MessageService messageService = new MessageServiceImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
            registry.rebind("MessageService", messageService);
            System.out.println("Servidor pronto...");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
