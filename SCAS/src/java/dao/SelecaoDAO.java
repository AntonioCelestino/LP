package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Selecao;

public class SelecaoDAO {
    public static List<Selecao> obterSelecoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Selecao> selecoes = new ArrayList<Selecao>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from SELECAO");
            while (rs.next()) {
                Selecao selecao = new Selecao(
                        rs.getInt("SELECAO_ID"),
                        rs.getString("DT_INICIO_INSCRICAO"),
                        rs.getString("DT_FIM_INSCRICAO"),
                        rs.getString("NUM_EDITAL"), null);
                selecao.setCodModalidade(rs.getInt("MODALIDADE_ID"));
                selecoes.add(selecao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            fecharConexao(conexao, comando);
        }
        return selecoes;
    }

    public static Selecao obterSelecao(int codSelecao) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Selecao selecao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from SELECAO where SELECAO_ID = " + codSelecao);
            rs.first();
            selecao = new Selecao(
                    rs.getInt("SELECAO_ID"),
                    rs.getString("DT_INICIO_INSCRICAO"),
                    rs.getString("DT_FIM_INSCRICAO"),
                    rs.getString("NUM_EDITAL"), null);
            selecao.setCodModalidade(rs.getInt("MODALIDADE_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return selecao;
    }
    
    public static void gravar(Selecao selecao) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into selecao (SELECAO_ID, DT_INICIO_INSCRICAO, DT_FIM_INSCRICAO, NUM_EDITAL, MODALIDADE_ID) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, selecao.getCodSelecao());
            comando.setString(2, selecao.getDataInicioSelecao());
            comando.setString(3, selecao.getDataFimSelecao());
            comando.setString(4, selecao.getNumeroEdital());
            
            if (selecao.getModalidade() == null){
                comando.setNull(5, Types.NULL);
            }else{
                comando.setInt(5, selecao.getCodModalidade());
            }
            
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void alterar(Selecao selecao) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update selecao set DT_INICIO_INSCRICAO = ?, DT_FIM_INSCRICAO = ?, NUM_EDITAL = ?, MODALIDADE_ID = ? where SELECAO_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, selecao.getDataInicioSelecao());
            comando.setString(2, selecao.getDataFimSelecao());
            comando.setString(3, selecao.getNumeroEdital());
            
            if (selecao.getModalidade() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setInt(4, selecao.getCodModalidade());
            }
            comando.setInt(5, selecao.getCodSelecao());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Selecao selecao) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from SELECAO where SELECAO_ID = " + selecao.getCodSelecao();
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
