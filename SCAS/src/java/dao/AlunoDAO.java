package dao;

import java.util.List;
import modelo.Aluno;

public class AlunoDAO extends GenericoDAO<Aluno>{

    private AlunoDAO() {
    }
    
    public static List<Aluno> obterAlunos(){
        return getInstance().obterClasses("select a from Aluno a", Aluno.class);
    }
}
