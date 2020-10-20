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
public class MovimentacaoItemDAO implements DAO {
    
    AmbienteDAO ADAO = new AmbienteDAO();
    ItemDAO IDAO = new ItemDAO();
    
    public MovimentacaoItem adiciona(Object obj){
        MovimentacaoItem mi1 = (MovimentacaoItem) obj;
        String sql1 = "select MovimentacaoItem_seq.nextval from dual";
        String sql = "insert into MovimentacaoItem" + " values (?,?,?,?,?,?)";
		try(Connection connection = new ConnectionFactory().getConnection();
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
                    ResultSet rs = stmt1.executeQuery();
                    if(rs.next()) {
                        stmt.setInt(1, rs.getInt(1));
                        mi1.setId(rs.getInt(1));
                    }
                    stmt.setInt(2, mi1.getOrigem().getId());
                    stmt.setInt(3, mi1.getDestino().getId());
                    stmt.setString(4, mi1.getMotivo());
                    stmt.setDate(5, java.sql.Date.valueOf(mi1.getData_criacao()));
                    stmt.setInt(6, mi1.getItem().getId());
			
                    stmt.execute();
            
                    System.out.println("Elemento inserido com sucesso.");
                    return mi1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void exclui(Object obj) {
        MovimentacaoItem mi1 = (MovimentacaoItem) obj;
        String sql = "delete from MovimentacaoItem where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, mi1.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public MovimentacaoItem buscaPorId(long code) {
        
        String sql = "select * from MovimentacaoItem where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                MovimentacaoItem mi1 = new MovimentacaoItem();
                mi1.setId(rs.getInt("id"));
                mi1.setOrigem(ADAO.buscaPorId(rs.getInt("id_origem")));
                mi1.setDestino(ADAO.buscaPorId(rs.getInt("id_destino")));
                mi1.setMotivo(rs.getString("motivo"));
                mi1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                mi1.setItem(IDAO.buscaPorId(rs.getInt("id_item")));

                
                return mi1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<Object> listar() {
        String sql = "select * from MovimentacaoItem order by 1";

        List<Object> MovimentacaoItem = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                MovimentacaoItem mi1 = new MovimentacaoItem();
                mi1.setId(rs.getInt("id"));
                mi1.setOrigem(ADAO.buscaPorId(rs.getInt("id_origem")));
                mi1.setDestino(ADAO.buscaPorId(rs.getInt("id_destino")));
                mi1.setMotivo(rs.getString("motivo"));
                mi1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                mi1.setItem(IDAO.buscaPorId(rs.getInt("id_item")));
              
                MovimentacaoItem.add(mi1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return MovimentacaoItem;
    }
    
    public void exclui() {
        String sql = "delete from MovimentacaoItem";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {         
            stmt.execute();
            cStmt.setString(1, "MovimentacaoItem_seq");
            cStmt.execute();
            
            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
