
package canciondewii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.ImageIcon;

public class escribirtxt {
    public void escribirtxt(String ruta) throws IOException{


    File archivo = new File(ruta);
    BufferedWriter bw;
        if(archivo.exists()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))); 
            String linea = null; 
            int numeroDeLineas = 0;
            String archivoo = "";
//            while((linea = br.readLine())!=null){ 
//                numeroDeLineas++;
//            }
            while((linea = br.readLine())!=null){ 
                if(numeroDeLineas == 0){
                    archivoo = linea;
                    numeroDeLineas++;
//                    System.out.println("numeroDeLineas == 0: " + archivoo);
                }else{
                    archivoo = archivoo+"\n"+linea;
                    numeroDeLineas++;
                }

            }
            
            cualMusicEs cualMusicEs = new cualMusicEs();
            String nuevaCancion = JOptionPane.showInputDialog("Dime el nombre de la cancón");
            cualMusicEs.setPlayClick();
            bw = new BufferedWriter(new FileWriter(archivo));
            String archivoString = archivoo.toString();
            System.out.println(nuevaCancion);
            
            if(nuevaCancion != null){
                
                PrintWriter escribir = new PrintWriter(bw);//para crear el objeto que escribe en el archivo
                escribir.println(archivoString + "\n" + nuevaCancion);//para escribir en el archivo
                escribir.flush();
                escribir.close();
                bw.close();
                
                ImageIcon image = new ImageIcon("/Users/JoseFabioAL/NetBeansProjects/canciones/tipos-de-copias-de-seguridad2.jpg");
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,"Desea hacer la copia de seguridad?","Copia de seguridad",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,image,options,null);
                cualMusicEs.setPlayClick();
                if(n == 0){
                    escribirtxt escribirtxt = new escribirtxt();
                    escribirtxt.copiaSeguridad();
                }else{
                    
                }
                
                
                
            }else if (nuevaCancion == null ){
                PrintWriter escribir = new PrintWriter(bw);//para crear el objeto que escribe en el archivo
                escribir.println(archivoString);//para escribir en el archivo
                escribir.flush();
                escribir.close();
                bw.close();
            }
            
        } else {
            System.out.println("el archivo no existe");
        }
//        escribirtxt escribirtxt = new escribirtxt();
//        escribirtxt.copiaSeguridad();

        
        

    }
    public void copiaSeguridad() throws FileNotFoundException, IOException{
        
        File archivo = new File("/Users/JoseFabioAL/NetBeansProjects/Archivos/copia de canciones.txt");
        BufferedWriter bw;
        if(archivo.exists() ) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))); 
            
            bw = new BufferedWriter(new FileWriter(archivo));
            leertxt leertxt = new leertxt();
            String cancionestxt = leertxt.GetTxtString("/Users/JoseFabioAL/NetBeansProjects/Archivos/canciones.txt");
            
                
            try (PrintWriter escribir = new PrintWriter(bw)){ //para crear el objeto que escribe en el archivo
                escribir.println(cancionestxt);//para escribir en el archivo
                escribir.flush();
            }
            bw.close();
                

            
        }else {
            System.out.println("el archivo no existe");
        }
    }
    
    public void igualrCopias(int queIgualar) throws IOException{
        if(queIgualar == 1){//Copia = Orginal
            File archivo = new File("/Users/JoseFabioAL/NetBeansProjects/Archivos/copia de canciones.txt");
            BufferedWriter bw;
            if(archivo.exists() ) {
    //        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))); 

            bw = new BufferedWriter(new FileWriter(archivo));
            leertxt leertxt = new leertxt();
            String cancionestxt = leertxt.GetTxtString("/Users/JoseFabioAL/NetBeansProjects/Archivos/canciones.txt");


                try (PrintWriter escribir = new PrintWriter(bw)){ //para crear el objeto que escribe en el archivo
                    escribir.println(cancionestxt);//para escribir en el archivo
                    escribir.flush();
                }
            bw.close();

            }
        }else if(queIgualar == 2){//Original = Copia
            File archivo = new File("/Users/JoseFabioAL/NetBeansProjects/Archivos/canciones.txt");
            BufferedWriter bw;
            if(archivo.exists() ) {
    //        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));

            bw = new BufferedWriter(new FileWriter(archivo));
            leertxt leertxt = new leertxt();
            String cancionestxt = leertxt.GetTxtString("/Users/JoseFabioAL/NetBeansProjects/Archivos/copia de canciones.txt");


                try (PrintWriter escribir = new PrintWriter(bw)){ //para crear el objeto que escribe en el archivo
                    escribir.println(cancionestxt);//para escribir en el archivo
                    escribir.flush();
                }
            bw.close();
            }
        }else{
            //no hace nada
        }
    }

}