/*
 *
 * Diogo Neiss
 * 
 * Dizemos que uma sequência de números é uma escadinha, se a diferença entre números consecutivos é sempre a mesma. Por
exemplo, ‘2, 3, 4, 5” e “10, 7, 4” são escadinhas. Note que qualquer sequência com apenas um ou dois números também é
uma escadinha!
Neste problema estamos procurando escadinhas em uma sequência maior de números. Dada uma sequência de números,
queremos determinar quantas escadinhas existem. Mas só estamos interessados em escadinhas tão longas quanto possı́vel.
Por isso, se uma escadinha é um pedaço de outra, consideramos somente a maior. Por exemplo, na sequência “1, 1, 1, 3, 5,
4, 8, 12” temos 4 escadinhas diferentes: “1, 1, 1”, “1, 3, 5”, “5, 4” e “4, 8, 12”.
Dados de entrada: A entrada é composta por vários casos de teste. Uma linha da entrada contém um inteiro N indicando
o tamanho da sequência de números. A linha seguinte contém N inteiros definindo a sequência. A última linha contém a
frase “FIM”.
Exemplo de entrada:
8
1 1 1 3 5 4 8 12
1
112
5
11 -106 -223 -340 -457
FIM
 * 
 */

public class Escada {

	public static void main(String args[]) {
		MyIO.setCharset("UTF-8");

		int entradas[][] = new int[20][20];
		String tamLinhaString;
		int flag = 0;
		int j = 0;
		do {
			// MyIO.println("Insira o numero de elementos na linha, ou FIM pra parar");
			tamLinhaString = MyIO.readLine();
			// MyIO.println("\tNumero de nums na linha: "+tamLinhaString);
			if (estaNoFinal(tamLinhaString)) {
				flag = -1;
			} else {
				// colocar o tamanho da linha no primeiro elemento
				entradas[j][0] = Integer.parseInt(tamLinhaString);

				for (int i = 1; i <= entradas[j][0]; i++) {
					entradas[j][i] = MyIO.readInt();
					// MyIO.println("Imserção atual: "+entradas[j][i]);
				}
				j++;
			}

		} while (flag != -1);

		for (int i = 0; i < j; i++) {
			escadinha(entradas[i]);
		}

	}

	public static void escadinha(int array[]) {
		int quantEscadas = 0;
		int diff;
		String diferencasEncontradas = "";
		// MyIO.print("\tEntrada atual: ");

		// começa em 3 pq a primeira posicao é o tamanho e eu acesso 2 posicoes
		// anteriores a atual
		int numElementos = array[0];

		if (numElementos < 3)
			quantEscadas += 1;
		else
			for (int i = 3; i <= numElementos; i++) {
				diff = array[i] - array[i - 1];

				if (!diferencasEncontradas.contains(Integer.toString(diff))) {
					diferencasEncontradas += Integer.toString(diff);
					diferencasEncontradas += " ";
					quantEscadas++;
				}
			}

		// MyIO.println("Escadas encontradas: "+diferencasEncontradas);
		MyIO.println(quantEscadas);
	}

	public static boolean estaNoFinal(String frase) {
		return frase.contains("FIM");
	}

}
