package plantraj.modprob;

import pee.modprob.Estado;
import pee.modprob.Operador;

public class OperadorLigacao implements Operador {
	
	private EstadoLocalidade estadoOrigem,
							estadoDestino;
	
	private int custo;
	
	public OperadorLigacao (String locIni,
							String locFin,
							int custo) {
		this.estadoOrigem = new EstadoLocalidade (locIni);
		this.estadoDestino = new EstadoLocalidade (locFin);
		this.custo = custo;
	}
	
	public Estado aplicar (Estado estado) {
		if(estado.equals(estadoOrigem)) {
			return estadoDestino;
		}
			return null;
	}
	
	public float custo (Estado estado, Estado estadoSuc) {
		return custo;
	}
	
}
