import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by emir.sadikovic on 5/4/2017.
 */
public class Klub implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Clan> spisak;
    ArrayList<Integer> Niz[][];
    public int dan;
    public int sat;

    public Klub() {
        spisak = new ArrayList<Clan>();
        dan = 0;
        sat = 0;
        ArrayList<Integer> k = new ArrayList<Integer>();
        Niz = new ArrayList[7][12];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {
                Niz[i][j] = new ArrayList<Integer>();

            }

        }

    }

    public Klub(ArrayList arrayList, ArrayList<Integer>[][] niz) {
        spisak = arrayList;
        Niz = niz;
    }

    public Klub(Klub k, int dan, int sat) {
        this.spisak = k.spisak;
        this.dan = dan;
        this.sat = sat;
        this.Niz = k.Niz;

    }

    public void dodajClana(Clan c) {
        this.spisak.add(c);
    }

    public void dodajClana(String s) {

        String[] st;
        st = s.split(" ");
        String i = st[0];
        String p = st[1];
        Clan c = new Clan(i, p, this.spisak.size());
        this.spisak.add(c);
    }


   /* public void dosao(int i){

        for (Clan c : this.spisak){
            if (c.Rbr==i){
                c.Tu=true;
            }
        }

    }

    public void otisao(int i){

        for (Clan c : this.spisak){
            if (c.Rbr==i){
                c.Tu=false;
            }
        }

    } */

    public void IzbaciTrenutnoPrisutne() {
        for (Clan c : this.spisak) {
            if (c.Tu == true) {
                System.out.println(c);
            }
        }

    }

    public void PrikaziDanasnjeSlobodneTermine(int danasnjiDan, int trenutniSat) {

        for (int i = trenutniSat+1; i < 12; i++) {
            if (Niz[danasnjiDan][i].size() < 16) {
                System.out.println("slobodan termin u " + i);
            }
        }

    }



    public void BrzoDodavanje(String s){
        String[] tokensVal = s.split(",");
        if (tokensVal.length != 3) {
            System.out.println("Unos nije dobar");
        }
        int i=Integer.parseInt(tokensVal[0]);
        int j=Integer.parseInt(tokensVal[1]);
        int k=Integer.parseInt(tokensVal[2]);

        this.zauzmi(i,j,k);

    }


    public void ZakaziDanas(String termini, int rbr) {
        if (rbr > this.spisak.size()) {
            System.out.println("Ne postoji taj broj clanske karte");
        } else {

            String[] tokensVal = termini.split(",");

            if (tokensVal.length > 3) {
                System.out.println("Uneli ste termin neprikladne duzine");
            } else {
                for (String tmp : tokensVal) {

                    try {
                        int i = Integer.parseInt(tmp);

                        zauzmi(dan, i, rbr);
                    } catch (NumberFormatException e) {
                        System.out.println("Niste uneli korektan format");

                    }
                }
            }
        }

    }

    public void ZakaziNajbliziZaNaredneDane(int duzina, int rbr){
        if (rbr > this.spisak.size()){
            System.out.println("Ne postoji taj broj clanske karte");
        }
        else {
            if (duzina > 3 || duzina < 1) {
                System.out.println("Uneli ste termin neprikladne duzine");
            } else {
                for (int d = dan + 1; d < 7; d++) {
                    for (int i = 0; i < 16 - duzina; i++) {
                        int b = 1;
                        for (int k = 0; k < duzina; k++) {
                            if (Niz[d][i].size() == 16) {
                                b = b * 0;
                            }
                        }
                        if (b == 1) {
                            for (int k = 0; k < duzina; k++) {
                                this.zauzmi(d, i + k, rbr);
                            }
                            System.out.println("Slobodan dan: " + d + ", u: " + i + "sati radnog vremena");

                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    public void DolazakOdlazak(int rb){
        for (Clan c : this.spisak) {
            if (c.Rbr == rb) {

                if(c.Tu){
                    c.Tu=false;
                }
                else c.Tu=true;

            }
        }
    }

    public boolean regularan(int dan, int sat, int rbr){
        if (rbr > this.spisak.size()){
            System.out.println("Ne postoji taj broj clanske karte");
            return false;
        }

        if (rbr > this.spisak.size()){
            System.out.println("Ne postoji taj broj clanske karte");
            return false;
        }

        if (dan<0 || dan>6 ){
            System.out.println("dan nije dobro unet");
            return false;
        }

        if (dan<this.dan || (dan==this.dan && sat<=this.sat)){
            System.out.println("Unet je termin koji je vec prosao");
            return false;
        }

        if (sat<0 || sat>11){
            System.out.println("sat nije dobro unet");
            return false;
        }

        if (this.Niz[dan][sat].size() == 16) {
            System.out.println("Termin nije slobodan");
            return false;
        }

        Clan c=this.spisak.get(rbr);

        if (c.zakazano[dan].size() ==3) {
            System.out.println("Ovaj clan je popunio svoje dnevne sate");
            return false;
        }

        if (this.Niz[dan][sat].contains(rbr)) {
            System.out.println("Ovaj clan je vec dodat u datom terminu");
            return false;
        }

        else return true;
    }

    public ArrayList<Integer> PretraziPoImenuIPrezimenu(String s){
    ArrayList<Integer> lista=new ArrayList<Integer>();
    String st = s.replaceAll("\\s+","");
    for(Clan tmp: this.spisak){
        if (st.equalsIgnoreCase(tmp.Ime.replaceAll("\\s+",""))
                || st.equalsIgnoreCase(tmp.Prezime.replaceAll("\\s+","")) ||
                st.equalsIgnoreCase(tmp.Ime.replaceAll("\\s+","") + tmp.Prezime.replaceAll("\\s+",""))
                ||  st.equalsIgnoreCase(tmp.Prezime.replaceAll("\\s+","") +  tmp.Ime.replaceAll("\\s+","")))
        {
            lista.add(tmp.Rbr);
        }

    }


    return  lista;
    }

    public ArrayList<Integer> ClanoviKojiCeDanasBitiTu(int dan) {
        ArrayList<Integer> priv = new ArrayList<Integer>();
        for (int i =0; i < 12; i++) {
            for (int tmp : Niz[dan][i])
            {
                if (priv.contains(tmp)){
                    continue;
                }
                 else {
                 priv.add(tmp);
                 System.out.println(this.spisak.get(tmp));
                }
            }
        }
        return priv;
    }




    public void zauzmi(int dan, int sat, int rbr){
        if (regularan(dan, sat,rbr)) {
            this.Niz[dan][sat].add(rbr);
            this.spisak.get(rbr).zakazano[dan].add(sat);

        }
        else System.out.println("Greska!");
    }

    public void StampajRaspored(){
        String s= "Raspored: \n";


        for (int i=0; i<7; i++){
            for(int j=0; j<12; j++) {
                s = s + " [" + i + "] [" + j + "] ";
                {
                    for (int k = 0; k < Niz[i][j].size(); k++)
                        s = s + this.Niz[i][j].get(k) + " ";

                }
                s = s + "\n";
            }
        }

        System.out.println(s);

    }




    public String toString(){

        String s= "Spisak imena: ";
        for (Clan tmp : this.spisak) {
            s=s+ tmp + "\n";
        }
        s=s+"\n";

        for (int i=0; i<7; i++){
            for(int j=0; j<12; j++) {
                s = s + " [" + i + "] [" + j + "] ";
                {
                    for (int k = 0; k < Niz[i][j].size(); k++)
                        s = s + this.Niz[i][j].get(k) + " ";

                }
                s = s + "\n";
            }
        }

        return s;


    }


}
