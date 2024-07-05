package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class MenuPrincipal
 * @description 
 * @HU_CU_REQ 
 * @date 4 jun. 2024
 */
public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	
	/* VARIABLES-GLOBALES 
	 * ALMACENAN 5 MODELOS DE COCINAS */
	public static String m_0 = "Mabe EMP6120PG0", m_1 = "Indurama Parma", m_2 = "Sole COSOL027", m_3 = "Coldex CX602", m_4 = "Reco Dakota";
	
	//ALMACENAN 5 PRECIOS DE COCINAS
	public static double p_0 = 949.0, p_1 = 1089.0, p_2 = 850.0, p_3 = 629.0, p_4 = 849.0;
	
	/* VARIABLES ALMACEN CARACTERISTICAS
	 * ALMACENAN 5 VALORES DE PROFUNDIDAD DE COCINAS */
	public static double prof_0 = 58.6, prof_1 = 67.5, prof_2 = 50.0, prof_3 = 51.5, prof_4 = 66.0;
	
	//ALMACENAN 5 VALORES DE ANCHO
	public static double anch_0 = 60.0, anch_1 = 80.0, anch_2 = 60.0, anch_3 = 61.6, anch_4 = 75.4;
	
	//ALMACENAN 5 VALORES DE ALTO
	public static double alt_0 = 91.0, alt_1 = 94.0, alt_2 = 90.0, alt_3 = 95.0, alt_4 = 94.5;
	
	//5 VARIABLES ALMACENAN LA CANTIDAD DE QUEMADORES DE CADA MODELO DE COCINA
	public static int qdr_0 = 4, qdr_1 = 6, qdr_2 = 4, qdr_3 = 5, qdr_4 = 5;

	
	/* VARIABLES ADICIONALES A LA VENTA
	 * PORCENTAJE DE DESCUENTO POR RANGO DE UNIDADES DE VENTA */
	
	//1 A 5 UNIDADES
	public static double porcRango1 = 7.5;
	
	//6 A 10 UNIDADES
	public static double porcRango2 = 10.0;
	
	//11 A 15 UNIDADES
	public static double porcRango3 = 12.5;
	
	//MÁS DE 15 UNIDADES
	public static double porcRango4 = 15.0;
	
	/* OBSEQUIOS POR UNIDADES VENDIDAS */
	
	//1 UNIDAD
	public static String obsq1 = "Cafetera";
	
	//2 A 5 UNIDADES 
	public static String obsq2 = "Licuadora";
	
	//6 A MÁS UNIDADES
	public static String obsq3 = "Extracto";
	
	//CANTIDAD ÓPTIMA DE VENTA
	public static int cantVent = 20;
	
	//CUOTA DE VENTA ESPERADA POR DIA 
	public static double cuotDiaria = 75000.0;
	
	//VARIBLES - IMPORTE ACUMULADO VENTA-MODELO 
	public static double importeAcumulado0, importeAcumulado1, importeAcumulado2, importeAcumulado3,importeAcumulado4, importeAcumuladoTotal;
	
	//VARIBLES - PORCENTAJE-CUOTA-DIARIA
	public static double  porcentajeCuota0, porcentajeCuota1, porcentajeCuota2, porcentajeCuota3, porcentajeCuota4, porcentajeCuotaTotal;
	
	//VARIBLES - UNIDADES VENDIDAS-VENDIDAS-X-MODELO 
	public static int contadorVenta0, contadorVenta1,contadorVenta2, contadorVenta3, contadorVenta4, contadorVentaTotal;     
	
	//VARIABLES - CANTIDAD-UNIDADES-VENTA 
	public static int cantUniVendidas0, cantUniVendidas1, cantUniVendidas2, cantUniVendidas3, cantUniVendidas4;

	
	
	
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("COCINAS BANMEI S.A.C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 439);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mn_archivo = new JMenu("Archivo");
		menuBar.add(mn_archivo);
		
		JMenuItem mntm_salir = new JMenuItem("Salir");
		mntm_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mn_archivo.add(mntm_salir);
		
		JMenu mn_mantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mn_mantenimiento);
		
		JMenuItem mntm_consultaCocina = new JMenuItem("Consultar cocina");
		mntm_consultaCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA 
				ConsultarCocinas dialog = new ConsultarCocinas();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

			}
		});
		mn_mantenimiento.add(mntm_consultaCocina);
		
		JMenuItem mntm_modificarCocina = new JMenuItem("Modificar cocina");
		mntm_modificarCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				ModificarCocinas dialog = new ModificarCocinas();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_mantenimiento.add(mntm_modificarCocina);
		
		JMenuItem mntm_listarCocina = new JMenuItem("Listar cocina");
		mntm_listarCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA 
				ListarCocinas dialog = new ListarCocinas();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_mantenimiento.add(mntm_listarCocina);
		
		JMenu mn_ventas = new JMenu("Ventas");
		menuBar.add(mn_ventas);
		
		JMenuItem mntm_vender = new JMenuItem("Vender");
		mntm_vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				Vender dialog = new Vender();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_ventas.add(mntm_vender);
		
		JMenuItem mntm_generarReportes = new JMenuItem("Generar reportes");
		mntm_generarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				GenerarReportes dialog = new GenerarReportes();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_ventas.add(mntm_generarReportes);
		
		JMenu mn_configuracion = new JMenu("Configuración");
		menuBar.add(mn_configuracion);
		
		JMenuItem mntm_config_descuento = new JMenuItem("Configurar descuento");
		mntm_config_descuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				ConfigurarDescuentos dialog = new ConfigurarDescuentos();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_configuracion.add(mntm_config_descuento);
		
		JMenuItem mntm_config_obsequio = new JMenuItem("Configurar obsequio");
		mntm_config_obsequio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				ConfigurarObsequios dialog = new ConfigurarObsequios();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_configuracion.add(mntm_config_obsequio);
		
		JMenuItem mntm_config_cantidad_optima = new JMenuItem("Configurar cantidad óptima ");
		mntm_config_cantidad_optima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				ConfigurarCantidadOptima dialog = new ConfigurarCantidadOptima();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_configuracion.add(mntm_config_cantidad_optima);
		
		JMenuItem mntm_cuota_diaria = new JMenuItem("Configurar cuota diaria");
		mntm_cuota_diaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				ConfigurarCuotaDiaria dialog = new ConfigurarCuotaDiaria();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_configuracion.add(mntm_cuota_diaria);
		
		JMenu mn_ayuda = new JMenu("Ayuda");
		menuBar.add(mn_ayuda);
		
		JMenuItem mntm_acercaDeTienda = new JMenuItem("Acerca de tienda");
		mntm_acercaDeTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MOSTRAR VENTANA
				OpcionDeAyuda dialog = new OpcionDeAyuda();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mn_ayuda.add(mntm_acercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
