package view;

import java.util.*;


public class MVCView 
{
	Scanner lector;
	
	public MVCView()
	{
		lector = new Scanner(System.in);
	}
	
	
	public void printMensaje(String mensaje)
	{
		System.out.print(mensaje);
	}
	
	

}
