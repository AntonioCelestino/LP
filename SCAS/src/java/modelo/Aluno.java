package modelo;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Aluno {
    private int matricula;
    private int anoIngresso;
    private String periodoCurso;
    private String familia_endereco;
    private String familia_numero;
    private String familia_complemento;
    private String familia_bairro;
    private String familia_cep;
    private String familia_cidade;
    private String familia_uf;
    private Curso curso;
    private Usuario usuario;
    
    private int codCurso;
    private int codUsuario;

    public Aluno(int matricula, int anoIngresso, String periodoCurso, String familia_endereco, String familia_numero, String familia_complemento, String familia_bairro, String familia_cep, String familia_cidade, String familia_uf, Curso curso, Usuario usuario) {
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
        this.periodoCurso = periodoCurso;
        this.familia_endereco = familia_endereco;
        this.familia_numero = familia_numero;
        this.familia_complemento = familia_complemento;
        this.familia_bairro = familia_bairro;
        this.familia_cep = familia_cep;
        this.familia_cidade = familia_cidade;
        this.familia_uf = familia_uf;
        this.curso = curso;
        this.usuario = usuario;
    }
    
    public static List<Aluno> obterAlunos() throws ClassNotFoundException{
        return AlunoDAO.obterAlunos();
    }
    
    public static Aluno obterAluno(int codAluno) throws ClassNotFoundException{
        return AlunoDAO.obterAluno(codAluno);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getPeriodoCurso() {
        return periodoCurso;
    }

    public void setPeriodoCurso(String periodoCurso) {
        this.periodoCurso = periodoCurso;
    }

    public String getFamilia_endereco() {
        return familia_endereco;
    }

    public void setFamilia_endereco(String familia_endereco) {
        this.familia_endereco = familia_endereco;
    }

    public String getFamilia_numero() {
        return familia_numero;
    }

    public void setFamilia_numero(String familia_numero) {
        this.familia_numero = familia_numero;
    }

    public String getFamilia_complemento() {
        return familia_complemento;
    }

    public void setFamilia_complemento(String familia_complemento) {
        this.familia_complemento = familia_complemento;
    }

    public String getFamilia_bairro() {
        return familia_bairro;
    }

    public void setFamilia_bairro(String familia_bairro) {
        this.familia_bairro = familia_bairro;
    }

    public String getFamilia_cep() {
        return familia_cep;
    }

    public void setFamilia_cep(String familia_cep) {
        this.familia_cep = familia_cep;
    }

    public String getFamilia_cidade() {
        return familia_cidade;
    }

    public void setFamilia_cidade(String familia_cidade) {
        this.familia_cidade = familia_cidade;
    }

    public String getFamilia_uf() {
        return familia_uf;
    }

    public void setFamilia_uf(String familia_uf) {
        this.familia_uf = familia_uf;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    public Curso getCurso() throws ClassNotFoundException{
        if ((codCurso != 0) && (curso == null)){
            curso = CursoDAO.obterCurso(codCurso);
        }
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() throws ClassNotFoundException {
        if ((codUsuario != 0) && (usuario == null)) {
            usuario = UsuarioDAO.obterUsuario(codUsuario);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        AlunoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        AlunoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        AlunoDAO.excluir(this);
    }
    
}
