package pee.modprob;

public interface Operador {
	
	/**
	 * Representa a aplicação
	 * 	da ação ao estado atual
	 * @param estado
	 * @return
	 */
	public Estado aplicar (Estado estado);
	
	
	/**
	 * Representa o custo para
	 * 	realizar a ação (estado -> estadoSuc)
	 * @param estado
	 * @param estadoSuc
	 * @return
	 */
	public float custo (Estado estado, Estado estadoSuc);
	
}
