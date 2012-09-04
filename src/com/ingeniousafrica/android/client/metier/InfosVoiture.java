package com.ingeniousafrica.android.client.metier;

import java.io.Serializable;

public class InfosVoiture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Creation des variables locales
	private String mMarque;
	private String mCouleur;
	private String mVitesse;
	private String mA;
   
	
	public InfosVoiture() {
	}

	public InfosVoiture(String mMarque, String mCouleur, String mVitesse, String mA) {
		super();
		this.mMarque = mMarque;
		this.mCouleur = mCouleur;
		this.mVitesse = mVitesse;
		this.mA = mA;
	}
	
	public InfosVoiture(String mMarque, String mCouleur, String mVitesse) {
		super();
		this.mMarque = mMarque;
		this.mCouleur = mCouleur;
		this.mVitesse = mVitesse;
		
	}

	public String getmMarque() {
		return mMarque;
	}


	public void setmMarque(String mMarque) {
		this.mMarque = mMarque;
	}


	public String getmCouleur() {
		return mCouleur;
	}


	public void setmCouleur(String mCouleur) {
		this.mCouleur = mCouleur;
	}


	public String getmVitesse() {
		return mVitesse;
	}


	public void setmVitesse(String mVitesse) {
		this.mVitesse = mVitesse;
	}

	public String getmA() {
		return mA;
	}

	public void setmA(String mA) {
		this.mA = mA;
	}

	
}
