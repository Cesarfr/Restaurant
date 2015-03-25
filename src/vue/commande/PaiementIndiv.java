package vue.commande;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue PaiementIndivisuel
 */
public class PaiementIndiv extends JFrame {

	private JPanel contentPane;
	private JLabel lblIndividual;
	private JLabel lblNoOrden;
	private JLabel lblComensal;
	public JScrollPane scrollTabla;
	public JTable tabAssi;
	public JTextField txtTotal;
	private JLabel lblTotalAPagar;
	public DefaultTableModel dtm;
	private JLabel lblIngresaElMonto;
	public JTextField txtNoComm;
	public JTextField txtNoPers;
	public JTextField txtMonto;
	public JTextField txtMonn;
	private JLabel lblElCambioEs;
	public JButton btnSuivante;
	public JButton btnAnnuler;
	public JButton btnMonnaie;
	private JLabel label;
	private JLabel lbleuro;
	private JLabel lblBase1;
	private JLabel lblBase2;
	public JLabel lblEmplo;
	

	/**
	 * Create the frame.
	 */
	public PaiementIndiv() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaiementIndiv.class.getResource("../../images/Money_Bag_32.png")));
		setResizable(false);
		setTitle("Paiement individuel");
		setBounds(100, 100, 606, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIndividual = new JLabel("PAIEMENT INDIVIDUEL");
		lblIndividual.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndividual.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblIndividual.setBounds(146, 14, 327, 34);
		contentPane.add(lblIndividual);
		
		lblNoOrden = new JLabel("No. comm:");
		lblNoOrden.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoOrden.setBounds(31, 59, 68, 14);
		contentPane.add(lblNoOrden);
		
		lblComensal = new JLabel("Personne:");
		lblComensal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComensal.setHorizontalAlignment(SwingConstants.CENTER);
		lblComensal.setBounds(191, 59, 86, 14);
		contentPane.add(lblComensal);
		
		scrollTabla = new JScrollPane();
		scrollTabla.setBounds(31, 84, 530, 116);
		contentPane.add(scrollTabla);
		
		String[] columnNames = {"No. Ligne","Assiette","Prix"};
		dtm= new DefaultTableModel(null, columnNames);
		tabAssi = new JTable(dtm);
		tabAssi.setBounds(31, 176, 129, 43);
		scrollTabla.setViewportView(tabAssi);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(431, 200, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		lblTotalAPagar = new JLabel("Total:");
		lblTotalAPagar.setBounds(352, 204, 110, 14);
		contentPane.add(lblTotalAPagar);
		
		lblIngresaElMonto = new JLabel("Saisissez le montant du paiement:");
		lblIngresaElMonto.setBounds(31, 214, 246, 14);
		contentPane.add(lblIngresaElMonto);
		
		txtNoComm = new JTextField();
		txtNoComm.setEditable(false);
		txtNoComm.setBounds(109, 56, 44, 20);
		contentPane.add(txtNoComm);
		txtNoComm.setColumns(10);
		
		txtNoPers = new JTextField();
		txtNoPers.setEditable(false);
		txtNoPers.setBounds(279, 56, 44, 20);
		contentPane.add(txtNoPers);
		txtNoPers.setColumns(10);
		
		txtMonto = new JTextField();
		txtMonto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMonto.setBounds(31, 236, 55, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		txtMonn = new JTextField();
		txtMonn.setEditable(false);
		txtMonn.setBounds(146, 278, 114, 20);
		contentPane.add(txtMonn);
		txtMonn.setColumns(10);
		
		lblElCambioEs = new JLabel("Le monnaie est:");
		lblElCambioEs.setBounds(31, 280, 122, 14);
		contentPane.add(lblElCambioEs);
		
		btnSuivante = new JButton("Suivante"); // cambia de comensal
		btnSuivante.setBackground(new Color(152, 251, 152));
		btnSuivante.setEnabled(false);
		btnSuivante.setBounds(129, 327, 148, 32);
		contentPane.add(btnSuivante);
		
		btnAnnuler = new JButton("Annuler");// cancela la operacion
		btnAnnuler.setBackground(new Color(255, 192, 203));
		btnAnnuler.setBounds(325, 327, 148, 32);
		contentPane.add(btnAnnuler);
		
		btnMonnaie = new JButton("Monnaie");
		btnMonnaie.setBackground(new Color(245, 222, 179));
		btnMonnaie.setBounds(127, 235, 105, 23);
		contentPane.add(btnMonnaie);
		
		label = new JLabel("\u20AC");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(90, 237, 19, 14);
		contentPane.add(label);
		
		lbleuro = new JLabel("\u20AC");
		lbleuro.setHorizontalAlignment(SwingConstants.RIGHT);
		lbleuro.setBounds(258, 280, 19, 14);
		contentPane.add(lbleuro);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(PaiementIndiv.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 393, 315, 47);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(PaiementIndiv.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(314, 393, 286, 47);
		contentPane.add(lblBase2);
		
		JLabel label_5 = new JLabel("\u20AC");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(523, 202, 19, 14);
		contentPane.add(label_5);
		
		lblEmplo = new JLabel("New label");
		lblEmplo.setBounds(469, 47, 46, 14);
		contentPane.add(lblEmplo);
	}
}
