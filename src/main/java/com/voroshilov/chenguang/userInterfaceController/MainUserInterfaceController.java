package com.voroshilov.chenguang.userInterfaceController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class MainUserInterfaceController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void  swithToMainPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/templates/mainPage.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Main page");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void  swithToNewTaskPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/templates/newTask.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("New Task");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
