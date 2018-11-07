package sample.component;

import javafx.scene.control.Alert;

import java.util.*;

public class Window {
    public Window() {

    }

    public void alert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("我是弹窗~");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
