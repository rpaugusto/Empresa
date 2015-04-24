/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author rui
 */
public class Conect {

    private String driver = "org.postgresql.driver";
    private String host = "127.0.0.1"; //endereço ip do servidor
    private String port = "5432";      //porta de comunicação com o banco de dados
    private String base = "estoque";   //nome da base de dados
    private String user = "root";      //usuario para logar no banco
    private String pass = "965839";    //senha para logar no banco
    private String url = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.base;

    public Connection con;

    public Connection openCon() {
        try {
            System.setProperty("jdbc.Drivers", this.driver);
            con = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());
        }

        return con;
    }

    public void cloCon() {

        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
