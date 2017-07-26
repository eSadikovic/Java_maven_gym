import org.junit.Test;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;
import java.*;

public class BrzoDodavanjeTest1 extends  TestCase
{
    @Test

    public void testBrzoDodavanje() {
        String s="1,2,3";
        Klub kl=new Klub();

        Clan c=new Clan("e","s", 0);
        Clan c1=new Clan("e","s", 1);
        Clan c2=new Clan("e","s", 2);
        Clan c3=new Clan("e","s", 4);
        ArrayList<Clan> al=new ArrayList<Clan>();
        al.add(c);
        al.add(c1);
        al.add(c2);
        al.add(c3);
        kl.spisak=al;


        kl.BrzoDodavanje(s);
        int j=kl.Niz[1][2].get(0);
        assertEquals(j,3);
    }


}