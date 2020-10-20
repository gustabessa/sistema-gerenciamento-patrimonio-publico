/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GustavoBessa
 */
public class ItensRevisaoDAO {
    
    RevisaoAnualDAO RADAO = new RevisaoAnualDAO();
    ItemDAO IDAO = new ItemDAO();
    
    public Object alterar(Object obj) {
        ItensRevisao i1 = (ItensRevisao) obj;
        String sql = "update ItensRevisao set " + "verificacao = ?, data_modificacao = ?, estado = ? where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setString(1, i1.getVerificacao());
            stmt.setDate(2, Date.valueOf(i1.getData_modificacao()));
            stmt.setInt(3, i1.getEstado());
            stmt.setInt(4, i1.getId());

            stmt.execute();

            System.out.println("Elemento atualizado com sucesso.");
            return i1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ItensRevisao> filtrar(int param) {
        String sql = "select * from ItensRevisao where id_revisaoanual = ? order by 1";

        List<ItensRevisao> ItensRevisao = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                stmt.setInt(1, param);
                ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                ItensRevisao ir1 = new ItensRevisao();
                ir1.setId(rs.getInt("id"));
                ir1.setRevisao(RADAO.buscaPorId(rs.getInt("id_revisaoanual")));
                ir1.setItem(IDAO.buscaPorId(rs.getInt("id_item")));
                ir1.setVerificacao(rs.getString("verificacao"));
                ir1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ir1.setEstado(rs.getInt("estado"));
                ir1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
              
                ItensRevisao.add(ir1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return ItensRevisao;
    }
    
    public void adiciona(Object obj){
        ItensRevisao ir1 = (ItensRevisao) obj;
        String sql1 = "select ItensRevisao_seq.nextval from dual";
        String sql = "insert into ItensRevisao" + " values (?,?,?,?,?,?,?)";
		try(Connection connection = new ConnectionFactory().getConnection();
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
                    ResultSet rs = stmt1.executeQuery();
                    if(rs.next())
                        stmt.setInt(1, rs.getInt(1));
                    stmt.setInt(2, ir1.getRevisao().getId());
                    stmt.setInt(3, ir1.getItem().getId());
                    stmt.setString(4, ir1.getVerificacao());
                    stmt.setDate(5, java.sql.Date.valueOf(ir1.getData_criacao()));
                    stmt.setDate(6, java.sql.Date.valueOf(ir1.getData_modificacao()));
                    stmt.setInt(7, ir1.getEstado());
			
                    stmt.execute();
            
                    System.out.println("Elemento inserido com sucesso.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void exclui(Object obj) {
        ItensRevisao ir1 = (ItensRevisao) obj;
        String sql = "delete from ItensRevisao where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, ir1.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ItensRevisao buscaPorId(long code) {
        
        String sql = "select * from ItensRevisao where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                ItensRevisao ir1 = new ItensRevisao();
                ir1.setId(rs.getInt("id"));
                ir1.setRevisao(RADAO.buscaPorId(rs.getInt("id_revisaoanual")));
                ir1.setItem(IDAO.buscaPorId(rs.getInt("id_item")));
                ir1.setVerificacao(rs.getString("verificacao"));
                ir1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ir1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                ir1.setEstado(rs.getInt("estado"));
                
                return ir1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<ItensRevisao> listar() {
        String sql = "select * from ItensRevisao order by 1";

        List<ItensRevisao> ItensRevisao = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                ItensRevisao ir1 = new ItensRevisao();
                ir1.setId(rs.getInt("id"));
                ir1.setRevisao(RADAO.buscaPorId(rs.getInt("id_revisaoanual")));
                ir1.setItem(IDAO.buscaPorId(rs.getInt("id_item")));
                ir1.setVerificacao(rs.getString("verificacao"));
                ir1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                ir1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                ir1.setEstado(rs.getInt("estado"));
              
                ItensRevisao.add(ir1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return ItensRevisao;
    }
    
    public void exclui() {
        String sql = "delete from ItensRevisao";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {         
            stmt.execute();
            cStmt.setString(1, "ItensRevisao_seq");
            cStmt.execute();
            
            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
