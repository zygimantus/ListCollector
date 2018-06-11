package com.zygimantus.listcollector;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    private static final BorderPane ROOT = new BorderPane();

    private ConfigurableApplicationContext springContext;

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(MainApp.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");

        URL menuBarUrl = getClass().getResource("/fxml/Menu.fxml");
        MenuBar bar = FXMLLoader.load(menuBarUrl);

        String fxmlFile = "/fxml/hello.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        fxmlLoader.setControllerFactory(springContext::getBean);
        Parent pane = fxmlLoader.load();

        ROOT.setTop(bar);
        ROOT.setCenter(pane);

        log.debug("Showing JFX scene");
        Scene scene = new Scene(ROOT, 640, 480);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
}
