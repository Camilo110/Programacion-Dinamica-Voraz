package PF_FADA;

import java.util.ArrayList;

public class PF_dinamica {
	
	public void Metodo (int n,int[] meses,double ci,double cu, double cv, int u,int m) {
		ArrayList<ArrayList<Nodo>> Etapas = new ArrayList<>();
		ArrayList<Nodo> primeraEtapa = new ArrayList<>();
		primeraEtapa.add(new Nodo(0,0,0,0,0));
		Etapas.add(primeraEtapa);
		for(int i=0;i<n-1;i++) {
			Etapas.add(CrearNodo(m,meses[i]));
		}
		ArrayList<Nodo> ultimaEtapa = new ArrayList<>();
		ultimaEtapa.add(new Nodo(meses[n-1],0,0,0,0));
		Etapas.add(ultimaEtapa);
		
		for(int i=Etapas.size()-1;i>0;i--) {
			ArrayList<Nodo> Lista1 =Etapas.get(i-1);
			ArrayList<Nodo> Lista2 =Etapas.get(i);
			System.out.println(" i " + i + "--" + Etapas.size());
			for(int k=0;k<Lista1.size();k++) {
				double min=Double.POSITIVE_INFINITY;
				System.out.println(" k " + k + "--" + Lista1.size());
                                int proximo=0;
				for(int z=0;z<Lista2.size();z++) {
					System.out.println(z + " --- " + Lista2.size() +" --- " );
					double costo=Ccosto(Lista2.get(z).getuActuales(),Lista1.get(k).getCapInv(),ci,cu,cv,u) + Lista2.get(z).getcAcumulado() ;
					int uProduccion = Lista2.get(z).getuActuales()- Lista1.get(k).getCapInv();
                                        
                                        if(uProduccion>=0 && uProduccion<=u && min>costo) {
						min = Math.min(costo,min);
                                                proximo = z;
					}
                                        
					System.out.println("1antes ----------------------------------------------- " +Lista1.get(k).getcAcumulado());
					Lista1.get(k).setcAcumulado(min);
					System.out.println("1despues " + Lista1.get(k).getcAcumulado());
					System.out.println("2antes " + Lista1.get(k).getProxNodo());
					Lista1.get(k).setProxNodo(proximo);
					System.out.println("2despues " + Lista1.get(k).getProxNodo());
					System.out.println("3antes " +Lista1.get(k).getProducir());
					Lista1.get(k).setProducir(Lista2.get(proximo).getuActuales() - Lista1.get(k).getCapInv());
					System.out.println("3despuess " +Lista1.get(k).getProducir());
				}
				
			}
		}
		Resultado(Etapas);
	}

	public double Ccosto(int uActuales, int capInv,double ci,double cu, double cv, int u) {
		double aux= uActuales-capInv;
			
				if(aux==0) {
					return capInv*cv;
				}else {
					return (ci + (aux*cu) + (capInv*cv));
				}
			}
//idea de la parte dificil
//for(int k=0;k<Lista1.size();k++) {
//	double min=Ccosto(Lista2.get(0).getuActuales(),Lista1.get(k).getCapInv(),ci,cu,cv,u) + Lista2.get(0).getcAcumulado() ;
//	int proximo=0;
//	System.out.println(" k " + k + "--" + Lista1.size());
//	for(int z=1;z<Lista2.size();z++) {
//		System.out.println(z + " --- " + Lista2.size() +" --- " );
//		double costo=Ccosto(Lista2.get(z).getuActuales(),Lista1.get(k).getCapInv(),ci,cu,cv,u) + Lista2.get(z).getcAcumulado() ;
//		double aux= Lista2.get(z).getuActuales()-Lista1.get(k).getCapInv();
//		if(costo<min) {
//			min = costo;
//			proximo = z;
//		}
////
	
	
	
//
//	public double Ccosto(int uActuales, int capInv,double ci,double cu, double cv, int u) {
//		double aux= uActuales-capInv;
//			if(aux<0 || aux>u) {
//				return Double.POSITIVE_INFINITY;
//			}else {
//				if(aux==0) {
//					return capInv*cv;
//				}else {
//					return (ci + (aux*cu) + (capInv*cv));
//				}
//			}
//	}
	
	public ArrayList<Nodo> CrearNodo(int inv, int demanda) {
		ArrayList<Nodo> aux =new ArrayList<Nodo>();
		for(int i=0;i<=inv;i++) {
			aux.add(new Nodo(i+demanda,0,0,i,0));
		}
		return aux;
	}
	public void Resultado(ArrayList<ArrayList<Nodo>> etapas) {
		double costoTotal = etapas.get(0).get(0).getcAcumulado();
		int prox=0;
		int[] result = new int[etapas.size()-1];
		for (int i = 0; i < etapas.size()-1; i++) {
			result[i]=etapas.get(i).get(prox).getProducir();
			prox=etapas.get(i).get(prox).getProxNodo();
		}
		String aux2 = "";
		for(int i =0;i<result.length;i++) {
			aux2 += result[i] + ",";
		}
		System.out.print("el costo es: " + costoTotal + " y la produccion mesual es: " + aux2 );
		
	}

	public static void main(String[] args) {
		PF_dinamica p = new PF_dinamica();
		int[] result = {1,3,2,4};
		p.Metodo(4,result ,3.0, 1.0,0.5,10,9);
	}

}
