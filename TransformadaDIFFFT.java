public class TransformadaDIFFFT {
/**
* Para realizar la arirmetica compleja en los calculos de la FFT
*/
AritmeticaCompleja aritmetica;
/**
* Constructor de la clase
*/
public TransformadaDIFFFT() {
aritmetica = new AritmeticaCompleja();
}
/**
* Muestra los complejos funciona como DEBUG por si se quiere ver en algun
* momento de la ejecucion resultados intermedios
* @param zetas imprime esta variable
*/
private void mostrarArreglo( Complejo [] zetas ) {
for( int j=0; j<zetas.length; j++ ) {
System.out.println( j + " " + zetas[j] );
}
System.out.println();
}
/**
* Calcula la FFT por decimacion o diezmo en frecuencia
* @param N tamanio de las muestras de entrada
* @param a arreglo de tamanio N Complejos
* @param w contiene las raices de la unidad tambien complejos
* @return devuelve la transformada discreta de los valores que antes
* contenia "a" (Complejos)
*/
public Complejo [] calcularTransformada( int N, Complejo [] a,
Complejo [] w ) {
int numeroDeProblemas = 1;
int tamanioProblema = N;
int jGirar = 0;
while( tamanioProblema>1 ) {
int tamanioMitad = tamanioProblema / 2;
for( int k=0; k<numeroDeProblemas; k++ ) {
int jPrimero = k * tamanioProblema;
int jUltimo = jPrimero + tamanioMitad - 1;
// recorre las raices de la unidad sin dar saltos
// las veces que sea necesario en el algoritmo
jGirar = 0;//2 * ( N - ( N / numeroDeProblemas ) );
for( int j=jPrimero; j<=jUltimo; j++ ) {
Complejo W = new Complejo( w[jGirar] );
Complejo temp = new Complejo( a[j] );
// Se realiza la mariposa de la primera operacion
a[j] = aritmetica.sumar( temp, a[j+tamanioMitad] );
// segunda operacion
a[j+tamanioMitad] =
aritmetica.multiplicar( W,
aritmetica.restar( temp,
a[j+tamanioMitad] ) );
// recorremos el arreglo de las raices
jGirar = jGirar + numeroDeProblemas;
}
}
numeroDeProblemas *= 2;// * numeroDeProblemas;
tamanioProblema = tamanioMitad;
}
return invertirBits( a );
}
/**
* La funcion calcula las raices de la unidad necesarias para aplicar en un
* algoritmo de FFT, es decir, los w__{N}^{r} conjugados
* @param N tamanio de la FFT
* @return devuelve w que contiene las raices complejas ordenadas para
* emplearlas cuando se requieran en el algoritmo FFT
*/
public Complejo [] calcularRaices( int N ) {
double theta = 2.0*Math.PI / (double)N;
double [] wCos = new double[N];
double [] wSen = new double[N];
double s = Math.sin(theta);
double c = 1.0 - 2.0 * Math.pow( Math.sin(theta/2.0), 2.0 );
//double c = Math.sqrt( 1.0 - s*s );
wCos[0] = 1.0;
wSen[0] = 0.0;
//System.out.println( "0 0 " + wCos[0] + " " + wSen[0] );
for( int k=0; k<N/8; k++ ) {
wCos[k+1] = c * wCos[k] - s*wSen[k];
wSen[k+1] = s * wCos[k] + c*wSen[k];
//System.out.println( (k+1) + " " + (k+1) + " " + wCos[k+1] + " " + wSen[k+1] );
}
//System.out.println();
int L = N / 8;
wCos[L] = Math.sqrt(2.0) / 2.0;
wSen[L] = Math.sqrt(2.0) / 2.0;
for( int k=1; k<=N/8; k++ ) {
    wCos[L+k] = wSen[L-k];
wSen[L+k] = wCos[L-k];
//System.out.println( (k+L) + " " + (k+L) + " " + wCos[k+L] + " " + wSen[L+k]);
}
//System.out.println();
L = N / 4;
wCos[L] = 0.0;
wSen[L] = 1.0;
for( int k=1; k<N/4; k++ ) {
wCos[L+k] = -wCos[L-k];
wSen[L+k] = wSen[L-k];
//System.out.println( (k+L) + " " + (k+L) + " " + wCos[k+L] + " " + wSen[L+k]);
}
//System.out.println();
Complejo [] w = new Complejo[N];
//System.out.println( "PRIMER FOR" );
for( int n=0; n<N/2; n++ ) {
double real = wCos[n];
double imag = wSen[n];
if( imag!=0.0 ) {
imag *= (-1.0);
}
w[n] = new Complejo( real, imag );
//System.out.println( n + " " + w[n] );
}
//System.out.println( "SEGUNDO FOR" );
for( int n=N/2; n<N; n++ ) {
//System.out.println( wCos[n-N/2] + " " + wSen[n-N/2] );
double real = wCos[n-N/2];
double imag = wSen[n-N/2];
if( real!=0.0 ) {
real *= (-1.0);
}
//System.out.println( real + " " + imag );
w[n] = new Complejo( real, imag );
//System.out.println( n + " " + w[n] );
}
return w;
}
/**
* Ordena los elementos de la FFT
*
* @param a arreglo complejo desordenado
* @return devuelve el arreglo complejo ordenado
*/
private Complejo [] invertirBits( Complejo [] a ) {
int N = a.length;
Complejo [] fftTemp = new Complejo[N];
for(int n=0; n<N; n++ ) {
fftTemp[n] = new Complejo( a[n] );
}
int [] bitInverso = new int[N];
int p = 1;
for( int q=0; q<N; q++ ) {
bitInverso[q] = q;
}
while( p<N ) {
for( int q=0; q<p; q++ ) {
bitInverso[q] = bitInverso[q]*2;
bitInverso[q+p] = bitInverso[q]+1;
}
p = p*2;
}
for( int n=0; n<N ;n++ )
a[bitInverso[n]]=fftTemp[n]; //fft_out FFT ordenada.
return a;
}
}