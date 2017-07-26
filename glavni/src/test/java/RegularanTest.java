import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/18/2017.
 */
public class RegularanTest extends TestCase {
    @Test

    public void testRegularan() {
        String s1 = "1";
        String s2 = "1,2";
        String s3 = "1,2,3";

        Klub kl = new Klub();
        kl=new Klub(kl, 1,2);

        Clan c = new Clan("e", "s", 0);
        Clan c1 = new Clan("e", "s", 1);
        Clan c2 = new Clan("e", "s", 2);
        Clan c3 = new Clan("e", "s", 4);
        ArrayList<Clan> al = new ArrayList<Clan>();
        al.add(c);
        al.add(c1);
        al.add(c2);
        al.add(c3);
        kl.spisak = al;


        assertFalse(kl.regularan(1,2,3));
        assertFalse(kl.regularan(1,3,30));
        assertFalse(kl.regularan(7,2,3));
        assertFalse(kl.regularan(1,20,3));
        assertFalse(kl.regularan(1,20,4));

    }

}