package plantraj;

import java.util.Scanner;

import pee.PassoSolucao;
import pee.melhorprim.ProcuraCustoUnif;
import pee.modprob.Solucao;
import pee.prof.ProcuraProf;
import plantraj.modprob.OperadorLigacao;
import plantraj.modprob.ProblemaPlanTraj;

public class PlaneadorTrajecto {

	/**
	 * Definir todos os operadores do planeador de trajeto
	 * @return
	 */
	private static OperadorLigacao[] definirOperadores () {
		OperadorLigacao[] ops = {	new OperadorLigacao ("Loc-0", "Loc-1", 5	),
									new OperadorLigacao ("Loc-0", "Loc-2", 25	),
									new OperadorLigacao ("Loc-1", "Loc-3", 12	),
									new OperadorLigacao ("Loc-1", "Loc-6", 5	),
									new OperadorLigacao ("Loc-2", "Loc-4", 30	),
									new OperadorLigacao ("Loc-3", "Loc-2", 10	),
									new OperadorLigacao ("Loc-3", "Loc-5", 5	),
									new OperadorLigacao ("Loc-4", "Loc-3", 2	),
									new OperadorLigacao ("Loc-5", "Loc-6", 8	),
									new OperadorLigacao ("Loc-5", "Loc-4", 10	),
									new OperadorLigacao ("Loc-6", "Loc-3", 15)	};
		return ops;
	}
	
	private static void mostrarTrajecto (Solucao solucao) {
		for (PassoSolucao sol: solucao) {
			System.out.println(sol.getEstado().toString());
		}
	}
	
	public static void main (String args[]) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		System.out.print("Insira a localidade inicial -> ");
		
		String ini = (input.nextLine());
		System.out.print("Insira a localidade final -> ");
		String fin = (input.nextLine());
		
		System.out.print ("Deseja pesquisar por transições ou custo (transicao/custo) ->");
		String cout = input.nextLine();
		
		// Criar um problema com o input do utilizador
		ProblemaPlanTraj prob = new ProblemaPlanTraj (ini, fin, definirOperadores());
		
		Solucao sol;
		
		// Conforme o input, resolver o problema com a procura desejada
		switch (cout) {
		case "transicao":
			System.out.println("Procura por Profundidade");
			sol = new ProcuraProf().resolver(prob, 2);
			break;
		case "custo":
			System.out.println("Procura por Custo");
			sol = new ProcuraCustoUnif().resolver(prob);
			break;
		default:
			System.out.println("Procura por Profundidade");
			sol = new ProcuraProf().resolver(prob, 2);
			break;
		}
		
		if (sol != null)
			mostrarTrajecto(sol);
	}
	
}
