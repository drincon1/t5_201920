package controller;

import java.io.IOException;
import java.util.Scanner;

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
	 */
	public Controller ()
	{
		modelo = new MVCModelo();
		view = new MVCView();
	}

	public void run() throws IOException
	{

	}
}
