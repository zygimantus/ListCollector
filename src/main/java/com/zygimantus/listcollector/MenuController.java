package com.zygimantus.listcollector;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Zygimantus
 */
public class MenuController {

    @FXML
    private MenuBar menuBar;

    @FXML
    protected void processExit(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to exit?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    protected void newBooksList(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/BooksList.fxml"));
        ((BorderPane) menuBar.getScene().getRoot()).setCenter(root);
    }

    @FXML
    protected void newMoviesList(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoviesList.fxml"));
        ((BorderPane) menuBar.getScene().getRoot()).setCenter(root);

    }

}
