package vista;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import controlador.Coordinador;
import controlador.EliminarEquipoControlador;
import modelo.vo.EquipoVo;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class VentanaEliminarEquipo extends JFrame implements ActionListener{
	JComboBox equipoCb;
	JButton eliminarEquipoBtn;
	EliminarEquipoControlador eliminarEquipoControlador;
	Coordinador coordinador;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JLabel lblPrecaucion;
	
	
	public VentanaEliminarEquipo() {
		eliminarEquipoControlador = new EliminarEquipoControlador();
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoja el Equipo a Eliminar");
		lblNewLabel.setBounds(109, 100, 252, 22);
		getContentPane().add(lblNewLabel);
		
		EquipoVo[] equipos = eliminarEquipoControlador.listaEquipos();
		
		equipoCb = new JComboBox(equipos);
		equipoCb.setBounds(103, 147, 185, 22);
		getContentPane().add(equipoCb);
		
		eliminarEquipoBtn = new JButton("Eliminar Equipo");
		eliminarEquipoBtn.setBackground(Color.WHITE);
		eliminarEquipoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarEquipoBtn.setBounds(115, 192, 150, 39);
		eliminarEquipoBtn.addActionListener(this);
		getContentPane().add(eliminarEquipoBtn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(151, 26, 100, 52);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		lblPrecaucion = new JLabel("Precaución: tenga en cuenta que esta acción es irreversible");
		lblPrecaucion.setBounds(12, 256, 388, 16);
		getContentPane().add(lblPrecaucion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(12, 243, 368, 12);
		getContentPane().add(separator);
		setSize(400,330);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==eliminarEquipoBtn) {
			EquipoVo equipoSelec = (EquipoVo) equipoCb.getSelectedItem();
			eliminarEquipoControlador.eliminarEquipo(equipoSelec.getIdEquipo());
			coordinador.cerrarVentanaEliminarEquipo();
			}
	}

	public void setCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		this.coordinador=coordinador;
	}
}
