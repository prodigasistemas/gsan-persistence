package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.exception.BaseRuntimeException;
import br.gov.model.exception.ParametroEmissaoContaFebrabanIndefinido;
import br.gov.model.exception.ParametroMensagemContaIndefinido;


@Entity
@Table(name="parametro",schema="faturamento")
public class FaturamentoParametro implements Serializable{
	private static final long serialVersionUID = -6903368616774359884L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_parametro")
	@SequenceGenerator(name="seq_parametro", sequenceName="seq_parametro", schema="faturamento", allocationSize=1)
    @Column(name="id")
	private Integer id;
	
	@Column(name="nome", nullable=false, length=40)
	private String nome;
	
	@Column(name="valor", nullable=false, length=150)
	private String valor;
	
	public enum NOME_PARAMETRO_FATURAMENTO{
	    EMITIR_CONTA_CODIGO_FEBRABAN(new ParametroEmissaoContaFebrabanIndefinido()), 
	    ESCREVER_MENSAGEM_CONTA_TRES_PARTES(new ParametroMensagemContaIndefinido());
	    
	    BaseRuntimeException exception = null;
	    
	    NOME_PARAMETRO_FATURAMENTO(BaseRuntimeException ex){
	        this.exception = ex;
	    }

        public BaseRuntimeException getException() {
            return exception;
        }
	}
	
    public FaturamentoParametro(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String toString() {
        return "FaturamentoParametros [nome=" + nome + ", valor=" + valor + "]";
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FaturamentoParametro other = (FaturamentoParametro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
