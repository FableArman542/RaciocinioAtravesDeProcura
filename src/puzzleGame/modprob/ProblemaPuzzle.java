package puzzleGame.modprob;

import pee.mecProc.ProblemaHeur;
import pee.modprob.Estado;

public class ProblemaPuzzle extends ProblemaHeur {
	
	EstadoPuzzle estadoFinal;
	boolean heur;
	
	public ProblemaPuzzle (	EstadoPuzzle estadoInicial,
							EstadoPuzzle estadoFinal,
							OperadorPuzzle[] operadores) {
		super(estadoInicial, operadores);
		this.estadoFinal = estadoFinal;
	}
	
	public ProblemaPuzzle (	EstadoPuzzle estadoInicial,
							EstadoPuzzle estadoFinal,
							OperadorPuzzle[] operadores,
							boolean heur) {
		super(estadoInicial, operadores);
		this.estadoFinal = estadoFinal;
		this.heur = heur;
	}

	@Override
	public boolean objetivo(Estado estado) {
		return estado.equals(estadoFinal);
	}

	@Override
	public double heuristica(Estado estado) {
		EstadoPuzzle est = (EstadoPuzzle)estado;
		return (heur) ? est.getPuzzle().numPecasForaLugar(estadoFinal.getPuzzle()) :
						est.getPuzzle().distManhattan(estadoFinal.getPuzzle());
	}

}
