public class entidadFederativa{
    String nombreE;
    municipioAlcadia municipio;
    public entidadFederativa(String nombreE,String nombreA){
        this.nombreE = nombreE;
        municipio = new municipioAlcadia(nombreA);
    }

    public void mostrarDatos(){
        System.out.println(nombreE);
        municipio.mostrarDatos();
    }
}