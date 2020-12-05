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



public class PruebaMetodosDeBusqueda {
	
	
	
	public static void main(String[] args) {
	
	int[] matriz= {1,4,6,8,19,23,56,78,98,100,102};
	int opcion = 0;
	do {
		System.out.println("========== MENU ==========");
		System.out.println("Digite 1 para usar el metodo de busuqeda binaria");
		System.out.println("Digite 2 para ¿?");
		System.out.println("Digite 3 para ***SALIR***");
		opcion = Correcion.validacion();
		
		switch(opcion) {
		case 1:
			System.out.println("Ingrese el valor buscado");
			int buscado = Correcion.validacion(); 
			System.out.println("Vector: " + Arrays.toString(matriz));
			MetodosDeBusqueda.binario(matriz, buscado);break;
		case 2:
			System.out.println("¿?");break;
		case 3:
			System.out.println("Gracias por usar el Programa");
		}
		
	}while(opcion != 3);
	
	
	
	

	}

}
