package cb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int max(int a,int b)
    {
    	return a > b ? a:b;
    }
	
	
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World! Quelques modifications !" );
        int x = max(3,4);
        System.out.println(x);
    }
}
