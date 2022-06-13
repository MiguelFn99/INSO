package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.MensajeVo;

public class MensajeDao {

	public void crearMensaje(MensajeVo mensaje){
		
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO mensaje (idmensaje, idJugador, mensaje) VALUES ('"
					+mensaje.getIdMensaje()+"', '"+mensaje.getIdJugador()+"', '"+mensaje.getMensaje()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (Exception e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registró");
		}
		
	}

    public ArrayList<MensajeVo> buscarMensajes() {
        Conexion conex = new Conexion();
        ArrayList<MensajeVo> mensajes = new ArrayList<MensajeVo>();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM mensaje ");
            ResultSet res = consulta.executeQuery();

            while(res.next()) {
                mensajes.add(new MensajeVo(Integer.parseInt(res.getString(1)), 
                        Integer.parseInt(res.getString(2)), 
                        res.getString(3)));
            }

            res.close();
            consulta.close();
            conex.desconectar();

        } catch(Exception e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        return mensajes;
     }



}
