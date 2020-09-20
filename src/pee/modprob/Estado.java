package pee.modprob;

public abstract class Estado {
	
	public boolean equals (Object obj) {
		return (this.hashCode() 
				== obj.hashCode());
	}
	
	public abstract int hashCode ();

}
