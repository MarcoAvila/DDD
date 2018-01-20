package org.marcoavila.ddd.util.testingapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.repository.AbstractRepository;

/**
 * Emulates a data base by serializing java objects.
 * 
 * @author Marco Avila
 */
public abstract class AbstractObjectRep<EN extends Entity<ID>, ID> extends AbstractRepository<EN, ID>  {

	private final String DATA_BASE_PATH;
	
	

	
	
	public AbstractObjectRep(String dataBasePath) {
		DATA_BASE_PATH = dataBasePath;
	}


	
	
	
	protected EN addObj(EN en) throws Exception {

		en.setId( generateId() );
		
		write(en);
				
		return en;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	protected EN findObj(ID id) throws Exception {
		
		FileInputStream fin = new FileInputStream(DATA_BASE_PATH + 
				File.separator +
				fileNameFor(id));
		
		ObjectInputStream ois = new ObjectInputStream(fin);
		
		@SuppressWarnings("unchecked")
		EN entity = (EN)ois.readObject(); 
		ois.close();
				
		return entity;		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	protected EN saveObj(EN en) throws Exception {
		
		write(en);
				
		return en;		
	}
	
	
	
	
	
	
	
	
	

	
	

	
	private void write(EN en) throws Exception {
		
		FileOutputStream fout = new FileOutputStream(DATA_BASE_PATH + 
				File.separator +
				fileNameFor( en.getId() ));
		
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		
		oos.writeObject(en);		
		oos.close();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String fileNameFor(ID id) {
		return id.toString() + "." + AbstractObjectDao.FILE_EXTENSION;
	}
	



	
	
	protected abstract ID generateId();
	
	
	
	
	
}
