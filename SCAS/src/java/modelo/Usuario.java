package modelo;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Integer codUsuario;
    @Size(max = 45)
    @Column(name = "DATA_NASC", length = 45)
    private String dataNasc;
    @Size(max = 45)
    @Column(name = "NOME", length = 45)
    private String nome;
    @Size(max = 45)
    @Column(name = "SEXO", length = 45)
    private String sexo;
    @Size(max = 45)
    @Column(name = "CPF", length = 45)
    private String cpf;
    @Size(max = 45)
    @Column(name = "IDENTIDADE", length = 45)
    private String identidade;
    @Size(max = 45)
    @Column(name = "TELEFONE_FIXO", length = 45)
    private String telefoneFixo;
    @Size(max = 45)
    @Column(name = "TELEFONE_CELULAR", length = 45)
    private String telefoneCelular;
    @Size(max = 45)
    @Column(name = "EMAIL", length = 45)
    private String email;
    @Size(max = 45)
    @Column(name = "ENDERECO", length = 45)
    private String endereco;
    @Size(max = 45)
    @Column(name = "NUMERO", length = 45)
    private String numero;
    @Size(max = 45)
    @Column(name = "COMPLEMENTO", length = 45)
    private String complemento;
    @Size(max = 45)
    @Column(name = "BAIRRO", length = 45)
    private String bairro;
    @Size(max = 45)
    @Column(name = "CEP", length = 45)
    private String cep;
    @Size(max = 45)
    @Column(name = "CIDADE", length = 45)
    private String cidade;
    @Size(max = 45)
    @Column(name = "UF", length = 45)
    private String uf;
    @Size(max = 45)
    @Column(name = "LOGIN", length = 45)
    private String login;
    @Size(max = 45)
    @Column(name = "SENHA", length = 45)
    private String senha;
    
    public Usuario(){
    }

    public static List<Usuario> obterUsuarios() throws ClassNotFoundException{
        return UsuarioDAO.obterUsuarios();
    }
    
    public static Usuario obterUsuario(int codUsuario) throws ClassNotFoundException{
        return UsuarioDAO.obterUsuario(codUsuario);
    }
    
    public Usuario(Integer codUsuario, String dataNasc, String nome, String sexo, String cpf, String identidade, String telefoneFixo, String telefoneCelular, String email, String endereco, String numero, String complemento, String bairro, String cep, String cidade, String uf, String login, String senha) {
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

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ id=" + codUsuario + " ]";
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        UsuarioDAO.getInstance().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        UsuarioDAO.getInstance().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        UsuarioDAO.getInstance().excluir(this);
    }
    
}

