package br.gov.model;

import java.lang.reflect.Method;

public class MergeProperties {

	public static <C> C mergeProperties(C destino, C origem) {
		Method[] metodos = origem.getClass().getMethods();
		String nomeMetodo;
		String nomeMetodoSemGet;

		try {
			for (Method metodo : metodos) {
				nomeMetodo = metodo.getName();
				// Testa se é um método get
				if (!nomeMetodo.substring(0, 3).equals("get"))
					continue;
				if (metodo.getParameterTypes().length != 0)
					continue;
				Object valor = metodo.invoke(origem);
				if (valor == null)
					continue;
				// Captura o metodo SET de acordo com o tipo de retorno do
				// metodo GET
				nomeMetodoSemGet = nomeMetodo.substring(3, nomeMetodo.length());
				Method metodoSET = destino.getClass().getMethod("set" + nomeMetodoSemGet, metodo.getReturnType());
				if (metodo != null)
					metodoSET.invoke(destino, valor);
			}
		} catch (Exception e) {
		}

		return destino;
	}
}
