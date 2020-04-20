package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IreportController {
    @FXML private PieChart wpiechart;
    @FXML private PieChart spiechart;

    private Connection connextion;
    private PreparedStatement ps;

    ObservableList<PieChart.Data> piechartdata;
    ObservableList<PieChart.Data> piechartdata1;

    ArrayList<Integer> quantity=new ArrayList<>();
    ArrayList<String> productname= new ArrayList<>();
    ResultSet rs;

    ArrayList<Integer> quantity1=new ArrayList<>();
    ArrayList<String> productname1= new ArrayList<>();
    ResultSet rs1;

    @FXML private void initialize(){
        connectdb();
        wpiechart.setData(piechartdata);
        connect1db();
        spiechart.setData(piechartdata1);
    }


    private void connect1db(){
        piechartdata1= FXCollections.observableArrayList();

        try {

            String dbstring="jdbc:mysql://localhost:3306/project";
            String user="root";
            String password="";
            Connection conn= DriverManager.getConnection(dbstring,user,password);
            System.out.println("Connection okay");
            String query="select * from Inventory";
//            conn.prepareStatement("select productname,quantity from Product");
            rs1=conn.createStatement().executeQuery(query);

            while (rs1.next()){
                piechartdata1.add(new PieChart.Data(rs1.getString("product"),rs1.getDouble("quantity")));
                productname1.add(rs1.getString("product"));
                quantity1.add(rs1.getInt("quantity"));
            }


        } catch (SQLException e) {
            Logger.getLogger(WReportController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }

    }

    private void connectdb(){
        piechartdata= FXCollections.observableArrayList();

        try {

            String dbstring="jdbc:mysql://localhost:3306/project";
            String user="root";
            String password="";
            Connection conn= DriverManager.getConnection(dbstring,user,password);
            System.out.println("Connection okay");
            String query="select * from Product";
//            conn.prepareStatement("select productname,quantity from Product");
            rs=conn.createStatement().executeQuery(query);

            while (rs.next()){
                piechartdata.add(new PieChart.Data(rs.getString("productname"),rs.getDouble("quantity")));
                productname.add(rs.getString("productname"));
                quantity.add(rs.getInt("quantity"));
            }


        } catch (SQLException e) {
            Logger.getLogger(WReportController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }

    }

}
