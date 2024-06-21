import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean exit = false;
        Scanner leer = new Scanner(System.in);
        CheckDivisa check = new CheckDivisa();
        Gson gson = new Gson();


        System.out.println("******* Bienvenido al conversor de divisas! *******");

        while(!exit){

            //Variable de opcion para el switch

            int option;
            System.out.println("******* Seleccione una opción para proceder... *******");

            //Seleccionando la opcion

            System.out.println("1. Dolar estadounidense (USD) a Peso argentino (ARS)");
            System.out.println("2. Peso argentino (ARS) a Dolar estadounidense (USD)");
            System.out.println("3. Dolar estadounidense (USD) a Real brasileño (BRL)");
            System.out.println("4. Real brasileño (BRL) a Dolar estadounidense (USD)");
            System.out.println("5. Dolar estadounidense (USD) a Peso colombiano (COP)");
            System.out.println("6. Peso colombiano (COP) a Boliviano boliviano (BOB)");
            System.out.println("7. Salir");

            System.out.println("------------------------------------------");

            try{
                System.out.print("Digite una opcion: ");
                option = Integer.valueOf(leer.nextLine());

                switch (option){

                    case 1:

                        double valorAConvertir;

                        try{
                            System.out.print("Digite el valor a convertir: ");
                            valorAConvertir = Double.valueOf(leer.nextLine());

                            Conversion conversionUsdToArs = check.realizarConversion("USD", "ARS");
                            check.calcularConversion(conversionUsdToArs, valorAConvertir);
                        } catch (InputMismatchException e){
                            System.out.println("Algo salio mal - " + e.getMessage());
                        }

                        break;

                    case 2:

                        try{
                            System.out.print("Digite el valor a convertir: ");
                            valorAConvertir = Double.valueOf(leer.nextLine());

                            Conversion conversionArsToUsd = check.realizarConversion("ARS", "USD");
                            check.calcularConversion(conversionArsToUsd, valorAConvertir);
                        } catch (InputMismatchException e){
                            System.out.println("Algo salio mal - " + e.getMessage());
                        }

                        break;
                    case 3:

                        try{
                            System.out.print("Digite el valor a convertir: ");
                            valorAConvertir = Double.valueOf(leer.nextLine());

                            Conversion conversionUsdToBrl = check.realizarConversion("USD", "BRL");
                            check.calcularConversion(conversionUsdToBrl, valorAConvertir);
                        } catch (InputMismatchException e){
                            System.out.println("Algo salio mal - " + e.getMessage());
                        }

                        break;
                    case 4:

                        try{
                            System.out.print("Digite el valor a convertir: ");
                            valorAConvertir = Double.valueOf(leer.nextLine());

                            Conversion conversionBrlToUsd = check.realizarConversion("BRL", "USD");
                            check.calcularConversion(conversionBrlToUsd, valorAConvertir);
                        } catch (InputMismatchException e){
                            System.out.println("Algo salio mal - " + e.getMessage());
                        }

                        break;
                    case 5:

                        try{
                            System.out.print("Digite el valor a convertir: ");
                            valorAConvertir = Double.valueOf(leer.nextLine());

                            Conversion conversionUsdToCop = check.realizarConversion("USD", "COP");
                            check.calcularConversion(conversionUsdToCop, valorAConvertir);
                        } catch (InputMismatchException e){
                            System.out.println("Algo salio mal - " + e.getMessage());
                        }

                        break;
                    case 6:

                        try{
                            System.out.print("Digite el valor a convertir: ");
                            valorAConvertir = Double.valueOf(leer.nextLine());

                            Conversion conversionCopToBob = check.realizarConversion("COP", "BOB");
                            check.calcularConversion(conversionCopToBob, valorAConvertir);
                        } catch (InputMismatchException e){
                            System.out.println("Algo salio mal - " + e.getMessage());
                        }

                        break;
                    case 7:
                        exit = true;
                        break;

                }

            } catch (NumberFormatException e){
                System.out.println("\nAlgo salio mal - " + e.getMessage() + "\n");
            }



        }
    }
}