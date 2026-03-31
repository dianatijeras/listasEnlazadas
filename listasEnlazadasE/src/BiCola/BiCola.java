package BiCola;
import Cola.Nodo;

public class BiCola<T> {
    private Cola.Nodo<T> inicio;
    private Cola.Nodo<T> fin;
    private int tam;

    public BiCola(){
        inicio = null;
        fin = null;
        tam = 0;
    }


    /**
     * agregar
     * @param valor
     */
    public void agregarFinal(T valor){
        Cola.Nodo<T> newElement = new Nodo<>(valor);
        if(inicio == null && fin == null && tam == 0){
            inicio = newElement;
            fin = newElement;
        }else{
            fin.setProximo(newElement);
            fin = newElement;
        }
        tam++;
    }

    /**
     * quitar inicio
     */
    public void eliminarInicio(){
        if(!(inicio == null && fin == null && tam == 0)){
            inicio = inicio.getProximo();
            tam--;
        }
    }

    public void agregarInicio(T valor){
        Cola.Nodo<T> newElement = new Nodo<>(valor);
        newElement.setProximo(inicio);
        inicio = newElement;
        tam++;
    }

    public void eliminarFinal(){
        if(tam == 0) {
            return;
        }
        if(inicio == fin) {
            inicio = null;
            fin = null;
        }else{
            Nodo<T> actual = inicio;

            while(actual.getProximo() != fin){
                actual = actual.getProximo();
            }

            actual.setProximo(null);
            fin = actual;
        }
        tam--;
    }
}
