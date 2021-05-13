package main;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class RMIFigureServer extends UnicastRemoteObject implements Calculations{

    public RMIFigureServer() throws RemoteException {
        super();
    }

    @Override
    public double perimetro_cuadrado (double lado1) throws RemoteException, RemoteException {
    	return lado1 * 4;
    }
    @Override
    public double area_cuadrado (double lado1) throws RemoteException, RemoteException{
    	return lado1 * lado1;
    }
    @Override
    public double perimetro_rectangulo (double lado1, double lado2) throws RemoteException, RemoteException{
    	return lado1 * 2 + lado2 * 2;
    }
    @Override
    public double area_rectangulo (double lado1, double lado2) throws RemoteException, RemoteException{
    	return lado1 * lado2;
    }
    @Override
    public double perimetro_triangulo (double lado1) throws RemoteException, RemoteException{
    	return lado1 * 3;
    }
    @Override
    public double area_triangulo (double lado1, double altura) throws RemoteException, RemoteException{
    	return lado1 * altura / 2;
    }
    @Override
    public double perimetro_circulo (double radio) throws RemoteException, RemoteException{
    	return 2 * Math.PI * radio;
    }
    @Override
    public double area_circulo (double radio) throws RemoteException, RemoteException{
    	return Math.PI * (radio * radio);
    }
   
    public static void main(String[] args){
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemoteServer", new RMIFigureServer());
            System.out.println("Server is running");
        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}