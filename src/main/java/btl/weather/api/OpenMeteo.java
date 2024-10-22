package btl.weather.api;

import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class OpenMeteo {
    private static final Logger logger = LogManager.getLogger("MAIN");
    private OpenMeteoOptions options;
    private HttpClient httpClient;

    public OpenMeteo(OpenMeteoOptions options){
        this.options = options;

        httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.of(60, ChronoUnit.SECONDS))
                .build();
    }

    public Map<String, Object> fetch() throws IOException, URISyntaxException, InterruptedException {
        logger.info(options.toURI());
        HttpRequest request = HttpRequest.newBuilder().uri(options.toURI()).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        logger.info(response.body());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), Map.class);
    }

    class hourlyForecast{

    }
}
