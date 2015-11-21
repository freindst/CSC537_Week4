import java.util.Random;

public class matrix {
	private int[][] m;
	private int row;
	private int column;
	private int number;
	
	public matrix()
	{
		this.m = null;
		this.row = 0;
		this.column = 0;
		this.number = 0;
	}
	
	public matrix(int[][] m, int row, int column, int number)
	{
		this.m = m;
		this.row = row;
		this.column = column;
		this.number = number;
	}
	
	public matrix(int row, int column, int number) throws Exception
	{
		if (number >= row * column)
		{
			throw new Exception("Non-zero elements are exceeding the size of the matrix.");
		}
		else
		{
			this.m = new int[row][column];
			this.row = row;
			this.column = column;
			this.number = number;
			Random r = new Random();
			int[] picker = new int[number];
			for (int i = 0; i < number; i++)
			{
				int temp = r.nextInt(row * column);
				boolean check = false;
				for (int n = 0; n < i; n++)
				{
					if (temp == picker[n])
					{
						check = true;
					}
				}
				if (check)
				{
					i--;
				}
				else
				{
					picker[i] = temp;
				}
			}
			
			int index = 0;
			for (int i = 0; i < row; i ++)
			{
				for (int j = 0; j < column; j++)
				{
					boolean check = false;
					for (int k = 0; k < number; k++)
					{
						if (index == picker[k])
						{
							check = true;
						}						
					}
					m[i][j] = (check) ? r.nextInt(500) + 1 : 0;
					index++;
				}
			}
		}
	}
	
	public Yale toYale()
	{
		int[] A = new int[this.number];
		int index = 0;
		int[] IA = new int[this.column + 1];
		int[] JA = new int[this.number];
		for (int j = 0; j < this.column; j++)
		{
			IA[j] = index;
			for (int i = 0; i < this.row; i++)
			{				
				if (this.m[i][j] != 0)
				{
					A[index] = this.m[i][j];
					JA[index] = i;
					index++;
				}
			}			
		}
		IA[this.column] = index;
		Yale yale = new Yale(A, IA, JA);
		return yale;
	}
	
	public void display()
	{
		System.out.println('[');
		for (int j = 0; j < this.column; j++)
		{
			for (int i = 0; i < this.row; i++)
			{
				String element = this.m[i][j] + "";
				int elementLength = element.length(); 
				for (int k = 0; k < 4 - elementLength; k++)
				{
					element += " ";
				}
				System.out.print(element);
			}
			System.out.println("");
		}
		System.out.println(']');
	}	

}
