import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Calculator extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu file, help;
	private JMenuItem close;
	private JMenuItem about;
	private JButton btnNovaPergunta;
	private JLabel lblPergunta;
	
	
	private JTextField display;
	
//	DADOS
	
	private MapManager manager = new MapManager();
	private JButton btnNovoJogo;
	
	

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
       display =  new JTextField("Colocar resposta aqui");
       display.setBounds(200, 100, 600, 35);
       display.setEditable(true);
       display.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
       
       DocumentListener docListener = new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			textChanged(e);
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			textChanged(e);			
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			textChanged(e);			
		}
		
		public void textChanged(DocumentEvent e) {
			if(manager.jogoAcabado()) return;
			String text = display.getText();
			
			if(manager.tentativa(text)) {
				lblPergunta.setText("Acerto mizeravi, faz outra pergunta.");
				btnNovaPergunta.setEnabled(true);
			}
				
			
			
		}
	};
       
       display.getDocument().addDocumentListener(docListener);
       
       getContentPane().add(display);
		
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
			app.getContentPane().setLayout(null);
			
			lblPergunta = new JLabel("");
			lblPergunta.setBounds(235, 171, 482, 224);
			getContentPane().add(lblPergunta);
			
			btnNovaPergunta = new JButton("Nova Pergunta");
			btnNovaPergunta.setBounds(43, 100, 145, 25);
			btnNovaPergunta.setEnabled(false);
			getContentPane().add(btnNovaPergunta);
			
			btnNovoJogo = new JButton("Novo Jogo");
			btnNovoJogo.setBounds(43, 137, 145, 25);
			getContentPane().add(btnNovoJogo);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		
		clickListeners();
	}
	
	private void clickListeners() {
		btnNovaPergunta.addActionListener(action -> {
			lblPergunta.setText(manager.nova_pergunta());
			btnNovaPergunta.setEnabled(false);
		});
		btnNovoJogo.addActionListener(action -> {
			btnNovaPergunta.setEnabled(false);
			manager.novoJogo();
			lblPergunta.setText(manager.getPerguntaAtual());
		});
	}
}
