package com.example.jeongyeji.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jeongyeji.myapplication.com.dto.BBS_DTO;
import com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeongyeji on 2017-09-21.
 */

public class BBSInputActivity extends AppCompatActivity {
    RequestQueue requestQueue ;
    EditText inputData[]=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbs_inputform);
        Button submit = (Button) findViewById(R.id.submit);
        requestQueue= Volley.newRequestQueue(this);
        submit.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){

                    StringRequest stringReqeust=new StringRequest(Request.Method.POST,"http://172.30.1.49:8080/JerseyPractice/rest/bbs/post",
                            new Response.Listener<String>() {

                                public void onResponse(String response) {
                                    Log.i("input form", "success!");
                                }
                            },
                            new Response.ErrorListener(){
                                public void onErrorResponse(VolleyError error){
                                    Log.i("input form","error..");
                                }


                            }){
                        @Override
                        protected Map<String, String> getParams()
                        {
                            BBS_DTO bbs_dto=inputBBS_DTO();
                            Gson gson=new Gson();
                            String data=gson.toJson(bbs_dto);
                            Log.i("jsp",data);
                            Map<String, String>  params = new HashMap<String, String>();
                            params.put("data",data);

                            return params;
                        }
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();
                            //headers.put("Content-Type", "application/json; charset=utf-8");
                            return headers;
                        }
                    };

                    requestQueue.add(stringReqeust);





            }



        });
    }
//
//
//
//
//        submit.setOnClickListener(new Button.OnClickListener(){
//
//
//                public void onClick(View v){
//                    Cache cache=new DiskBasedCache(getCacheDir(),1024*1024);
//                    Network network=new BasicNetwork(new HurlStack());
//
//                    requestQueue=new RequestQueue(cache,network);
//                    requestQueue.start();
//                    StringRequest stringReqeust=new StringRequest(Request.Method.POST,"",
//                            new Response.Listener<String>() {
//
//                                public void onResponse(String response) {
//                                    Log.i("input form", "success!");
//                                }
//                            },
//                            new Response.ErrorListener(){
//                                public void onErrorResponse(VolleyError error){
//                                    Log.i("input form","error..");
//                                }
//
//
//                            });
//
//                    requestQueue.add(stringReqeust);
//
//
//                }});



//}
    public BBS_DTO inputBBS_DTO(){
         BBS_DTO bbs_dto=new BBS_DTO();
         EditText contents[]=new EditText[4];

        contents[0]=(EditText)findViewById(R.id.user_id);
         contents[1]=(EditText)findViewById(R.id.bbs_location);
         contents[2]=(EditText)findViewById(R.id.bbs_title);
         contents[3]=(EditText)findViewById(R.id.bbs_Content);
        bbs_dto.setUser_id(contents[0].getText().toString());
        bbs_dto.setBbs_location(contents[1].getText().toString());
        bbs_dto.setBbs_title(contents[2].getText().toString());
        bbs_dto.setBbs_content(contents[3].getText().toString());
        // temp
        bbs_dto.setBbs_date(new Timestamp(System.currentTimeMillis()));
        bbs_dto.setBbs_read(0);


         return bbs_dto;
        }
    }