
package canciondewii;

import java.io.IOException;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

public class CancionDeWii {

  public static void main(String[] args) throws IOException {
    int primeraVez = 0;
    azar azar = new azar();
    Object[] cancionesAzr = azar.sonIguales();
    ImageIcon image = new ImageIcon("/Users/JoseFabioAL/Desktop/descargas/itunes_logo2 copia.jpg");
    ImageIcon image2 = new ImageIcon("/Users/JoseFabioAL/Desktop/descargas/itunes_logo2 copia 2.jpg");

    while (true) {
      Object cancion = ".mp3";
      Object cuantasVecesObj = "";
      cualMusicEs cualMusicEs = new cualMusicEs();
      String cancionString = "";
      leertxt leertxt = new leertxt();

      Object[] archivoArray = leertxt.getCanciones(); //la lista de todas las canciones por orden alfaetico  sin .mp3

      while (cancion.equals(".mp3")) {
        if (primeraVez == 0) {

          int numeroCanciones;
          for (numeroCanciones = 0; numeroCanciones < archivoArray.length; numeroCanciones++) {
          }

          cancion = JOptionPane.showInputDialog(null, "Elije tu canción favorita (" + numeroCanciones + ")",
              "Elije",
              JOptionPane.QUESTION_MESSAGE, image, cancionesAzr, null) + ".mp3";

          cancionString = cancion.toString();

          leertxt.getCancionesAbajo(cancionString);

          cualMusicEs.setPlayClick();
          primeraVez++;

          if (cancionString.equals("null.mp3"))
            System.exit(0); //<-- si elijió cancelar se cancela antes de que pregunte otra cosa
        } else if (primeraVez > 0) {
          cancion = JOptionPane.showInputDialog(null, "Elije tu canción favorita", "Elije",
              JOptionPane.QUESTION_MESSAGE, image, archivoArray, null) + ".mp3";
          cancionString = cancion.toString();
          leertxt.getCancionesAbajo(cancionString);

          cualMusicEs.setPlayClick();
          primeraVez++;

          if (cancionString.equals("null.mp3"))
            System.exit(0); //<-- si elijió cancelar se cancela antes de que pregunte otra cosa
        }
      }

      int ilimitados0No = 2;

      if (ilimitados0No == 2) { //si eligió un determinado número de veces
        cuantasVecesObj = JOptionPane.showInputDialog(null,
            "Cuantas veces queres correr \"" + cancionString + "\" ?", "Elije", //se le pregunta cuántas veces
            JOptionPane.QUESTION_MESSAGE, image2,
            new Object[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "∞", "⬇", "♻" }, "♻");
        cualMusicEs.setPlayClick();

        if (cuantasVecesObj == "null") {
          // nada
        } else if (cuantasVecesObj == "∞" || cuantasVecesObj == "♻") {// si eligió infinitas veces correr la canción o al azar
          if (cuantasVecesObj == "∞") { // confirma que eligió ilimitadas
            while (true) //tan fácil como un while infinito
              cualMusicEs.setPlay(cancionString);
          } else {
            cualMusicEs.setPlay(cancionString);
            cualMusicEs.setPlayAzr();
          }
        } else if (ilimitados0No == 0 || cuantasVecesObj != null) {
          if (ilimitados0No == 0) {
            System.exit(0);
          }
          String cuantasVecesStr = cuantasVecesObj.toString();
          int cuantasVecesInt = Integer.parseInt(cuantasVecesStr);
          int i = cuantasVecesInt;
          if (i > 0) {

            int x = 0;
            while (x < i) {
              cualMusicEs.setPlay(cancionString);
              x++;
            }
          }
        } else if (ilimitados0No == 0) {//si elijió la opcion de salir porque escogió una cancion que no quiere escuchar
          //no ara nada e ira al pricipio
        }

      }

      if (cancionString.equals("null.mp3")) {//si desde un principio decide salirse el programa no lo pen
        System.exit(0);
      }

    }
  }
}
