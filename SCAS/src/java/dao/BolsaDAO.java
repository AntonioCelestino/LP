package dao;

import java.util.List;
import modelo.Bolsa;

public class BolsaDAO extends GenericoDAO<Bolsa>{
    
    private BolsaDAO() {
    }

    public static List<Bolsa> obterBolsas(){
        return getInstance().obterClasses("select b from Bolsa b", Bolsa.class);
    }
}
