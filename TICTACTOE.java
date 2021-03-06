
public class TICTACTOE implements TTTCONSTANTS
{
    TTTVIEW v;
    TTTMODEL m;
    private KÄSTCHEN[][] Gewinnbedingung;
    MODUS Spielmodus;
    int Spieler_PC;

    TICTACTOE(){
        v=new TTTVIEW(){
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
            Spielende();
        }else if(Spieler_PC==1){
            if(m.ZugAlleine(x,y,BELEGUNG.KREIS)==true){
                if(Spielende()==false){
                    NPC_Zug();
                }
            }else{
                v.Fehlermeldung();  
            }
        } else {
            if(m.ZugAlleine(x,y,BELEGUNG.KREUZ)==true){
                if(Spielende()==false){
                    NPC_Zug();
                }
            }else{
                v.Fehlermeldung();
            }
        }
    }

    public void SpielerWechseln(){//wechselt den Spieler des PCs 
        if (Spieler_PC==2){
            Spieler_PC=1;
            NPC_Zug();
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
        } else if(Spielmodus==MODUS.PC){
            Spielmodus=MODUS.RANDOM;
        }else {
            Spielmodus=MODUS.PLAYER;
        }

    }

    public void Reset(){
        m.Reset();
        GewinnbedingungReset();
    }

    private void NPC_Zug(){
        if(Spielmodus==MODUS.PC){
            ZugComputer();
        } else if(Spielmodus==MODUS.RANDOM){
            RandomZug();
        }
    }

    private void RandomZug(){
        if(Spieler_PC==1){
            ZufaelligesFeld().Belegen(BELEGUNG.KREUZ);            
        } else {
            ZufaelligesFeld().Belegen(BELEGUNG.KREIS);
        }
    }

    private KÄSTCHEN ZufaelligesFeld(){
        while (true){
            KÄSTCHEN k=m.FeldGeben((int) Math.round(Math.random()*2), (int) Math.round(Math.random()*2));
            if(k.IstLeer()){
                return k;
            }
        }
    }

    private void ZugComputer(){
        if(Spieler_PC==1){
            ZugPC(BELEGUNG.KREUZ);            
        } else {
            ZugPC(BELEGUNG.KREIS);
        }
    }

    private boolean Spielende(){
        BELEGUNG s=HatGewonnen();
        if (s.equals(BELEGUNG.UNBELEGT)==false){
            v.SiegerDarstellen(s);
            return true;
        } else if(IstUnentschieden()==true){
            v.UnentschiedenDarstellen();
            return true;
        }
        return false;
    }

    private void ZugPlayer(int x, int y){
        m.Zug(x,y);
    }

    private void ZugPC(BELEGUNG s){ //wer is PC
        KÄSTCHEN k=WirdGewinnen(s);
        KÄSTCHEN k0=WirdGewinnen(AndereBelegung(s));
        KÄSTCHEN k1=InEcke();
        KÄSTCHEN k2=AnRand();
        if(k!=null && k.IstLeer()){
            k.Belegen(s); 
        } else if(k0!=null && k0.IstLeer()){
            k0.Belegen(s);
        }else if(Spezialfall(s)==false){
            if(m.FeldGeben(1,1).IstLeer()){
                m.FeldGeben(1,1).Belegen(s);
            } else if(k1!= null){
                k1.Belegen(s);
            } else if(k2!=null){
                k2.Belegen(s);
            } 
        }     
    }

    private boolean Spezialfall(BELEGUNG s){
        for (int i=6;i<8;i=i+1){
            if(Gewinnbedingung[i][0].IstBelegt() && Gewinnbedingung[i][1].IstBelegt() && Gewinnbedingung[i][2].IstBelegt()){
                if(Gewinnbedingung[i][0].belegtGeben().equals(Gewinnbedingung[i][2].belegtGeben()) && Gewinnbedingung[i][1].belegtGeben().equals(Gewinnbedingung[i][2].belegtGeben())==false){
                    AnRand().Belegen(s);
                    return true; 
                }
            }
        }
        return false;
    }

    private BELEGUNG AndereBelegung(BELEGUNG s){
        if(s==BELEGUNG.KREIS){
            return BELEGUNG.KREUZ;
        }else {
            return BELEGUNG.KREIS;
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
            if(m.FeldGeben(i,1).IstLeer()){
                return m.FeldGeben(i,1);
            }
            if(m.FeldGeben(1,i).IstLeer()){
                return m.FeldGeben(1,i);
            }
        }
        return null;
    }

    private KÄSTCHEN InEcke(){
        for(int i=0;i<3;i=i+2){
            for(int j=0;j<3;j=j+2){
                if(m.FeldGeben(i,j).IstLeer()){
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
                        if(Gewinnbedingung[wo][b].belegtGeben().equals(s)==false && Gewinnbedingung[wo][b].IstLeer()){
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
                if(k[i][j].IstLeer())
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
        if (k1.belegtGeben().equals(k2.belegtGeben()) && k1.belegtGeben().equals(k3.belegtGeben()) && k1.IstBelegt()){
            return k1.belegtGeben();
        } else {
            return BELEGUNG.UNBELEGT; 
        }
    }

}

