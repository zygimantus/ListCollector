package com.zygimantus.listcollector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(MainApp.class);
        String fxmlFile = "/fxml/hello.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 400, 200);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
}
