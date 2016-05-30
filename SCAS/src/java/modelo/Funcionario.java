package modelo;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Funcionario{
    private int registro;
    private String cargo;
    private Usuario usuario;
    
    private int codUsuario;

    public Funcionario(int registro, String cargo, Usuario usuario) {
        this.registro = registro;
        this.cargo = cargo;
        this.usuario = usuario;
    }
    
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException{
        return FuncionarioDAO.obterFuncionarios();
    }
    
    public static  Funcionario obterFuncionario(int registro) throws ClassNotFoundException{
        return FuncionarioDAO.obterFuncionario(registro);
    }
    
    public int getRegistro() {
        return registro;
    }
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public int getCodUsuario() {
        return codUsuario;
    }
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    public Usuario getUsuario() throws ClassNotFoundException {
        if ((codUsuario != 0) && (usuario == null)) {
            usuario = UsuarioDAO.obterUsuario(codUsuario);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.excluir(this);
    }
    
}
