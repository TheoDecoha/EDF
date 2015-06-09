package com.edf_decoha;

import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class AfficheListeClient extends Activity {

	private ListView lvListe;
	private List<Client> malistec;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_affiche_client);
		malistec = (new Modele()).listclient();
		lvListe = (ListView)findViewById(R.id.lvListe);
		ClientAdapter adapter = new ClientAdapter(this, malistec);
		lvListe.setAdapter(adapter);
		lvListe.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
		      public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Intent myIntent = new Intent(getApplicationContext(), ModifClient.class);
				myIntent.putExtra("param1",  malistec.get(position).getIdentifiant());
				startActivity(myIntent);	
		        	}
		         });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.affiche_client, menu);
		return true;
	}

}
