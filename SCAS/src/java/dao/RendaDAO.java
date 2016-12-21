package dao;

import java.util.List;
import modelo.Renda;

public class RendaDAO extends GenericoDAO<Renda>{

    private RendaDAO() {
    }

    public static List<Renda> obterRendas(){
        return getInstance().obterClasses("select r from Renda r", Renda.class);
    }
}
