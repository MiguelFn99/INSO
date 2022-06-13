package vista;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import controlador.Coordinador;
import controlador.EliminarPartidoControlador;
import modelo.vo.PartidoVo;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class VentanaEliminarPartido extends JFrame implements ActionListener{
	JComboBox equipoCb;
	JButton eliminarPartidoBtn;
	EliminarPartidoControlador eliminarPartidoControlador;
	Coordinador coordinador;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JLabel lblPrecaucion;
	
	
	public VentanaEliminarPartido() {
		eliminarPartidoControlador = new EliminarPartidoControlador();
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoja el Partido sin disputar a Eliminar");
		lblNewLabel.setBounds(70, 100, 252, 22);
		getContentPane().add(lblNewLabel);
		
		PartidoVo[] partidos = eliminarPartidoControlador.listaPartidos();
		equipoCb = new JComboBox(partidos);
		equipoCb.setBounds(45, 147, 312, 22);
		getContentPane().add(equipoCb);
		
		eliminarPartidoBtn = new JButton("Eliminar Partido");
		eliminarPartidoBtn.setBounds(115, 192, 150, 39);
		eliminarPartidoBtn.setBackground(Color.WHITE);
		eliminarPartidoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarPartidoBtn.addActionListener(this);
		getContentPane().add(eliminarPartidoBtn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(151, 26, 100, 52);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		lblPrecaucion = new JLabel("Precaución: tenga en cuenta que esta acción es irreversible");
		lblPrecaucion.setBounds(12, 256, 388, 16);
		getContentPane().add(lblPrecaucion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 243, 368, 12);
		separator.setForeground(Color.BLACK);
		getContentPane().add(separator);
		setSize(400,320);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==eliminarPartidoBtn) {
			PartidoVo partidoSelec = (PartidoVo) equipoCb.getSelectedItem();
			eliminarPartidoControlador.eliminarEquipo(partidoSelec.getIdPartido());
			coordinador.cerrarVentanaEliminarPartido();
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		this.coordinador=coordinador;
	}
}
