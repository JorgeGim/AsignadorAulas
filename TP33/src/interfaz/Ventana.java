package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class Ventana extends JPanel 
{
	private boolean debug = false;
	
	public Ventana()
	{
		super(new GridLayout(1, 0));
		
		String[] datosMateria = {"Materia","Inicio","Fin","Aula"};
		
		 Object[][] data = {
			        {"Kathy", "Smith",
			         "Snowboarding", new Integer(5), new Boolean(false)},
			        {"John", "Doe",
			         "Rowing", new Integer(3), new Boolean(true)},
			        {"Sue", "Black",
			         "Knitting", new Integer(2), new Boolean(false)},
			        {"Jane", "White",
			         "Speed reading", new Integer(20), new Boolean(true)},
			        {"Joe", "Brown",
			         "Pool", new Integer(10), new Boolean(false)}
			        };
		 
		 final JTable tabla = new JTable(data, datosMateria);
		 tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		 tabla.setFillsViewportHeight(true);
		 
		   if (debug) {
	            tabla.addMouseListener(new MouseAdapter() {
	                public void mouseClicked(MouseEvent e) {
	                    printDebugData(tabla);
	                }
	            });
	        }
	 
	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(tabla);
	 
	        //Add the scroll pane to this panel.
	        add(scrollPane);
	}
	
	private void printDebugData(JTable tabla)
	{
		int nroFilas = tabla.getRowCount();
		int nroColumnas = tabla.getColumnCount();
		javax.swing.table.TableModel model = tabla.getModel();
		
		 System.out.println("Value of data: ");
	        for (int i=0; i < nroFilas; i++) {
	            System.out.print("    row " + i + ":");
	            for (int j=0; j < nroColumnas; j++) {
	                System.out.print("  " + model.getValueAt(i, j));
	            }
	            System.out.println();
	        }
	        System.out.println("--------------------------");
	}
	
	 private static void mostrarVentana() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("SimpleTableDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        Ventana newContentPane = new Ventana();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mostrarVentana();
			}
		});
	}
}
