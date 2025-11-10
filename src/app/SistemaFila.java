package app;

public class SistemaFila {
	private Pessoa [] prioridade80;
	private Pessoa [] prioridade65;
	private Pessoa [] semPrioridade;
	private int tamanho80 = 0;
	private int tamanho65 = 0;
	private int tamanhoSemPrioridade = 0;
	private int tamanhoMaximo;
	private int contPrioridades = 0;
		
	public SistemaFila(int capacidade) {
		prioridade80 = new Pessoa[capacidade];
		prioridade65 = new Pessoa[capacidade];
		semPrioridade = new Pessoa[capacidade];
		this.tamanhoMaximo = capacidade;
	}
	
	public boolean add(Pessoa p) {
		if(tamanho80 + tamanho65 + tamanhoSemPrioridade == tamanhoMaximo ) {
			System.out.println("A fila está cheia !");
			return false;
		}
		else {
			if(p.getIdade() >= 80) {
				prioridade80[tamanho80] = p;
				System.out.println();
				tamanho80 ++;
			}
			else if(p.getIdade()< 80 && p.getIdade() >= 65) {
				prioridade65[tamanho65] = p;
				tamanho65 ++;
			}
			else {
				semPrioridade[tamanhoSemPrioridade] = p;
				tamanhoSemPrioridade ++;
			}
		}
		return true;
	}
	
	public void pop(String tipo){
		if(tipo.equalsIgnoreCase("80+")) {
			for(int i =0;i<tamanho80;i++) {
				prioridade80[i] = prioridade80[i+1];
			}
			tamanho80 --;
		}
		else if(tipo.equalsIgnoreCase("65+")) {
			for(int i =0;i<tamanho65;i++) {
				prioridade65[i] = prioridade65[i+1];
			}
			tamanho65 --;
		}
		else {
			for(int i =0;i<tamanhoSemPrioridade;i++) {
				semPrioridade[i] = semPrioridade[i+1];
			}
			tamanhoSemPrioridade --;
		}
	}
	
	public void atender(Guiche g) {
		if(contPrioridades == 2 && isEmptySemPrioridade() != true && g.getAtendido() == null) {
			System.out.println("2 pessoas prioritárias foram atendidas , portatanto uma pessoa sem prioridade será chamada");
			g.setAtendido(semPrioridade[0]);
			if(semPrioridade[0] != null) {
				System.out.println("--->"+semPrioridade[0].toString()+"dirija-se ao guiche "+g.getNumero());
				contPrioridades = 0;
				pop("Sem prioridade");
			}
		}
		else if(isEmpty80() != true && g.getAtendido() == null) {
			g.setAtendido(prioridade80[0]);
			if(prioridade80[0] != null) {
				System.out.println("--->"+prioridade80[0].toString()+"dirija-se ao guiche "+g.getNumero());
				contPrioridades ++;
				pop("80+");
			}
		}
		else if(isEmpty65() != true && g.getAtendido() == null) {
			g.setAtendido(prioridade65[0]);
			if(prioridade65[0] != null) {
				System.out.println("--->"+prioridade65[0].toString()+"dirija-se ao guiche "+g.getNumero());
				contPrioridades ++ ;
				pop("65+");
			}
		}
		else {
			g.setAtendido(semPrioridade[0]);
			if(semPrioridade[0] != null) {
				System.out.println("--->"+semPrioridade[0].toString()+"dirija-se ao guiche "+g.getNumero());
				pop("Sem prioridade");
			}
			
		}
	}
	
	public void liberarGuiche(Guiche g) {
		g.setAtendido(null);
	}
	
	public boolean isEmpty80() {
		return tamanho80 == 0;
	}
	
	public boolean isEmpty65() {
		return tamanho65 == 0;
	}
	
	public boolean isEmptySemPrioridade() {
		return tamanhoSemPrioridade == 0;
	}
	
	public void exibirFila() {
		System.out.println("==Fila de Atendimento==");
		System.out.println("Pessoas 80+:");
		for(int i=0;i<tamanho80;i++) {
			System.out.print("-");
			System.out.println(prioridade80[i].toString());
		}
		System.out.println("Pessoas 65+:");
		for(int i=0;i<tamanho65;i++) {
			System.out.print("-");
			System.out.println(prioridade65[i].toString());
		}
		System.out.println("Pessoas sem prioridáde:");
		for(int i=0;i<tamanhoSemPrioridade;i++) {
			System.out.print("-");
			System.out.println(semPrioridade[i].toString());
		}
	}
	
}
