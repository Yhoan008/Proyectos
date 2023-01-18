import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

public class App {
    public static void main(String[] args) {

        App app=new App();
        
    }

    public App(){
        Des();
    }

    public void Des(){
        
        String ruta="./Archivo.dat";

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(ruta));

            Type ListType=new TypeToken<List<Serializado>>(){}.getType();

            List<Serializado> serialRecuperado=new Gson().fromJson(br, ListType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public void Ser(){
        
        List<Serializado> list = Arrays.asList(
            
            new Serializado("name", "apellido", 12),
            new Serializado("Nombre", "perez", 10),
            new Serializado("Andres","Quintero",15)
        
        );
        
    
        String Json= new Gson().toJson(list);    
    
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter("./Archivo.dat"));
    
            br.write(Json);
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static class Serializado {

        String name;
        String apellido;
        int codigo;

        

        @Override
        public String toString() {
            return "Serializado [apellido=" + apellido + ", codigo=" + codigo + ", name=" + name + "]";
        }

        public Serializado(String name, String apellido, int codigo) {
            this.name = name;
            this.apellido = apellido;
            this.codigo = codigo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getApellido() {
            return apellido;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public int getCodigo() {
            return codigo;
        }
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

    }

}

