package com.edf_decoha;

import java.util.List;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClientAdapter extends BaseAdapter {
	
	private List<Client> Listec;
	private LayoutInflater inflater;
	
	public ClientAdapter(Context context,List<Client> vListec) {
			inflater = LayoutInflater.from(context);
			Listec = vListec;
	}
	
	private class ViewHolder {
		TextView vid, vnom, vprenom, vtl, vad, vcp,  vville;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Listec.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return Listec.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.vueclient, null);	
			
			String s=Listec.get(position).getTl();
			s=String.format("%s.%s.%s.%s.%s", s.substring(0, 2), s.substring(2, 4), 
					          s.substring(4, 6),s.substring(6, 8),s.substring(8, 10));
			
			holder.vid = (TextView)convertView.findViewById(R.id.TwNum);
			holder.vnom = (TextView)convertView.findViewById(R.id.TwNom);
			holder.vprenom = (TextView)convertView.findViewById(R.id.TwPrenom);
			holder.vtl = (TextView)convertView.findViewById(R.id.TwTel);
			holder.vtl.setText(s);
			holder.vad = (TextView)convertView.findViewById(R.id.TwAdresse);
			holder.vcp = (TextView)convertView.findViewById(R.id.TwCP);
			holder.vville = (TextView)convertView.findViewById(R.id.TwVille);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.vid.setText(Listec.get(position).getIdentifiant());
		holder.vnom.setText(Listec.get(position).getNom());
		holder.vprenom.setText(Listec.get(position).getPrenom());
		holder.vtl.setText(Listec.get(position).getTl());
		holder.vad.setText(Listec.get(position).getAdresse());
		holder.vcp.setText(Listec.get(position).getCp());
		holder.vville.setText(Listec.get(position).getVille());
		
		   if(position % 2 == 0){  
			   convertView.setBackgroundColor(Color.rgb(238, 233, 233));
		   }
		   else {
			   convertView.setBackgroundColor(Color.rgb(255, 255, 255));
		   }

		
		return convertView;
	}

}
