/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GustavoBessa
 */
public class ServidorDAO implements DAO {

    CampusDAO CDAO = new CampusDAO();

    public List<Servidor> filtrar(String param) {
        String sql = "select * from servidor where nome like ? order by 1";

        List<Servidor> Servidor = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, '%'+param+'%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                Servidor s1 = new Servidor();
                s1.setId(rs.getInt("id"));
                s1.setNome(rs.getString("nome"));
                s1.setEmail(rs.getString("email"));
                s1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                s1.setCargo(rs.getString("cargo"));
                s1.setPapel(rs.getString("papel"));
                s1.setLogin(rs.getString("login"));
                s1.setSenha(rs.getString("senha"));
                
                Servidor.add(s1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return Servidor;
    }
    
    public Object alterar(Object obj) {
        Servidor s1 = (Servidor) obj;
        String sql = "update SERVIDOR set " + "nome = ?, email = ?, id_campus = ?, cargo = ?, papel = ?, login = ?, senha = ? where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setString(1, s1.getNome());
            stmt.setString(2, s1.getEmail());
            stmt.setInt(3, s1.getCampus().getId());
            stmt.setString(4, s1.getCargo());
            stmt.setString(5, s1.getPapel());
            stmt.setString(6, s1.getLogin());
            stmt.setString(7, s1.getSenha());
            stmt.setInt(8, s1.getId());

            stmt.execute();

            System.out.println("Elemento atualizado com sucesso.");
            return s1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object adiciona(Object obj) {
        Servidor s1 = (Servidor) obj;
        String sql1 = "select SERVIDOR_SEQ.nextval from dual";
        String sql = "insert into SERVIDOR" + " values (?,?,?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                stmt.setInt(1, rs.getInt(1));
                s1.setId(rs.getInt(1));
            }
            stmt.setString(2, s1.getNome());
            stmt.setString(3, s1.getEmail());
            stmt.setInt(4, s1.getCampus().getId());
            stmt.setString(5, s1.getCargo());
            stmt.setString(6, s1.getPapel());
            stmt.setString(7, s1.getLogin());
            stmt.setString(8, s1.getSenha());

            stmt.execute();

            System.out.println("Elemento inserido com sucesso.");

            return s1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void exclui(Object obj) {
        Servidor s1 = (Servidor) obj;
        String sql = "delete from SERVIDOR where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, s1.getId());

            stmt.execute();

            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Servidor buscaPorId(long code) {

        String sql = "select * from SERVIDOR where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Servidor s1 = new Servidor();
                s1.setId(rs.getInt("id"));
                s1.setNome(rs.getString("nome"));
                s1.setEmail(rs.getString("email"));
                s1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                s1.setCargo(rs.getString("cargo"));
                s1.setPapel(rs.getString("papel"));
                s1.setLogin(rs.getString("login"));
                s1.setSenha(rs.getString("senha"));

                return s1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Object> listar() {
        String sql = "select * from SERVIDOR order by 1";

        List<Object> Servidor = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Servidor s1 = new Servidor();
                s1.setId(rs.getInt("id"));
                s1.setNome(rs.getString("nome"));
                s1.setEmail(rs.getString("email"));
                s1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                s1.setCargo(rs.getString("cargo"));
                s1.setPapel(rs.getString("papel"));
                s1.setLogin(rs.getString("login"));
                s1.setSenha(rs.getString("senha"));

                Servidor.add(s1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Servidor;
    }

    public void exclui() {
        String sql = "delete from SERVIDOR";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {
            cStmt.setString(1, "servidor_seq");
            cStmt.execute();
            stmt.execute();

            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Servidor loginSistema(String login, String senha) {
        String sql = "select * from SERVIDOR order by 1";

        List<Servidor> Servidor = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Servidor s1 = new Servidor();
                s1.setId(rs.getInt("id"));
                s1.setNome(rs.getString("nome"));
                s1.setEmail(rs.getString("email"));
                s1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                s1.setCargo(rs.getString("cargo"));
                s1.setPapel(rs.getString("papel"));
                s1.setLogin(rs.getString("login"));
                s1.setSenha(rs.getString("senha"));

                Servidor.add(s1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Servidor s : Servidor) {
            if (s.getLogin().equals(login) && s.getSenha().equals(senha)) {
                return s;
            }
        }
        return null;
    }

}
