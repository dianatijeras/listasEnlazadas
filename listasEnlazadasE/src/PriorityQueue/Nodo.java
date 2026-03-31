package PriorityQueue;

public class Nodo<T> {
    private T valor;
    private Nodo<T> proximo;
    private int prioridad;

    public Nodo(T valor, int prioridad) {
        this.valor = valor;
        proximo = null;
        this.prioridad = 0;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public int getPrioridad() {
        return prioridad;
    }



    @Override
    public String toString() {
        return "listaSimple.Nodo{" +
                "valor=" + valor +
                ", proximo=" + proximo +
                '}';
    }
}
