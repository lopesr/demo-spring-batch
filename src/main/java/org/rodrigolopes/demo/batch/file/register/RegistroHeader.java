package org.rodrigolopes.demo.batch.file.register;

import java.math.BigDecimal;

public class RegistroHeader implements IRegistro {

	private String tipoRegistro;
	private String description;
	private String cliente;
	private BigDecimal sequencial;

	public RegistroHeader(String tipoRegistro, String description, String cliente, BigDecimal sequencial) {
		this.tipoRegistro = tipoRegistro;
		this.description = description;
		this.cliente = cliente;
		this.sequencial = sequencial;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getSequencial() {
		return sequencial;
	}

	public void setSequencial(BigDecimal sequencial) {
		this.sequencial = sequencial;
	}

	@Override
	public String toString() {
		return "RegistroHeader [tipoRegistro=" + tipoRegistro + ", description=" + description + ", cliente=" + cliente
				+ ", sequencial=" + sequencial + "]";
	}

}
