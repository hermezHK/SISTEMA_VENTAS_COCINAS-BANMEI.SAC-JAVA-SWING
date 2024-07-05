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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Vender extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_precio;
	private JTextField txt_cantidad;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JComboBox cmb_modelo_ventas;

	// DECLARACION VARIABLES DE LOS PRODUCTOS Y BENEFICIOS ADICIONALES
	public static double precioVenta, impCompra, impDescuento, impPagar;
	public static int cantidadVenta;
	public static String obsequio;
	private JTextArea txt_area_vender;

	/**
	 * Create the dialog.
	 */
	public Vender() {
		setTitle("Vender");
		setBounds(285, 150, 558, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// Titulo
		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 237, 41);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Modelo ");
		lblNewLabel_1.setBounds(10, 64, 80, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 100, 80, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(10, 136, 80, 14);
		contentPanel.add(lblNewLabel_3);

		btn_aceptar = new JButton("Vender");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptar();
			}
		});
		btn_aceptar.setBounds(381, 60, 108, 23);
		contentPanel.add(btn_aceptar);

		btn_cancelar = new JButton("Cerrar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelar();
			}
		});
		btn_cancelar.setBounds(381, 100, 108, 23);
		contentPanel.add(btn_cancelar);

		txt_precio = new JTextField();
		txt_precio.setEditable(false);
		txt_precio.setColumns(10);
		txt_precio.setBounds(82, 97, 125, 20);
		contentPanel.add(txt_precio);

		txt_cantidad = new JTextField();
		txt_cantidad.setColumns(10);
		txt_cantidad.setBounds(82, 133, 125, 20);
		contentPanel.add(txt_cantidad);

		cmb_modelo_ventas = new JComboBox();
		cmb_modelo_ventas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cargarPrecio();
			}
		});
		cmb_modelo_ventas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cmb_modelo_ventas.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cmb_modelo_ventas.setBounds(82, 60, 125, 22);
		contentPanel.add(cmb_modelo_ventas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 506, 225);
		contentPanel.add(scrollPane);

		txt_area_vender = new JTextArea();
		scrollPane.setViewportView(txt_area_vender);

	}

	void cargarPrecio() {
		// CARGANDO EL PRECIO DE ACUERDO AL MODELO SELECIONADO
		int item = cmb_modelo_ventas.getSelectedIndex();
		txt_precio.setText("" + precio(item));
	}

	// METODO PARA TRAER EL PRECIO AL ELEGIR UN ITEM DEL JCOMBOBOX
	double precio(int item) {
		switch (item) {
		case 0:
			return MenuPrincipal.p_0;
		case 1:
			return MenuPrincipal.p_1;
		case 2:
			return MenuPrincipal.p_2;
		case 3:
			return MenuPrincipal.p_3;
		default:
			return MenuPrincipal.p_4;
		}
	}

	void botonCancelar() {
		this.dispose();

	}

	void botonAceptar() {
		// REALIZAR LOS MÉTODOS DESPUES ELEGIR EL BÓTON ACEPTAR
		obtenerDatos();
		importeCompra();
		importeDescuento();
		importePagar();
		obtenerObsequio();
		mostrarResultados();
		contAcumulados();
		contAcumuladoTotal();
		mostrarMensajePantalla();
	}

	// OBTERNER LOS DATOS INGRESADOS DEL USUARIO

	void obtenerDatos() {
		precioVenta = Double.parseDouble(txt_precio.getText());
		cantidadVenta = Integer.parseInt(txt_cantidad.getText());
	}

	// CALCULAR IMPORTE-COMPRA
	void importeCompra() {

		impCompra = precioVenta * cantidadVenta;
	}

	// CAULCULAR IMPORTE-DESCUENTO
	void importeDescuento() {
		if (cantidadVenta >= 16)
			impDescuento = impCompra * MenuPrincipal.porcRango4 / 100;
		else if (cantidadVenta >= 11)
			impDescuento = impCompra * MenuPrincipal.porcRango3 / 100;
		else if (cantidadVenta >= 6)
			impDescuento = impCompra * MenuPrincipal.porcRango2 / 100;
		else
			impDescuento = impCompra * MenuPrincipal.porcRango1 / 100;
	}

	// CALCULAR IMPORTE-PAGAR
	void importePagar() {
		impPagar = impCompra - impDescuento;
	}

	// OBTENIENDO EL OBSEQUIO-VENTA
	void obtenerObsequio() {
		if (cantidadVenta >= 6)
			obsequio = MenuPrincipal.obsq3;
		else if (cantidadVenta >= 2 )
			obsequio = MenuPrincipal.obsq2;
		else
			obsequio = MenuPrincipal.obsq1;
	}

	// MOSTRAR LOS RESULTADOS EN AREA DE TEXTO-VENDER
	void mostrarResultados() {
		// METODO QUE REAALIZA EL REDONDEO NUMERO DECIMAL
		DecimalFormat formato1 = new DecimalFormat("0.00");
		txt_area_vender.setText("");
		txt_area_vender.append("BOLETA DE VENTA" + "\n\n");
		txt_area_vender.append("Modelo            : " + cmb_modelo_ventas.getSelectedItem() + "\n");
		txt_area_vender.append("Precio            : S/. " + formato1.format(precioVenta) + "\n");
		txt_area_vender.append("Cantidad          : " + cantidadVenta + "\n");
		txt_area_vender.append("Importe compra    : S/. " + formato1.format(impCompra) + "\n");
		txt_area_vender.append("Importe descuento : S/. " + formato1.format(impDescuento) + "\n");
		txt_area_vender.append("Importe pagar     : S/. " + formato1.format(impPagar) + "\n");
		txt_area_vender.append("Obsequio          : " + obsequio);
	}

