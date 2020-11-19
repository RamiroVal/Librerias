package LibTexto;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * Librería que limita el numero y el tipo de caracteres que aceptara un JTextField
 * @author jesus
 */
public class CharLimit extends KeyAdapter{
	
    //Variable que sirve como referencia para mostrarle al usuario una opción a elegir
    public static final int SOLO_LETRAS_Y_ESPACIOS = 0, SOLO_LETRAS = 1, SOLO_NUMEROS_Y_ESPACIOS = 2, SOLO_NUMEROS = 3, SOLO_LETRAS_Y_NUMEROS = 4
            , BOOLEANOS = 5;

    private int a;
    private int Tamano; //Variable que sirve para definir la cantidad de caracteres que el JTextField aceptará
    private JTextField txtField; //JTextField
    
    /**
     * Constructor vacío, acepta 300 caracteres y letras, numeros y espacios
     */
    public CharLimit(){ 
        Tamano = 300;
    	a = 6;
    }

    //Constructor que recibe un JTextField de parámetro (tamaño igual a la longitud del JTextField y acepta cualquier tipo de caracteres)
    /**
     * Constructor que recibe un JTextField, acepta 300 caracteres y letras, numeros y espacios
     * @param TextField - Se le aplicara la configuracion
     */
    public CharLimit(JTextField TextField) {
    	txtField = TextField;
    	txtField.addKeyListener(this);
    	Tamano = 300;
    	a = 6;
    }
    
    //Constructor que recibe como parámetro un JTextField y el número de caracteres que aceptará (acepta cualquier tipo de caracteres)
    /**
     * Constructor recibe JTextField y la cantidad de caracteres que se aceptaran, acepta letras, numeros y espacios
     * @param TextField - Se le aplicara la configuracion
     * @param tamano - Establece numero de caracteres que aceptara
     */
    public CharLimit(JTextField TextField, int tamano) {
    	txtField = TextField;
    	Tamano = tamano;
    	txtField.addKeyListener(this);
    	a = 6;
    }
    
    //Constructor que recibe como parámetro un JTextField, el número de caracteres que se aceptarán y el tipo de datos que aceptará
    /**
     * Constructor, recibe un JTextField, numero de caracteres que se aceptaran y el tipo de caracter que se aceptara
     * @param TextField - Se le aplicara la configuracion
     * @param tamano - Establece el numero de caracteres que aceptara
     * @param tipo_dato - Establece el tipo de caracteres que aceptara
     */
    public CharLimit(JTextField TextField, int tamano, int tipo_dato) {
    	txtField =  TextField;
    	Tamano = tamano;
    	a = tipo_dato;
    	txtField.addKeyListener(this);
    }
    
    /**
     * Regresa el numero de caracteres que se aceptan
     * @return - Regresa el numero de caracteres que acepta
     */
    public int getTamano() {
    	return Tamano;
    }
    
    //Método para establecer el JTextField
    /**
     * Establece el JTextField que usara la libreria
     * @param TextField - Se le aplicara la configuracion
     */
    public void setTextField(JTextField TextField) {
    	txtField = TextField;
    	txtField.addKeyListener(this);
    }
    
    //Método para definir qué tipo de caracteres aceptará
    /**
     * Define el tipo de dato que se aceptaran SOLO_LETRAS_Y_ESPACIOS, SOLO_LETRAS, SOLO_NUMEROS_Y_ESPACIOS, SOLO_NUMEROS, 
     * SOLO_LETRAS_Y_NUMEROS, BOOLEANOS
     * @param tipo - Establece el tipo de caracter que aceptara
     */
    public void defineCaracter(int tipo) {
    	a = tipo;
    }
    
    //Método que define el número de caracteres qeu aceptará el JTextField
    /**
     * Establece el numero de caracteres que aceptara el JTextField
     * @param tamano - Establece el numero de caractere que aceptara
     */
    public void setTamano(int tamano){
    	Tamano = tamano;
    }

