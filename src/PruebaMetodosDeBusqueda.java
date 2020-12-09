import java.util.Arrays;
import java.util.Scanner;


interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}
class MetodosDeBusqueda{
	public static int binario(int[]matriz, int valorBuscado) {
		if(matriz.length==0) {
			return -1;
		}
		int mitad,inferior =0;
		int superior = matriz.length-1;
		do {
			mitad = (int)(inferior + superior) / 2;
			if (valorBuscado > matriz[mitad]) {
			inferior = mitad + 1;
			} else {
			superior = mitad-1;
			}
			} while (matriz[mitad] != valorBuscado && inferior <= superior);

			if (matriz[mitad] == valorBuscado) {
				System.out.println("Encontrado");
				return mitad;
			
			} else {
				System.out.println("No se encontro");
			return -1;
			}		
	}
	}
class FuncionHash {

	private String[] arreglo;
	private int tamaño;
	private int contador;
		
	public String[] getArreglo() {
		return arreglo;
	}

	// Constructor
	public FuncionHash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}

	// Funcion HASH
	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 7;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
			
				indiceArreglo %= tamaño;
			}
			arreglo[indiceArreglo] = elemento;
		}
	}
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 8;
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 8; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			for (int k = 0; k < 100; k++) {
			}
			System.out.println();
			for (j = incremento - 8; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			if (arreglo[indiceArrglo] == elemento) {
				System.out.println("Elemento " + elemento + " se encontro en el indice" + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			if (contador > 7) {
				System.out.print("Error");
				break;
			}
		}
		return null;
	}

}
public class PruebaMetodosDeBusqueda {
	
	
	
	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	int[] matriz= {1,4,6,8,19,23,56,78,98,100,102};
	String [] matrizS= {"1","4","6","8","19","23","56","78"};
	FuncionHash funcion = new FuncionHash(matrizS.length);
	int opcion = 0;
	do {
		System.out.println("========== MENU ==========");
		System.out.println("Digite 1 para usar el metodo de busuqeda binaria");
		System.out.println("Digite 2 para usar el metodo de Funcion Hash");
		System.out.println("Digite 3 para ***SALIR***");
		opcion = Correcion.validacion();
		
		switch(opcion) {
		case 1:
			System.out.println("===== Metodo de Busqueda Binaria");
			System.out.println("Ingrese el valor buscado");
			int buscado = Correcion.validacion(); 
			System.out.println("Vector: " + Arrays.toString(matriz));
			MetodosDeBusqueda.binario(matriz, buscado);break;
		case 2:
			System.out.println("======= Metodo de Busqueda Funcion Hash ========");
			funcion.funcionHash(matrizS, funcion.getArreglo());
			funcion.mostrar();
			System.out.println("Ingresa el valor a buscar:");
			String x = entrada.nextLine();
			String buscarElemento= funcion.buscarClave("x");
			if(buscarElemento == null) {
				System.out.print("\n Elemento no encontrado");
			}
			break;
		case 3:
			System.out.println("Gracias por usar el Programa");
		}
		
	}while(opcion != 3);
	
	
	
	

	}

}
