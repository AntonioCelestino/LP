package modelo;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

public class Curso {
    private int codCurso;
    private String nome;
    private String tipoEnsino;
    private String turno;
    
    public static List<Curso> obterCursos() throws ClassNotFoundException{
        return CursoDAO.obterCursos();
    }
    
    public static Curso obterCurso(int codCurso) throws ClassNotFoundException{
        return CursoDAO.obterCurso(codCurso);
    }

    public Curso(int codCurso, String nome, String tipoEnsino, String turno) {
        this.codCurso = codCurso;
        this.nome = nome;
        this.tipoEnsino = tipoEnsino;
        this.turno = turno;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoEnsino() {
        return tipoEnsino;
    }

    public void setTipoEnsino(String tipoEnsino) {
        this.tipoEnsino = tipoEnsino;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        CursoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        CursoDAO.excluir(this);
    }
    
}
