package ListaSimple;

public class ListaSimplementeEnlazada<T extends Comparable<T>> {
    private Nodo<T> inicial;
    private int tam;

    /**
     * constructor
     */
    public ListaSimplementeEnlazada(){
        inicial = null;
        tam = 0;
    }

    /**
     * metodo para insertar
     * @param valor
     * @return
     */
    public boolean insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if(inicial == null && tam == 0) {
            inicial = nuevo;
            tam++;
            return true;
        }
        Nodo<T> tempo = inicial;
        while(tempo.getProximo() != null) {
            tempo = tempo.getProximo();
        }
        tempo.setProximo(nuevo);
        tam++;
        return true;

    }

    /**
     * metodo para insertar al inicio
     * @param valor
     */
    public void insertarInicio(T valor){
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        nuevoNodo.setProximo(inicial);
        inicial = nuevoNodo;
        tam++;
    }

    /**
     * metodo para insertar dada una posicion
     * @param posicion
     * @param valor
     */
    public void insertarPosicion(int posicion, T valor) {
        if (posicion < 0 || posicion > tam) {
            System.out.println("Posición inválida: " + posicion);
        }

        Nodo<T> nuevo = new Nodo<>(valor);

        if (posicion == 0) {
            nuevo.setProximo(inicial);
            inicial = nuevo;
            tam++;
            return;
        }

        Nodo<T> actual = inicial;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }

        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);
        tam++;
    }

    /**
     * metodo para eliminar el elemento final
     */
    public void eliminarFinal(){
        if(inicial != null && inicial.getProximo()== null && tam == 1){
            inicial = null;
            tam--;
            return;
        }
        Nodo<T> tempo = inicial;
        while(tempo.getProximo().getProximo() != null){
            tempo = tempo.getProximo();
        }
        tempo.setProximo(null);
        tam--;
    }

    /**
     * metodo que elimina un elemento al inicio
     */
    public void eliminarInicio(){
        if(inicial != null && tam > 0){
            inicial = inicial.getProximo();
            tam--;
        }
    }

    /**
     * metodo para eliminar dada una posicion
     * @param posicion
     * @return
     */
    public boolean eliminarPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= tam || inicial == null) {
            return false;
        }

        if (posicion == 0) {
            inicial = inicial.getProximo();
            tam--;
            return true;
        }

        Nodo<T> actual = inicial;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }

        actual.setProximo(actual.getProximo().getProximo());
        tam--;
        return true;
    }

    /**
     * metodo que verifica si la lista es vacia
     * @return
     */
    public boolean esVacia(){
        return inicial == null && tam == 0;
    }

    /**
     * metodo que localiza un elemento
     * @param valor
     * @return
     */
    public int localizar(T valor) {
        Nodo<T> tempo = inicial;
        int index = 0;

        do {
            if(tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getProximo();
            index++;
        }while(tempo != null);

        return -1;
    }

    /**
     * metodo que inserta elementos de manera ordenada
     * @param valor
     */
    public void insertarOrdenado(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        // Insertar al inicio
        if (inicial == null || valor.compareTo(inicial.getValor()) < 0) {
            nuevo.setProximo(inicial);
            inicial = nuevo;
        } else {
            Nodo<T> actual = inicial;

            while (actual.getProximo() != null &&
                    actual.getProximo().getValor().compareTo(valor) < 0) {
                actual = actual.getProximo();
            }

            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
        }

        tam++;
    }



    /**
     * metodo que obtiene el primer elemento
     * @return
     */
    public Nodo<T> getInicial() {
        return inicial;
    }

    /**
     * metodo que obtiene el tamaño
     * @return
     */
    public int getTam() {
        return tam;
    }

    /**
     * metodo que modifica el inicial
     * @param inicial
     */
    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    /**
     * metodo que modifica el tamaño
     * @param tam
     */
    public void setTam(int tam) {
        this.tam = tam;
    }

    /**
     * metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "listaSimple.ListaSimplementeEnlazada{" +
                "inicial = " + inicial +
                '}';
    }
}
