package com.example.antinapoles;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Context context;
	ArrayList<budgetinfo> list;
	LayoutInflater inflater;
	
	public MyAdapter(Context context, ArrayList<budgetinfo> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		budgetinfoHandler handler= null;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item_layout, null);
				handler = new budgetinfoHandler();
					handler.municipal_name = (TextView) convertView.findViewById(R.id.tvmunicipal_name);
					handler.month = (TextView) convertView.findViewById(R.id.tvmonth);
					handler.budget = (TextView) convertView.findViewById(R.id.tvbudget);
					handler.description = (TextView) convertView.findViewById(R.id.tvdescription);
					handler.total_expsenses = (TextView) convertView.findViewById(R.id.tvtotalexpenses);
				convertView.setTag(handler);
		}
		else handler = (budgetinfoHandler) convertView.getTag();
			//populate the handler
				handler.municipal_name.setText(list.get(position).getMunicipal_name());
				handler.month.setText(list.get(position).getMonth());
				handler.budget.setText(list.get(position).getBudget());
				handler.description.setText(list.get(position).getDescription());
				handler.total_expsenses.setText(list.get(position).getTotal_expenses());
		
		return convertView;
	}
	static class budgetinfoHandler{
		TextView  municipal_name,month,budget,description,total_expsenses;
	}
}
