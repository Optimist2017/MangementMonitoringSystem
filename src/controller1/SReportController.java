package controller1;

import controller.WReportController;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SReportController {

    @FXML
    private Button btnload;
    @FXML private BarChart<String,Double> barchart;


    private Connection connextion;

    @FXML private void initialize(){
        load();
    }


    @FXML private void load(){



        try {
            String query="select time,amount from CartSold order by time asc";

            XYChart.Series<String,Double> series =  new XYChart.Series<>();

            connextion = connectdb();

            ResultSet rs=connextion.createStatement().executeQuery(query);

            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getDouble(2)));

            }
            barchart.getData().add(series);

        } catch (SQLException e) {
            System.out.println("Problem at load function");
            e.printStackTrace();
        }


    }
    private Connection connectdb(){

        try {

            String dbstring="jdbc:mysql://localhost:3306/project";
            String user="root";
            String password="";
            Connection conn= DriverManager.getConnection(dbstring,user,password);
            System.out.println("Connection okay");
            return conn;
        } catch (SQLException e) {
            Logger.getLogger(WReportController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }
        return null;
    }


}
