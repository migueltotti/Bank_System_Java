package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.BankAccount;
import entity.BankSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BankAccount account;
	private BankSystem bank;
	JLabel lblUsuarioId;
	JLabel lblNomeUsuario;
	JLabel lblSaldoUsuario;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setAccount(BankAccount account) {
		this.account = account;
		
		if(account != null) {
			lblUsuarioId.setText(String.valueOf(account.getHolder().getId()));
			lblNomeUsuario.setText(account.getHolder().getName());
			lblSaldoUsuario.setText(String.valueOf(account.getAmount()));
		}
	}
	
	public void setBank(BankSystem bank) {
		this.bank = bank;
	}

	/**
	 * Create the frame.
	 */
	public UserPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pagina do Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 193, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 68, 45, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 97, 59, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Saldo:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 126, 59, 19);
		contentPane.add(lblNewLabel_1_2);
		
		lblUsuarioId = new JLabel("New label");
		lblUsuarioId.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblUsuarioId.setBounds(42, 71, 162, 13);
		contentPane.add(lblUsuarioId);
		
		lblNomeUsuario = new JLabel("New label");
		lblNomeUsuario.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNomeUsuario.setBounds(66, 102, 316, 13);
		contentPane.add(lblNomeUsuario);
		
		lblSaldoUsuario = new JLabel("New label");
		lblSaldoUsuario.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSaldoUsuario.setBounds(66, 129, 162, 13);
		contentPane.add(lblSaldoUsuario);
		
		// User Info
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.setContentAreaFilled(false);
		btnSaque.setOpaque(true);
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaquePage saque = new SaquePage();
				saque.setAccount(account);
				saque.setVisible(true);
			}
		});
		btnSaque.setBackground(new Color(255, 128, 64));
		btnSaque.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaque.setBounds(20, 206, 109, 39);
		contentPane.add(btnSaque);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositoPage deposito = new DepositoPage();
				deposito.setAccount(account);
				deposito.setVisible(true);
			}
		});
		btnDeposito.setBackground(new Color(0, 255, 0));
		btnDeposito.setContentAreaFilled(false);
		btnDeposito.setOpaque(true);
		btnDeposito.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeposito.setBounds(139, 206, 109, 39);
		contentPane.add(btnDeposito);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferirPage trasferir = new TransferirPage();
				trasferir.setAccount(account);
				trasferir.setBank(bank);
				trasferir.setVisible(true);
			}
		});
		btnTransferir.setBackground(new Color(128, 128, 255));
		btnTransferir.setContentAreaFilled(false);
		btnTransferir.setOpaque(true);
		btnTransferir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTransferir.setBounds(258, 206, 109, 39);
		contentPane.add(btnTransferir);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(account != null) {
					lblUsuarioId.setText(String.valueOf(account.getHolder().getId()));
					lblNomeUsuario.setText(account.getHolder().getName());
					lblSaldoUsuario.setText(String.valueOf(account.getAmount()));
				}
			}
		});
		btnNewButton.setBounds(10, 156, 75, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<= Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankManagement bankManagement = new BankManagement();
				bankManagement.SetBank(bank);
				bankManagement.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(287, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
