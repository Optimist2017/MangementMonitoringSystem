package controller;

import business.DBManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Employees;
import model.Log;

import java.sql.Timestamp;
import java.text.DateFormat;


public class LogController {

    @FXML private TableView<Log> table;
    @FXML private TableColumn<Log, Timestamp> timeColumn;
    @FXML private TableColumn<Log, Employees> userColumn;
    @FXML private TableColumn<Log, String> actionColumn;

    public void initialize(){
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));

         userColumn.setCellFactory(new Callback<TableColumn<Log, Employees>, TableCell<Log, Employees>>() {
             @Override
             public TableCell<Log, Employees> call(TableColumn<Log, Employees> param) {
                 return new TableCell<Log,Employees>(){
                     @Override
                     protected void updateItem(Employees item, boolean empty) {
                         super.updateItem(item, empty);
                         setText(item==null || empty ? null : item.getFullname());
                     }
                 };
             }
         });

        timeColumn.setCellFactory(new Callback<TableColumn<Log, Timestamp>, TableCell<Log, Timestamp>>() {
            @Override
            public TableCell<Log, Timestamp> call(TableColumn<Log, Timestamp> param) {
                return new TableCell<Log, Timestamp>(){
                    @Override
                    protected void updateItem(Timestamp item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item==null || empty)
                            setText(null);
                        else
                            setText(DateFormat.getDateTimeInstance().format(item));

                    }
                };
            }
        });



        table.getItems().addAll(DBManager.listAll(Log.class));
    }




}
