package com.zygimantus.listcollector;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Zygimantus
 */
public class MenuController {

    @FXML
    protected void processExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
