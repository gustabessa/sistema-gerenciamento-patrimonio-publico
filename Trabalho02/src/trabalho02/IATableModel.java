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
public class IATableModel extends AbstractTableModel {
    private List<Item> listaDeItens;
    private final String[] colunas = {"Id Item", "Cod. Patrimônio", "Especificação", "Estado", "Valor compra"};
    

    public IATableModel() {
        this.listaDeItens = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Cidade
     */
    public Item get(int rowIndex) {
        return this.listaDeItens.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param RA
     */
    public void add(Item i) {
        this.listaDeItens.add(i);
        fireTableDataChanged();
    }
    

    /**
     * Remove uma cidade da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void remove(int rowIndex) {
        this.listaDeItens.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return this.listaDeItens.size();
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
                return this.listaDeItens.get(rowIndex).getId();

            case 1:
                return this.listaDeItens.get(rowIndex).getCod_partimonio();

            case 2:
                return this.listaDeItens.get(rowIndex).getEspecificacao();
                
            case 3:
                return this.listaDeItens.get(rowIndex).getEstado();
                
            case 4:
                return this.listaDeItens.get(rowIndex).getValor_compra();

            default:
                return this.listaDeItens.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
    

