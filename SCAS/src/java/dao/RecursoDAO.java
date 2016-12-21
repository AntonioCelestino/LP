package dao;

import java.util.List;
import modelo.Recurso;

public class RecursoDAO extends GenericoDAO<Recurso>{

    private RecursoDAO() {
    }

    public static List<Recurso> obterRecursos(){
        return getInstance().obterClasses("select r from Recurso r", Recurso.class);
    }
}
