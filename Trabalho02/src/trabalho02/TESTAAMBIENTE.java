package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class TESTAAMBIENTE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AmbienteDAO ADAO = new AmbienteDAO();
        ServidorDAO SDAO = new ServidorDAO();
        CampusDAO CDAO = new CampusDAO();

        int opc = 3;
        while (opc != 0) {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Exibir Todos");
            System.out.println("4 - Deletar Todos");
            System.out.println("0 - Sair");
            opc = Integer.parseInt(input.nextLine());
            if (opc == 1) {
                Ambiente a1 = new Ambiente();
                a1.setCampus(CDAO.buscaPorId(1));
                a1.setData_criacao(LocalDate.of(2015, 01, 10));
                a1.setData_modificacao(LocalDate.of(2015, 01, 10));
                a1.setDescricao("Sala 317");
                a1.setServidor(SDAO.buscaPorId(1));
                ADAO.adiciona(a1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                Ambiente a1 = ADAO.buscaPorId(id);
                ADAO.exclui(a1);
            } else if (opc == 3) {
                List<Object> Ambiente = ADAO.listar();
                for (Object c : Ambiente) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                ADAO.exclui();
            }
        }

    }

}
