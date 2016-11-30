package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Selecao;

public class SelecaoDAO {
    
    private static SelecaoDAO instance = new SelecaoDAO();

    public static SelecaoDAO getInstance() {
        return instance;
    }

    private SelecaoDAO() {
    }

    public static List<Selecao> obterSelecoes(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Selecao> selecoes = null;
        try {
            tx.begin();
            TypedQuery<Selecao> query = em.createQuery("select s from Selecao s", Selecao.class);
            selecoes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return selecoes;
    }

    public static Selecao obterSelecao(int codSelecao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Selecao selecao = null;
        try {
            tx.begin();
            selecao = em.find(Selecao.class, codSelecao);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return selecao;
    }

    public void operacao(Selecao selecao, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(selecao);
            } else if(operacao.equals("alterar")){
                em.merge(selecao);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Selecao.class, selecao.getCodSelecao()));
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