//CALCULAR LOS CONTADORES Y ACUMULADORES POR MODELO  
	void contAcumulados() {
		int item = cmb_modelo_ventas.getSelectedIndex();
		/*
		 * CALCULAR CANTIDAD-VENTAS, IMPORTE-PAGO, PUNIDADES, PORCENTAJE-MODELOS
		 */
		switch (item) {
		case 0:
			MenuPrincipal.contadorVenta0++;
			MenuPrincipal.importeAcumulado0 += impPagar;
			MenuPrincipal.porcentajeCuota0 = (MenuPrincipal.importeAcumulado0 / MenuPrincipal.cuotDiaria) * 100;
			MenuPrincipal.cantVent += cantidadVenta;
			break;
		case 1:
			MenuPrincipal.contadorVenta1++;
			MenuPrincipal.importeAcumulado1 += impPagar;
			MenuPrincipal.porcentajeCuota1 = (MenuPrincipal.importeAcumulado0 / MenuPrincipal.cuotDiaria) * 100;
			MenuPrincipal.cantVent += cantidadVenta;
			break;
		case 2:
			MenuPrincipal.contadorVenta2++;
			MenuPrincipal.importeAcumulado2 += impPagar;
			MenuPrincipal.porcentajeCuota2 = (MenuPrincipal.importeAcumulado0 / MenuPrincipal.cuotDiaria) * 100;
			MenuPrincipal.cantVent += cantidadVenta;
			break;
		case 3:
			MenuPrincipal.contadorVenta3++;
			MenuPrincipal.importeAcumulado3 += impPagar;
			MenuPrincipal.porcentajeCuota3 = (MenuPrincipal.importeAcumulado0 / MenuPrincipal.cuotDiaria) * 100;
			MenuPrincipal.cantVent += cantidadVenta;
			break;
		default:
			MenuPrincipal.contadorVenta4++;
			MenuPrincipal.importeAcumulado4 += impPagar;
			MenuPrincipal.porcentajeCuota4 = (MenuPrincipal.importeAcumulado0 / MenuPrincipal.cuotDiaria) * 100;
			MenuPrincipal.cantVent += cantidadVenta;
		}
	}

	// CALCULAR ACUMULADORES Y CONTADORES TOTALES
	void contAcumuladoTotal() {
		MenuPrincipal.contadorVentaTotal++;
		MenuPrincipal.importeAcumuladoTotal += impPagar;
		MenuPrincipal.porcentajeCuotaTotal += (impPagar / MenuPrincipal.cuotDiaria) * 100;
	}

	// METODO MOSTRAR MENSAJE EN PANTALLA CADA 5 VENTAS
	void mostrarMensajePantalla() {     //SI LA VENTAS ES MULTIPLO DE 5 SE MOSTRARÁ EL MENSAJE    
		if (MenuPrincipal.contadorVentaTotal % 5 == 0) {            
			JOptionPane.showInternalMessageDialog(null, "Venta Nro. " + MenuPrincipal.contadorVentaTotal + "\n" + "Importe total general acumulado: S/." + Math.round(MenuPrincipal.importeAcumuladoTotal*100.0)/100.0 + "\n" + "Porcentaje de la cuota diaria: " + Math.round(MenuPrincipal.porcentajeCuotaTotal*100.0)/100.0 + "%", "Realizo 5 Ventas" , 1, null);
		}
	}
}