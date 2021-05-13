package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculations extends Remote {
	
    public double perimetro_cuadrado (double lado1) throws RemoteException, RemoteException;
    public double area_cuadrado (double lado1) throws RemoteException, RemoteException;
    
    public double perimetro_rectangulo (double lado1, double lado2) throws RemoteException, RemoteException;
    public double area_rectangulo (double lado1, double lado2) throws RemoteException, RemoteException;
    
    public double perimetro_triangulo (double lado1) throws RemoteException, RemoteException;
    public double area_triangulo (double lado1, double altura) throws RemoteException, RemoteException;
    
    public double perimetro_circulo (double radio) throws RemoteException, RemoteException;
    public double area_circulo (double radio) throws RemoteException, RemoteException;
}