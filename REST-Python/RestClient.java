import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RestClient {
    public static void main(String[] args) {
    Boolean end = true;
    try {
      URI uri = new URI("http://localhost:8888/mensagem");
      Scanner scanner = new Scanner(System.in);
      HttpClient client = HttpClient.newHttpClient();

      while (end) {
        System.out.print("Digite sua mensagem: ");
        String userInput = scanner.nextLine();

        if (userInput.equals("tt")) {
          end = false;
          continue;
        }

        String requestBody = String.format("{\"mensagem\":\"%s\"}", userInput);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(String.format("Resposta do servidor: %s", response.body()));
      }
      scanner.close();

    } catch (IOException | InterruptedException | URISyntaxException e) {
      e.printStackTrace();
    }
  }
}
