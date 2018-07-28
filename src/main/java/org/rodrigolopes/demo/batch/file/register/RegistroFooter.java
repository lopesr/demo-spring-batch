package org.rodrigolopes.demo.batch.file.register;

import java.math.BigDecimal;

public class RegistroFooter implements IRegistro {

	private String tipoRegistro;
	private BigDecimal qtdeRegistros;
	private BigDecimal valorTotal;
	private BigDecimal sequencial;

	public RegistroFooter(String tipoRegistro, BigDecimal qtdeRegistros, BigDecimal valorTotal, BigDecimal sequencial) {
		super();
		this.tipoRegistro = tipoRegistro;
		this.qtdeRegistros = qtdeRegistros;
		this.valorTotal = valorTotal;
		this.sequencial = sequencial;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public BigDecimal getQtdeRegistros() {
		return qtdeRegistros;
	}

	public void setQtdeRegistros(BigDecimal qtdeRegistros) {
		this.qtdeRegistros = qtdeRegistros;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getSequencial() {
		return sequencial;
	}

	public void setSequencial(BigDecimal sequencial) {
		this.sequencial = sequencial;
	}

	@Override
	public String toString() {
		return "RegistroFooter [tipoRegistro=" + tipoRegistro + ", qtdeRegistros=" + qtdeRegistros + ", valorTotal="
				+ valorTotal + ", sequencial=" + sequencial + "]";
	}

}
