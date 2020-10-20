package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TESTAMOVIMENTACAOITEM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AmbienteDAO ADAO = new AmbienteDAO();
        ItemDAO IDAO = new ItemDAO();
        MovimentacaoItemDAO MIDAO = new MovimentacaoItemDAO();

        int opc = 3;
        while (opc != 0) {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Exibir Todos");
            System.out.println("4 - Deletar Todos");
            System.out.println("0 - Sair");
            opc = Integer.parseInt(input.nextLine());
            if (opc == 1) {
                MovimentacaoItem mi1 = new MovimentacaoItem();
                mi1.setOrigem(ADAO.buscaPorId(1));
                mi1.setDestino(ADAO.buscaPorId(1));
                mi1.setMotivo("MOVIMENTACAO DE TESTE");
                mi1.setData_criacao(LocalDate.now());
                mi1.setItem(IDAO.buscaPorId(1));
                MIDAO.adiciona(mi1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                MovimentacaoItem md1 = MIDAO.buscaPorId(id);
                MIDAO.exclui(md1);
            } else if (opc == 3) {
                List<Object> MovimentacaoItem = MIDAO.listar();
                for (Object c : MovimentacaoItem) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                MIDAO.exclui();
            }
        }

    }

}
