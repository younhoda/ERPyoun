package erp;

public class BookselectDTO {
	
	private String ISBN;
	private String classification;
	private String title;
	private String publisher;
	private String writer;
	private int price;
	private int quantity;
	private int TS;
	
	public BookselectDTO(String iSBN, String classification, String title, String publisher, String writer, int price,
			int quantity, int tS) {
		super();
		ISBN = iSBN;
		this.classification = classification;
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
		this.quantity = quantity;
		TS = tS;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTS() {
		return TS;
	}

	public void setTS(int tS) {
		TS = tS;
	}

	@Override
	public String toString() {
		return "BookselectDTO [ISBN=" + ISBN + ", classification=" + classification + ", title=" + title
				+ ", publisher=" + publisher + ", writer=" + writer + ", price=" + price + ", quantity=" + quantity
				+ ", TS=" + TS + "]";
	}
	
	
	
	
	
}
