import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by emir on 5/14/17.
 */
public class Rad {

    public static void main(String[] args) {
        Klub klub=new Klub();
        int indikator = 1;
        try {

            klub = (Klub) Serijalizacija.deserialize("myfile");

        }
        catch(IOException i){
            i.printStackTrace();
        }

        catch (ClassNotFoundException e) {
        }

        int dan=unos.BirajDan();
        int sat=unos.BirajSat();
        klub=new Klub(klub, dan, sat);

        while (indikator != 0) {
            int num1=unos.Biranje();



            if (num1 == 1) {

                System.out.println("unesite ime i prezime: ");
                Scanner inpu = new Scanner(System.in);
                String str;

                if (inpu.hasNext())
                    str = inpu.nextLine();
                else {
                    System.out.println("Ime nije korektno uneto uneto");
                    inpu.next();
                    continue;
                }

                klub.dodajClana(str);
            }

            if (num1 == 8) {
               klub.ClanoviKojiCeDanasBitiTu(dan);
            }
            if (num1 == 9) {
                System.out.println("Unesite ime i/ili prezime: ");
                Scanner inpu = new Scanner(System.in);
                String str;

                if (inpu.hasNext())
                    str = inpu.nextLine();
                else {
                    System.out.println("Ime nije korektno uneto uneto");
                    inpu.next();
                    continue;
                }

                ArrayList<Integer> lista= klub.PretraziPoImenuIPrezimenu(str);
                System.out.println("Brojevi koji odgovaraju pretrazi: ");
                for(int tmp:lista){
                    System.out.println(tmp);
                }

            }


            if (num1 == 2) {
                ArrayList<Clan> al = klub.spisak;

                for (Clan tmp : al) {
                    System.out.println(tmp);
                }
            }

            if (num1 == 5) {
                System.out.println("Broj cl. karte");
                Scanner i = new Scanner(System.in);
                int rb;




                if (i.hasNextInt())
                    rb = i.nextInt();

                else {
                    System.out.println("Broj nije korektno unet");
                    i.next();
                    continue;
                }

                if (rb > klub.spisak.size()){
                    System.out.println("Ne postoji taj broj clanske karte");
                }


                klub.DolazakOdlazak(rb);
            }


            if (num1 == 4) {
                System.out.println("Broj cl. karte");
                Scanner inpu = new Scanner(System.in);
                int rbr;
                if (inpu.hasNextInt())
                    rbr= inpu.nextInt();
                else {
                    System.out.println("Broj nije korektno unet");
                    inpu.next();
                    continue;
                }


                klub.PrikaziDanasnjeSlobodneTermine(dan, sat);
                System.out.println("Da li zelite da zakazete danas termin: Y/N");
                String s = inpu.next();

                if (s.equals("Y")) {
                    System.out.println("Zakazi termin, u obliku \"a,b,c \", a za prvi sat c za poslednji");
                    s = inpu.next();
                    klub.ZakaziDanas(s, rbr);
                }

                if (s.equals("N")) {
                    System.out.println("Da li zelite da zakazete najblizi termin narednih dana?");
                    s = inpu.next();

                    if (s.equals("Y")) {
                        System.out.println("Ukucajte duzinu termina");
                        int t;



                        if (inpu.hasNextInt())
                            t = inpu.nextInt();
                        else {
                            System.out.println("Broj nije korektno unet");
                            inpu.next();
                            continue;
                        }




                        if (0<t && t<4) {
                            klub.ZakaziNajbliziZaNaredneDane(t, rbr);
                        }

                        else System.out.println("Uneli ste nedozvoljenu duzinu termina");
                    }
                }


            }


            if (num1 == 3) {
                klub.IzbaciTrenutnoPrisutne();

            }


            if (num1 == 6) {
                klub.StampajRaspored();

            }
            if (num1 == 7) {
                Scanner inpu = new Scanner(System.in);
                System.out.println("Koliko clanova zelite da ubacite odjednom?");
                int n = inpu.nextInt();

                for (int i = 0; i < n; i++) {
                    System.out.println("Ubacite: \"dan, sat, broj clanske karte \", za prekid unosa ukucajte broj 0");
                    if(inpu.hasNextInt()){break;}
                    String string = inpu.next();
                    klub.BrzoDodavanje(string);
                }
            }

            if (num1 == 0) {
                indikator = 0;
            }
        }


        try {

            Serijalizacija.serialize(klub, "myfile");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
}