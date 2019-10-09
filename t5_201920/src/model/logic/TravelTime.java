package model.logic;

public class TravelTime implements Comparable<TravelTime>
{

	//-----------------------------
	// Atributos
	//-----------------------------
	
	// es el trimestre del aÃ±o del viaje
	private int trimestre;
	
	//es la zona de origen
	private int sourceid;
	
	//es la zona destino
	private int distid;
	
	//es el dia de la semana
	private int dow;
	
	//es el tiempo promedio de viaje entre las dos zonas
	private double mean_travel_time;
	
	//es la desviacioÌ�n estaÌ�ndar de los tiempos de viaje
	private double standard_deviation_travel_time;

	
	//-----------------------------
	// Constructor
	//-----------------------------
	/**
	 * Metodo constructor de la clase TravelTime
	 * @param trimestre El trimestre del aÃ±o del viaje. trimestre == 1 || trimestre == 2
	 * @param sourceid La zona de origen source. sourceid > 0
	 * @param distid La zona destino. distid > 0  
	 * @param dow El dÃ­a de la semana. hod dow > 0 && dow < 8
	 * @param mean_travel_time El tiempo promedio de viaje entre las dos zonas. mean_travel_time > 0
	 * @param standard_deviation_travel_time La desviacioÌ�n estaÌ�ndar de los tiempos de viaje. standar_deviation_travel_time > 0
	 */
	public TravelTime(int trimestre, int sourceid, int distid, int dow, double mean_travel_time,
			double standard_deviation_travel_time) 
	{
		this.trimestre = trimestre;
		this.sourceid = sourceid;
		this.distid = distid;
		this.dow = dow;
		this.mean_travel_time = mean_travel_time;
		this.standard_deviation_travel_time = standard_deviation_travel_time;
	}


	//-----------------------------
	// Metodos getters
	//-----------------------------

	public int getTrimestre()
	{
		return trimestre;
	}
	
	public int getSourceid() {
		return sourceid;
	}
	
	public int getDistid() {
		return distid;
	}
	
	public int getDow() {
		return dow;
	}

	public double getMean_travel_time() {
		return mean_travel_time;
	}
	
	public double getStandard_deviation_travel_time() {
		return standard_deviation_travel_time;
	}

	//-----------------------------
	// Metodos de funcionamiento 
	//-----------------------------
	public int compareTo(TravelTime o) 
	{
		if(this.mean_travel_time > o.mean_travel_time)
			return 1;
		else if(this.mean_travel_time < o.mean_travel_time)
			return -1;
		return 0;
	}


}
