package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class GenericoDAO <T> {
    private static GenericoDAO instance = new GenericoDAO();

    public static GenericoDAO getInstance() {
        return instance;
    }

    public GenericoDAO() {
    }
    
    public EntityManager getEM(){
        return PersistenceUtil.getEntityManager();
    }
    
    public EntityTransaction getTX(EntityManager em){
        return em.getTransaction();
    }

    public List<T> obterClasses(String jpsl, Class<T> clazz){
        EntityManager em = getEM();
        EntityTransaction tx = getTX(em);
        List<T> ts = null;
        try {
            tx.begin();
            TypedQuery<T> query = em.createQuery(jpsl, clazz);
            ts = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return ts;
    }
    
    public T obterClasse(Class<T> clazz, int codClasse){
        EntityManager em = getEM();
        EntityTransaction tx = getTX(em);
        T t = null;
        try {
            tx.begin();
            t = em.find(clazz, codClasse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return t;
    }
    
    public void operacao(T t, String operacao, int codClasse){
        EntityManager em = getEM();
        EntityTransaction tx = getTX(em);
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(t);
            } else if(operacao.equals("alterar")){
                em.merge(t);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(t.getClass(), codClasse));
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
