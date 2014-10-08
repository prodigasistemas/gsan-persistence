package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="arquivo_texto_rot_empr", schema="micromedicao")
public class ArquivoTextoRoteiroEmpresa implements Serializable{
	private static final long serialVersionUID = 7820136855158807678L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ARQUIVO_TEXTO_ROT_EMPR")
	@SequenceGenerator(name="SEQ_ARQUIVO_TEXTO_ROT_EMPR", schema="micromedicao", sequenceName="seq_arquivo_texto_rot_empr", allocationSize=1)
	@Column(name="txre_id")
	private Integer id;
	
	@Column(name="txre_amreferencia")
	private Integer anoMesReferencia;
	
	@Column(name="sitl_id")
	private Integer situacaoTransmissaoLeitura;
	
	@ManyToOne
	@JoinColumn(name="rota_id")
	private Rota rota;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Integer getSituacaoTransmissaoLeitura() {
		return situacaoTransmissaoLeitura;
	}

	public void setSituacaoTransmissaoLeitura(Integer situacaoTransmissaoLeitura) {
		this.situacaoTransmissaoLeitura = situacaoTransmissaoLeitura;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
}
