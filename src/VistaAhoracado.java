/**
 * Clase que representa la vista del Juego.  Esta clase heredea de JFrame e implementa
 * dos JPanel que se especializan en dibujar la palabra y dibujar el ahorcado respectivamente.
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class VistaAhoracado extends JFrame implements KeyListener{
	    
		private int cantidadLetras, intentos;
		private String palabra_rayas ;
		
		private Dibujo miDibujo; //JPanel encargado de pintar el ahorcado
		private Palabra miPalabra; //JPanel encargado de pintar la palabra
		
		private ControlAhorcado control;
		
		public VistaAhoracado(){
		
			super("Juego del Ahorcado");
			palabra_rayas = "";
			control = new ControlAhorcado();
			cantidadLetras=control.seleccionarPalabra();
			for(int i=1; i<=cantidadLetras; i++)
			{
				
				palabra_rayas += "-";
			
			}
			
			
			
			
			intentos=0; //Esto es auxiliar para que ud visualice el dibujado del ahorcado
                        //lo debe modificar al hacer el ajuste

			miDibujo = new Dibujo();
			miPalabra = new Palabra();
	
			
			getContentPane().add(miPalabra);
			getContentPane().add(miDibujo);
			addKeyListener(this);
			
			setVisible(true);
			setResizable(false);
			setLocationRelativeTo(null);
			setSize(310,400);
		}
	
    /**
     * M�todo que genera un nuevo juego
     */
	public void reiniciar(){
		cantidadLetras=control.seleccionarPalabra();
		intentos=-1; //Esto es auxiliar para que ud visualice el dibujado del ahorcado
		             //lo debe modificar al hacer el ajuste
	}	
	
	public void modificarString(String letra, String pos )
	{
		String aux = "";
		
		for(int i = 0 ; i < pos.length(); i++)
		{
			int pos_aux = Integer.valueOf(pos.charAt(i));
			
		
			for(int j = 0 ; j < cantidadLetras;j++ )
			{
				if(j==pos_aux)
				{
					aux = aux + letra;

				}else{
					aux = aux + String.valueOf(palabra_rayas.charAt(j));
				}
			}
		}
		
		palabra_rayas = aux;
	}
	
	
	/*
	 * Clase especializada en dibujar el ahorcado paso a paso en cinco intentos
	 */
	
	private class Dibujo extends JPanel{
			
			
			public void paint(Graphics g){
				      
				  super.paint(g);
				  //armazon
				  g.setColor(Color.RED);
		      	  g.fillRect(47, 209, 110, 5);
		      	  g.fillRect(47, 209, 5, 130);
		      	  g.fillRect(20, 339, 70, 5);
				  
		      	  miPalabra.repaint();
		      	  
		      	  g.setColor(Color.LIGHT_GRAY);
		      	  
		      	  intentos = control.getIntento();
			      
			      switch (intentos) {
			          case 1://Cabeza
			        	      g.fillOval(110, 120, 90, 90);
				    	      break;
			    	  case 2: //Cabeza
			    		      g.fillOval(110, 120, 90, 90);
			    		      //Cuerpo
			    		      g.fillRect(150, 208, 10, 100);
					          break;
	                          
			    	  case 3://Cabeza
		    		          g.fillOval(110, 120, 90, 90); 
			    		      //Cuerpo
		    		      	  g.fillRect(150, 208, 10, 100);
			    		      //brazo izquierda  
					          g.fillRect(120, 238, 30, 10);
					          //brazo derecho			if(validar[0] != "")
								{
									
									miDibujo.repaint();
								}
								
					      	  g.fillRect(160, 238, 30, 10);
					      	  break;
			    	  case 4://Cabeza
			    	  		 g.fillOval(110, 120, 90, 90);
			    		     //Cuerpo
	    		      	  	 g.fillRect(150, 208, 10, 100);
	    		      	  	 //brazo izquierda  
	    		      	  	 g.fillRect(120, 238, 30, 10);
	    		      	  	 //brazo derecho
	    		      	  	 //g.setColor(Color.MAGENTA);
	    		      	  	 g.fillRect(160, 238, 30, 10);
				      	  	 //pierna izquierda
		    		      	 //g.setColor(Color.MAGENTA);
		    		      	 g.fillRect(120, 298, 30, 10);
	            		     //pierna derecho
		    			     g.fillRect(160, 298, 30, 10);
		    		      	 break;
			    	  case 5: //Cabeza
			    		  	  g.fillOval(110, 120, 90, 90);
			    		  	  //Cuerpo
	 		      	  	      g.fillRect(150, 208, 10, 100);
	 		      	  	      //brazo izquierda  			if(validar[0] != "")
	 		     			{
	 		   				
	 		   				miDibujo.repaint();
	 		   			}
	 		   			
	 		      	  	      g.fillRect(120, 238, 30, 10);
	 		      	  	      //brazo derecho
	 		      	  	      g.fillRect(160, 238, 30, 10);
				      	  	  //pierna izquierda
		    		      	  g.fillRect(120, 298, 30, 10);
		    		      	  //pierna derecho
		    			      g.fillRect(160, 298, 30, 10);

			    		      //Ahorcado		      
					      	  g.setColor(Color.BLACK);
					          g.drawArc(133, 177, 45, 30, 180, -180);
					          g.drawOval(135, 150, 5, 7);
					          g.drawOval(165, 150, 5, 7);
					          
					          reiniciar();
					          break;
			      } 		      
			      	      		      
			    }	

		}//Fin class Dibujo

	   /*
	    * Clase especializada en dibujar la palabra a adivinar
	   */
		private class Palabra extends JPanel {
			
			public Palabra()
			{
				setSize(300,100);
				setBackground(Color.WHITE);
			}
			public void paint(Graphics g){
				super.paint(g);
								
				g.setColor(new Color(0,0,255)); //Establece color de dibujo a Azul (RGB)
				g.setFont(new Font ("SansSerif",Font.BOLD,18)); //Establece la fuente 
				
				int x=10; //posici�n donde iniciar� el pintado
				
				/*
				 * Bucle que pinta la palabra.  Inicialmente pinta tantos guiones como
				 * letras tenga la palabra seleccionada
				 * Ud debe modificar este bucle para que pinte la letra encontrada en la
				 *  posici�n que le corresponda
				 */
				String pintar="-";
				String letra = control.getLetra();
				
				
				
				for(int i=1; i<=cantidadLetras; i++)
				{
					
					g.drawString(String.valueOf(palabra_rayas.charAt(i-1)),x,50);
					x+=30;
				
				}
					
				g.setFont(new Font ("SansSerif",Font.BOLD,16));
				g.drawString("Pulsa una tecla",10, 100);
								
			}
			
		}


		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
			String letra = arg0.getKeyText(arg0.getKeyCode());
			String[] validar = control.validarLetra(letra);
			control.posiciones();
			
			
			
			if(validar[1] != "")
			{
				modificarString(letra, validar[1]);
				miDibujo.repaint();
			}
			
			
			
			 //Esto es auxiliar para que ud visualice el pintado del ahoracado en 
			            //esta versi�n incompleta. 
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

}
