
package trabalho02;

import java.time.LocalDate;


public class MovimentacaoDono {
    private int id;
    private Ambiente ambiente;
    private Servidor origem;
    private Servidor destino;
    private String motivo;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Servidor getOrigem() {
        return origem;
    }

    public void setOrigem(Servidor origem) {
        this.origem = origem;
    }

    public Servidor getDestino() {
        return destino;
    }

    public void setDestino(Servidor destino) {
        this.destino = destino;
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
