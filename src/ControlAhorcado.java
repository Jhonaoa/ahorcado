/**
 * Clase que representa la l�gica del Juego. Especialiada en manejar la palabra a adivinar.
 * 
 */

import java.util.Random;

public class ControlAhorcado {
	
	private static final String[] bancoPalabras = {"BATMAN","SUPERMAN","ACUAMAN","FLASH"};
	private String palabra;
	private static int intentos;
	private String letra = "";
	
	public ControlAhorcado(){
		intentos=0;
	}
	
	/**
	 * M�todo que selecciona de forma aleatoria una palabra del banco de palabras.
	 * @param String retorna la palabra seleccionada
	 */
	public int seleccionarPalabra(){
		Random  aleatorio = new Random();
		palabra = bancoPalabras[(int)(aleatorio.nextDouble()*(bancoPalabras.length))];
		System.out.println(palabra);
		return palabra.length();
	}
	
	/**
	 * M�todo que valida si la letra seleccionada est� en la palabra
	 * @param letra Argumento de entrada que referencia al caracter seleccionado por el usuario
	 * @return Arreglo del tipo String que devuelve en su primera posici�n el n�mero de intentos fallidos y 
	 * en su segunda posici�n la ubicaci�n de las letras seleccionadas o vac�o si la letra no se encontr�.
	 */
	
	public String[] validarLetra(String letra){
		
		String[] estado = new String[2];
		String posiciones = "";
						
        for(int i=0;i<palabra.length();i++){ 
         if((int)letra.charAt(0)==(int)palabra.charAt(i)) 
             posiciones=posiciones+String.valueOf(i);     
        }
        
        if(posiciones.equals("")){
        	intentos++; //Solo se cuenta intento fallido si no se encontr� la letra en la palabra
        }
        
        estado[0]=Integer.toString(intentos);
        estado[1]=posiciones;
        
        //System.out.println(estado[1]);
         
        return estado;
        }

	/*
	 * M�todo para resetear intentos cada vez que inicie un nuevo juego
	 */
	public void setIntentos(int i){
		intentos=0;
	}
	
	public void setLetra(String i){
		letra = i;
	}
	
	public String getLetra()
	{
		return letra;
	}
	
	public String getPalabra()
	{
		return palabra;
	}
	
	public int getIntento()
	{
		return intentos;
	}
	
	public int[] posiciones()
	{
		int[] aux;
		
		aux = new int[palabra.length()];
		
		
		
		for(int i=0;i<validarLetra(letra)[1].length();i++)
		{ 
			aux[i]= Integer.parseInt(String.valueOf(validarLetra(letra)[1].charAt(i)));
			System.out.print(aux[i]);
		}
		
		return aux;
		
	}
}