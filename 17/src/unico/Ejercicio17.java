package unico;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

/* Escribe un programa que calcule el precio final de un producto según su base imponible
 * (precio antes de impuestos), el tipo de IVA aplicado (general, reducido o superreducido)
 * y el código promocional. Los tipos de IVA general, reducido y superreducido son del 21%,
 * 10% y 4% respectivamente. Los códigos promocionales pueden ser nopro, mitad, meno5 o 5porc
 * que significan respectivamente que no se aplica promoción, el precio se reduce a la mitad,
 * se descuentan 5 euros o se descuenta el 5%. El ejercicio se da por bueno si se muestran los
 * valores correctos, aunque los números no estén tabulados
 * */
		
		final int IVAGENERAL = 21;
		final int IVAREDUCIDO = 10;
		final int IVASUPER = 4;
		final int DESCMITAD = 2;
		final int DESCMENO5 = 5;
		final double DESC5PORC = 0.05;
		
		double baseImponible;
		int tipoIVA;
		int tipoIVANumerico = 0;
		int codigoPromocional;
		double iva;
		double precioSinDescuento;
		double descuento = 0;
		double total;
		
		
		System.out.print("Introduzca la base imponible: ");
	    baseImponible = Double.parseDouble(teclado.nextLine());
	    System.out.print("Introduzca el tipo de IVA (1 - general, 2 - reducido o 3 - superreducido): ");
	    tipoIVA = Integer.parseInt(teclado.nextLine());
	    System.out.print("Introduzca el código promocional (1 - nopro, 2 - mitad, 3 - meno5 o 4 - 5porc): ");
	    codigoPromocional = Integer.parseInt(teclado.nextLine());
	    
// Calcula el IVA y el precio antes del descuento
	    
	    switch(tipoIVA) {
	      case 1:
	        tipoIVANumerico = IVAGENERAL;
	        break;
	      case 2:
	        tipoIVANumerico = IVAREDUCIDO;
	        break;
	      case 3:
	        tipoIVANumerico = IVASUPER;
	        break;
	      default:
	        System.out.println("El tipo de IVA introducido no es correcto.");
	    }
	    
	    iva = baseImponible * tipoIVANumerico / 100;
	    precioSinDescuento = baseImponible + iva;
	    
// Calcula el descuento
	    
	    switch(codigoPromocional) {
	      case 1:
	        break;
	      case 2: // el precio se reduce a la mitad
	        descuento = precioSinDescuento / DESCMITAD;
	        break;
	      case 3: // se descuentan 5 euros
	        descuento = DESCMENO5;
	        break;
	      case 4: // se descuenta el 5%
	        descuento = precioSinDescuento * DESC5PORC;
	        break;
	      default:
	        System.out.println("El código promocional introducido no es correcto.");
	    }
	    
// Muestra el precio final del producto desglosado
	    
	    total = precioSinDescuento - descuento;
	    
	    System.out.println("Base imponible       " + baseImponible);
	    System.out.println("IVA                  " + iva);
	    System.out.println("Precio con IVA       " + precioSinDescuento);
	    System.out.println("Cód. promo.          " + codigoPromocional + descuento);
	    System.out.println("TOTAL                " + total);
	  }
	}