package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO extends GenericoDAO<Usuario>{
    
    private UsuarioDAO() {
    }

    public static List<Usuario> obterUsuarios(){
        return getInstance().obterClasses("select u from Usuario u", Usuario.class);
    }
    
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
