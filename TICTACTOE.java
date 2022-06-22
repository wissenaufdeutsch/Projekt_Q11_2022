
public class TICTACTOE implements TTTCONSTANTS
{
    TTTVIEW t;
    TTTMODEL m;
    private KÄSTCHEN[][] Gewinnbedingung;
    MODUS Spielmodus;
    int Spieler_PC;

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
        GewinnbedingungReset();
        Spielmodus=MODUS.PLAYER;
        Spieler_PC=1;
    }

    public void Zug(int x, int y){
        if (Spielmodus==MODUS.PLAYER){
            ZugPlayer(x,y);
        } else {
            ZugGegenPC(Spieler_PC,x,y);
        }

    }

    public void SpielerWechseln(){//wechselt den Spieler des PLAYERS (1 zu 2; 2 zu 1)
        if (Spieler_PC==1){
            Spieler_PC=2;
        } else {
            Spieler_PC=1;
        }

    }

    public void ModusWechseln(){
        if (Spielmodus==MODUS.PLAYER){
            Spielmodus=MODUS.PC;
        } else {
            Spielmodus=MODUS.PLAYER;
        }

    }

    public void Reset(){
        m.Reset();
        GewinnbedingungReset();
    }

    private void ZugGegenPC(int wer, int x, int y){ //wer willst du sein

        if(wer==1){
            m.ZugAlleine(x,y,BELEGUNG.KREUZ);
            ZugPC(BELEGUNG.KREIS);
        } else {
            ZugPC(BELEGUNG.KREUZ);
            m.ZugAlleine(x,y, BELEGUNG.KREIS);
        }
    }

    private void ZugPlayer(int x, int y){
        m.Zug(x,y);
        if (HatGewonnen().equals(BELEGUNG.UNBELEGT)==false){
            t.SiegerDarstellen(HatGewonnen());
        } else if(IstUnentschieden()==true){
            t.UnentschiedenDarstellen(); 
        }
    }

    private void ZugPC(BELEGUNG s){ //wer is PC
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
        if (HatGewonnen().equals(BELEGUNG.UNBELEGT)==false){
            t.SiegerDarstellen(HatGewonnen());
        } else if(IstUnentschieden()==true){
            t.UnentschiedenDarstellen(); 
        }
    }

    private void GewinnbedingungReset(){

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

    private KÄSTCHEN AnRand(){
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

    private KÄSTCHEN InEcke(){
        for(int i=0;i<3;i=i+2){
            for(int j=0;j<3;j=j+2){
                if(m.FeldGeben(i,j).belegtGeben().equals(BELEGUNG.UNBELEGT)){
                    return m.FeldGeben(i,j);
                }
            }
        }
        return null;
    }

    private KÄSTCHEN WirdGewinnen(BELEGUNG s){ //checkt, ob BELEGUNG s im nächsten Zug gewinnen kann
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

    private boolean IstUnentschieden(){
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

    private BELEGUNG HatGewonnen() //gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst "unbelegt"
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

    private BELEGUNG IstGleich(KÄSTCHEN k1,KÄSTCHEN k2, KÄSTCHEN k3){
        if (k1.belegtGeben().equals(k2.belegtGeben()) && k1.belegtGeben().equals(k3.belegtGeben()) && k1.belegtGeben().equals(BELEGUNG.UNBELEGT)==false){
            return k1.belegtGeben();
        } else {
            return BELEGUNG.UNBELEGT; 
        }
    }

}

