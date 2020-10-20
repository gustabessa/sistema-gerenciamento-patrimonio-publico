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
public class RevisaoAnualDAO {
    
    ServidorDAO SDAO = new ServidorDAO();
    AmbienteDAO ADAO = new AmbienteDAO();
    
    public List<RevisaoAnual> listaAno(String param) {
        String sql = "select * from RevisaoAnual where ano = ? order by 1";

        List<RevisaoAnual> RevisaoAnual = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, Integer.valueOf(param));
                ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                RevisaoAnual ra1 = new RevisaoAnual();
                ra1.setId(rs.getInt("id"));
                ra1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                ra1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                ra1.setAno(rs.getInt("ano"));
                ra1.setEstado(rs.getString("estado"));
                ra1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ra1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
              
                RevisaoAnual.add(ra1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return RevisaoAnual;
    }
    
    public List<RevisaoAnual> filtrar(String param) {
        String sql = "select * from RevisaoAnual where estado like ? order by 1";

        List<RevisaoAnual> RevisaoAnual = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, param);
                ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                RevisaoAnual ra1 = new RevisaoAnual();
                ra1.setId(rs.getInt("id"));
                ra1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                ra1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                ra1.setAno(rs.getInt("ano"));
                ra1.setEstado(rs.getString("estado"));
                ra1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ra1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
              
                RevisaoAnual.add(ra1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return RevisaoAnual;
    }
    
    public Object alterar(Object obj) {
        RevisaoAnual ra = (RevisaoAnual) obj;
        String sql = "update RevisaoAnual set " + "estado = ?, data_modificacao = ? where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setString(1, ra.getEstado());
            stmt.setDate(2, java.sql.Date.valueOf(ra.getData_modificacao()));
            stmt.setInt(3, ra.getId());

            stmt.execute();

            System.out.println("Elemento atualizado com sucesso.");
            return ra;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Object adiciona(Object obj){
        RevisaoAnual ra1 = (RevisaoAnual) obj;
        String sql1 = "select RevisaoAnual_seq.nextval from dual";
        String sql = "insert into RevisaoAnual" + " values (?,?,?,?,?,?,?)";
		try(Connection connection = new ConnectionFactory().getConnection();
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
                    ResultSet rs = stmt1.executeQuery();
                    if(rs.next()) {
                        stmt.setInt(1, rs.getInt(1));
                        ra1.setId(rs.getInt(1));
                    }
                        
                    stmt.setInt(2, ra1.getServidor().getId());
                    stmt.setInt(3, ra1.getAmbiente().getId());
                    stmt.setInt(4, ra1.getAno());
                    stmt.setString(5, ra1.getEstado());
                    stmt.setDate(6, java.sql.Date.valueOf(ra1.getData_criacao()));
                    stmt.setDate(7, java.sql.Date.valueOf(ra1.getData_modificacao()));
			
                    stmt.execute();
                    
                    System.out.println("Elemento inserido com sucesso.");
                    return ra1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void exclui(Object obj) {
        RevisaoAnual ra1 = (RevisaoAnual) obj;
        String sql = "delete from RevisaoAnual where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, ra1.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public RevisaoAnual buscaPorId(long code) {
        
        String sql = "select * from RevisaoAnual where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                RevisaoAnual ra1 = new RevisaoAnual();
                ra1.setId(rs.getInt("id"));
                ra1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                ra1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                ra1.setAno(rs.getInt("ano"));
                ra1.setEstado(rs.getString("estado"));
                ra1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ra1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                
                return ra1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<RevisaoAnual> listar() {
        String sql = "select * from RevisaoAnual order by 1";

        List<RevisaoAnual> RevisaoAnual = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                RevisaoAnual ra1 = new RevisaoAnual();
                ra1.setId(rs.getInt("id"));
                ra1.setServidor(SDAO.buscaPorId(rs.getInt("id_servidor")));
                ra1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                ra1.setAno(rs.getInt("ano"));
                ra1.setEstado(rs.getString("estado"));
                ra1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ra1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
              
                RevisaoAnual.add(ra1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return RevisaoAnual;
    }
    
    public void exclui() {
        String sql = "delete from RevisaoAnual";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {         
            stmt.execute();
            cStmt.setString(1, "RevisaoAnual_seq");
            cStmt.execute();
            
            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
