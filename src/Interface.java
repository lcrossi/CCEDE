import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

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
	
	ArrayList<acoes> listaA = new ArrayList<acoes>(); //Lista com as seções de ação
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
		
		JLabel lblNewLabel = new JLabel("Tipo de ação:\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 120, 100, 25);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabe2 = new JLabel("Categoria da ação:\n");
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
		comboBox_1.addItem("Peso Próprio");
		comboBox_1.addItem("Retração");
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
				contadorDeAcoes = contadorDeAcoes + 1;// Add ação
				//Preparação dos dados para impressão no painel
				String tipoAcao = (String) comboBox.getSelectedItem(); 
				String categAcao = (String) comboBox_1.getSelectedItem();
				double mgntd = Double.parseDouble(magnitude.getText());
				
				String texto = "---------------------------------------------- \n Ação: " + contadorDeAcoes + "\n\n" 
						+ " - Tipo de ação: " + tipoAcao + "\n\n" 
						+ " - Categoria da ação: " + categAcao + "\n\n"
						+ " - Grandeza: " + mgntd + "\n\n";
				
				//Adicionando ao ArrayList listaA o obj com os dados
				int mnvA = comboBox.getSelectedIndex();
				int nomeA = comboBox_1.getSelectedIndex();
				double valorA = Double.parseDouble(magnitude.getText());
				novaAcao = new acoes(mnvA, nomeA, valorA);
				novaAcao.preencher();
				listaA.add(novaAcao);
				System.out.println("nova acao: " + novaAcao.getMnv() + "\n " + novaAcao.getNome() + "\n" + novaAcao.getValor());
				
				//Recupera oq ja estava escrito antes e adiciona as informações ao painel
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
		
		painelResultados = new TextArea();
		painelResultados.setFont(new Font("Roboto", Font.PLAIN, 12));
		painelResultados.setForeground(Color.BLACK);
		painelResultados.setBounds(10, 301, 764, 400);
		contentPane.add(painelResultados);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(600, 250, 55, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("Salvar");
		menuBar.add(mnFile);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser abrir = new JFileChooser();
				abrir.setDialogTitle("Abrir arquivo");
				abrir.setCurrentDirectory(new File("."));
				int result = abrir.showOpenDialog(null);
				
				File file = null;
				if(result == JFileChooser.APPROVE_OPTION){
					
				file = abrir.getSelectedFile();
				try{
					Path path = Paths.get(file.getAbsolutePath());
					String retorno = new String(Files.readAllBytes(path));
					painelResultados.setText(retorno);
				}catch(Exception erro){
					JOptionPane.showInputDialog(this, "arquivo não carregado");
				}
				}
			}
		});
		mnFile.add(mntmAbrir);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String texto = painelResultados.getText();
										
				JFileChooser salvar= new JFileChooser();
					salvar.setDialogTitle("Salvar Arquivo");
					salvar.setCurrentDirectory(new File ("."));
					int select = salvar.showSaveDialog(null);
					if(select == JFileChooser.APPROVE_OPTION){
						File arquivo = salvar.getSelectedFile();
						try {
							PrintWriter pw = new PrintWriter(arquivo);
							pw.write(texto);
							pw.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						
					}
				
				}
		});
		mnFile.add(mntmSalvar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmSair);
		
		
	}
}