class WaterBottleTest {
	public static void main(String[] args) {
		WaterBottle a = new WaterBottle();
		WaterBottle b = new WaterBottle();
		
		a.fillWaterBottle(10);
		b.fillWaterBottle(10);
		
		System.out.println(a.equals(b));
	}
}