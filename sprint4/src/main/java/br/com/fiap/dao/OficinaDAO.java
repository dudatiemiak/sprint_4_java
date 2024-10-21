package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository{
    public ArrayList<OficinaTO> findAll(){

        ArrayList<OficinaTO> oficinas = new ArrayList<>();
        String sql = "SELECT * FROM ddd_oficinas ORDER BY codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    OficinaTO oficina = new OficinaTO();
                    oficina.setCodigo(rs.getLong("codigo"));
                    oficina.setNome_oficina(rs.getString("nome_oficina"));
                    oficina.setCnpj(rs.getLong("cnpj"));
                    oficina.setStatus(rs.getString("status"));
                    oficina.setCep(rs.getString("cep"));
                    oficinas.add(oficina);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return oficinas;
    }
    
    public OficinaTO findByCodigo(Long codigo){
        OficinaTO oficina = null;
        String sql = "SELECT * FROM ddd_oficinas WHERE codigo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    oficina = new OficinaTO();
                    oficina.setCodigo(rs.getLong("codigo"));
                    oficina.setNome_oficina(rs.getString("nome_oficina"));
                    oficina.setCnpj(rs.getLong("cnpj"));
                    oficina.setStatus(rs.getString("status"));
                    oficina.setCep(rs.getString("cep"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return oficina;
    }
    public OficinaTO save(OficinaTO oficina){
        String sql = "insert into ddd_oficinas(codigo, nome_oficina, cnpj, status, cep) values(null, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, oficina.getNome_oficina());
            ps.setLong(2, oficina.getCnpj());
            ps.setString(3, oficina.getStatus());
            ps.setString(4, oficina.getCep());

            if (ps.executeUpdate() > 0) {
                return oficina;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo){
        String sql = "delete from ddd_oficinas where codigo = ?";
        //abrindo conexão com o banco, garante a liberação do recurso que o preparedStatment vai liberar
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0; //vai executar o comando e comparar se é menor que zero, se for maior que zero retorna true - quando da verdadeiro significa que deu certo e conseguiu apagar
        } catch (SQLException e) {
            System.out.printf("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection(); //de qualquer forma fecha a comexão
        }
        return false; //se ele chegou até aqui significa que ele não conseguiu apagar. mas é muito dificil ele chegar nessa linha
    }

    public OficinaTO update(OficinaTO oficina) throws SQLException {
        String sql = "update ddd_oficinas set nome_oficina =?, cnpj =?, status =?, cep =? where codigo=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, oficina.getNome_oficina());
            ps.setLong(2, oficina.getCnpj());
            ps.setString(3, oficina.getStatus());
            ps.setString(4, oficina.getCep());
            ps.setLong(5, oficina.getCodigo());
            if (ps.executeUpdate() > 0){
                return oficina;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
