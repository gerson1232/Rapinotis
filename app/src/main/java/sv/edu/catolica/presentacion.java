package sv.edu.catolica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import sv.edu.catolica.adapter.RecyclerAdapter;
import sv.edu.catolica.model.Itemlis;

public class presentacion extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener{
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<Itemlis> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        Llenar();
        initViews();
        initvalues();
    }

    private void initvalues(){
        LinearLayoutManager manager =new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);
        items = getItems();
        adapter= new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);


    }

    private void initViews() {
        rvLista =findViewById(R.id.rvLista);
    }
    private List<Itemlis> getItems() {
        List<Itemlis> itemLists = new ArrayList<>();
        itemLists.add(new Itemlis("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", R.drawable.deportes));

        return itemLists;
    }
    @Override
    public void itemClick(Itemlis item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
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