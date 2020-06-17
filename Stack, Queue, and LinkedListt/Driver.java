class Driver {
	public static void main(String[] args) {
		System.out.println("===Testing Queue===");
		Queue q = new Queue();
		System.out.println("Pushing...");
		q.push(10);
		System.out.println(q.toString());
		q.push(20);
		System.out.println(q.toString());
		q.push(30);
		System.out.println(q.toString());
		q.push(40);
		System.out.println(q.toString());
		q.push(50);
		System.out.println(q.toString());
		System.out.println("Poping...");
		q.pop();
		System.out.println(q.toString());
		q.pop();
		System.out.println(q.toString());
		q.pop();
		System.out.println(q.toString());
		q.pop();
		System.out.println(q.toString());
		q.pop();
		System.out.println(q.toString());
	}
}