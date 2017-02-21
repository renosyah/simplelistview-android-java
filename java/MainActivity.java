package com.example.renosyahputra.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.renosyahputra.simplelistview.myCustomList.CustomListView;
import com.example.renosyahputra.simplelistview.myCustomList.ItemList;
import com.example.renosyahputra.simplelistview.request.Request_Data_List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ItemList> array_adapter_holder = new ArrayList<ItemList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView mylist = (ListView)findViewById(R.id.mylist);

        Response.Listener<String> response_from_server = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{

                    JSONObject data_json = new JSONObject(response);
                    JSONArray data_array = data_json.getJSONArray("Person");
                    for (int i = 0;i<data_array.length();i++){
                        JSONObject data_in_array = data_array.getJSONObject(i);
                        String id = data_in_array.getString("Id");
                        String nama = data_in_array.getString("Name");
                        String keterangan = "mahasiswa";  //data_in_array.getString("Stats");

                        array_adapter_holder.add(new ItemList(id,nama,keterangan));
                    }
                    CustomListView adapter = new CustomListView(MainActivity.this,R.layout.customlistcontent,array_adapter_holder);
                    mylist.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Request_Data_List request_data_to_server = new Request_Data_List("",response_from_server);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(request_data_to_server);




    mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String id_klik = ((TextView)view.findViewById(R.id.id_holder)).getText().toString();
            String nama_klik = ((TextView)view.findViewById(R.id.nama_holder)).getText().toString();

            Toast.makeText(getApplicationContext(),"ini "+nama_klik+" dengan nim "+id_klik,Toast.LENGTH_SHORT).show();
        }
    });

    }


}
