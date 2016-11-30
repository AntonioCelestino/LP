package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Doenca;

public class DoencaDAO {
    
    private static DoencaDAO instance = new DoencaDAO();

    public static DoencaDAO getInstance() {
        return instance;
    }

    private DoencaDAO() {
    }
    
    public static List<Doenca> obterDoencas(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Doenca> doencas = null;
        try {
            tx.begin();
            TypedQuery<Doenca> query = em.createQuery("select d from Doenca d", Doenca.class);
            doencas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return doencas;
    }

    public static Doenca obterDoenca(int codDoenca){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Doenca doenca = null;
        try {
            tx.begin();
            doenca = em.find(Doenca.class, codDoenca);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return doenca;
    }
    
    public void operacao(Doenca doenca, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(doenca);
            } else if(operacao.equals("alterar")){
                em.merge(doenca);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Doenca.class, doenca.getCodDoenca()));
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
