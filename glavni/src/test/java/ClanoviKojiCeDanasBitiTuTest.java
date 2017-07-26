import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;




import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/18/2017.
 */
public class ClanoviKojiCeDanasBitiTuTest extends TestCase
{
    @Test

    public void testClanoviKojiCeDanasBitiTu() {
        String s1="1";
        String s2="1,2";
        String s3="1,2,3";

        Klub kl=new Klub();
        kl=new Klub(kl, 1,0);

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

        ArrayList<Integer> aLista=kl.ClanoviKojiCeDanasBitiTu(1);

        assertEquals(3, aLista.size());
        assertEquals(0,(int) aLista.get(0));
        assertEquals(1,(int) aLista.get(1));
        assertEquals(2,(int) aLista.get(2));

    }


}