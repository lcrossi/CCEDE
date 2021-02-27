import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Canvas;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.TextArea;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JPanel whiteBkgdPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField magnitude;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField maiorRisco;
	private JTextField menorRisco;
	private TextArea painelResultados;

	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() {
		setTitle("CCEDE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new panelComponent(); //Componente onde está a imagem de background da calduladora
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setForeground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel lblCCEDE = new JLabel("CCEDE");
		lblCCEDE.setFont(new Font("hooge 05_54", Font.BOLD, 22));
		lblCCEDE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCCEDE.setBounds(6, 10, 100, 25);
		lblCCEDE.setForeground(Color.WHITE);
		contentPane.add(lblCCEDE);
		
		JLabel lblCalculadoraDe = new JLabel("Calculadora de a\u00E7\u00F5es estruturais");
		lblCalculadoraDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculadoraDe.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblCalculadoraDe.setBounds(574, 11, 200, 25);
		lblCalculadoraDe.setForeground(Color.WHITE);
		contentPane.add(lblCalculadoraDe);
		
		JLabel lblNewLabel = new JLabel("Select 1\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 120, 100, 25);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabe2 = new JLabel("Select 2\n");
		lblNewLabe2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabe2.setBounds(300, 120, 100, 25);
		lblNewLabe2.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabe2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabe2);
		
		JLabel lblNewLabe3 = new JLabel("Magnitude:\n");
		lblNewLabe3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabe3.setBounds(450, 120, 100, 25);
		lblNewLabe3.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabe3.setForeground(Color.WHITE);
		contentPane.add(lblNewLabe3);		
		
		comboBox = new JComboBox();
		comboBox.setBounds(150, 150, 100, 25);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(300, 150, 100, 25);
		contentPane.add(comboBox_1);
		
		magnitude = new JTextField();
		magnitude.setBackground(SystemColor.control);
		magnitude.setBounds(450, 150, 100, 25);
		contentPane.add(magnitude);
		magnitude.setColumns(10);
		
		JButton btnNewButton = new JButton("+\r\n");
		btnNewButton.setBounds(600, 150, 45, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Aqui fica um componente com os códigos do Barbie e Isa
					//Teste feito a seguir usando valor no campo magnitude:
				double mgntd = Double.parseDouble(magnitude.getText());
				double valor = 5*(mgntd)/3;
				painelResultados.setText(painelResultados.getText() + "\n" + valor); //"Salva/reimprime" oq ja estava escrito antes
				magnitude.setText("");//Limpa o input
				System.out.println("valor: " + valor);
				} catch(Exception erro){
					JOptionPane.showMessageDialog(null, "erro de calculo");
				}
			}
		});
		btnCalcular.setBounds(350, 200, 100, 30);
		btnCalcular.setFont(new Font("Roboto", Font.BOLD, 14));
		btnCalcular.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnCalcular);
		
		JLabel lblCenrioDeMaior = new JLabel("Cen\u00E1rio de maior risco");
		lblCenrioDeMaior.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenrioDeMaior.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblCenrioDeMaior.setBounds(10, 264, 150, 25);
		lblCenrioDeMaior.setForeground(Color.WHITE);
		contentPane.add(lblCenrioDeMaior);
		
		maiorRisco = new JTextField();
		maiorRisco.setBackground(SystemColor.control);
		maiorRisco.setBounds(171, 264, 80, 25);
		contentPane.add(maiorRisco);
		maiorRisco.setColumns(10);
		
		JLabel lblCenrioDeMenor = new JLabel("Cen\u00E1rio de menor risco");
		lblCenrioDeMenor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenrioDeMenor.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblCenrioDeMenor.setBounds(446, 264, 150, 25);
		lblCenrioDeMenor.setForeground(Color.WHITE);
		contentPane.add(lblCenrioDeMenor);
		
		menorRisco = new JTextField();
		menorRisco.setColumns(10);
		menorRisco.setBackground(SystemColor.menu);
		menorRisco.setBounds(607, 264, 80, 25);
		contentPane.add(menorRisco);
		
		painelResultados = new TextArea();
		painelResultados.setFont(new Font("Roboto", Font.PLAIN, 12));
		painelResultados.setForeground(Color.BLACK);
		painelResultados.setBounds(10, 301, 764, 100);
		contentPane.add(painelResultados);
	}
}