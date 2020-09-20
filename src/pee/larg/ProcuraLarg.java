package pee.larg;

import pee.Procura;
import pee.mecProc.MecanismoProcura;
import pee.mecProc.Problema;
import pee.mecProc.mem.MemoriaFIFO;
import pee.mecProc.mem.MemoriaProcura;

public class ProcuraLarg extends MecanismoProcura <Problema> implements Procura {

	@Override
	protected MemoriaProcura iniciarMemoria() {
		// Procura em Largura utiliza memoria FIFO
		return new MemoriaFIFO ();
	}

}
