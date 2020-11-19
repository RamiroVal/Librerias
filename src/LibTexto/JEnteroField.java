package LibTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  JEnteroField extends JTextField implements KeyListener{
    private int Tamano;
    public JEnteroField(int n){
        super(n);
    	Tamano=n;
    	addKeyListener(this);
    }
    
    public void keyPressed( KeyEvent e   ) {
        if(e.isControlDown())
            if(e.getKeyCode()==KeyEvent.VK_X  || e.getKeyCode()==KeyEvent.VK_C || e.getKeyCode()==KeyEvent.VK_V)
                e.consume();
    }
    
    public void keyReleased(KeyEvent e){
    }
    
    public void keyTyped(KeyEvent e){
        if( getText().length()==Tamano)
            e.consume();
        else
            if(getText().length()!=0 && e.getKeyChar()=='-' )
                e.consume();
            else
                if(!(e.getKeyChar()>='0' && e.getKeyChar()<='9' || e.getKeyChar()=='-'))
                    e.consume();
    }
}