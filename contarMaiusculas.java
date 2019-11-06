/*
 *
 * Diogo Neiss
 */

import java.io.*;
import java.util.*;
public class contarMaiusculas {

  public static void main(String args[]){

  String entrada[] = new String[2000];

  int contadorFrases = 0;

  do{

    entrada[contadorFrases] = MyIO.readLine(); 
  }while(!estaNoFinal(entrada[contadorFrases++]));
  contadorFrases--;
  
  for(int i=0;i<contadorFrases;i++)
    printarQuantasMaiusculas(entrada[i]);

  }

  public static void printarQuantasMaiusculas(String frase){
    int c = 0;

    for(int i=0; i<frase.length();i++){
      char letra = frase.charAt(i);
      if(letra >= 'A' && letra <= 'Z')
        c++;
    }
    MyIO.println(c);

  }

  public static boolean estaNoFinal(String frase){
    return frase.length() >= 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'; 

}

}
