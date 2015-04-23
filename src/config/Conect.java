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

/**
 *
 * @author rui
 */
public class Conect {
    
    
    private String drive = "org.postgresql.driver";
    private String host  = "127.0.0.1"; //endereço ip do servidor
    private String port  = "5432";      //porta de comunicação com o banco de dados
    private String base  = "estoque";   //nome da base de dados
    private String user  = "root";      //usuario para logar no banco
    private String pass  = "965839";    //senha para logar no banco
    private String url   = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.base ;
    
    private static Connection con;
    
    public Conect(){
        
        try{
            try {
                Class.forName(this.drive);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(this.url, this.user, this.pass);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar!\nError: "+ ex.getMessage(), "Conexao",3);
        }

    }
    
    public Connection getCon(){
        return con;
    }
    
    
    
}
