package br.gov.model.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;

public class IOUtil {

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
}
