package com.zygimantus.listcollector;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooksListController {

    private static final Logger log = LoggerFactory.getLogger(BooksListController.class);

    @FXML
    private TextField url;

    public void submit() {

        String urlValue = url.getText();
        log.info("Your have entered: " + urlValue);
    }

}
