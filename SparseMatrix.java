
public class SparseMatrix {

	public static void main(String[] args) throws Exception {
		System.out.println("Create a random matrix: ");
		matrix m = new matrix(5, 7, 10);
		m.display();
		System.out.println("");
		
		System.out.println("Compress it with Yale Algorithm: ");
		Yale y = m.toYale();
		y.display();
		System.out.println("");
		
		System.out.println("Change it back to a matrix form:");
		matrix m1 = y.toMatrix();
		m1.display();
	}

}
