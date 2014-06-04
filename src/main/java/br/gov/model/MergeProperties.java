package br.gov.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MergeProperties {

	public static <C> C mergeProperties(C destino, C origem) {
		Method[] metodos = origem.getClass().getMethods();
		String nomeMetodo;
		String nomeMetodoSemGet;

		try {
			for (Method metodo : metodos) {
				nomeMetodo = metodo.getName();
				nomeMetodoSemGet = nomeMetodo.substring(3, nomeMetodo.length());
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
				Method metodoSET = destino.getClass().getMethod("set" + nomeMetodoSemGet, metodo.getReturnType());
				if (metodo != null)
					metodoSET.invoke(destino, valor);
			}
		} catch (NoSuchMethodException e) {
			System.out.println("Metodo nao encontrado.");
		} catch (InvocationTargetException e) {
			System.out.println("Chamada de metodo incorreta.");
		} catch (IllegalAccessException e) {
			System.out.println("Metodo inacessivel.");
		} catch (IllegalArgumentException e) {
			System.out.println("Argumentos incorretos.");
		}

		return destino;
	}
}
