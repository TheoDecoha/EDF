package com.edf_decoha;

import java.io.File;
import android.os.Environment;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Modele {
	
	private String DB4OFILENAME; 
	private ObjectContainer db;
	private File appDir;
	
	public void open()
	{
		DB4OFILENAME=Environment.getExternalStorageDirectory()+"/baseDB4O"+"/BaseEDF_DECOHA.db4o";
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	}
	
	public void mkdir()
	{
		appDir = new File(Environment.getExternalStorageDirectory()+"/baseDB4O");
		if(!appDir.exists() && !appDir.isDirectory()) 
		    {
		        appDir.mkdirs();
		    }
	}

	public ArrayList<Client> listclient()
	{
		open();
		ArrayList<Client> lesclients = new ArrayList<Client>();
		
		ObjectSet<Client> result = db.queryByExample(Client.class);
		while (result.hasNext()) {
			lesclients.add(result.next());
		}
		db.close();
		return lesclients;	
	}
	
	public Client trouveclient(String id)
	{
		open();
		Client vretour = new Client();
		vretour.setIdentifiant(id);
		ObjectSet<Client> result = db.queryByExample(vretour);
		if(result.hasNext())
		{
			vretour= (Client) result.next();
		}
		else
		{
			vretour=null;
		}
		db.close();
		return vretour;
	}
	
	public void saveclient(Client unClient)
	{		
		open();
		Client vretour = new Client();
		vretour.setIdentifiant(unClient.getIdentifiant());
		ObjectSet<Client> result = db.queryByExample(vretour);
		
		if(result.size() == 0)
		{
			db.store(unClient);
			
		}
		else
		{
			vretour = (Client)result.next();
			vretour.recopieclient(unClient);
			db.store(vretour);
		}
		db.close();
	}
	
	public void chargedb()
	{
		
		ObjectSet<Client> result = db.queryByExample(Client.class);
		if(result.size()==0)
		{
		try {
			Client vcli1=	new Client("1001", "Bourbon", "Mathieu","10 rue Anne Frank", "49000", "angers","0624553212", "19950055123", 1456.24,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2012"));
			Client vcli2=	new Client("1002", "Charraud", "Bastien","10 rue Anne Frank", "49000", "angers","0624553212", "19950055123", 1456.24,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2012"));
			Client vcli3=	new Client("1003", "Armand", "Maxence","10 rue Anne Frank", "49000", "angers","0624553212", "19950055123", 1456.24,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2012"));
			Client vcli4=	new Client("1004", "Decoha", "Théo","10 rue Anne Frank", "49000", "angers","0624553212", "19950055123", 1456.24,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2012"));
			Client vcli5=	new Client("1005", "Delohen", "Kévin","10 rue Anne Frank", "49000", "angers","0624553212", "19950055123", 1456.24,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2012"));
			db.store(vcli1);
			db.store(vcli2);
			db.store(vcli3);
			db.store(vcli4);
			db.store(vcli5);
			} 
		catch (ParseException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	public Modele()
	{
		mkdir();
		open();
		chargedb();
		db.close();
	}
}
