package dao;

import java.util.List;
import modelo.Doenca;

public class DoencaDAO extends GenericoDAO<Doenca>{

    private DoencaDAO() {
    }
    
    public static List<Doenca> obterDoencas(){
        return getInstance().obterClasses("select d from Doenca d", Doenca.class);
    }
}
