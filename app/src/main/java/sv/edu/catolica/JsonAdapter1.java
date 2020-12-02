package sv.edu.catolica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JsonAdapter1 extends RecyclerView.Adapter <JsonDataViewHolder>{

    ArrayList<JasonDataList1> list;
    Context context;

    public JsonAdapter1(ArrayList<JasonDataList1> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public JsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vie = LayoutInflater.from(context).inflate(R.layout.item_list_view1,parent,false);



        return new JsonDataViewHolder(vie);

    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataViewHolder holder, int position) {
        JasonDataList1 currentData = list.get(position);

        holder.txttitulo.setText(currentData.getTitulo());
        holder.txtnoticia.setText(currentData.getNoticia());

        Picasso.get().load(currentData.getImagen()).into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
