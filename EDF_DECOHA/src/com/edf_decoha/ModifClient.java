package com.edf_decoha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifClient extends Activity {

	Modele monmodele = new Modele();
	Client monclient = new Client();
	private Double modifreleve = null;
	private TextView num = null;
	private TextView nom = null;
	private TextView prenom = null;
	private TextView tel = null;
	private TextView adresse = null;
	private TextView cp = null;
	private TextView ville = null;
	private TextView compteur = null;
	private TextView ancienreleve = null;
	private TextView anciennedate = null;
	private EditText releve = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modif_client);
		Bundle b = getIntent().getExtras();
		String param1 = b.getString("param1");

		monclient = monmodele.trouveclient(param1);

		DatePicker dp = (DatePicker) findViewById(R.id.dPreleve);
		Date d = monclient.getDate_dernier_releve();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		dp.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		DatePicker dt = (DatePicker) findViewById(R.id.dPreleve);
		// dt.setCalendarViewShown(false);

		// TextViews

		num = (TextView) findViewById(R.id.textView1);
		nom = (TextView) findViewById(R.id.textView2);
		prenom = (TextView) findViewById(R.id.textView7);
		tel = (TextView) findViewById(R.id.textView3);
		adresse = (TextView) findViewById(R.id.textView4);
		cp = (TextView) findViewById(R.id.textView5);
		ville = (TextView) findViewById(R.id.textView8);
		compteur = (TextView) findViewById(R.id.textView6);
		ancienreleve = (TextView) findViewById(R.id.textView9);
		anciennedate = (TextView) findViewById(R.id.textView11);
		releve = (EditText) findViewById(R.id.eTReleve);

		Button btnGeo = (Button) findViewById(R.id.btnGeo);
		Button btnSigna = (Button) findViewById(R.id.btnSigna);
		Button btnOk = (Button) findViewById(R.id.btnOk);
		Button btnCancel = (Button) findViewById(R.id.btnCancel);

		// Setters

		num.setText(monclient.getIdentifiant());
		nom.setText(monclient.getNom());
		prenom.setText(monclient.getPrenom());
		tel.setText(monclient.getTl());
		adresse.setText(monclient.getAdresse());
		cp.setText(monclient.getCp());
		ville.setText(monclient.getVille());
		compteur.setText(monclient.getIdcompteur());
		ancienreleve.setText(monclient.getAncien_releve().toString());
		anciennedate.setText(new SimpleDateFormat("dd/MM/yyyy").format(monclient.getDate_ancien_releve()));
		releve.setText(monclient.getAncien_releve().toString());

		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		btnOk.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (saveok()) {
					save(monclient);
				}
				finish();
			}
		});

	}

	public boolean saveok() {
		if (monclient.getSituation() != 0
				&& Double.parseDouble(compteur.getText().toString()) > Double
						.parseDouble(monclient.getAncien_releve().toString())
				&& (monclient.getSituation() < 7 && monclient.getSituation() > 0)) {
			Toast.makeText(getApplicationContext(), "Ok succès",
					Toast.LENGTH_LONG).show();
			return true;
		} else {
			Toast.makeText(getApplicationContext(),
					"Vous ne respectez pas les conditions", Toast.LENGTH_LONG)
					.show();
			return false;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modif_client, menu);
		return true;
	}

	public void save(Client vcli) {

		modifreleve = Double.parseDouble(releve.getText().toString());
		vcli.setAncien_releve(modifreleve);

		// vcli.setDernier_releve((double) R.id.eTReleve);
		vcli.setSituation(R.id.eTSituation);
		int day = ((DatePicker) findViewById(R.id.dPreleve)).getDayOfMonth();
		int month = ((DatePicker) findViewById(R.id.dPreleve)).getMonth();
		int year = ((DatePicker) findViewById(R.id.dPreleve)).getYear();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		vcli.setDate_dernier_releve(calendar.getTime());
		monmodele.saveclient(vcli);
	}

}
