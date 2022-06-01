
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

    void Reset(){
        m.Reset();
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


    BELEGUNG HatGewonnen_old() //gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst "unbelegt"
   

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

    BELEGUNG HatGewonnen() //gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst "unbelegt"
    {

        for(int a=0;a<3;a=a+1){
            if (IstGleich(m.FeldGeben(a,0),m.FeldGeben(a,1),m.FeldGeben(a,2)).equals(BELEGUNG.UNBELEGT)==false){
                return m.FeldGeben(a,0).belegtGeben();
            }
        }
        for(int b=0;b<3;b=b+1){
            if (IstGleich(m.FeldGeben(0,b),m.FeldGeben(1,b),m.FeldGeben(2,b)).equals(BELEGUNG.UNBELEGT)==false){
                return m.FeldGeben(0,b).belegtGeben();
            }
        }        
        for (int c=0;c>-3;c=c-2){
            if(IstGleich(m.FeldGeben(Math.abs(c),0),m.FeldGeben(1,1),m.FeldGeben(c+2,2)).equals(BELEGUNG.UNBELEGT)==false){
                return m.FeldGeben(1,1).belegtGeben();
            }
        }
        return BELEGUNG.UNBELEGT;
    }

    BELEGUNG IstGleich(KÄSTCHEN k1,KÄSTCHEN k2, KÄSTCHEN k3){
        if (k1.belegtGeben().equals(k2.belegtGeben()) && k1.belegtGeben().equals(k3.belegtGeben()) && k1.belegtGeben().equals(BELEGUNG.UNBELEGT)==false){
            return k1.belegtGeben();
        } else {
            return BELEGUNG.UNBELEGT; 
        }
    }

}

