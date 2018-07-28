package org.rodrigolopes.demo.batch.file.register;

public class RegistroNaoReconhecido implements IRegistro {

	private String registro;

	public RegistroNaoReconhecido(String registro) {
		super();
		this.registro = registro;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "RegistroNaoReconhecido [registro=" + registro + "]";
	}

}
