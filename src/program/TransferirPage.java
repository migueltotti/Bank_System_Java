package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.BankAccount;
import entity.BankSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferirPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textThirdPartyAccountId;
	private JTextField textTransferAmount;
	private BankAccount account;
	private BankSystem bank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferirPage frame = new TransferirPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public void setBank(BankSystem bank) {
		this.bank = bank;
	}


	/**
	 * Create the frame.
	 */
	public TransferirPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 282, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transferir:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 163, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Conta destino:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 42, 146, 13);
		contentPane.add(lblNewLabel_1);
		
		textThirdPartyAccountId = new JTextField();
		textThirdPartyAccountId.setBounds(10, 59, 242, 19);
		contentPane.add(textThirdPartyAccountId);
		textThirdPartyAccountId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor a ser transferido em reais (R$):");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(10, 97, 208, 13);
		contentPane.add(lblNewLabel_1_1);
		
		textTransferAmount = new JTextField();
		textTransferAmount.setColumns(10);
		textTransferAmount.setBounds(10, 114, 242, 19);
		contentPane.add(textTransferAmount);
		
		JLabel lblTransferUserNotFound = new JLabel("Usuario para transferencia inexistente");
		lblTransferUserNotFound.setForeground(new Color(255, 0, 0));
		lblTransferUserNotFound.setBackground(new Color(255, 0, 0));
		lblTransferUserNotFound.setBounds(10, 142, 242, 13);
		lblTransferUserNotFound.setVisible(false);
		contentPane.add(lblTransferUserNotFound);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean transferAccountExists = bank.userExists(Integer.valueOf(textThirdPartyAccountId.getText()));
				
				if(transferAccountExists) {
					lblTransferUserNotFound.setVisible(false);
					BankAccount transferAccount = bank.getAccount(Integer.valueOf(textThirdPartyAccountId.getText()));
					account.withdraw(Double.valueOf(textTransferAmount.getText()));
					transferAccount.deposit(Double.valueOf(textTransferAmount.getText()));
					
					TransactionSuccess successPage = new TransactionSuccess();
					successPage.setVisible(true);
					
					dispose();
				}
				else {
					textTransferAmount.setText("");
					textThirdPartyAccountId.setText("");
					lblTransferUserNotFound.setVisible(true);
				}
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfirmar.setBackground(new Color(0, 255, 0));
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBounds(10, 154, 116, 30);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBounds(136, 154, 116, 30);
		contentPane.add(btnCancelar);
		
		
	}

}
