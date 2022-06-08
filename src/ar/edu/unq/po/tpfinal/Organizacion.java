package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class Organizacion implements OrganizacionObserver {
	private Ubicacion ubicacion;
	private TipoDeOrganizacion tipo;
	private int cantEmpleados;
	
	private List<ZonaObservable> observados;
	private FuncionalidadExterna funcionalidadNuevaMuestra;
	private FuncionalidadExterna funcionalidadNuevaVerificacion;
	
	
	public Organizacion(Ubicacion u, TipoDeOrganizacion t, int e, FuncionalidadExterna f1, FuncionalidadExterna f2) {
		this.setUbicacion(u);
		this.setTipoOrganizacion(t);
		this.setCantEmpleados(e);
		this.observados = new ArrayList<ZonaObservable>();
		this.setFuncionalidadNuevaMuestra(f1);
		this.setFuncionalidadNuevaVerificacion(f2);
	}
	
	
	@Override
	public void updateNuevaMuestra(ZonaObservable z, Muestra m) {
		this.getFuncionalidadNuevaMuestra().nuevoEvento(this, (ZonaDeCobertura)z, m);
	}
	
	@Override
	public void updateMuestraVerificada(ZonaObservable z, Muestra m) {
		this.getFuncionalidadNuevaVerificacion().nuevoEvento(this, (ZonaDeCobertura)z, m);
	}
	
	// Permite a una organizacion suscribirse a una ZonaDeCobertura
	public void suscribirse(ZonaObservable observable) {
		this.getObservados().add(observable);
		observable.addObserver(this);
	}
	
	// Permite a una organizacion desuscribirse a una ZonaDeCobertura
	public void desuscribirse(ZonaObservable observable) {
		this.getObservados().remove(observable);
		observable.deleteObserver(this);
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
	
	public List<ZonaObservable> getObservados() {
		return observados;
	}

	public FuncionalidadExterna getFuncionalidadNuevaMuestra() {
		return funcionalidadNuevaMuestra;
	}
	public void setFuncionalidadNuevaMuestra(FuncionalidadExterna funcionalidadNuevaMuestra) {
		this.funcionalidadNuevaMuestra = funcionalidadNuevaMuestra;
	}


	public FuncionalidadExterna getFuncionalidadNuevaVerificacion() {
		return funcionalidadNuevaVerificacion;
	}
	public void setFuncionalidadNuevaVerificacion(FuncionalidadExterna funcionalidadNuevaVerificacion) {
		this.funcionalidadNuevaVerificacion = funcionalidadNuevaVerificacion;
	}
}
