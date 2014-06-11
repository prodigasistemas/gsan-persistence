package br.gov.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.model.faturamento.DebitoCreditoSituacao;

@Converter
public class DebitoCreditoSituacaoConverter implements AttributeConverter<DebitoCreditoSituacao, String>{

	public String convertToDatabaseColumn(DebitoCreditoSituacao attribute) {
		System.out.println("REETETETEZTEZTEZTEZTEZTEZTEZTEZTEZTEZTEZTEZTEZTEZTEZTEZT");
		switch (attribute) {
		case NORMAL:
			return "N";
		case ARRASTADA:
			return "A";
		case INCLUIDA:
			return "I";
		default:
			return "Y";
		}
	}

	public DebitoCreditoSituacao convertToEntityAttribute(String dbData) {
		System.out.println("VCXVCVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVCXVXXVXC ------- " + dbData);
		switch (dbData) {
		case "N":
			return DebitoCreditoSituacao.NORMAL;
		case "A":
			System.out.println("hyyhhyhyhyhyhhyhyhyhyhyhyhyhyhyhyhyhyhyhyhyhyhyhyhyh");
			return DebitoCreditoSituacao.ARRASTADA;
		case "I":
			return DebitoCreditoSituacao.INCLUIDA;
		default:
			return DebitoCreditoSituacao.CANCELADA;
		}
	}
}
