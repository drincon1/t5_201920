package view;

import java.util.*;

import model.data_structures.*;
import model.logic.TravelTime;


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

	public void printInfoCarga(ListaDoblementeEncadenada<TravelTime>...viaje)
	{
		for(int i = 0; i < viaje.length; i++)
		{
			System.out.println("\n************** SEMANA " + (i+1) + " **************");
			System.out.println("Número de viajes en la semana " + (i+1) +": " + viaje[i].darTamano() + "\nInformacion primer viaje de la semana " + (i+1));
			System.out.println("Zona Origen: " + viaje[i].darPrimero().elemento.getSourceid());
			System.out.println("Zona Destino: "+ viaje[i].darPrimero().elemento.getDistid());
			System.out.println("Dia: " + viaje[i].darPrimero().elemento.getDow());
			System.out.println("Tiempo Promedio: " + viaje[i].darPrimero().elemento.getMean_travel_time());
			System.out.println("\nInformacion último viaje de la semana " + (i+1));
			System.out.println("Zona Origen: " + viaje[i].darUltimo().elemento.getSourceid());
			System.out.println("Zona Destino: "+ viaje[i].darUltimo().elemento.getDistid());
			System.out.println("Dia: " + viaje[i].darUltimo().elemento.getDow());
			System.out.println("Tiempo Promedio: " + viaje[i].darUltimo().elemento.getMean_travel_time());
		}
	}

}
