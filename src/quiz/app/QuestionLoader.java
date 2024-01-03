package quiz.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class QuestionLoader {
    private static final String API_ENDPOINT = "https://quizapi.io/api/v1/questions";

    public List<QuizQuestion> loadQuestionsFromApi() {
        try {
            URL url = new URL(API_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                // Parse the JSON response and return a list of QuizQuestion objects
                return parseJsonResponse(response.toString());
            } else {
                System.out.println("Failed to fetch questions. Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<QuizQuestion> parseJsonResponse(String jsonResponse) {
        // Use a JSON library to parse the response and create QuizQuestion objects
        // Implement this method based on the structure of the API response
        // ...

        return null;  // Replace with the actual list of QuizQuestion objects
    }
}

