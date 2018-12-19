package erp;

public class MemberDTO {

	private String id; //아이디
	private String pw; //패스워드
	private String name;	//이름
	private String tel;	//전화번호	
	private String Addr;	//주소
	
	public MemberDTO(String id, String pw, String name, String tel, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		Addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", Addr=" + Addr + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
