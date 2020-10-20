
package trabalho02;

import java.time.LocalDate;


public final class RevisaoAnual {
    private int id;
    private int ano;
    private Servidor servidor;
    private Ambiente ambiente;
    private String estado;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    
    /*public void detalhaRevisao(ItensRevisaoDAO IRDAO) {
        System.out.println("\n\t==========================================================================================================");
        System.out.println("\n\tCOD.\tSERVIDOR\tCAMPUS E AMBIENTE\tDATA DE CRIAÇÃO\t\tDATA DE MODIFICAÇÃO\tESTADO");
        System.out.println("\n\t" + this.id + "\t" + this.servidor.getNome() + 
                "\t\t" + this.ambiente.getCampus().getAbreviacao() + ", " + this.ambiente.getDescricao() + 
                "\t\t" + this.data_criacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
                "\t\t" + this.data_modificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
                "\t\t" + this.estado);
        System.out.println("\n\t----------------------------------------------------------------------------------------------------------");
        System.out.println("\n\tDETALHES DOS ITENS: ");
        IRDAO.mostraPorRevisao(this);
        System.out.println("\n\t----------------------------------------------------------------------------------------------------------");
        
    }*/

    @Override
    public String toString() {
        return "RevisaoAnual{" + "id=" + id + ", ano=" + ano + ", servidor=" + servidor.getNome() + ", ambiente=" + ambiente.getDescricao() + ", estado=" + estado + ", data_criacao=" + data_criacao + ", data_modificacao=" + data_modificacao + '}';
    }
}
    

