package modelo;

import dao.AlunoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MATRICULA", nullable = false)
    private Integer matricula;
    @Column(name = "ANO_INGRESSO")
    private Integer anoIngresso;
    @Size(max = 45)
    @Column(name = "PERIODO_CURSO", length = 45)
    private String periodoCurso;
    @Size(max = 45)
    @Column(name = "FAMILIA_ENDERECO", length = 45)
    private String familia_endereco;
    @Size(max = 45)
    @Column(name = "FAMILIA_NUMERO", length = 45)
    private String familia_numero;
    @Size(max = 45)
    @Column(name = "FAMILIA_COMPLEMENTO", length = 45)
    private String familia_complemento;
    @Size(max = 45)
    @Column(name = "FAMILIA_BAIRRO", length = 45)
    private String familia_bairro;
    @Size(max = 45)
    @Column(name = "FAMILIA_CEP", length = 45)
    private String familia_cep;
    @Size(max = 45)
    @Column(name = "FAMILIA_CIDADE", length = 45)
    private String familia_cidade;
    @Size(max = 45)
    @Column(name = "FAMILIA_UF", length = 45)
    private String familia_uf;
    @JoinColumn(name = "CURSO_ID", referencedColumnName = "CURSO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    public Aluno(){
    }

    public static List<Aluno> obterAlunos() throws ClassNotFoundException{
        return AlunoDAO.obterAlunos();
    }
    
    public static Aluno obterAluno(int codAluno) throws ClassNotFoundException{
        return AlunoDAO.obterAluno(codAluno);
    }
    
    public Aluno(Integer matricula, Integer anoIngresso, String periodoCurso, String familia_endereco, String familia_numero, String familia_complemento, String familia_bairro, String familia_cep, String familia_cidade, String familia_uf, Curso curso, Usuario usuario) {
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(Integer anoIngresso) {
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
    
    public Curso getCurso(){
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Aluno[ id=" + matricula + " ]";
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        AlunoDAO.getInstance().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        AlunoDAO.getInstance().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        AlunoDAO.getInstance().excluir(this);
    }
    
}
