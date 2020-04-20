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
import model.SaleEmployees;
import model.Saleslog;

import java.sql.Timestamp;
import java.text.DateFormat;


public class SalesLogController {

    @FXML private TableView<Saleslog> table;
    @FXML private TableColumn<Saleslog, Timestamp> timeColumn;
    @FXML private TableColumn<Saleslog, SaleEmployees> userColumn;
    @FXML private TableColumn<Saleslog, String> actionColumn;

    public void initialize(){
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));


        userColumn.setCellFactory(new Callback<TableColumn<Saleslog, SaleEmployees>, TableCell<Saleslog, SaleEmployees>>() {
            @Override
            public TableCell<Saleslog, SaleEmployees> call(TableColumn<Saleslog, SaleEmployees> param) {
                return new TableCell<Saleslog,SaleEmployees>(){
                    @Override
                    protected void updateItem(SaleEmployees item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(item == null || empty ? null : item.getFullname());

                    }
                };
            }
        });


          timeColumn.setCellFactory(new Callback<TableColumn<Saleslog, Timestamp>, TableCell<Saleslog, Timestamp>>() {
              @Override
              public TableCell<Saleslog, Timestamp> call(TableColumn<Saleslog, Timestamp> param) {
                  return new TableCell<Saleslog,Timestamp>(){
                      @Override
                      protected void updateItem(Timestamp item, boolean empty) {
                          super.updateItem(item, empty);
                          if (item==null|| empty)
                             setText(null);
                          else
                             setText(DateFormat.getDateTimeInstance().format(item));

                      }
                  };
              }
          });



        table.getItems().addAll(DBManager.listAll(Saleslog.class));
    }




}
