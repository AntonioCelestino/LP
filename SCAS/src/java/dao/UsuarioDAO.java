package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {

    public static List<Usuario> obterUsuarios() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from USUARIO");
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("USUARIO_ID"),
                        rs.getString("DATA_NASC"),
                        rs.getString("NOME"),
                        rs.getString("SEXO"),
                        rs.getString("CPF"),
                        rs.getString("IDENTIDADE"),
                        rs.getString("TELEFONE_FIXO"),
                        rs.getString("TELEFONE_CELULAR"),
                        rs.getString("EMAIL"),
                        rs.getString("ENDERECO"),
                        rs.getString("NUMERO"),
                        rs.getString("COMPLEMENTO"),
                        rs.getString("BAIRRO"),
                        rs.getString("CEP"),
                        rs.getString("CIDADE"),
                        rs.getString("UF"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuarios;
    }

    public static Usuario obterUsuario(int codUsuario) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from USUARIO where USUARIO_ID = " + codUsuario);
            rs.first();
            usuario = new Usuario(
                    rs.getInt("USUARIO_ID"),
                        rs.getString("DATA_NASC"),
                        rs.getString("NOME"),
                        rs.getString("SEXO"),
                        rs.getString("CPF"),
                        rs.getString("IDENTIDADE"),
                        rs.getString("TELEFONE_FIXO"),
                        rs.getString("TELEFONE_CELULAR"),
                        rs.getString("EMAIL"),
                        rs.getString("ENDERECO"),
                        rs.getString("NUMERO"),
                        rs.getString("COMPLEMENTO"),
                        rs.getString("BAIRRO"),
                        rs.getString("CEP"),
                        rs.getString("CIDADE"),
                        rs.getString("UF"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuario;
    }

    public static void gravar(Usuario usuario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into usuario (USUARIO_ID, DATA_NASC, NOME, SEXO, CPF, IDENTIDADE, TELEFONE_FIXO, TELEFONE_CELULAR, EMAIL, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, UF, LOGIN, SENHA) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, usuario.getCodUsuario());
            comando.setString(2, usuario.getDataNasc());
            comando.setString(3, usuario.getNome());
            comando.setString(4, usuario.getSexo());
            comando.setString(5, usuario.getCpf());
            comando.setString(6, usuario.getIdentidade());
            comando.setString(7, usuario.getTelefoneFixo());
            comando.setString(8, usuario.getTelefoneCelular());
            comando.setString(9, usuario.getEmail());
            comando.setString(10, usuario.getEndereco());
            comando.setString(11, usuario.getNumero());
            comando.setString(12, usuario.getComplemento());
            comando.setString(13, usuario.getBairro());
            comando.setString(14, usuario.getCep());
            comando.setString(15, usuario.getCidade());
            comando.setString(16, usuario.getUf());
            comando.setString(17, usuario.getLogin());
            comando.setString(18, usuario.getSenha());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(Usuario usuario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update usuario set DATA_NASC = ?, NOME = ?, SEXO = ?, CPF = ?, IDENTIDADE = ?, TELEFONE_FIXO = ?, TELEFONE_CELULAR = ?, EMAIL = ?, ENDERECO = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CEP = ?, CIDADE = ?, UF = ?, LOGIN = ?, SENHA = ? where USUARIO_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, usuario.getDataNasc());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getSexo());
            comando.setString(4, usuario.getCpf());
            comando.setString(5, usuario.getIdentidade());
            comando.setString(6, usuario.getTelefoneFixo());
            comando.setString(7, usuario.getTelefoneCelular());
            comando.setString(8, usuario.getEmail());
            comando.setString(9, usuario.getEndereco());
            comando.setString(10, usuario.getNumero());
            comando.setString(11, usuario.getComplemento());
            comando.setString(12, usuario.getBairro());
            comando.setString(13, usuario.getCep());
            comando.setString(14, usuario.getCidade());
            comando.setString(15, usuario.getUf());
            comando.setString(16, usuario.getLogin());
            comando.setString(17, usuario.getSenha());
            comando.setInt(18, usuario.getCodUsuario());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Usuario usuario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from USUARIO where USUARIO_ID = " + usuario.getCodUsuario();
            comando.execute(stringSQL);
        }catch (SQLException e) {
            throw e;
        }finally {
            fecharConexao(conexao, comando);
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
