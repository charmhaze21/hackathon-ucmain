package com.example.antinapoles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class login extends ActionBarActivity {
    EditText etemail, etpassword;
    Button btn, back;
    String email, password;
    Boolean check;
    int stat;
    String token = null;//
    String temptoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3Q6ODA4MFwvYXBpXC92MVwvYXV0aFwvYWNjZXNzX3Rva2VuIiwic3ViIjoxMSwiaWF0IjoxNDI0MjExMjQxLCJleHAiOjE0NTA1MDkyNDF9._IcnPtslEjoOQoZTfPohph09iTxdZ6uU1HZJx4UKTFA";
    String bearer = "Bearer ";
   // MyDatabase db;
    Resources res;
    String ip,myip;
    String url;
    EditText etIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        res = getResources();
    //    ip = res.getString(R.string.ip_address);
     //   db = new MyDatabase(this);
        etIP = new EditText(this);
        etIP.setText("http://");
        //if(db.checkip()!=999){
            new AlertDialog.Builder(this)
                    .setMessage("Enter server IP address")
                    .setTitle("IP Address")
                    .setView(etIP)
                    .setCancelable(false)
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub

                            if (!etIP.getText().toString().equals("")) {
                            	myip = etIP.getText().toString();
                                dialog.dismiss();
                            } else
                                Toast.makeText(getApplicationContext(), "Please enter IP address!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        //}

     /*   int tokenCheck = 0;
        try {
            tokenCheck =db.checkToken();
        }catch (Exception e){ e.printStackTrace();}
        if(tokenCheck>0){
            Intent intent = new Intent(this, feature_enabler.class);
            this.startActivity(intent);
        }
*/        etemail= (EditText) this.findViewById(R.id.etEmail);
        etpassword = (EditText) this.findViewById(R.id.etPassword);
        back = (Button) this.findViewById(R.id.btnLoginBack);
        btn = (Button) this.findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip = myip;
                url = ip+"/api/v1/auth/access_token";
                email = etemail.getText().toString();
                password = etpassword.getText().toString();
                if(checkInternet())
                    new userLogin().execute();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent loginIntent = new Intent(login.this, registration.class);
               // login.this.startActivity(loginIntent);
                login.this.finish();
            }
        });

    }

    public void checkStat(){
        switch (stat){
            case 200:
                token = bearer+" "+token;
                if(token.equals(temptoken)){
              //  db.insertToken(token);
                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                		intent.putExtra("token",token);
                		intent.putExtra("ip",ip);
                this.startActivity(intent);
                this.finish();;
                break;
                }
            case 401:
                Toast.makeText(getApplicationContext(), "Invalid email and password", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public boolean checkInternet(){
        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(!isConnected){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Internet Connection Error")
                    .setMessage("Unable to Connect.")
                    .setNeutralButton("OK", null).create().show();
        }
        return isConnected;
    }

    public class userLogin extends AsyncTask<Void, Void, Boolean>{


        @Override
        protected Boolean doInBackground(Void... voids){
            try {
                Log.d("async", "async");
                RestTemplate restTemplate = new RestTemplate();
                HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();

                HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
                //MappingJackson2HttpMessageConverter mpc = new MappingJackson2HttpMessageConverter();

                restTemplate.getMessageConverters().add(formHttpMessageConverter);
                restTemplate.getMessageConverters().add(stringHttpMessageConverternew);
//                restTemplate.getMessageConverters().add(mpc);

                MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
                map.add("email", email);
                map.add("password", password);

                ResponseEntity<String> response = restTemplate.postForEntity(url, map, String.class);
                org.springframework.http.HttpStatus status = response.getStatusCode();
                String restCall = response.getBody();
                JSONObject jso = new JSONObject(restCall);
                stat = status.value();
                token = jso.getString("token");
                bearer = "Bearer ";
                checkStat();
                Log.d("token", token);
                Log.d("response", restCall);
                Log.d("status", ""+status);
                Log.d("responseentity", ""+response);
                Log.d("statusint", ""+stat);

                Log.d("async end", "async end");
            } catch (HttpClientErrorException e){ e.printStackTrace();
                e.getStatusCode();
            } catch(Exception e){ e.printStackTrace(); }
              return false;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            check = aBoolean;
            checkStat();
        }
    }
}
