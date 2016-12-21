package modelo;

import dao.FormularioDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "formulario")
public class Formulario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORMULARIO_ID", nullable = false)
    private Integer codFormulario;
    @JoinColumn(name = "ALUNO_MATRICULA", referencedColumnName = "MATRICULA", nullable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "SELECAO_ID", referencedColumnName = "SELECAO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Selecao selecao;
    
    //--- Questão 01 ---
    @Size(max = 45)
    @Column(name = "QT01_RESPOSTA", length = 45)
    private String qt01_Resposta;	// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT01_NOME", length = 45)
    private String qt01_Nome; 		// preenchida se qt01_Resposta = 'sim'
    @Size(max = 45)
    @Column(name = "QT01_PARENTESCO", length = 45)
    private String qt01_Parentesco; 	// preenchida se qt01_Resposta = 'sim'
    @Size(max = 45)
    @Column(name = "QT01_PROGRAMA", length = 45)
    private String qt01_Programa; 	// preenchida se qt01_Resposta = 'sim'
    @Size(max = 45)
    @Column(name = "QT01_ANO", length = 45)
    private String qt01_Ano; 		// preenchida se qt01_Resposta = 'sim'

    //--- Questão 02 ---
    @Size(max = 45)
    @Column(name = "QT02_ALIMENTACAO", length = 45)
    private String qt02_Alimentacao;	// com ratio button de 'Sim' ou 'Não'	
    @Size(max = 45)
    @Column(name = "QT02_MANUTENCAO", length = 45)
    private String qt02_Manutencao;	// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT02_MORADIA", length = 45)
    private String qt02_Moradia;	// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT02_TRANSPORTE", length = 45)
    private String qt02_Transporte;	// com ratio button de 'Sim' ou 'Não'	
    @Size(max = 45)
    @Column(name = "QT02_OUTRO", length = 45)
    private String qt02_Outro;          // preenchida se as respostas anteriores são iguais a 'Não'	

    //--- Questão 03 ---
    @Size(max = 45)
    @Column(name = "QT03_TRANSPORTE", length = 45)
    private String qt03_Transporte;             // com ratio button
    @Size(max = 45)
    @Column(name = "QT03_TEMPO", length = 45)
    private String qt03_Tempo;                  // preenchida se qt03_Transporte = 'pé-bicicleta'
    @Column(name = "QT03_VALOR_GASTO_DIARIO")
    private float qt03_ValorGastoDiario; 	// preenchida se qt03_Transporte = 'transporte coletivo'
    @Column(name = "QT03_VALOR_GASTO_MENSAL")
    private float qt03_ValorGastoMensal; 	// preenchida se qt03_Transporte = 'transporte locado'
    @Size(max = 45)
    @Column(name = "QT03_OUTRO", length = 45)
    private String qt03_Outro;                  // preenchida se qt03_Transporte = 'Outro'

    //--- Questão 04 ---
    @Size(max = 45)
    @Column(name = "QT04_INSTITUICAO_ENSINO_FUNDAMENTAL", length = 45)
    private String qt04_InstituicaoEnsinoFundamental; 	// com ratio button

    //--- Questão 05 ---
    @Size(max = 45)
    @Column(name = "QT05_INSTITUICAO_ENSINO_MEDIO", length = 45)
    private String qt05_InstituicaoEnsinoMedio; 	// com ratio button

    //--- Questão 06 ---
    @Size(max = 45)
    @Column(name = "QT06_ATIVIDADE_REMUNERADA", length = 45)
    private String qt06_AtividadeRemunerada; 	// com ratio button
    @Column(name = "QT06_VALOR_BOLSA_ESTAGIO")
    private float qt06_ValorBolsaEstagio; 	// preenchida qt06_AtividadeRemunerada = estágio
    @Size(max = 45)
    @Column(name = "QT06_PROJETO_INICIACAO", length = 45)
    private String qt06_ProjetoIniciacao; 	// preenchida qt06_AtividadeRemunerada = iniciação científica
    @Column(name = "QT06_VALOR_BOLSA_INICIACAO")
    private float qt06_ValorBolsaIniciacao; 	// preenchida qt06_AtividadeRemunerada = iniciação científica
    @Size(max = 45)
    @Column(name = "QT06_PROJETO_TREINAMENTO", length = 45)
    private String qt06_ProjetoTreinamento; 	// preenchida qt06_AtividadeRemunerada = treinamento profissional
    @Column(name = "QT06_VALOR_BOLSA_TREINAMENTO")
    private float qt06_ValorBolsaTreinamento; 	// preenchida qt06_AtividadeRemunerada = treinamento profissional
    @Size(max = 45)
    @Column(name = "QT06_OUTRO", length = 45)
    private String qt06_Outro;                  // preenchida qt06_AtividadeRemunerada = Outra
    @Column(name = "QT06_VALOR_BOLSA_OUTRO")
    private float qt06_ValorBolsaOutro; 	// preenchida qt06_AtividadeRemunerada = Outra

    //--- Questão 07 ---
    @Size(max = 45)
    @Column(name = "QT07_TRABALHO_REMUNERADO", length = 45)
    private String qt07_TrabalhoRemunerado;	// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT07_HORAS_SEMANAIS", length = 45)
    private String qt07_HorasSemanais;  	// preenchida se qt07_TrabalhoRemunerado = 'Sim'
    @Column(name = "QT07_SALARIO")
    private float qt07_Salario; 		// preenchida se qt07_TrabalhoRemunerado = 'Sim'

    //--- Questão 08 ---
    @Size(max = 45)
    @Column(name = "QT08_MANUTENCAO", length = 45)
    private String qt08_Manutencao; 	// com ratio button
    @Size(max = 45)
    @Column(name = "QT08_OUTRO", length = 45)
    private String qt08_Outra;          // preenchida se qt08_Manutencao = 'Outra'

    //--- Questão 09 ---
    @Size(max = 45)
    @Column(name = "QT09_MORADIA", length = 45)
    private String qt09_Moradia; 	// com ratio button
    @Size(max = 45)
    @Column(name = "QT09_OUTRO", length = 45)
    private String qt09_Outra;          // preenchida se qt09_Moradia = 'Outra'

    //--- Questão 10 ---
    @Size(max = 45)
    @Column(name = "QT10_RESPONSAVEL_FINANCEIRO", length = 45)
    private String qt10_ResponsavelFinanceiro;		// com ratio button
    @Size(max = 45)
    @Column(name = "QT10_OUTRO", length = 45)
    private String qt10_Outros; 			// preenchida se qt10_ResponsavelFinanceiro = 'Outros'

    //--- Questão 11 ---
    @Size(max = 45)
    @Column(name = "QT11_ESGOTO", length = 45)
    private String qt11_Esgoto;         // com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT11_AGUA_TRATADA", length = 45)
    private String qt11_Agua;		// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT11_ILUMINACAO", length = 45)
    private String qt11_Iluminacao;	// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT11_COLETA_LIXO", length = 45)
    private String qt11_Lixo;		// com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT11_RUA_PAVIMENTADA", length = 45)
    private String qt11_Pavimentacao;	// com ratio button de 'Sim' ou 'Não'

    //--- Questão 12 ---
    @Size(max = 45)
    @Column(name = "QT12_RESIDENCIA", length = 45)
    private String qt12_Residencia; 	// com ratio button
    @Size(max = 45)
    @Column(name = "QT12_OUTRO", length = 45)
    private String qt12_Outro;		// preenchida se qt12_Residencia = 'Outro'

    //--- Questão 13 ---
    @Size(max = 45)
    @Column(name = "QT13_IMOVEL", length = 45)
    private String qt13_Imovel; 	// com ratio button
    @Column(name = "QT13_VALOR_ALUGUEL")
    private float qt13_ValorAluguel;	// preenchida se qt13_Imovel = alugado
    @Column(name = "QT13_VALOR_PRESTACAO")
    private float qt13_ValorPrestacao;	// preenchida se qt13_Imovel = em pagamento
    @Size(max = 45)
    @Column(name = "QT13_NOME", length = 45)
    private String qt13_Nome;		// preenchida se qt13_Imovel = emprestado
    @Size(max = 45)
    @Column(name = "QT13_OUTRO", length = 45)
    private String qt13_Outro;		// preenchida se qt13_Imovel = Outro

    //--- Questão 14 ---
    @Size(max = 45)
    @Column(name = "QT14_ACABAMENTO", length = 45)
    private String qt14_Acabamento; 	// com ratio button

    //--- Questão 15 ---
    @Size(max = 45)
    @Column(name = "QT15_OUTROS_IMOVEIS", length = 45)
    private String qt15_OutrosImoveis;      // com ratio button de 'Sim' ou 'Não'
    @Size(max = 45)
    @Column(name = "QT15_DESCRICAO_IMOVEIS", length = 45)
    private String qt15_DescricaoImoveis;   // preenchida se qt15_OutrosImoveis = 'Sim'

    //--- Questão 16 ---
    @Column(name = "QT16_QUANTIDADE_CARRO")
    private Integer qt16_QuantCarro;
    @Column(name = "QT16_QUANTIDADE_TELEVISAO")
    private Integer qt16_QuantTV;
    @Column(name = "QT16_QUANTIDADE_MAQUINA_LAVAR")
    private Integer qt16_QuantMaqLavar;
    @Column(name = "QT16_QUANTIDADE_GELADEIRA")
    private Integer qt16_QuantGeladeira;
    @Column(name = "QT16_QUANTIDADE_TV_CABO")
    private Integer qt16_QuantTVCabo;
    @Column(name = "QT16_QUANTIDADE_COMPUTADOR")
    private Integer qt16_QuantComputador;
    @Column(name = "QT16_QUANTIDADE_INTERNET")
    private Integer qt16_QuantInternetPaga;
    @Column(name = "QT16_QUANTIDADE_EMPREGADA_MENSALISTA")
    private Integer qt16_QuantEmpregadaMensalista;
    @Column(name = "QT16_QUANTIDADE_EMPREGADA_DIARISTA")
    private Integer qt16_QuantEmpregadaDiarista;
    @Column(name = "QT16_QUANTIDADE_BANHEIRO")
    private Integer qt16_QuantBanheiro;
    @Column(name = "QT16_QUANTIDADE_QUARTO")
    private Integer qt16_QuantQuarto;

    //--- Questão 17 ---
    @Size(max = 45)
    @Column(name = "QT17_PROBLEMA_SAUDE", length = 45)
    private String qt17_ProblemaSaude; // com ratio button de 'Sim' ou 'Não'
    //se 'Sim' acessar tabela separada para preencher seus campos

    //--- Questão 18 ---
    //acessar tabela separada
    @Column(name = "QT18_ALUGUEL_IMOVEIS")
    private float qt18_AluguelImoveis;
    @Column(name = "QT18_PENSAO_MORTE")
    private float qt18_PensaoMorte;
    @Column(name = "QT18_PENSAO_ALIMENTICIA")
    private float qt18_PensaoAlimenticia;
    @Column(name = "QT18_AJUDA_TERCEIROS")
    private float qt18_AjudaTerceiros;
    @Column(name = "QT18_BENEFICIOS_SOCIAIS")
    private float qt18_BeneficiosSociais;
    @Column(name = "QT18_OUTRA_RENDA")
    private float qt18_OutraRenda;
    @Size(max = 45)
    @Column(name = "QT18_NOME_OUTRA_RENDA", length = 45)
    private String qt18_NomeOutraRenda;
    @Column(name = "QT18_TOTAL_RENDA")
    private float qt18_TotalRenda;
    @Column(name = "QT18_NUMERO_RESIDENTES")
    private Integer qt18_NumeroResidentes;

    //--- Questão 19 ---
    @Column(name = "QT19_VALOR_AGUA")
    private float qt19_ValorAgua;
    @Column(name = "QT19_VALOR_LUZ")
    private float qt19_ValorLuz;
    @Column(name = "QT19_VALOR_TELEFONE")
    private float qt19_ValorTelefone;
    @Column(name = "QT19_VALOR_CONDOMINIO")
    private float qt19_ValorCondominio;
    @Column(name = "QT19_VALOR_MENSALIDADE_ESCOLAR")
    private float qt19_ValorMensalidadeEscolar;
    @Column(name = "QT19_VALOR_ALIMENTACAO")
    private float qt19_ValorAlimentacao;
    @Column(name = "QT19_VALOR_SAUDE")
    private float qt19_ValorSaude;
    @Column(name = "QT19_VALOR_TRANSPORTE")
    private float qt19_ValorTransporte;
    @Column(name = "QT19_VALOR_IPTU_ANUAL")
    private float qt19_ValorIptuAnual;
    @Column(name = "QT19_VALOR_ALUGUEL")
    private float qt19_ValorAluguel;
    @Column(name = "QT19_VALOR_PENSAO")
    private float qt19_ValorPensao;
    @Column(name = "QT19_VALOR_OUTROS")
    private float qt19_ValorOutros;

    //--- Questão 20 ---
    @Column(name = "QT20_VALOR_AGUA")
    private float qt20_ValorAgua;
    @Column(name = "QT20_VALOR_LUZ")
    private float qt20_ValorLuz;
    @Column(name = "QT20_VALOR_TELEFONE")
    private float qt20_ValorTelefone;
    @Column(name = "QT20_VALOR_CONDOMINIO")
    private float qt20_ValorCondominio;
    @Column(name = "QT20_VALOR_ALUGUEL")
    private float qt20_ValorAluguel;
    @Column(name = "QT20_VALOR_IPTU_ANUAL")
    private float qt20_ValorIptuAnual;

    //--- Questão 21 ---
    @Size(max = 200)
    @Column(name = "QT21_ESCLARECIMENTOS", length = 200)
    private String qt21_Esclarecimentos; 
    
    public Formulario(){
    }

    public static List<Formulario> obterFormularios() throws ClassNotFoundException{
        return FormularioDAO.obterFormularios();
    }
    
    public static Formulario obterFormulario(int codFormulario) throws ClassNotFoundException{
        return (Formulario) FormularioDAO.getInstance().obterClasse(Formulario.class, codFormulario);
    }

    public Formulario(Integer codFormulario, Aluno aluno, Selecao selecao) {
        this.codFormulario = codFormulario;
        this.aluno = aluno;
        this.selecao = selecao;
    }
    public Formulario questao_01(String qt01_Resposta, String qt01_Nome, String qt01_Parentesco, String qt01_Programa, String qt01_Ano) {
        this.qt01_Resposta = qt01_Resposta;
        this.qt01_Nome = qt01_Nome;
        this.qt01_Parentesco = qt01_Parentesco;
        this.qt01_Programa = qt01_Programa;
        this.qt01_Ano = qt01_Ano;
        return this;
    }
    public Formulario questao_02(String qt02_Alimentacao, String qt02_Manutencao, String qt02_Moradia, String qt02_Transporte, String qt02_Outro) {
        this.qt02_Alimentacao = qt02_Alimentacao;
        this.qt02_Manutencao = qt02_Manutencao;
        this.qt02_Moradia = qt02_Moradia;
        this.qt02_Transporte = qt02_Transporte;
        this.qt02_Outro = qt02_Outro;
        return this;
    }
    public Formulario questao_03(String qt03_Transporte, String qt03_Tempo, float qt03_ValorGastoDiario, float qt03_ValorGastoMensal, String qt03_Outro) {
        this.qt03_Transporte = qt03_Transporte;
        this.qt03_Tempo = qt03_Tempo;
        this.qt03_ValorGastoDiario = qt03_ValorGastoDiario;
        this.qt03_ValorGastoMensal = qt03_ValorGastoMensal;
        this.qt03_Outro = qt03_Outro;
        return this;
    }
    public Formulario questao_04(String qt04_InstituicaoEnsinoFundamental) {
        this.qt04_InstituicaoEnsinoFundamental = qt04_InstituicaoEnsinoFundamental;
        return this;
    }
    public Formulario questao_05(String qt05_InstituicaoEnsinoMedio) {
        this.qt05_InstituicaoEnsinoMedio = qt05_InstituicaoEnsinoMedio;
        return this;
    }
    public Formulario questao_06(String qt06_AtividadeRemunerada, float qt06_ValorBolsaEstagio, String qt06_ProjetoIniciacao, float qt06_ValorBolsaIniciacao, String qt06_ProjetoTreinamento, float qt06_ValorBolsaTreinamento, String qt06_Outro, float qt06_ValorBolsaOutro) {
        this.qt06_AtividadeRemunerada = qt06_AtividadeRemunerada;
        this.qt06_ValorBolsaEstagio = qt06_ValorBolsaEstagio;
        this.qt06_ProjetoIniciacao = qt06_ProjetoIniciacao;
        this.qt06_ValorBolsaIniciacao = qt06_ValorBolsaIniciacao;
        this.qt06_ProjetoTreinamento = qt06_ProjetoTreinamento;
        this.qt06_ValorBolsaTreinamento = qt06_ValorBolsaTreinamento;
        this.qt06_Outro = qt06_Outro;
        this.qt06_ValorBolsaOutro = qt06_ValorBolsaOutro;
        return this;
    }
    public Formulario questao_07(String qt07_TrabalhoRemunerado, String qt07_HorasSemanais, float qt07_Salario) {
        this.qt07_TrabalhoRemunerado = qt07_TrabalhoRemunerado;
        this.qt07_HorasSemanais = qt07_HorasSemanais;
        this.qt07_Salario = qt07_Salario;
        return this;
    }
    public Formulario questao_08(String qt08_Manutencao, String qt08_Outra) {
        this.qt08_Manutencao = qt08_Manutencao;
        this.qt08_Outra = qt08_Outra;
        return this;
    }
    public Formulario questao_09(String qt09_Moradia, String qt09_Outra) {
        this.qt09_Moradia = qt09_Moradia;
        this.qt09_Outra = qt09_Outra;
        return this;
    }
    public Formulario questao_10(String qt10_ResponsavelFinanceiro, String qt10_Outros) {
        this.qt10_ResponsavelFinanceiro = qt10_ResponsavelFinanceiro;
        this.qt10_Outros = qt10_Outros;
        return this;
    }
    public Formulario questao_11(String qt11_Esgoto, String qt11_Agua, String qt11_Iluminacao, String qt11_Lixo, String qt11_Pavimentacao) {
        this.qt11_Esgoto = qt11_Esgoto;
        this.qt11_Agua = qt11_Agua;
        this.qt11_Iluminacao = qt11_Iluminacao;
        this.qt11_Lixo = qt11_Lixo;
        this.qt11_Pavimentacao = qt11_Pavimentacao;
        return this;
    }
    public Formulario questao_12(String qt12_Residencia, String qt12_Outro) {
        this.qt12_Residencia = qt12_Residencia;
        this.qt12_Outro = qt12_Outro;
        return this;
    }
    public Formulario questao_13(String qt13_Imovel, float qt13_ValorAluguel, float qt13_ValorPrestacao, String qt13_Nome, String qt13_Outro) {
        this.qt13_Imovel = qt13_Imovel;
        this.qt13_ValorAluguel = qt13_ValorAluguel;
        this.qt13_ValorPrestacao = qt13_ValorPrestacao;
        this.qt13_Nome = qt13_Nome;
        this.qt13_Outro = qt13_Outro;
        return this;
    }
    public Formulario questao_14(String qt14_Acabamento) {
        this.qt14_Acabamento = qt14_Acabamento;
        return this;
    }
    public Formulario questao_15(String qt15_OutrosImoveis, String qt15_DescricaoImoveis) {
        this.qt15_OutrosImoveis = qt15_OutrosImoveis;
        this.qt15_DescricaoImoveis = qt15_DescricaoImoveis;
        return this;
    }
    public Formulario questao_16(Integer qt16_QuantCarro, Integer qt16_QuantTV, Integer qt16_QuantMaqLavar, Integer qt16_QuantGeladeira, Integer qt16_QuantTVCabo, Integer qt16_QuantComputador, Integer qt16_QuantInternetPaga, Integer qt16_QuantEmpregadaMensalista, Integer qt16_QuantEmpregadaDiarista, Integer qt16_QuantBanheiro, Integer qt16_QuantQuarto) {
        this.qt16_QuantCarro = qt16_QuantCarro;
        this.qt16_QuantTV = qt16_QuantTV;
        this.qt16_QuantMaqLavar = qt16_QuantMaqLavar;
        this.qt16_QuantGeladeira = qt16_QuantGeladeira;
        this.qt16_QuantTVCabo = qt16_QuantTVCabo;
        this.qt16_QuantComputador = qt16_QuantComputador;
        this.qt16_QuantInternetPaga = qt16_QuantInternetPaga;
        this.qt16_QuantEmpregadaMensalista = qt16_QuantEmpregadaMensalista;
        this.qt16_QuantEmpregadaDiarista = qt16_QuantEmpregadaDiarista;
        this.qt16_QuantBanheiro = qt16_QuantBanheiro;
        this.qt16_QuantQuarto = qt16_QuantQuarto;
        return this;
    }
    public Formulario questao_17(String qt17_ProblemaSaude) {
        this.qt17_ProblemaSaude = qt17_ProblemaSaude;
        return this;
    }
    public Formulario questao_18(float qt18_AluguelImoveis, float qt18_PensaoMorte, float qt18_PensaoAlimenticia, float qt18_AjudaTerceiros, float qt18_BeneficiosSociais, float qt18_OutraRenda, String qt18_NomeOutraRenda, float qt18_TotalRenda, Integer qt18_NumeroResidentes) {
        this.qt18_AluguelImoveis = qt18_AluguelImoveis;
        this.qt18_PensaoMorte = qt18_PensaoMorte;
        this.qt18_PensaoAlimenticia = qt18_PensaoAlimenticia;
        this.qt18_AjudaTerceiros = qt18_AjudaTerceiros;
        this.qt18_BeneficiosSociais = qt18_BeneficiosSociais;
        this.qt18_OutraRenda = qt18_OutraRenda;
        this.qt18_NomeOutraRenda = qt18_NomeOutraRenda;
        this.qt18_TotalRenda = qt18_TotalRenda;
        this.qt18_NumeroResidentes = qt18_NumeroResidentes;
        return this;
    }
    public Formulario questao_19(float qt19_ValorAgua, float qt19_ValorLuz, float qt19_ValorTelefone, float qt19_ValorCondominio, float qt19_ValorMensalidadeEscolar, float qt19_ValorAlimentacao, float qt19_ValorSaude, float qt19_ValorTransporte, float qt19_ValorIptuAnual, float qt19_ValorAluguel, float qt19_ValorPensao, float qt19_ValorOutros) {
        this.qt19_ValorAgua = qt19_ValorAgua;
        this.qt19_ValorLuz = qt19_ValorLuz;
        this.qt19_ValorTelefone = qt19_ValorTelefone;
        this.qt19_ValorCondominio = qt19_ValorCondominio;
        this.qt19_ValorMensalidadeEscolar = qt19_ValorMensalidadeEscolar;
        this.qt19_ValorAlimentacao = qt19_ValorAlimentacao;
        this.qt19_ValorSaude = qt19_ValorSaude;
        this.qt19_ValorTransporte = qt19_ValorTransporte;
        this.qt19_ValorIptuAnual = qt19_ValorIptuAnual;
        this.qt19_ValorAluguel = qt19_ValorAluguel;
        this.qt19_ValorPensao = qt19_ValorPensao;
        this.qt19_ValorOutros = qt19_ValorOutros;
        return this;
    }
    public Formulario questao_20(float qt20_ValorAgua, float qt20_ValorLuz, float qt20_ValorTelefone, float qt20_ValorCondominio, float qt20_ValorAluguel, float qt20_ValorIptuAnual) {
        this.qt20_ValorAgua = qt20_ValorAgua;
        this.qt20_ValorLuz = qt20_ValorLuz;
        this.qt20_ValorTelefone = qt20_ValorTelefone;
        this.qt20_ValorCondominio = qt20_ValorCondominio;
        this.qt20_ValorAluguel = qt20_ValorAluguel;
        this.qt20_ValorIptuAnual = qt20_ValorIptuAnual;
        return this;
    }
    public Formulario questao_21(String qt21_Esclarecimentos) {
        this.qt21_Esclarecimentos = qt21_Esclarecimentos;
        return this;
    }
    
    
    public Integer getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(Integer codFormulario) {
        this.codFormulario = codFormulario;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Selecao getSelecao(){
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    public String getQt01_Resposta() {
        return qt01_Resposta;
    }

    public void setQt01_Resposta(String qt01_Resposta) {
        this.qt01_Resposta = qt01_Resposta;
    }

    public String getQt01_Nome() {
        return qt01_Nome;
    }

    public void setQt01_Nome(String qt01_Nome) {
        this.qt01_Nome = qt01_Nome;
    }

    public String getQt01_Parentesco() {
        return qt01_Parentesco;
    }

    public void setQt01_Parentesco(String qt01_Parentesco) {
        this.qt01_Parentesco = qt01_Parentesco;
    }

    public String getQt01_Programa() {
        return qt01_Programa;
    }

    public void setQt01_Programa(String qt01_Programa) {
        this.qt01_Programa = qt01_Programa;
    }

    public String getQt01_Ano() {
        return qt01_Ano;
    }

    public void setQt01_Ano(String qt01_Ano) {
        this.qt01_Ano = qt01_Ano;
    }

    public String getQt02_Alimentacao() {
        return qt02_Alimentacao;
    }

    public void setQt02_Alimentacao(String qt02_Alimentacao) {
        this.qt02_Alimentacao = qt02_Alimentacao;
    }

    public String getQt02_Manutencao() {
        return qt02_Manutencao;
    }

    public void setQt02_Manutencao(String qt02_Manutencao) {
        this.qt02_Manutencao = qt02_Manutencao;
    }

    public String getQt02_Moradia() {
        return qt02_Moradia;
    }

    public void setQt02_Moradia(String qt02_Moradia) {
        this.qt02_Moradia = qt02_Moradia;
    }

    public String getQt02_Transporte() {
        return qt02_Transporte;
    }

    public void setQt02_Transporte(String qt02_Transporte) {
        this.qt02_Transporte = qt02_Transporte;
    }

    public String getQt02_Outro() {
        return qt02_Outro;
    }

    public void setQt02_Outro(String qt02_Outro) {
        this.qt02_Outro = qt02_Outro;
    }

    public String getQt03_Transporte() {
        return qt03_Transporte;
    }

    public void setQt03_Transporte(String qt03_Transporte) {
        this.qt03_Transporte = qt03_Transporte;
    }

    public String getQt03_Tempo() {
        return qt03_Tempo;
    }

    public void setQt03_Tempo(String qt03_Tempo) {
        this.qt03_Tempo = qt03_Tempo;
    }

    public float getQt03_ValorGastoDiario() {
        return qt03_ValorGastoDiario;
    }

    public void setQt03_ValorGastoDiario(float qt03_ValorGastoDiario) {
        this.qt03_ValorGastoDiario = qt03_ValorGastoDiario;
    }

    public float getQt03_ValorGastoMensal() {
        return qt03_ValorGastoMensal;
    }

    public void setQt03_ValorGastoMensal(float qt03_ValorGastoMensal) {
        this.qt03_ValorGastoMensal = qt03_ValorGastoMensal;
    }

    public String getQt03_Outro() {
        return qt03_Outro;
    }

    public void setQt03_Outro(String qt03_Outro) {
        this.qt03_Outro = qt03_Outro;
    }

    public String getQt04_InstituicaoEnsinoFundamental() {
        return qt04_InstituicaoEnsinoFundamental;
    }

    public void setQt04_InstituicaoEnsinoFundamental(String qt04_InstituicaoEnsinoFundamental) {
        this.qt04_InstituicaoEnsinoFundamental = qt04_InstituicaoEnsinoFundamental;
    }

    public String getQt05_InstituicaoEnsinoMedio() {
        return qt05_InstituicaoEnsinoMedio;
    }

    public void setQt05_InstituicaoEnsinoMedio(String qt05_InstituicaoEnsinoMedio) {
        this.qt05_InstituicaoEnsinoMedio = qt05_InstituicaoEnsinoMedio;
    }

    public String getQt06_AtividadeRemunerada() {
        return qt06_AtividadeRemunerada;
    }

    public void setQt06_AtividadeRemunerada(String qt06_AtividadeRemunerada) {
        this.qt06_AtividadeRemunerada = qt06_AtividadeRemunerada;
    }

    public float getQt06_ValorBolsaEstagio() {
        return qt06_ValorBolsaEstagio;
    }

    public void setQt06_ValorBolsaEstagio(float qt06_ValorBolsaEstagio) {
        this.qt06_ValorBolsaEstagio = qt06_ValorBolsaEstagio;
    }

    public String getQt06_ProjetoIniciacao() {
        return qt06_ProjetoIniciacao;
    }

    public void setQt06_ProjetoIniciacao(String qt06_ProjetoIniciacao) {
        this.qt06_ProjetoIniciacao = qt06_ProjetoIniciacao;
    }

    public float getQt06_ValorBolsaIniciacao() {
        return qt06_ValorBolsaIniciacao;
    }

    public void setQt06_ValorBolsaIniciacao(float qt06_ValorBolsaIniciacao) {
        this.qt06_ValorBolsaIniciacao = qt06_ValorBolsaIniciacao;
    }

    public String getQt06_ProjetoTreinamento() {
        return qt06_ProjetoTreinamento;
    }

    public void setQt06_ProjetoTreinamento(String qt06_ProjetoTreinamento) {
        this.qt06_ProjetoTreinamento = qt06_ProjetoTreinamento;
    }

    public float getQt06_ValorBolsaTreinamento() {
        return qt06_ValorBolsaTreinamento;
    }

    public void setQt06_ValorBolsaTreinamento(float qt06_ValorBolsaTreinamento) {
        this.qt06_ValorBolsaTreinamento = qt06_ValorBolsaTreinamento;
    }

    public String getQt06_Outro() {
        return qt06_Outro;
    }

    public void setQt06_Outro(String qt06_Outro) {
        this.qt06_Outro = qt06_Outro;
    }

    public float getQt06_ValorBolsaOutro() {
        return qt06_ValorBolsaOutro;
    }

    public void setQt06_ValorBolsaOutro(float qt06_ValorBolsaOutro) {
        this.qt06_ValorBolsaOutro = qt06_ValorBolsaOutro;
    }

    public String getQt07_TrabalhoRemunerado() {
        return qt07_TrabalhoRemunerado;
    }

    public void setQt07_TrabalhoRemunerado(String qt07_TrabalhoRemunerado) {
        this.qt07_TrabalhoRemunerado = qt07_TrabalhoRemunerado;
    }

    public String getQt07_HorasSemanais() {
        return qt07_HorasSemanais;
    }

    public void setQt07_HorasSemanais(String qt07_HorasSemanais) {
        this.qt07_HorasSemanais = qt07_HorasSemanais;
    }

    public float getQt07_Salario() {
        return qt07_Salario;
    }

    public void setQt07_Salario(float qt07_Salario) {
        this.qt07_Salario = qt07_Salario;
    }

    public String getQt08_Manutencao() {
        return qt08_Manutencao;
    }

    public void setQt08_Manutencao(String qt08_Manutencao) {
        this.qt08_Manutencao = qt08_Manutencao;
    }

    public String getQt08_Outra() {
        return qt08_Outra;
    }

    public void setQt08_Outra(String qt08_Outra) {
        this.qt08_Outra = qt08_Outra;
    }

    public String getQt09_Moradia() {
        return qt09_Moradia;
    }

    public void setQt09_Moradia(String qt09_Moradia) {
        this.qt09_Moradia = qt09_Moradia;
    }

    public String getQt09_Outra() {
        return qt09_Outra;
    }

    public void setQt09_Outra(String qt09_Outra) {
        this.qt09_Outra = qt09_Outra;
    }

    public String getQt10_ResponsavelFinanceiro() {
        return qt10_ResponsavelFinanceiro;
    }

    public void setQt10_ResponsavelFinanceiro(String qt10_ResponsavelFinanceiro) {
        this.qt10_ResponsavelFinanceiro = qt10_ResponsavelFinanceiro;
    }

    public String getQt10_Outros() {
        return qt10_Outros;
    }

    public void setQt10_Outros(String qt10_Outros) {
        this.qt10_Outros = qt10_Outros;
    }

    public String getQt11_Esgoto() {
        return qt11_Esgoto;
    }

    public void setQt11_Esgoto(String qt11_Esgoto) {
        this.qt11_Esgoto = qt11_Esgoto;
    }

    public String getQt11_Agua() {
        return qt11_Agua;
    }

    public void setQt11_Agua(String qt11_Agua) {
        this.qt11_Agua = qt11_Agua;
    }

    public String getQt11_Iluminacao() {
        return qt11_Iluminacao;
    }

    public void setQt11_Iluminacao(String qt11_Iluminacao) {
        this.qt11_Iluminacao = qt11_Iluminacao;
    }

    public String getQt11_Lixo() {
        return qt11_Lixo;
    }

    public void setQt11_Lixo(String qt11_Lixo) {
        this.qt11_Lixo = qt11_Lixo;
    }

    public String getQt11_Pavimentacao() {
        return qt11_Pavimentacao;
    }

    public void setQt11_Pavimentacao(String qt11_Pavimentacao) {
        this.qt11_Pavimentacao = qt11_Pavimentacao;
    }

    public String getQt12_Residencia() {
        return qt12_Residencia;
    }

    public void setQt12_Residencia(String qt12_Residencia) {
        this.qt12_Residencia = qt12_Residencia;
    }

    public String getQt12_Outro() {
        return qt12_Outro;
    }

    public void setQt12_Outro(String qt12_Outro) {
        this.qt12_Outro = qt12_Outro;
    }

    public String getQt13_Imovel() {
        return qt13_Imovel;
    }

    public void setQt13_Imovel(String qt13_Imovel) {
        this.qt13_Imovel = qt13_Imovel;
    }

    public float getQt13_ValorAluguel() {
        return qt13_ValorAluguel;
    }

    public void setQt13_ValorAluguel(float qt13_ValorAluguel) {
        this.qt13_ValorAluguel = qt13_ValorAluguel;
    }

    public float getQt13_ValorPrestacao() {
        return qt13_ValorPrestacao;
    }

    public void setQt13_ValorPrestacao(float qt13_ValorPrestacao) {
        this.qt13_ValorPrestacao = qt13_ValorPrestacao;
    }

    public String getQt13_Nome() {
        return qt13_Nome;
    }

    public void setQt13_Nome(String qt13_Nome) {
        this.qt13_Nome = qt13_Nome;
    }

    public String getQt13_Outro() {
        return qt13_Outro;
    }

    public void setQt13_Outro(String qt13_Outro) {
        this.qt13_Outro = qt13_Outro;
    }

    public String getQt14_Acabamento() {
        return qt14_Acabamento;
    }

    public void setQt14_Acabamento(String qt14_Acabamento) {
        this.qt14_Acabamento = qt14_Acabamento;
    }

    public String getQt15_OutrosImoveis() {
        return qt15_OutrosImoveis;
    }

    public void setQt15_OutrosImoveis(String qt15_OutrosImoveis) {
        this.qt15_OutrosImoveis = qt15_OutrosImoveis;
    }

    public String getQt15_DescricaoImoveis() {
        return qt15_DescricaoImoveis;
    }

    public void setQt15_DescricaoImoveis(String qt15_DescricaoImoveis) {
        this.qt15_DescricaoImoveis = qt15_DescricaoImoveis;
    }
    
    public Integer getQt16_QuantCarro() {
        return qt16_QuantCarro;
    }

    public void setQt16_QuantCarro(Integer qt16_QuantCarro) {
        this.qt16_QuantCarro = qt16_QuantCarro;
    }

    public Integer getQt16_QuantTV() {
        return qt16_QuantTV;
    }

    public void setQt16_QuantTV(Integer qt16_QuantTV) {
        this.qt16_QuantTV = qt16_QuantTV;
    }

    public Integer getQt16_QuantMaqLavar() {
        return qt16_QuantMaqLavar;
    }

    public void setQt16_QuantMaqLavar(Integer qt16_QuantMaqLavar) {
        this.qt16_QuantMaqLavar = qt16_QuantMaqLavar;
    }

    public Integer getQt16_QuantGeladeira() {
        return qt16_QuantGeladeira;
    }

    public void setQt16_QuantGeladeira(Integer qt16_QuantGeladeira) {
        this.qt16_QuantGeladeira = qt16_QuantGeladeira;
    }

    public Integer getQt16_QuantTVCabo() {
        return qt16_QuantTVCabo;
    }

    public void setQt16_QuantTVCabo(Integer qt16_QuantTVCabo) {
        this.qt16_QuantTVCabo = qt16_QuantTVCabo;
    }

    public Integer getQt16_QuantComputador() {
        return qt16_QuantComputador;
    }

    public void setQt16_QuantComputador(Integer qt16_QuantComputador) {
        this.qt16_QuantComputador = qt16_QuantComputador;
    }

    public Integer getQt16_QuantInternetPaga() {
        return qt16_QuantInternetPaga;
    }

    public void setQt16_QuantInternetPaga(Integer qt16_QuantInternetPaga) {
        this.qt16_QuantInternetPaga = qt16_QuantInternetPaga;
    }

    public Integer getQt16_QuantEmpregadaMensalista() {
        return qt16_QuantEmpregadaMensalista;
    }

    public void setQt16_QuantEmpregadaMensalista(Integer qt16_QuantEmpregadaMensalista) {
        this.qt16_QuantEmpregadaMensalista = qt16_QuantEmpregadaMensalista;
    }

    public Integer getQt16_QuantEmpregadaDiarista() {
        return qt16_QuantEmpregadaDiarista;
    }

    public void setQt16_QuantEmpregadaDiarista(Integer qt16_QuantEmpregadaDiarista) {
        this.qt16_QuantEmpregadaDiarista = qt16_QuantEmpregadaDiarista;
    }

    public Integer getQt16_QuantBanheiro() {
        return qt16_QuantBanheiro;
    }

    public void setQt16_QuantBanheiro(Integer qt16_QuantBanheiro) {
        this.qt16_QuantBanheiro = qt16_QuantBanheiro;
    }

    public Integer getQt16_QuantQuarto() {
        return qt16_QuantQuarto;
    }

    public void setQt16_QuantQuarto(Integer qt16_QuantQuarto) {
        this.qt16_QuantQuarto = qt16_QuantQuarto;
    }

    public String getQt17_ProblemaSaude() {
        return qt17_ProblemaSaude;
    }

    public void setQt17_ProblemaSaude(String qt17_ProblemaSaude) {
        this.qt17_ProblemaSaude = qt17_ProblemaSaude;
    }

    public float getQt18_AluguelImoveis() {
        return qt18_AluguelImoveis;
    }

    public void setQt18_AluguelImoveis(float qt18_AluguelImoveis) {
        this.qt18_AluguelImoveis = qt18_AluguelImoveis;
    }

    public float getQt18_PensaoMorte() {
        return qt18_PensaoMorte;
    }

    public void setQt18_PensaoMorte(float qt18_PensaoMorte) {
        this.qt18_PensaoMorte = qt18_PensaoMorte;
    }

    public float getQt18_PensaoAlimenticia() {
        return qt18_PensaoAlimenticia;
    }

    public void setQt18_PensaoAlimenticia(float qt18_PensaoAlimenticia) {
        this.qt18_PensaoAlimenticia = qt18_PensaoAlimenticia;
    }

    public float getQt18_AjudaTerceiros() {
        return qt18_AjudaTerceiros;
    }

    public void setQt18_AjudaTerceiros(float qt18_AjudaTerceiros) {
        this.qt18_AjudaTerceiros = qt18_AjudaTerceiros;
    }

    public float getQt18_BeneficiosSociais() {
        return qt18_BeneficiosSociais;
    }

    public void setQt18_BeneficiosSociais(float qt18_BeneficiosSociais) {
        this.qt18_BeneficiosSociais = qt18_BeneficiosSociais;
    }

    public float getQt18_OutraRenda() {
        return qt18_OutraRenda;
    }

    public void setQt18_OutraRenda(float qt18_OutraRenda) {
        this.qt18_OutraRenda = qt18_OutraRenda;
    }

    public String getQt18_NomeOutraRenda() {
        return qt18_NomeOutraRenda;
    }

    public void setQt18_NomeOutraRenda(String qt18_NomeOutraRenda) {
        this.qt18_NomeOutraRenda = qt18_NomeOutraRenda;
    }

    public float getQt18_TotalRenda() {
        return qt18_TotalRenda;
    }

    public void setQt18_TotalRenda(float qt18_TotalRenda) {
        this.qt18_TotalRenda = qt18_TotalRenda;
    }
    
    public Integer getQt18_NumeroResidentes() {
        return qt18_NumeroResidentes;
    }

    public void setQt18_NumeroResidentes(Integer qt18_NumeroResidentes) {
        this.qt18_NumeroResidentes = qt18_NumeroResidentes;
    }

    public float getQt19_ValorAgua() {
        return qt19_ValorAgua;
    }

    public void setQt19_ValorAgua(float qt19_ValorAgua) {
        this.qt19_ValorAgua = qt19_ValorAgua;
    }

    public float getQt19_ValorLuz() {
        return qt19_ValorLuz;
    }

    public void setQt19_ValorLuz(float qt19_ValorLuz) {
        this.qt19_ValorLuz = qt19_ValorLuz;
    }

    public float getQt19_ValorTelefone() {
        return qt19_ValorTelefone;
    }

    public void setQt19_ValorTelefone(float qt19_ValorTelefone) {
        this.qt19_ValorTelefone = qt19_ValorTelefone;
    }

    public float getQt19_ValorCondominio() {
        return qt19_ValorCondominio;
    }

    public void setQt19_ValorCondominio(float qt19_ValorCondominio) {
        this.qt19_ValorCondominio = qt19_ValorCondominio;
    }

    public float getQt19_ValorMensalidadeEscolar() {
        return qt19_ValorMensalidadeEscolar;
    }

    public void setQt19_ValorMensalidadeEscolar(float qt19_ValorMensalidadeEscolar) {
        this.qt19_ValorMensalidadeEscolar = qt19_ValorMensalidadeEscolar;
    }

    public float getQt19_ValorAlimentacao() {
        return qt19_ValorAlimentacao;
    }

    public void setQt19_ValorAlimentacao(float qt19_ValorAlimentacao) {
        this.qt19_ValorAlimentacao = qt19_ValorAlimentacao;
    }

    public float getQt19_ValorSaude() {
        return qt19_ValorSaude;
    }

    public void setQt19_ValorSaude(float qt19_ValorSaude) {
        this.qt19_ValorSaude = qt19_ValorSaude;
    }

    public float getQt19_ValorTransporte() {
        return qt19_ValorTransporte;
    }

    public void setQt19_ValorTransporte(float qt19_ValorTransporte) {
        this.qt19_ValorTransporte = qt19_ValorTransporte;
    }

    public float getQt19_ValorIptuAnual() {
        return qt19_ValorIptuAnual;
    }

    public void setQt19_ValorIptuAnual(float qt19_ValorIptuAnual) {
        this.qt19_ValorIptuAnual = qt19_ValorIptuAnual;
    }

    public float getQt19_ValorAluguel() {
        return qt19_ValorAluguel;
    }

    public void setQt19_ValorAluguel(float qt19_ValorAluguel) {
        this.qt19_ValorAluguel = qt19_ValorAluguel;
    }

    public float getQt19_ValorPensao() {
        return qt19_ValorPensao;
    }

    public void setQt19_ValorPensao(float qt19_ValorPensao) {
        this.qt19_ValorPensao = qt19_ValorPensao;
    }

    public float getQt19_ValorOutros() {
        return qt19_ValorOutros;
    }

    public void setQt19_ValorOutros(float qt19_ValorOutros) {
        this.qt19_ValorOutros = qt19_ValorOutros;
    }

    public float getQt20_ValorAgua() {
        return qt20_ValorAgua;
    }

    public void setQt20_ValorAgua(float qt20_ValorAgua) {
        this.qt20_ValorAgua = qt20_ValorAgua;
    }

    public float getQt20_ValorLuz() {
        return qt20_ValorLuz;
    }

    public void setQt20_ValorLuz(float qt20_ValorLuz) {
        this.qt20_ValorLuz = qt20_ValorLuz;
    }

    public float getQt20_ValorTelefone() {
        return qt20_ValorTelefone;
    }

    public void setQt20_ValorTelefone(float qt20_ValorTelefone) {
        this.qt20_ValorTelefone = qt20_ValorTelefone;
    }

    public float getQt20_ValorCondominio() {
        return qt20_ValorCondominio;
    }

    public void setQt20_ValorCondominio(float qt20_ValorCondominio) {
        this.qt20_ValorCondominio = qt20_ValorCondominio;
    }

    public float getQt20_ValorAluguel() {
        return qt20_ValorAluguel;
    }

    public void setQt20_ValorAluguel(float qt20_ValorAluguel) {
        this.qt20_ValorAluguel = qt20_ValorAluguel;
    }

    public float getQt20_ValorIptuAnual() {
        return qt20_ValorIptuAnual;
    }

    public void setQt20_ValorIptuAnual(float qt20_ValorIptuAnual) {
        this.qt20_ValorIptuAnual = qt20_ValorIptuAnual;
    }

    public String getQt21_Esclarecimentos() {
        return qt21_Esclarecimentos;
    }

    public void setQt21_Esclarecimentos(String qt21_Esclarecimentos) {
        this.qt21_Esclarecimentos = qt21_Esclarecimentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormulario != null ? codFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.codFormulario == null && other.codFormulario != null) || (this.codFormulario != null && !this.codFormulario.equals(other.codFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Formulario[ id=" + codFormulario + " ]";
    }
}
