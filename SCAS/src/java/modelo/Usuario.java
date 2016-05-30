package modelo;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Usuario{
    private int codUsuario;
    private String dataNasc;
    private String nome;
    private String sexo;
    private String cpf;
    private String identidade; 
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String login;
    private String senha;

    public Usuario(int codUsuario, String dataNasc, String nome, String sexo, String cpf, String identidade, String telefoneFixo, String telefoneCelular, String email, String endereco, String numero, String complemento, String bairro, String cep, String cidade, String uf, String login, String senha) {
        this.codUsuario = codUsuario;
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.identidade = identidade;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.login = login;
        this.senha = senha;
    }
    
    
    public static List<Usuario> obterUsuarios() throws ClassNotFoundException{
        return UsuarioDAO.obterUsuarios();
    }
    
    public static Usuario obterUsuario(int codUsuario) throws ClassNotFoundException{
        return UsuarioDAO.obterUsuario(codUsuario);
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    public void gravar() throws SQLException, ClassNotFoundException {
        UsuarioDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        UsuarioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        UsuarioDAO.excluir(this);
    }
    
}

