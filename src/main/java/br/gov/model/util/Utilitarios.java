package br.gov.model.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

import br.gov.model.exception.ValorReferenciaInvalido;

public class Utilitarios {
    
    public static String DIA_MES_ANO = "dd/MM/yyyy";
    public static String MES_ANO     = "MM/yyyy";

    public static Integer obterDigitoVerificador(String codigoBarraCom43Posicoes, Short moduloVerificador) {
        Integer digitoVerificadorGeral = null;

        if (moduloVerificador.compareTo(ConstantesSistema.MODULO_VERIFICADOR_11) == 0) {
            digitoVerificadorGeral = obterDigitoVerificadorModulo11(codigoBarraCom43Posicoes);

        } else {
            digitoVerificadorGeral = obterDigitoVerificadorModulo10(codigoBarraCom43Posicoes);
        }

        return digitoVerificadorGeral;
    }

    public static Integer obterDigitoVerificadorModulo10(String codigo) {

        int sequencia = 2, contEntrada, digito, contAuxiliar, produto, contProduto, somaDigitosProduto = 0;
        
        contAuxiliar = 1;
        for (contEntrada = 0; contEntrada < codigo.length(); contEntrada++) {

            digito = new Integer(codigo.substring(codigo.length() - contAuxiliar, codigo.length() - contEntrada)).intValue();

            produto = digito * sequencia;
            String produtoString = String.valueOf(produto);

            for (contProduto = 0; contProduto < produtoString.length(); contProduto++) {
                somaDigitosProduto = somaDigitosProduto + new Integer(produtoString.substring(contProduto, contProduto + 1)).intValue();
            }

            if (sequencia == 2) {
                sequencia = 1;
            } else {
                sequencia = 2;
            }

            contAuxiliar++;
        }

        int resto = somaDigitosProduto % 10;

        int dac;
        if (resto == 0) {
            dac = 0;
        } else {
            dac = 10 - resto;
        }

        return new Integer(dac);
    }
    
    public static Integer obterDigitoVerificadorModulo10NOVO(String[] digitos) {

		int sequencia = 2, somaDigitosProduto = 0;
		
		for (int i = digitos.length - 1; i >= 0; i--) {
			int digito = Integer.valueOf(digitos[i]);
			int produto = digito * sequencia;
			
			String produtoString = String.valueOf(produto);
            for (int contProduto = 0; contProduto < produtoString.length(); contProduto++) {
                somaDigitosProduto = somaDigitosProduto + new Integer(produtoString.substring(contProduto, contProduto + 1)).intValue();
            }

            if (sequencia == 2) {
                sequencia = 1;
            } else {
                sequencia = 2;
            }
		}

        int resto = somaDigitosProduto % 10;

        int dac;
        if (resto == 0) {
            dac = 0;
        } else {
            dac = 10 - resto;
        }

        return new Integer(dac);
    }

    public static Integer obterDigitoVerificadorModulo11(String codigo) {

        int multiplicador = 2;
        int soma = 0;

        for (int contador = (codigo.length() - 1); contador >= 0; contador--) {
            if (multiplicador > 9) {
                multiplicador = 2;
            }
            
            soma += Integer.parseInt(codigo.substring(contador, contador + 1)) * multiplicador;
            multiplicador += 1;
        }

        int resto = soma % 11;
        
        int dac;
        if ((resto == 0) || (resto == 1)) {
            dac = 0;
        } else {
            dac = 11 - resto;
        }
        return dac;
    }

	public static String ordenarCamposConsulta(int tipoAgrupamento) {
		
		String [] campos = {"A.greg_id", "A.uneg_id", "A.muni_id", "A.loca_id", "B.unop_tipo, B.unop_id"};
		String ordem ="";
		for(int i = 0; i < tipoAgrupamento; i++) {
			ordem += campos[i] + ", ";
		}
		 
		ordem += "B.cons_data";
		return ordem;
	}
	
	public static String formatarBigDecimalComPonto(BigDecimal numero) {

		if (numero == null) {
			numero = new BigDecimal("0.00");
		}

		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		
		NumberFormat formato = new DecimalFormat("##0.00", symbols);
		formato.setMaximumFractionDigits(2);
		formato.setMinimumFractionDigits(2);
		formato.setGroupingUsed(false);

		return formato.format(numero);
	}
	
