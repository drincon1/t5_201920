package model.logic;

import java.io.*;

import com.opencsv.CSVReader;

import model.data_structures.ListaDoblementeEncadenada;
import model.data_structures.Nodo;
import model.data_structures.TablaHashSeparateChaining;


public class MVCModelo 
{
	private ListaDoblementeEncadenada<TravelTime> viajesSemana1;
	private ListaDoblementeEncadenada<TravelTime> viajesSemana2;
	private ListaDoblementeEncadenada<TravelTime> viajesSemana3;
	private ListaDoblementeEncadenada<TravelTime> viajesSemana4;

	//---------------------------------
	// Constructor
	//---------------------------------
	public MVCModelo() throws IOException
	{
		viajesSemana1 = new ListaDoblementeEncadenada<TravelTime>();
		viajesSemana2 = new ListaDoblementeEncadenada<TravelTime>();
		viajesSemana3 = new ListaDoblementeEncadenada<TravelTime>();
		viajesSemana4 = new ListaDoblementeEncadenada<TravelTime>();

		loadTravelTimes();
	}

	//---------------------------------
	// Cargar datos
	//---------------------------------
	/**
	 * Metodo que carga los archivos csv
	 * Los archivos que carga son:
	 * @throws IOException Lanza una excepcion si el lector no logra trabajar como debe
	 */
	public void loadTravelTimes() throws IOException 
	{
		String ruta = "./data/bogota-cadastral-2018-1-WeeklyAggregate.csv";
		CSVReader reader = null;

		try
		{
			reader = new CSVReader(new FileReader(ruta));
			String [] nextLine;
			nextLine = reader.readNext();
			while((nextLine = reader.readNext()) != null)
			{
				viajesSemana1.agregar(new TravelTime(1, Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), 
						Integer.parseInt(nextLine[2]), Double.parseDouble(nextLine[3]), Double.parseDouble(nextLine[4])));
			}

			ruta = "./data/bogota-cadastral-2018-2-WeeklyAggregate.csv";
			reader = new CSVReader(new FileReader(ruta));
			nextLine = reader.readNext();
			while((nextLine = reader.readNext()) != null)
			{
				viajesSemana2.agregar(new TravelTime(2, Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), 
						Integer.parseInt(nextLine[2]), Double.parseDouble(nextLine[3]), Double.parseDouble(nextLine[4])));
			}

			ruta = "./data/bogota-cadastral-2018-3-WeeklyAggregate.csv";
			reader = new CSVReader(new FileReader(ruta));
			nextLine = reader.readNext();
			while((nextLine = reader.readNext()) != null)
			{
				viajesSemana3.agregar(new TravelTime(3, Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), 
						Integer.parseInt(nextLine[2]), Double.parseDouble(nextLine[3]), Double.parseDouble(nextLine[4])));
			}

			ruta = "./data/bogota-cadastral-2018-4-WeeklyAggregate.csv";
			reader = new CSVReader(new FileReader(ruta));
			nextLine = reader.readNext();
			while((nextLine = reader.readNext()) != null)
			{
				viajesSemana4.agregar(new TravelTime(4, Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), 
						Integer.parseInt(nextLine[2]), Double.parseDouble(nextLine[3]), Double.parseDouble(nextLine[4])));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			reader.close();
		}
	}

	//---------------------------------
	// Metodos funcionamiento
	//---------------------------------

	public TablaHashSeparateChaining<String, TravelTime> poblarSeparateChaining(int trimestre)
	{
		TablaHashSeparateChaining<String, TravelTime> tablaSC = new TablaHashSeparateChaining<String, TravelTime>();
		ListaDoblementeEncadenada<TravelTime> temporal = null;
		switch(trimestre)
		{
		case 1: temporal = viajesSemana1;
		break;
		case 2: temporal = viajesSemana2;
		break;
		case 3: temporal = viajesSemana3;
		break;
		case 4:  temporal = viajesSemana4;
		break;
		}
		
		Nodo<TravelTime> temp = temporal.darPrimero();
		while(temp != null)
		{
			int trim = temp.elemento.getTrimestre();
			int source = temp.elemento.getSourceid();
			int dest = temp.elemento.getDistid();
			tablaSC.put(Integer.toString(trim)+"-"+Integer.toString(source)+"-"+Integer.toString(dest), temp.darElemento());
		}
		
		return tablaSC;
	}
	
	



	//---------------------------------
	// Metodos getters
	//---------------------------------
	public ListaDoblementeEncadenada<TravelTime> getViajesSemana1() {
		return viajesSemana1;
	}
	public ListaDoblementeEncadenada<TravelTime> getViajesSemana2() {
		return viajesSemana2;
	}
	public ListaDoblementeEncadenada<TravelTime> getViajesSemana3() {
		return viajesSemana3;
	}
	public ListaDoblementeEncadenada<TravelTime> getViajesSemana4() {
		return viajesSemana4;
	}
	




}