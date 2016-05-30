package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Renda;

public class RendaDAO {
    public static List<Renda> obterRendas() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Renda> rendas = new ArrayList<Renda>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from RENDA");
            while(rs.next()){
                Renda renda = new Renda(
                        rs.getInt("RENDA_ID"),null,
                        rs.getString("QT18_NOME"),
                        rs.getString("QT18_DATA_NASC"),
                        rs.getString("QT18_ESTADO_CIVIL"),
                        rs.getString("QT18_PARENTESCO"),
                        rs.getString("QT18_ESCOLARIDADE"),
                        rs.getString("QT18_TRABALHO"),
                        rs.getString("QT18_OCUPACAO"),
                        rs.getDouble("QT18_RENDA_BRUTA"));
                renda.setCodFormulario(rs.getInt("FORMULARIO_ID"));
                rendas.add(renda);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return rendas;
    }
    
    public static Renda obterRenda(int codRenda) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Renda renda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from RENDA where RENDA_ID = " + codRenda);
            rs.first();
            renda = new Renda(
                        rs.getInt("RENDA_ID"),null,
                        rs.getString("QT18_NOME"),
                        rs.getString("QT18_DATA_NASC"),
                        rs.getString("QT18_ESTADO_CIVIL"),
                        rs.getString("QT18_PARENTESCO"),
                        rs.getString("QT18_ESCOLARIDADE"),
                        rs.getString("QT18_TRABALHO"),
                        rs.getString("QT18_OCUPACAO"),
                        rs.getDouble("QT18_RENDA_BRUTA"));
                renda.setCodFormulario(rs.getInt("FORMULARIO_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return renda;
    }
    
    public static void gravar(Renda renda) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into renda (RENDA_ID, FORMULARIO_ID, QT18_NOME, QT18_DATA_NASC, QT18_ESTADO_CIVIL, QT18_PARENTESCO, QT18_ESCOLARIDADE, QT18_TRABALHO, QT18_OCUPACAO, QT18_RENDA_BRUTA) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, renda.getCodRenda());
            if (renda.getFormulario() == null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setInt(2, renda.getCodFormulario());
            }
            comando.setString(3, renda.getQt18_Nome());
            comando.setString(4, renda.getQt18_DataNasc());
            comando.setString(5, renda.getQt18_EstadoCivil());
            comando.setString(6, renda.getQt18_Parentesco());
            comando.setString(7, renda.getQt18_Escolaridade());
            comando.setString(8, renda.getQt18_Trabalho());
            comando.setString(9, renda.getQt18_Ocupacao());
            comando.setDouble(10, renda.getQt18_RendaBruta());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Renda renda) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update renda set FORMULARIO_ID = ?, QT18_NOME = ?, QT18_DATA_NASC = ?, QT18_ESTADO_CIVIL = ?, QT18_PARENTESCO = ?, QT18_ESCOLARIDADE = ?, QT18_TRABALHO = ?, QT18_OCUPACAO = ?, QT18_RENDA_BRUTA = ? where RENDA_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            if (renda.getFormulario() == null){
                comando.setNull(1, Types.NULL);
            }else{
                comando.setInt(1, renda.getCodFormulario());
            }
            comando.setString(2, renda.getQt18_Nome());
            comando.setString(3, renda.getQt18_DataNasc());
            comando.setString(4, renda.getQt18_EstadoCivil());
            comando.setString(5, renda.getQt18_Parentesco());
            comando.setString(6, renda.getQt18_Escolaridade());
            comando.setString(7, renda.getQt18_Trabalho());
            comando.setString(8, renda.getQt18_Ocupacao());
            comando.setDouble(9, renda.getQt18_RendaBruta());
            comando.setInt(10, renda.getCodRenda());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Renda renda) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from RENDA where RENDA_ID = " + renda.getCodRenda();
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
