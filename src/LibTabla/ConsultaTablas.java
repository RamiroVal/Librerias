package LibTabla;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *Libreria que crea un JTable en un JDialog, recibiendo un JFrame, el titulo del JDialog,
 * un arreglo de String con los nombres de las columnas y una matriz de String con los datos que se quieren mostrar
 * @author jesus
 */
public class ConsultaTablas extends JDialog{
	
    public ConsultaTablas(JFrame frame, String titulo,  String[] titulos, String[][] datos) {
        super(frame, titulo, true);
        setSize(700, 200);
	setResizable(false);
	setLocationRelativeTo(null);
		
	JTable tblTabla = new JTable(datos, titulos);
	tblTabla.setPreferredScrollableViewportSize(new Dimension(500, 800));

	JScrollPane scpScroll = new JScrollPane(tblTabla);
	
	getContentPane().add(scpScroll, BorderLayout.CENTER);
		
    }

}
