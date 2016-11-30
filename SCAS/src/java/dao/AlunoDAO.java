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
import modelo.Aluno;

public class AlunoDAO {
    
    public static boolean verificarAluno(int codUsuario) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean resultado = false;
        try {
            conexao = BD.getConexao();
            String sql = "select * from aluno where USUARIO_ID = ?";
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
    
    private static AlunoDAO instance = new AlunoDAO();

    public static AlunoDAO getInstance() {
        return instance;
    }

    private AlunoDAO() {
    }
    
    public static List<Aluno> obterAlunos(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Aluno> alunos = null;
        try {
            tx.begin();
            TypedQuery<Aluno> query = em.createQuery("select a from Aluno a", Aluno.class);
            alunos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return alunos;
    }

    public static Aluno obterAluno(int codAluno){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Aluno aluno = null;
        try {
            tx.begin();
            aluno = em.find(Aluno.class, codAluno);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return aluno;
    }
    
    public void operacao(Aluno aluno, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(aluno);
            } else if(operacao.equals("alterar")){
                em.merge(aluno);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Aluno.class, aluno.getMatricula()));
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
