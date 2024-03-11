package PF_FADA;

public class PF_voraz {
    
    public void Metodo (int n,int[] meses,double ci,double cu, double cv, int u,int m) {
        int inv = 0;
        int costo = 0;
        int[] listaResult = new int[n];
        for (int i = 0; i < meses.length; i++) {
            if(meses[i] > inv){
                int producir = Math.min(u, meses[i]-inv);
                costo += ci+(producir+ cu)+(cv * inv);
                listaResult[i] = producir;
                inv = producir + inv - meses[i];
            }else{
                listaResult[i] = 0;
                costo += (inv * cv);
                inv -= meses[i];
            }
        }
    }
    
    
    
    
    
}
