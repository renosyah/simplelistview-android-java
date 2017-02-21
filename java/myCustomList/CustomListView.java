package com.example.renosyahputra.simplelistview.myCustomList;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.renosyahputra.simplelistview.R;

import java.util.List;

public class CustomListView extends ArrayAdapter<ItemList> {

    Context context;
    int resource;
    List<ItemList> objects = null;


    public CustomListView(Context context, int resource, List<ItemList> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Datalist holder = null;
        if (row == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder = new Datalist();
            holder.id_datalist = (TextView) row.findViewById(R.id.id_holder);
            holder.nama_datalist = (TextView) row.findViewById(R.id.nama_holder);
            holder.keterangan_datalist = (TextView) row.findViewById(R.id.keterangan_holder);

            row.setTag(holder);

        }else{
            holder = (Datalist)row.getTag();
        }

        ItemList item = getItem(position);
        holder.id_datalist.setText(item.id);
        holder.nama_datalist.setText(item.nama);
        holder.keterangan_datalist.setText(item.keterangan);

        return row;
    }
    static class Datalist{
        TextView id_datalist;
        TextView nama_datalist;
        TextView keterangan_datalist;
    }
}
