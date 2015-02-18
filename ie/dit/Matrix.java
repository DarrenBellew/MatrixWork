package ie.dit;

import java.util.Random;

class Matrix2D  {

	private float[][] data;
	private int row;
	private int col;

	Matrix2D(int row, int col)  {
		data = new float[row][col];
		this.row = row;
		this.col=col;
		setIdentity();
	}

	Matrix2D(Matrix2D c)  {
		
			for(int i=0; i<c.getRows(); i++)  {
				for(int j=0; j<c.getCols(); j++)  {
					try  {
						setData(i, j, c.getData(i,j));
					}
					catch (Matrix2DException exc)  {
						exc.printStackTrace();
					}
				}
			}
		
		
	}



	float getData(int row, int col)  {
		return data[row][col];
	}

	void setData(int row, int col, float data) throws Matrix2DException {
		if(row > this.row || col > this.col)  {
			throw new Matrix2DException("Out of Bounds Exception on Setting Data... cause fuck you thats why");
		}
		
		this.data[row][col] = data;
		
		
	}




	int getRows()  {
		return row;
	}
	int getCols()  {
		return col;
	}

	void setIdentity()  {
		for(int i=0; i<row; i++)  {
			for(int j=0; j<col; j++)  {
				if(i==j)  {
					data[i][j] = 1;
				}
				else  {
					data[i][j] = 0;
				}
			}
		}
	}
	void setMatrix(Matrix2D c) throws Matrix2DException {
		if(c.getRows() != row || c.getCols() != col)  {
			throw new Matrix2DException("Invalid Matrix Size");
		}


		for(int i=0; i<c.getRows(); i++)  {
			for(int j=0; j<c.getCols(); j++)  {
				setData(i, j, c.getData(i,j));
			}
		}
	}


	public static Matrix2D add(Matrix2D a, Matrix2D b) throws Matrix2DException {
		
		try{
			Matrix2D c = new Matrix2D(a.getRows(), a.getCols());

			for(int i=0; i< a.getRows(); i++)  {
				for(int j=0; j< a.getCols(); j++)  {
					c.setData(i,j, a.getData(i,j) + b.getData(i,j));
				}
			}
			return c;
		}
		catch (Matrix2DException exc)  {
			exc.printStackTrace();
		}
		return a;
	}

	public void add(Matrix2D c) throws Matrix2DException {
		if(col != c.getRows())  {
			throw new Matrix2DException("Invalid Adding Calculation");
		}

		for(int i=0; i<row; i++)  {
			for(int j=0; j<col; j++)  {
				setData(i,j, getData(i,j) + c.getData(i,j));
			}
		}
	
	}

	public void mult(Matrix2D b) throws Matrix2DException {
		
		if(row != b.getRows() || col != b.getCols())  {
			throw new Matrix2DException("Invalid Multiplication");
		}

		int mainI = 0;
		
		for(int i=0; i<getCols(); i++) {
			for(int j=0; j<getRows(); j++)  {	
			
				for(int l=0; l < b.getCols();l++)  {
					for(int k=0; k < b.getRows(); k++)  {
				
						setData(i,j,getData(i,j) * b.getData(k,l));
						System.out.println(i+", "+j);
					}
				}
			}
		}
	}

	public void randomise(float max) throws Matrix2DException {
		Random rand = new Random();
		for(int i=0; i<getRows(); i++)  {
			for(int j=0; j<getCols(); j++)  {
				try  {
					setData(i,j,rand.nextFloat() * max);
				}
				catch (Matrix2DException exc)  {
					exc.printStackTrace();
				}
			}
		}
	}

	

	
}