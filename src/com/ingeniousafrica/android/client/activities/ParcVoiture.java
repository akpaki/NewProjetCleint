package com.ingeniousafrica.android.client.activities;



import java.util.ArrayList;

import com.ingeniousafrica.android.client.R;
import com.ingeniousafrica.android.client.metier.DataRecupClientVoiture;
import com.ingeniousafrica.android.client.metier.InfosClient;
import com.ingeniousafrica.android.client.metier.InfosVoiture;
import com.ingeniousafrica.android.client.metier.SerialisationClientVoiture;
import com.ingeniousafrica.android.client.metier.VoitureAdapter;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ParcVoiture extends Activity implements OnClickListener{
	
	ListView mListNewVoiture;
	ListView mListVoiture;
	
	TextView mNomCli;
	TextView mPrenomCli;
	
	Button mButtonRetourClient;
	
	DataRecupClientVoiture mData;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parc_voiture);
        
        Bundle objetbunble  = this.getIntent().getExtras();
        
        // Recupèrons l objet client 
        InfosClient lClient = (InfosClient)objetbunble.getSerializable("client");
        
        mNomCli = (TextView)findViewById(R.id.activity_parc_voiture_client_nom);
        
        mPrenomCli = (TextView)findViewById(R.id.activity_parc_voiture_client_prenom);
        
        mNomCli.setText(lClient.getmNom());
        
        mPrenomCli.setText(lClient.getmPrenom());
        
     // Recupèrons l objet voiture 
        InfosVoiture lVoiture = (InfosVoiture)objetbunble.getSerializable("voiture");
        ArrayList<InfosVoiture> lItemNouveauVoiture = new ArrayList<InfosVoiture>();
        
        lItemNouveauVoiture.add(lVoiture);
        
        VoitureAdapter newAdapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture,lItemNouveauVoiture);
        
        mListNewVoiture = (ListView)findViewById(R.id.activity_parc_voiture_listview);
        
        mListNewVoiture.setAdapter(newAdapter);
        
        mButtonRetourClient = (Button) findViewById(R.id.activity_parc_voiture_button_retour);
        mButtonRetourClient.setOnClickListener(this);
        
        mData = (DataRecupClientVoiture) SerialisationClientVoiture.readData(this, "Donnees");
        
        // Verification 
        if(mData != null){
        	
        	VoitureAdapter lAdapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture,mData.getmVoiture());
        	
        	mListVoiture = (ListView)findViewById(R.id.activity_parc_voiture_listview);
        	
        	mListVoiture.setAdapter(lAdapter);

        	mData.getmVoiture().add(lVoiture); 
	        
	        SerialisationClientVoiture.saveData(this, "Donnees", mData, false);
	        
        }else{
        	
        	mData = new DataRecupClientVoiture();
        	mData.setmVoiture(lItemNouveauVoiture);
	        
	        SerialisationClientVoiture.saveData(this, "Donnees", mData, false);
        }
     
        
    }


	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.activity_parc_voiture_button_retour:
			
			Intent lIntent = new Intent(this, Main.class);
    		startActivity(lIntent);
			finish();
			
			break;
		}

	}
	
	
}
