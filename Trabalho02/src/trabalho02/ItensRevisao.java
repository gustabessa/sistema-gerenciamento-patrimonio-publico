
package trabalho02;

import java.time.LocalDate;

public class ItensRevisao {
    private int id;
    private RevisaoAnual revisao;
    private Item item;
    private String verificacao;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    private int estado;



    @Override
    public String toString() {
        return this.item.getId() + " - " + this.item.getEspecificacao() + " - " + this.item.getCod_partimonio();
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RevisaoAnual getRevisao() {
        return revisao;
    }

    public void setRevisao(RevisaoAnual revisao) {
        this.revisao = revisao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getVerificacao() {
        return verificacao;
    }

    public void setVerificacao(String verificacao) {
        this.verificacao = verificacao;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public LocalDate getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(LocalDate data_modificacao) {
        this.data_modificacao = data_modificacao;
    }
    
    
}
