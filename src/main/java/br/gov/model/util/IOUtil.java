package br.gov.model.util;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;

public class IOUtil {

	public static void criarArquivo(String nome, String caminho, String conteudo) {
		File arquivo = new File(caminho + nome);
		IOUtil.escreverArquivo(arquivo, conteudo);
		IOUtil.comprimirParaGzip(arquivo);
		arquivo.delete();
	}
	
	public static void escreverArquivo(File arquivo, String texto) {
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo)));
			out.write(texto);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File comprimirParaGzip(File arquivo) {
		File comprimido = new File(arquivo.getAbsolutePath() + ".gz");

		try {
			InputStream input = new FileInputStream(arquivo);
			GZIPOutputStream output = new GZIPOutputStream(new FileOutputStream(comprimido));
			byte[] buffer = new byte[16 * 1024];

			for (int bytes = input.read(buffer); bytes > 0; bytes = input.read(buffer)) {
				output.write(buffer, 0, bytes);
			}

			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return comprimido;
	}

	public static byte[] transformarObjetoParaBytes(Object objeto) {
		byte[] retorno = null;

		try {
			ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
			ObjectOutputStream output = new ObjectOutputStream(byteOutput);
			output.writeObject(objeto);

			retorno = byteOutput.toByteArray();

			output.close();
			byteOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return retorno;
	}
}
