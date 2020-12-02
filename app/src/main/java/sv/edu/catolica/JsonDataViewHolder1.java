package sv.edu.catolica;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JsonDataViewHolder1 extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView txttitulo,txtnoticia;




    public JsonDataViewHolder1(@NonNull View itemView) {


        super(itemView);
        imageView = itemView.findViewById(R.id.imgItem);
        txttitulo = itemView.findViewById(R.id.tvTitulo);
        txtnoticia = itemView.findViewById(R.id.tvNoticia);


    }
}
