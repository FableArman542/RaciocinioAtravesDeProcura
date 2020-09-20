package plantraj.modprob;

import pee.mecProc.Problema;
import pee.modprob.Estado;

public class ProblemaPlanTraj extends Problema {
	
	private EstadoLocalidade estadoFinal;

	public ProblemaPlanTraj(String estadoInicial,
							String estadoFinal,
							OperadorLigacao[] operadores) {
		super(new EstadoLocalidade (estadoInicial), operadores);
		this.estadoFinal = new EstadoLocalidade (estadoFinal);
	}

	@Override
	public boolean objetivo (Estado estado) {
		return estado.equals(this.estadoFinal);
	}

}
