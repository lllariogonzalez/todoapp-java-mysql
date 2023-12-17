package Dao;

import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;


public class MysqlDb {
    
    Properties config;
    private String password;
    protected Connection conexion = null;
    private String username= "";
    private String database= "";
    private String port = "";
    private String ip= "";
    private String cadena = "";

    public MysqlDb(){
        this.config = ConfigLoader.loadConfig();
        this.password = config.getProperty("db.password");
        this.username = config.getProperty("db.username");
        this.database = config.getProperty("db.database");
        this.port = config.getProperty("db.port");
        this.ip = config.getProperty("db.ip");
        this.cadena = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    }

    public Connection connect(){
        try{
            conexion = DriverManager.getConnection(cadena, username, password);
            // JOptionPane.showMessageDialog(null,"Se conectó correctamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo conectar" + e.toString());
        }
        return conexion;
    }
    
    public void disconnect(){
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
