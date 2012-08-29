package com.ingeniousafrica.android.client.metier;

import java.io.Serializable;
import java.util.ArrayList;


public class DataRecupClientVoiture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<InfosClient> mClient; // Composition, il ya destruction de l instance mClient lorsque l instance InfosClient est détruite
	private ArrayList<InfosVoiture> mVoiture;
	
	public ArrayList<InfosClient> getmClient() {
		return mClient;
	}
	
	public void setmClient(ArrayList<InfosClient> mClient) {
		this.mClient = mClient;
	}
	
	
	public ArrayList<InfosVoiture> getmVoiture() {
		return mVoiture;
	}
	public void setmVoiture(ArrayList<InfosVoiture> mVoiture) {
		this.mVoiture = mVoiture;
	}
	
	
	

}
