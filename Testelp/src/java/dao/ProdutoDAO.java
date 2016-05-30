package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Produto;

public class ProdutoDAO {
    
    private static ProdutoDAO instance = new ProdutoDAO();
    
    public static ProdutoDAO getInstance(){
        return instance;
    }
    
    private ProdutoDAO(){
    }
    
    public void salvar(Produto produto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(produto);
            tx.commit();
        }catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
    }
    public void alterar(Produto produto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(produto);
            tx.commit();
        }catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
    }
    public void excluir(Produto produto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Produto.class, produto.getId()));
            tx.commit();
        }catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
    }
    
    public static Produto obterProduto(int id){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Produto produto = null;
        try {
            tx.begin();
            produto = em.find(Produto.class, id);
            tx.commit();
        }catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return produto;
    }
    
    public static List<Produto> obterProdutos(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Produto> produtos = null;
        try {
            tx.begin();
            TypedQuery<Produto> query = em.createQuery("select p from Produto p", Produto.class);
            produtos = query.getResultList();
            tx.commit();
        }catch (Exception e){
            if (tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return produtos;
    }
}
