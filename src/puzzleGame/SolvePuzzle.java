package puzzleGame;

import pee.PassoSolucao;
import pee.Procura;
import pee.ProcuraHeur;
import pee.larg.ProcuraLarg;
import pee.melhorprim.ProcuraAA;
import pee.melhorprim.ProcuraCustoUnif;
import pee.melhorprim.ProcuraSofrega;
import pee.modprob.Solucao;
import pee.prof.ProcuraProf;
import pee.prof.ProcuraProfIter;
import puzzle.Puzzle;
import puzzleGame.modprob.EstadoPuzzle;
import puzzleGame.modprob.OperadorPuzzle;
import puzzleGame.modprob.ProblemaPuzzle;

public class SolvePuzzle {
	
	public static OperadorPuzzle[] CriarOperadores () {
		OperadorPuzzle[] ops = {	new OperadorPuzzle(Puzzle.Movimento.CIMA),
									new OperadorPuzzle(Puzzle.Movimento.BAIXO),
									new OperadorPuzzle(Puzzle.Movimento.DIR),
									new OperadorPuzzle(Puzzle.Movimento.ESQ)};
		return ops;
	}
	
	public static void MostrarPassos (Solucao solucao) {
		for (PassoSolucao sol: solucao) {
			System.out.println(sol.getEstado().toString() + " Custo " + String.valueOf(sol.getCusto()));
		}
	}
	
	public static void main (String args[]) {
		
		int matrizA [][]  = {
							{1, 2, 3},
							{8, 4, 5},
							{6, 7, 0}
							};
		
		int matrizB [][]  = {
							{8, 4, 5},
							{6, 1, 2},
							{3, 7, 0}
							};
		
		int matrizFinal [][]  = {
								{1, 2, 3},
								{4, 5, 6},
								{7, 8, 0}
								};
		
		EstadoPuzzle eA = new EstadoPuzzle(new Puzzle(matrizA));
		EstadoPuzzle eB = new EstadoPuzzle(new Puzzle(matrizB));
		EstadoPuzzle eFinal = new EstadoPuzzle(new Puzzle(matrizFinal));
		System.out.println("Puzzle Solver");
		ProblemaPuzzle prob = new ProblemaPuzzle (	eA,
													eFinal,
													CriarOperadores());
		ProblemaPuzzle probHeur = new ProblemaPuzzle (	eB,
														eFinal,
														CriarOperadores(),
														false);
		
		Procura procProf = new ProcuraProf();
		Procura procProfIter = new ProcuraProfIter(10);
		Procura procLarg = new ProcuraLarg();
		Procura procCustoUnif = new ProcuraCustoUnif();
		ProcuraHeur procSofrega = new ProcuraSofrega();
		ProcuraHeur procAA = new ProcuraAA();
		
		//Solucao sol = procCustoUnif.resolver(prob);
		//Solucao sol = procProf.resolver(prob, 50);
		//Solucao sol = procProfIter.resolver(prob);
		//Solucao sol = procLarg.resolver(prob);
		//Solucao sol = procSofrega.resolver(probHeur);
		Solucao sol = procAA.resolver(probHeur);
		
		if (sol != null) {
			MostrarPassos(sol);
			
			System.out.println("Custo da solucao: " + sol.getCusto());
			System.out.println("Complexidade temporal: " + procAA.getCustoTemporal());
			System.out.println("Complexidade espacial: " + procAA.getCustoEspacial());
			
		}
	}
	
}
