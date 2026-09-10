public class Main {

    public static void main(String[] args) {

        MiListaDoble lista = new MiListaDoble();

        System.out.println("====================================");
        System.out.println("      PRUEBA DE MiListaDoble");
        System.out.println("====================================");

        // ====================================
        // 1. isEmpty()
        // ====================================

        System.out.println("\n--- 1. isEmpty() ---");

        System.out.println("¿Está vacía?: " + lista.isEmpty());


        // ====================================
        // 2. getSize()
        // ====================================

        System.out.println("\n--- 2. getSize() ---");

        System.out.println("Tamaño inicial: " + lista.getSize());


        // ====================================
        // 3. insertHead()
        // ====================================

        System.out.println("\n--- 3. insertHead() ---");

        lista.insertHead(20);
        lista.insertHead(10);

        System.out.println("Lista después de insertar 20 y 10 al inicio:");
        System.out.println(lista);


        // ====================================
        // 4. insertTail()
        // ====================================

        System.out.println("\n--- 4. insertTail() ---");

        lista.insertTail(30);
        lista.insertTail(40);

        System.out.println("Lista después de insertar 30 y 40 al final:");
        System.out.println(lista);


        // ====================================
        // 5. add()
        // ====================================

        System.out.println("\n--- 5. add() ---");

        lista.add(50);

        System.out.println("Lista después de add(50):");
        System.out.println(lista);


        // ====================================
        // 6. getHead()
        // ====================================

        System.out.println("\n--- 6. getHead() ---");

        System.out.println("Cabeza: " + lista.getHead());


        // ====================================
        // 7. getTail()
        // ====================================

        System.out.println("\n--- 7. getTail() ---");

        System.out.println("Cola: " + lista.getTail());


        // ====================================
        // 8. getSize()
        // ====================================

        System.out.println("\n--- 8. getSize() ---");

        System.out.println("Tamaño actual: " + lista.getSize());


        // ====================================
        // 9. get()
        // ====================================

        System.out.println("\n--- 9. get() ---");

        DoubleNode nodo30 = lista.search(30);

        System.out.println("Nodo encontrado: " + nodo30);
        System.out.println("Dato del nodo: " + lista.get(nodo30));


        // ====================================
        // 10. search()
        // ====================================

        System.out.println("\n--- 10. search() ---");

        DoubleNode encontrado = lista.search(40);

        if (encontrado != null) {
            System.out.println("Se encontró el nodo: " + encontrado.dato);
        } else {
            System.out.println("No se encontró el elemento.");
        }


        // ====================================
        // 11. contains()
        // ====================================

        System.out.println("\n--- 11. contains() ---");

        System.out.println("¿Contiene 30?: " + lista.contains(30));
        System.out.println("¿Contiene 100?: " + lista.contains(100));


        // ====================================
        // 12. insert(DoubleNode, Object)
        // ====================================

        System.out.println("\n--- 12. insert(DoubleNode, Object) ---");

        DoubleNode nodo20 = lista.search(20);

        lista.insert(nodo20, 25);

        System.out.println("Lista después de insertar 25 después de 20:");
        System.out.println(lista);


        // ====================================
        // 13. insert(Object, Object)
        // ====================================

        System.out.println("\n--- 13. insert(Object, Object) ---");

        lista.insert(30, 35);

        System.out.println("Lista después de insertar 35 después de 30:");
        System.out.println(lista);


        // ====================================
        // 14. set()
        // ====================================

        System.out.println("\n--- 14. set() ---");

        DoubleNode nodo40 = lista.search(40);

        lista.set(nodo40, 45);

        System.out.println("Lista después de cambiar 40 por 45:");
        System.out.println(lista);


        // ====================================
        // 15. toArray()
        // ====================================

        System.out.println("\n--- 15. toArray() ---");

        Object[] arreglo = lista.toArray();

        System.out.println("Elementos del arreglo:");

        for (Object elemento : arreglo) {
            System.out.print(elemento + " ");
        }

        System.out.println();


        // ====================================
        // 16. toArray(Object[])
        // ====================================

        System.out.println("\n--- 16. toArray(Object[]) ---");

        Object[] arreglo2 = new Object[20];

        lista.toArray(arreglo2);

        System.out.println("Elementos del segundo arreglo:");

        for (Object elemento : arreglo2) {

            if (elemento != null) {
                System.out.print(elemento + " ");
            }
        }

        System.out.println();


        // ====================================
        // 17. comprobar anterior
        // ====================================

        System.out.println("\n--- 17. Comprobar enlaces ANTERIOR ---");

        DoubleNode nodo35 = lista.search(35);

        if (nodo35 != null) {

            if (nodo35.anterior != null) {
                System.out.println(
                        "El anterior de 35 es: "
                                + nodo35.anterior.dato
                );
            } else {
                System.out.println("35 no tiene anterior.");
            }
        }


        // ====================================
        // 18. comprobar siguiente
        // ====================================

        System.out.println("\n--- 18. Comprobar enlaces SIGUIENTE ---");

        if (nodo35 != null) {

            if (nodo35.siguiente != null) {
                System.out.println(
                        "El siguiente de 35 es: "
                                + nodo35.siguiente.dato
                );
            } else {
                System.out.println("35 no tiene siguiente.");
            }
        }


        // ====================================
        // 19. subList()
        // ====================================

        System.out.println("\n--- 19. subList() ---");

        DoubleNode desde = lista.search(20);
        DoubleNode hasta = lista.search(45);

        MiListaDoble sublista = lista.subList(desde, hasta);

        System.out.println("Sublista desde 20 hasta 45:");
        System.out.println(sublista);


        // ====================================
        // 20. remove()
        // ====================================

        System.out.println("\n--- 20. remove() ---");

        DoubleNode nodo25 = lista.search(25);

        System.out.println("Antes de eliminar 25:");
        System.out.println(lista);

        lista.remove(nodo25);

        System.out.println("Después de eliminar 25:");
        System.out.println(lista);


        // ====================================
        // 21. Comprobar enlaces después de remove
        // ====================================

        System.out.println("\n--- 21. Comprobar enlaces después de remove() ---");

        DoubleNode nodo30Despues = lista.search(30);

        if (nodo30Despues != null) {

            if (nodo30Despues.anterior != null) {

                System.out.println(
                        "Anterior de 30: "
                                + nodo30Despues.anterior.dato
                );

            } else {

                System.out.println("30 no tiene anterior.");
            }

            if (nodo30Despues.siguiente != null) {

                System.out.println(
                        "Siguiente de 30: "
                                + nodo30Despues.siguiente.dato
                );

            } else {

                System.out.println("30 no tiene siguiente.");
            }
        }


        // ====================================
        // 22. sortList()
        // ====================================

        System.out.println("\n--- 22. sortList() ---");

        MiListaDoble listaOrdenada = new MiListaDoble();

        listaOrdenada.add(50);
        listaOrdenada.add(10);
        listaOrdenada.add(40);
        listaOrdenada.add(20);
        listaOrdenada.add(30);

        System.out.println("Lista antes de ordenar:");
        System.out.println(listaOrdenada);

        listaOrdenada.sortList();

        System.out.println("Lista después de ordenar:");
        System.out.println(listaOrdenada);


        // ====================================
        // 23. clear()
        // ====================================

        System.out.println("\n--- 23. clear() ---");

        lista.clear();

        System.out.println("¿Está vacía?: " + lista.isEmpty());

        System.out.println("Tamaño después de clear(): "
                + lista.getSize());


        // ====================================
        // FIN
        // ====================================

        System.out.println("\n====================================");
        System.out.println("       FIN DE LAS PRUEBAS");
        System.out.println("====================================");
    }
}