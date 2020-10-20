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
public class MITableModel extends AbstractTableModel {
    private List<MovimentacaoItem> listaDeMovItem;
    private final String[] colunas = {"Item", "Ambiente Origem", "Ambiente Destino", "Data"};
    

    public MITableModel() {
        this.listaDeMovItem = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public MovimentacaoItem get(int rowIndex) {
        return this.listaDeMovItem.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param RA
     */
    public void add(MovimentacaoItem MI) {
        this.listaDeMovItem.add(MI);
        fireTableDataChanged();
    }
    

    /**
     * Remove uma cidade da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void remove(int rowIndex) {
        this.listaDeMovItem.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeMovItem.size();
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
                return this.listaDeMovItem.get(rowIndex).getItem().getEspecificacao();

            case 1:
                return this.listaDeMovItem.get(rowIndex).getOrigem().getDescricao();

            case 2:
                return this.listaDeMovItem.get(rowIndex).getDestino().getDescricao();
                
            case 3:
                return this.listaDeMovItem.get(rowIndex).getData_criacao();
                

            default:
                return this.listaDeMovItem.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
    

