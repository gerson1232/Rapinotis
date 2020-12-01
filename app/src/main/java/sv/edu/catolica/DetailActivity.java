package sv.edu.catolica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import sv.edu.catolica.model.Itemlis;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgItemDerail;
    private TextView tvtTituloDetail;
    private TextView tvNoticiaDeatil;
    private Itemlis itemDetail;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        initValues();


    }
    private void initView() {
        imgItemDerail= findViewById(R.id.imgItemDetai);
        tvtTituloDetail=findViewById(R.id.tvTituloDetail);
        tvNoticiaDeatil=findViewById(R.id.tvNoticiaDetail);
    }

    private void initValues() {
        itemDetail = (Itemlis) getIntent().getExtras().getSerializable("itemDetail");

        imgItemDerail.setImageResource(itemDetail.getImgResource());
        tvtTituloDetail.setText(itemDetail.getTitulo());
        tvNoticiaDeatil.setText(itemDetail.getNoticias());
    }
}