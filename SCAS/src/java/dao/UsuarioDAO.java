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
import modelo.Usuario;

public class UsuarioDAO {
    
    public static boolean verificarUsuario(String login, String senha) throws ClassNotFoundException {
        Connection conexao = null;

        // Tratando SQL Injection
        // Login a ser digitado: ' or 1=1; --      (coloque um espaÃ§o no final)
        PreparedStatement comando = null;

        // Sem tratar SQL Injection
        //Statement comando = null;
        //Usuario usuario = null;
        boolean resultado = false;
        try {
            conexao = BD.getConexao();

            // Sem tratar SQL Injection
            //comando = conexao.createStatement();
            //String sql = "select * from usuario where login = '" + login + "' and senha = '" + senha + "'";
            //ResultSet rs = comando.executeQuery(sql);
            //Tratando SQL Injection
            String sql = "select * from usuario where login = ? and senha = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, login);
            comando.setString(2, senha);
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
    
    public static boolean verificarTipoUsuario(int codUsuario, String tipoUsuario) 
            throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean resultado = false;
        try {
            conexao = BD.getConexao();
            String sql = "select * from "+tipoUsuario+" where USUARIO_ID = ?";
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
    
    public static int getCodUsuarioPorLogin(String login, String senha) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        int codUsuario = -1;
        try {
            conexao = BD.getConexao();
            String sql = "select * from usuario where login = ? and senha = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                codUsuario = rs.getInt("USUARIO_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return codUsuario;
    }
    
    private static UsuarioDAO instance = new UsuarioDAO();

    public static UsuarioDAO getInstance() {
        return instance;
    }

    private UsuarioDAO() {
    }

    public static List<Usuario> obterUsuarios(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Usuario> usuarios = null;
        try {
            tx.begin();
            TypedQuery<Usuario> query = em.createQuery("select u from Usuario u", Usuario.class);
            usuarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return usuarios;
    }

    public static Usuario obterUsuario(int codUsuario){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Usuario usuario = null;
        try {
            tx.begin();
            usuario = em.find(Usuario.class, codUsuario);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return usuario;
    }

    public void operacao(Usuario usuario, String operacao){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(operacao.equals("gravar")){
                em.persist(usuario);
            } else if(operacao.equals("alterar")){
                em.merge(usuario);
            } else if(operacao.equals("excluir")){
                em.remove(em.getReference(Usuario.class, usuario.getCodUsuario()));
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
