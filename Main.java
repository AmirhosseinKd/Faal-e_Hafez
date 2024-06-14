import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FalOnline {

    public static void main(String[] args) throws IOException, ParseException {

        String urlString = "https://faal.spclashers.workers.dev/api";


        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());


        String poem = (String) jsonObject.get("Poem");
        String interpretation = (String) jsonObject.get("Interpretation");
        System.out.println("شعر:");
        System.out.println(poem);
        System.out.println("\nتفسیر:");
        System.out.println(interpretation);
    }
}