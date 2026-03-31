package PriorityQueue;

public class PriorityQueue<T> {
    private Nodo<T> inicio;
    private int tam;

    public PriorityQueue() {
        this.inicio = null;
        this.tam = 0;
    }

    /**
     * agregar a al cola de prioridad
     * @param valor
     * @param prioridad
     */
    public void agregar(T valor, int prioridad){
        Nodo<T> nuevo = new Nodo<>(valor, prioridad);

        //si esta vacia
        if(inicio == null){
            inicio = nuevo;
        }
        //verifica prioridad
        else if(prioridad > inicio.getPrioridad()){
            nuevo.setProximo(inicio);
            inicio = nuevo;
        }
        else{
            Nodo<T> actual = inicio;

            while(actual.getProximo() != null &&
                    actual.getProximo().getPrioridad() >= prioridad){
                actual = actual.getProximo();
            }

            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
        }

        tam++;
    }

    /**
     * eliminar de la cola
     * @return
     */
    public T eliminar(){
        if(inicio == null){
            return null;
        }

        T valor = inicio.getValor();
        inicio = inicio.getProximo();
        tam--;

        return valor;
    }

    /**
     * obtener el primer elemento
     * @return
     */
    public T peek(){
        if(inicio == null){
            return null;
        }
        return inicio.getValor();
    }

    /**
     * esta vacia
     * @return
     */
    public boolean isEmpty(){
        return inicio == null;
    }

    /**
     * tamanio de la cola
     * @return
     */
    public int size(){
        return tam;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public int getTam() {
        return tam;
    }
}
