/*
 *
 * Diogo Neiss
 */

import java.io.*;
import java.util.*;
public class Escada {

  public static void main(String args[]){

    int entradas[][] = new int[20][20];


  }
  public static void escadinha(int array[]){
      int quantEscadas = 1;
      int diff;
      for(int i = 3; i <= array[0]; i++){
        diff = array[i] -array[i-1];
        if(array[i-1] - array[i-2] == diff)
          quantEscadas++;
      MyIO.println("Quantidade de escadas =  "+quantEscadas);
      }


  }


  public static boolean estaNoFinal(String frase){
    return frase.length() >= 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'; 

  }

}
