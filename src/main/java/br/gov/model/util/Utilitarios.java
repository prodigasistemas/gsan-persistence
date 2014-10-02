package br.gov.model.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class Utilitarios {
	
	public static String formatarBigDecimalComPonto(BigDecimal numero) {

		if (numero == null) {
			numero = new BigDecimal("0.00");
		}

		NumberFormat formato = NumberFormat.getInstance(new Locale("pt", "BR"));
		formato.setMaximumFractionDigits(2);
		formato.setMinimumFractionDigits(2);
		formato.setGroupingUsed(false);

		return (formato.format(numero)).replace(",", ".");
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
	
	public static int reduzirMeses(Integer data, int meses) {
		data -= meses;
		
		if (data % 100 == 0){
			String strData = String.valueOf(data);
			int ano = Integer.valueOf(strData.substring(0, 4));
			ano--;
			data = Integer.valueOf(ano + "12"); 
		}
		
		return data;
	}
	
	public static Date adicionarDias(Date data, int dias) {
		return adicionaCampoData(data, Calendar.DAY_OF_MONTH, dias);
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
	
	public static String completaComEspacosADireita(int tamanhoCampo, Object campo) {
		return completaStringADireita(tamanhoCampo, campo, ' ');
	}
	
	private static String completaStringAEsquerda(int tamanhoCampo, Object campo, char caractere) {
		return StringUtils.leftPad(campo != null ? String.valueOf(campo) : "", tamanhoCampo, caractere);
	}
	
	private static String completaStringADireita(int tamanhoCampo, Object campo, char caractere) {
		return StringUtils.rightPad(campo != null ? String.valueOf(campo) : "", tamanhoCampo, caractere);
	}
}
