package org.marcoavila.ddd;

/**
 * 
 * @author Marco Avila
 */

public abstract class AbstractEntity<ID> extends AbstractInvariantsOwner implements Entity<ID> {

	private ID id;
	
	
	

	

	public AbstractEntity() {

	}


	public AbstractEntity(ID id) {
		setId(id);
	}








	@Override
	public final ID getId() {
		return id;
	}




	
	


	@Override
	public final void setId(ID id) {
		this.id = id;
	}
	
	


		
	
	

	@Override
	protected String invariantsHeader() {
		
		return this.getClass().getSimpleName() +
				(id != null ? " id " + id : " <no id>") + ": ";
	}


	
	
	
	
	
	protected boolean falseWithMessage(String message) {
		this.message = message;
		return false;
	}
	
	
	
	
	
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}









	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}










		
	
}
