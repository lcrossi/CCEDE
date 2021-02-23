package Interface_Gráfica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.TextArea;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 150, 90, 25);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("+\r\n");
		btnNewButton.setBounds(293, 111, 45, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ok\r\n");
		btnNewButton_1.setBounds(292, 151, 45, 25);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("+\r\n");
		button.setBounds(729, 111, 45, 25);
		contentPane.add(button);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(446, 152, 90, 25);
		contentPane.add(comboBox_1);
		
		JButton button_1 = new JButton("Ok\r\n");
		button_1.setBounds(729, 151, 45, 25);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("A\u00E7\u00F5es Permanentes\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 110, 273, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Nd");
		lblNewLabel_1.setBounds(110, 150, 25, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.control);
		textField.setBounds(136, 150, 25, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel(" Nd");
		label.setBounds(171, 150, 25, 25);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(197, 150, 25, 25);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel(" Nd");
		label_1.setBounds(232, 150, 25, 25);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.menu);
		textField_2.setBounds(258, 150, 25, 25);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel(" Nd");
		label_2.setBounds(546, 150, 25, 25);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.menu);
		textField_3.setBounds(572, 150, 25, 25);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel(" Nd");
		label_3.setBounds(607, 150, 25, 25);
		contentPane.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.menu);
		textField_4.setBounds(633, 150, 25, 25);
		contentPane.add(textField_4);
		
		JLabel label_4 = new JLabel(" Nd");
		label_4.setBounds(668, 150, 25, 25);
		contentPane.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.menu);
		textField_5.setBounds(694, 150, 25, 25);
		contentPane.add(textField_5);
		
		JLabel lblAesVariveis = new JLabel("A\u00E7\u00F5es Vari\u00E1veis");
		lblAesVariveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblAesVariveis.setBounds(446, 116, 273, 25);
		contentPane.add(lblAesVariveis);
		
		JLabel lblCalculadoraDe = new JLabel("Calculadora de a\u00E7\u00F5es estruturais");
		lblCalculadoraDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculadoraDe.setBounds(574, 11, 200, 25);
		contentPane.add(lblCalculadoraDe);
		
		JLabel lblCenrioDeMaior = new JLabel("Cen\u00E1rio de maior risco");
		lblCenrioDeMaior.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenrioDeMaior.setBounds(10, 264, 150, 25);
		contentPane.add(lblCenrioDeMaior);
		
		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.control);
		textField_6.setBounds(171, 264, 80, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 301, 764, 100);
		contentPane.add(textArea);
		
		JLabel lblCenrioDeMenor = new JLabel("Cen\u00E1rio de menor risco");
		lblCenrioDeMenor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenrioDeMenor.setBounds(446, 264, 150, 25);
		contentPane.add(lblCenrioDeMenor);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBackground(SystemColor.menu);
		textField_7.setBounds(607, 264, 80, 25);
		contentPane.add(textField_7);
	}
}
