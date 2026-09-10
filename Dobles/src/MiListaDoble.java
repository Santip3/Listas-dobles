public class MiListaDoble implements ListInterface {

    DoubleNode cabeza;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {

        if (this.cabeza == null) {
            return 0;
        }

        DoubleNode iterador = this.cabeza;
        int contador = 0;

        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }

        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {

        if (this.cabeza == null) {
            return null;
        }

        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {

        if (this.cabeza == null) {
            return null;
        }

        DoubleNode iterador = this.cabeza;

        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }

        return iterador.dato;
    }

    @Override
    public Object get(DoubleNode node) {

        if (node == null) {
            return null;
        }

        return node.dato;
    }

    @Override
    public DoubleNode search(Object object) {

        DoubleNode iterador = this.cabeza;

        while (iterador != null) {

            if (iterador.dato.equals(object)) {
                return iterador;
            }

            iterador = iterador.siguiente;
        }

        return null;
    }

    @Override
    public boolean add(Object object) {

        insertTail(object);

        return true;
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {

        if (node == null) {
            return false;
        }

        DoubleNode nuevoNodo = new DoubleNode(object);

        // El nuevo nodo apunta al siguiente de node
        nuevoNodo.siguiente = node.siguiente;

        // El nuevo nodo apunta hacia atrás a node
        nuevoNodo.anterior = node;

        // Si existe un nodo después de node,
        // ese nodo ahora debe apuntar hacia nuevoNodo
        if (node.siguiente != null) {
            node.siguiente.anterior = nuevoNodo;
        }

        // node ahora apunta hacia nuevoNodo
        node.siguiente = nuevoNodo;

        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {

        DoubleNode iterador = this.cabeza;

        while (iterador != null) {

            if (iterador.dato.equals(objectRef)) {

                DoubleNode nuevoNodo = new DoubleNode(object);

                nuevoNodo.siguiente = iterador.siguiente;
                nuevoNodo.anterior = iterador;

                if (iterador.siguiente != null) {
                    iterador.siguiente.anterior = nuevoNodo;
                }

                iterador.siguiente = nuevoNodo;

                return true;
            }

            iterador = iterador.siguiente;
        }

        return false;
    }

    @Override
    public boolean insertHead(Object object) {

        try {

            // Crear el nuevo nodo
            DoubleNode nuevaCabeza = new DoubleNode(object);

            // El nuevo nodo apunta a la antigua cabeza
            nuevaCabeza.siguiente = this.cabeza;

            // Si ya existía una cabeza,
            // ahora su anterior será la nueva cabeza
            if (this.cabeza != null) {
                this.cabeza.anterior = nuevaCabeza;
            }

            // La nueva cabeza pasa a ser la cabeza de la lista
            this.cabeza = nuevaCabeza;

            return true;

        } catch (Exception e) {

            System.out.println("Ocurrió un error");

            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {

        if (this.cabeza == null) {

            DoubleNode nuevaCabeza = new DoubleNode(object);

            this.cabeza = nuevaCabeza;

        } else {

            DoubleNode nuevaCola = new DoubleNode(object);

            DoubleNode iterador = this.cabeza;

            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;
            }

            // El nuevo nodo apunta hacia atrás
            // al último nodo actual
            nuevaCola.anterior = iterador;

            // El último nodo actual apunta
            // hacia el nuevo nodo
            iterador.siguiente = nuevaCola;
        }

        return true;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {

        if (node == null) {
            return false;
        }

        node.dato = object;

        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {

        if (node == null || this.cabeza == null) {
            return false;
        }

        // Caso 1: eliminar la cabeza
        if (this.cabeza == node) {

            this.cabeza = node.siguiente;

            if (this.cabeza != null) {
                this.cabeza.anterior = null;
            }

            node.siguiente = null;
            node.anterior = null;

            return true;
        }

        // Caso 2: eliminar un nodo intermedio o la cola
        DoubleNode anterior = node.anterior;
        DoubleNode siguiente = node.siguiente;

        if (anterior != null) {
            anterior.siguiente = siguiente;
        }

        if (siguiente != null) {
            siguiente.anterior = anterior;
        }

        node.anterior = null;
        node.siguiente = null;

        return true;
    }

    @Override
    public boolean contains(Object object) {

        DoubleNode iterador = this.cabeza;

        while (iterador != null) {

            if (iterador.dato.equals(object)) {
                return true;
            }

            iterador = iterador.siguiente;
        }

        return false;
    }

    @Override
    public Object[] toArray() {

        Object[] arreglo = new Object[getSize()];

        DoubleNode iterador = this.cabeza;

        int posicion = 0;

        while (iterador != null) {

            arreglo[posicion] = iterador.dato;

            posicion++;

            iterador = iterador.siguiente;
        }

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {

        int posicion = 0;

        DoubleNode iterador = this.cabeza;

        while (iterador != null && posicion < object.length) {

            object[posicion] = iterador.dato;

            posicion++;

            iterador = iterador.siguiente;
        }

        return object;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {

        MiListaDoble nuevaLista = new MiListaDoble();

        if (from == null || to == null) {
            return nuevaLista;
        }

        DoubleNode iterador = from;

        while (iterador != null) {

            nuevaLista.insertTail(iterador.dato);

            if (iterador == to) {
                break;
            }

            iterador = iterador.siguiente;
        }

        return nuevaLista;
    }

    @Override
    public MiListaDoble sortList() {

        if (this.cabeza == null || this.cabeza.siguiente == null) {
            return this;
        }

        DoubleNode actual;
        DoubleNode siguiente;

        for (actual = this.cabeza;
             actual != null;
             actual = actual.siguiente) {

            for (siguiente = actual.siguiente;
                 siguiente != null;
                 siguiente = siguiente.siguiente) {

                if ((Integer) actual.dato > (Integer) siguiente.dato) {

                    Object temporal = actual.dato;

                    actual.dato = siguiente.dato;

                    siguiente.dato = temporal;
                }
            }
        }

        return this;
    }

    @Override
    public String toString() {

        String resultado = "MiListaDoble{";

        DoubleNode iterador = this.cabeza;

        while (iterador != null) {

            resultado += iterador.dato;

            if (iterador.siguiente != null) {
                resultado += " <-> ";
            }

            iterador = iterador.siguiente;
        }

        resultado += "}";

        return resultado;
    }
}