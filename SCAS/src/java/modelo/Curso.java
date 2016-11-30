package modelo;

import dao.CursoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "CURSO_ID", nullable = false)
    private Integer codCurso;
    @Size(max = 45)
    @Column(name = "NOME", length = 45)
    private String nome;
    @Size(max = 45)
    @Column(name = "TIPO_ENSINO", length = 45)
    private String tipoEnsino;
    @Size(max = 45)
    @Column(name = "TURNO", length = 45)
    private String turno;
    
    public Curso(){
    }
    
    public boolean persistir(DAO cursoDAO) throws SQLException, ClassNotFoundException {
        return cursoDAO.persistir(this);
    }
    public boolean eliminar(DAO cursoDAO) throws SQLException, ClassNotFoundException {
        return cursoDAO.eliminar(this);
    }
    
    public static List<Curso> obterCursos() throws ClassNotFoundException{
        return CursoDAO.obterCursos();
    }
    
    public static Curso obterCurso(int codCurso) throws ClassNotFoundException{
        return CursoDAO.obterCurso(codCurso);
    }

    public Curso(Integer codCurso, String nome, String tipoEnsino, String turno) {
        this.codCurso = codCurso;
        this.nome = nome;
        this.tipoEnsino = tipoEnsino;
        this.turno = turno;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Curso[ id=" + codCurso + " ]";
    }    
}
