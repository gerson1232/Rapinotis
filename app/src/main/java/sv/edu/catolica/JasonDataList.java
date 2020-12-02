package sv.edu.catolica;

public class JasonDataList {


    String titulo;
    String noticia;
    String imagen;

    public JasonDataList(String titulo, String noticia, String imagen) {
        this.titulo = titulo;
        this.noticia = noticia;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public String getImagen() {
        return imagen;
    }
}
