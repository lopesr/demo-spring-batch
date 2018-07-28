package org.rodrigolopes.demo.batch.file.writer;

import java.util.List;

import org.rodrigolopes.demo.batch.file.register.IRegistro;
import org.springframework.batch.item.ItemWriter;

public class RegistroWriter implements ItemWriter<IRegistro> {

	@Override
	public void write(List<? extends IRegistro> items) throws Exception {
		for(IRegistro registro : items){
			System.out.println("----Registro----> " + registro.toString());
		}
	}

}
