package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.component.Constellation_match;
import sample.component.Constellation_search;
import sample.component.Window;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox sex;
    @FXML
    private ComboBox month;
    @FXML
    private ComboBox day;
    @FXML
    private ComboBox match_man_month;
    @FXML
    private ComboBox match_man_day;
    @FXML
    private ComboBox match_women_month;
    @FXML
    private ComboBox match_women_day;
    @FXML
    private TextArea constellation_description;
    @FXML
    private TextArea constellation_match_info;
    @FXML
    private TextArea test;
    @FXML
    private Label constellation_point;

    // Search
    private String sex_selected;
    private String month_selected;
    private String day_selected;
    // Match
    private String man_month;
    private String man_day;
    private String women_month;
    private String women_day;

    @FXML
    public void add_option() throws Exception {
        // DONE Define ComboBox options
        ArrayList<String> month_list = new ArrayList<>();
        ArrayList<String> day_list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) month_list.add(String.format("%02d月", i));
        for (int i = 1; i <= 31; i++) day_list.add(String.format("%02d日", i));
        String[] sex_list = {"男", "女"};

        // DONE ComboBox add the Items
        sex.setItems(FXCollections.observableArrayList(sex_list));
        month.setItems(FXCollections.observableArrayList(month_list));
        day.setItems(FXCollections.observableArrayList(day_list));
        match_man_month.setItems(FXCollections.observableArrayList(month_list));
        match_man_day.setItems(FXCollections.observableArrayList(day_list));
        match_women_month.setItems(FXCollections.observableArrayList(month_list));
        match_women_day.setItems(FXCollections.observableArrayList(day_list));

        // DONE Add The ComboBox Listener
        sex.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.sex_selected = sex_list[newValue.intValue()];
//            System.out.println(sex_list[newValue.intValue()]);
        });
        month.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.month_selected = month_list.get(newValue.intValue());
        });
        day.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.day_selected = day_list.get(newValue.intValue());
        });
        match_man_month.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.man_month = month_list.get(newValue.intValue());
        });
        match_man_day.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.man_day = day_list.get(newValue.intValue());
        });
        match_women_month.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.women_month = month_list.get(newValue.intValue());
        });
        match_women_day.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            this.women_day = day_list.get(newValue.intValue());
        });
    }

    @FXML
    public void search_constellation() throws Exception {
        // DONE Search Constellation
        Boolean is_finish = this.day_selected == null || this.month_selected == null || this.sex_selected == null;
        if (is_finish) {
            Window window = new Window();
            window.alert("请填写完整的信息！");
        } else {
            String month = this.month_selected.replace('月', ' ').trim();
            String day = this.day_selected.replace('日', ' ').trim();
            String birthday = month + "-" + day;

            Constellation_search constellation_search = new Constellation_search();
            constellation_description.setText(constellation_search.show_constellation(birthday));
        }
    }

    @FXML
    public void match_constellation() throws Exception {
        // DONE Match constellation
        Boolean is_finish = this.man_month == null || this.man_day == null || this.women_month == null || this.women_day == null;
        if (is_finish) {
            Window window = new Window();
            window.alert("请填写完整的信息！");
        } else {
            // DONE define variable
            String m_month = this.man_month.replace('月', ' ').trim();
            String m_day = this.man_day.replace('日', ' ').trim();
            String w_month = this.women_month.replace('月', ' ').trim();
            String w_day = this.women_day.replace('日', ' ').trim();
            String man_birthday = m_month + "-" + m_day;
            String women_birthday = w_month + "-" + w_day;

            // DONE import class
            Constellation_search constellation_search = new Constellation_search();
            Constellation_match constellation_match=new Constellation_match();

            // DONE get the man or women constellation
            String man_constellation=constellation_search.filter_constellation(man_birthday);
            String women_constellation=constellation_search.filter_constellation(women_birthday);

            // DONE show the info
            constellation_point.setText("配对指数："+constellation_match.constellation_point("男"+man_constellation,"女"+women_constellation));
            constellation_match_info.setText(constellation_match.constellation_match(man_constellation,women_constellation));
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            add_option();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
