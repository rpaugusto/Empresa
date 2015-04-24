/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.ModFornecedor;
import config.Conect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author rui
 */
public class ConFornecedor {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insert(ModFornecedor obj) throws SQLException {

        Conect con = new Conect();

        this.sql = "INSERT INTO fornecedores (nome, endereco, bairro, cidade, uf,"
                + " telefone, cnpj, ie) VALUES (?, ?, ?, ?, ?, ?, ?, ? )";

        this.ps = con.openCon().prepareCall(this.sql);
        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getEndereco());
        this.ps.setString(3, obj.getBairro());
        this.ps.setString(4, obj.getCidade());
        this.ps.setString(5, obj.getUf());
        this.ps.setString(6, obj.getTelefone());
        this.ps.setString(7, obj.getCnpj());
        this.ps.setString(8, obj.getIe());
        
        //con.cloCon();

        return this.ps.executeUpdate() > 0;
    }

    public boolean update(ModFornecedor obj) throws SQLException {

        Conect con = new Conect();

        this.sql = "UPDATE fornecedores SET (nome = ?, endereco = ?, bairro = ?,"
                + " cidade = ?, uf = ?, telefone = ?, cnpj = ?, ie = ? )"
                + " WHERE (id = ?)";

        this.ps = con.openCon().prepareCall(this.sql);
        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getEndereco());
        this.ps.setString(3, obj.getBairro());
        this.ps.setString(4, obj.getCidade());
        this.ps.setString(5, obj.getUf());
        this.ps.setString(6, obj.getTelefone());
        this.ps.setString(7, obj.getCnpj());
        this.ps.setString(8, obj.getIe());
        
        con.cloCon();

        return this.ps.executeUpdate() > 0;
    }

    public boolean delete() throws SQLException {

        Conect con = new Conect();

        return this.ps.executeUpdate() > 0;
    }

    public ModFornecedor select(String valor) throws SQLException {

        ModFornecedor obj = null;

        Conect con = new Conect();

        this.sql = "SELECT * FROM fornecedores";
            this.sql += " WHERE cnpj = ? ";
       
        this.ps = con.openCon().prepareStatement(sql);
        this.ps.setString(1, valor);
        
        this.rs = this.ps.executeQuery();

        if (rs.next()) {
            obj = new ModFornecedor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("uf"),
                    rs.getString("telefone"),
                    rs.getString("cnpj"),
                    rs.getString("ie")
            );

        }
        
        //con.cloCon();
        
        return obj;
    }

    public ArrayList<ModFornecedor> selectAll() throws SQLException {

        ModFornecedor obj = null;

        Conect con = new Conect();

        ArrayList<ModFornecedor> lsFor = new ArrayList<>();

        this.sql = "SELECT * FROM fornecedores";
        this.ps = con.openCon().prepareStatement(sql);
        
        this.rs = this.ps.executeQuery();

        if (rs != null) {
            while (rs.next()) {
                obj = new ModFornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("telefone"),
                        rs.getString("cnpj"),
                        rs.getString("ie")
                );
                lsFor.add(obj);
            }
            return lsFor;
        }

        return null;
    }

}
