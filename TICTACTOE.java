
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

            public void Fehlermeldung()
            {
                System.out.println("Fehler!"); 
            }
        };
        m=new TTTMODEL();
        Gewinnbedingung= new KÄSTCHEN[8][3];
        GewinnbedingungReset();
        Spielmodus=MODUS.PLAYER;
        Spieler_PC=2;
    }

    public void Zug(int x, int y){
        if (Spielmodus==MODUS.PLAYER){
            ZugPlayer(x,y);
        } else if(Spieler_PC==1){
            if(m.ZugAlleine(x,y,BELEGUNG.KREIS)==true){;
                Spielende();
                ZugComputer();
            }else{
                t.Fehlermeldung();  
            }
        } else {
            if(m.ZugAlleine(x,y,BELEGUNG.KREUZ)==true){
                Spielende();
                ZugComputer();
            }else{
                t.Fehlermeldung();
            }
        }
    }

    public void SpielerWechseln(){//wechselt den Spieler des PCs 
        if (Spieler_PC==2){
            Spieler_PC=1;
            ZugComputer();
            m.SpielerAmZugSetzen(2);
        } else {
            Spieler_PC=2;
            Reset();
        }

    }

    public void ModusWechseln(){
        Reset();
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

    private void ZugComputer(){
        if(Spieler_PC==1){
            ZugPC(BELEGUNG.KREUZ);            
        } else {
            ZugPC(BELEGUNG.KREIS);
        }
    }

    private void Spielende(){
        BELEGUNG s=HatGewonnen();
        if (s.equals(BELEGUNG.UNBELEGT)==false){
            t.SiegerDarstellen(s);
        } else if(IstUnentschieden()==true){
            t.UnentschiedenDarstellen(); 
        }
    }

    private void ZugPlayer(int x, int y){
        m.Zug(x,y);
        Spielende();
    }

    private void ZugPC(BELEGUNG s){ //wer is PC
        KÄSTCHEN k=WirdGewinnen(s);
        BELEGUNG s1;
        if(s==BELEGUNG.KREIS){
            s1=BELEGUNG.KREUZ;
        }else {
            s1=BELEGUNG.KREIS;
        }
        KÄSTCHEN k0=WirdGewinnen(s1);
        KÄSTCHEN k1=InEcke();
        KÄSTCHEN k2=AnRand();
        if(k!=null && k.belegtGeben().equals(BELEGUNG.UNBELEGT)){
            k.Belegen(s); 
        } else if(k0!=null && k0.belegtGeben().equals(BELEGUNG.UNBELEGT)){
            k0.Belegen(s);
        }else if(m.FeldGeben(1,1).belegtGeben().equals(BELEGUNG.UNBELEGT)){
            m.FeldGeben(1,1).Belegen(s);
        } else if(k1!= null){
            k1.Belegen(s);
        } else if(k2!=null){
            k2.Belegen(s);
        } 
        Spielende();
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

        int c=6;
        for (int i=0;i>-3;i=i-2){
            Gewinnbedingung[c][0]=m.FeldGeben(Math.abs(i),0);
            Gewinnbedingung[c][1]=m.FeldGeben(1,1);
            Gewinnbedingung[c][2]=m.FeldGeben(i+2,2);
            c=c+1;
        }

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

    private BELEGUNG HatGewonnen()//gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst "unbelegt"
    {
        for (int i=0;i<8;i=i+1){
            if(IstGleich(Gewinnbedingung[i][0],Gewinnbedingung[i][1],Gewinnbedingung[i][2]).equals(BELEGUNG.UNBELEGT)==false){
                return Gewinnbedingung[i][0].belegtGeben();
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

