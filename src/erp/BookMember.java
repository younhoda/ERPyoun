package erp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import java.awt.Color;

public class BookMember extends JFrame implements ActionListener {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JPasswordField passwordField_1;

	public BookMember() {
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setLayout(null);

		btnNewButton = new JButton("등록");
		btnNewButton.setBounds(100, 345, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC544\uC774\uB514 \uC911\uBCF5\uD655\uC778");
		btnNewButton_1.setBounds(339, 78, 155, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(");
		btnNewButton_2.setBounds(352, 178, 136, 23);
		getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setBounds(136, 29, 230, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setBounds(12, 76, 74, 26);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("패스워드");
		lblNewLabel_2.setBounds(12, 128, 85, 26);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("패스워드재확인");
		lblNewLabel_3.setBounds(12, 176, 85, 26);
		getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setBounds(22, 212, 57, 30);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("전화번호");
		lblNewLabel_5.setBounds(22, 261, 57, 15);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("주소");
		lblNewLabel_6.setBounds(22, 301, 57, 15);
		getContentPane().add(lblNewLabel_6);

		textField = new JTextField();
		textField.setBounds(97, 73, 230, 34);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(100, 125, 230, 34);
		getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(110, 173, 233, 34);
		getContentPane().add(passwordField_1);

		textField_1 = new JTextField();
		textField_1.setBounds(103, 211, 230, 34);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(103, 252, 230, 34);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(100, 292, 230, 34);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);

		setTitle("회원가입");
		setSize(516, 443);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BookInput in = new BookInput();
		if (e.getSource() == btnNewButton) {
			MemberDTO library = new MemberDTO(textField.getText(), passwordField.getText(), textField_1.getText(),
					textField_3.getText(), textField_4.getText());
			in.input(textField.getText(), library);

		} 
	}
	public static void main(String[] args) {
		new BookMember();
	}
}
