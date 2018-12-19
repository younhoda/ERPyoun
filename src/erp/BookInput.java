package erp;

import java.awt.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookInput {

	String sPW = " ";
	String sPW2 = " ";

	// 회원정보 등록
	public void input(String id, MemberDTO library) {

		File file = new File("Book\\" + library.getId() + ".txt");

		if (file.exists()) {
		} else if (id.equals(id) && file.equals(id)) {
			JOptionPane.showMessageDialog(null, "아이디가 같습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다. 다시 입력바랍니다.");
		}

		try {
			FileWriter writer = new FileWriter(file);
			writer.write(library.getId() + "\r\n");
			writer.write(library.getPw() + "\r\n");
			writer.write(library.getName() + "\r\n");
			writer.write(library.getTel() + "\r\n");
			writer.write(library.getAddr() + "\r\n");

			writer.flush();
			writer.close();

			JOptionPane.showMessageDialog(null, "파일이 정상적으로 등록되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 비밀번호 재확인
	public void passwordCheck() {
		if (sPW.equals(sPW) && sPW2.equals(sPW2)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 같습니다.");

		}

	}
}