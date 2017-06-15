package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import datos.MateriasGSON;
import negocio.Aula;
import negocio.Solver;

public class Ventana extends JPanel 
{
	private boolean debug = false;
	private JFrame frame;
	MateriasGSON _materias;
	ArrayList<Aula> _aulas;
	Solver _solver;
	JTable _tabla;
	DefaultTableModel _model;
	
	
	public Ventana()
	{
		super(new GridLayout(1, 0));
	

		String[] aulas;
		String[] materias;
		
		_tabla = new JTable();
		_model = new DefaultTableModel();
		
		_model.addColumn("AULAS");
		
		for(int i=0;i<24;i++){
			_model.addColumn(i+"hs");
		}
		
		 _tabla.setModel(_model);
		 
		 _tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 
		 _tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		 _tabla.setFillsViewportHeight(true);
		   if (debug) {
	            _tabla.addMouseListener(new MouseAdapter() {
	                public void mouseClicked(MouseEvent e) {
	                    printDebugData(_tabla);
	                }
	            });
	        }
	 
	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(_tabla);
	 
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
