package org.marcoavila.ddd.util.testingapp;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.Entity;

/**
 * Emulates a data base by serializing java objects.
 * 
 * @author Marco Avila
 */
public abstract class AbstractObjectDao<EN extends Entity<Long>, ID> {

	private final String DATA_BASE_PATH;
	
	static final String FILE_EXTENSION = "javaobj";
	
	
	
	
	
	public AbstractObjectDao(String dataBasePath) {
		DATA_BASE_PATH = dataBasePath;
	}
















	@SuppressWarnings("unchecked")
	protected List<EN> findObjs(Class<EN> type) {

		List<EN> ens = new ArrayList<>();
		
		File dir = new File(DATA_BASE_PATH);
		
		FileFilter ff = new FileFilter() {			
			@Override
			public boolean accept(File f) {
				return f.getName().endsWith( FILE_EXTENSION );
			}
		};
		
		if (dir.listFiles(ff) == null)
			return ens;
		
		for (File f : dir.listFiles(ff)) {
			
			Object obj = null;
			try {
				obj = loadObj( f.getCanonicalPath() );
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (obj != null &&
				obj.getClass().equals(type))
				ens.add( (EN)obj );
		}
		
		 return ens;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	protected Object loadObj(String filePath) {
		
		FileInputStream fin;
		
		try {
			fin = new FileInputStream(filePath);
		
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			Object obj = ois.readObject(); // É ÓIS!
			ois.close();

			return obj;		

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
