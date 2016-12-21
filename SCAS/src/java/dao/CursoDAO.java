package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Curso;
import modelo.DAO;

public class CursoDAO extends GenericoDAO<Curso> implements DAO{

    private CursoDAO() {
    }
    
    public static List<Curso> obterCursos(){
        return getInstance().obterClasses("select c from Curso c", Curso.class);
    }

    private static CursoDAO instance = new CursoDAO();

    public static CursoDAO getInstanceMock() {
        return instance;
    }
    
    @Override
    public boolean persistir(Curso curso) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        EntityManager em = getEM();
        EntityTransaction tx = getTX(em);
        try {
            tx.begin();
            em.persist(curso);
            tx.commit();
            retorno = true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return retorno;
    }

    @Override
    public boolean eliminar(Curso curso) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        EntityManager em = getEM();
        EntityTransaction tx = getTX(em);
        try {
            tx.begin();
            em.remove(em.getReference(Curso.class, curso.getCodCurso()));
            tx.commit();
            retorno = true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return retorno;
    }
}
