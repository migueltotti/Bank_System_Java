package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.BankSystem;

import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class BankManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textPassword;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblUsuarioNoCadastrado;
	private BankSystem bank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankManagement frame = new BankManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void SetBank(BankSystem bank) {
		
		this.bank = bank;
	}

	/**
	 * Create the frame.
	 */
	public BankManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		if(bank == null)
			bank = new BankSystem();
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFrame for BankManagement
				boolean result = bank.userExists(textEmail.getText());
				
				if(!result) {
					lblUsuarioNoCadastrado.setVisible(true);
				}
				else {
					UserPage userPage = new UserPage();
					userPage.setVisible(true);
					dispose();
				}
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setOpaque(true);
		btnLogin.setBackground(Color.GREEN);
		
		JButton btnCreateAccount = new JButton("Create");
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreateAccount.setBackground(new Color(0, 128, 255));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFrame for create new User
				CreateUserPage createUserPage = new CreateUserPage();
				createUserPage.setBank(bank);
				createUserPage.setVisible(true);
				dispose();
			}
		});
		btnCreateAccount.setContentAreaFilled(false);
		btnCreateAccount.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("Email");
		
		lblPassword = new JLabel("Password");
		
		lblNewLabel_1 = new JLabel("Login Page");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		lblUsuarioNoCadastrado = new JLabel("Usuario não cadastrado!");
		lblUsuarioNoCadastrado.setForeground(new Color(255, 0, 0));
		lblUsuarioNoCadastrado.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
									.addComponent(textEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnCreateAccount, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblUsuarioNoCadastrado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(lblNewLabel_1)))
					.addGap(124))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsuarioNoCadastrado)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnCreateAccount))
					.addGap(77))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
