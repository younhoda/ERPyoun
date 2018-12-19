package erp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;

public class BookLogin extends JFrame implements ActionListener {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton_1, btnNewButton;
	private JTextField txtId;
	private JPasswordField txtPw;
	String sID = " ";
	String sPW = " ";

	public BookLogin() {

		getContentPane().setLayout(null);

		btnNewButton = new JButton("로그인");

		btnNewButton.setBounds(57, 525, 97, 23);
		getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(this);

		JButton btnNewButton_2 = new JButton("회원가입");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookMember member = new BookMember();
			}
		});

		btnNewButton_2.setBounds(206, 525, 124, 23);
		getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(57, 404, 81, 25);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("패스워드");
		lblNewLabel_1.setBounds(57, 456, 81, 31);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(150, 395, 184, 34);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 461, 184, 26);
		getContentPane().add(passwordField);

		setTitle("도서 erp 입니다.");
		setSize(704, 650);
		setVisible(true);

	}

	public static void main(String[] args) {
		BookLogin login = new BookLogin();
	}

	@Override

	public void actionPerformed(ActionEvent e) {

		BookMain main = new BookMain();
		BookLogin login = new BookLogin();

		try {
			Scanner sc = new Scanner(new File(textField.getText() + ".txt"));
			sID = sc.nextLine();
			sPW = sc.nextLine();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		if (e.getSource() == btnNewButton) {
			if (!textField.getText().equals(sID) && passwordField.getText().equals(sPW)) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 틀렸습니다.");				
			}else {
			JOptionPane.showMessageDialog(null, "로그인되었습니다.");
			}
			return;
		} else if (e.getSource() == btnNewButton) {

		}

	}

}
