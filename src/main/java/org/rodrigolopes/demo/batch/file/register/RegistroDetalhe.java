package org.rodrigolopes.demo.batch.file.register;

import java.math.BigDecimal;

public class RegistroDetalhe implements IRegistro{

	private String tipoRegistro;
	private String Pagador;
	private BigDecimal valor;
	private BigDecimal sequencial;
	
	public RegistroDetalhe(String tipoRegistro, String pagador, BigDecimal valor, BigDecimal sequencial) {
		this.tipoRegistro = tipoRegistro;
		Pagador = pagador;
		this.valor = valor;
		this.sequencial = sequencial;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getPagador() {
		return Pagador;
	}

	public void setPagador(String pagador) {
		Pagador = pagador;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getSequencial() {
		return sequencial;
	}

	public void setSequencial(BigDecimal sequencial) {
		this.sequencial = sequencial;
	}

	@Override
	public String toString() {
		return "RegistroDetalhe [tipoRegistro=" + tipoRegistro + ", Pagador=" + Pagador + ", valor=" + valor
				+ ", sequencial=" + sequencial + "]";
	}
	

}
