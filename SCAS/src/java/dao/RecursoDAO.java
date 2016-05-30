package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Recurso;

public class RecursoDAO {
    public static List<Recurso> obterRecursos() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Recurso> recursos = new ArrayList<Recurso>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from RECURSO");
            while(rs.next()){
                Recurso recurso = new Recurso(
                        rs.getInt("RECURSO_ID"),
                        rs.getInt("ANO"),
                        rs.getDouble("CREDITOS"),
                        rs.getDouble("DEBITOS"),
                        rs.getDouble("SALDO"),null);
                recurso.setCodModalidade(rs.getInt("MODALIDADE_ID"));
                recursos.add(recurso);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return recursos;
    }
    
    public static Recurso obterRecurso(int codRecurso) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Recurso recurso = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from RECURSO where RECURSO_ID = " + codRecurso);
            rs.first();
            recurso = new Recurso(
                    rs.getInt("RECURSO_ID"),
                    rs.getInt("ANO"),
                    rs.getDouble("CREDITOS"),
                    rs.getDouble("DEBITOS"),
                    rs.getDouble("SALDO"),null);
            recurso.setCodModalidade(rs.getInt("MODALIDADE_ID"));
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return recurso;
    }
    
    public static void gravar(Recurso recurso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into recurso (RECURSO_ID, ANO, CREDITOS, DEBITOS, SALDO, MODALIDADE_ID) values (?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, recurso.getCodRecurso());
            comando.setInt(2, recurso.getAno());
            comando.setDouble(3, recurso.getCreditos());
            comando.setDouble(4, recurso.getDebitos());
            comando.setDouble(5, recurso.getSaldo());
            
            if (recurso.getModalidade() == null){
                comando.setNull(6, Types.NULL);
            }else{
                comando.setInt(6, recurso.getCodModalidade());
            }
            
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Recurso recurso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update recurso set ANO = ?, CREDITOS = ?, DEBITOS = ?, SALDO = ?, MODALIDADE_ID = ? where RECURSO_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, recurso.getAno());
            comando.setDouble(2, recurso.getCreditos());
            comando.setDouble(3, recurso.getDebitos());
            comando.setDouble(4, recurso.getSaldo());
            
            if (recurso.getModalidade() == null){
                comando.setNull(5, Types.NULL);
            }else{
                comando.setInt(5, recurso.getCodModalidade());
            }
            comando.setInt(6, recurso.getCodRecurso());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Recurso recurso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from RECURSO where RECURSO_ID = " + recurso.getCodRecurso();
            comando.execute(stringSQL);
        }catch (SQLException e) {
            throw e;
        }finally {
            fecharConexao(conexao, comando);
        }
    }

    private static void fecharConexao(Connection conexao, Statement comando) {
        try{
            if(comando != null){
                comando.close();
            }
            if(conexao != null){
                conexao.close();
            }
        }catch(SQLException e){
        }
    }
}
