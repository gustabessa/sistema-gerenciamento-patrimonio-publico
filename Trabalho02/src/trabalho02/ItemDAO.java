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
public class ItemDAO implements DAO {
    
    ServidorDAO SDAO = new ServidorDAO();
    AmbienteDAO ADAO = new AmbienteDAO();
    
    public List<Item> filtrar(String param) {
        String sql = "select * from item where especificacao like ? order by 1";

        List<Item> Item = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, '%'+param+'%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                Item i1 = new Item();
                i1.setId(rs.getInt("id"));
                i1.setEspecificacao(rs.getString("especificacao"));
                i1.setValor_compra(rs.getDouble("valor_compra"));
                i1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                i1.setDono(SDAO.buscaPorId(rs.getInt("id_servidor")));
                i1.setEstado(rs.getInt("estado"));
                i1.setCod_partimonio(rs.getInt("cod_patrimonio"));
                i1.setData_compra(rs.getDate("data_compra").toLocalDate());
                i1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                i1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                
                Item.add(i1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return Item;
    }
    
    public Object alterar(Object obj) {
        Item i1 = (Item) obj;
        String sql = "update Item set " + "especificacao = ?, cod_patrimonio = ?, estado = ?, data_compra = ?, "
                + "id_servidor = ?, valor_compra = ?, id_ambiente = ?, data_criacao = ?, data_modificacao = ? where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setString(1, i1.getEspecificacao());
            stmt.setInt(2, i1.getCod_partimonio());
            stmt.setInt(3, i1.getEstado());
            stmt.setDate(4, Date.valueOf(i1.getData_compra()));
            stmt.setInt(5, i1.getDono().getId());
            stmt.setDouble(6, i1.getValor_compra());
            stmt.setInt(7, i1.getAmbiente().getId());
            stmt.setDate(8, Date.valueOf(i1.getData_criacao()));
            stmt.setDate(9, Date.valueOf(i1.getData_modificacao()));
            stmt.setInt(10, i1.getId());

            stmt.execute();

            System.out.println("Elemento atualizado com sucesso.");
            return i1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Object adiciona(Object obj){
        Item i1 = (Item) obj;
        String sql1 = "select ITEM_SEQ.nextval from dual";
        String sql = "insert into ITEM" + " values (?,?,?,?,?,?,?,?,?,?)";
		try(Connection connection = new ConnectionFactory().getConnection();
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        PreparedStatement stmt1 = connection.prepareStatement(sql1)) {
                    ResultSet rs = stmt1.executeQuery();
                    if(rs.next()) {
                        stmt.setInt(1, rs.getInt(1));
                        i1.setId(rs.getInt(1));
                    }
                        
                    stmt.setInt(2, i1.getDono().getId());
                    stmt.setInt(3, i1.getAmbiente().getId());
                    stmt.setString(4, i1.getEspecificacao());
                    stmt.setInt(5, i1.getCod_partimonio());
                    stmt.setInt(6, i1.getEstado());
                    stmt.setDate(7, java.sql.Date.valueOf(i1.getData_compra()));
                    stmt.setDouble(8, i1.getValor_compra());
                    stmt.setDate(9, java.sql.Date.valueOf(i1.getData_criacao()));
                    stmt.setDate(10, java.sql.Date.valueOf(i1.getData_modificacao()));
			
                    stmt.execute();
            
                    System.out.println("Elemento inserido com sucesso.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
                return i1;
    }
    
    public void exclui(Object obj) {
        Item i1 = (Item) obj;
        String sql = "delete from ITEM where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, i1.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Item buscaPorId(long code) {
        
        String sql = "select * from ITEM where id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Item i1 = new Item();
                i1.setId(rs.getInt("id"));
                i1.setDono(SDAO.buscaPorId(rs.getInt("id_servidor")));
                i1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                i1.setEspecificacao(rs.getString("especificacao"));
                i1.setCod_partimonio(rs.getInt("cod_patrimonio"));
                i1.setEstado(rs.getInt("estado"));
                i1.setData_compra(rs.getDate("data_compra").toLocalDate());
                i1.setValor_compra(rs.getDouble("valor_compra"));
                i1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                i1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
                
                return i1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<Object> listar() {
        String sql = "select * from ITEM order by 1";

        List<Object> Item = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                Item i1 = new Item();
                i1.setId(rs.getInt("id"));
                i1.setDono(SDAO.buscaPorId(rs.getInt("id_servidor")));
                i1.setAmbiente(ADAO.buscaPorId(rs.getInt("id_ambiente")));
                i1.setEspecificacao(rs.getString("especificacao"));
                i1.setCod_partimonio(rs.getInt("cod_patrimonio"));
                i1.setEstado(rs.getInt("estado"));
                i1.setData_compra(rs.getDate("data_compra").toLocalDate());
                i1.setValor_compra(rs.getDouble("valor_compra"));
                i1.setData_criacao(rs.getDate("data_criacao").toLocalDate());
                i1.setData_modificacao(rs.getDate("data_modificacao").toLocalDate());
              
                Item.add(i1);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return Item;
    }
    
    public void exclui() {
        String sql = "delete from ITEM";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                CallableStatement cStmt = connection.prepareCall("{call reset_seq(?)}")) {         
            stmt.execute();
            cStmt.setString(1, "item_seq");
            cStmt.execute();
            
            System.out.println("Elementos excluídos com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
