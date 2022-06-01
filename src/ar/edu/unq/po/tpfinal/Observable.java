package ar.edu.unq.po.tpfinal;

public interface Observable {
	public void attach(ActualizadorDeCategoria observer);

	public void dettach();

	public void notificar();

}
