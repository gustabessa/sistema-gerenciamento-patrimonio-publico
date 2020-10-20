/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gusta
 */
public class MDTableModel extends AbstractTableModel {
    private List<MovimentacaoDono> listaDeMovDono;
    private final String[] colunas = {"Ambiente", "Dono Origem", "Dono Destino", "Data"};
    

    public MDTableModel() {
        this.listaDeMovDono = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public MovimentacaoDono get(int rowIndex) {
        return this.listaDeMovDono.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param RA
     */
    public void add(MovimentacaoDono MD) {
        this.listaDeMovDono.add(MD);
        fireTableDataChanged();
    }
    

    /**
     * Remove uma cidade da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void remove(int rowIndex) {
        this.listaDeMovDono.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeMovDono.size();
    }

    /**
     * Retorna o numero de colunas da tabela
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o valor especifico de uma celula
     *
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {

            case 0:
                return this.listaDeMovDono.get(rowIndex).getAmbiente().getDescricao();

            case 1:
                return this.listaDeMovDono.get(rowIndex).getOrigem().getNome();

            case 2:
                return this.listaDeMovDono.get(rowIndex).getDestino().getNome();
                
            case 3:
                return this.listaDeMovDono.get(rowIndex).getData_criacao();
                

            default:
                return this.listaDeMovDono.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
    

