package vue.commande;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue modifyligne
 */
public class ModifyLigne extends JFrame {

	private JPanel contentPane;
	public JTextField txtMLCom;
	public JTextField txtMLPersonne;
	public JTextField txtMLLig;
	private JLabel lblOrden;
	private JLabel lblComensal;
	private JLabel lblLinea;
	private JLabel lblNomAssiette;
	private JLabel lblTypeAssiette;
	public JButton btnMLEnregistrer;
	public JComboBox<String> cmbMLType;
	public JTextField txtMLPrix;
	private JLabel lblPrix;
	public JButton btnMLAnnuler;
	private JLabel label;
	public JComboBox <String>cmbMLMAss;
	DecimalFormat dec = new DecimalFormat("##0.00");
	private JLabel lblBase1;
	private JLabel lblBase2;

	/**
	 * Create the frame.
	 */
	public ModifyLigne() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModifyLigne.class.getResource("../../images/steak-32.png")));
		setResizable(false);
		setTitle("Modifier commande");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblOrden = new JLabel("Num commande");
		lblOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrden.setBounds(36, 11, 120, 14);
		contentPane.add(lblOrden);
		
		txtMLCom = new JTextField();
		txtMLCom.setEditable(false);
		txtMLCom.setColumns(10);
		txtMLCom.setBounds(50, 29, 86, 20);
		contentPane.add(txtMLCom);
		
		lblComensal = new JLabel("Nombre personne");
		lblComensal.setHorizontalAlignment(SwingConstants.CENTER);
		lblComensal.setBounds(149, 11, 152, 14);
		contentPane.add(lblComensal);
		
		txtMLPersonne = new JTextField();
		txtMLPersonne.setEditable(false);
		txtMLPersonne.setColumns(10);
		txtMLPersonne.setBounds(187, 29, 86, 20);
		contentPane.add(txtMLPersonne);
		
		lblLinea = new JLabel("Nombre ligne");
		lblLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinea.setBounds(294, 11, 145, 14);
		contentPane.add(lblLinea);
		
		txtMLLig = new JTextField();
		txtMLLig.setEditable(false);
		txtMLLig.setColumns(10);
		txtMLLig.setBounds(318, 29, 86, 20);
		contentPane.add(txtMLLig);
		
		lblTypeAssiette = new JLabel("Type d'Assiette");
		lblTypeAssiette.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeAssiette.setBounds(10, 87, 146, 14);
		contentPane.add(lblTypeAssiette);
		
		lblNomAssiette = new JLabel("Nom d'Assiette");
		lblNomAssiette.setBounds(166, 87, 134, 14);
		contentPane.add(lblNomAssiette);
		
		lblPrix = new JLabel("Prix:");
		lblPrix.setBounds(368, 87, 57, 14);
		contentPane.add(lblPrix);
		
		btnMLEnregistrer = new JButton("Enregistrer");
		btnMLEnregistrer.setBackground(new Color(152, 251, 152));
//		btnAadir.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lineas=Integer.parseInt(txtLinea.getText());
//				/** se llena  el arreglo*/
//				objeto[lineaamod][0]=txtOrden.getText();
//				objeto[lineaamod][1]=txtComensal.getText();
//				objeto[lineaamod][2]=txtLinea.getText();
//				objeto[lineaamod][3]=id_platillo;
//				objeto[lineaamod][4]=textAreaNotas.getText();
//				
////				for(int fi=0; fi<contador; fi++){
////					for(int columna=0; columna<5; columna++){
////						System.err.println("Nuevo "+objeto[fi][columna]);
////					}
////				}
//				
//				AlimOrdenados al=new AlimOrdenados();
//				al.llenarTabla(objeto, contador);
//				al.setLocationRelativeTo(null);
//				al.setVisible(true);
//				setVisible(false);
//			}
//		});
		btnMLEnregistrer.setBounds(93, 189, 120, 42);
		contentPane.add(btnMLEnregistrer);
		
		cmbMLType = new JComboBox<String>();
		cmbMLType.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Salade", "Entree", "Dessert"}));
		cmbMLType.setBounds(24, 104, 132, 20);
		contentPane.add(cmbMLType);
		
		txtMLPrix = new JTextField();
		txtMLPrix.setEditable(false);
		txtMLPrix.setBounds(354, 105, 71, 20);
		contentPane.add(txtMLPrix);
		txtMLPrix.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 447, 2);
		contentPane.add(separator);
		
		btnMLAnnuler = new JButton("Annuler");
		btnMLAnnuler.setBackground(new Color(255, 192, 203));
		btnMLAnnuler.setBounds(257, 189, 108, 42);
		contentPane.add(btnMLAnnuler);
		
		label = new JLabel("\u20AC");
		label.setBounds(428, 107, 19, 14);
		contentPane.add(label);
		
		cmbMLMAss = new JComboBox<String>();
		cmbMLMAss.setEnabled(false);
		cmbMLMAss.setBounds(168, 104, 181, 20);
		contentPane.add(cmbMLMAss);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(ModifyLigne.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 263, 315, 48);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(ModifyLigne.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(189, 263, 315, 48);
		contentPane.add(lblBase2);
	}

}
