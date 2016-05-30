package modelo;

import dao.AlunoDAO;
import dao.FormularioDAO;
import dao.SelecaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Formulario {
    private int codFormulario;
    private Aluno aluno;
    private Selecao selecao;
    
    private int codAluno;
    private int codSelecao;
    //--- Questão 01 ---
    private String qt01_Resposta;	// com ratio button de 'Sim' ou 'Não'
    private String qt01_Nome; 		// preenchida se qt01_Resposta = 'sim'
    private String qt01_Parentesco; 	// preenchida se qt01_Resposta = 'sim'
    private String qt01_Programa; 	// preenchida se qt01_Resposta = 'sim'
    private String qt01_Ano; 		// preenchida se qt01_Resposta = 'sim'

    //--- Questão 02 ---
    private String qt02_Alimentacao;	// com ratio button de 'Sim' ou 'Não'				
    private String qt02_Manutencao;	// com ratio button de 'Sim' ou 'Não'
    private String qt02_Moradia;	// com ratio button de 'Sim' ou 'Não'
    private String qt02_Transporte;	// com ratio button de 'Sim' ou 'Não'	
    private String qt02_Outro;          // preenchida se as respostas anteriores são iguais a 'Não'	

    //--- Questão 03 ---
    private String qt03_Transporte;             // com ratio button
    private String qt03_Tempo;                  // preenchida se qt03_Transporte = 'pé-bicicleta'
    private String qt03_ValorGastoDiario; 	// preenchida se qt03_Transporte = 'transporte coletivo'
    private String qt03_ValorGastoMensal; 	// preenchida se qt03_Transporte = 'transporte locado'
    private String qt03_Outro;                  // preenchida se qt03_Transporte = 'Outro'

    //--- Questão 04 ---
    private String qt04_InstituicaoEnsinoFundamental; 	// com ratio button

    //--- Questão 05 ---
    private String qt05_InstituicaoEnsinoMedio; 	// com ratio button

    //--- Questão 06 ---
    private String qt06_AtividadeRemunerada; 	// com ratio button
    private String qt06_ValorBolsaEstagio; 	// preenchida qt06_AtividadeRemunerada = estágio
    private String qt06_ProjetoIniciacao; 	// preenchida qt06_AtividadeRemunerada = iniciação científica
    private String qt06_ValorBolsaIniciacao; 	// preenchida qt06_AtividadeRemunerada = iniciação científica
    private String qt06_ProjetoTreinamento; 	// preenchida qt06_AtividadeRemunerada = treinamento profissional
    private String qt06_ValorBolsaTreinamento; 	// preenchida qt06_AtividadeRemunerada = treinamento profissional
    private String qt06_Outro;                  // preenchida qt06_AtividadeRemunerada = Outra
    private String qt06_ValorBolsaOutro; 	// preenchida qt06_AtividadeRemunerada = Outra

    //--- Questão 07 ---
    private String qt07_TrabalhoRemunerado;	// com ratio button de 'Sim' ou 'Não'
    private String qt07_HorasSemanais;  	// preenchida se qt07_TrabalhoRemunerado = 'Sim'
    private String qt07_Salario; 		// preenchida se qt07_TrabalhoRemunerado = 'Sim'

    //--- Questão 08 ---
    private String qt08_Manutencao; 	// com ratio button
    private String qt08_Outra;          // preenchida se qt08_Manutencao = 'Outra'

    //--- Questão 09 ---
    private String qt09_Moradia; 	// com ratio button
    private String qt09_Outra;          // preenchida se qt09_Moradia = 'Outra'

    //--- Questão 10 ---
    private String qt10_ResponsavelFinanceiro;		// com ratio button
    private String qt10_Outros; 			// preenchida se qt10_ResponsavelFinanceiro = 'Outros'

    //--- Questão 11 ---
    private String qt11_Esgoto;         // com ratio button de 'Sim' ou 'Não'
    private String qt11_Agua;		// com ratio button de 'Sim' ou 'Não'
    private String qt11_Iluminacao;	// com ratio button de 'Sim' ou 'Não'
    private String qt11_Lixo;		// com ratio button de 'Sim' ou 'Não'
    private String qt11_Pavimentacao;	// com ratio button de 'Sim' ou 'Não'

    //--- Questão 12 ---
    private String qt12_Residencia; 	// com ratio button
    private String qt12_Outro;		// preenchida se qt12_Residencia = 'Outro'

    //--- Questão 13 ---
    private String qt13_Imovel; 	// com ratio button
    private String qt13_ValorAluguel;	// preenchida se qt13_Imovel = alugado
    private String qt13_ValorPrestacao;	// preenchida se qt13_Imovel = em pagamento
    private String qt13_Nome;		// preenchida se qt13_Imovel = emprestado
    private String qt13_Outro;		// preenchida se qt13_Imovel = Outro

    //--- Questão 14 ---
    private String qt14_Acabamento; 	// com ratio button

    //--- Questão 15 ---
    private String qt15_OutrosImoveis;      // com ratio button de 'Sim' ou 'Não'
    private String qt15_DescricaoImoveis;   // preenchida se qt15_OutrosImoveis = 'Sim'

    //--- Questão 16 ---
    private int qt16_QuantCarro;
    private int qt16_QuantTV;
    private int qt16_QuantMaqLavar;
    private int qt16_QuantGeladeira;
    private int qt16_QuantTVCabo;
    private int qt16_QuantComputador;
    private int qt16_QuantInternetPaga;
    private int qt16_QuantEmpregadaMensalista;
    private int qt16_QuantEmpregadaDiarista;
    private int qt16_QuantBanheiro;
    private int qt16_QuantQuarto;

    //--- Questão 17 ---
    private String qt17_ProblemaSaude; // com ratio button de 'Sim' ou 'Não'
    //se 'Sim' acessar tabela separada para preencher seus campos

    //--- Questão 18 ---
    //acessar tabela separada
    private double qt18_AluguelImoveis;
    private double qt18_PensaoMorte;
    private double qt18_PensaoAlimenticia;
    private double qt18_AjudaTerceiros;
    private double qt18_BeneficiosSociais;
    private double qt18_OutraRenda;
    private String qt18_NomeOutraRenda;
    private double qt18_TotalRenda;
    private int qt18_NumeroResidentes;

    //--- Questão 19 ---
    private double qt19_ValorAgua;
    private double qt19_ValorLuz;
    private double qt19_ValorTelefone;
    private double qt19_ValorCondominio;
    private double qt19_ValorMensalidadeEscolar;
    private double qt19_ValorAlimentacao;
    private double qt19_ValorSaude;
    private double qt19_ValorTransporte;
    private double qt19_ValorIptuAnual;
    private double qt19_ValorAluguel;
    private double qt19_ValorPensao;
    private double qt19_ValorOutros;

    //--- Questão 20 ---
    private double qt20_ValorAgua;
    private double qt20_ValorLuz;
    private double qt20_ValorTelefone;
    private double qt20_ValorCondominio;
    private double qt20_ValorAluguel;
    private double qt20_ValorIptuAnual;

    //--- Questão 21 ---
    private String qt21_Esclarecimentos; 

    public Formulario(int codFormulario, Aluno aluno, Selecao selecao, String qt01_Resposta, String qt01_Nome, String qt01_Parentesco, String qt01_Programa,
            String qt01_Ano, String qt02_Alimentacao, String qt02_Manutencao, String qt02_Moradia, String qt02_Transporte, String qt02_Outro, String qt03_Transporte,
            String qt03_Tempo, String qt03_ValorGastoDiario, String qt03_ValorGastoMensal, String qt03_Outro, String qt04_InstituicaoEnsinoFundamental, 
            String qt05_InstituicaoEnsinoMedio, String qt06_AtividadeRemunerada, String qt06_ValorBolsaEstagio, String qt06_ProjetoIniciacao, String qt06_ValorBolsaIniciacao, 
            String qt06_ProjetoTreinamento, String qt06_ValorBolsaTreinamento, String qt06_Outro, String qt06_ValorBolsaOutro, String qt07_TrabalhoRemunerado, 
            String qt07_HorasSemanais, String qt07_Salario, String qt08_Manutencao, String qt08_Outra, String qt09_Moradia, String qt09_Outra, 
            String qt10_ResponsavelFinanceiro, String qt10_Outros, String qt11_Esgoto, String qt11_Agua, String qt11_Iluminacao, String qt11_Lixo, 
            String qt11_Pavimentacao, String qt12_Residencia, String qt12_Outro, String qt13_Imovel, String qt13_ValorAluguel, String qt13_ValorPrestacao, 
            String qt13_Nome, String qt13_Outro, String qt14_Acabamento, String qt15_OutrosImoveis, String qt15_DescricaoImoveis, int qt16_QuantCarro, int qt16_QuantTV, 
            int qt16_QuantMaqLavar, int qt16_QuantGeladeira, int qt16_QuantTVCabo, int qt16_QuantComputador, int qt16_QuantInternetPaga, int qt16_QuantEmpregadaMensalista, 
            int qt16_QuantEmpregadaDiarista, int qt16_QuantBanheiro, int qt16_QuantQuarto, String qt17_ProblemaSaude, double qt18_AluguelImoveis, 
            double qt18_PensaoMorte, double qt18_PensaoAlimenticia, double qt18_AjudaTerceiros, double qt18_BeneficiosSociais, double qt18_OutraRenda, 
            String qt18_NomeOutraRenda, double qt18_TotalRenda, int qt18_NumeroResidentes, double qt19_ValorAgua, double qt19_ValorLuz, double qt19_ValorTelefone, double qt19_ValorCondominio, 
            double qt19_ValorMensalidadeEscolar, double qt19_ValorAlimentacao, double qt19_ValorSaude, double qt19_ValorTransporte, double qt19_ValorIptuAnual, 
            double qt19_ValorAluguel, double qt19_ValorPensao, double qt19_ValorOutros, double qt20_ValorAgua, double qt20_ValorLuz, double qt20_ValorTelefone, 
            double qt20_ValorCondominio, double qt20_ValorAluguel, double qt20_ValorIptuAnual, String qt21_Esclarecimentos) {
        this.codFormulario = codFormulario;
        this.aluno = aluno;
        this.selecao = selecao;
        this.qt01_Resposta = qt01_Resposta;
        this.qt01_Nome = qt01_Nome;
        this.qt01_Parentesco = qt01_Parentesco;
        this.qt01_Programa = qt01_Programa;
        this.qt01_Ano = qt01_Ano;
        this.qt02_Alimentacao = qt02_Alimentacao;
        this.qt02_Manutencao = qt02_Manutencao;
        this.qt02_Moradia = qt02_Moradia;
        this.qt02_Transporte = qt02_Transporte;
        this.qt02_Outro = qt02_Outro;
        this.qt03_Transporte = qt03_Transporte;
        this.qt03_Tempo = qt03_Tempo;
        this.qt03_ValorGastoDiario = qt03_ValorGastoDiario;
        this.qt03_ValorGastoMensal = qt03_ValorGastoMensal;
        this.qt03_Outro = qt03_Outro;
        this.qt04_InstituicaoEnsinoFundamental = qt04_InstituicaoEnsinoFundamental;
        this.qt05_InstituicaoEnsinoMedio = qt05_InstituicaoEnsinoMedio;
        this.qt06_AtividadeRemunerada = qt06_AtividadeRemunerada;
        this.qt06_ValorBolsaEstagio = qt06_ValorBolsaEstagio;
        this.qt06_ProjetoIniciacao = qt06_ProjetoIniciacao;
        this.qt06_ValorBolsaIniciacao = qt06_ValorBolsaIniciacao;
        this.qt06_ProjetoTreinamento = qt06_ProjetoTreinamento;
        this.qt06_ValorBolsaTreinamento = qt06_ValorBolsaTreinamento;
        this.qt06_Outro = qt06_Outro;
        this.qt06_ValorBolsaOutro = qt06_ValorBolsaOutro;
        this.qt07_TrabalhoRemunerado = qt07_TrabalhoRemunerado;
        this.qt07_HorasSemanais = qt07_HorasSemanais;
        this.qt07_Salario = qt07_Salario;
        this.qt08_Manutencao = qt08_Manutencao;
        this.qt08_Outra = qt08_Outra;
        this.qt09_Moradia = qt09_Moradia;
        this.qt09_Outra = qt09_Outra;
        this.qt10_ResponsavelFinanceiro = qt10_ResponsavelFinanceiro;
        this.qt10_Outros = qt10_Outros;
        this.qt11_Esgoto = qt11_Esgoto;
        this.qt11_Agua = qt11_Agua;
        this.qt11_Iluminacao = qt11_Iluminacao;
        this.qt11_Lixo = qt11_Lixo;
        this.qt11_Pavimentacao = qt11_Pavimentacao;
        this.qt12_Residencia = qt12_Residencia;
        this.qt12_Outro = qt12_Outro;
        this.qt13_Imovel = qt13_Imovel;
        this.qt13_ValorAluguel = qt13_ValorAluguel;
        this.qt13_ValorPrestacao = qt13_ValorPrestacao;
        this.qt13_Nome = qt13_Nome;
        this.qt13_Outro = qt13_Outro;
        this.qt14_Acabamento = qt14_Acabamento;
        this.qt15_OutrosImoveis = qt15_OutrosImoveis;
        this.qt15_DescricaoImoveis = qt15_DescricaoImoveis;
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
        this.qt17_ProblemaSaude = qt17_ProblemaSaude;
        this.qt18_AluguelImoveis = qt18_AluguelImoveis;
        this.qt18_PensaoMorte = qt18_PensaoMorte;
        this.qt18_PensaoAlimenticia = qt18_PensaoAlimenticia;
        this.qt18_AjudaTerceiros = qt18_AjudaTerceiros;
        this.qt18_BeneficiosSociais = qt18_BeneficiosSociais;
        this.qt18_OutraRenda = qt18_OutraRenda;
        this.qt18_NomeOutraRenda = qt18_NomeOutraRenda;
        this.qt18_TotalRenda = qt18_TotalRenda;
        this.qt18_NumeroResidentes = qt18_NumeroResidentes;
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
        this.qt20_ValorAgua = qt20_ValorAgua;
        this.qt20_ValorLuz = qt20_ValorLuz;
        this.qt20_ValorTelefone = qt20_ValorTelefone;
        this.qt20_ValorCondominio = qt20_ValorCondominio;
        this.qt20_ValorAluguel = qt20_ValorAluguel;
        this.qt20_ValorIptuAnual = qt20_ValorIptuAnual;
        this.qt21_Esclarecimentos = qt21_Esclarecimentos;
    }

    public static List<Formulario> obterFormularios() throws ClassNotFoundException{
        return FormularioDAO.obterFormularios();
    }
    
    public static Formulario obterFormulario(int codFormulario) throws ClassNotFoundException{
        return FormularioDAO.obterFormulario(codFormulario);
    }
    
    public int getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(int codFormulario) {
        this.codFormulario = codFormulario;
    }

    public Aluno getAluno() throws ClassNotFoundException {
        if ((codAluno != 0) && (aluno == null)) {
            aluno = AlunoDAO.obterAluno(codAluno);
        }
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Selecao getSelecao() throws ClassNotFoundException {
        if ((codSelecao != 0) && (selecao == null)){
            selecao = SelecaoDAO.obterSelecao(codSelecao);
        }
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }
    
    public int getCodSelecao() {
        return codSelecao;
    }

    public void setCodSelecao(int codSelecao) {
        this.codSelecao = codSelecao;
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

    public String getQt03_ValorGastoDiario() {
        return qt03_ValorGastoDiario;
    }

    public void setQt03_ValorGastoDiario(String qt03_ValorGastoDiario) {
        this.qt03_ValorGastoDiario = qt03_ValorGastoDiario;
    }

    public String getQt03_ValorGastoMensal() {
        return qt03_ValorGastoMensal;
    }

    public void setQt03_ValorGastoMensal(String qt03_ValorGastoMensal) {
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

    public String getQt06_ValorBolsaEstagio() {
        return qt06_ValorBolsaEstagio;
    }

    public void setQt06_ValorBolsaEstagio(String qt06_ValorBolsaEstagio) {
        this.qt06_ValorBolsaEstagio = qt06_ValorBolsaEstagio;
    }

    public String getQt06_ProjetoIniciacao() {
        return qt06_ProjetoIniciacao;
    }

    public void setQt06_ProjetoIniciacao(String qt06_ProjetoIniciacao) {
        this.qt06_ProjetoIniciacao = qt06_ProjetoIniciacao;
    }

    public String getQt06_ValorBolsaIniciacao() {
        return qt06_ValorBolsaIniciacao;
    }

    public void setQt06_ValorBolsaIniciacao(String qt06_ValorBolsaIniciacao) {
        this.qt06_ValorBolsaIniciacao = qt06_ValorBolsaIniciacao;
    }

    public String getQt06_ProjetoTreinamento() {
        return qt06_ProjetoTreinamento;
    }

    public void setQt06_ProjetoTreinamento(String qt06_ProjetoTreinamento) {
        this.qt06_ProjetoTreinamento = qt06_ProjetoTreinamento;
    }

    public String getQt06_ValorBolsaTreinamento() {
        return qt06_ValorBolsaTreinamento;
    }

    public void setQt06_ValorBolsaTreinamento(String qt06_ValorBolsaTreinamento) {
        this.qt06_ValorBolsaTreinamento = qt06_ValorBolsaTreinamento;
    }

    public String getQt06_Outro() {
        return qt06_Outro;
    }

    public void setQt06_Outro(String qt06_Outro) {
        this.qt06_Outro = qt06_Outro;
    }

    public String getQt06_ValorBolsaOutro() {
        return qt06_ValorBolsaOutro;
    }

    public void setQt06_ValorBolsaOutro(String qt06_ValorBolsaOutro) {
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

    public String getQt07_Salario() {
        return qt07_Salario;
    }

    public void setQt07_Salario(String qt07_Salario) {
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

    public String getQt13_ValorAluguel() {
        return qt13_ValorAluguel;
    }

    public void setQt13_ValorAluguel(String qt13_ValorAluguel) {
        this.qt13_ValorAluguel = qt13_ValorAluguel;
    }

    public String getQt13_ValorPrestacao() {
        return qt13_ValorPrestacao;
    }

    public void setQt13_ValorPrestacao(String qt13_ValorPrestacao) {
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
    
    public int getQt16_QuantCarro() {
        return qt16_QuantCarro;
    }

    public void setQt16_QuantCarro(int qt16_QuantCarro) {
        this.qt16_QuantCarro = qt16_QuantCarro;
    }

    public int getQt16_QuantTV() {
        return qt16_QuantTV;
    }

    public void setQt16_QuantTV(int qt16_QuantTV) {
        this.qt16_QuantTV = qt16_QuantTV;
    }

    public int getQt16_QuantMaqLavar() {
        return qt16_QuantMaqLavar;
    }

    public void setQt16_QuantMaqLavar(int qt16_QuantMaqLavar) {
        this.qt16_QuantMaqLavar = qt16_QuantMaqLavar;
    }

    public int getQt16_QuantGeladeira() {
        return qt16_QuantGeladeira;
    }

    public void setQt16_QuantGeladeira(int qt16_QuantGeladeira) {
        this.qt16_QuantGeladeira = qt16_QuantGeladeira;
    }

    public int getQt16_QuantTVCabo() {
        return qt16_QuantTVCabo;
    }

    public void setQt16_QuantTVCabo(int qt16_QuantTVCabo) {
        this.qt16_QuantTVCabo = qt16_QuantTVCabo;
    }

    public int getQt16_QuantComputador() {
        return qt16_QuantComputador;
    }

    public void setQt16_QuantComputador(int qt16_QuantComputador) {
        this.qt16_QuantComputador = qt16_QuantComputador;
    }

    public int getQt16_QuantInternetPaga() {
        return qt16_QuantInternetPaga;
    }

    public void setQt16_QuantInternetPaga(int qt16_QuantInternetPaga) {
        this.qt16_QuantInternetPaga = qt16_QuantInternetPaga;
    }

    public int getQt16_QuantEmpregadaMensalista() {
        return qt16_QuantEmpregadaMensalista;
    }

    public void setQt16_QuantEmpregadaMensalista(int qt16_QuantEmpregadaMensalista) {
        this.qt16_QuantEmpregadaMensalista = qt16_QuantEmpregadaMensalista;
    }

    public int getQt16_QuantEmpregadaDiarista() {
        return qt16_QuantEmpregadaDiarista;
    }

    public void setQt16_QuantEmpregadaDiarista(int qt16_QuantEmpregadaDiarista) {
        this.qt16_QuantEmpregadaDiarista = qt16_QuantEmpregadaDiarista;
    }

    public int getQt16_QuantBanheiro() {
        return qt16_QuantBanheiro;
    }

    public void setQt16_QuantBanheiro(int qt16_QuantBanheiro) {
        this.qt16_QuantBanheiro = qt16_QuantBanheiro;
    }

    public int getQt16_QuantQuarto() {
        return qt16_QuantQuarto;
    }

    public void setQt16_QuantQuarto(int qt16_QuantQuarto) {
        this.qt16_QuantQuarto = qt16_QuantQuarto;
    }

    public String getQt17_ProblemaSaude() {
        return qt17_ProblemaSaude;
    }

    public void setQt17_ProblemaSaude(String qt17_ProblemaSaude) {
        this.qt17_ProblemaSaude = qt17_ProblemaSaude;
    }

    public double getQt18_AluguelImoveis() {
        return qt18_AluguelImoveis;
    }

    public void setQt18_AluguelImoveis(double qt18_AluguelImoveis) {
        this.qt18_AluguelImoveis = qt18_AluguelImoveis;
    }

    public double getQt18_PensaoMorte() {
        return qt18_PensaoMorte;
    }

    public void setQt18_PensaoMorte(double qt18_PensaoMorte) {
        this.qt18_PensaoMorte = qt18_PensaoMorte;
    }

    public double getQt18_PensaoAlimenticia() {
        return qt18_PensaoAlimenticia;
    }

    public void setQt18_PensaoAlimenticia(double qt18_PensaoAlimenticia) {
        this.qt18_PensaoAlimenticia = qt18_PensaoAlimenticia;
    }

    public double getQt18_AjudaTerceiros() {
        return qt18_AjudaTerceiros;
    }

    public void setQt18_AjudaTerceiros(double qt18_AjudaTerceiros) {
        this.qt18_AjudaTerceiros = qt18_AjudaTerceiros;
    }

    public double getQt18_BeneficiosSociais() {
        return qt18_BeneficiosSociais;
    }

    public void setQt18_BeneficiosSociais(double qt18_BeneficiosSociais) {
        this.qt18_BeneficiosSociais = qt18_BeneficiosSociais;
    }

    public double getQt18_OutraRenda() {
        return qt18_OutraRenda;
    }

    public void setQt18_OutraRenda(double qt18_OutraRenda) {
        this.qt18_OutraRenda = qt18_OutraRenda;
    }

    public String getQt18_NomeOutraRenda() {
        return qt18_NomeOutraRenda;
    }

    public void setQt18_NomeOutraRenda(String qt18_NomeOutraRenda) {
        this.qt18_NomeOutraRenda = qt18_NomeOutraRenda;
    }

    public double getQt18_TotalRenda() {
        return qt18_TotalRenda;
    }

    public void setQt18_TotalRenda(double qt18_TotalRenda) {
        this.qt18_TotalRenda = qt18_TotalRenda;
    }
    
    public int getQt18_NumeroResidentes() {
        return qt18_NumeroResidentes;
    }

    public void setQt18_NumeroResidentes(int qt18_NumeroResidentes) {
        this.qt18_NumeroResidentes = qt18_NumeroResidentes;
    }

    public double getQt19_ValorAgua() {
        return qt19_ValorAgua;
    }

    public void setQt19_ValorAgua(double qt19_ValorAgua) {
        this.qt19_ValorAgua = qt19_ValorAgua;
    }

    public double getQt19_ValorLuz() {
        return qt19_ValorLuz;
    }

    public void setQt19_ValorLuz(double qt19_ValorLuz) {
        this.qt19_ValorLuz = qt19_ValorLuz;
    }

    public double getQt19_ValorTelefone() {
        return qt19_ValorTelefone;
    }

    public void setQt19_ValorTelefone(double qt19_ValorTelefone) {
        this.qt19_ValorTelefone = qt19_ValorTelefone;
    }

    public double getQt19_ValorCondominio() {
        return qt19_ValorCondominio;
    }

    public void setQt19_ValorCondominio(double qt19_ValorCondominio) {
        this.qt19_ValorCondominio = qt19_ValorCondominio;
    }

    public double getQt19_ValorMensalidadeEscolar() {
        return qt19_ValorMensalidadeEscolar;
    }

    public void setQt19_ValorMensalidadeEscolar(double qt19_ValorMensalidadeEscolar) {
        this.qt19_ValorMensalidadeEscolar = qt19_ValorMensalidadeEscolar;
    }

    public double getQt19_ValorAlimentacao() {
        return qt19_ValorAlimentacao;
    }

    public void setQt19_ValorAlimentacao(double qt19_ValorAlimentacao) {
        this.qt19_ValorAlimentacao = qt19_ValorAlimentacao;
    }

    public double getQt19_ValorSaude() {
        return qt19_ValorSaude;
    }

    public void setQt19_ValorSaude(double qt19_ValorSaude) {
        this.qt19_ValorSaude = qt19_ValorSaude;
    }

    public double getQt19_ValorTransporte() {
        return qt19_ValorTransporte;
    }

    public void setQt19_ValorTransporte(double qt19_ValorTransporte) {
        this.qt19_ValorTransporte = qt19_ValorTransporte;
    }

    public double getQt19_ValorIptuAnual() {
        return qt19_ValorIptuAnual;
    }

    public void setQt19_ValorIptuAnual(double qt19_ValorIptuAnual) {
        this.qt19_ValorIptuAnual = qt19_ValorIptuAnual;
    }

    public double getQt19_ValorAluguel() {
        return qt19_ValorAluguel;
    }

    public void setQt19_ValorAluguel(double qt19_ValorAluguel) {
        this.qt19_ValorAluguel = qt19_ValorAluguel;
    }

    public double getQt19_ValorPensao() {
        return qt19_ValorPensao;
    }

    public void setQt19_ValorPensao(double qt19_ValorPensao) {
        this.qt19_ValorPensao = qt19_ValorPensao;
    }

    public double getQt19_ValorOutros() {
        return qt19_ValorOutros;
    }

    public void setQt19_ValorOutros(double qt19_ValorOutros) {
        this.qt19_ValorOutros = qt19_ValorOutros;
    }

    public double getQt20_ValorAgua() {
        return qt20_ValorAgua;
    }

    public void setQt20_ValorAgua(double qt20_ValorAgua) {
        this.qt20_ValorAgua = qt20_ValorAgua;
    }

    public double getQt20_ValorLuz() {
        return qt20_ValorLuz;
    }

    public void setQt20_ValorLuz(double qt20_ValorLuz) {
        this.qt20_ValorLuz = qt20_ValorLuz;
    }

    public double getQt20_ValorTelefone() {
        return qt20_ValorTelefone;
    }

    public void setQt20_ValorTelefone(double qt20_ValorTelefone) {
        this.qt20_ValorTelefone = qt20_ValorTelefone;
    }

    public double getQt20_ValorCondominio() {
        return qt20_ValorCondominio;
    }

    public void setQt20_ValorCondominio(double qt20_ValorCondominio) {
        this.qt20_ValorCondominio = qt20_ValorCondominio;
    }

    public double getQt20_ValorAluguel() {
        return qt20_ValorAluguel;
    }

    public void setQt20_ValorAluguel(double qt20_ValorAluguel) {
        this.qt20_ValorAluguel = qt20_ValorAluguel;
    }

    public double getQt20_ValorIptuAnual() {
        return qt20_ValorIptuAnual;
    }

    public void setQt20_ValorIptuAnual(double qt20_ValorIptuAnual) {
        this.qt20_ValorIptuAnual = qt20_ValorIptuAnual;
    }

    public String getQt21_Esclarecimentos() {
        return qt21_Esclarecimentos;
    }

    public void setQt21_Esclarecimentos(String qt21_Esclarecimentos) {
        this.qt21_Esclarecimentos = qt21_Esclarecimentos;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FormularioDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        FormularioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        FormularioDAO.excluir(this);
    }
}
