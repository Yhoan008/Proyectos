package clases;

public class principal {

    public static void main (String[] args){

        //El programa funciona aun si se invoca cualquier clase del metodo abstracto clasep
        //sin embargo no funciona llamando el mismo metodo abstracto

        clasep mens = new consulta();
        mens.setSaldo(1000000);
        mens.operaciones();
    }
    
}
