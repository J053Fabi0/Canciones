/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canciondewii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author JoseFabioAL
 */
public class leertxt {
    
    public String GetTxtString(String ruta) throws FileNotFoundException, IOException{ //ruta del archivo que tenemos que leer
        File archivo = new File(ruta);
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))); 
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
        String linea = ""; 
        int numeroDeLineas = 0;
        String archivoo = "";
    //    while((linea = br.readLine())!=null){ 
    //        numeroDeLineas++;
    //    }
        while((linea = br.readLine())!=null){ 
            if(numeroDeLineas == 0){
                archivoo = linea;
                numeroDeLineas++;
    //            System.out.println("numeroDeLineas == 0: " + archivoo);
            }else{
                archivoo = archivoo+"\n"+linea;
                numeroDeLineas++;
            }

        }

        String archivoString = archivoo.toString();
        
        
        return archivoString;
        
    }
    
    
    public Object[] gettxtObject(String rutaArchivo){ //ruta del archivo que tenemos que leer
    
        String texto = "";

        try{
            BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));

            String temporal = "";//se guarda temporalmente el archivo en este String
            String bfRead;
            while((bfRead = bf.readLine()) != null){ //haz el ciclo mientras bfRead tienen datos

                temporal = temporal+bfRead+",";//guardado el texto del archivo

            }

        texto = temporal; //lo guardamos en una variabe externa ya que temporal solo tiene vida en en try catch

        }catch(Exception e){
            System.out.println("no se encontro el archivo");
        }





        Object[] archivoArray = texto.split(",");

    //    for(int i =0; i<archivoArray.length; i++){
    //        System.out.println(archivoArray[i]);
    //    }
    //    archivoArray.remove(0);


        return archivoArray;
        
    }
    
    public Object get1rstMusic() throws FileNotFoundException, IOException{
        
                File carpeta=new File("../canciones/cancionesJava/");
        ArrayList listaArchivos=new ArrayList();
        for(File archivo:carpeta.listFiles())
	listaArchivos.add(archivo.getName());
        String listaArchivos2 = listaArchivos.toString();
        listaArchivos2 = listaArchivos2.substring(12, listaArchivos2.length());
        listaArchivos2 = listaArchivos2.substring(0, listaArchivos2.length()-5);
        Object[] listaArchivosArray = listaArchivos2.split(Pattern.quote(".mp3, "));
        
        return listaArchivosArray[0];
        
    }
    public Object[] getCanciones(){
        File carpeta=new File("../canciones/cancionesJava/");
        ArrayList listaArchivos=new ArrayList();
        for(File archivo:carpeta.listFiles())
	listaArchivos.add(archivo.getName());
        String listaArchivos2 = listaArchivos.toString();
        listaArchivos2 = listaArchivos2.substring(12, listaArchivos2.length());
        listaArchivos2 = listaArchivos2.substring(0, listaArchivos2.length()-5);
        Object[] listaArchivosArray = listaArchivos2.split(Pattern.quote(".mp3, "));
        
        return listaArchivosArray;
    }
    public Object[] getCancionesAbajo(String cancionActual){
        leertxt leertxt = new leertxt();
        ArrayList listaCanciones = new ArrayList();
        Object[] ObjectCanciones = leertxt.getCanciones();
        for(int i = 0; i < ObjectCanciones.length; i++){
            listaCanciones.add(ObjectCanciones[i]);
        }
        cancionActual = cancionActual.substring(0, cancionActual.length() - 4); //La cancion actualmente elejida
//        System.out.println("cancionActual: " + cancionActual);
        int numCancionActual = listaCanciones.indexOf(cancionActual);   //se saca el numero de la posicion de la cancion que esta actualmente
        
//        for(int i = 0; i <= (listaCanciones.size()-1) - numCancionActual; i++){
//            System.out.println(listaCanciones.get(i));
//        }
        return null;
    }
    
}
