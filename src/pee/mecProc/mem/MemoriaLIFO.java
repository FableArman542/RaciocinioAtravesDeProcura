package pee.mecProc.mem;

import java.util.Collections;
import java.util.LinkedList;

import pee.mecProc.No;

public class MemoriaLIFO extends MemoriaProcura {

	public MemoriaLIFO() {
		super(Collections.asLifoQueue(new LinkedList<No>()));
	}

}
