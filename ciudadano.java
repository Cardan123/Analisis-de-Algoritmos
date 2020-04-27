public class ciudadano{
    String nombre;
    String paterno;
    String materno;
    int edad;
    direccion direcciones;
    public ciudadano(String nombre, String paterno, String materno,int edad, String calle, int numero,String colonia,String cp,String nombreE,String nombreA){
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        direcciones = new direccion(calle,numero,colonia,cp,nombreE,nombreA);
    }

    public void mostrarDatos(){
        System.out.println(nombre+" "+paterno+" "+materno);
        System.out.println(edad);
        direcciones.mostrarDatos();
    }
}