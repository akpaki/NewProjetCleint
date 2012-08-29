package com.ingeniousafrica.android.client.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.ingeniousafrica.android.client.R;
import com.ingeniousafrica.android.client.metier.InfosClient;
import com.ingeniousafrica.android.client.metier.InfosVoiture;

public class Main extends Activity implements OnClickListener{

	// Définition des variables globales pour contenir nos controles
	EditText mNom;
	EditText mPrenom;
	Spinner mSpcouleur;
	Spinner mSpvitesse;
	Button mButton;

	String mCouleur;
	String mVitesse;

	/** Creation de tableau du choix pour les options */
	//private static final String Scouleurs [] = {"Rouge", "Bleue", "Verte",  "Noire", "Blanche", "Orange"};
	//private static final String Svitesses [] = {"Mécanique", "Automatique"};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		/** Méthode appelée à la création de l'activité
		 * @param savedInstanceState permet de restaurer l'état 
		 * de l'interface utilisateur 
		 * 
		 * */
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// creation des accesseurs vers nos controles
		mNom = (EditText) findViewById(R.id.editText1);
		mNom.setInputType(InputType.TYPE_CLASS_TEXT);

		mPrenom = (EditText) findViewById(R.id.activity_main_editext_prenom);
		mPrenom.setInputType(InputType.TYPE_CLASS_TEXT);

		mButton = (Button)findViewById(R.id.activity_main_button_valider);

		/** Mettons en place un ecouteur d evenement sur notre controle button */
		mButton.setOnClickListener(this);

		mSpcouleur = (Spinner) findViewById(R.id.activity_main_spinner_couleur);
		
		//ArrayAdapter<String> color_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Scouleurs);
		ArrayAdapter<CharSequence> lColorAdapter = ArrayAdapter.createFromResource(
				this, R.array.couleur, android.R.layout.simple_spinner_item);
		lColorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		mSpcouleur.setAdapter(lColorAdapter);
		mSpcouleur.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				
				//int item = mSpcouleur.getSelectedItemPosition();
				//mCouleur = Scouleurs[item];

				showToast("La couleur choisie est : " + mCouleur);

				//showToast("La vitesse choisie est : " + choix_couleur);
				//showToast("Spinner2: position=" + position + " id=" + id);
			}

			public void onNothingSelected(AdapterView<?> parent) {
				//showToast("Spinner2: unselected");
			}

		});

		mSpvitesse = (Spinner) findViewById(R.id.activity_main_spinner_boite_de_vitesse);
		
		//  ArrayAdapter<String> vitesse_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Svitesses);
		ArrayAdapter<CharSequence> lVitesseAdapter = ArrayAdapter.createFromResource(
				this, R.array.boite_de_vitesse, android.R.layout.simple_spinner_item);
		lVitesseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpvitesse.setAdapter(lVitesseAdapter);
		
		mSpvitesse.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(
					AdapterView<?> parent, View view, int position, long id){
  			   // int item = mSpvitesse.getSelectedItemPosition();
				//mVitesse = Svitesses[item];
				
				showToast("Spinner1: position=" + view + " id=" + id);
               
				showToast("La vitesse choisie est : " + mVitesse);

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				

			}
		});


	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_main_button_valider:

			if(mNom.getText().toString() != null || mPrenom.getText().toString() != null){
				//Creation d un objet de type Bundle
				Bundle objetbunble = new Bundle();

				//Instancions un objet client pour les infos du client
				InfosClient client = new InfosClient();

				//Instancions un objet voiture pour les infos de la nouvelle voiture
				InfosVoiture voiture = new InfosVoiture();

				//
				client.setmNom(mNom.getText().toString());
				client.setmPrenom(mPrenom.getText().toString());

				//
				voiture.setmCouleur(mCouleur);
				voiture.setmVitesse(mVitesse);


				//Mettons les objets client et voiture dans l'objet bundle afin de pouvoir le recuperer dans l'autre activity
				objetbunble.putSerializable("client", client);
				objetbunble.putSerializable("voiture", voiture);

				Intent intent = new Intent(this, FabricVoiture.class);
				
				//Nous mettons l objet de type bundle dans l'intent
				intent.putExtras(objetbunble);
				
				//Demarrons notre intent
				startActivity(intent);

				break;
			}
			else
			{
				Intent intent = new Intent(this, Main.class);
				startActivity(intent);
				showToast("Les champs sont vides");
			}

		}


	}

	protected void showToast(String message) {

		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

	} 
	/** Fonction appelée Lorsque l activité de visible a l user */
	@Override
	protected void onStart() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("","onStart");
		super.onStart();
	}

	/** Fonction appelée lorsque l activité devien reellemet active et en cours d utilisation par l user */
	@Override
	protected void onResume() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onResume");
		super.onResume();
	}

	/** Fonction appelée lorsque l activité est en pause */
	@Override
	protected void onPause() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onPause");
		super.onPause();
	}

	/** Fonction appelée lorsque l activité est stopé par un autre programme du systeme */
	@Override
	protected void onStop() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onStop");
		super.onStop();
	}


	/** Fonction appelée a la fin de notre activity */
	@Override
	protected void onDestroy() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onDestroy");
		super.onDestroy();
	}
}