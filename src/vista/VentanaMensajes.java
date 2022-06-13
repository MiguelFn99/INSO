package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controlador.Coordinador;
import controlador.MensajesControlador;
import modelo.vo.MensajeVo;

public class VentanaMensajes extends JFrame {

	private JTable mensajesJt;
	private MensajesControlador mensajesControlador;
	private Coordinador coordinador;

	public VentanaMensajes() {

		// Ventana
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(new BorderLayout());
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);

		int wordWrapColumnIndex = 3;
		mensajesJt = new JTable();
		mensajesJt.setAutoCreateRowSorter(true);
		llenarTabla(mensajesJt);
		getContentPane().add(new JScrollPane(mensajesJt), BorderLayout.CENTER);

	}

	private void llenarTabla(JTable mensajesJt) {

		DefaultTableModel modeloTabla = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Aqu� devolvemos true o false seg�n queramos que una celda
				// identificada por fila,columna (row,column), sea o no editable
				return false;
			}
		};

		//
		mensajesJt.setModel(modeloTabla);

		// Añado las columnas
		modeloTabla.addColumn("ID Mensaje");
		modeloTabla.addColumn("Jugador");
		modeloTabla.addColumn("Mensaje");
		
		//Cambiar el ancho de las columnas
		mensajesJt.getColumnModel().getColumn(0).setMaxWidth(50);
		mensajesJt.getColumnModel().getColumn(1).setMinWidth(100);
		mensajesJt.getColumnModel().getColumn(1).setMaxWidth(100);
		
		//Añadir textArea a las celdas de la columna 2
		mensajesJt.getColumnModel().getColumn(2).setCellRenderer(
			      new TextAreaRenderer());

		// Creo una lista con todos los mensajes
		mensajesControlador = new MensajesControlador();
		ArrayList<MensajeVo> listaMensajes = mensajesControlador.listaMensajes();
		int numMensajes = listaMensajes.size();
		Object[] columna = new Object[3];

		for (int i = 0; i < numMensajes; i++) {
			columna[0] = listaMensajes.get(i).getIdMensaje();
			columna[1] = mensajesControlador.buscarJugador(listaMensajes.get(i).getIdJugador()).toString();
			columna[2] = "";
			modeloTabla.addRow(columna);
			modeloTabla.setValueAt(listaMensajes.get(i).getMensaje(), i, 2);
			mensajesJt.setRowHeight(i, 100);
		}
		
		//Align Center Columnas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		mensajesJt.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		mensajesJt.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );

		((DefaultTableCellRenderer) mensajesJt.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(SwingConstants.CENTER);
		
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public class TextAreaRenderer extends JTextArea implements TableCellRenderer {

		public TextAreaRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
		}

		public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText((String) obj);
			return this;
		}
	}

}
