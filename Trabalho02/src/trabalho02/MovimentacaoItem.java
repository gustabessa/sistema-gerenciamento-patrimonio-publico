
package trabalho02;

import java.time.LocalDate;



public class MovimentacaoItem {
    private int id;
    private Item item;
    private Ambiente destino;
    private Ambiente origem;
    private String motivo;
    private LocalDate data_criacao;        
    private LocalDate data_modificacao;    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ambiente getDestino() {
        return destino;
    }

    public void setDestino(Ambiente destino) {
        this.destino = destino;
    }

    public Ambiente getOrigem() {
        return origem;
    }

    public void setOrigem(Ambiente origem) {
        this.origem = origem;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    @Override
    public String toString() {
        return "";
    }
    
    
    
}
