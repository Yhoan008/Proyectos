import javax.crypto.*;
import javax.crypto.spec.*;

public class App {
    public static void main(String[] args) throws Exception {
        String claveInsegura= "1234" ;

        for (int i=0;i<=10;i++){
            setCifrado(claveInsegura);
            byte[] claveSegura = getCifrado();
            System.out.println(claveSegura);
        }
    }

    public static void setCifrado(String key){
        String clave = key;

        byte[] keyData = clave.getBytes();

        SecretKeySpec ks = new SecretKeySpec(keyData, "Blowfish");

        try{
            Cipher cp = Cipher.getInstance("Blowfish");

            cp.init(Cipher.ENCRYPT_MODE,ks);

            secureKey = cp.doFinal(clave.getBytes());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static byte[] getCifrado(){
        return secureKey;
    }

    private static byte[] secureKey;
}
