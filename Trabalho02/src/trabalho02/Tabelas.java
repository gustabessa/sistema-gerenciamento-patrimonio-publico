/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import com.itextpdf.text.pdf.PdfPTable;

/**
 *
 * @author gusta
 */
public class Tabelas {
    private PdfPTable Tabela;
    private int qtAmb;
    private double total;
    private Campus campus;

    public Tabelas(Campus campus, PdfPTable Tabela, int qtAmb, double total) {
        this.Tabela = Tabela;
        this.qtAmb = qtAmb;
        this.total = total;
        this.campus = campus;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    
    public PdfPTable getTabela() {
        return Tabela;
    }

    public void setTabela(PdfPTable Tabela) {
        this.Tabela = Tabela;
    }

    public int getQtAmb() {
        return qtAmb;
    }

    public void setQtAmb(int qtAmb) {
        this.qtAmb = qtAmb;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
