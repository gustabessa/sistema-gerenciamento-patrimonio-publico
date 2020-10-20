package trabalho02;

import java.util.List;
import java.util.Scanner;

public class TESTASERVIDOR {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                Servidor s1 = new Servidor();
                s1.setNome("Eduardo Augusto Silvestre");
                s1.setEmail("gustavowbessa@gmail.com");
                s1.setCampus(CDAO.buscaPorId(1));
                s1.setCargo("Estudante");
                s1.setPapel("adm");
                s1.setLogin("admin");
                s1.setSenha("12345");
                SDAO.adiciona(s1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                Servidor s1 = SDAO.buscaPorId(id);
                SDAO.exclui(s1);
            } else if (opc == 3) {
                List<Object> Servidor = SDAO.listar();
                for (Object c : Servidor) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                SDAO.exclui();
            }
        }

    }

}
