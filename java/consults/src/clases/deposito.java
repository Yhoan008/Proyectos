package clases;

public class deposito extends clasep{

    @Override
    public void Transacciones(){

        System.out.print("Cuanto deseas Depositar:   ");
        Deposito();


        transacciones = getSaldo();
        setSaldo(transacciones+deposito);
        System.out.println("--------------------");
        System.out.println("Depositaste:  "+deposito);
        System.out.println("Tu saldo actual es:  "+getSaldo());
        System.out.println("--------------------");
    }
    
}
