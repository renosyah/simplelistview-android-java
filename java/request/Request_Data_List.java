package com.example.renosyahputra.simplelistview.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Request_Data_List extends StringRequest{
    private static final String URL_SERVER_FOR_REQUEST = "http://192.168.23.1:8080/mintadata";
    private Map<String,String> Params;


    public Request_Data_List(String data_to_request, Response.Listener<String> respon_from_server){
        super(Method.POST,URL_SERVER_FOR_REQUEST,respon_from_server,null);

        Params = new HashMap<>();
        Params.put("find",data_to_request);
    }

    @Override
    public Map<String, String> getParams() {
        return Params;
    }
}
