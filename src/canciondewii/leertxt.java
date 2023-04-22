/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canciondewii;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

/**
 *
 * @author JoseFabioAL
 */
public class leertxt {
  public String GetTxtString(String ruta) throws FileNotFoundException, IOException { //ruta del archivo que tenemos que leer
    String linea = "";
    String archivoo = "";
    int numeroDeLineas = 0;
    File archivo = new File(ruta);
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));

    while ((linea = br.readLine()) != null) {
      if (numeroDeLineas == 0) {
        archivoo = linea;
        numeroDeLineas++;
      } else {
        archivoo = archivoo + "\n" + linea;
        numeroDeLineas++;
      }
    }

    br.close();

    return archivoo.toString();
  }

  public Object[] gettxtObject(String rutaArchivo) { //ruta del archivo que tenemos que leer
    String texto = "";

    try {
      BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));

      String temporal = "";//se guarda temporalmente el archivo en este String
      String bfRead;
      while ((bfRead = bf.readLine()) != null) //haz el ciclo mientras bfRead tienen datos
        temporal = temporal + bfRead + ",";//guardado el texto del archivo

      texto = temporal; //lo guardamos en una variabe externa ya que temporal solo tiene vida en en try catch

      bf.close();
    } catch (Exception e) {
      System.out.println("no se encontro el archivo");
    }

    Object[] archivoArray = texto.split(",");

    return archivoArray;
  }

  public Object get1rstMusic() throws FileNotFoundException, IOException {
    File carpeta = new File("../canciones/cancionesJava/");
    ArrayList<String> listaArchivos = new ArrayList<String>();

    for (File archivo : carpeta.listFiles())
      listaArchivos.add(archivo.getName());

    String listaArchivos2 = listaArchivos.toString();
    listaArchivos2 = listaArchivos2.substring(12, listaArchivos2.length());
    listaArchivos2 = listaArchivos2.substring(0, listaArchivos2.length() - 5);
    Object[] listaArchivosArray = listaArchivos2.split(Pattern.quote(".mp3, "));

    return listaArchivosArray[0];
  }

  public Object[] getCanciones() {
    File carpeta = new File("../canciones/cancionesJava/");
    ArrayList<String> listaArchivos = new ArrayList<String>();
    for (File archivo : carpeta.listFiles())
      listaArchivos.add(archivo.getName());
    String listaArchivos2 = listaArchivos.toString();
    listaArchivos2 = listaArchivos2.substring(12, listaArchivos2.length());
    listaArchivos2 = listaArchivos2.substring(0, listaArchivos2.length() - 5);
    Object[] listaArchivosArray = listaArchivos2.split(Pattern.quote(".mp3, "));

    return listaArchivosArray;
  }

  public Object[] getCancionesAbajo(String cancionActual) {
    leertxt leertxt = new leertxt();
    ArrayList<Object> listaCanciones = new ArrayList<Object>();
    Object[] ObjectCanciones = leertxt.getCanciones();
    for (int i = 0; i < ObjectCanciones.length; i++) {
      listaCanciones.add(ObjectCanciones[i]);
    }
    cancionActual = cancionActual.substring(0, cancionActual.length() - 4); //La cancion actualmente elejida

    return null;
  }

}
