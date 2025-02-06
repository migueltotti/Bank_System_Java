package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.BankAccount;
import entity.BankSystem;
import entity.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class CreateUserPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JLabel lblNewLabel_2;
	private JTextField emailField;
	private JTextField passwordField;
	private JLabel lblNewLabel_3;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private BankSystem bank;
	private JLabel usuarioJaCadastrado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUserPage frame = new CreateUserPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setBank(BankSystem bank) {
		this.bank = bank;
	}

	/**
	 * Create the frame.
	 */
	public CreateUserPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Criar Usuario");
		lblNewLabel.setBounds(119, 11, 160, 30);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		JLabel lblNewLabel_1 = new JLabel("-> Nome de Usuario");
		lblNewLabel_1.setBounds(119, 75, 146, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		nameField = new JTextField();
		nameField.setBounds(119, 99, 226, 20);
		nameField.setColumns(10);
		nameField.setFocusable(true);
		
		lblNewLabel_2 = new JLabel("-> Email");
		lblNewLabel_2.setBounds(119, 123, 146, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		emailField = new JTextField();
		emailField.setBounds(119, 142, 226, 20);
		emailField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(119, 194, 226, 20);
		passwordField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("-> Senha");
		lblNewLabel_3.setBounds(119, 173, 146, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nameField.getText();
				String email = emailField.getText();
				String senha = passwordField.getText();
				
				User newUser = new User(nome, email, senha);
				BankAccount newBankAccount = new BankAccount(newUser, 100.00);
				
				boolean addResult = bank.addAccount(newBankAccount);
				
				if(!addResult) {
					usuarioJaCadastrado.setVisible(true);
					nameField.setText("");
					emailField.setText("");
					passwordField.setText("");
					nameField.setFocusable(true);
				}
				else {
					UserSuccessCard successCard = new UserSuccessCard();
					successCard.SetBank(bank);
					successCard.setVisible(true);
					dispose();
				}
			}
		});
		btnConfirmar.setBounds(119, 243, 226, 23);
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBackground(Color.GREEN);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(119, 277, 226, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get back to LoginPage
				BankManagement bankManagement = new BankManagement();
				bankManagement.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBackground(Color.RED);
		contentPane.add(btnCancelar);
		contentPane.add(nameField);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(emailField);
		contentPane.add(lblNewLabel_3);
		contentPane.add(passwordField);
		contentPane.add(btnConfirmar);
		
		usuarioJaCadastrado = new JLabel("Usuario com esse email já cadastrado!");
		usuarioJaCadastrado.setForeground(new Color(255, 0, 0));
		usuarioJaCadastrado.setBackground(new Color(255, 0, 0));
		usuarioJaCadastrado.setBounds(119, 218, 226, 14);
		usuarioJaCadastrado.setVisible(false);
		contentPane.add(usuarioJaCadastrado);
	}
}
