import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.Duration;

public class busquedas {
private int numeros[];
private int numeroBuscado;

    public busquedas(int tamano){
        numeros = new int[tamano];
        generarNumeros();
        Arrays.sort(numeros);
    }

    private void generarNumeros() {
        for ( int i = 0 ; i < numeros.length ; i++ ) {
            numeros[i] = (int)(Math.random() * (numeros.length + numeros.length + 1) - numeros.length);
        }
    }

    public void imprimirNumeros() {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println('\n');
    }

    public void buscarNumero() {
        System.out.print("Ingrese el numero que desea buscar: ");
        numeroBuscado = Integer.parseInt(System.console().readLine());
    }

    public void tiempoBusquedaBinaria(){
        long inicio;
        long fin;

        inicio = System.nanoTime();
        busquedaBinariaRecursiva(0, numeros.length - 1, numeroBuscado);
        fin = System.nanoTime();
        System.out.println("La busqueda recursiva tardo: " + (fin - inicio) + " nanosegundos");
        
        inicio = System.nanoTime();
        busquedaBinariaIterativo(numeroBuscado);
        fin = System.nanoTime();
        System.out.println("La busqueda iterativa tardo: " + (fin - inicio) + " nanosegundos");

    }

    private int busquedaBinariaRecursiva( int minLimite, int maxLimite, int numeroBuscado) {
        if (maxLimite >= 0 && numeros[minLimite] <= numeroBuscado && numeros[maxLimite] >= numeroBuscado) {
            int mitad = minLimite + (maxLimite - minLimite) / 2;
            if (numeros[mitad] == numeroBuscado) {
                return mitad;
            }
            if (numeros[mitad] > numeroBuscado) {
                return busquedaBinariaRecursiva(minLimite , mitad - 1, numeroBuscado);
            }
            return busquedaBinariaRecursiva(mitad + 1, maxLimite, numeroBuscado);
        }
        return -1;
    }

    private int busquedaBinariaIterativo(int numeroBuscado) {
        int minLimite = 0;
        int maxLimite = numeros.length - 1;
        while (minLimite <= maxLimite) {
            int mitad = minLimite + (maxLimite - minLimite) / 2;
            if (numeros[mitad] == numeroBuscado) {
                return mitad;
            }
            if (numeros[mitad] < numeroBuscado) {
                minLimite = mitad + 1;
            } else { 
                maxLimite = mitad - 1;
            }
        }
        return -1;
    }

}