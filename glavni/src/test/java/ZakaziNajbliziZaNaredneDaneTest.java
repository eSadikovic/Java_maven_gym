import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/18/2017.
 */
public class ZakaziNajbliziZaNaredneDaneTest extends TestCase
{
    @Test

    public void testZakaziDanas() {

        Klub kl=new Klub();
        kl=new Klub(kl, 1,2);
        ArrayList<Clan> al=new ArrayList<Clan>();
        for (int i=0;i<10;i++)


        al.add(new Clan("e", "s", i));


        kl.spisak=al;

        kl.ZakaziNajbliziZaNaredneDane(3,1);



        assertEquals((int) kl.Niz[2][0].get(0),1);
        assertEquals((int) kl.Niz[2][1].get(0),1);
        assertEquals((int) kl.Niz[2][2].get(0),1);



    }


}