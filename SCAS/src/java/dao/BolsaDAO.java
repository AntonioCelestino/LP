package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Bolsa;

public class BolsaDAO {
    public static List<Bolsa> obterBolsas() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Bolsa> bolsas = new ArrayList<Bolsa>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from BOLSA");
            while(rs.next()){
                Bolsa bolsa = new Bolsa(
                        rs.getInt("BOLSA_ID"),
                        rs.getString("DT_INICIO"),
                        rs.getString("DT_FIM"), null);
                bolsa.setCodFormulario(rs.getInt("FORMULARIO_ID"));
                bolsas.add(bolsa);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return bolsas;
    }
    
    public static Bolsa obterBolsa(int codBolsa) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Bolsa bolsa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from BOLSA where BOLSA_ID = " + codBolsa);
            rs.first();
            bolsa = new Bolsa(
                        rs.getInt("BOLSA_ID"),
                        rs.getString("DT_INICIO"),
                        rs.getString("DT_FIM"), null);
                bolsa.setCodFormulario(rs.getInt("FORMULARIO_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return bolsa;
    }
    
    public static void gravar(Bolsa bolsa) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into bolsa (BOLSA_ID, DT_INICIO, DT_FIM, FORMULARIO_ID) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, bolsa.getCodBolsa());
            comando.setString(2, bolsa.getDataInicio());
            comando.setString(3, bolsa.getDataFim());
            
            if (bolsa.getFormulario() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setInt(4, bolsa.getCodFormulario());
            }
            
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Bolsa bolsa) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update bolsa set DT_INICIO = ?, DT_FIM = ?, FORMULARIO_ID = ? where BOLSA_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, bolsa.getDataInicio());
            comando.setString(2, bolsa.getDataFim());
            
            if (bolsa.getFormulario() == null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setInt(3, bolsa.getCodFormulario());
            }
            
            comando.setInt(4, bolsa.getCodBolsa());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Bolsa bolsa) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from BOLSA where BOLSA_ID = " + bolsa.getCodBolsa();
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
