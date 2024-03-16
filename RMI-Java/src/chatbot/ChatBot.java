package chatbot;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatBot {

    private ArrayList<Menssage> menssages;


    public ChatBot(){
        menssages = new ArrayList<>();
        uploadMenssges();
    }

    public String Mensagem(String userMenssage){
        String output = "Não entendi";
        
        for (Menssage menssage : menssages) {
            if (menssage.getInput().equals(userMenssage)) {
                output = menssage.getOutput();
                break;
            }
        }

        return output;
    }

    public void uploadMenssges() {
        try {

            File file = new File("auxiliar/menssage.txt");
		    Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String recuperar = scan.nextLine();
                
                String[] dadosMenssage = recuperar.split(";");
                Menssage m = new Menssage(dadosMenssage[0],dadosMenssage[1]);
                
                menssages.add(m);
            }
            
            scan.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
