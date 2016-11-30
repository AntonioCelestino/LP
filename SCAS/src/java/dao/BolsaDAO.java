package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Bolsa;

public class BolsaDAO {

    private static BolsaDAO instance = new BolsaDAO();

    public static BolsaDAO getInstance() {
        return instance;
    }

    private BolsaDAO() {
    }

    public static List<Bolsa> obterBolsas(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Bolsa> bolsas = null;
        try {
            tx.begin();
            TypedQuery<Bolsa> query = em.createQuery("select b from Bolsa b", Bolsa.class);
            bolsas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return bolsas;
    }

    public static Bolsa obterBolsa(int codBolsa){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Bolsa bolsa = null;
        try {
            tx.begin();
            bolsa = em.find(Bolsa.class, codBolsa);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return bolsa;
    }

    public void operacao(Bolsa bolsa, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(bolsa);
            } else if(operacao.equals("alterar")){
                em.merge(bolsa);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Bolsa.class, bolsa.getCodBolsa()));
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
