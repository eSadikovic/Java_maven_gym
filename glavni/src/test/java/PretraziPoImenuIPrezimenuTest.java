import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;


import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;




import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/18/2017.
 */
public class PretraziPoImenuIPrezimenuTest extends TestCase
{
    @Test

    public void testPretraziPoImenuIPrezimenu() {
        String s1="1";
        String s2="1,2";
        String s3="1,2,3";

        Klub kl=new Klub();
        kl=new Klub(kl, 1,0);

        Clan c=new Clan("laza","lazic", 0);
        Clan c1=new Clan("pera","peric", 1);
        Clan c2=new Clan("mika","mikic", 2);
        Clan c3=new Clan("pera","mikic", 4);
        ArrayList<Clan> al=new ArrayList<Clan>();
        al.add(c);
        al.add(c1);
        al.add(c2);
        al.add(c3);
        kl.spisak=al;

        ArrayList<Integer> aLista1 =  kl.PretraziPoImenuIPrezimenu("laza");
        ArrayList<Integer> aLista2 =  kl.PretraziPoImenuIPrezimenu("pera peric");
        ArrayList<Integer> aLista3 =  kl.PretraziPoImenuIPrezimenu("pera");
        ArrayList<Integer> aLista4 =  kl.PretraziPoImenuIPrezimenu("Mikic ");

        assertEquals(1, aLista1.size());
        assertEquals(1, aLista2.size());
        assertEquals(2, aLista3.size());
        assertEquals(2, aLista4.size());

        assertEquals(0,(int) aLista1.get(0));
        assertEquals(1,(int) aLista2.get(0));
        assertEquals(1,(int) aLista3.get(0));
        assertEquals(4,(int) aLista3.get(1));
        assertEquals(2,(int) aLista4.get(0));
        assertEquals(4,(int) aLista4.get(1));


    }


}