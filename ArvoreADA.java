import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Date;

public class ArvoreADA {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreADA() {
		raiz = null;
	}

	public static void main(String[] args) throws Exception {
        //entradas do stdin
        //o primeiro elemento indica o tamanho da linha.
        int entradas[][] = new int[50][50];
        
        int numeroNumerosLinha =0;
        int linhas = -1;
        
        //leitura das linhas
        do {
          linhas++;
         
        // MyIO.print("Insira o numero de numeros na linha: ");
          
          //primeiro int do stdin é o numero de numeros naquela linha
          entradas[0][linhas] = MyIO.readInt();
          numeroNumerosLinha = entradas[0][linhas];
          
          for(int i=1; i<= numeroNumerosLinha ;i++){
            entradas[i][linhas] = MyIO.readInt();
           // MyIO.println("\tNumero inserido: "+entradas[i][linhas]);
          }
          //MyIO.println("-----------------------------");
            
        } while (numeroNumerosLinha != 0);
        //MyIO.println("Linhas inseridas: "+linhas);

        // array de referencias a objetos
        ArvoreADA conjuntoArvores[] = new ArvoreADA[linhas];
        
        //inserir linhas da entrada dentro da árvore
        for (int j = 0; j < linhas; j++) {  
          conjuntoArvores[j] = new ArvoreADA();
          for (int i = 1; i <= entradas[0][j]; i++) {
            //MyIO.println("\tNumero sendo inserido agora: "+entradas[i][j]);
            conjuntoArvores[j].inserir2(entradas[i][j]);
          }
		  MyIO.println("-------------------------");
        }
        for(int k = 0; k < linhas; k++){
         //MyIO.println("Mostrando a arvore: "+k);
          conjuntoArvores[k].mostrarPre();
        }
        
        // fim da main
   }

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarPre() {
		mostrarPre(raiz);
		System.out.println();
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void mostrarPre(No i) {
		if (i != null) {
			MyIO.print(i.elemento+" "); // Conteudo do no.
			mostrarPre(i.esq); // Elementos da esquerda.
			mostrarPre(i.dir); // Elementos da direita.
		}
	}
	public void inserir2(int x) throws Exception {
		if(raiz == null){
      //	MyIO.println("Criando no: "+x);
			raiz = new No(x);
		} else if(x < raiz.elemento){
			 inserir2(x, raiz.esq, raiz);
		} else if(x > raiz.elemento){
			 inserir2(x, raiz.dir, raiz);
		} else {
		   throw new Exception("Erro ao inserir2!");
		}
	  }
  
	  /**
	   * Metodo privado recursivo para inserir2 elemento.
	   */
	  private void inserir2(int x, No i, No pai) throws Exception {
		  if (i == null) {
		   if(x < pai.elemento){

      	//MyIO.println("Criando no na esquerda: "+x);
			  pai.esq = new No(x);
		   } else {
		
      	//MyIO.println("Criando no na direita: "+x);
			   pai.dir = new No(x);
		   }
		} else if (x < i.elemento) {
		   inserir2(x, i.esq, i);
		} else if(x > i.elemento){
		   inserir2(x, i.dir, i);
		} else {
		   throw new Exception("Erro ao inserir2!");
		}
	  }

}

class No {
	public int elemento; // Conteudo do no.
	public No esq, dir; // Filhos da esq e dir.

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento Conteudo do no.
	 */
	public No(int elemento) {
	  this.dir = this.esq = null;
    this.elemento = elemento;
  }
}

