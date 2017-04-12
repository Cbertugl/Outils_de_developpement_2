package cb;

import com.opencsv.*;
import java.io.*;
import java.util.*;
import org.apache.commons.collections.*;
import java.lang.*;

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
                CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"), ';', (char)0);
                try
                {
                    List<String[]>myEntries = reader.readAll();


                    for(int i=0; i<myEntries.size(); i++)
                    {
                        System.out.println("Ligne:"+i);
                        nbstr=myEntries.get(i);
                        nb=nbstr[0].split(";");
                        List list = Arrays.asList(nb);
                        Vector<String>out=new Vector<String>();
                        Predicate predicat = new Predicate()
                        {
                            public boolean evaluate(Object x)
                            {
                                try
                                {
                                    return Integer.parseInt((String) x) < 50;
                                }
                                catch (java.lang.NumberFormatException n)
                                {
                                    return false;
                                }
                            }
                        };
                        
                        CollectionUtils.select(list, predicat, out);
                        System.out.println("OUT:"+out);
                        for (int j=0; j < out.size(); j++) {
                            String[] tmp=out.toArray(new String[0]);
                            System.out.println("TMP:"+tmp[j]);
                            if(j==out.size()-1)
                            {
                                writer.writeNext(tmp);
                            }

                            String y = out.get(j).toString();
                            x= Integer.parseInt(y);
                            monmax=max(x,monmax);
                        }
                        
                        //parcourt
                        //for(int k=0; k<nb.length; k++)
                        //{
                        //    x = Integer.parseInt(nb[k]);
                        //    System.out.println("Nombre lu:"+x);
                        //    monmax=max(x, monmax);
                        //}
                    }    
                    System.out.println("Le max:"+monmax);
                }
                catch (IOException e)
                {
                    System.out.println("Erreur: IOException1");
                }
                writer.close();
            }
            catch (IOException e)
            {
                System.out.println("Erreur: IOException2");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Erreur: FileNotFoundException");
        }
    }
}