	public static String formatarAnoMesParaMesAno(int anoMes) {

		String anoMesFormatado = "";
		String anoMesRecebido = "" + anoMes;
		if (anoMesRecebido.length() < 6) {
			anoMesFormatado = anoMesRecebido;
		} else {
			String mes = anoMesRecebido.substring(4, 6);
			String ano = anoMesRecebido.substring(0, 4);
			anoMesFormatado = mes + "/" + ano;
		}
		return anoMesFormatado;
	}
	
	public static Integer representacaoNumericaCodigoBarrasModulo10(Integer numero) {
		int entrada = numero.intValue();

		String entradaString = String.valueOf(entrada);

		int sequencia = 2;
		int contEntrada, digito, contAuxiliar, produto, contProduto;
		String produtoString;
		int somaDigitosProduto = 0;

		contAuxiliar = 1;
		for (contEntrada = 0; contEntrada < entradaString.length(); contEntrada++) {
			digito = new Integer(entradaString.substring(entradaString.length() - contAuxiliar, entradaString.length() - contEntrada)).intValue();

			produto = digito * sequencia;
			produtoString = String.valueOf(produto);

			for (contProduto = 0; contProduto < produtoString.length(); contProduto++) {
				somaDigitosProduto = somaDigitosProduto + new Integer(produtoString.substring(contProduto, contProduto + 1)).intValue();
			}

			if (sequencia == 2) {
				sequencia = 1;
			} else {
				sequencia = 2;
			}

			contAuxiliar++;
		}

		int resto = (somaDigitosProduto % 10);
		int dac;

		if (resto == 0) {
			dac = 0;
		} else {
			dac = 10 - resto;
		}

		return new Integer(dac);
	}

	public static short obterUltimoDiaMes(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return (short) calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	private static Date adicionaCampoData(Date data, int campo, int qtd){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(campo, qtd);
		return calendar.getTime();
	}
	
	public static Date adicionarMeses(Date data, int meses) {
		return adicionaCampoData(data, Calendar.MONTH, meses);
	}
	
	public static Date adicionarMeses(Integer data, int meses) {
        if (String.valueOf(data).length() != 6){
            throw new ValorReferenciaInvalido();
        }
        
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.YEAR , extrairAno(data));
        cal.set(Calendar.MONTH, extrairMes(data) - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
	    
	    return adicionarMeses(cal.getTime(), meses);
	}
	
	public static int reduzirMeses(Integer data, int meses) {
	    Calendar cal = Calendar.getInstance();

	    cal.setTime(adicionarMeses(data, - meses));
	    
	    return Integer.valueOf(cal.get(Calendar.YEAR) + "" + completaComZerosEsquerda(2, cal.get(Calendar.MONTH) + 1));
	}
	
	public static Date reduzirDias(Date data, int dias) {
		return adicionarDias(data, - dias);
	}
	
	public static Date adicionarDias(Date data, int dias) {
		return adicionaCampoData(data, Calendar.DAY_OF_MONTH, dias);
	}
	
	public static Date adicionarDias(Integer data, int dias) {
        if (String.valueOf(data).length() != 6){
            throw new ValorReferenciaInvalido();
        }
        
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.YEAR , extrairAno(data));
        cal.set(Calendar.MONTH, extrairMes(data));
        cal.set(Calendar.DAY_OF_MONTH, extrairDia(data));
	    
	    return adicionarDias(cal.getTime(), dias);
	}
	
