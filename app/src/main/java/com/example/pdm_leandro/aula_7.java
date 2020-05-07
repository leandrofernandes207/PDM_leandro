package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class aula_7 extends AppCompatActivity {
    private TextView txtumid,txttemp,txtorv,txtpres;
    private ListView listView;
    String [] de = {"temp","umid","orv","pres"};
    int [] para ={R.id.tvTemp,R.id.tvUmid,R.id.tvPontoOrvalho,R.id.tvPressao};
    List<Map<String,String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_7);
        txtpres = (TextView)findViewById(R.id.tvPressao);
        txttemp = (TextView)findViewById(R.id.tvTemp);
        txtumid = (TextView)findViewById(R.id.tvUmid);
        txtorv = (TextView)findViewById(R.id.tvPontoOrvalho);
    }

    public void btBuscar(View view) {
        list = new ArrayList<>();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://ghelfer.net/la/weather.json", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                String data= new String(response);
                try {
                    loadData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData(String data) throws JSONException {
        JSONObject res = new JSONObject(data);
        JSONArray array = res.getJSONArray("weather");
        double sumTemp = 0,sumUmid = 0,sumPres = 0,sumOrv = 0;
        for (int i = 0; i <array.length() ; i++) {
            JSONObject json = array.getJSONObject(i);
            String temp=json.get("temperature").toString();
            sumTemp+=Double.parseDouble(temp);
            String umid=json.get("humidity").toString();
            sumUmid+=Double.parseDouble(umid);
            String pres=json.get("pressure").toString();
            sumPres+=Double.parseDouble(pres);
            String orv=json.get("dewpoint").toString();
            sumOrv+=Double.parseDouble(orv);

            Map<String,String> mapa = null;
            mapa.put("temp",temp);
            mapa.put("umid",umid);
            mapa.put("orv",orv);
            mapa.put("pres",pres);
            list.add(mapa);
        }
        txttemp.setText(String.valueOf(sumTemp/array.length()));
        txtorv.setText(String.valueOf(sumOrv/array.length()));
        txtumid.setText(String.valueOf(sumUmid/array.length()));
        txtpres.setText(String.valueOf(sumPres/array.length()));
        //SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.);
    }
}
