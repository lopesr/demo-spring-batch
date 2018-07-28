package org.rodrigolopes.demo.batch.file.reader;

import org.rodrigolopes.demo.batch.file.register.IRegistro;
import org.rodrigolopes.demo.batch.file.register.RegistroDetalhe;
import org.rodrigolopes.demo.batch.file.register.RegistroFooter;
import org.rodrigolopes.demo.batch.file.register.RegistroHeader;
import org.rodrigolopes.demo.batch.file.register.RegistroNaoReconhecido;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class RegistroFieldSetMapper implements FieldSetMapper<IRegistro> {

	@Override
	public IRegistro mapFieldSet(FieldSet fieldSet) throws BindException {
		
		if (fieldSet == null) {
			return null;
		}

		String tipoRegistro = fieldSet.readString(0);
		
		if ("0".equals(tipoRegistro)) {
			return new RegistroHeader(tipoRegistro,
					fieldSet.readString(1),
					fieldSet.readString(2),
					fieldSet.readBigDecimal(3)
					);
		}
		
		if ("1".equals(tipoRegistro)) {
			return new RegistroDetalhe(tipoRegistro,
					fieldSet.readString(1),
					fieldSet.readBigDecimal(2),
					fieldSet.readBigDecimal(3)
					);			
		}
		
		if ("9".equals(tipoRegistro)) {
			return new RegistroFooter(tipoRegistro,
					fieldSet.readBigDecimal(1),
					fieldSet.readBigDecimal(2),
					fieldSet.readBigDecimal(3)
					);			
		}
		
		return new RegistroNaoReconhecido(fieldSet.readString(0));

	}

}
