package vista;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import controlador.Coordinador;
import controlador.EliminarArbitroControlador;
import modelo.vo.ArbitroVo;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class VentanaEliminarArbitro extends JFrame implements ActionListener{
	JComboBox arbitroCb;
	JButton eliminarArbitroBtn;
	EliminarArbitroControlador eliminarArbitroControlador;
	Coordinador coordinador;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JLabel lblPrecaucion;
	
	
	public VentanaEliminarArbitro() {
		eliminarArbitroControlador = new EliminarArbitroControlador();
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoja el Arbitro a Eliminar");
		lblNewLabel.setBounds(109, 100, 252, 22);
		getContentPane().add(lblNewLabel);
		
		ArbitroVo[] arbitros = eliminarArbitroControlador.listaArbitros();
		
		arbitroCb = new JComboBox(arbitros);
		arbitroCb.setBounds(111, 147, 156, 22);
		getContentPane().add(arbitroCb);
		
		eliminarArbitroBtn = new JButton("Eliminar Arbitro");
		eliminarArbitroBtn.setBackground(Color.WHITE);
		eliminarArbitroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarArbitroBtn.setBounds(115, 192, 150, 39);
		eliminarArbitroBtn.addActionListener(this);
		getContentPane().add(eliminarArbitroBtn);
		
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
		if (e.getSource()==eliminarArbitroBtn) {
			ArbitroVo arbitroSelec = (ArbitroVo) arbitroCb.getSelectedItem();
			eliminarArbitroControlador.eliminarArbitro(arbitroSelec.getIdArbitro());
			coordinador.cerrarVentanaEliminarArbitro();
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		this.coordinador=coordinador;
	}
}
