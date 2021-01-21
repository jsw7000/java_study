
public class TV {
	int num;		//제품 번호
	String name;	//제품 이름
	int price;		//가격
	int quantity;	//수량
	int inch;		//인치
	String display_type;	//디스플레이 타입
	
	
	TV (int num, String name, int price, int quantity, int inch, String display_type) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.inch = inch;
		this.display_type = display_type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplay_type() {
		return display_type;
	}
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}
	
	
	public String toString() {
		return "TV [제품 번호 : " + this.num + ", 제품 이름 : " + this.name + ", 가격 : " + this.price + ", 수량 : " + this.quantity + ", 인치 : " + this.inch
				+ ", 디스플레이 타입" + this.display_type + "]";
	}


}
