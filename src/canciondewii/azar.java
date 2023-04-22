/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canciondewii;

import java.util.Stack;
import java.lang.String;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author JoseFabioAL
 */
public class azar {
  public Object[] sonIguales() throws IOException {
    leertxt leertxt = new leertxt();
    Object[] canciones = leertxt.getCanciones();
    int numeroCanciones = canciones.length;

    int pos;
    int nCartas = numeroCanciones;
    Stack<Integer> pCartas = new Stack<Integer>();
    for (int i = 0; i < nCartas; i++) {
      pos = (int) Math.floor(Math.random() * nCartas);
      while (pCartas.contains(pos))
        pos = (int) Math.floor(Math.random() * nCartas);

      pCartas.push(pos);
    }

    String numerosRnd = pCartas.toString();
    numerosRnd = numerosRnd.substring(1, numerosRnd.length()); //se generan los numeros al azar para luego en este orden tener a
    numerosRnd = numerosRnd.substring(0, numerosRnd.length() - 1);

    String[] numerosRndArr = numerosRnd.split(Pattern.quote(", "));

    ArrayList<String> ArrayCancionesAzr = new ArrayList<String>();

    for (int i = 0; i < numeroCanciones; i++) {
      String numeroAzrString = numerosRndArr[i].toString();
      int numeroAzr = Integer.parseInt(numeroAzrString);
      String unaCancionAzr = canciones[numeroAzr].toString();
      ArrayCancionesAzr.add(unaCancionAzr);
    }

    return ArrayCancionesAzr.toArray();
  }
}
