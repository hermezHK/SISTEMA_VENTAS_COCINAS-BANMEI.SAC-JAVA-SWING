package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class OpcionDeAyuda
 * @description
 * @HU_CU_REQ
 * @date 10 jun. 2024
 */
public class OpcionDeAyuda extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public OpcionDeAyuda() {
		setTitle("Acerca de Tienda");
		setBounds(480, 220, 571, 394);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(157, 11, 253, 22);
		getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setBounds(0, 31, 555, 2);
		getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("Autores");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(221, 44, 95, 27);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Jaramillo Pacaya, Hermel Hermez");
		lblNewLabel_2.setBounds(189, 80, 221, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Garcia Rodas Edin Jesus");
		lblNewLabel_2_1.setBounds(189, 107, 221, 14);
		getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Gamarra Mendoza, Pedro Arturo");
		lblNewLabel_2_2.setBounds(189, 132, 221, 14);
		getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Terrazas Miranda, Sergio André");
		lblNewLabel_2_3.setBounds(189, 157, 221, 14);
		getContentPane().add(lblNewLabel_2_3);

		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCerrarAyuda(); // BOTÓN CERRAR DE LA VENTANA AYUDA
			}
		});
		btnNewButton.setBounds(221, 228, 89, 23);
		getContentPane().add(btnNewButton);

	}

	void botonCerrarAyuda() {
		this.dispose(); // MÉTODO PARA CERRAR LA VENTANA ACTUAL

	}
}
