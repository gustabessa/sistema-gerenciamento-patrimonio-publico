package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TESTAITEM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AmbienteDAO ADAO = new AmbienteDAO();
        ServidorDAO SDAO = new ServidorDAO();
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
                Item i1 = new Item();
                i1.setAmbiente(ADAO.buscaPorId(1));
                i1.setCod_partimonio(00001);
                i1.setData_compra(LocalDate.of(2020, 01, 11));
                i1.setDono(SDAO.buscaPorId(1));
                i1.setEspecificacao("Computador");
                i1.setEstado(2);
                i1.setValor_compra(2400);
                i1.setData_criacao(LocalDate.of(2020, 01, 11));
                i1.setData_modificacao(LocalDate.of(2020, 01, 11));
                IDAO.adiciona(i1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                Item i1 = IDAO.buscaPorId(id);
                IDAO.exclui(i1);
            } else if (opc == 3) {
                List<Object> Item = IDAO.listar();
                for (Object c : Item) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                IDAO.exclui();
            }
        }

    }

}
