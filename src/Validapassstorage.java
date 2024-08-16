import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validapassstorage extends Thread {
    private String password;
    private boolean validez;
    private static List<pass> listapass = new ArrayList<>();


    public Validapassstorage(String password) {
        this.password = password;
    }

    public void run() {
        precargarPasswords();
        String regex = "^(?=(?:[^A-Z]*[A-Z]){2})(?=(?:[^a-z]*[a-z]){3})(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        validez = matcher.matches();
    }

    public boolean validez() {
        return validez;
    }

    public static void main(String[] args) {
        String pass1 = "123456789";
        String pass2 = "EstaContraDeberiaPasar12@"; //Solo esta
        String pass3 = "Hola123";
        String pass4 = "@@@@@@@@@@@@@@@@";
        String pass5 = "aaaaaaaaaaaaaaaaa";
        String pass6 = "EEEEEEEEEEEEEEE";
        String pass7 = "IiIiIiIiIiIiIiIiI";
        String pass8 = "O1O1O1O1O1O1o1O1Oo1o";
        String pass9 = "U@1Pa12@@1lakmzwdmqxqlomxiw1"; //Y esta cumplen los requisitos
        String pass10 = "abcdefghijklmnñopqrstuvwxyz";

        Validapassstorage validador1 = new Validapassstorage(pass1);
        Validapassstorage validador2 = new Validapassstorage(pass2);
        Validapassstorage validador3 = new Validapassstorage(pass3);
        Validapassstorage validador4 = new Validapassstorage(pass4);
        Validapassstorage validador5 = new Validapassstorage(pass5);
        Validapassstorage validador6 = new Validapassstorage(pass6);
        Validapassstorage validador7 = new Validapassstorage(pass7);
        Validapassstorage validador8 = new Validapassstorage(pass8);
        Validapassstorage validador9 = new Validapassstorage(pass9);
        Validapassstorage validador10 = new Validapassstorage(pass10);

        validador1.start();
        validador2.start();
        validador3.start();
        validador4.start();
        validador5.start();
        validador6.start();
        validador7.start();
        validador8.start();
        validador9.start();
        validador10.start();

        try {
            validador1.join();
            validador2.join();
            validador3.join();
            validador4.join();
            validador5.join();
            validador6.join();
            validador7.join();
            validador8.join();
            validador9.join();
            validador10.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La contraseña 1 pasa los requisitos: " + validador1.validez());
        System.out.println("La contraseña 2 pasa los requisitos: " + validador2.validez());
        System.out.println("La contraseña 3 pasa los requisitos: " + validador3.validez());
        System.out.println("La contraseña 4 pasa los requisitos: " + validador4.validez());
        System.out.println("La contraseña 5 pasa los requisitos: " + validador5.validez());
        System.out.println("La contraseña 6 pasa los requisitos: " + validador6.validez());
        System.out.println("La contraseña 7 pasa los requisitos: " + validador7.validez());
        System.out.println("La contraseña 8 pasa los requisitos: " + validador8.validez());
        System.out.println("La contraseña 9 pasa los requisitos: " + validador9.validez());
        System.out.println("La contraseña 10 pasa los requisitos: " + validador10.validez());


        listapass.add(new pass(pass1, validador1.validez));
        listapass.add(new pass(pass2, validador2.validez));
        listapass.add(new pass(pass3, validador3.validez));
        listapass.add(new pass(pass4, validador4.validez));
        listapass.add(new pass(pass5, validador5.validez));
        listapass.add(new pass(pass6, validador6.validez));
        listapass.add(new pass(pass7, validador7.validez));
        listapass.add(new pass(pass8, validador8.validez));
        listapass.add(new pass(pass9, validador9.validez));
        listapass.add(new pass(pass10, validador10.validez));
    }

    private static void precargarPasswords() {
        try {
            BufferedReader archivo = new BufferedReader(new FileReader("passs.dat"));
            String linea;
            while ((linea = archivo.readLine()) != null) {
                List<String> datosPasswords = Arrays.asList(linea.split(","));
                String contra = datosPasswords.get(0);
                boolean resultado = Boolean.parseBoolean(datosPasswords.get(1));
                listapass.add(new pass(contra, resultado));
            }
            archivo.close();
        } catch (IOException e) {
            System.err.println("No existe archivo: e.getMessage()");

        }
    }
}