package app;

public class Guiche {
	private int numero;
	private Pessoa atendido;
	
	public Guiche(int numero) {
		this.numero = numero;
		this.atendido = null;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public Pessoa getAtendido() {
		return this.atendido;
	}
	
	public void setAtendido(Pessoa p) {
		this.atendido = p;
	}
	
	public String toString() {
		if(this.atendido == null) {
			return "Guiche "+numero+":Livre";
		}
		return "Guiche "+numero+":"+atendido.getNome();
	}
}
