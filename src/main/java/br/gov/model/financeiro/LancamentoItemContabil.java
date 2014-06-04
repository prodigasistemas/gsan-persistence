package br.gov.model.financeiro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lancamento_item_contabil", schema="financeiro")
public class LancamentoItemContabil {
	
	@Id
	@Column(name="lict_id")
	private Long id;
}

