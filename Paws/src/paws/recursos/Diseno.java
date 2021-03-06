package paws.recursos;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import paws.control.Imagenes;

public class Diseno {
	public static Color fondoVentanas = new Color(150,192,150);
	public static Color letras = new Color(25,25,112);
	public static Font fuenteTitulosVentanas;
	public static Font fuenteBotones;
	
	public static void inicializarFuentes(){
		try {
			fuenteTitulosVentanas = Font.createFont(Font.TRUETYPE_FONT,
				new File(RutasArchivo.fuentes + "coustard.ttf"))
				.deriveFont(25f);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fuenteTitulosVentanas);
		} catch (FontFormatException | IOException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),
				"Problema al cargar fuente Paws", JOptionPane.WARNING_MESSAGE,
				Imagenes.getIconoSistema());
			fuenteTitulosVentanas = new Font("Segoe UI Light", Font.PLAIN, 30);
		}
		
		try {
			fuenteBotones = Font.createFont(Font.TRUETYPE_FONT,
				new File(RutasArchivo.fuentes + "telex.ttf"))
				.deriveFont(Font.PLAIN, 12f);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fuenteBotones);
		} catch (FontFormatException | IOException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),
				"Problema al cargar fuente de los botones", JOptionPane.WARNING_MESSAGE,
				Imagenes.getIconoSistema());
			fuenteBotones = new Font("Tahoma", Font.PLAIN, 11);
		}
	}
	
	public static void inicializarLookAndFeel(){
		// Establece un look and feel met�lico, si no lo encuentra, establece el look and feel del sistema operativo.
		try {
			UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(),
					"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	
}
