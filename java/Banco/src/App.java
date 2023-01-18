


import java.util.*;

public class App{

    
    public static void main(String[] args) {
        ArrayList<String> cadena=new ArrayList<String>();

        cadena.add("hola");
    }

    class Objeto{

        String nombre;
        String edad;

        public Objeto(String nombre, String edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "Objeto [edad=" + edad + ", nombre=" + nombre + "]";
        }
        
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getEdad() {
            return edad;
        }
        public void setEdad(String edad) {
            this.edad = edad;
        }

    }
}
