import java.io.Serializable;
import java.util.*;
public class Clan implements Serializable {
    String Ime;
    String Prezime;
    int Rbr;
    boolean Tu;
    ArrayList<Integer> [] zakazano;


    {

    }

    public Clan(String ime, String prezime, int rbr){
        this.Ime=ime;
        this.Prezime=prezime;
        this.Rbr=rbr;
        this.Tu=false;
        this.zakazano = new ArrayList[7];
        for(int i=0;i<7;i++){
            this.zakazano[i]=new ArrayList<Integer>();

        }

    }


    public void dodajUKlub(ArrayList<Clan> clanovi){
        clanovi.add(this);
    }



    public String toString(){
        return this.Ime + " " + this.Prezime + " " + this.Rbr + " Prisutan: " + this.Tu;
    }





    public void Zakazi(int dan, int sat){
        for(int i=0; i<3; i++)
            if (zakazano[dan].size() >=3) {
            System.out.println("Popunjeni su temini za ovog clana za taj dan");
            }

            else
        zakazano[dan].add(sat);

    }




}
