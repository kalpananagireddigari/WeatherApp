import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApp {

    public static void main(String[] args) {
        try {

            String apiKey = "31ea82ccd5bb78d185593e1f8c9d6b45";  // Put your API key
            String city = "Hyderabad";

            String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

           String temp = json.split("\"temp\":")[1].split(",")[0];

           String humidityPart = json.split("\"humidity\":")[1];
           String humidity = humidityPart.split(",")[0];

String weatherPart = json.split("\"description\":\"")[1];
String weather = weatherPart.split("\"")[0];

            System.out.println("\n===== WEATHER REPORT =====");
            System.out.println("City: " + city);
            System.out.println("Temperature: " + temp + " °C");
            System.out.println("Humidity: " + humidity + " %");
            System.out.println("Weather: " + weather);
            System.out.println("==========================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}