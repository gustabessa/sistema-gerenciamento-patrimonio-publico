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
public class CampusDAO implements DAO {
    
    public List<Campus> filtrar(String param) {
        String sql = "select * from campus where abreviacao like ? order by 1";

        List<Campus> Campus = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, '%'+param+'%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                Campus c1 = new Campus();
                c1.setId(rs.getInt("id"));
                c1.setNome(rs.getString("nome"));
                c1.setAbreviacao(rs.getString("abreviacao"));
                c1.setEndereco(rs.getString("endereco"));
                c1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                c1.setBairro(rs.getString("bairro"));
                c1.setCidade(rs.getString("cidade"));
                c1.setCep(rs.getString("cep"));
                
                Campus.add(c1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return Campus;
    }
    
    public Object alterar(Object obj) {
        Campus c1 = (Campus) obj;
        String sql = "update CAMPUS set " + "nome = ?, abreviacao = ?, data_criacao = ?, cidade = ?, bairro = ?, endereco = ?, cep = ? where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setString(1, c1.getNome());
            stmt.setString(2, c1.getAbreviacao());
            stmt.setDate(3, java.sql.Date.valueOf(c1.getData_criacao()));
            stmt.setString(4, c1.getCidade());
            stmt.setString(5, c1.getBairro());
            stmt.setString(6, c1.getEndereco());
            stmt.setString(7, c1.getCep());
            stmt.setInt(8, c1.getId());

            stmt.execute();

            System.out.println("Elemento atualizado com sucesso.");
            return c1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Object adiciona(Object obj){
        Campus c1 = (Campus) obj;
        String sql1 = "select CAMPUS_SEQ.nextval from dual";
        String sql = "insert into campus" + " values (?,?,?,?,?,?,?,?)";
		try(Connection connection = new ConnectionFactory().getConnection();
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
                    ResultSet rs = stmt1.executeQuery();
                    if(rs.next())
                    {
                        stmt.setInt(1, rs.getInt(1));
                        c1.setId(rs.getInt(1));
                    }
                    stmt.setString(2, c1.getNome());
                    stmt.setString(3, c1.getAbreviacao());
                    stmt.setDate(4, java.sql.Date.valueOf(c1.getData_criacao()));
                    stmt.setString(5, c1.getCidade());
                    stmt.setString(6, c1.getBairro());
                    stmt.setString(7, c1.getEndereco());
                    stmt.setString(8, c1.getCep());
			
                    stmt.execute();
                    
                    System.out.println("Elemento inserido com sucesso.");
                    return c1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void exclui(Object obj) {
        Campus c1 = (Campus) obj;
        String sql = "delete from campus where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, c1.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Campus buscaPorId(long code) {
        
        String sql = "select * from campus where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Campus c1 = new Campus();
                c1.setId(rs.getInt("id"));
                c1.setNome(rs.getString("nome"));
                c1.setAbreviacao(rs.getString("abreviacao"));
                c1.setEndereco(rs.getString("endereco"));
                c1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                c1.setBairro(rs.getString("bairro"));
                c1.setCidade(rs.getString("cidade"));
                c1.setCep(rs.getString("cep"));
                
                return c1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    @Override
    public List<Object> listar() {
        String sql = "select * from campus order by 1";

        List<Object> Campus = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                Campus c1 = new Campus();
                c1.setId(rs.getInt("id"));
                c1.setNome(rs.getString("nome"));
                c1.setAbreviacao(rs.getString("abreviacao"));
                c1.setEndereco(rs.getString("endereco"));
                c1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                c1.setBairro(rs.getString("bairro"));
                c1.setCidade(rs.getString("cidade"));
                c1.setCep(rs.getString("cep"));
                
                Campus.add(c1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return Campus;
    }
    
    public void exclui() {
        String sql = "delete from campus";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {         
            stmt.execute();
            cStmt.setString(1, "campus_seq");
            cStmt.execute();
            
            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
