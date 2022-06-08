package ar.edu.unq.po.tpfinal;

public interface OrganizacionObserver {
	public void updateNuevaMuestra(ZonaObservable z, Muestra m);
	public void updateMuestraVerificada(ZonaObservable z, Muestra m);
}
