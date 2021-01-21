
public class Refrigerator {
	int num;		//제품 번호
	String name;	//제품 이름
	int price;		//가격
	int quantity;	//수량
	int capacity;	//용량
	Refrigerator(int num, String name, int price, int quantity, int capacity) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.capacity = capacity;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		return "Refrigerator [제품 번호 : " + this.num + ", 제품 이름 : " + this.name + ", 가격 : " + this.price + ", 수량 : " + this.quantity
				+ ", 용량 : " + this.capacity + "]";
	}
	
}
