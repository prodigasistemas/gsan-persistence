package br.gov.model.seguranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.exception.BaseRuntimeException;
import br.gov.model.exception.ParametroCaminhoArquivosIndefinido;
import br.gov.model.exception.ParametroCaminhoLogBatchIndefinido;

@Entity
@Table(name = "parametro", schema = "seguranca")
public class SegurancaParametro implements Serializable {

	private static final long serialVersionUID = -7918264574580624530L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seguranca_parametro")
	@SequenceGenerator(name = "seq_seguranca_parametro", sequenceName = "seq_seguranca_parametro", schema = "seguranca", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", nullable = false, length = 40)
	private String nome;

	@Column(name = "valor", nullable = false, length = 150)
	private String valor;

	public enum NOME_PARAMETRO_SEGURANCA {
		CAMINHO_ARQUIVOS(new ParametroCaminhoArquivosIndefinido()),
		CAMINHO_LOG_BATCH(new ParametroCaminhoLogBatchIndefinido());

		BaseRuntimeException exception = null;

		NOME_PARAMETRO_SEGURANCA(BaseRuntimeException ex) {
			this.exception = ex;
		}

		public BaseRuntimeException getException() {
			return exception;
		}
	}

	public SegurancaParametro() {
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

	@Override
	public String toString() {
		return "SegurancaParametro [nome=" + nome + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SegurancaParametro other = (SegurancaParametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
