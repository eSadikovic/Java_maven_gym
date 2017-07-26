import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/18/2017.
 */
public class DolazakOdlazakTest  extends TestCase {
    @Test

    public void testDolazakOdlazak() {
        String s1 = "1";
        String s2 = "1,2";
        String s3 = "1,2,3";

        Klub kl = new Klub();
        kl = new Klub(kl, 1, 2);

        Clan c = new Clan("e", "s", 0);
        Clan c1 = new Clan("e", "s", 1);
        Clan c2 = new Clan("e", "s", 2);
        Clan c3 = new Clan("e", "s", 3);
        ArrayList<Clan> al = new ArrayList<Clan>();
        al.add(c);
        al.add(c1);
        al.add(c2);
        al.add(c3);
        kl.spisak = al;

        kl.DolazakOdlazak(2);
        assertTrue(kl.spisak.get(2).Tu);
        kl.DolazakOdlazak(2);
        assertFalse(kl.spisak.get(2).Tu);

    }

}