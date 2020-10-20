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
public class MovimentacaoDonoDAO {
    
    ServidorDAO SDAO = new ServidorDAO();
    AmbienteDAO ADAO = new AmbienteDAO();
    
    public void adiciona(Object obj){
        MovimentacaoDono md1 = (MovimentacaoDono) obj;
        String sql1 = "select MovimentacaoDono_seq.nextval from dual";
        String sql = "insert into MovimentacaoDono" + " values (?,?,?,?,?,?)";
		try(Connection connection = new ConnectionFactory().getConnection();
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
                    ResultSet rs = stmt1.executeQuery();
                    if(rs.next())
                        stmt.setInt(1, rs.getInt(1));
                    stmt.setInt(2, md1.getOrigem().getId());
                    stmt.setInt(3, md1.getDestino().getId());
                    stmt.setString(4, md1.getMotivo());
                    stmt.setDate(5, java.sql.Date.valueOf(md1.getData_criacao()));
                    stmt.setInt(6, md1.getAmbiente().getId());
			
                    stmt.execute();
            
                    System.out.println("Elemento inserido com sucesso.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void exclui(Object obj) {
        MovimentacaoDono md1 = (MovimentacaoDono) obj;
        String sql = "delete from MovimentacaoDono where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, md1.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public MovimentacaoDono buscaPorId(long code) {
        
        String sql = "select * from MovimentacaoDono where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                MovimentacaoDono md1 = new MovimentacaoDono();
                md1.setId(rs.getInt("id"));
                md1.setOrigem(SDAO.buscaPorId(rs.getInt("id_origem")));
                md1.setDestino(SDAO.buscaPorId(rs.getInt("id_destino")));
                md1.setMotivo(rs.getString("motivo"));
                md1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                md1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));

                
                return md1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<MovimentacaoDono> listar() {
        String sql = "select * from MovimentacaoDono order by 1";

        List<MovimentacaoDono> MovimentacaoDono = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                MovimentacaoDono md1 = new MovimentacaoDono();
                md1.setId(rs.getInt("id"));
                md1.setOrigem(SDAO.buscaPorId(rs.getInt("id_origem")));
                md1.setDestino(SDAO.buscaPorId(rs.getInt("id_destino")));
                md1.setMotivo(rs.getString("motivo"));
                md1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                md1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
              
                MovimentacaoDono.add(md1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return MovimentacaoDono;
    }
    
    public void exclui() {
        String sql = "delete from MovimentacaoDono";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {         
            stmt.execute();
            cStmt.setString(1, "MovimentacaoDono_seq");
            cStmt.execute();
            
            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
