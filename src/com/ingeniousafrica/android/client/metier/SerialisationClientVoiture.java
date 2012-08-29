package com.ingeniousafrica.android.client.metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;

public class SerialisationClientVoiture {

	//Methode qui va nous permettre d enregistrer nos objets serialisés dans la memoire du telephone
	public static void saveData(Context context, String key, final Object data, boolean temp){
		synchronized (data) {
			
			if(data==null)return;
			final File file;
			if(temp){
				file = getCacheFile(context,key);
			}else{
				file = getDataFile(context,key);
			}
			save(file, data);
		}
	}
	
	//Methode qui sera appelée pour recuperer le chemin du dossier cache de l application
	private static File getCacheFile(Context context, String key){
		try {
			return new File(context.getCacheDir().getAbsolutePath()+"/"+key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//Methode qui sera appelée pour recuperer le chemin du dossier data de l application
	private static File getDataFile(Context context, String key){
		try {
			return new File(context.getFilesDir().getAbsolutePath()+"/"+key);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	//Methode qui sera appelée par la methode précedente saveData
	private static void save(File file, final Object data)
	{
		try {
			// Enregistrons notre objet avec un objet de type ObjectOutputStream
			FileOutputStream	fos = new FileOutputStream(file);
			ObjectOutputStream	oos = new ObjectOutputStream(fos);			
			oos.writeObject(data);			
			oos.close();
			fos.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//la methode qui nous permettra de charger les objets en mémoire
	public static Object readData(Context context, String key){
		
		//recuperons le chemin du dossier cache
		File file = getCacheFile(context,key);
		// Si le fichier n'éxiste pas dans le dossier du cache
		// On regarde s'il existe dans le dossier data
		if(!file.exists()){
			file = getDataFile(context,key);
			// S'il n'éxiste pas non plus dans le dossier data alors on retourne null
			if(!file.exists()) return null;
		}
		
		//En revanche s il existe, on utilise un objet de type ObjectInputStream pour deserialiser notre objet et le renvoyé
		try {
			FileInputStream		fis = new FileInputStream(file);
			ObjectInputStream	ois = new ObjectInputStream(fis);
			Object o = ois.readObject();		
			ois.close();
			fis.close();
			
			return o;

		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
