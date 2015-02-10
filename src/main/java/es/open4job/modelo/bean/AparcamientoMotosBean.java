package es.open4job.modelo.bean;


public class AparcamientoMotosBean {

	private double latitud;
	private double longitud;
	private String title;
	private String icon;
	private String descripcion;
	private String lastUpdated;
	private int plazas;
	private int id;

	public AparcamientoMotosBean(double latitud, double longitud, String title,
			String icon, String descripcion, String lastUpdated, int plazas,
			int id) {

		this.latitud = latitud;
		this.longitud = longitud;
		this.title = title;
		this.icon = icon;
		this.descripcion = descripcion;
		this.lastUpdated = lastUpdated;
		this.plazas = plazas;
		this.id = id;

	}
	public AparcamientoMotosBean(){
		super();
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return ("AparcamientoMotoVO = [ " + "latitud = " + latitud + ", "
				+ "longitud = " + longitud + ", " + "title = " + title + ", "
				+ "icon = " + icon + ", " + "descripcion = " + descripcion
				+ ", " + "lastUpdate = " + lastUpdated + ", " + " plazas = "
				+ plazas + ", " + "id = " + id + ", ");
	}

}
