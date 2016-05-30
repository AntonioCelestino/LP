package dao;

import exception.TratamentoExcecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;

public class CursoDAO {
    public static List<Curso> obterCursos() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from CURSO");
            while(rs.next()){
                Curso curso = new Curso(
                        rs.getInt("CURSO_ID"),
                        rs.getString("NOME"),
                        rs.getString("TIPO_ENSINO"),
                        rs.getString("TURNO"));
                cursos.add(curso);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return cursos;
    }

    public static Curso obterCurso(int codCurso) throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from CURSO where CURSO_ID = " + codCurso);
            rs.first();
            curso = new Curso(
                        rs.getInt("CURSO_ID"),
                        rs.getString("NOME"),
                        rs.getString("TIPO_ENSINO"),
                        rs.getString("TURNO"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
    }
    
    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into curso (CURSO_ID, NOME, TIPO_ENSINO, TURNO) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getCodCurso());
            comando.setString(2, curso.getNome());
            comando.setString(3, curso.getTipoEnsino());
            comando.setString(4, curso.getTurno());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Curso curso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update curso set NOME = ?, TIPO_ENSINO = ?, TURNO = ? where CURSO_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, curso.getNome());
            comando.setString(2, curso.getTipoEnsino());
            comando.setString(3, curso.getTurno());
            comando.setInt(4, curso.getCodCurso());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
 
    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from CURSO where CURSO_ID = " + curso.getCodCurso();
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
