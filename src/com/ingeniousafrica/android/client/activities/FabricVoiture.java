package com.ingeniousafrica.android.client.activities;

import com.ingeniousafrica.android.client.R;
import com.ingeniousafrica.android.client.metier.InfosClient;
import com.ingeniousafrica.android.client.metier.InfosVoiture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class FabricVoiture extends Activity implements OnClickListener{

	Spinner mSpMarque;
	
	Button mButtonRetour;
	Button mButtonFabric;
	
	String mChoixMarque;
	
	Bundle mObjetbunble;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabric_voiture);

		mObjetbunble  = this.getIntent().getExtras();

		mButtonRetour = (Button) findViewById(R.id.activity_fabric_voiture_button_retour);
		mButtonFabric = (Button) findViewById(R.id.activity_fabric_voiture_button_fabriquer);
		
		/** Mettons en place un ecouteur d evenement sur nos controles button */
		mButtonRetour.setOnClickListener(this);
		mButtonFabric.setOnClickListener(this);

		mSpMarque = (Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter<CharSequence> lMarqueAdapter = ArrayAdapter.createFromResource(this, R.array.marque, android.R.layout.simple_spinner_item);
		
		lMarqueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		mSpMarque.setAdapter(lMarqueAdapter);
		
		final String [] lMarqueView = this.getResources().getStringArray(R.array.marque);
		
		mSpMarque.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(
					AdapterView<?> parent, View view, int position, long id) {
				
				int lItemMarque = mSpMarque.getSelectedItemPosition();
				mChoixMarque = lMarqueView[lItemMarque];

				//Récupérons notre Resource de type String puis affichons le
				showToast(getResources().getString(R.string.choix_marque_voiture) + mChoixMarque);
			}

			public void onNothingSelected(AdapterView<?> parent) {
				
				//Récupérons notre Resource de type String puis affichons le
				showToast(getResources().getString(R.string.pas_choix_marque));
			}

		});

	}


	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	protected void showToast(String message) {

		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

	}

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.activity_fabric_voiture_button_fabriquer:
			
			//Recupèrons  les objets client et voiture qui se trouve dans l'objet bundle
			InfosClient client = (InfosClient)mObjetbunble.getSerializable("client");
			InfosVoiture voiture = (InfosVoiture)mObjetbunble.getSerializable("voiture");
			
			//
			voiture.setmMarque(mChoixMarque);
    		
  		    mObjetbunble.putSerializable("voiture", voiture);
  		    mObjetbunble.putSerializable("client", client);
			

			Intent intent2 = new Intent(this, ParcVoiture.class);
			intent2.putExtras(mObjetbunble);
			startActivity(intent2);

			// Fin de l'activité
			finish();
			break;

		case R.id.activity_fabric_voiture_button_retour:
			
			Intent intent3 = new Intent(this, Main.class);
			intent3.putExtras(mObjetbunble);
			startActivity(intent3);
			
			// Fin de l'activité puis retour en arriere
			finish();

		}



	}
}
