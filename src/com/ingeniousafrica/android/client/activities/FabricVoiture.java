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

	Spinner sp_marque;
	Button button_retour;
	Button button_fabric;
	String marque;
	
	Bundle objetbunble;

	private static final String Smarques [] = {"Avanza", "Benz", "BMW", "Dacia", "Toyota", "Volvo"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabric_voiture);

		objetbunble  = this.getIntent().getExtras();

		button_retour = (Button) findViewById(R.id.activity_fabric_voiture_button_retour);
		button_fabric = (Button) findViewById(R.id.activity_fabric_voiture_button_fabriquer);
		
		/** Mettons en place un ecouteur d evenement sur noscontrole button */
		button_retour.setOnClickListener(this);
		button_fabric.setOnClickListener(this);

		sp_marque = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> marque_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Smarques);
		marque_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_marque.setAdapter(marque_adapter);
		sp_marque.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(
					AdapterView<?> parent, View view, int position, long id) {
				int item = sp_marque.getSelectedItemPosition();
				marque = Smarques[item];

				showToast("La marque choisie est : " + marque);
			}

			public void onNothingSelected(AdapterView<?> parent) {
				//showToast("Spinner2: unselected");
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
			InfosClient client = (InfosClient)objetbunble.getSerializable("client");
			InfosVoiture voiture = (InfosVoiture)objetbunble.getSerializable("voiture");
			
			//
			voiture.setmMarque(marque);
    		

  		    objetbunble.putSerializable("voiture", voiture);
  		    objetbunble.putSerializable("client", client);
			

			Intent intent2 = new Intent(this, ParcVoiture.class);
			intent2.putExtras(objetbunble);
			startActivity(intent2);

			// Fin de l'activité
			finish();
			break;

		case R.id.activity_fabric_voiture_button_retour:
			Intent intent3 = new Intent(this, Main.class);
			intent3.putExtras(objetbunble);
			startActivity(intent3);
			// Fin de l'activité puis retour en arriere
			finish();

		}



	}
}
