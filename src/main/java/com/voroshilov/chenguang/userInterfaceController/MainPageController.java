package com.voroshilov.chenguang.userInterfaceController;

import com.voroshilov.chenguang.constant.PathConstants;
import com.voroshilov.chenguang.constant.TitleConstants;
import com.voroshilov.chenguang.model.Task;
import com.voroshilov.chenguang.service.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MainPageController {

    @FXML
    private ListView<String> taskListView;

    @FXML
    private TextArea taskDescriptionArea;

    @FXML
    private Button goToFormCreateNewTask;

    private final TaskService taskService;

    private List<Task> taskList;

    @Autowired
    public MainPageController(TaskService taskService) {
        this.taskService = taskService;
    }

    @FXML
    public void initialize() {
        taskList = taskService.getAll();

        ObservableList<String> taskNames = FXCollections.observableArrayList();
        for (Task task : taskList) {
            taskNames.add(task.getName());
        }

        taskListView.setItems(taskNames);

        taskListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Task selectedTask = taskList.stream()
                        .filter(task -> task.getName().equals(newSelection))
                        .findFirst()
                        .orElse(null);

                if (selectedTask != null) {
                    taskDescriptionArea.setText(selectedTask.getDescription() != null ? selectedTask.getDescription() : "");
                } else {
                    taskDescriptionArea.clear();
                }
            } else {
                taskDescriptionArea.clear();
            }
        });

        MainUserInterfaceController mainUserInterfaceController = new MainUserInterfaceController();

        goToFormCreateNewTask.setOnAction(event -> {
            try {
                mainUserInterfaceController.switchScene(event, TitleConstants.NEW_TASK_PAGE_TITLE, PathConstants.NEW_TASK_PAGE_PATH);
            } catch (IOException e) {
                /* ToDo normal exception handler for this */
                e.printStackTrace();
            }
        });

    }


}
