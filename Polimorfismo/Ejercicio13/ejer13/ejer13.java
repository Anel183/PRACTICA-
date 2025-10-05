package Polimorfismo.Ejercicio13.ejer13;
class Cancion {
    private String nombre;
    private String artista;
    private int pesoKb;

    public Cancion(String nombre, String artista, int pesoKb) {
        this.nombre = nombre;
        this.artista = artista;
        this.pesoKb = pesoKb;
    }

    public String getNombre() { return nombre; }
    public String getArtista() { return artista; }
    public int getPesoKb() { return pesoKb; }
}

class Video {
    private String nombre;
    private String artista;
    private int pesoMg;

    public Video(String nombre, String artista, int pesoMg) {
        this.nombre = nombre;
        this.artista = artista;
        this.pesoMg = pesoMg;
    }

    public String getNombre() { return nombre; }
    public int getPesoMg() { return pesoMg; }
}

class MP4 {
    private String marca;
    private double capacidadGb;
    private Cancion[] canciones;
    private int nrCanciones;
    private Video[] videos;
    private int nrVideos;

    public MP4(String marca, double capacidadGb) {
        this.marca = marca;
        this.capacidadGb = capacidadGb;
        this.canciones = new Cancion[100];
        this.nrCanciones = 0;
        this.videos = new Video[3];
        this.nrVideos = 0;
    }

    public Cancion buscarCancion(String nombre, String artista, int pesoKb) {
        for (int i = 0; i < nrCanciones; i++) {
            Cancion c = canciones[i];
            if (c != null &&
                ( (nombre != null && nombre.equals(c.getNombre())) ||
                  (artista != null && artista.equals(c.getArtista())) ||
                  pesoKb > 0 && pesoKb == c.getPesoKb() )) {
                return c;
            }
        }
        return null;
    }
    public Cancion buscarPorNombre(String nombre) { return buscarCancion(nombre, null, 0); }
    public Cancion buscarPorArtista(String artista) { return buscarCancion(null, artista, 0); }
    public Cancion buscarPorPeso(int pesoKb) { return buscarCancion(null, null, pesoKb); }

    public void addCancion(Cancion c) {
        if (buscarCancion(c.getNombre(), null, 0) != null) {
            System.out.println("Canción ya existe: " + c.getNombre());
            return;
        }
        if (nrCanciones < canciones.length) {
            canciones[nrCanciones++] = c;
            System.out.println("Añadida: " + c.getNombre());
        } else {
            System.out.println("MP4 lleno de canciones.");
        }
    }
    public void addVideo(Video v) {
        if (nrVideos < videos.length) {
            videos[nrVideos++] = v;
            System.out.println("Añadido: " + v.getNombre());
        } else {
            System.out.println("MP4 lleno de videos.");
        }
    }

    public void removeCancion(String nombre) {
        for (int i = 0; i < nrCanciones; i++) {
            if (canciones[i] != null && canciones[i].getNombre().equals(nombre)) {
                canciones[i] = null;
                nrCanciones--;
                System.out.println("Removida: " + nombre);
                return;
            }
        }
        System.out.println("Canción no existe: " + nombre);
    }

    public double capacidadDisponible() {
        double usadaMb = 0.0;
        for (int i = 0; i < nrCanciones; i++) {
            if (canciones[i] != null) usadaMb += canciones[i].getPesoKb() / 1024.0;
        }
        for (int i = 0; i < nrVideos; i++) {
            if (videos[i] != null) usadaMb += videos[i].getPesoMg();
        }
        return capacidadGb * 1024 - usadaMb; 
    }

    @Override
    public String toString() {
        return "MP4 -" + marca + ", Capacidad: " + capacidadGb + " GB-";
    }
}

public class ejer13 {
    public static void main(String[] args) {
        MP4 reproductor = new MP4("Sony", 2.0);

        reproductor.addCancion(new Cancion("Back to Black", "Amy Winehouse", 100));
        reproductor.addCancion(new Cancion("Lost On You", "LP", 150));

        reproductor.addVideo(new Video("Heathens", "Twenty One Pilots", 50));
        reproductor.addVideo(new Video("Harmonica Andromeda", "KSHMR", 70));
        reproductor.addVideo(new Video("Without Me", "Halsey", 30));

        System.out.println(reproductor);
        Cancion encontrada = reproductor.buscarPorNombre("Back to Black");
        if (encontrada != null) System.out.println("Encontrada: " + encontrada.getNombre());

        reproductor.addCancion(new Cancion("Nueva Canción", "Nuevo Artista", 200));

        reproductor.removeCancion("Back to Black");

        System.out.println("Capacidad disponible: " + reproductor.capacidadDisponible() + " MB");
    }
}