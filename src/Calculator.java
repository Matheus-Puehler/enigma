import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Calculator extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu file, help;
	private JMenuItem close;
	private JMenuItem about;
	
	private JTextField display;
	
	

	public static void main(String[] args) {
	
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			    JFrame.setDefaultLookAndFeelDecorated(true);
			} catch (Exception e) {
				System.out.println("Could not load system look");
			}
		new Calculator();

	}
	public Calculator() {
		super("ENIGMA MathPuehler");
		sendMenuBar();
		sendDisplay();
		sendUI(this);
	}
	private void sendDisplay() {
		Scanner s = new Scanner(System.in); 
       display =  new JTextField("Colocar resposta aqui");
       TextField textField = new TextField ();
       System.out.println(textField);
       display.setBounds(200, 100, 600, 35);
       display.setEditable(true);
       display.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
       add(display);
		
	}
	private void sendMenuBar() {
	  menuBar= new JMenuBar();
	  file= new JMenu("Opções");
	  help= new JMenu ("Ajuda");
	  close = new JMenuItem ("Fechar");
	  about= new JMenuItem ("Sobre");
		setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(help);
		
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Criado por Matheus Puehler: "
						+ "\n Whatsapp: +55 41 988251466 "
						+ "\n Twitter: @mathPGpuehler", "Sobre", JOptionPane.OK_CANCEL_OPTION);
				
			}
			
		});
		
		file.add(close);
		help.add(about);
		
		
	}
	private void sendUI(Calculator app) {
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(1000, 700);
		app.setResizable(false);
			app.setLayout(null);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
	}

}
