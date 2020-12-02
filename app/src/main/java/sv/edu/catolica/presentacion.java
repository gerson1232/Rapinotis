package sv.edu.catolica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TabHost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class presentacion extends AppCompatActivity {
    private RecyclerView rvLista, rvListaInternacionales, rvListaDeportes;
    private RecyclerView.Adapter mAdapter;
    private SearchView svSearch;
    ArrayList<JasonDataList> arrayList;
    ArrayList<JasonDataList1> arrayList1;
    ArrayList<JasonDataList2> arrayList2;
    private final String URL_INTERNACIONALES="http://192.168.1.9:8080/rapiNotis/buscarNoticiaInternacionales.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        rvLista = findViewById(R.id.rvLista);
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvListaInternacionales = findViewById(R.id.rvListaInter);
        rvListaInternacionales.setHasFixedSize(true);
        rvListaInternacionales.setLayoutManager(new LinearLayoutManager(this));
        rvListaDeportes = findViewById(R.id.rvListDeportes);
        rvListaDeportes.setHasFixedSize(true);
        rvListaDeportes.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<JasonDataList>();
        arrayList1 = new ArrayList<JasonDataList1>();
        arrayList2 = new ArrayList<JasonDataList2>();

        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();

        JsonFetchs jsonFetchs = new JsonFetchs();
        jsonFetchs.execute();

        JsonFetchsc jsonFetchsc = new JsonFetchsc();
        jsonFetchsc.execute();


        Llenar();

    }

    public class JsonFetchs extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainfile;


        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.1.9:8080/rapiNotis/buscarNoticia.php");
                httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();

                String line="";
                while ((line=bufferedReader.readLine())!=null ){
                    stringBuffer.append(line);
                }

                mainfile= stringBuffer.toString();

                JSONArray parent = new JSONArray(mainfile);

                 int i = 0;
                 while (i<= parent.length()){
                     JSONObject child = parent.getJSONObject(i);
                     String titulo = child.getString("titulo");
                     String noticia = child.getString("noticia");
                     String img = child.getString("imagen");


                     arrayList.add(new JasonDataList(titulo,noticia,img));
                     i++;
                 }

            }catch (MalformedURLException | JSONException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

          JsonAdapter jsonAdapter = new JsonAdapter(arrayList,getApplicationContext());
            rvLista.setAdapter(jsonAdapter);




        }
    }

    public class JsonFetch extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainfiles;


        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.1.9:8080/rapiNotis/buscarNoticiaInternacionales.php");
                httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();

                String line="";
                while ((line=bufferedReader.readLine())!=null ){
                    stringBuffer.append(line);
                }

                mainfiles= stringBuffer.toString();

                JSONArray parent = new JSONArray(mainfiles);

                int i = 0;
                while (i<= parent.length()){
                    JSONObject child = parent.getJSONObject(i);
                    String titulo = child.getString("titulo");
                    String noticia = child.getString("noticia");
                    String img = child.getString("imagen");


                    arrayList1.add(new JasonDataList1(titulo,noticia,img));
                    i++;
                }

            }catch (MalformedURLException | JSONException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            JsonAdapter1 jsonAdapter1 = new JsonAdapter1(arrayList1,getApplicationContext());
            rvListaInternacionales.setAdapter(jsonAdapter1);




        }
    }

    public class JsonFetchsc extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainfiles;


        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.1.9:8080/rapiNotis/buscarNoticiaDeportes.php");
                httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();

                String line="";
                while ((line=bufferedReader.readLine())!=null ){
                    stringBuffer.append(line);
                }

                mainfiles= stringBuffer.toString();

                JSONArray parent = new JSONArray(mainfiles);

                int i = 0;
                while (i<= parent.length()){
                    JSONObject child = parent.getJSONObject(i);
                    String titulo = child.getString("titulo");
                    String noticia = child.getString("noticia");
                    String img = child.getString("imagen");


                    arrayList2.add(new JasonDataList2(titulo,noticia,img));
                    i++;
                }

            }catch (MalformedURLException | JSONException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            JsonAdapter2 jsonAdapter2 = new JsonAdapter2(arrayList2,getApplicationContext());
            rvListaDeportes.setAdapter(jsonAdapter2);




        }
    }













    public void Llenar(){

        Resources res = getResources();
        TabHost tavControl = findViewById(R.id.miTabHost);
        tavControl.setup();

        TabHost.TabSpec spesifi = tavControl.newTabSpec("Nacionales");
        spesifi.setContent(R.id.tab1);
        spesifi.setIndicator("",res.getDrawable(R.drawable.nacionales));

        tavControl.addTab(spesifi);


        spesifi = tavControl.newTabSpec("Mundiales");
        spesifi.setContent(R.id.tab2);
        spesifi.setIndicator("",res.getDrawable(R.drawable.mundiales));

        tavControl.addTab(spesifi);

        spesifi = tavControl.newTabSpec("Deportes");
        spesifi.setContent(R.id.tab3);
        spesifi.setIndicator("",res.getDrawable(R.drawable.deportes));

        tavControl.addTab(spesifi);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.periodista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.agregar:
                Intent v = new Intent(presentacion.this,MainActivity.class);
                startActivity(v);
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}