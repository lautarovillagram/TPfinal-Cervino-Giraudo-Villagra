package ar.edu.unq.po.tpfinal;

public class Organizacion {
	Ubicacion ubicacion;
	TipoDeOrganizacion tipo;
	int cantEmpleados;
	
	public Organizacion(Ubicacion u, TipoDeOrganizacion t, int e) {
		this.setUbicacion(u);
		this.setTipoOrganizacion(t);
		this.setCantEmpleados(e);
	}
	
	// Getters y Setters
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	private void setUbicacion(Ubicacion u) {
		this.ubicacion = u;
	}
	
	public TipoDeOrganizacion getTipoOrganizacion() {
		return tipo;
	}
	private void setTipoOrganizacion(TipoDeOrganizacion t) {
		this.tipo = t;
	}
	
	public int getCantEmpleados() {
		return cantEmpleados;
	}
	private void setCantEmpleados(int e) {
		this.cantEmpleados = e;
	}
}
