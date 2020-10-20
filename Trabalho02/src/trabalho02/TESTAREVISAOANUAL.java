package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TESTAREVISAOANUAL {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AmbienteDAO ADAO = new AmbienteDAO();
        ServidorDAO SDAO = new ServidorDAO();
        RevisaoAnualDAO RADAO = new RevisaoAnualDAO();

        int opc = 3;
        while (opc != 0) {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Exibir Todos");
            System.out.println("4 - Deletar Todos");
            System.out.println("0 - Sair");
            opc = Integer.parseInt(input.nextLine());
            if (opc == 1) {
                RevisaoAnual ra1 = new RevisaoAnual();
                ra1.setAmbiente(ADAO.buscaPorId(1));
                ra1.setServidor(SDAO.buscaPorId(1));
                ra1.setAno(LocalDate.now().getYear());
                ra1.setData_criacao(LocalDate.now());
                ra1.setData_modificacao(LocalDate.now());
                ra1.setEstado("ENCERRADA");
                RADAO.adiciona(ra1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                RevisaoAnual ra1 = RADAO.buscaPorId(id);
                RADAO.exclui(ra1);
            } else if (opc == 3) {
                List<RevisaoAnual> RevisaoAnual = RADAO.listar();
                for (RevisaoAnual c : RevisaoAnual) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                RADAO.exclui();
            }
        }

    }

}
