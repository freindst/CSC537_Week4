
public class Yale {
	private int[] A;
	private int[] IA;
	private int[] JA;
	
	public Yale()
	{
		this.A = null;
		this.IA = null;
		this.JA = null;
	}
	
	public Yale(int[] A, int[] IA, int[] JA)
	{
		this.A = A;
		this.IA = IA;
		this.JA = JA;
	}
	
	//Convert Yale algorithm format to matrix class
	public matrix toMatrix()
	{
		int row = max(this.JA) + 1;
		int column = this.IA.length - 1;
		int number = this.A.length;
		
		int[][] m = new int[row][column];
		for (int j = 0; j < column; j++)
		{
			for (int i = 0; i < row; i++)
			{
				m[i][j] = 0;
			}
		}
		
		int indexOfA = 0;
		int indexOfIA = 0;		
		for (indexOfIA = 0; indexOfIA < this.IA.length - 1; indexOfIA++)
		{
			int curr = this.IA[indexOfIA];
			int next = this.IA[indexOfIA + 1];
			while(next > curr)
			{
				m[this.JA[indexOfA]][indexOfIA] = this.A[indexOfA];
				indexOfA++;
				next--;
			}
		}
		matrix ma = new matrix(m, row, column, number);
		return ma;
	}
	
	public void display()
	{
		System.out.print("A = [ ");
		for (int i = 0; i < this.A.length; i++)
		{
			System.out.print(this.A[i] + " ");
		}
		System.out.println("]");
		
		System.out.print("IA = [ ");
		for (int i = 0; i < this.IA.length; i++)
		{
			System.out.print(this.IA[i] + " ");
		}
		System.out.println("]");
		
		System.out.print("JA = [ ");
		for (int i = 0; i < this.JA.length; i++)
		{
			System.out.print(this.JA[i] + " ");
		}
		System.out.println("]");
	}
	
	//get the maximum integer in a array
	private int max(int[] array)
	{
		int result = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (result < array[i])
			{
				result = array[i];
			}
		}
		return result;
	}

}
