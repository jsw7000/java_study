
public class ProductTest {

	public static void main(String[] args) {
		TV s_tv = new TV(12345,"S_TV",15000,3,40,"uhd");
		Refrigerator s_refrigerator = new Refrigerator(23232, "S_Refrigerator", 30000, 2, 500);
			
		System.out.println(s_tv.toString());
		System.out.println(s_refrigerator.toString());
	}

}
