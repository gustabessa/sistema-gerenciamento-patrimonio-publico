package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TESTAMOVIMENTACAODONO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ServidorDAO SDAO = new ServidorDAO();
        AmbienteDAO ADAO = new AmbienteDAO();
        MovimentacaoDonoDAO MDDAO = new MovimentacaoDonoDAO();

        int opc = 3;
        while (opc != 0) {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Exibir Todos");
            System.out.println("4 - Deletar Todos");
            System.out.println("0 - Sair");
            opc = Integer.parseInt(input.nextLine());
            if (opc == 1) {
                MovimentacaoDono md1 = new MovimentacaoDono();
                md1.setOrigem(SDAO.buscaPorId(1));
                md1.setDestino(SDAO.buscaPorId(1));
                md1.setMotivo("MOVIMENTACAO DE TESTE");
                md1.setData_criacao(LocalDate.now());
                md1.setAmbiente(ADAO.buscaPorId(1));
                MDDAO.adiciona(md1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                MovimentacaoDono md1 = MDDAO.buscaPorId(id);
                MDDAO.exclui(md1);
            } else if (opc == 3) {
                List<MovimentacaoDono> MovimentacaoDono = MDDAO.listar();
                for (MovimentacaoDono c : MovimentacaoDono) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                MDDAO.exclui();
            }
        }

    }

}
