package vue.employe;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;
import org.freixas.jcalendar.JCalendarCombo;
import javax.swing.JPasswordField;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue pour ajouter une employe
 */
@SuppressWarnings("serial")
public class AjoEmploye extends JFrame {

	private JPanel contentPane;
	private JLabel lblNom;
	private JLabel lblApellidoPaterno;
	private JLabel lblDateNaiss;
	private JLabel lblSexe;
	private JLabel lblEmploi;
	private JLabel lblVille;
	private JLabel lblNmero;
	private JLabel lblPays;
	private JLabel lblTelf;
	private JLabel lblRue;
	private JLabel lblStat;
	public JLabel lblStatus;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblBase3;
	private JLabel lblAjouterEmp;
	public JRadioButton rdbtnHomme;
	public JRadioButton rdbtnFemme;
	public JButton btnAddEmploi;
	public JButton btnSortirAjoEmp;
	public JTextField txtNom;
	public JTextField txtPrenom;
	public JTextField txtTel;
	public JTextField txtRue;
	public JTextField txtNum;
	public JTextField txtVille;
	public JTextField txtPay;
	public JComboBox<String> cmbEmploi;
	public JCalendarCombo calendario;
	private JLabel lblUser;
	public JTextField txtUserS;
	public JPasswordField txtPassS;
	private JLabel lblPassword;
	public JLabel lblIDAjo;


	/**
	 * Create the frame.
	 */
	public AjoEmploye() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjoEmploye.class.getResource("../../images/FormatFactoryempleado.png")));
		setTitle("Ajouter Employe");
		setBounds(100, 100, 653, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNom = new JLabel("NOM");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(40, 73, 89, 14);
		contentPane.add(lblNom);
		
		lblApellidoPaterno = new JLabel("Prenom");
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoPaterno.setBounds(40, 98, 101, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblDateNaiss = new JLabel("Date de Naissance");
		lblDateNaiss.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateNaiss.setBounds(40, 158, 112, 14);
		contentPane.add(lblDateNaiss);
		
		lblSexe = new JLabel("Sexo");
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexe.setBounds(40, 193, 46, 14);
		contentPane.add(lblSexe);
		
		rdbtnHomme = new JRadioButton("Homme");
		rdbtnHomme.setBackground(new Color(238, 232, 170));
		rdbtnHomme.setBounds(151, 189, 109, 23);
		contentPane.add(rdbtnHomme);
		
		rdbtnFemme = new JRadioButton("Femme");
		rdbtnFemme.setSelected(true);
		rdbtnFemme.setBackground(new Color(238, 232, 170));
		rdbtnFemme.setBounds(300, 189, 109, 23);
		contentPane.add(rdbtnFemme);
		
		lblRue = new JLabel("Rue");
		lblRue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRue.setBounds(40, 222, 101, 14);
		contentPane.add(lblRue);
		
		lblTelf = new JLabel("Tel\u00E9fono");
		lblTelf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelf.setBounds(40, 320, 78, 14);
		contentPane.add(lblTelf);
		
		btnAddEmploi = new JButton("Ajouter Employe");
		btnAddEmploi.setBackground(new Color(255, 255, 0));
		btnAddEmploi.setBounds(139, 414, 151, 37);
		contentPane.add(btnAddEmploi);
		
		btnSortirAjoEmp = new JButton("Sortir");
		btnSortirAjoEmp.setBackground(new Color(255, 192, 203));
		btnSortirAjoEmp.setBounds(386, 414, 112, 37);
		contentPane.add(btnSortirAjoEmp);
		
		txtNom = new JTextField();
		txtNom.setBounds(151, 70, 284, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(151, 95, 284, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(151, 317, 284, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		txtRue = new JTextField();
		txtRue.setBounds(151, 219, 284, 20);
		contentPane.add(txtRue);
		txtRue.setColumns(10);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmero.setBounds(40, 246, 46, 14);
		contentPane.add(lblNmero);
		
		txtNum = new JTextField();
		txtNum.setBounds(150, 243, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVille.setBounds(40, 271, 46, 14);
		contentPane.add(lblVille);
		
		txtVille = new JTextField();
		txtVille.setBounds(150, 268, 284, 20);
		contentPane.add(txtVille);
		txtVille.setColumns(10);
		
		lblPays = new JLabel("Pays");
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPays.setBounds(40, 296, 78, 14);
		contentPane.add(lblPays);
		
		txtPay = new JTextField();
		txtPay.setBounds(151, 293, 284, 20);
		contentPane.add(txtPay);
		txtPay.setColumns(10);
		
		calendario=new JCalendarCombo();
		calendario.setBounds(151, 155, 284, 20);
		contentPane.add(calendario);
		
		lblEmploi = new JLabel("Puesto");
		lblEmploi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmploi.setBounds(40, 348, 65, 14);
		contentPane.add(lblEmploi);
		
		cmbEmploi = new JComboBox<String>();
		cmbEmploi.setModel(new DefaultComboBoxModel<String>(new String[] {"Emploi", "Caissier", "Cuisinier", "Serveur", "Manager"}));
		cmbEmploi.setBounds(151, 345, 139, 20);
		contentPane.add(cmbEmploi);
		
		lblStat = new JLabel("Estado");
		lblStat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStat.setBounds(500, 194, 89, 14);
		contentPane.add(lblStat);
		
		lblStatus = new JLabel("Registro en proceso");
		lblStatus.setForeground(new Color(128, 0, 128));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(466, 222, 148, 14);
		contentPane.add(lblStatus);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(AjoEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 462, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(AjoEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(312, 462, 315, 24);
		contentPane.add(lblBase2);
		
		lblBase3 = new JLabel("");
		lblBase3.setIcon(new ImageIcon(AjoEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase3.setBounds(607, 462, 30, 24);
		contentPane.add(lblBase3);
		
		lblAjouterEmp = new JLabel("AJOUTER EMPLOYE");
		lblAjouterEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterEmp.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblAjouterEmp.setBounds(175, 24, 337, 20);
		contentPane.add(lblAjouterEmp);
		
		lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(40, 377, 46, 14);
		contentPane.add(lblUser);
		
		txtUserS = new JTextField();
		txtUserS.setEnabled(false);
		txtUserS.setBounds(150, 374, 86, 20);
		contentPane.add(txtUserS);
		txtUserS.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(300, 377, 86, 14);
		contentPane.add(lblPassword);
		
		txtPassS = new JPasswordField();
		txtPassS.setEnabled(false);
		txtPassS.setBounds(412, 374, 86, 20);
		contentPane.add(txtPassS);
		txtPassS.setColumns(10);
		
		lblIDAjo = new JLabel("");
		lblIDAjo.setBounds(513, 73, 46, 14);
		contentPane.add(lblIDAjo);
	}
}
