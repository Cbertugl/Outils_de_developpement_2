package cb;

import com.opencsv.*;
import java.io.*;
import java.util.*;
//import java.lang.*;


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
        //int x = max(3,4);
        //System.out.println(x);

        int monmax = 0;
        int x;
        String[] nbstr;
        String[] nb;
        try
        {
            CSVReader reader = new CSVReader(new FileReader("data.csv"));
            try
            {
                List<String[]>myEntries = reader.readAll();

                for(int i=0; i<myEntries.size(); i++)
                {
                    System.out.println("Ligne:"+i);
                    nbstr=myEntries.get(i);
                    //parcourt
                    nb=nbstr[0].split(";");
                    for(int k=0; k<nb.length; k++)
                    {
                        x = Integer.parseInt(nb[k]);
                        System.out.println("Nombre lu:"+x);
                        monmax=max(x, monmax);
                    }
                }    
            System.out.println("Le max:"+monmax);
            }
            catch (IOException e)
            {
                System.out.println("Erreur: IOException");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Erreur: FileNotFoundException");
        }
    }
}
