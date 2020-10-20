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
public class RATableModel extends AbstractTableModel {
    private List<RevisaoAnual> listaDeRevisoes;
    private final String[] colunas = {"Código", "Servidor", "Ambiente", "Data Criação", "Data Modificação", "Estado"};
    

    public RATableModel() {
        this.listaDeRevisoes = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public RevisaoAnual get(int rowIndex) {
        return this.listaDeRevisoes.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param RA
     */
    public void add(RevisaoAnual RA) {
        this.listaDeRevisoes.add(RA);
        fireTableDataChanged();
    }
    

    /**
     * Remove uma cidade da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void remove(int rowIndex) {
        this.listaDeRevisoes.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeRevisoes.size();
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
                return this.listaDeRevisoes.get(rowIndex).getId();

            case 1:
                return this.listaDeRevisoes.get(rowIndex).getServidor().getNome();

            case 2:
                return this.listaDeRevisoes.get(rowIndex).getAmbiente().getDescricao();
                
            case 3:
                return this.listaDeRevisoes.get(rowIndex).getData_criacao();
                
            case 4:
                return this.listaDeRevisoes.get(rowIndex).getData_modificacao();
             
            case 5:
                return this.listaDeRevisoes.get(rowIndex).getEstado();

            default:
                return this.listaDeRevisoes.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
    

