package controlador;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class CambiarSkin {

	// Cambiamos el Skin segun lo que seleccionamos en el panel principal
	public static void setSkin(String skin) {
		try {
			switch (skin) {
			case "FlatLightLaf": {
				UIManager.setLookAndFeel(new FlatLightLaf());
				break;
			}
			case "FlatDarkLaf": {
				UIManager.setLookAndFeel(new FlatDarkLaf());
				break;
			}
			case "FlatMacDarkLaf": {
				UIManager.setLookAndFeel(new FlatMacDarkLaf());
				break;
			}
			default:
				throw new IllegalArgumentException("No se puedo aplicar el skin: " + skin);
			}

			// Repintamos todas las ventanas despues de aplicar el cambio de la skin
			SwingUtilities.invokeLater(() -> {
				for (Frame frame : Frame.getFrames()) {
					if (frame instanceof JFrame) {
						SwingUtilities.updateComponentTreeUI((JFrame) frame);
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
