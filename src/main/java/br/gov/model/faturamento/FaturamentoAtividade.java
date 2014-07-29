package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="faturamento_atividade", schema="faturamento")
public class FaturamentoAtividade implements Serializable{
	private static final long serialVersionUID = 1541432061228892380L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FATURAMENTO_ATIVIDADE")
	@SequenceGenerator(name="SEQ_FATURAMENTO_ATIVIDADE", schema="faturamento", sequenceName="seq_faturamento_atividade", allocationSize=1)		
	@Column(name="ftat_id")
	private Integer id;
	

	public final static Integer GERAR_ARQUIVO_LEITURA = new Integer(1);
	public final static Integer EFETUAR_LEITURA = new Integer(2);
	public final static Integer REGISTRAR_LEITURA_ANORMALIDADE = new Integer(3);
	public final static Integer GERAR_FISCALIZACAO = new Integer(4);
	public final static Integer TRANSMITIR_ARQUIVO = new Integer(7);
	public final static Integer DISTRIBUIR_CONTAS = new Integer(6);
	public final static Integer FATURAR_GRUPO = new Integer(5);
	public final static Integer SIMULAR_FATURAMENTO = new Integer(8);
	public final static Integer PRE_FATURAR_GRUPO = new Integer(0);
	public final static Integer CONSISTIR_LEITURAS_E_CALCULAR_CONSUMOS = new Integer(9);
	
	public final static Short ATIVIDADE_POSSIVEL_COMANDO = new Short("1");
	public final static Short ATIVIDADE_POSSIVEL_REPETICAO = new Short("1");

	public FaturamentoAtividade() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
