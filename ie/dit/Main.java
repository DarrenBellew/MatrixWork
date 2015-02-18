package ie.dit;

class Main  {
	public static void main(String[] args)  {
		
			Matrix2D m = new Matrix2D(3,3);
			Matrix2D n = new Matrix2D(3,3);
			
			try  {
				for(int i=0; i<m.getRows(); i++)  {
					for(int j=0; j<m.getCols(); j++)  {
						m.setData(i,j,3);
						n.setData(i,j,3);
					}
				}
			}

			catch (Matrix2DException exc)  {
				exc.printStackTrace();
			}

			System.out.println("M Data: ");
			
			for(int i=0; i<m.getRows(); i++)  {
				for(int j=0; j<m.getCols(); j++)  {
					System.out.println(m.getData(i, j));
				}
			}
			System.out.println("N Data: ");
			for(int i=0; i<m.getRows(); i++)  {
				for(int j=0; j<m.getCols(); j++)  {
					System.out.println(n.getData(i, j));
				}
			}

			
			/*
			try  {
				m.add(n);
				System.out.println("New M: ");
				for(int i=0; i<m.getRows(); i++)  {
					for(int j=0; j<n.getRows(); j++)  {
						System.out.println(m.getData(i,j));
					}
				}
			}
			catch (Matrix2DException exc) {
				
				exc.printStackTrace();
			}
			*/

			try  {
				System.out.println("Distance between m and n: ");
				System.out.println(
					"Distance is: " + EditDistance.minimumEditDistance(
					m,n//"I like robots", "I like robot"
					));
			}
			catch (Matrix2DException exc) {
				exc.printStackTrace();
			}


			//n.mult(m); Multiplication

			/*
			try  {
				n.randomize(10);
			}
			catch (Matrix2DException exc)  {
				exc.printStackTrace();
			}

			*/
			/*System.out.println("New N: ");
			for(int i=0; i<n.getRows(); i++)  {
				for(int j=0; j<n.getCols(); j++)  {
					System.out.println(n.getData(i,j));
				}
			}*/
		

		

	}
}