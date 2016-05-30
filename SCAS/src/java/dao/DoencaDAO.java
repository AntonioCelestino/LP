package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Doenca;

public class DoencaDAO {
    public static List<Doenca> obterDoencas() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Doenca> doencas = new ArrayList<Doenca>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from DOENCA");
            while(rs.next()){
                Doenca doenca = new Doenca(
                        rs.getInt("DOENCA_ID"),null,
                        rs.getString("QT17_NOME"),
                        rs.getString("QT17_DOENCA"),
                        rs.getString("QT17_TRABALHO"),
                        rs.getString("QT17_DEPENDENCIA"),
                        rs.getDouble("QT17_GASTO"));
                doenca.setCodFormulario(rs.getInt("FORMULARIO_ID"));
                doencas.add(doenca);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return doencas;
    }
    
    public static Doenca obterDoenca(int codDoenca) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Doenca doenca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from DOENCA where DOENCA_ID = " + codDoenca);
            rs.first();
            doenca = new Doenca(
                        rs.getInt("DOENCA_ID"),null,
                        rs.getString("QT17_NOME"),
                        rs.getString("QT17_DOENCA"),
                        rs.getString("QT17_TRABALHO"),
                        rs.getString("QT17_DEPENDENCIA"),
                        rs.getDouble("QT17_GASTO"));
                doenca.setCodFormulario(rs.getInt("FORMULARIO_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return doenca;
    }
    
    public static void gravar(Doenca doenca) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into doenca (DOENCA_ID, FORMULARIO_ID, QT17_NOME, QT17_DOENCA, QT17_TRABALHO, QT17_DEPENDENCIA, QT17_GASTO) values (?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, doenca.getCodDoenca());
            if (doenca.getFormulario() == null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setInt(2, doenca.getCodFormulario());
            }
            comando.setString(3, doenca.getQt17_Nome());
            comando.setString(4, doenca.getQt17_Doenca());
            comando.setString(5, doenca.getQt17_Trabalho());
            comando.setString(6, doenca.getQt17_Dependencia());
            comando.setDouble(7, doenca.getQt17_Gasto());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Doenca doenca) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update doenca set FORMULARIO_ID = ?, QT17_NOME = ?, QT17_DOENCA = ?, QT17_TRABALHO = ?, QT17_DEPENDENCIA = ?, QT17_GASTO = ? where DOENCA_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            if (doenca.getFormulario() == null){
                comando.setNull(1, Types.NULL);
            }else{
                comando.setInt(1, doenca.getCodFormulario());
            }
            comando.setString(2, doenca.getQt17_Nome());
            comando.setString(3, doenca.getQt17_Doenca());
            comando.setString(4, doenca.getQt17_Trabalho());
            comando.setString(5, doenca.getQt17_Dependencia());
            comando.setDouble(6, doenca.getQt17_Gasto());
            comando.setInt(7, doenca.getCodDoenca());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Doenca doenca) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from DOENCA where DOENCA_ID = " + doenca.getCodDoenca();
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
