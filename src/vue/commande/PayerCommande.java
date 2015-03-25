package vue.commande;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue du frame pour la gestion des paiements
 */
public class PayerCommande extends JFrame {

	private JPanel contentPane;
	private JLabel lblEligeElTipo;
	public JTextField txtNoTab;
	private JLabel lblEncabezado;
	private JLabel lblIngresaElNumero;
	public JRadioButton rdbtnSeul;
	public JRadioButton rdbtnParTab;
	public JButton btnGenerer;
	public JButton btnAnnuler;
	public JLabel lblMendsaje;
	private JLabel lblBase1;
	private JLabel lblBase2;
	public JButton btnchercher;

	/**
	 * Create the frame.
	 */
	public PayerCommande() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PayerCommande.class.getResource("../../images/Money_Bag_32.png")));
		setResizable(false);
		setTitle("Payer le commande");
		setBounds(100, 100, 528, 293);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEligeElTipo = new JLabel("Choissisez type :");
		lblEligeElTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEligeElTipo.setBounds(38, 108, 159, 14);
		contentPane.add(lblEligeElTipo);
		
		txtNoTab = new JTextField();
		txtNoTab.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNoTab.setBounds(203, 64, 38, 20);
		contentPane.add(txtNoTab);
		txtNoTab.setColumns(10);
		
		lblIngresaElNumero = new JLabel("Numero du Table");
		lblIngresaElNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngresaElNumero.setBounds(38, 67, 166, 14);
		contentPane.add(lblIngresaElNumero);
		
		rdbtnSeul = new JRadioButton("Individuel");
		rdbtnSeul.setBackground(new Color(238, 232, 170));
		rdbtnSeul.setEnabled(false);
		rdbtnSeul.setBounds(194, 104, 89, 23);
		contentPane.add(rdbtnSeul);
		
		rdbtnParTab = new JRadioButton("Par table");
		rdbtnParTab.setBackground(new Color(238, 232, 170));
		rdbtnParTab.setEnabled(false);
		rdbtnParTab.setSelected(true);
		rdbtnParTab.setBounds(305, 104, 109, 23);
		contentPane.add(rdbtnParTab);
		
		lblMendsaje = new JLabel("");
		lblMendsaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMendsaje.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		lblMendsaje.setBounds(214, 47, 308, 20);
		contentPane.add(lblMendsaje);
		
		lblEncabezado = new JLabel("PAYER LE COMMANDE");
		lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncabezado.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblEncabezado.setBounds(45, 11, 422, 28);
		contentPane.add(lblEncabezado);
		
		btnGenerer = new JButton("G\u00E9n\u00E9rer");
		btnGenerer.setBackground(new Color(152, 251, 152));
		btnGenerer.setEnabled(false);
		btnGenerer.setBounds(121, 149, 109, 34);
		contentPane.add(btnGenerer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 192, 203));
		btnAnnuler.setBounds(302, 149, 89, 34);
		contentPane.add(btnAnnuler);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(PayerCommande.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 212, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(PayerCommande.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(305, 212, 217, 24);
		contentPane.add(lblBase2);
		
		btnchercher = new JButton("Chercher");
		btnchercher.setBounds(273, 63, 89, 23);
		contentPane.add(btnchercher);
	}
}
