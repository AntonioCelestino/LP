package dao;

import java.util.List;
import modelo.Modalidade;

public class ModalidadeDAO extends GenericoDAO<Modalidade>{

    private ModalidadeDAO() {
    }
    
    public static List<Modalidade> obterModalidades(){
        return getInstance().obterClasses("select m from Modalidade m", Modalidade.class);
    }
}
