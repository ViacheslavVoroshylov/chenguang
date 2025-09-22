package com.voroshilov.chenguang.userInterfaceController;

import com.voroshilov.chenguang.constant.PathConstants;
import com.voroshilov.chenguang.constant.TitleConstants;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

public class MainUserInterfaceController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScene(ActionEvent event, String nameScene, String namePath) throws IOException {
        root = FXMLLoader.load(getClass().getResource(namePath));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(nameScene);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
