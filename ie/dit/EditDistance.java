package ie.dit;

class EditDistance  {


	static float minimumEditDistance(Matrix2D a, Matrix2D b) throws Matrix2DException {/*String f, String g) throws Matrix2DException*/
		String f = EditDistance.matrixToString(a);
		String g = EditDistance.matrixToString(b);

		Matrix2D c = new Matrix2D(f.length()+1, g.length()+1);
		System.out.println(f);
		System.out.println(g);

		for(int i=1; i<c.getRows(); i++)  {
			c.setData(i-1,0,i-1);
			
			for(int j=1; j<c.getCols(); j++)  {
				c.setData(0,j-1,j-1);
				float x=0;

				if(f.charAt(i-1) == g.charAt(j-1))  {
					x = c.getData(i-1,j-1);
				}

				else {

					x = 1 + EditDistance.min3 (
							c.getData(i-1,j),
							c.getData(i,j-1),
							c.getData(i-1,j-1)
						);
				}
				
				c.setData(i,j,x);
			}
		}

		return c.getData(f.length(), g.length());
	}



	static float min3(float x, float y, float z)  {
		if(x<y && x<z)  {
			return x;
		}
		//already <x
		else if(y<z)  {
			return y;
		}
		//z is now the lowest
		else  {
			return z;
		}
	}

	static String matrixToString(Matrix2D c)  {
		String t = "";

		for(int i=0; i<c.getRows(); i++)  {
			for (int j=0; j<c.getCols(); j++) {
				t = t+c.getData(i,j)+"\t";
			}
		}
		
		return t;
	}
}