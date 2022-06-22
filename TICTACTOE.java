
public class TICTACTOE implements TTTCONSTANTS
{
    TTTVIEW t;
    TTTMODEL m;
    private KÄSTCHEN[][] Gewinnbedingung;

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
        Gewinnbedingung= new KÄSTCHEN[8][3];

        for(int i=0;i<3;i=i+1){
            for(int a=0;a<3;a=a+1){
                Gewinnbedingung[i][a]=m.FeldGeben(i,a);
            }
        }

        for(int i=0;i<3;i=i+1){
            for(int b=0;b<3;b=b+1){
                Gewinnbedingung[i+3][b]=m.FeldGeben(b,i);
            }
        }

        Gewinnbedingung[6][0]=m.FeldGeben(0,0);
        Gewinnbedingung[6][1]=m.FeldGeben(1,1);
        Gewinnbedingung[6][2]=m.FeldGeben(2,2);
        Gewinnbedingung[7][0]=m.FeldGeben(0,2);
        Gewinnbedingung[7][1]=m.FeldGeben(1,1);
        Gewinnbedingung[7][2]=m.FeldGeben(2,0);

    }

    void Zug(int x, int y){
        m.Zug(x,y);
        if (HatGewonnen().equals(BELEGUNG.UNBELEGT)==false){
            t.SiegerDarstellen(HatGewonnen());
        } else if(IstUnentschieden()==true){
            t.UnentschiedenDarstellen(); 
        }
    }

    void ZugPC(BELEGUNG s){ //wer is PC
        KÄSTCHEN k=WirdGewinnen(s);
        KÄSTCHEN k1=InEcke();
        KÄSTCHEN k2=AnRand();
        if(k!=null && k.belegtGeben().equals(BELEGUNG.UNBELEGT)){
            k.Belegen(s); 
        } else if(m.FeldGeben(1,1).belegtGeben().equals(BELEGUNG.UNBELEGT)){
            m.FeldGeben(1,1).Belegen(s);
        } else if(k1!= null){
            k1.Belegen(s);
        } else if(k2!=null){
            k2.Belegen(s);
        } 

    }

    void Reset(){
        m.Reset();
    }

    KÄSTCHEN AnRand(){
        for(int i=0;i<3;i=i+2){
            if(m.FeldGeben(i,1).belegtGeben().equals(BELEGUNG.UNBELEGT)){
                return m.FeldGeben(i,1);
            }
            if(m.FeldGeben(1,i).belegtGeben().equals(BELEGUNG.UNBELEGT)){
                return m.FeldGeben(1,i);
            }
        }
        return null;
    }

    KÄSTCHEN InEcke(){
        for(int i=0;i<3;i=i+2){
            for(int j=0;j<3;j=j+2){
                if(m.FeldGeben(i,j).belegtGeben().equals(BELEGUNG.UNBELEGT)){
                    return m.FeldGeben(i,j);
                }
            }
        }
        return null;
    }

    KÄSTCHEN WirdGewinnen(BELEGUNG s){ //checkt, ob BELEGUNG s im nächsten Zug gewinnen kann
        int a=0;
        int wo=0;
        for (int i=0;i<8;i=i+1){
            for(int j=0;j<3;j=j+1){
                if(Gewinnbedingung[i][j].belegtGeben().equals(s)){
                    a=a+1;
                    wo=i;
                }
                if(a==2){
                    for(int b=0;b<3;b=b+1){
                        if(Gewinnbedingung[wo][b].belegtGeben().equals(s)==false){
                            return Gewinnbedingung[wo][b];
                        }
                    }
                }
            }
            a=0;
        }
        return null;
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

