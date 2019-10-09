package controller;

import java.io.IOException;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller 
{
	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;


	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 * @throws IOException 
	 */
	public Controller () throws IOException
	{
		modelo = new MVCModelo();
		view = new MVCView();
	}

	public void run() throws IOException
	{
		view.printInfoCarga(modelo.getViajesSemana1(), modelo.getViajesSemana2(), modelo.getViajesSemana3(), modelo.getViajesSemana4());
		view.printMensaje(Integer.toString(modelo.poblarSeparateChaining(view.printPoblarSeparateChaining()).N));
		
	
	}
}
