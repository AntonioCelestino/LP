package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Modalidade;

public class ModalidadeDAO {
    
    private static ModalidadeDAO instance = new ModalidadeDAO();

    public static ModalidadeDAO getInstance() {
        return instance;
    }

    private ModalidadeDAO() {
    }
    
    public static List<Modalidade> obterModalidades(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Modalidade> modalidades = null;
        try {
            tx.begin();
            TypedQuery<Modalidade> query = em.createQuery("select m from Modalidade m", Modalidade.class);
            modalidades = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return modalidades;
    }

    public static Modalidade obterModalidade(int codModalidade){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Modalidade modalidade = null;
        try {
            tx.begin();
            modalidade = em.find(Modalidade.class, codModalidade);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return modalidade;
    }
    
    public void operacao(Modalidade modalidade, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(modalidade);
            } else if(operacao.equals("alterar")){
                em.merge(modalidade);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Modalidade.class, modalidade.getCodModalidade()));
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
