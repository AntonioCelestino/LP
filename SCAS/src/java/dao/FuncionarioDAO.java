package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Funcionario;

public class FuncionarioDAO {
    
    public static boolean verificarFuncionario(int codUsuario) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean resultado = false;
        try {
            conexao = BD.getConexao();
            String sql = "select * from funcionario where USUARIO_ID = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, codUsuario);
            ResultSet rs = comando.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return resultado;
    }
    
    private static FuncionarioDAO instance = new FuncionarioDAO();

    public static FuncionarioDAO getInstance() {
        return instance;
    }

    private FuncionarioDAO() {
    }
    
    public static List<Funcionario> obterFuncionarios(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Funcionario> funcionarios = null;
        try {
            tx.begin();
            TypedQuery<Funcionario> query = em.createQuery("select f from Funcionario f", Funcionario.class);
            funcionarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionarios;
    }

    public static Funcionario obterFuncionario(int codFuncionario){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Funcionario funcionario = null;
        try {
            tx.begin();
            funcionario = em.find(Funcionario.class, codFuncionario);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionario;
    }
    
    public void operacao(Funcionario funcionario, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(funcionario);
            } else if(operacao.equals("alterar")){
                em.merge(funcionario);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Funcionario.class, funcionario.getRegistro()));
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
    
    private static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
        }
    }
}
