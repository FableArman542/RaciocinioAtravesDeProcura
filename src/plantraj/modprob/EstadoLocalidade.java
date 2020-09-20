package plantraj.modprob;

import pee.modprob.Estado;

/**
 * Estado com apenas mais umas caracteristicas de modo a ser uma localidade
 * @author arman
 *
 */
public class EstadoLocalidade extends Estado {
	
	private String localidade;
	
	public EstadoLocalidade (String localidade) {
		this.localidade = localidade;
	}
	
	public int hashCode () {
		return localidade.hashCode();
	}
	
	public String toString () {
		return "Localidade: " + localidade;
	}

}
