package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Formulario;

public class FormularioDAO {
    public static List<Formulario> obterFormularios() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Formulario> formularios = new ArrayList<Formulario>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from FORMULARIO");
            while(rs.next()){
                Formulario formulario = new Formulario(
                    rs.getInt("FORMULARIO_ID"),
                    null, null,
                    rs.getString("QT01_RESPOSTA"),
                    rs.getString("QT01_NOME"),
                    rs.getString("QT01_PARENTESCO"),
                    rs.getString("QT01_PROGRAMA"),
                    rs.getString("QT01_ANO"),
                    rs.getString("QT02_ALIMENTACAO"),
                    rs.getString("QT02_MANUTENCAO"),
                    rs.getString("QT02_MORADIA"),
                    rs.getString("QT02_TRANSPORTE"),
                    rs.getString("QT02_OUTRO"),
                    rs.getString("QT03_TRANSPORTE"),
                    rs.getString("QT03_TEMPO"),
                    rs.getString("QT03_VALOR_GASTO_DIARIO"),
                    rs.getString("QT03_VALOR_GASTO_MENSAL"),
                    rs.getString("QT03_OUTRO"),
                    rs.getString("QT04_INSTITUICAO_ENSINO_FUNDAMENTAL"),
                    rs.getString("QT05_INSTITUICAO_ENSINO_MEDIO"),
                    rs.getString("QT06_ATIVIDADE_REMUNERADA"),
                    rs.getString("QT06_VALOR_BOLSA_ESTAGIO"),
                    rs.getString("QT06_PROJETO_INICIACAO"),
                    rs.getString("QT06_VALOR_BOLSA_INICIACAO"),
                    rs.getString("QT06_PROJETO_TREINAMENTO"),
                    rs.getString("QT06_VALOR_BOLSA_TREINAMENTO"),
                    rs.getString("QT06_OUTRO"),
                    rs.getString("QT06_VALOR_BOLSA_OUTRO"),
                    rs.getString("QT07_TRABALHO_REMUNERADO"),
                    rs.getString("QT07_HORAS_SEMANAIS"),
                    rs.getString("QT07_SALARIO"),
                    rs.getString("QT08_MANUTENCAO"),
                    rs.getString("QT08_OUTRO"),
                    rs.getString("QT09_MORADIA"),
                    rs.getString("QT09_OUTRO"),
                    rs.getString("QT10_RESPONSAVEL_FINANCEIRO"),
                    rs.getString("QT10_OUTRO"),
                    rs.getString("QT11_ESGOTO"),
                    rs.getString("QT11_AGUA_TRATADA"),
                    rs.getString("QT11_ILUMINACAO"),
                    rs.getString("QT11_COLETA_LIXO"),
                    rs.getString("QT11_RUA_PAVIMENTADA"),
                    rs.getString("QT12_RESIDENCIA"),
                    rs.getString("QT12_OUTRO"),
                    rs.getString("QT13_IMOVEL"),
                    rs.getString("QT13_VALOR_ALUGUEL"),
                    rs.getString("QT13_VALOR_PRESTACAO"),
                    rs.getString("QT13_NOME"),
                    rs.getString("QT13_OUTRO"),
                    rs.getString("QT14_ACABAMENTO"),
                    rs.getString("QT15_OUTROS_IMOVEIS"),
                    rs.getString("QT15_DESCRICAO_IMOVEIS"),
                    rs.getInt("QT16_QUANTIDADE_CARRO"),
                    rs.getInt("QT16_QUANTIDADE_TELEVISAO"),
                    rs.getInt("QT16_QUANTIDADE_MAQUINA_LAVAR"),
                    rs.getInt("QT16_QUANTIDADE_GELADEIRA"),
                    rs.getInt("QT16_QUANTIDADE_TV_CABO"),
                    rs.getInt("QT16_QUANTIDADE_COMPUTADOR"),
                    rs.getInt("QT16_QUANTIDADE_INTERNET"),
                    rs.getInt("QT16_QUANTIDADE_EMPREGADA_MENSALISTA"),
                    rs.getInt("QT16_QUANTIDADE_EMPREGADA_DIARISTA"),
                    rs.getInt("QT16_QUANTIDADE_BANHEIRO"),
                    rs.getInt("QT16_QUANTIDADE_QUARTO"),
                    rs.getString("QT17_PROBLEMA_SAUDE"),
                    rs.getDouble("QT18_ALUGUEL_IMOVEIS"),
                    rs.getDouble("QT18_PENSAO_MORTE"),
                    rs.getDouble("QT18_PENSAO_ALIMENTICIA"),
                    rs.getDouble("QT18_AJUDA_TERCEIROS"),
                    rs.getDouble("QT18_BENEFICIOS_SOCIAIS"),
                    rs.getDouble("QT18_OUTRA_RENDA"),
                    rs.getString("QT18_NOME_OUTRA_RENDA"),
                    rs.getDouble("QT18_TOTAL_RENDA"),
                    rs.getInt("QT18_NUMERO_RESIDENTES"),
                    rs.getDouble("QT19_VALOR_AGUA"),
                    rs.getDouble("QT19_VALOR_LUZ"),
                    rs.getDouble("QT19_VALOR_TELEFONE"),
                    rs.getDouble("QT19_VALOR_CONDOMINIO"),
                    rs.getDouble("QT19_VALOR_MENSALIDADE_ESCOLAR"),
                    rs.getDouble("QT19_VALOR_ALIMENTACAO"),
                    rs.getDouble("QT19_VALOR_SAUDE"),
                    rs.getDouble("QT19_VALOR_TRANSPORTE"),
                    rs.getDouble("QT19_VALOR_IPTU_ANUAL"),
                    rs.getDouble("QT19_VALOR_ALUGUEL"),
                    rs.getDouble("QT19_VALOR_PENSAO"),
                    rs.getDouble("QT19_VALOR_OUTROS"),
                    rs.getDouble("QT20_VALOR_AGUA"),
                    rs.getDouble("QT20_VALOR_LUZ"),
                    rs.getDouble("QT20_VALOR_TELEFONE"),
                    rs.getDouble("QT20_VALOR_CONDOMINIO"),
                    rs.getDouble("QT20_VALOR_ALUGUEL"),
                    rs.getDouble("QT20_VALOR_IPTU_ANUAL"),
                    rs.getString("QT21_ESCLARECIMENTOS"));
                formulario.setCodAluno(rs.getInt("ALUNO_MATRICULA"));
                formulario.setCodSelecao(rs.getInt("SELECAO_ID"));
                formularios.add(formulario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            fecharConexao(conexao, comando);
        }
        return formularios;
    }
    
