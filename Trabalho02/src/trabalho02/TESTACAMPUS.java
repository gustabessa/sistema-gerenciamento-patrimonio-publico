package trabalho02;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class TESTACAMPUS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                Campus c1 = new Campus();
                c1.setAbreviacao("UPT1");
                c1.setBairro("Parque das Manteigas");
                c1.setCep("3888819");
                c1.setCidade("Uberaba");
                c1.setData_criacao(LocalDate.now());
                c1.setEndereco("Praça dos Pombos - 395");
                c1.setNome("IFTM - Uberaba Pqe Avançado, Unidade 1");
                CDAO.adiciona(c1);
            } else if (opc == 2) {
                int id;
                System.out.println("Id a deletar");
                id = Integer.parseInt(input.nextLine());
                Campus c1 = CDAO.buscaPorId(id);
                try {
                    CDAO.exclui(c1);

                } catch (Exception e) {
                    System.out.println("NAO DEU MANEZAO");
                }
            } else if (opc == 3) {
                List<Object> Campus = CDAO.listar();
                for (Object c : Campus) {
                    System.out.println(c);
                }
            } else if (opc == 4) {
                CDAO.exclui();
            }

        }
        /*
        String sql = "insert into campus" + " values (?,?,?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, c1.getId());
            stmt.setString(2, c1.getNome());
            stmt.setString(3, c1.getAbreviacao());
            stmt.setDate(4, java.sql.Date.valueOf(c1.getData_criacao()));
            stmt.setString(5, c1.getCidade());
            stmt.setString(6, c1.getBairro());
            stmt.setString(7, c1.getEndereco());
            stmt.setString(8, c1.getCep());

            stmt.execute();

            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

}
