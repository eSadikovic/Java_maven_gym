import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/18/2017.
 */
public class ZakaziDanasTest extends TestCase
{
    @Test

    public void testZakaziDanas() {
        String s1="1";
        String s2="1,2";
        String s3="1,2,3";

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

        kl.ZakaziDanas(s1, 0);
        kl.ZakaziDanas(s2, 1);
        kl.ZakaziDanas(s3, 2);
        assertEquals((int) kl.Niz[0][1].get(0),0);
        assertEquals((int) kl.Niz[0][1].get(1),1);
        assertEquals((int) kl.Niz[0][1].get(2),2);
        assertEquals((int) kl.Niz[0][2].get(0),1);
        assertEquals((int) kl.Niz[0][2].get(1),2);
        assertEquals((int) kl.Niz[0][3].get(0),2);


    }


}