	public static Date atribuiDia(Date data, int dia) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		return calendar.getTime();
	}
	
	public static String completaComZerosEsquerda(int tamanhoCampo, Object campo) {
		return completaStringAEsquerda(tamanhoCampo, campo, '0');
	}
	
	public static String completaTexto(int tamanhoCampo, Object campo) {
		return completaStringAEsquerda(tamanhoCampo, campo, ' ');
	}
	
	public static String converteParaTexto(Object campo) {
	    return campo == null ? "" : String.valueOf(campo);
	}
		
	public static Date ano1900() {
		Calendar cal = Calendar.getInstance();
		cal.set(1900, 0, 1);
		return cal.getTime();
	}

	public static Date converteParaDataComUltimoDiaMes(Integer anoMesNumerico) {
		String anoMes = String.valueOf(anoMesNumerico);
		int ano = Integer.parseInt(anoMes.substring(0, 4));
		int mes = Integer.parseInt(anoMes.substring(4, 6));
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.MONTH, (mes - 1));
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		return cal.getTime();
	}
	
	public static Date converteParaDataComPrimeiroDiaMes(Integer anoMesNumerico) {
	    String anoMes = String.valueOf(anoMesNumerico);
	    int ano = Integer.parseInt(anoMes.substring(0, 4));
	    int mes = Integer.parseInt(anoMes.substring(4, 6));
	    Calendar cal = GregorianCalendar.getInstance();
	    cal.set(Calendar.YEAR, ano);
	    cal.set(Calendar.MONTH, (mes - 1));
	    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
	    
	    return cal.getTime();
	}
	
	public static int qtdDiasMes(Integer anoMesNumerico) {
	    String anoMes = String.valueOf(anoMesNumerico);
	    int ano = Integer.parseInt(anoMes.substring(0, 4));
	    int mes = Integer.parseInt(anoMes.substring(4, 6));
	    Calendar cal = GregorianCalendar.getInstance();
	    cal.set(Calendar.YEAR, ano);
	    cal.set(Calendar.MONTH, (mes - 1));
	    
	    return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static String formataData(Date data){
		return formataData(data, FormatoData.DIA_MES_ANO);
	}

    public static String formataData(Date data, FormatoData formato){
        SimpleDateFormat format = new SimpleDateFormat(formato.getFormato());
        return data != null ? format.format(data) : "";
    }

	public static Integer extrairAno(Integer anoMes) {
		return Integer.valueOf(String.valueOf(anoMes).substring(0,4));
	}
	
	public static Integer extrairMes(Integer anoMes) {
		return Integer.valueOf(String.valueOf(anoMes).substring(4,6));
	}
	
	public static Integer extrairDia(Integer anoMesDia) {
		return Integer.valueOf(String.valueOf(anoMesDia).substring(6,8));
	}
	
	public static Integer converteMesAnoParaAnoMes(String anoMes) {
		if (anoMes!= null && anoMes.length() == 7)
			return Integer.valueOf(String.valueOf(anoMes).substring(3) + String.valueOf(anoMes).substring(0,2));
		else
			return null;
	}
	
	public static String converteAnoMesParaMesAno(Integer anoMes) {
		return String.valueOf(anoMes).substring(4) + "/" + String.valueOf(anoMes).substring(0,4);
	}
	
	public static String retiraCaracteresEspeciais(String texto){
	    texto = Normalizer.normalize(texto,Normalizer.Form.NFD);
	    return texto.replaceAll("[^\\p{ASCII}]", "");
    }	
	
	public static String completaComEspacosADireita(int tamanhoCampo, Object campo) {
		return completaStringADireita(tamanhoCampo, campo, ' ');
	}
	
	private static String completaStringAEsquerda(int tamanhoCampo, Object campo, char caractere) {
		return StringUtils.leftPad(campo != null ? String.valueOf(campo) : "", tamanhoCampo, caractere);
	}
	
	private static String completaStringADireita(int tamanhoCampo, Object campo, char caractere) {
		return StringUtils.rightPad(campo != null ? String.valueOf(campo) : "", tamanhoCampo, caractere);
	}
	
	public static int arredondarParaCima(BigDecimal numero) {
		numero = numero.setScale(0, BigDecimal.ROUND_HALF_UP);
		return numero.intValue();
	}
	
	public static Integer obterQuantidadeMeses(Integer dataFim, Integer dataInicio) {
		if (dataFim != null && dataInicio != null) {
			Integer anoFim = extrairAno(dataFim);
			Integer anoInicio = extrairAno(dataInicio);
			
			Integer mesFim = extrairMes(dataFim);
			Integer mesInicio = extrairMes(dataInicio);
			
			if(anoFim == anoInicio){
				return mesFim - mesInicio;
			}else if(anoFim > anoInicio){
				return ((anoFim-anoInicio)*12)-(mesFim+mesInicio);
			}
		}
		return 0;
	}
}
