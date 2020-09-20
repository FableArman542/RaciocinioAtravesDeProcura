package pee.modprob;

public interface Operador {
	
	/**
	 * Representa a aplica��o
	 * 	da a��o ao estado atual
	 * @param estado
	 * @return
	 */
	public Estado aplicar (Estado estado);
	
	
	/**
	 * Representa o custo para
	 * 	realizar a a��o (estado -> estadoSuc)
	 * @param estado
	 * @param estadoSuc
	 * @return
	 */
	public float custo (Estado estado, Estado estadoSuc);
	
}
