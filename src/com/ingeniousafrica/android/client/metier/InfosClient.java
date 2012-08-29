package com.ingeniousafrica.android.client.metier;

import java.io.Serializable;

public class InfosClient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mNom;
	private String mPrenom;

	
	public InfosClient() {
		super();
	}

	public InfosClient(String mNom, String mPrenom) {
		super();
		this.mNom = mNom;
		this.mPrenom = mPrenom;
	}

	public String getmNom() {
		return mNom;
	}

	public void setmNom(String mNom) {
		this.mNom = mNom;
	}

	public String getmPrenom() {
		return mPrenom;
	}

	public void setmPrenom(String mPrenom) {
		this.mPrenom = mPrenom;
	}

}
