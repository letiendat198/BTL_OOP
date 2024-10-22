package btl.weather;

import atlantafx.base.theme.PrimerLight;
import btl.weather.api.OpenMeteo;
import btl.weather.api.OpenMeteoHourlyOptions;
import btl.weather.api.OpenMeteoOptions;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class ApplicationMain extends Application{
    private static final Logger logger = LogManager.getLogger("MAIN");

    Scene scene;
    VBox view = new VBox();

    @Override
    public void start(Stage stage){
        setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

        stage.setTitle("Weather");

        OpenMeteoHourlyOptions hourlyOptions = new OpenMeteoHourlyOptions();
        hourlyOptions.addParams(new String[]{"temperature_2m", "relative_humidity_2m", "apparent_temperature"});
        OpenMeteoOptions options = new OpenMeteoOptions(21.0278f, 105.8342f);
        options.setHourlyOptions(hourlyOptions);
        OpenMeteo openMeteo = new OpenMeteo(options);
        
        try{
            Map<String, Object> forecast = openMeteo.fetch();
            logger.info(forecast.get("hourly"));
        }
        catch(Exception e){
            logger.error(e);
        }

        view.setAlignment(Pos.CENTER);
        view.setSpacing(10);

        scene = new Scene(view, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void run() {
        launch();
    }
}