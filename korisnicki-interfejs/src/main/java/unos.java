import java.util.Scanner;

/**
 * Created by emir on 5/14/17.
 */
public class unos {


    static int DanUBroj(String s) {
        if (s.equals("pon") || s.equals("Pon") || s.equals("PON"))
            return 0;
        if (s.equals("uto") || s.equals("Uto") || s.equals("UTO"))
            return 1;
        if (s.equals("sre") || s.equals("Sre") || s.equals("SRE"))
            return 2;
        if (s.equals("cet") || s.equals("Cet") || s.equals("CET"))
            return 3;
        if (s.equals("pet") || s.equals("Pet") || s.equals("PET"))
            return 4;
        if (s.equals("sub") || s.equals("Sub") || s.equals("SUB"))
            return 5;
        if (s.equals("ned") || s.equals("Ned") || s.equals("NED"))
            return 6;
        else {
            System.out.println("Niste uneli tacno dan");
            return -1;
        }
    }

    public static int Biranje() {

        int num1=0;

        System.out.println("\n ======================================== \n Za novog clana unesite 1, za spisak svih clanova 2, \n" +
                " za spisak trenutno prisutnih 3, \n" +
                " za zakazivanje 4,\n za dolazak-odlazak u teretanu 5,  \n" +
                "Za stampanje rasporeda 6 \n Za brzo dodavanje u raspored 7 \n" +
                "Za spisak clanova koji ce danas biti tu 8 \n" +
                        "Za pretragu po imenu i/ili prezimenu 9 \n" +
                "Ako zelite da zavrsite unesite: 0 \n " );
        Scanner inp = new Scanner(System.in);


        if (inp.hasNextInt())
            num1 = inp.nextInt();
        else {
            System.out.println("Broj nije korektno unet");
            inp.next();
        }

        return num1;

    }
public static int BirajDan() {
    int n = 0;
    Scanner in = new Scanner(System.in);

    int dan = 0;

    System.out.println("Unesite danasnji dan (u obliku: pon/uto/sre...)");
    String danS = in.next();
    dan = DanUBroj(danS);
   return dan;


    }



    public static int BirajSat() {
        Scanner in = new Scanner(System.in);
        int sat = 0;

        System.out.println("Unesite trenutni sat radnog vremena (0-11)");

        if (in.hasNextInt())
            sat = in.nextInt();
        else {
            System.out.println("Sat nije korekntno unet");
            in.next();
        }

        if (sat < 0 || sat > 11) {
            System.out.println("Sat nije korekntno unet");
            in.next();
        }
        return sat;


    }

}
