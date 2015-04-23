/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.ModCliente;
import config.Conect;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rui
 */
public class ConCliente {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insert(ModCliente obj) throws SQLException {

        Conect con = new Conect();

        this.sql = "INSERT INTO pessoas (nome, rg, cpf, endereco, bairro, "
                + "cidade, telefone, celular, renda) "
                + "VALUES (?,?,?,?,?,?,?,?,?) ";

        this.ps = con.getCon().prepareStatement(this.sql);
        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getRg());
        this.ps.setString(3, obj.getCpf());
        this.ps.setString(4, obj.getEndereco());
        this.ps.setString(5, obj.getBairro());
        this.ps.setString(6, obj.getCidade());
        this.ps.setString(7, obj.getTelefone());
        this.ps.setString(8, obj.getCelular());
        this.ps.setDouble(9, obj.getRenda());

        return this.ps.executeUpdate() > 0;
    }

    
    public ModCliente select(String argumento) throws SQLException {

        ModCliente obj = null;
        Conect con = new Conect();

        this.sql = "SELECT * FROM clientes" + argumento;

        this.ps = con.getCon().prepareStatement(this.sql);
        //this.ps.setString(1, cpf);
        this.rs = this.ps.executeQuery();
        if (rs.next()) {
            obj = new ModCliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getDouble("renda")
            );
        }
        return obj;

    }

    public boolean update(ModCliente obj) throws SQLException {

        Conect con = new Conect();

        this.sql = "UPDATE pessoas SET (nome = ?, rg = ?, cpf = ?, endereco = ?, "
                + "bairro = ?, cidade = ?, telefone = ?, celular = ?, renda = ?) "
                + "WHERE (id = ? and cpf = ?) ";

        this.ps = con.getCon().prepareStatement(this.sql);
        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getRg());
        this.ps.setString(3, obj.getCpf());
        this.ps.setString(4, obj.getEndereco());
        this.ps.setString(5, obj.getBairro());
        this.ps.setString(6, obj.getCidade());
        this.ps.setString(7, obj.getTelefone());
        this.ps.setString(8, obj.getCelular());
        this.ps.setDouble(9, obj.getRenda());
        this.ps.setInt(10, obj.getId());
        this.ps.setString(11, obj.getCpf());

        return this.ps.executeUpdate() > 0;
    }

    public boolean delete(ModCliente obj) throws SQLException {

        Conect con = new Conect();

        this.sql = "DELETE FOM pessoas WHERE id = ?";

        this.ps = con.getCon().prepareStatement(this.sql);
        this.ps.setInt(1, obj.getId());

        return this.ps.executeUpdate() > 0;

    }

}
