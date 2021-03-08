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
import java.util.ArrayList;
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
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JTextField magnitude;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField maiorRisco;
	private JTextField menorRisco;
	private TextArea painelResultados;
	
	private int contadorDeAcoes = 0;
	
	ArrayList<acoes> listaA = new ArrayList<acoes>(); //Lista com as se��es de a��o
	acoes novaAcao = null;
	
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
		setBounds(250, 20, 800, 750);
		contentPane = new panelComponent(); //Componente onde est� a imagem de background da calduladora
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
		
		JLabel lblNewLabel = new JLabel("Tipo de a��o:\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 120, 100, 25);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabe2 = new JLabel("Categoria da a��o:\n");
		lblNewLabe2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabe2.setBounds(295, 120, 110, 25);
		lblNewLabe2.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabe2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabe2);
		
		JLabel lblNewLabe3 = new JLabel("Magnitude:\n");
		lblNewLabe3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabe3.setBounds(450, 120, 100, 25);
		lblNewLabe3.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabe3.setForeground(Color.WHITE);
		contentPane.add(lblNewLabe3);		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(150, 150, 100, 25);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Momento");
		comboBox.addItem("Normal");
		comboBox.addItem("Cortante");

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(300, 150, 100, 25);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Peso Pr�prio");
		comboBox_1.addItem("Retra��o");
		comboBox_1.addItem("Sobrecarga");
		comboBox_1.addItem("Temperatura");
		comboBox_1.addItem("Vento");
		
		magnitude = new JTextField();
		magnitude.setBackground(SystemColor.control);
		magnitude.setBounds(450, 150, 100, 25);
		contentPane.add(magnitude);
		magnitude.setColumns(10);
		
		JButton btnNewButton = new JButton("+\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				contadorDeAcoes = contadorDeAcoes + 1;// Add a��o
				//Prepara��o dos dados para impress�o no painel
				String tipoAcao = (String) comboBox.getSelectedItem(); 
				String categAcao = (String) comboBox_1.getSelectedItem();
				double mgntd = Double.parseDouble(magnitude.getText());
				
				String texto = "---------------------------------------------- \n A��o: " + contadorDeAcoes + "\n\n" 
						+ " - Tipo de a��o: " + tipoAcao + "\n\n" 
						+ " - Categoria da a��o: " + categAcao + "\n\n"
						+ " - Grandeza: " + mgntd + "\n\n";
				
				//Adicionando ao ArrayList listaA o obj com os dados
				int mnvA = comboBox.getSelectedIndex();
				int nomeA = comboBox_1.getSelectedIndex();
				double valorA = Double.parseDouble(magnitude.getText());
				novaAcao = new acoes(mnvA, nomeA, valorA);
				novaAcao.preencher();
				listaA.add(novaAcao);
				System.out.println("nova acao: " + novaAcao.getMnv() + "\n " + novaAcao.getNome() + "\n" + novaAcao.getValor());
				
				//Recupera oq ja estava escrito antes e adiciona as informa��es ao painel
				painelResultados.setText(painelResultados.getText() + "\n" + texto); 
				//Limpeza dos inputs
				magnitude.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);

				} catch(Exception erro){
					contadorDeAcoes = contadorDeAcoes - 1;
					JOptionPane.showMessageDialog(null, "erro de calculo");
				}
			}
		});
		btnNewButton.setBounds(600, 150, 45, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					combinacoes comb = new combinacoes(listaA);
					painelResultados.setText(painelResultados.getText() + "\n" + comb.getRelatorio()); //"Salva/reimprime" oq ja estava escrito antes
				
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
		painelResultados.setBounds(10, 301, 764, 400);
		contentPane.add(painelResultados);
	}
}