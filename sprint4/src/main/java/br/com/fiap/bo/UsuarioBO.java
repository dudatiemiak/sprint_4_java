package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public ArrayList<UsuarioTO> findAll() {
        usuarioDAO = new UsuarioDAO();
        //aqui se implementa a regra de negócios
        return  usuarioDAO.findAll();
    }

    public UsuarioTO findByCodigo(Long codigo) {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.findByCodigo(codigo);
    }

    public UsuarioTO save(UsuarioTO oficina) {
        usuarioDAO = new UsuarioDAO();
        //aqui se implementa a regra de negócios
//        if (!oficina.getDataDeFabricacao().isBefore(LocalDate.now())) { // se não for
//            return null;
//        }
//        if (!oficina.getDataDeValidade().isAfter(LocalDate.now())) { // se não for
//            return null;
//        }
        return usuarioDAO.save(oficina);
    }

    public  boolean delete(Long codigo){
        usuarioDAO = new UsuarioDAO();
        //aqui se implementa a regra de negócios
        return usuarioDAO.delete(codigo);
    }

    public UsuarioTO update(UsuarioTO oficina) throws SQLException {
        usuarioDAO = new UsuarioDAO();
        //aqui se implementa a regra de negócios
        return usuarioDAO.update(oficina);
    }
}
