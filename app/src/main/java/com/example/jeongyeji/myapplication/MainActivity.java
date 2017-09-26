package com.example.jeongyeji.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jeongyeji.myapplication.com.dto.BBSList_DTO;
import com.example.jeongyeji.myapplication.com.dto.BBS_DTO;
import com.example.jeongyeji.myapplication.com.volleysingleton.VolleySingleton;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    Button next;
    BBS_DTO bbs_dto=new BBS_DTO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue= VolleySingleton.getInstance(this).getRequestQueue();
        // 받아온 데이터 객체에 삽입


    }

    public void onConnect(View v){
        Log.i("jsp", "click event!");
        // 통신 코드 작성
        // json data parsing
        // requstqueue 리턴 > 통신 큐 > 하나씩 끄집어내서 한다.
        // 요청
        // method, url, listener
        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                "http://172.30.1.49:8080/JerseyPractice/rest/bbs",
                // webserver 고정 ip받고 이 주소를 써주어야 할 듯...
                new Response.Listener<String> (){
                    public void onResponse(String response) {
                        String changString=null;
                        Log.i("jsp","1");
                        Log.i("jsp",response);
                        TextView test=(TextView)findViewById(R.id.test);
                        Log.i("jsp","응답결과"+response);

                        Gson gson=new Gson();
                        // gson 으로 받아서 뒤에서 Map으로 보내준다.
                        BBSList_DTO resBoard=    gson.fromJson(response,BBSList_DTO.class);
                       for(BBS_DTO b : resBoard.getBbsList()) {

                           test.append((b.getBbs_date().toString()));
                       }
                    }


                },
                new Response.ErrorListener(){
                    public void onErrorResponse(VolleyError error){
                        Log.i("jsp","ㅊㅊ error"+error.getMessage()+" "+error.getStackTrace().toString());

                    }


                }){




        };
        /*
        * method > Method.GET
        *
        *
        * */
        requestQueue.add(stringRequest);
        //응답 > 파싱 > 데이터가 잘 출력되는 지 확인


    }


    public void onNewRequest(View v){
        Intent intent=new Intent(getApplicationContext(),BBSInputActivity.class);
        startActivity(intent);
    }
}
