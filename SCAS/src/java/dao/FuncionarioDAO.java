package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO {
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from FUNCIONARIO");
            while(rs.next()){
                Funcionario funcionario = new Funcionario(
                        rs.getInt("REGISTRO"),
                        rs.getString("CARGO"), null);
                funcionario.setCodUsuario(rs.getInt("USUARIO_ID"));
                funcionarios.add(funcionario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return funcionarios;
    }
    
    public static Funcionario obterFuncionario(int registro) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from FUNCIONARIO where REGISTRO = " + registro);
            rs.first();
            funcionario = new Funcionario(
                    rs.getInt("REGISTRO"),
                    rs.getString("CARGO"), null);
            funcionario.setCodUsuario(rs.getInt("USUARIO_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into funcionario (REGISTRO, CARGO, USUARIO_ID) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, funcionario.getRegistro());
            comando.setString(2, funcionario.getCargo());
            
            if (funcionario.getUsuario() == null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setInt(3, funcionario.getCodUsuario());
            }
            
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update funcionario set CARGO = ?, USUARIO_ID = ? where REGISTRO = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, funcionario.getCargo());
            
            if (funcionario.getUsuario() == null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setInt(2, funcionario.getCodUsuario());
            }
            comando.setInt(3, funcionario.getRegistro());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from FUNCIONARIO where REGISTRO = " + funcionario.getRegistro();
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
