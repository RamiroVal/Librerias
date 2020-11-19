package LibTexto;

import java.awt.Font;

import javax.swing.JLabel;
/**
 *Libreria que establece una configuracion a JLabel para usarlo por defecto
 * en AppInventario (Calibri, negritas, tamaño 14)
 * @author jesus
 */
public class LabelDefault extends JLabel{
	
    public LabelDefault() {
        setFont(new Font("Calibri", Font.BOLD, 14));
    }
	
    public LabelDefault(String titulo) {
        super(titulo);
        setFont(new Font("Calibri", Font.BOLD, 14));
    }
    
}
