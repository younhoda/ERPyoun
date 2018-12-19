package erp;

import javax.swing.JFrame;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class BookMain extends JFrame {
	private JButton btnNewButton_2, btnNewButton;

	public BookMain() {
		getContentPane().setLayout(null);

		btnNewButton = new JButton("발주등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookOrder order = new BookOrder();
			}
		});

		btnNewButton.setBounds(40, 42, 116, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_4 = new JButton("로그아웃");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogin name = new BookLogin();
				JOptionPane.showMessageDialog(null, "로그아웃 하셨습니다.");
			}
		});
		btnNewButton_4.setBounds(272, 42, 97, 23);
		getContentPane().add(btnNewButton_4);

		setSize(713, 601);
		setTitle("ERP 메인화면입니다.");
		setVisible(true);

	}

	public static void main(String[] args) {

		new BookMain();
	}
}
