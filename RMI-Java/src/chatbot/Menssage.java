package chatbot;

public class Menssage {

    private String input;
    private String output;

    public Menssage (String in, String out){
        this.input = in;
        this.output = out;
    }

    public String getInput(){
        return input;
    }

    public void setInput(String newIn){
        this.input = newIn;
    }

    public String getOutput(){
        return output;
    }

    public void setOutput(String newOut){
        this.output = newOut;
    }

}
