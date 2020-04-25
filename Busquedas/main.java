import java.util.Arrays;
public class main{
    public static void main(String[] args) {
        System.out.print("Intruduzca el numero de elementos del arreglo: \n");
        int tam = Integer.parseInt(System.console().readLine());
        busquedas busqueda = new busquedas(tam);
        busqueda.imprimirNumeros();
        busqueda.buscarNumero();
        busqueda.tiempoBusquedaBinaria();
    }
}