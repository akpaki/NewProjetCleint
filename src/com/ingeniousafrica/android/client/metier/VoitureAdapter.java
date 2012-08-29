package com.ingeniousafrica.android.client.metier;

import java.util.List;

import com.ingeniousafrica.android.client.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VoitureAdapter extends ArrayAdapter<InfosVoiture>{
//	String marque;
//	String couleur;
//	String vitesse;
	
	int mRes;
	//LayoutInflater a pour mission de charger notre fichier "item_nouveau_voiture.xml" pour l'item
	LayoutInflater inflateur;

	//Creation du constructeur par defaut pour prendre 2 parametres: une liste et un contexte
	public VoitureAdapter(Context context, int textViewResourceId, List<InfosVoiture> objects) {
		
		super(context, textViewResourceId, objects);
		
		inflateur = LayoutInflater.from(context);
		mRes = textViewResourceId;
	}

	//methode qui retournera la vue de l'item pour l'affichage
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = inflateur.inflate(mRes, null);
		
		}
		
		InfosVoiture voiture = getItem(position);
		
		//Creation des accesseurs vers nos controles
		TextView marque = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_texteview_marque);
		TextView couleur = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_texteview_couleur);
		TextView vitesse = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_texteview_boite_de_vitesse);
	
		marque.setText(voiture.getmMarque());
		couleur.setText(voiture.getmCouleur());
		vitesse.setText(voiture.getmVitesse());
		
		return convertView;
	}
	
	

}
