package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Modalidade;

public class ModalidadeDAO {

    public static List<Modalidade> obterModalidades() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Modalidade> modalidades = new ArrayList<Modalidade>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from MODALIDADE");
            while (rs.next()) {
                Modalidade modalidade = new Modalidade(
                        rs.getInt("MODALIDADE_ID"),
                        rs.getString("NOME"),
                        rs.getDouble("VALOR_MENSAL"),
                        rs.getString("DESCRICAO"));
                modalidades.add(modalidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return modalidades;
    }

    public static Modalidade obterModalidade(int codModalidade) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Modalidade modalidade = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from MODALIDADE where MODALIDADE_ID = " + codModalidade);
            while (rs.next()) {
                modalidade = new Modalidade(
                        rs.getInt("MODALIDADE_ID"),
                        rs.getString("NOME"),
                        rs.getDouble("VALOR_MENSAL"),
                        rs.getString("DESCRICAO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return modalidade;
    }
    
    public static void gravar(Modalidade modalidade) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into modalidade (MODALIDADE_ID, NOME, VALOR_MENSAL, DESCRICAO) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, modalidade.getCodModalidade());
            comando.setString(2, modalidade.getNome());
            comando.setDouble(3, modalidade.getValorMensal());
            comando.setString(4, modalidade.getDescricao());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(Modalidade modalidade) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update modalidade set NOME = ?, VALOR_MENSAL = ?, DESCRICAO = ? where MODALIDADE_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, modalidade.getNome());
            comando.setDouble(2, modalidade.getValorMensal());
            comando.setString(3, modalidade.getDescricao());
            comando.setInt(4, modalidade.getCodModalidade());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Modalidade modalidade) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from MODALIDADE where MODALIDADE_ID = " + modalidade.getCodModalidade();
            comando.execute(stringSQL);
        }catch (SQLException e) {
            throw e;
        }finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void fecharConexao(Connection conexao, Statement comando) {
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
