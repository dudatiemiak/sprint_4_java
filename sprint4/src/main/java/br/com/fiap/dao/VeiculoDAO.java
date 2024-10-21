package br.com.fiap.dao;

import br.com.fiap.to.VeiculoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository{
    public ArrayList<VeiculoTO> findAll() {
        ArrayList<VeiculoTO> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos ORDER BY codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VeiculoTO veiculo = new VeiculoTO();
                    veiculo.setCodigo(rs.getLong("codigo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setTipo(rs.getString("tipo"));
                    veiculo.setQuilometragem(rs.getFloat("quilometragem"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setAno(rs.getInt("ano"));
                    veiculos.add(veiculo);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculos;
    }

    public VeiculoTO findByCodigo(Long codigo) {
        VeiculoTO veiculo = null;
        String sql = "SELECT * FROM veiculos WHERE codigo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                veiculo = new VeiculoTO();
                veiculo.setCodigo(rs.getLong("codigo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setTipo(rs.getString("tipo"));
                veiculo.setQuilometragem(rs.getFloat("quilometragem"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        String sql = "INSERT INTO veiculos (placa, tipo, quilometragem, marca, modelo, ano) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getTipo());
            ps.setFloat(3, veiculo.getQuilometragem());
            ps.setString(4, veiculo.getMarca());
            ps.setString(5, veiculo.getModelo());
            ps.setInt(6, veiculo.getAno());

            if (ps.executeUpdate() > 0) {
                return veiculo;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "DELETE FROM veiculos WHERE codigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public VeiculoTO update(VeiculoTO veiculo) throws SQLException {
        String sql = "UPDATE veiculos SET placa = ?, tipo = ?, quilometragem = ?, marca = ?, modelo = ?, ano = ? WHERE codigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getTipo());
            ps.setFloat(3, veiculo.getQuilometragem());
            ps.setString(4, veiculo.getMarca());
            ps.setString(5, veiculo.getModelo());
            ps.setInt(6, veiculo.getAno());
            ps.setLong(7, veiculo.getCodigo());

            if (ps.executeUpdate() > 0) {
                return veiculo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
