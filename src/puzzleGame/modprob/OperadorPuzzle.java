package puzzleGame.modprob;

import pee.modprob.Estado;
import pee.modprob.Operador;
import puzzle.Puzzle;

public class OperadorPuzzle implements Operador {
	
	private Puzzle.Movimento mov;
	private int custo = 1;
	
	public OperadorPuzzle (Puzzle.Movimento mov) {
		this.mov = mov;
	}

	/**
	 * 
	 */
	@Override
	public Estado aplicar(Estado estado) {
		EstadoPuzzle puzzleState = (EstadoPuzzle) estado;
		Puzzle puzzle = puzzleState.getPuzzle().movimentar(mov);
		
		if (puzzle != null) {
			EstadoPuzzle estadoSeguinte = new EstadoPuzzle(puzzle);
			return estadoSeguinte;
		}
		
		return null;
	}

	@Override
	public float custo(Estado estado, Estado estadoSuc) {
		return custo;
	}

}
