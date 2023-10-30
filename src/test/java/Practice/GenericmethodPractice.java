package Practice;

public class GenericmethodPractice {

	public static void main(String[] args) //caller method  
	{
		int a=10;
		int b=20;
		int c =a+b;
		
		System.out.println(c);
      add();
     int sum = add(400,500);
     System.out.println(sum);
	}
	
	public static void add() //called method
	{
		int a=10;
		int b= 40;
		int c= a+b;
		System.out.println(c);
	}
	
	public static int add(int a, int b)//called method
	{   //when ever we want the data we use parameter 
		int c= a+b;   //here we have not use the hard code data instead of hard coding we pass the arguments
		return c;     //instead of sopln statement we use return because it fully depends on caller method.
	}

}
