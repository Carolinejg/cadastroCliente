package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import util.DbUtil;



public class ClienteDAO {
	private Connection connection;

    public ClienteDAO() {
        connection = DbUtil.getConnection();
    }
    
    public void addCliente(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into prv_cliente(nome,rg,cpf,celular,email,nome_mae,nome_pai,data_nasc, data_cadastro) values (?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getRg());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getCelular());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setString(6, cliente.getNomeMae());
            preparedStatement.setString(7, cliente.getNomePai());
            preparedStatement.setDate(8, new java.sql.Date(cliente.getDataNsc().getTime()));
            preparedStatement.setTimestamp(9, new java.sql.Timestamp(cliente.getDataCad().getTime()));
                     
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public Cliente getClienteByCpf(String clienteCpf) {
    	
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from prv_cliente where cpf=?");
            preparedStatement.setString(1, clienteCpf);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	
            	Cliente cliente = new Cliente();
            	cliente.setNome(rs.getString("nome"));
            	cliente.setRg(rs.getString("rg"));
            	cliente.setCpf(rs.getString("cpf"));
            	cliente.setCelular(rs.getString("celular"));
            	cliente.setEmail(rs.getString("email"));
            	cliente.setNomeMae(rs.getString("nome_mae"));
            	cliente.setNomePai(rs.getString("nome_pai"));
            	cliente.setDataNsc(rs.getDate("data_nasc"));
            	cliente.setDataCad(rs.getTimestamp("data_cadastro"));
            	return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
