
package canciondewii;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 

public class cualMusicEs {


//    public String cuales(int respuestaCancion){
//           if   (respuestaCancion == 0){
//            return("Tiny Tim.mp3");
//        }else if(respuestaCancion == 1){
//            return("Tom_Sawyer_final.mp3");
//        }else if(respuestaCancion == 2){
//            return("MiiMusic.mp3");
//        }else if(respuestaCancion == 3){
//            return("Sentigo-comun.mp3");
//        }else if(respuestaCancion == 4){
//            return("Fur Elise.mp3");
//        }else if(respuestaCancion == 5){
//            return("cancelar");
//        }
//        return null;
//    }
    
    public void setPlay(String nameMusic){ // ya funciona, corre bien las cacniones con el ../
                    try {
                    
                    FileInputStream fis;
                    Player player;
                    fis = new FileInputStream(//la direccion del archivo a tocar es...
                            "../canciones/cancionesJava/"+nameMusic);//  /Users/JoseFabioAL/Desktop/descargas/cancionesJava/
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    player = new Player(bis); // Llamada a constructor de la clase Player. Bis tiene la cancion que se quiere tocar.
                    player.play();            // Llamada al método play
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                  }catch (FileNotFoundException e) {
                    e.printStackTrace();
                  }
    }
    public void setPlayClick(){
        try {

            FileInputStream fis;
            Player player;
            fis = new FileInputStream("../canciones/click.mp3");    //  /Users/JoseFabioAL/NetBeansProjects/canciones/click.mp3
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis); // Llamada a constructor de la clase Player
            player.play();          // Llamada al método play
        } catch (JavaLayerException e) {
          e.printStackTrace();
        }catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        
    }public void setPlayAzr() throws IOException{
        azar azar = new azar();
        Object[] cancionesAzr = azar.sonIguales();
        for(int i = 0; i < cancionesAzr.length; i++){
            
            try {
                String cancion = cancionesAzr[i].toString()+".mp3";
                FileInputStream fis;
                Player player;
                fis = new FileInputStream("../canciones/cancionesJava/"+cancion); //  /Users/JoseFabioAL/Desktop/descargas/cancionesJava/
                BufferedInputStream bis = new BufferedInputStream(fis);

                player = new Player(bis); // Llamada a constructor de la clase Player
                player.play();          // Llamada al método play
                } catch (JavaLayerException e) {
              e.printStackTrace();
                }catch (FileNotFoundException e) {
              e.printStackTrace();
            }
        }

    }public void setPlayDown() throws IOException{
        
    }
}

