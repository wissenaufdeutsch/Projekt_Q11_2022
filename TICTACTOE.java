
public class TICTACTOE implements TTTCONSTANTS
{
    TTTVIEW t;
    TTTMODEL m;

    TICTACTOE(){
        t=new TTTVIEW(){
            public void SiegerDarstellen(BELEGUNG s)
            {
                System.out.println(s);
            }

            public void UnentschiedenDarstellen()
            {
                System.out.println("Unentschieden!");
            }
        };
        m=new TTTMODEL();
    }

    void Zug(int x, int y){
        m.Zug(x,y);
        if (HatGewonnen().equals(BELEGUNG.UNBELEGT)==false){
            t.SiegerDarstellen(HatGewonnen());
        } else if(IstUnentschieden()==true){
            t.UnentschiedenDarstellen(); 
        }
    }

    boolean IstUnentschieden(){
        KÄSTCHEN[][]k=m.SpielfeldGeben();        
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                if(k[i][j].belegtGeben().equals(BELEGUNG.UNBELEGT)==true)
                {
                    return false;
                }
            }
        }
        return true; 
    }

    BELEGUNG HatGewonnen() //gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst "unbelegt"
    {

        if (IstGleich(m.FeldGeben(0,0), m.FeldGeben(1,0), m.FeldGeben(2,0)).equals(BELEGUNG.UNBELEGT)==false || IstGleich(m.FeldGeben(0,0), m.FeldGeben(0,1), m.FeldGeben(0,2)).equals(BELEGUNG.UNBELEGT)==false || IstGleich(m.FeldGeben(0,0), m.FeldGeben(1,1), m.FeldGeben(2,2)).equals(BELEGUNG.UNBELEGT)==false){
            return m.FeldGeben(0,0).belegtGeben();
        }else if(IstGleich(m.FeldGeben(1,0), m.FeldGeben(1,1), m.FeldGeben(1,2)).equals(BELEGUNG.UNBELEGT)==false ||IstGleich(m.FeldGeben(0,1), m.FeldGeben(1,1), m.FeldGeben(2,1)).equals(BELEGUNG.UNBELEGT)==false || IstGleich(m.FeldGeben(0,2), m.FeldGeben(1,1), m.FeldGeben(2,0)).equals(BELEGUNG.UNBELEGT)==false){
            return m.FeldGeben(1,1).belegtGeben();
        } else if(IstGleich(m.FeldGeben(2,0), m.FeldGeben(2,1), m.FeldGeben(2,2)).equals(BELEGUNG.UNBELEGT)==false || IstGleich(m.FeldGeben(0,2), m.FeldGeben(1,2), m.FeldGeben(2,2)).equals(BELEGUNG.UNBELEGT)==false){
            return m.FeldGeben(2,2).belegtGeben();
        } else {
            return BELEGUNG.UNBELEGT;
        }   

    }

    BELEGUNG IstGleich(KÄSTCHEN k1,KÄSTCHEN k2, KÄSTCHEN k3){
        if (k1.belegtGeben().equals(k2.belegtGeben()) && k1.belegtGeben().equals(k3.belegtGeben()) && k1.belegtGeben().equals(BELEGUNG.UNBELEGT)==false){
            return k1.belegtGeben();
        } else {
            return BELEGUNG.UNBELEGT; 
        }
    }

}

