package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class TESTAITENSREVISAO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RevisaoAnualDAO RADAO = new RevisaoAnualDAO();
        ItensRevisaoDAO IRDAO = new ItensRevisaoDAO();
        ItemDAO IDAO = new ItemDAO();

        int opc = 3;
        while (opc != 0) {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Exibir Todos");
            System.out.println("4 - Deletar Todos");
            System.out.println("0 - Sair");
            opc = Integer.parseInt(input.nextLine());
            if (opc == 1) {
                ItensRevisao ir1 = new ItensRevisao();
                ir1.setRevisao(RADAO.buscaPorId(1));
                ir1.setItem(IDAO.buscaPorId(1));
                ir1.setVerificacao("ENCONTRADO");
                ir1.setData_criacao(LocalDate.now());
                ir1.setData_modificacao(LocalDate.now());
                IRDAO.adiciona(ir1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                ItensRevisao ir1 = IRDAO.buscaPorId(id);
                IRDAO.exclui(ir1);
            } else if (opc == 3) {
                List<ItensRevisao> ItensRevisao = IRDAO.listar();
                for (ItensRevisao c : ItensRevisao) {
                    System.out.println(c.getId() + " " + c.getItem().getEspecificacao());
                }
            } else if (opc == 4) {
                IRDAO.exclui();
            }
        }

    }

}
