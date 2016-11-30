package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Renda;

public class RendaDAO {
    
    private static RendaDAO instance = new RendaDAO();

    public static RendaDAO getInstance() {
        return instance;
    }

    private RendaDAO() {
    }

    public static List<Renda> obterRendas(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Renda> rendas = null;
        try {
            tx.begin();
            TypedQuery<Renda> query = em.createQuery("select r from Renda r", Renda.class);
            rendas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return rendas;
    }

    public static Renda obterRenda(int codRenda){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Renda renda = null;
        try {
            tx.begin();
            renda = em.find(Renda.class, codRenda);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return renda;
    }

    public void operacao(Renda renda, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(renda);
            } else if(operacao.equals("alterar")){
                em.merge(renda);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Renda.class, renda.getCodRenda()));
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
