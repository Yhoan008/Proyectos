package clases;
import java.util.Scanner;

public abstract class clasep {

    protected int transacciones,retiro,deposito;
    private static int saldo;
    Scanner entrada = new Scanner(System.in);

    public void operaciones(){
        int bandera = 0;
        int seleccion = 0;
        do{
            do{
                System.out.println("POR FAVOR SELECCIONE UNA OPCION");
                System.out.println("    1. Consulta de saldo");
                System.out.println("    2. Retiro de Efectivo");
                System.out.println("    3. Deposito de Efectivo");
                System.out.println("    4. Salir");
                seleccion = entrada.nextInt() ;

                if (seleccion >= 1 && seleccion <= 4){
                    bandera=1;
                }else{
                    System.out.print("----------------------");
                    System.out.print("Opcion no valida, vuelva a intentar");
                    System.out.print("----------------------");

                } 
            }while(bandera == 0);

            if (seleccion==1){
                clasep mens = new consulta();
                mens.Transacciones();
            }else if(seleccion==2){
                clasep mens = new retiro();
                mens.Transacciones();
            }else if(seleccion==3){
                clasep mens = new deposito();
                mens.Transacciones();
            }else if(seleccion==4){
                System.out.println("----------------------");
                System.out.println("!Gracias!, vuelva pronto");
                System.out.println("----------------------");
                bandera=2;
            }
        }while (bandera != 2);
    }

    public void Retiro(){
        retiro = entrada.nextInt();
    }
    public void Deposito(){
        deposito = entrada.nextInt();
    }

    public abstract void Transacciones();

    public int getSaldo(){
        return saldo;
    }
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
}
