package dao;

import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO extends GenericoDAO<Funcionario>{

    private FuncionarioDAO() {
    }
    
    public static List<Funcionario> obterFuncionarios(){
        return getInstance().obterClasses("select f from Funcionario f", Funcionario.class);
    }
}
