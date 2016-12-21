package dao;

import java.util.List;
import modelo.Formulario;

public class FormularioDAO extends GenericoDAO<Formulario>{

    private FormularioDAO() {
    }
    
    public static List<Formulario> obterFormularios(){
        return getInstance().obterClasses("select f from Formulario f", Formulario.class);
    }
}
