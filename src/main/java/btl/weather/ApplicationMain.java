package btl.weather;

import atlantafx.base.theme.PrimerLight;
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


public class ApplicationMain extends Application{
    private static final Logger logger = LogManager.getLogger("MAIN");

    Scene scene;
    VBox view = new VBox();

    @Override
    public void start(Stage stage){
        setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

        stage.setTitle("Weather");

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