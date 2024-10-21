package br.com.fiap.bo;

import br.com.fiap.dao.OficinaDAO;
import br.com.fiap.to.OficinaTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaBO {
    private OficinaDAO oficinaDAO;

    public ArrayList<OficinaTO> findAll() {
        oficinaDAO = new OficinaDAO();
        //aqui se implementa a regra de negócios
        return  oficinaDAO.findAll();
    }

    public OficinaTO findByCodigo(Long codigo) {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.findByCodigo(codigo);
    }

    public OficinaTO save(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        //aqui se implementa a regra de negócios
//        if (!oficina.getDataDeFabricacao().isBefore(LocalDate.now())) { // se não for
//            return null;
//        }
//        if (!oficina.getDataDeValidade().isAfter(LocalDate.now())) { // se não for
//            return null;
//        }
        return oficinaDAO.save(oficina);
    }

    public  boolean delete(Long codigo){
        oficinaDAO = new OficinaDAO();
        //aqui se implementa a regra de negócios
        return oficinaDAO.delete(codigo);
    }

    public OficinaTO update(OficinaTO oficina) throws SQLException {
        oficinaDAO = new OficinaDAO();
        //aqui se implementa a regra de negócios
        return oficinaDAO.update(oficina);
    }
}
