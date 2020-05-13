public class Ordenamiento{
    ciudadano [] lista;
    
    public Ordenamiento(ciudadano [] lista){
        this.lista = lista;
    }

    public void mostrar(){
        for(int i = 0; i < lista.length; i++){
            System.out.println("");
            lista[i].mostrarDatos();
        }
    }

    public ciudadano [] ordenarPorMezcla( ciudadano[] unaLista ) {
    int i, j, k;
    if( unaLista.length>1 ){
        int nElementosIzq = unaLista.length / 2;
        int nElementosDer = unaLista.length - nElementosIzq;
        ciudadano [] listaIzquierda = new ciudadano[nElementosIzq];
        ciudadano [] listaDerecha = new ciudadano[nElementosDer];
        // Dividir
        // Copiando de unaLista a listaIzquierda
        llenarLista( unaLista, listaIzquierda, 0, nElementosIzq );
        // Copiando unaLista a listaDerecha
        llenarLista( unaLista, listaDerecha, nElementosIzq, nElementosIzq+nElementosDer
        );
        // Recursividad
        listaIzquierda = ordenarPorMezcla(listaIzquierda);
        listaDerecha = ordenarPorMezcla(listaDerecha);
        // Unir
        intercambiar( unaLista, listaIzquierda, listaDerecha );
    }
    // Muestra como se va haciendo el proceso de ordenamiento
    //this.mostrarLista(unaLista);
    return unaLista;
    }

    private void llenarLista( ciudadano[] arreglo, ciudadano[] arreglo2, int inicio, int fin ) {
        int contador = 0;
        for( int i=inicio; i<fin; i++ ){
            arreglo2[contador] = arreglo[i];
            contador++;
        }
    }

    private void intercambiar( ciudadano[] unaLista, ciudadano[] listaIzquierda, ciudadano[] listaDerecha ) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(listaIzquierda.length!=j && listaDerecha.length!=k ) {
            if( listaIzquierda[j].edad<listaDerecha[k].edad ) {
            unaLista[i] = listaIzquierda[j];
            i++;
            j++;
            }
            else {
            unaLista[i] = listaDerecha[k];
            i++;
            k++;
            }
        }
    // lista final = unir listas
        while( listaIzquierda.length!=j ) {
            unaLista[i] = listaIzquierda[j];
            i++;
            j++;
        }
        while( listaDerecha.length!=k ) {
            unaLista[i] = listaDerecha[k];
            i++;
            k++;
        }
    }

    public ciudadano[] getLista() {
        return lista;
    }

    public void setLista(ciudadano[] lista) {
        this.lista = lista;
    }
}