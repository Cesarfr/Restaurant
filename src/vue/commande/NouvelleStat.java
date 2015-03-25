package vue.commande;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue nouvellestatus
 */
public class NouvelleStat extends JFrame {

	private JPanel contentPane;
	private JLabel lbletat;
	public JLabel lblEtatAct;
	public JButton btnChEst;
	public JButton btnAnnuler;
	private JLabel lblBase1;
	private JLabel lblBase2;

	/**
	 * Create the frame.
	 */
	public NouvelleStat() {
		setResizable(false);
		setTitle("Changer l'\u00E9tat du commande");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListAssiettesCommandes.class.getResource("../../images/steak-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbletat = new JLabel("\u00C9tat actuel");
		lbletat.setFont(new Font("Rockwell", Font.BOLD, 16));
		lbletat.setHorizontalAlignment(SwingConstants.CENTER);
		lbletat.setBounds(10, 11, 424, 25);
		contentPane.add(lbletat);
		
		lblEtatAct = new JLabel("");
		lblEtatAct.setForeground(Color.RED);
		lblEtatAct.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtatAct.setFont(new Font("Cooper Black", Font.PLAIN, 40));
		lblEtatAct.setBounds(42, 36, 347, 86);
		contentPane.add(lblEtatAct);
		
		btnChEst = new JButton("Change");
		btnChEst.setBackground(new Color(152, 251, 152));
		btnChEst.setBounds(69, 133, 134, 35);
		contentPane.add(btnChEst);
		
		btnAnnuler = new JButton("Sortir");
		btnAnnuler.setBackground(new Color(255, 192, 203));
		btnAnnuler.setBounds(257, 133, 89, 35);
		contentPane.add(btnAnnuler);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(NouvelleStat.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 189, 315, 45);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(NouvelleStat.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(219, 189, 225, 45);
		contentPane.add(lblBase2);
	}

}
