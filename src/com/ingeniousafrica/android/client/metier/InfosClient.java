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
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mNom == null) ? 0 : mNom.hashCode());
		result = prime * result + ((mPrenom == null) ? 0 : mPrenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfosClient other = (InfosClient) obj;
		if (mNom == null) {
			if (other.mNom != null)
				return false;
		} else if (!mNom.equals(other.mNom))
			return false;
		if (mPrenom == null) {
			if (other.mPrenom != null)
				return false;
		} else if (!mPrenom.equals(other.mPrenom))
			return false;
		return true;
	}
	*/
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
