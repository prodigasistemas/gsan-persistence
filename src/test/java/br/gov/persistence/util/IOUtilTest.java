package br.gov.persistence.util;

import static br.gov.persistence.util.IOUtil.arquivosFiltrados;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//FIXME: Parametrizar o teste com o diretorio
public class IOUtilTest {
    
    @Test
    public void testaFiltroArquivosComExtensaoTxt() throws IOException{
        String[] wildcards = new String[]{"*.txt"};
        File arq = new File("/tmp", "arq.txt");
        arq.createNewFile();
        File[] arquivos = arquivosFiltrados("/tmp", wildcards);
        
        assertEquals("arq.txt", arquivos[0].getName());
        
        arq.delete();
    }
    
    @Test
    public void testaFiltroArquivosComExtensaoTxtEComPrefixo() throws IOException{
        String[] wildcards = new String[]{"pre.01.*.txt"};
        List<File> arqs = new ArrayList<File>();
        File arq = new File("/tmp", "pre.01.extra.txt");
        arq.createNewFile();
        arqs.add(arq);
        arq = new File("/tmp", "pre.02.extra.txt");
        arq.createNewFile();
        arqs.add(arq);
        
        File[] arquivos = arquivosFiltrados("/tmp", wildcards);
        assertEquals(1, arquivos.length);
        assertEquals("pre.01.extra.txt", arquivos[0].getName());
        
        arqs.forEach(e -> e.delete());
    }    
}
