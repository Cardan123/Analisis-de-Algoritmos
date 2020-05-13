public class direccion{
    String calle;
    int numero;
    String colonia;
    String cp;
    entidadFederativa entidad;
    public direccion(String calle,int numero,String colonia,String cp,String nombreE,String nombreA){
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        entidad = new entidadFederativa(nombreE,nombreA);
    }

    public void mostrarDatos(){
        System.out.println(calle);
        System.out.println(numero);
        System.out.println(colonia);
        System.out.println(cp);
        entidad.mostrarDatos();
    }
}