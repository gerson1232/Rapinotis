package sv.edu.catolica.model;

import java.io.Serializable;

public class Itemlis implements Serializable {
    private String titulo;
    private String Noticias;
    private String Genero;
    private int imgResource;

    public Itemlis(String titulo, String Noticias, int imgResource){
        this.titulo=titulo;
        this.Noticias =Noticias;
        this.imgResource = imgResource;

    }
    public String getTitulo(){
        return titulo;
    }
    public String getNoticias()
    {
        return Noticias;
    }
    public int getImgResource()
    {
        return imgResource;
    }
}