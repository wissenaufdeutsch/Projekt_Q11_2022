
public class TICTACTOE
{
    KÄSTCHEN[][] spielfeld;
    int SpielerAmZug;

    TICTACTOE(){
        spielfeld=new KÄSTCHEN[3][3];
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
        SpielerAmZug=1; //1:Spieler 1 (Kreuz); 2: Spieler 2 (Kreis)
    }

    void Zug(int x, int y){
        if(SpielerAmZug==1){
            spielfeld[x][y].Belegen("Kreuz");
            SpielerAmZug=2;
        } else {
            spielfeld[x][y].Belegen("Kreis");
            SpielerAmZug=1;
        }

        if (HatGewonnen().equals("unbelegt")==false){
            System.out.println("Sieger!");
            //SiegerDarstellen(HatGewonnen()); Methode sol den Sieger darstellen, bekommt entweder String "Kreuz" oder "Kreis" als Übergabeparameter
        }

    }

    void Reset(){
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
    }

    String HatGewonnen() //gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst "unbelegt"
    {

        if (IstGleich(spielfeld[0][0], spielfeld[1][0], spielfeld[2][0]).equals("unbelegt")==false || IstGleich(spielfeld[0][0], spielfeld[0][1], spielfeld[0][2]).equals("unbelegt")==false || IstGleich(spielfeld[0][0], spielfeld[1][1], spielfeld[2][2]).equals("unbelegt")==false){
            return spielfeld[0][0].belegtGeben();
        }else if(IstGleich(spielfeld[1][0], spielfeld[1][1], spielfeld[1][2]).equals("unbelegt")==false ||IstGleich(spielfeld[0][1], spielfeld[1][1], spielfeld[2][1]).equals("unbelegt")==false || IstGleich(spielfeld[0][2], spielfeld[1][1], spielfeld[2][0]).equals("unbelegt")==false){
            return spielfeld[1][1].belegtGeben();
        } else if(IstGleich(spielfeld[2][0], spielfeld[2][1], spielfeld[2][2]).equals("unbelegt")==false || IstGleich(spielfeld[0][2], spielfeld[1][2], spielfeld[2][2]).equals("unbelegt")==false){
            return spielfeld[2][2].belegtGeben();
        } else {
            return "unbelegt";
        }   

    }

    String IstGleich(KÄSTCHEN k1,KÄSTCHEN k2, KÄSTCHEN k3){
        if (k1.belegtGeben().equals(k2.belegtGeben()) && k1.belegtGeben().equals(k3.belegtGeben()) && k1.belegtGeben().equals("unbelegt")==false){
            return k1.belegtGeben();
        } else {
            return "unbelegt"; 
        }
    }

    int SpielerAmZugGeben(){
        return SpielerAmZug;
    }

    KÄSTCHEN[][] SpielfeldGeben(){
        return spielfeld; 
    }
}

