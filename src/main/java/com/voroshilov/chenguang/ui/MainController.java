package com.voroshilov.chenguang.ui;

import com.voroshilov.chenguang.model.Task;
import com.voroshilov.chenguang.service.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainController {

    @FXML
    private ListView<String> taskListView;

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @FXML
    public void initialize() {
        List<Task> taskList = taskService.getAll();
        ObservableList<String> taskNames = FXCollections.observableArrayList();

        for (Task task : taskList) {
            taskNames.add(task.getName());
        }

        taskListView.setItems(taskNames);
    }
}
