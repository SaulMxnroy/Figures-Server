package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	
	Scanner input = new Scanner(System.in);
	
    public static void main(String[] arg){
        Client client = new Client();
        client.connectServer();
    }

    private void connectServer() {
        try {
        	
            double perimetro, area, lado, base, altura, radio;
            int figure;

            Registry registro = LocateRegistry.getRegistry("localhost", 7777);
            Calculations interfaz = (Calculations) registro.lookup("RemoteServer");
            
            System.out.println("Elija una figura: \n"
            		+ "1.-Cuadrado\n"
            		+ "2.-Rectángulo\n"
            		+ "3.-Triángulo\n"
            		+ "4.-Círculo\n");
            figure = input.nextInt();
            
            switch (figure) {
            
            case 1: //cuadrado
            	System.out.println("Ingrese la medida del lado: ");
                lado = input.nextDouble();
                
                perimetro = interfaz.perimetro_cuadrado(lado);
                area = interfaz.area_cuadrado(lado);
                System.out.println("El perimetro es: " + perimetro);
                System.out.println("El area es: " + area);
                
            	break;
            case 2: //rectángulo
            	System.out.println("Ingrese la medida de la base: ");
                base = input.nextDouble();
                System.out.println("Ingrese la medida de la altura: ");
                altura = input.nextDouble();
                
                perimetro = interfaz.perimetro_rectangulo(base, altura);
                area = interfaz.area_rectangulo(base, altura);
                System.out.println("El perimetro es: " + perimetro);
                System.out.println("El area es: " + area);
                
            	break;
            case 3://triángulo
            	System.out.println("Ingrese la medida de la base: ");
                base = input.nextDouble();
                System.out.println("Ingrese la medida de la altura: ");
                altura = input.nextDouble();
                
                perimetro = interfaz.perimetro_triangulo(base);
                area = interfaz.area_triangulo(base, altura);
                System.out.println("El perimetro es: " + perimetro);
                System.out.println("El area es: " + area);
                
            	break;
            case 4://círculo
            	System.out.println("Ingrese la medida del diámetro: ");
                radio = input.nextDouble() / 2;
                
                perimetro = interfaz.perimetro_circulo(radio);
                area = interfaz.area_circulo(radio);
                System.out.println("El perimetro es: " + perimetro);
                System.out.println("El area es: " + area);
                
            	break;
            	
            }
    
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}
