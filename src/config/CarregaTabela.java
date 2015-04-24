/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rui
 */
public class CarregaTabela extends AbstractTableModel{
    
    private ArrayList linha = null;
    private String[] coluna = null;

    public CarregaTabela(ArrayList lin, String[] col) {
        setLinha(lin);
        setColuna(col);
    }
    
    public ArrayList getLinhas(){
        return this.linha;
    }
    
    public void setLinha(ArrayList linhas){
        this.linha = linhas;
    }

    public String[] getColunas() {
        return coluna;
    }

    public void setColuna(String[] colunas) {
        this.coluna = colunas;
    }
    
    public int getColumnCount(){
        return coluna.length;    
    }
    
    public int getRowCount(){
        return linha.size();
    }
    
    public String getColumName(int numCol){
        return coluna[numCol];
    }
    
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
}
