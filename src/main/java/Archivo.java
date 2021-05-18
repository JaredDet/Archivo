import java.io.*;

public class Archivo {

    private static final String ruta = "src/main/resources/savedataCalculadora.txt";
    private static final File archivo = new File(ruta);
    private static String cadena;
    private double valor;

    public Archivo(double valor){
        this.valor = valor;
    }

    public Archivo(){

    }

    private void crearArchivo(){

        try {
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo(){

        if(!archivo.exists()){
            crearArchivo();
        }try {
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("El valor guardado es: " + valor);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarArchivo(){

        archivo.delete();
    }

    private void leerArchivo(){

        try {
            FileReader file = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(file);
            cadena = lector.readLine();
            lector.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double cargarArchivo(){
        leerArchivo();
        return Double.parseDouble(cadena.substring(22));
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}