package pee.prof;

import pee.Procura;
import pee.mecProc.MecanismoProcura;
import pee.mecProc.Problema;
import pee.mecProc.mem.MemoriaLIFO;
import pee.mecProc.mem.MemoriaProcura;

public class ProcuraProf extends MecanismoProcura <Problema> implements Procura {

	@Override
	protected MemoriaProcura iniciarMemoria() {
		// A procura em profundidade utiliza memória LIFO
		return new MemoriaLIFO ();
	}

}
