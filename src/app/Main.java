package app;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SistemaFila fila = new SistemaFila(100);
		System.out.println("Informe o números de guiches:");
		int n = sc.nextInt();
		sc.nextLine();
		Guiche [] guiches = new Guiche[n];
		for(int i = 0;i<n;i++) {
			guiches[i] = new Guiche(i+1);
		}
		
		System.out.println("Sistema de contre de fila de atendimento");
		System.out.println("==Menu de opções==");
		while(true) {
			System.out.println("1-Cadastrar uma nova pessoa na fila\n2-Liberar Guiches\n3-Atender pessoas\n4-Exibir guiches\n5-Exibir fila\n6-Encerrar");
			int opcao = sc.nextInt();
			sc.nextLine();
			if(opcao == 1) {
				System.out.println("Digite o nome:");
				String nome = sc.nextLine();
				System.out.println("Digite a idade:");
				int idade = sc.nextInt();
				sc.nextLine();
				Pessoa p = new Pessoa(nome,idade);
				fila.add(p);
				System.out.println(p.getNome()+" foi adicionada a fila");
			}
			else if(opcao == 2) {
				for(Guiche g : guiches) {
					fila.liberarGuiche(g);
					System.out.println("Guiches liberados");
				}
			}
			else if(opcao == 3) {
				for(Guiche g : guiches) {
					fila.atender(g);
				}
			}
			else if(opcao == 4) {
				System.out.println("Guiches:");
				for(Guiche g : guiches) {
					System.out.println(g.toString());
				}
			}
			else if(opcao == 5) {
				fila.exibirFila();
			}
			else if(opcao == 6) {
				System.out.println("Encerrando...");
				break;
			}
			else {
				System.out.println("Opção inválida");
			}
			
		}

	}

}
