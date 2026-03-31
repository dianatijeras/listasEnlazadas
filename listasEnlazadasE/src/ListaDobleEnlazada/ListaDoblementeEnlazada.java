package ListaDobleEnlazada;

public class ListaDoblementeEnlazada<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int tam;

    public ListaDoblementeEnlazada(int tam) {
        inicio = null;
        fin = null;
        this.tam = 0;
    }

    /**
     * agregar al inicio
     * @param valor
     */
    public void agregarInicio(T valor){
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setProximo(inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }

        tam++;
    }

    /**
     * agregar al final
     * @param valor
     */
    public void agregarFinal(T valor){
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if(fin == null){
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }

        tam++;
    }

    /**
     * eliminar un elemento al inicio de la lista
     */
    public void eliminarInicio(){
        if(inicio == null){
            return;
        }

        if(inicio == fin){
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }

        tam--;
    }

    /**
     * eliminar un elemento al final de la lista
     */
    public void eliminarFinal(){
        if(fin == null){
            return;
        }

        if(inicio == fin){
            inicio = null;
            fin = null;
        } else {
            fin = fin.getAnterior();
            fin.setProximo(null);
        }

        tam--;
    }
}
