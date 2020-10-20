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
public class AmbienteDAO implements DAO {

    ServidorDAO SDAO = new ServidorDAO();
    CampusDAO CDAO = new CampusDAO();

    
    public List<Ambiente> filtrar(String param) {
        String sql = "select * from ambiente where descricao like ? order by 1";

        List<Ambiente> Ambiente = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, '%'+param+'%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                Ambiente a1 = new Ambiente();
                a1.setId(rs.getInt("id"));
                a1.setDescricao(rs.getString("descricao"));
                a1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                a1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                a1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                a1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());

                
                Ambiente.add(a1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return Ambiente;
    }
    
    public Object alterar(Object obj) {
        Ambiente a1 = (Ambiente) obj;
        String sql = "update ambiente set " + "descricao = ?, id_servidor = ?, id_campus = ?, data_criacao = ?, data_modificacao = ? where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setString(1, a1.getDescricao());
            stmt.setInt(2, a1.getServidor().getId());
            stmt.setInt(3, a1.getCampus().getId());
            stmt.setDate(4, java.sql.Date.valueOf(a1.getData_criacao()));
            stmt.setDate(5, java.sql.Date.valueOf(a1.getData_modificacao()));
            stmt.setInt(6, a1.getId());
           
            stmt.execute();

            System.out.println("Elemento atualizado com sucesso.");
            return a1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public Object adiciona(Object obj) {
        Ambiente a1 = (Ambiente) obj;
        String sql1 = "select AMBIENTE_SEQ.nextval from dual";
        String sql = "insert into AMBIENTE" + " values (?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                stmt.setInt(1, rs.getInt(1));
                a1.setId(rs.getInt(1));
            }
            stmt.setInt(2, a1.getCampus().getId());
            stmt.setInt(3, a1.getServidor().getId()); // terá dono?
            stmt.setDate(4, java.sql.Date.valueOf(a1.getData_criacao()));
            stmt.setDate(5, java.sql.Date.valueOf(a1.getData_modificacao()));
            stmt.setString(6, a1.getDescricao());

            stmt.execute();

            System.out.println("Elemento inserido com sucesso.");
            
            return a1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void exclui(Object obj) {
        Ambiente a1 = (Ambiente) obj;
        String sql = "delete from AMBIENTE where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, a1.getId());

            stmt.execute();

            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ambiente buscaPorId(long code) {

        String sql = "select * from AMBIENTE where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ambiente a1 = new Ambiente();
                a1.setId(rs.getInt("id"));
                a1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                a1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                a1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                a1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                a1.setDescricao(rs.getString("descricao"));

                return a1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Object> listar() {
        String sql = "select * from AMBIENTE order by 1";

        List<Object> Ambiente = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Ambiente a1 = new Ambiente();
                a1.setId(rs.getInt("id"));
                a1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                a1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                a1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                a1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                a1.setDescricao(rs.getString("descricao"));

                Ambiente.add(a1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Ambiente;
    }
    
    public List<Object> listaOrdenaCampus() {
        String sql = "select * from AMBIENTE order by 2 asc";

        List<Object> Ambiente = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Ambiente a1 = new Ambiente();
                a1.setId(rs.getInt("id"));
                a1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                a1.setCampus(CDAO.buscaPorId(rs.getInt("id_campus")));
                a1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                a1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                a1.setDescricao(rs.getString("descricao"));

                Ambiente.add(a1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Ambiente;
    }

    public void exclui() {
        String sql = "delete from AMBIENTE";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {
            stmt.execute();
            cStmt.setString(1, "ambiente_seq");
            cStmt.execute();

            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
