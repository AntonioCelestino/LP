package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Formulario;

public class FormularioDAO {
    
    private static FormularioDAO instance = new FormularioDAO();

    public static FormularioDAO getInstance() {
        return instance;
    }

    private FormularioDAO() {
    }
    
    public static List<Formulario> obterFormularios(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Formulario> formularios = null;
        try {
            tx.begin();
            TypedQuery<Formulario> query = em.createQuery("select f from Formulario f", Formulario.class);
            formularios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return formularios;
    }

    public static Formulario obterFormulario(int codFormulario){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Formulario formulario = null;
        try {
            tx.begin();
            formulario = em.find(Formulario.class, codFormulario);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return formulario;
    }
    
    public void operacao(Formulario formulario, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(formulario);
            } else if(operacao.equals("alterar")){
                em.merge(formulario);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Formulario.class, formulario.getCodFormulario()));
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
