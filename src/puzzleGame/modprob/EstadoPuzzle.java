package puzzleGame.modprob;

import pee.modprob.Estado;
import puzzle.Puzzle;

public class EstadoPuzzle extends Estado {
	
	private Puzzle matriz;
	
	public EstadoPuzzle (Puzzle matriz) {
		this.matriz = matriz;
	}
	
	public Puzzle getPuzzle () {
		return matriz;
	}
	
	@Override
	public int hashCode () {
		return matriz.hashCode();
	}
	
	public String toString () {
		return matriz.toString();
	}

}
