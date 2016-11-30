package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Curso;
import modelo.DAO;

public class CursoDAO implements DAO {
    
    private static CursoDAO instance = new CursoDAO();

    public static CursoDAO getInstance() {
        return instance;
    }

    private CursoDAO() {
    }
    
    public static List<Curso> obterCursos(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Curso> cursos = null;
        try {
            tx.begin();
            TypedQuery<Curso> query = em.createQuery("select c from Curso c", Curso.class);
            cursos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cursos;
    }

    public static Curso obterCurso(int codCurso){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Curso curso = null;
        try {
            tx.begin();
            curso = em.find(Curso.class, codCurso);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return curso;
    }
    
    public void operacao(Curso curso, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(curso);
            } else if(operacao.equals("alterar")){
                em.merge(curso);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Curso.class, curso.getCodCurso()));
            }            
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }   

    @Override
    public boolean persistir(Curso curso) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
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
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
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
