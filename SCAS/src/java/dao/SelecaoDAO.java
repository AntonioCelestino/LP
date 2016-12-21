package dao;

import java.util.List;
import modelo.Selecao;

public class SelecaoDAO extends GenericoDAO<Selecao>{

    private SelecaoDAO() {
    }

    public static List<Selecao> obterSelecoes(){
        return getInstance().obterClasses("select s from Selecao s", Selecao.class);
    }
}