    //Métodos manejadores de eventos
    public void keyTyped(KeyEvent e){
    	switch (a) {
            case 0: //Cuando el usuario establece SOLO_LETRAS_Y_ESPACIOS
                if (Character.isLetter(e.getKeyChar()) || Character.isWhitespace(e.getKeyChar()) || Character.isISOControl(e.getKeyChar())) { //Si lo que se ingresó es una letra, espacio en blanco o una tecla de control
                    txtField.setBorder(new LineBorder(Color.black)); //Pinta el borde del JTextField de negro
		}else { //Si no
                    e.consume(); //Lo ignora
                    Toolkit.getDefaultToolkit().beep(); //Da un sonido como referencia
                    txtField.setBorder(new LineBorder(Color.red)); //Pinta el borde del JTextField de rojo
		}
                break;
            case 1: //Cuando el usuario establece SOLO_LETRAS
		if (Character.isLetter(e.getKeyChar()) || Character.isISOControl(e.getKeyChar())) { //Si lo que se ingresó es una letra, espacio en blanco o una tecla de control
                    txtField.setBorder(new LineBorder(Color.black)); //Pinta el borde del JTextField de negro
		}else { //Si no
                    e.consume(); //Lo ignora
                    Toolkit.getDefaultToolkit().beep(); //Da un sonido como referencia
                    txtField.setBorder(new LineBorder(Color.red)); //Pinta el borde del JTextField de rojo
		}
                break;
            case 2: //Cuando el susuario establece SOLO_NUMEROS_Y_ESPACIOS
		if (Character.isDigit(e.getKeyChar()) || Character.isISOControl(e.getKeyChar()) || Character.isWhitespace(e.getKeyChar())) { //Si lo que se ingresó en el JTextField es un dígito o una tecla de control o un espacio
                    txtField.setBorder(new LineBorder(Color.BLACK)); //Pinta el borde del JTextFiel de negro
		}else { //Si no
                    e.consume(); //Lo ignora
                    Toolkit.getDefaultToolkit().beep(); //Da un sonido de referencia
                    txtField.setBorder(new LineBorder(Color.red)); //Pinta el borde del JTextField de rojo
                }
                break;
            case 3: //Cuando el usuario establece SOLO_NUMEROS			
		if (Character.isDigit(e.getKeyChar()) || Character.isISOControl(e.getKeyChar())) { //Si lo que se ingresó en el JTextField es un dígito o una tecla de control
                    txtField.setBorder(new LineBorder(Color.BLACK)); //Pinta el borde del JTextFiel de negro
		}else { //Si no
                    e.consume(); //Lo ignora
                    Toolkit.getDefaultToolkit().beep(); //Da un sonido de referencia
                    txtField.setBorder(new LineBorder(Color.red)); //Pinta el borde del JTextField de rojo
		}
                break;
            case 4: //Cuando el usuario establece SOLO_LETRAS_Y_NUMEROS
		if (Character.isLetter(e.getKeyChar()) || Character.isDigit(e.getKeyChar()) || Character.isISOControl(e.getKeyChar())) {
                    txtField.setBorder(new LineBorder(Color.BLACK)); //Pinta el borde del JTextFiel de negro
		}else {
                    e.consume(); //Lo ignora
                    Toolkit.getDefaultToolkit().beep(); //Da un sonido de referencia
                    txtField.setBorder(new LineBorder(Color.red)); //Pinta el borde del JTextField de rojo
		}
                break;
            case 5: //Cuando el usuario establece BOOLEANO
                if (Character.isDigit(e.getKeyChar()) || e.getKeyChar() == '.' || Character.isISOControl(e.getKeyChar())) { //Si lo que se escribe es un caracter alfabético, espacio en blanco y letra
                    txtField.setBorder(new LineBorder(Color.BLACK)); //Restaura el color del JLabel txtPrecio
                 }else { //Si no
                    e.consume(); //Se ignora
                    Toolkit.getDefaultToolkit().beep(); //Se envía un sonido de atención
                    txtField.setBorder(new LineBorder(Color.red)); //Colorea el borde del JTextField txtPrecio de color rojo
                 }
                 break;
             default: //Si el usuario no definió el tipo de caracteres que se usarán se permitiran letras numeros y espacios
                 if (Character.isLetter(e.getKeyChar()) || Character.isDigit(e.getKeyChar()) || Character.isWhitespace(e.getKeyChar()) || Character.isISOControl(e.getKeyChar())){
                    txtField.setBorder(new LineBorder(Color.BLACK)); //Pinta el borde del JTextFiel de negro
                 }else{
                    e.consume(); //Lo ignora
                    Toolkit.getDefaultToolkit().beep(); //Da un sonido de referencia
                    txtField.setBorder(new LineBorder(Color.red)); //Pinta el borde del JTextField de rojo
                 }
                break;
    	}
    	
    	if (txtField.getText().length() == Tamano) { //Si el número de caracteres del JTextField es igual al tamaño asignado
            e.consume(); //Los ignora
            Toolkit.getDefaultToolkit().beep(); //Da un sonido como referencia
	}

    }
}