    public static Formulario obterFormulario(int codFormulario) throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        Formulario formulario = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from FORMULARIO where FORMULARIO_ID = " + codFormulario);
            rs.first();
            formulario = new Formulario(
                    rs.getInt("FORMULARIO_ID"),
                    null, null,
                    rs.getString("QT01_RESPOSTA"),
                    rs.getString("QT01_NOME"),
                    rs.getString("QT01_PARENTESCO"),
                    rs.getString("QT01_PROGRAMA"),
                    rs.getString("QT01_ANO"),
                    rs.getString("QT02_ALIMENTACAO"),
                    rs.getString("QT02_MANUTENCAO"),
                    rs.getString("QT02_MORADIA"),
                    rs.getString("QT02_TRANSPORTE"),
                    rs.getString("QT02_OUTRO"),
                    rs.getString("QT03_TRANSPORTE"),
                    rs.getString("QT03_TEMPO"),
                    rs.getString("QT03_VALOR_GASTO_DIARIO"),
                    rs.getString("QT03_VALOR_GASTO_MENSAL"),
                    rs.getString("QT03_OUTRO"),
                    rs.getString("QT04_INSTITUICAO_ENSINO_FUNDAMENTAL"),
                    rs.getString("QT05_INSTITUICAO_ENSINO_MEDIO"),
                    rs.getString("QT06_ATIVIDADE_REMUNERADA"),
                    rs.getString("QT06_VALOR_BOLSA_ESTAGIO"),
                    rs.getString("QT06_PROJETO_INICIACAO"),
                    rs.getString("QT06_VALOR_BOLSA_INICIACAO"),
                    rs.getString("QT06_PROJETO_TREINAMENTO"),
                    rs.getString("QT06_VALOR_BOLSA_TREINAMENTO"),
                    rs.getString("QT06_OUTRO"),
                    rs.getString("QT06_VALOR_BOLSA_OUTRO"),
                    rs.getString("QT07_TRABALHO_REMUNERADO"),
                    rs.getString("QT07_HORAS_SEMANAIS"),
                    rs.getString("QT07_SALARIO"),
                    rs.getString("QT08_MANUTENCAO"),
                    rs.getString("QT08_OUTRO"),
                    rs.getString("QT09_MORADIA"),
                    rs.getString("QT09_OUTRO"),
                    rs.getString("QT10_RESPONSAVEL_FINANCEIRO"),
                    rs.getString("QT10_OUTRO"),
                    rs.getString("QT11_ESGOTO"),
                    rs.getString("QT11_AGUA_TRATADA"),
                    rs.getString("QT11_ILUMINACAO"),
                    rs.getString("QT11_COLETA_LIXO"),
                    rs.getString("QT11_RUA_PAVIMENTADA"),
                    rs.getString("QT12_RESIDENCIA"),
                    rs.getString("QT12_OUTRO"),
                    rs.getString("QT13_IMOVEL"),
                    rs.getString("QT13_VALOR_ALUGUEL"),
                    rs.getString("QT13_VALOR_PRESTACAO"),
                    rs.getString("QT13_NOME"),
                    rs.getString("QT13_OUTRO"),
                    rs.getString("QT14_ACABAMENTO"),
                    rs.getString("QT15_OUTROS_IMOVEIS"),
                    rs.getString("QT15_DESCRICAO_IMOVEIS"),
                    rs.getInt("QT16_QUANTIDADE_CARRO"),
                    rs.getInt("QT16_QUANTIDADE_TELEVISAO"),
                    rs.getInt("QT16_QUANTIDADE_MAQUINA_LAVAR"),
                    rs.getInt("QT16_QUANTIDADE_GELADEIRA"),
                    rs.getInt("QT16_QUANTIDADE_TV_CABO"),
                    rs.getInt("QT16_QUANTIDADE_COMPUTADOR"),
                    rs.getInt("QT16_QUANTIDADE_INTERNET"),
                    rs.getInt("QT16_QUANTIDADE_EMPREGADA_MENSALISTA"),
                    rs.getInt("QT16_QUANTIDADE_EMPREGADA_DIARISTA"),
                    rs.getInt("QT16_QUANTIDADE_BANHEIRO"),
                    rs.getInt("QT16_QUANTIDADE_QUARTO"),
                    rs.getString("QT17_PROBLEMA_SAUDE"),
                    rs.getDouble("QT18_ALUGUEL_IMOVEIS"),
                    rs.getDouble("QT18_PENSAO_MORTE"),
                    rs.getDouble("QT18_PENSAO_ALIMENTICIA"),
                    rs.getDouble("QT18_AJUDA_TERCEIROS"),
                    rs.getDouble("QT18_BENEFICIOS_SOCIAIS"),
                    rs.getDouble("QT18_OUTRA_RENDA"),
                    rs.getString("QT18_NOME_OUTRA_RENDA"),
                    rs.getDouble("QT18_TOTAL_RENDA"),
                    rs.getInt("QT18_NUMERO_RESIDENTES"),
                    rs.getDouble("QT19_VALOR_AGUA"),
                    rs.getDouble("QT19_VALOR_LUZ"),
                    rs.getDouble("QT19_VALOR_TELEFONE"),
                    rs.getDouble("QT19_VALOR_CONDOMINIO"),
                    rs.getDouble("QT19_VALOR_MENSALIDADE_ESCOLAR"),
                    rs.getDouble("QT19_VALOR_ALIMENTACAO"),
                    rs.getDouble("QT19_VALOR_SAUDE"),
                    rs.getDouble("QT19_VALOR_TRANSPORTE"),
                    rs.getDouble("QT19_VALOR_IPTU_ANUAL"),
                    rs.getDouble("QT19_VALOR_ALUGUEL"),
                    rs.getDouble("QT19_VALOR_PENSAO"),
                    rs.getDouble("QT19_VALOR_OUTROS"),
                    rs.getDouble("QT20_VALOR_AGUA"),
                    rs.getDouble("QT20_VALOR_LUZ"),
                    rs.getDouble("QT20_VALOR_TELEFONE"),
                    rs.getDouble("QT20_VALOR_CONDOMINIO"),
                    rs.getDouble("QT20_VALOR_ALUGUEL"),
                    rs.getDouble("QT20_VALOR_IPTU_ANUAL"),
                    rs.getString("QT21_ESCLARECIMENTOS"));
            formulario.setCodAluno(rs.getInt("ALUNO_MATRICULA"));
            formulario.setCodSelecao(rs.getInt("SELECAO_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return formulario;
    }
    
    public static void gravar(Formulario formulario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into formulario (FORMULARIO_ID, ALUNO_MATRICULA, SELECAO_ID, QT01_RESPOSTA, "
                    + "QT01_NOME, QT01_PARENTESCO, QT01_PROGRAMA, QT01_ANO, QT02_ALIMENTACAO, QT02_MANUTENCAO, QT02_MORADIA, QT02_TRANSPORTE, QT02_OUTRO, "
                    + "QT03_TRANSPORTE, QT03_TEMPO, QT03_VALOR_GASTO_DIARIO, QT03_VALOR_GASTO_MENSAL, "
                    + "QT03_OUTRO, QT04_INSTITUICAO_ENSINO_FUNDAMENTAL, QT05_INSTITUICAO_ENSINO_MEDIO, "
                    + "QT06_ATIVIDADE_REMUNERADA, QT06_VALOR_BOLSA_ESTAGIO, QT06_PROJETO_INICIACAO, "
                    + "QT06_VALOR_BOLSA_INICIACAO, QT06_PROJETO_TREINAMENTO, QT06_VALOR_BOLSA_TREINAMENTO, "
                    + "QT06_OUTRO, QT06_VALOR_BOLSA_OUTRO, QT07_TRABALHO_REMUNERADO, QT07_HORAS_SEMANAIS, "
                    + "QT07_SALARIO, QT08_MANUTENCAO, QT08_OUTRO, QT09_MORADIA, QT09_OUTRO, QT10_RESPONSAVEL_FINANCEIRO, "
                    + "QT10_OUTRO, QT11_ESGOTO, QT11_AGUA_TRATADA, QT11_ILUMINACAO, QT11_COLETA_LIXO, QT11_RUA_PAVIMENTADA, "
                    + "QT12_RESIDENCIA, QT12_OUTRO, QT13_IMOVEL, QT13_VALOR_ALUGUEL, QT13_VALOR_PRESTACAO, "
                    + "QT13_NOME, QT13_OUTRO, QT14_ACABAMENTO, QT15_OUTROS_IMOVEIS, QT15_DESCRICAO_IMOVEIS, QT16_QUANTIDADE_CARRO, "
                    + "QT16_QUANTIDADE_TELEVISAO, QT16_QUANTIDADE_MAQUINA_LAVAR, QT16_QUANTIDADE_GELADEIRA, "
                    + "QT16_QUANTIDADE_TV_CABO, QT16_QUANTIDADE_COMPUTADOR, QT16_QUANTIDADE_INTERNET, "
                    + "QT16_QUANTIDADE_EMPREGADA_MENSALISTA, QT16_QUANTIDADE_EMPREGADA_DIARISTA, QT16_QUANTIDADE_BANHEIRO, "
                    + "QT16_QUANTIDADE_QUARTO, QT17_PROBLEMA_SAUDE, QT18_ALUGUEL_IMOVEIS, QT18_PENSAO_MORTE, "
                    + "QT18_PENSAO_ALIMENTICIA, QT18_AJUDA_TERCEIROS, QT18_BENEFICIOS_SOCIAIS, QT18_OUTRA_RENDA, QT18_NOME_OUTRA_RENDA, "
                    + "QT18_TOTAL_RENDA, QT18_NUMERO_RESIDENTES, QT19_VALOR_AGUA, QT19_VALOR_LUZ, QT19_VALOR_TELEFONE, QT19_VALOR_CONDOMINIO, "
                    + "QT19_VALOR_MENSALIDADE_ESCOLAR, QT19_VALOR_ALIMENTACAO, QT19_VALOR_SAUDE, QT19_VALOR_TRANSPORTE, "
                    + "QT19_VALOR_IPTU_ANUAL, QT19_VALOR_ALUGUEL, QT19_VALOR_PENSAO, QT19_VALOR_OUTROS, QT20_VALOR_AGUA, "
                    + "QT20_VALOR_LUZ, QT20_VALOR_TELEFONE, QT20_VALOR_CONDOMINIO, QT20_VALOR_ALUGUEL, QT20_VALOR_IPTU_ANUAL, "
                    + "QT21_ESCLARECIMENTOS) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, formulario.getCodFormulario());
            if (formulario.getAluno()== null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setInt(2, formulario.getCodAluno());
            }
            if (formulario.getSelecao()== null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setInt(3, formulario.getCodSelecao());
            }
            comando.setString(4, formulario.getQt01_Resposta());
            comando.setString(5, formulario.getQt01_Nome());
            comando.setString(6, formulario.getQt01_Parentesco());
            comando.setString(7, formulario.getQt01_Programa());
            comando.setString(8, formulario.getQt01_Ano());
            comando.setString(9, formulario.getQt02_Alimentacao());
            comando.setString(10, formulario.getQt02_Manutencao());
            comando.setString(11, formulario.getQt02_Moradia());
            comando.setString(12, formulario.getQt02_Transporte());
            comando.setString(13, formulario.getQt02_Outro());
            comando.setString(14, formulario.getQt03_Transporte());
            comando.setString(15, formulario.getQt03_Tempo());
            comando.setString(16, formulario.getQt03_ValorGastoDiario());
            comando.setString(17, formulario.getQt03_ValorGastoMensal());
            comando.setString(18, formulario.getQt03_Outro());
            comando.setString(19, formulario.getQt04_InstituicaoEnsinoFundamental());
            comando.setString(20, formulario.getQt05_InstituicaoEnsinoMedio());
            comando.setString(21, formulario.getQt06_AtividadeRemunerada());
            comando.setString(22, formulario.getQt06_ValorBolsaEstagio());
            comando.setString(23, formulario.getQt06_ProjetoIniciacao());
            comando.setString(24, formulario.getQt06_ValorBolsaIniciacao());
            comando.setString(25, formulario.getQt06_ProjetoTreinamento());
            comando.setString(26, formulario.getQt06_ValorBolsaTreinamento());
            comando.setString(27, formulario.getQt06_Outro());
            comando.setString(28, formulario.getQt06_ValorBolsaOutro());
            comando.setString(29, formulario.getQt07_TrabalhoRemunerado());
            comando.setString(30, formulario.getQt07_HorasSemanais());
            comando.setString(31, formulario.getQt07_Salario());
            comando.setString(32, formulario.getQt08_Manutencao());
            comando.setString(33, formulario.getQt08_Outra());
            comando.setString(34, formulario.getQt09_Moradia());
            comando.setString(35, formulario.getQt09_Outra());
            comando.setString(36, formulario.getQt10_ResponsavelFinanceiro());
            comando.setString(37, formulario.getQt10_Outros());
            comando.setString(38, formulario.getQt11_Esgoto());
            comando.setString(39, formulario.getQt11_Agua());
            comando.setString(40, formulario.getQt11_Iluminacao());
            comando.setString(41, formulario.getQt11_Lixo());
            comando.setString(42, formulario.getQt11_Pavimentacao());
            comando.setString(43, formulario.getQt12_Residencia());
            comando.setString(44, formulario.getQt12_Outro());
            comando.setString(45, formulario.getQt13_Imovel());
            comando.setString(46, formulario.getQt13_ValorAluguel());
            comando.setString(47, formulario.getQt13_ValorPrestacao());
            comando.setString(48, formulario.getQt13_Nome());
            comando.setString(49, formulario.getQt13_Outro());
            comando.setString(50, formulario.getQt14_Acabamento());
            comando.setString(51, formulario.getQt15_OutrosImoveis());
            comando.setString(52, formulario.getQt15_DescricaoImoveis());
            comando.setInt(53, formulario.getQt16_QuantCarro());
            comando.setInt(54, formulario.getQt16_QuantTV());
            comando.setInt(55, formulario.getQt16_QuantMaqLavar());
            comando.setInt(56, formulario.getQt16_QuantGeladeira());
            comando.setInt(57, formulario.getQt16_QuantTVCabo());
            comando.setInt(58, formulario.getQt16_QuantComputador());
            comando.setInt(59, formulario.getQt16_QuantInternetPaga());
            comando.setInt(60, formulario.getQt16_QuantEmpregadaMensalista());
            comando.setInt(61, formulario.getQt16_QuantEmpregadaDiarista());
            comando.setInt(62, formulario.getQt16_QuantBanheiro());
            comando.setInt(63, formulario.getQt16_QuantQuarto());
            comando.setString(64, formulario.getQt17_ProblemaSaude());
            comando.setDouble(65, formulario.getQt18_AluguelImoveis());
            comando.setDouble(66, formulario.getQt18_PensaoMorte());
            comando.setDouble(67, formulario.getQt18_PensaoAlimenticia());
            comando.setDouble(68, formulario.getQt18_AjudaTerceiros());
            comando.setDouble(69, formulario.getQt18_BeneficiosSociais());
            comando.setDouble(70, formulario.getQt18_OutraRenda());
            comando.setString(71, formulario.getQt18_NomeOutraRenda());
            comando.setDouble(72, formulario.getQt18_TotalRenda());
            comando.setInt(73, formulario.getQt18_NumeroResidentes());
            comando.setDouble(74, formulario.getQt19_ValorAgua());
            comando.setDouble(75, formulario.getQt19_ValorLuz());
            comando.setDouble(76, formulario.getQt19_ValorTelefone());
            comando.setDouble(77, formulario.getQt19_ValorCondominio());
            comando.setDouble(78, formulario.getQt19_ValorMensalidadeEscolar());
            comando.setDouble(79, formulario.getQt19_ValorAlimentacao());
            comando.setDouble(80, formulario.getQt19_ValorSaude());
            comando.setDouble(81, formulario.getQt19_ValorTransporte());
            comando.setDouble(82, formulario.getQt19_ValorIptuAnual());
            comando.setDouble(83, formulario.getQt19_ValorAluguel());
            comando.setDouble(84, formulario.getQt19_ValorPensao());
            comando.setDouble(85, formulario.getQt19_ValorOutros());
            comando.setDouble(86, formulario.getQt20_ValorAgua());
            comando.setDouble(87, formulario.getQt20_ValorLuz());
            comando.setDouble(88, formulario.getQt20_ValorTelefone());
            comando.setDouble(89, formulario.getQt20_ValorCondominio());
            comando.setDouble(90, formulario.getQt20_ValorAluguel());
            comando.setDouble(91, formulario.getQt20_ValorIptuAnual());
            comando.setString(92, formulario.getQt21_Esclarecimentos());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void alterar(Formulario formulario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update formulario set ALUNO_MATRICULA = ?, SELECAO_ID = ?, QT01_RESPOSTA = ?, QT01_NOME = ?, QT01_PARENTESCO = ?, QT01_PROGRAMA = ?, QT01_ANO = ?, "
                    + "QT02_ALIMENTACAO = ?, QT02_MANUTENCAO = ?, QT02_MORADIA = ?, QT02_TRANSPORTE = ?, QT02_OUTRO = ?, "
                    + "QT03_TRANSPORTE = ?, QT03_TEMPO = ?, QT03_VALOR_GASTO_DIARIO = ?, QT03_VALOR_GASTO_MENSAL = ?, "
                    + "QT03_OUTRO = ?, QT04_INSTITUICAO_ENSINO_FUNDAMENTAL = ?, QT05_INSTITUICAO_ENSINO_MEDIO = ?, "
                    + "QT06_ATIVIDADE_REMUNERADA = ?, QT06_VALOR_BOLSA_ESTAGIO = ?, QT06_PROJETO_INICIACAO = ?, "
                    + "QT06_VALOR_BOLSA_INICIACAO = ?, QT06_PROJETO_TREINAMENTO = ?, QT06_VALOR_BOLSA_TREINAMENTO = ?, "
                    + "QT06_OUTRO = ?, QT06_VALOR_BOLSA_OUTRO = ?, QT07_TRABALHO_REMUNERADO = ?, QT07_HORAS_SEMANAIS = ?, "
                    + "QT07_SALARIO = ?, QT08_MANUTENCAO = ?, QT08_OUTRO = ?, QT09_MORADIA = ?, QT09_OUTRO = ?, QT10_RESPONSAVEL_FINANCEIRO = ?, "
                    + "QT10_OUTRO = ?, QT11_ESGOTO = ?, QT11_AGUA_TRATADA = ?, QT11_ILUMINACAO = ?, QT11_COLETA_LIXO = ?, QT11_RUA_PAVIMENTADA = ?, "
                    + "QT12_RESIDENCIA = ?, QT12_OUTRO = ?, QT13_IMOVEL = ?, QT13_VALOR_ALUGUEL = ?, QT13_VALOR_PRESTACAO = ?, "
                    + "QT13_NOME = ?, QT13_OUTRO = ?, QT14_ACABAMENTO = ?, QT15_OUTROS_IMOVEIS = ?, QT15_DESCRICAO_IMOVEIS = ?, QT16_QUANTIDADE_CARRO = ?, "
                    + "QT16_QUANTIDADE_TELEVISAO = ?, QT16_QUANTIDADE_MAQUINA_LAVAR = ?, QT16_QUANTIDADE_GELADEIRA = ?, "
                    + "QT16_QUANTIDADE_TV_CABO = ?, QT16_QUANTIDADE_COMPUTADOR = ?, QT16_QUANTIDADE_INTERNET = ?, "
                    + "QT16_QUANTIDADE_EMPREGADA_MENSALISTA = ?, QT16_QUANTIDADE_EMPREGADA_DIARISTA = ?, QT16_QUANTIDADE_BANHEIRO = ?, "
                    + "QT16_QUANTIDADE_QUARTO = ?, QT17_PROBLEMA_SAUDE = ?, QT18_ALUGUEL_IMOVEIS = ?, QT18_PENSAO_MORTE = ?, "
                    + "QT18_PENSAO_ALIMENTICIA = ?, QT18_AJUDA_TERCEIROS = ?, QT18_BENEFICIOS_SOCIAIS = ?, QT18_OUTRA_RENDA = ?, QT18_NOME_OUTRA_RENDA = ?, QT18_TOTAL_RENDA = ?, "
                    + "QT18_NUMERO_RESIDENTES = ?, QT19_VALOR_AGUA = ?, QT19_VALOR_LUZ = ?, QT19_VALOR_TELEFONE = ?, QT19_VALOR_CONDOMINIO = ?, "
                    + "QT19_VALOR_MENSALIDADE_ESCOLAR = ?, QT19_VALOR_ALIMENTACAO = ?, QT19_VALOR_SAUDE = ?, QT19_VALOR_TRANSPORTE = ?, "
                    + "QT19_VALOR_IPTU_ANUAL = ?, QT19_VALOR_ALUGUEL = ?, QT19_VALOR_PENSAO = ?, QT19_VALOR_OUTROS = ?, QT20_VALOR_AGUA = ?, "
                    + "QT20_VALOR_LUZ = ?, QT20_VALOR_TELEFONE = ?, QT20_VALOR_CONDOMINIO = ?, QT20_VALOR_ALUGUEL = ?, QT20_VALOR_IPTU_ANUAL = ?, "
                    + "QT21_ESCLARECIMENTOS = ? where FORMULARIO_ID = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            if (formulario.getAluno()== null){
                comando.setNull(1, Types.NULL);
            }else{
                comando.setInt(1, formulario.getCodAluno());
            }
            if (formulario.getSelecao()== null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setInt(2, formulario.getCodSelecao());
            }
            comando.setString(3, formulario.getQt01_Resposta());
            comando.setString(4, formulario.getQt01_Nome());
            comando.setString(5, formulario.getQt01_Parentesco());
            comando.setString(6, formulario.getQt01_Programa());
            comando.setString(7, formulario.getQt01_Ano());
            comando.setString(8, formulario.getQt02_Alimentacao());
            comando.setString(9, formulario.getQt02_Manutencao());
            comando.setString(10, formulario.getQt02_Moradia());
            comando.setString(11, formulario.getQt02_Transporte());
            comando.setString(12, formulario.getQt02_Outro());
            comando.setString(13, formulario.getQt03_Transporte());
            comando.setString(14, formulario.getQt03_Tempo());
            comando.setString(15, formulario.getQt03_ValorGastoDiario());
            comando.setString(16, formulario.getQt03_ValorGastoMensal());
            comando.setString(17, formulario.getQt03_Outro());
            comando.setString(18, formulario.getQt04_InstituicaoEnsinoFundamental());
            comando.setString(19, formulario.getQt05_InstituicaoEnsinoMedio());
            comando.setString(20, formulario.getQt06_AtividadeRemunerada());
            comando.setString(21, formulario.getQt06_ValorBolsaEstagio());
            comando.setString(22, formulario.getQt06_ProjetoIniciacao());
            comando.setString(23, formulario.getQt06_ValorBolsaIniciacao());
            comando.setString(24, formulario.getQt06_ProjetoTreinamento());
            comando.setString(25, formulario.getQt06_ValorBolsaTreinamento());
            comando.setString(26, formulario.getQt06_Outro());
            comando.setString(27, formulario.getQt06_ValorBolsaOutro());
            comando.setString(28, formulario.getQt07_TrabalhoRemunerado());
            comando.setString(29, formulario.getQt07_HorasSemanais());
            comando.setString(30, formulario.getQt07_Salario());
            comando.setString(31, formulario.getQt08_Manutencao());
            comando.setString(32, formulario.getQt08_Outra());
            comando.setString(33, formulario.getQt09_Moradia());
            comando.setString(34, formulario.getQt09_Outra());
            comando.setString(35, formulario.getQt10_ResponsavelFinanceiro());
            comando.setString(36, formulario.getQt10_Outros());
            comando.setString(37, formulario.getQt11_Esgoto());
            comando.setString(38, formulario.getQt11_Agua());
            comando.setString(39, formulario.getQt11_Iluminacao());
            comando.setString(40, formulario.getQt11_Lixo());
            comando.setString(41, formulario.getQt11_Pavimentacao());
            comando.setString(42, formulario.getQt12_Residencia());
            comando.setString(43, formulario.getQt12_Outro());
            comando.setString(44, formulario.getQt13_Imovel());
            comando.setString(45, formulario.getQt13_ValorAluguel());
            comando.setString(46, formulario.getQt13_ValorPrestacao());
            comando.setString(47, formulario.getQt13_Nome());
            comando.setString(48, formulario.getQt13_Outro());
            comando.setString(49, formulario.getQt14_Acabamento());
            comando.setString(50, formulario.getQt15_OutrosImoveis());
            comando.setString(51, formulario.getQt15_DescricaoImoveis());
            comando.setInt(52, formulario.getQt16_QuantCarro());
            comando.setInt(53, formulario.getQt16_QuantTV());
            comando.setInt(54, formulario.getQt16_QuantMaqLavar());
            comando.setInt(55, formulario.getQt16_QuantGeladeira());
            comando.setInt(56, formulario.getQt16_QuantTVCabo());
            comando.setInt(57, formulario.getQt16_QuantComputador());
            comando.setInt(58, formulario.getQt16_QuantInternetPaga());
            comando.setInt(59, formulario.getQt16_QuantEmpregadaMensalista());
            comando.setInt(60, formulario.getQt16_QuantEmpregadaDiarista());
            comando.setInt(61, formulario.getQt16_QuantBanheiro());
            comando.setInt(62, formulario.getQt16_QuantQuarto());
            comando.setString(63, formulario.getQt17_ProblemaSaude());
            comando.setDouble(64, formulario.getQt18_AluguelImoveis());
            comando.setDouble(65, formulario.getQt18_PensaoMorte());
            comando.setDouble(66, formulario.getQt18_PensaoAlimenticia());
            comando.setDouble(67, formulario.getQt18_AjudaTerceiros());
            comando.setDouble(68, formulario.getQt18_BeneficiosSociais());
            comando.setDouble(69, formulario.getQt18_OutraRenda());
            comando.setString(70, formulario.getQt18_NomeOutraRenda());
            comando.setDouble(71, formulario.getQt18_TotalRenda());
            comando.setInt(72, formulario.getQt18_NumeroResidentes());
            comando.setDouble(73, formulario.getQt19_ValorAgua());
            comando.setDouble(74, formulario.getQt19_ValorLuz());
            comando.setDouble(75, formulario.getQt19_ValorTelefone());
            comando.setDouble(76, formulario.getQt19_ValorCondominio());
            comando.setDouble(77, formulario.getQt19_ValorMensalidadeEscolar());
            comando.setDouble(78, formulario.getQt19_ValorAlimentacao());
            comando.setDouble(79, formulario.getQt19_ValorSaude());
            comando.setDouble(80, formulario.getQt19_ValorTransporte());
            comando.setDouble(81, formulario.getQt19_ValorIptuAnual());
            comando.setDouble(82, formulario.getQt19_ValorAluguel());
            comando.setDouble(83, formulario.getQt19_ValorPensao());
            comando.setDouble(84, formulario.getQt19_ValorOutros());
            comando.setDouble(85, formulario.getQt20_ValorAgua());
            comando.setDouble(86, formulario.getQt20_ValorLuz());
            comando.setDouble(87, formulario.getQt20_ValorTelefone());
            comando.setDouble(88, formulario.getQt20_ValorCondominio());
            comando.setDouble(89, formulario.getQt20_ValorAluguel());
            comando.setDouble(90, formulario.getQt20_ValorIptuAnual());
            comando.setString(91, formulario.getQt21_Esclarecimentos());
            comando.setInt(92, formulario.getCodFormulario());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static void excluir(Formulario formulario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from FORMULARIO where FORMULARIO_ID = " + formulario.getCodFormulario();
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
