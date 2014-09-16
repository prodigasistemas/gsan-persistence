package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="consumo_tipo", schema="micromedicao")
public class ConsumoTipo implements Serializable{
	private static final long serialVersionUID = 529444854740790878L;
	
	public final static int INDEFINIDO       = 0;
    public final static int REAL             = 1;
    public final static int AJUSTADO         = 2;
    public final static int MEDIA_HIDROMETRO = 3;
    public final static int INFORMADO        = 4;
    public final static int NAO_MEDIDO       = 5;
    public final static int ESTIMADO         = 6;
    public final static int MINIMO_FIXADO    = 7;
    public final static int SEM_CONSUMO      = 8;
    public final static int MEDIA_IMOVEL     = 9;
    public final static int FIXO_SITUACAO_ESPECIAL = 10;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSUMO_TIPO")
	@SequenceGenerator(name="SEQ_CONSUMO_TIPO", schema="micromedicao", sequenceName="seq_consumo_tipo", allocationSize=1)
	@Column(name="cstp_id")
	private Integer id;
	
	@Column(name="cstp_iccalculomedia")
	private Short indicadorCalculoMedia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getIndicadorCalculoMedia() {
		return indicadorCalculoMedia;
	}

	public void setIndicadorCalculoMedia(Short indicadorCalculoMedia) {
		this.indicadorCalculoMedia = indicadorCalculoMedia;
	}

	public String toString() {
		return "ConsumoTipo [id=" + id + "]";
	}
}
