
package trabalho02;

import java.time.LocalDate;

public class Item {
    private int id;
    private String especificacao;
    private int cod_partimonio;
    private int estado;
    private LocalDate data_compra;         
    private Servidor dono;
    private double valor_compra;
    private Ambiente ambiente;
    private LocalDate data_criacao;        
    private LocalDate data_modificacao;    

    
        
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public int getCod_partimonio() {
        return cod_partimonio;
    }

    public void setCod_partimonio(int cod_partimonio) {
        this.cod_partimonio = cod_partimonio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getData_compra() {
        return data_compra;
    }

    public void setData_compra(LocalDate data_compra) {
        this.data_compra = data_compra;
    }

    public Servidor getDono() {
        return dono;
    }

    public void setDono(Servidor dono) {
        this.dono = dono;
    }

    public double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
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
                    return id + " - " + especificacao;

    }
    
//    public String mostrar(Servidor dono) {
//        if(this.dono == dono) {
//            return "Item:" + "\nId: " + id + "\nEspecificacao: " + especificacao + "\nCod. Partimonio: " + cod_partimonio + "\nEstado: " + estado + "\nData de Compra: " + data_compra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nDono: " + dono.getNome() + "\nValor de Compra: " + valor_compra + "\nAmbiente: " + ambiente;
//        } else {
//            return "Nope";
//        }
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
