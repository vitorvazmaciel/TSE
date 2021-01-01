import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

import java.io.IOException;
import org.json.JSONException;

import org.json.JSONObject; 
import org.json.JSONArray;

import java.util.Scanner;
import java.sql.*;
 
public class Script
{
	public static void main(String[] args) 
    {
    	
    	Connection connection = null;

    	try {

    		Class.forName("org.postgresql.Driver");

    		Scanner tc = new Scanner(System.in);

    		System.out.print("Database url: ");
    		String url = tc.nextLine();

    		System.out.print("User: ");
    		String user = tc.nextLine();

    		System.out.print("Password: ");
       		String password = tc.nextLine();

    		connection = DriverManager.getConnection(url, user, password);
    		
    		try {

					File f = new File("");
					String [] nomes = f.list();

    				for(String s : nomes) {
		        	
		        		String file = ""+s;
			        	JSONObject obj = new JSONObject(readFileAsString(file));

						Long id = Long.parseLong(obj.get("id").toString());
			        	String nomeUrna = obj.get("nomeUrna").toString();
			        	Integer numero = Integer.parseInt(obj.get("numero").toString());
			        	Integer idCandidatoSuperior = Integer.parseInt(obj.get("idCandidatoSuperior").toString());
			        	String nomeCompleto = obj.get("nomeCompleto").toString();
			        	String descricaoSexo = obj.get("descricaoSexo").toString();
			        	String dataDeNascimento = obj.get("dataDeNascimento").toString();
			        	String tituloEleitor = obj.get("tituloEleitor").toString();
			        	String cpf = obj.get("cpf").toString();
						String descricaoEstadoCivil = obj.get("descricaoEstadoCivil").toString();;
			        	String descricaoCorRaca = obj.get("descricaoCorRaca").toString();
			        	String descricaoSituacao = obj.get("descricaoSituacao").toString();
			        	String nacionalidade = obj.get("nacionalidade").toString();
			        	String grauInstrucao = obj.get("grauInstrucao").toString();
			        	String ocupacao = obj.get("ocupacao").toString();
			        	String gastoCampanha1T = obj.get("gastoCampanha1T").toString();
			        	String gastoCampanha2T = obj.get("gastoCampanha2T").toString();
			        	String sgUfNascimento = obj.get("sgUfNascimento").toString();
						String nomeMunicipioNascimento = obj.get("nomeMunicipioNascimento").toString();
			        	String localCandidatura = obj.get("localCandidatura").toString();
			        	String ufCandidatura = obj.get("ufCandidatura").toString();
			        	String ufSuperiorCandidatura = obj.get("ufSuperiorCandidatura").toString();
			        	String dataUltimaAtualizacao = obj.get("dataUltimaAtualizacao").toString();
			        	String fotoUrl = obj.get("fotoUrl").toString();
			        	String fotoDataUltimaAtualizacao = obj.get("fotoDataUltimaAtualizacao").toString();
			    		String descricaoTotalizacao = obj.get("descricaoTotalizacao").toString();
			        	String nomeColigacao = obj.get("nomeColigacao").toString();
			        	String composicaoColigacao = obj.get("composicaoColigacao").toString();
			        	String numeroProcessoDrap = obj.get("numeroProcessoDrap").toString();
			        	String numeroProcessoDrapEncrypt = obj.get("numeroProcessoDrapEncrypt").toString();
			        	String numeroProcesso = obj.get("numeroProcesso").toString();
			        	String numeroProcessoEncrypt = obj.get("numeroProcessoEncrypt").toString();
			        	String numeroProcessoPrestContas = obj.get("numeroProcessoPrestContas").toString();
			        	String numeroProcessoPrestContasEncrypt = obj.get("numeroProcessoPrestContasEncrypt").toString();
			        	String numeroProtocolo = obj.get("numeroProtocolo").toString();
						Double totalDeBens = Double.parseDouble((obj.get("totalDeBens").toString()));
			        	String substituto = obj.get("substituto").toString();
			        	String motivos = obj.get("motivos").toString();
						Integer codigoSituacaoCandidato = Integer.parseInt(obj.get("codigoSituacaoCandidato").toString());
			        	String descricaoSituacaoCandidato = obj.get("descricaoSituacaoCandidato").toString();
			        	Boolean st_SUBSTITUIDO = Boolean.parseBoolean(obj.get("st_SUBSTITUIDO").toString());
			        	String descricaoNaturalidade = obj.get("descricaoNaturalidade").toString();
			        	Boolean st_MOTIVO_AUSENCIA_REQUISITO = Boolean.parseBoolean(obj.get("st_MOTIVO_AUSENCIA_REQUISITO").toString());
			        	Boolean st_MOTIVO_CONDUTA_VEDADA = Boolean.parseBoolean(obj.get("st_MOTIVO_CONDUTA_VEDADA").toString());
			        	String cnpjcampanha = obj.get("cnpjcampanha").toString();
			        	Double gastoCampanha = Double.parseDouble((obj.get("gastoCampanha").toString()));
			        	Boolean st_MOTIVO_ABUSO_PODER = Boolean.parseBoolean(obj.get("st_MOTIVO_ABUSO_PODER").toString());
			        	Boolean st_MOTIVO_COMPRA_VOTO = Boolean.parseBoolean(obj.get("st_MOTIVO_COMPRA_VOTO").toString());
			        	String ds_MOTIVO_OUTROS = obj.get("ds_MOTIVO_OUTROS").toString();
						Boolean st_MOTIVO_GASTO_ILICITO = Boolean.parseBoolean(obj.get("st_MOTIVO_GASTO_ILICITO").toString());
			        	Boolean st_MOTIVO_IND_PARTIDO = Boolean.parseBoolean(obj.get("st_MOTIVO_IND_PARTIDO").toString());
			        	Boolean st_MOTIVO_FICHA_LIMPA = Boolean.parseBoolean(obj.get("st_MOTIVO_FICHA_LIMPA").toString());
			        	Boolean st_DIVULGA_ARQUIVOS = Boolean.parseBoolean(obj.get("st_DIVULGA_ARQUIVOS").toString());
			        	Boolean st_DIVULGA_BENS = Boolean.parseBoolean(obj.get("st_DIVULGA_BENS").toString());
			        	Boolean st_DIVULGA = Boolean.parseBoolean(obj.get("st_DIVULGA").toString());
			        	Boolean st_REELEICAO = Boolean.parseBoolean(obj.get("st_REELEICAO").toString());

			        	JSONObject cargo = obj.getJSONObject("cargo");
			        		Integer codigoCargo = Integer.parseInt(cargo.get("codigo").toString());
				        	String siglaCargo = cargo.get("sigla").toString();
				        	String nomeCargo = cargo.get("nome").toString();
				        	Integer codSuperiorCargo = Integer.parseInt(cargo.get("codSuperior").toString());
				        	Boolean titularCargo = Boolean.parseBoolean(cargo.get("titular").toString());
				        	Integer contagemCargo = Integer.parseInt(cargo.get("contagem").toString());

				        JSONObject partido = obj.getJSONObject("partido");
				        	Integer numeroPartido = Integer.parseInt(partido.get("numero").toString());
				        	String siglaPartido = partido.get("sigla").toString();
				        	String nomePartido = partido.get("nome").toString();

				        JSONObject eleicao = obj.getJSONObject("eleicao");
				        	Long idEleicao = Long.parseLong(eleicao.get("id").toString());
				        	String siglaUfEleicao = eleicao.get("siglaUF").toString();
				        	String localidadeSgUeEleicao = eleicao.get("localidadeSgUe").toString();
				        	Integer anoEleicao = Integer.parseInt(eleicao.get("ano").toString());
							String codigoEleicao = eleicao.get("codigo").toString();
				        	String nomeEleicao = eleicao.get("nomeEleicao").toString();
				        	String tipoEleicao = eleicao.get("tipoEleicao").toString();
				        	String turnoEleicao = eleicao.get("turno").toString();
				        	String tipoAbrangenciaEleicao = eleicao.get("tipoAbrangencia").toString();
				        	String dataEleicao = eleicao.get("dataEleicao").toString();
				        	String codSituacaoEleicao = eleicao.get("codSituacaoEleicao").toString();
				        	String descricaoSituacaoEleicao = eleicao.get("descricaoSituacaoEleicao").toString();
				        	String descricaoEleicao = eleicao.get("descricaoEleicao").toString();

			        	PreparedStatement st = connection.prepareStatement("INSERT INTO CANDIDATO (ID, NOME_URNA, NUMERO, ID_CANDIDATO_SUPERIOR, NOME_COMPLETO, DESCRICAO_SEXO, "+
			        						 	     					   "DATA_DE_NASCIMENTO, TITULO_ELEITOR, CPF, DESCRICAO_ESTADO_CIVIL, DESCRICAO_COR_RACA, "+
								        								   "DESCRICAO_SITUACAO, NACIONALIDADE, GRAU_INSTRUCAO, OCUPACAO, GASTO_CAMPANHA1T, GASTO_CAMPANHA2T, "+
								        								   "SG_UF_NASCIMENTO, NOME_MUNICIPIO_NASCIMENTO, LOCAL_CANDIDATURA, UF_CANDIDATURA, UF_SUPERIOR_CANDIDATURA, "+
								        								   "DATA_ULTIMA_ATUALIZACAO, FOTO_URL, FOTO_DATA_ULTIMA_ATUALIZACAO, DESCRICAO_TOTALIZACAO, NOME_COLIGACAO, "+
								        							       "COMPOSICAO_COLIGACAO, NUMERO_PROCESSO_DRAP, NUMERO_PROCESSO_DRAP_ENCRYPT, NUMERO_PROCESSO, NUMERO_PROCESSO_ENCRYPT, "+
								        							       "NUMERO_PROCESSO_PREST_CONTAS, NUMERO_PROCESSO_PREST_CONTAS_ENCRYPT, NUMERO_PROTOCOLO, TOTAL_DE_BENS, SUBSTITUTO, "+
								        							       "MOTIVOS, CODIGO_SITUACAO_CANDIDATO, DESCRICAO_SITUACAO_CANDIDATO, ST_SUBSTITUIDO, DESCRICAO_NATURALIDADE, ST_MOTIVO_AUSENCIA_REQUISITO, "+
								        							       "ST_MOTIVO_CONDUTA_VEDADA, CNPJ_CAMPANHA, GASTO_CAMPANHA, ST_MOTIVO_ABUSO_PODER, ST_MOTIVO_COMPRA_VOTO, DS_MOTIVO_OUTROS, "+
								        								   "ST_MOTIVO_GASTO_ILICITO, ST_MOTIVO_IND_PARTIDO, ST_MOTIVO_FICHA_LIMPA, ST_DIVULGA_ARQUIVOS, ST_DIVULGA_BENS, ST_DIVULGA, ST_REELEICAO, "+
								        								   "CODIGO_CARGO, SIGLA_CARGO, NOME_CARGO, COD_SUPERIOR_CARGO, TITULAR_CARGO, CONTAGEM_CARGO, NUMERO_PARTIDO, "+
								        								   "SIGLA_PARTIDO, NOME_PARTIDO, ID_ELEICAO, SIGLA_UF_ELEICAO, LOCALIDADE_SG_UE_ELEICAO,"+
								        								   "ANO_ELEICAO, CODIGO_ELEICAO, NOME_ELEICAO, TIPO_ELEICAO, TURNO_ELEICAO, TIPO_ABRANGENCIA_ELEICAO,  "+
								        								   "DATA_ELEICAO, COD_SITUACAO_ELEICAO, DESCRICAO_SITUACAO_ELEICAO, DESCRICAO_ELEICAO"+
																		   ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "+
								        								   "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
						st.setLong(1, id);
						st.setString(2, nomeUrna);
						st.setInt(3, numero);
						st.setInt(4, idCandidatoSuperior);
						st.setString(5, nomeCompleto);
						st.setString(6, descricaoSexo);
						st.setString(7, dataDeNascimento);
						st.setString(8, tituloEleitor);
						st.setString(9, cpf);
						st.setString(10, descricaoEstadoCivil);
						st.setString(11, descricaoCorRaca);
						st.setString(12, descricaoSituacao);
						st.setString(13, nacionalidade);
						st.setString(14, grauInstrucao);
						st.setString(15, ocupacao);
						st.setString(16, gastoCampanha1T);
						st.setString(17, gastoCampanha2T);
						st.setString(18, sgUfNascimento);
						st.setString(19, nomeMunicipioNascimento);
						st.setString(20, localCandidatura);
						st.setString(21, ufCandidatura);
						st.setString(22, ufSuperiorCandidatura);
						st.setString(23, dataUltimaAtualizacao);
						st.setString(24, fotoUrl);
						st.setString(25, fotoDataUltimaAtualizacao);
						st.setString(26, descricaoTotalizacao);
						st.setString(27, nomeColigacao);
						st.setString(28, composicaoColigacao);
						st.setString(29, numeroProcessoDrap);
						st.setString(30, numeroProcessoDrapEncrypt);
						st.setString(31, numeroProcesso);
						st.setString(32, numeroProcessoEncrypt);
						st.setString(33, numeroProcessoPrestContas);
						st.setString(34, numeroProcessoPrestContasEncrypt);
						st.setString(35, numeroProtocolo);
						st.setDouble(36, totalDeBens);
						st.setString(37, substituto);
						st.setString(38, motivos);
						st.setInt(39, codigoSituacaoCandidato);
						st.setString(40, descricaoSituacaoCandidato);
						st.setBoolean(41, st_SUBSTITUIDO);
						st.setString(42, descricaoNaturalidade);
						st.setBoolean(43, st_MOTIVO_AUSENCIA_REQUISITO);
						st.setBoolean(44, st_MOTIVO_CONDUTA_VEDADA);
						st.setString(45, cnpjcampanha);
						st.setDouble(46, gastoCampanha);
						st.setBoolean(47, st_MOTIVO_ABUSO_PODER);
						st.setBoolean(48, st_MOTIVO_COMPRA_VOTO);
						st.setString(49, ds_MOTIVO_OUTROS);
						st.setBoolean(50, st_MOTIVO_GASTO_ILICITO);
						st.setBoolean(51, st_MOTIVO_IND_PARTIDO);
						st.setBoolean(52, st_MOTIVO_FICHA_LIMPA);
						st.setBoolean(53, st_DIVULGA_ARQUIVOS);
						st.setBoolean(54, st_DIVULGA_BENS);
						st.setBoolean(55, st_DIVULGA);
						st.setBoolean(56, st_REELEICAO);
						st.setInt(57, codigoCargo);
						st.setString(58,	siglaCargo);
						st.setString(59, nomeCargo);
						st.setInt(60, codSuperiorCargo);
						st.setBoolean(61, titularCargo);
						st.setInt(62, contagemCargo);
						st.setInt(63, numeroPartido);
						st.setString(64, siglaPartido);
						st.setString(65, nomePartido);
						st.setLong(66, idEleicao);
						st.setString(67, siglaUfEleicao);
						st.setString(68, localidadeSgUeEleicao);
						st.setInt(69, anoEleicao);
						st.setString(70, codigoEleicao);
						st.setString(71, nomeEleicao);
						st.setString(72, tipoEleicao);
						st.setString(73, turnoEleicao);
						st.setString(74, tipoAbrangenciaEleicao);
						st.setString(75, dataEleicao);
						st.setString(76, codSituacaoEleicao);
						st.setString(77, descricaoSituacaoEleicao);
						st.setString(78, descricaoEleicao);

						st.executeUpdate();

						if(obj.get("bens") instanceof JSONArray) {
							JSONArray bens = obj.getJSONArray("bens");
							for(int i = 0; i < bens.length(); i++) {
								JSONObject aux = bens.getJSONObject(i);
								st = connection.prepareStatement("INSERT INTO BEM(ORDEM, DESCRICAO, DESCRICAO_DE_TIPO_DE_BEM, "+
																 "VALOR, DATA_ULTIMA_ATUALIZACAO, ID) " +
																 "VALUES (?, ?, ?, ?, ?, ?)");
								st.setInt(1, Integer.parseInt(aux.get("ordem").toString()));
								st.setString(2, aux.get("descricao").toString());
								st.setString(3, aux.get("descricaoDeTipoDeBem").toString());
								st.setDouble(4, Double.parseDouble(aux.get("valor").toString()));
								st.setString(5, aux.get("dataUltimaAtualizacao").toString());
								st.setLong(6, id);
								st.executeUpdate();
							}
						}

						if(obj.get("vices") instanceof JSONArray) {
							JSONArray vices = obj.getJSONArray("vices");
							for(int i = 0; i < vices.length(); i++) {
								JSONObject aux = vices.getJSONObject(i);
								st = connection.prepareStatement("INSERT INTO VICE(NOME_COLIGACAO, COMPOSICAO_COLIGACAO, ST_REGISTRO, SITUACAO_CANDIDATO, "+
																 "URL_FOTO, SG_PARTIDO, NM_URNA, NM_CANDIDATO, SQ_ELEICAO, SQ_CANDIDATO_SUPERIOR, NR_CANDIDATO, " +
																 "DS_CARGO, NM_PARTIDO, SQ_CANDIDATO, SG_UE, DT_ULTIMA_ATUALIZACAO, ID " +
																 ")VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

								st.setString(1, aux.get("nomeColigacao").toString());
								st.setString(2, aux.get("composicaoColigacao").toString());
								st.setString(3, aux.get("stRegistro").toString());
								st.setString(4, aux.get("situacaoCandidato").toString());
								st.setString(5, aux.get("urlFoto").toString());
								st.setString(6, aux.get("sg_PARTIDO").toString());
								st.setString(7, aux.get("nm_URNA").toString());
								st.setString(8, aux.get("nm_CANDIDATO").toString());
								st.setLong(9, Long.parseLong(aux.get("sq_ELEICAO").toString()));
								st.setString(10, aux.get("sq_CANDIDATO_SUPERIOR").toString());
								st.setString(11, aux.get("nr_CANDIDATO").toString());	
								st.setString(12, aux.get("ds_CARGO").toString());
								st.setString(13, aux.get("nm_PARTIDO").toString());
								st.setLong(14, Long.parseLong(aux.get("sq_CANDIDATO").toString()));
								st.setString(15, aux.get("sg_UE").toString());
								st.setString(16, aux.get("dt_ULTIMA_ATUALIZACAO").toString());
								st.setLong(17, id);
								st.executeUpdate();
							}
						}

						if(obj.get("emails") instanceof JSONArray) {
							JSONArray emails = obj.getJSONArray("emails");
							for(int i = 0; i < emails.length(); i++) {
								st = connection.prepareStatement("INSERT INTO EMAIL(ENDERECO_EMAIL, ID) VALUES (?, ?)");
								st.setString(1, emails.get(i).toString());
								st.setLong(2, id);
								st.executeUpdate();
							}
						}

						if(obj.get("sites") instanceof JSONArray) {
				        	JSONArray sites = obj.getJSONArray("sites");
				        	for(int i = 0; i < sites.length(); i++) {
				        		st = connection.prepareStatement("INSERT INTO SITE(ENDERECO_SITE, ID) VALUES (?, ?)");
				        		st.setString(1, sites.get(i).toString());
				        		st.setLong(2, id);
				        		st.executeUpdate();
				        	}
				        }


				        if(obj.get("arquivos") instanceof JSONArray) {
				        	JSONArray arquivos = obj.getJSONArray("arquivos");
				        	for(int i = 0; i < arquivos.length(); i++) {
				        		JSONObject aux = arquivos.getJSONObject(i);
				        		st = connection.prepareStatement("INSERT INTO ARQUIVO(ID_ARQUIVO, NOME, URL, TIPO, COD_TIPO, "+
				        										 "FULL_FILE_PATH, FILE_INPUT_STREAM, FILE_BYTE_ARRAY, ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				        		st.setLong(1, Long.parseLong(aux.get("idArquivo").toString()));
				        		st.setString(2, aux.get("nome").toString());
				        		st.setString(3, aux.get("url").toString());
				        		st.setString(4, aux.get("tipo").toString());
				        		st.setString(5, aux.get("codTipo").toString());
				        		st.setString(6, aux.get("fullFilePath").toString());
				        		st.setString(7, aux.get("fileInputStream").toString());
				        		st.setString(8, aux.get("fileByteArray").toString());
				        		st.setLong(9, id);
				        		st.executeUpdate();
				        	}
				        }

				        if(obj.get("eleicoesAnteriores") instanceof JSONArray) {
							JSONArray eleicoesAnteriores = obj.getJSONArray("eleicoesAnteriores");
							for(int i = 0; i < eleicoesAnteriores.length(); i++) {
								JSONObject aux = eleicoesAnteriores.getJSONObject(i);
								st = connection.prepareStatement("INSERT INTO ELEICAO_ANTERIOR(NR_ANO, ID_ELEICAO_ANTERIOR, NOME_URNA, "+
																"NOME_CANDIDATO, ID_ELEICAO, SG_UE, LOCAL, CARGO, PARTIDO, SITUACAO_TOTALIZACAO, "+
																"TX_LINK, ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
								st.setInt(1, Integer.parseInt(aux.get("nrAno").toString()));
								st.setString(2, aux.get("id").toString());
								st.setString(3, aux.get("nomeUrna").toString());
								st.setString(4, aux.get("nomeCandidato").toString());
								st.setString(5, aux.get("idEleicao").toString());
								st.setString(6, aux.get("sgUe").toString());
								st.setString(7, aux.get("local").toString());
								st.setString(8, aux.get("cargo").toString());
								st.setString(9, aux.get("partido").toString());
								st.setString(10, aux.get("situacaoTotalizacao").toString());
								st.setString(11, aux.get("txLink").toString());
								st.setLong(12, id);
								st.executeUpdate();
							}
						}
			 			
			 			st.close();

		 			}
				
				} catch (IOException e) {
		        	e.printStackTrace();
		        }catch (JSONException e) {
		        	e.printStackTrace();
		        }

		    connection.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
	}  

	public static String readFileAsString(String file) throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
     
}
