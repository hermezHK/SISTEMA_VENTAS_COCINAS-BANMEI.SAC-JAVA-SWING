package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class ConfigurarCantidadOptima
 * @description
 * @HU_CU_REQ
 * @date 10 jun. 2024
 */
public class ConfigurarCantidadOptima extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_cant_opt;
	private JButton btn_aceptar;
	private JButton btn_cancelar;

	/**
	 * Create the dialog.
	 */
	public ConfigurarCantidadOptima() {
		setTitle(" Configurar cantidad óptima");
		setBounds(530, 230, 558, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);

		// TITULO
		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 237, 41);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cantidad óptima de unidades vendidas");
		lblNewLabel_1.setBounds(10, 81, 225, 14);
		contentPanel.add(lblNewLabel_1);

		txt_cant_opt = new JTextField();
		txt_cant_opt.setBounds(245, 78, 86, 20);
		contentPanel.add(txt_cant_opt);
		txt_cant_opt.setColumns(10);

		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptar(); //BOTÓN ACEPTAR DE LA VENTANA CONFIGURAR-CANTIDAD-ÓPTIMA
			}
		});
		btn_aceptar.setBounds(415, 77, 89, 23);
		contentPanel.add(btn_aceptar);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelar(); //BOTÓN CANCELAR DE LA VENTANA CONFIGURAR-CANTIDAD-ÓPTIMA
			}
		});
		btn_cancelar.setBounds(415, 111, 89, 23);
		contentPanel.add(btn_cancelar);
		
		// MUESTRA LOS CANTIDAD-ÓPTIMA EN PANTALLA (OUTPUT)
		txt_cant_opt.setText("" + MenuPrincipal.cantVent);
	}

	void botonCancelar() {
		this.dispose(); // MÉTODO DE HACE REFERENCIA PARA CERRAR LA VENTANA ACTUAL

	}

	void botonAceptar() {
		// PERMITE MANEJAR ERRORES DE TIEMPO DE EJECUCIÓN QUE PUEDEN OCURRIR MIENTRAS SE EJECUTA EL PROGRAMA.
		try {
			MenuPrincipal.cantVent = Integer.parseInt(txt_cant_opt.getText());

			/*
			 * NumberFormatException LA EXCEPCIÓN SE USA COMO INDICADOR SI LA CONVERSIÓN DE
			 * STRING A UN NÚMERO NO ES POSIBLE. EL NÚMERO PUEDE SER ENTERO, FLOTANTE O
			 * DECIMAL SEGÚN SUS REQUISITOS
			 */
		} catch (NumberFormatException e) {
			// MENSAJE DE EXCEPTION INFORMA AL USUARIO FINAL
			JOptionPane.showMessageDialog(null, "Ingrese valores númericos ");
			return;

		}
		// MENSAJE MODIFICACIÓN EXITOSA DE LOS DATOS
		JOptionPane.showInternalMessageDialog(null, "Modificado correctamente");
		this.dispose(); // USUARIO ACEPTA LOS CAMBIOS SE INGRESA METODO CERRAR VENTANA ACTUAL
	}

}
