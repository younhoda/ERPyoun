package erp;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BookOrder extends JFrame implements ActionListener {
	private JButton btnNewButton, btnNewButton_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;

	public BookOrder() {
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.CYAN);

		getContentPane().setLayout(null);

		btnNewButton = new JButton("등록");

		btnNewButton.setBounds(12, 227, 97, 34);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("발주수정");
		btnNewButton_1.setBounds(125, 227, 121, 34);
		getContentPane().add(btnNewButton_1);

		lblNewLabel = new JLabel("출판사");
		lblNewLabel.setBounds(12, 36, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(12, 107, 57, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("수량");
		lblNewLabel_2.setBounds(12, 154, 57, 15);
		getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(81, 29, 165, 29);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(81, 87, 165, 35);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(81, 143, 165, 39);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);

		setTitle("발주서등록");
		setSize(449, 458);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookOrder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OrderDAO in = new OrderDAO();
		if (e.getSource() == btnNewButton) {

//			String Quantity = textField_1.getText();
//			int QuantityInt = Integer.parseInt(Quantity);

			OrderDAO dao = new OrderDAO();
			OrderDTO dto = new OrderDTO(textField.getText());
			JOptionPane.showMessageDialog(null, "발주등록되었습니다.");

			dao.insert(dto);

		} else if (e.getSource() == btnNewButton_1) {
			
			
		}
	}
}