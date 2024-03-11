package PF_FADA;
public class Nodo {
	int uActuales,proxNodo,capInv,producir;
	double cAcumulado;
	public Nodo(int uActuales, double cAcumulado, int proxNodo, int capInv, int producir) {
		super();
		this.uActuales = uActuales;
		this.cAcumulado = cAcumulado;
		this.proxNodo = proxNodo;
		this.capInv = capInv;
		this.producir = producir;
	}

	
	public int getuActuales() {
		return uActuales;
	}

	public void setuActuales(int uActuales) {
		this.uActuales = uActuales;
	}

	public double getcAcumulado() {
		return cAcumulado;
	}

	public void setcAcumulado(double cAcumulado) {
		this.cAcumulado = cAcumulado;
	}

	public int getProxNodo() {
		return proxNodo;
	}

	public void setProxNodo(int proxNodo) {
		this.proxNodo = proxNodo;
	}

	public int getCapInv() {
		return capInv;
	}

	public void setCapInv(int capInv) {
		this.capInv = capInv;
	}

	public int getProducir() {
		return producir;
	}

	public void setProducir(int producir) {
		this.producir = producir;
	}

	

}
 

