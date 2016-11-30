package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Recurso;

public class RecursoDAO {

    private static RecursoDAO instance = new RecursoDAO();

    public static RecursoDAO getInstance() {
        return instance;
    }

    private RecursoDAO() {
    }

    public static List<Recurso> obterRecursos(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Recurso> recursos = null;
        try {
            tx.begin();
            TypedQuery<Recurso> query = em.createQuery("select r from Recurso r", Recurso.class);
            recursos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return recursos;
    }

    public static Recurso obterRecurso(int codRecurso){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Recurso recurso = null;
        try {
            tx.begin();
            recurso = em.find(Recurso.class, codRecurso);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return recurso;
    }

    public void operacao(Recurso recurso, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(recurso);
            } else if(operacao.equals("alterar")){
                em.merge(recurso);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Recurso.class, recurso.getCodRecurso()));
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
}
