package com.edf_decoha;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;

public class MainActivity extends Activity {

	private ImageView client = null;
	private ImageView identification = null;
	private ImageView sauvegarde = null;
	private ImageView transfert = null;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// On récupère toutes les vues dont on a besoin
		client = (ImageView)findViewById(R.id.IVclient);
		identification = (ImageView)findViewById(R.id.IVidentification);
		sauvegarde = (ImageView)findViewById(R.id.IVsauvegarde);
		transfert = (ImageView)findViewById(R.id.IVtransfert);
		
		// On attribue un listener adapté aux vues qui en ont besoin
		client.setOnClickListener(clickimage);
		identification.setOnClickListener(clickimage);
		sauvegarde.setOnClickListener(clickimage);
		transfert.setOnClickListener(clickimage);
		Modele vmodele = new Modele();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private OnClickListener clickimage = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId())
				{
					case R.id.IVclient: 
					Intent myIntent = new Intent(getApplicationContext(), AfficheListeClient.class);
					startActivity(myIntent);
						break;
					case R.id.IVidentification: Toast.makeText(MainActivity.this, "Il a des chaussure à 300 euros", Toast.LENGTH_SHORT).show();
						break;
					case R.id.IVsauvegarde: Toast.makeText(MainActivity.this, "Portable de bourge", Toast.LENGTH_SHORT).show();
						break;
					case R.id.IVtransfert: Toast.makeText(MainActivity.this, "Et surtout il vient en limousine", Toast.LENGTH_SHORT).show();
						break;
				}	
		}
	};
}

