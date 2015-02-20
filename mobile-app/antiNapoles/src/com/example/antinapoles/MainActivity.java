package com.example.antinapoles;

import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	String municipal_name,month,budget,description,total_expenses;
	ListView lv;
	ArrayList<budgetinfo> listinfo = new ArrayList<budgetinfo>();
	
	MyAdapter adapter;
	Button search;
	int stat;
	String municipal;
	String ip;
	 String url;
	EditText searchMunicipal,etIP;
	  private ProgressDialog progressDialog;  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        lv = (ListView) this.findViewById(R.id.listViewsearch);
        search = (Button) this.findViewById(R.id.btnSearch);
        searchMunicipal = (EditText) this.findViewById(R.id.etsearch);
         url = "http://192.168.212.172:8000/infos"; // to add municipal
   
        search.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btnSearch:               	
                    		municipal = searchMunicipal.getText().toString();
                    		
                    		   if(checkInternet()){
                    			   new LoadViewTask().execute();
                    			   new getInfo().execute();    
                    		   }else{
                    			   Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                    		   }
                    		   
                           break;
                }
            }
        }));
     
    }
    
    public void showWebSchedule(){
        try{
           if(listinfo!=null){
        	  // listinfo.add(new budgetinfo("Cebu", "April", "100000.00","calamity funds", "40000.00"));
               adapter = new MyAdapter(getApplicationContext(), listinfo);
               Log.d("adapter", "" + adapter.getCount());
               lv.setAdapter(adapter);
             adapter.notifyDataSetChanged();
           }else{
        	   Toast.makeText(this, "Emty Fields", Toast.LENGTH_SHORT).show();
           }
        }catch (Exception e){ e.printStackTrace(); }
    }

    public void informNoSchedule(){
        Toast.makeText(this, "No Schedule Retrieved", Toast.LENGTH_SHORT).show();
    }

    public class getInfo extends AsyncTask<Void, Void, JSONObject>{
        @SuppressWarnings("rawtypes")
		@Override
        protected JSONObject doInBackground(Void... voids) {
            /*HttpAuthentication authHeader = new HttpAuthentication() {

                @Override
                public String getHeaderValue() {
                    return token;
                }
            };*/
            HttpHeaders requestHeaders = new HttpHeaders();
            //	requestHeaders.setAuthorization(authHeader);
            	requestHeaders.setContentType(new MediaType("application", "json"));
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

            RestTemplate restTemplate = new RestTemplate();

            try {
                HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();

                HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
                //MappingJackson2HttpMessageConverter mpc = new MappingJackson2HttpMessageConverter();

                restTemplate.getMessageConverters().add(formHttpMessageConverter);
                restTemplate.getMessageConverters().add(stringHttpMessageConverternew);
                							
                														
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class); /*restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);*/
                org.springframework.http.HttpStatus status = response.getStatusCode();
                String restCall = response.getBody();
                Log.d("Response Get Body",""+response.getBody());
                stat = status.value();
                checkStat();
                JSONObject jsa = new JSONObject(restCall);
             
                Log.d("asyntask", "async");
                Log.d("JSA",""+jsa);
                return jsa;
            } catch (HttpClientErrorException e) {
                Log.e("error", e.getLocalizedMessage(), e);
                // Handle 401 Unauthorized response
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsa) {
           Log.d("JSA Length", ""+jsa.length());
            //String municipal_name,month,budget,description,total_expenses;
            if(jsa!=null || jsa.length()!=0){
            	String municipal_name,month,budget,description,total_expenses;
                try{
                    for(int i = 0; i<jsa.length(); i++){
            //        municipal_name = jsa.getJSONObject("municipal_name").toString();
                    	int id = jsa.getInt("id");
                      month =jsa.getString("month");
                        budget =jsa.getJSONObject("budget").toString();
                        description = jsa.getJSONObject("expenses").toString();
                    total_expenses =jsa.getJSONObject("amount").toString();
                      
                        budgetinfo b = new budgetinfo("Cebu City",""+month,""+budget,""+description,"WAY BUDGET");
                      //  Log.d("user_id",""+municipal_name);
                        Log.d("Month",""+month);
                        Log.d("Budget",""+budget);
                        Log.d("Balance",""+description);
                //        listinfo.add(b);
                        //db.addLocation(s, 1);
                    }
                    if(listinfo.size()!=0) {
                        showWebSchedule();
                    }
              }catch (JSONException e){e.printStackTrace();}
            }else informNoSchedule();
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
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
                    .setMessage("An internet connection is required to load the map.")
                    .setNeutralButton("OK", null).create().show();
        }
        return isConnected;
    }
    public void checkStat(){
        switch (stat){
            case 200:
            	//	Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show();
            		Log.d("SUCCESS","");
                break;
       
            case 401:
                Toast.makeText(getApplicationContext(), "Invalid email and password", Toast.LENGTH_SHORT).show();
                break;
            case 500:
            		Toast.makeText(this, "Internal Error", Toast.LENGTH_SHORT).show();
        }
    }
    private class LoadViewTask extends AsyncTask<Void, Integer, Void>  
   	{  
   		        //Before running code in separate thread  
   		        @Override  
   		        protected void onPreExecute()  
   		        {  
   		            //Create a new progress dialog  
   		            /*progressDialog = new ProgressDialog(ScreenLoaderActivity.this);  
   		            //Set the progress dialog to display a horizontal progress bar  
   		            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  
   		            //Set the dialog title to 'Loading...'  
   		            progressDialog.setTitle("Loading...");  
   		            //Set the dialog message to 'Loading application View, please wait...'  
   		            progressDialog.setMessage("Loading application View, please wait...");  
   		            //This dialog can't be canceled by pressing the back key  
   		            progressDialog.setCancelable(false);  
   		            //This dialog isn't indeterminate  
   		            progressDialog.setIndeterminate(false);  
   		            //The maximum number of items is 100  
   		            progressDialog.setMax(100);  
   		            //Set the current progress to zero  
   		            progressDialog.setProgress(0);  
   		            //Display the progress dialog  
   		            progressDialog.show();  */
   		        	progressDialog = ProgressDialog.show(MainActivity.this,"Loading...",  
   		        		    "Loading application View, please wait...", false, false);  
   		        }  
   		  
   		        //The code to be executed in a background thread.  
   		        @Override  
   		        protected Void doInBackground(Void... params)  
   		        {  
   		            /* This is just a code that delays the thread execution 4 times, 
   		             * during 850 milliseconds and updates the current progress. This 
   		             * is where the code that is going to be executed on a background 
   		             * thread must be placed. 
   		             */  
   		            try  
   		            {  
   		                //Get the current thread's token  
   		                synchronized (this)  
   		                {  
   		                    //Initialize an integer (that will act as a counter) to zero  
   		                    int counter = 0;  
   		                    //While the counter is smaller than four  
   		                    while(counter <= 2)  
   		                    {  
   		                        //Wait 850 milliseconds  
   		                        this.wait(500);  
   		                        //Increment the counter  
   		                        counter++;  
   		                        //Set the current progress.  
   		                        //This value is going to be passed to the onProgressUpdate() method.  
   		                        publishProgress(counter*25);  
   		                    }  
   		                }  
   		            }  
   		            catch (InterruptedException e)  
   		            {  
   		                e.printStackTrace();  
   		            }  
   		            return null;  
   		        }  
   		  
   		        //Update the progress  
   		        @Override  
   		        protected void onProgressUpdate(Integer... values)  
   		        {  
   		            //set the current progress of the progress dialog  
   		            progressDialog.setProgress(values[0]);  
   		        }  
   		  
   		        //after executing the code in the thread  
   		        @Override  
   		        protected void onPostExecute(Void result)  
   		        {  
   		         	 progressDialog.dismiss(); 
   		         	
   		        }
   		        
       }
	
}
