
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
        } else {
            spielfeld[x][y].Belegen("Kreis");
        }
        
        if(HatGewonnen()!=null){
            //Sieger darstellen, bitte abändern
            System.out.println("Gewonnen hat Spieler "+ SpielerAmZug+"!");
        }

    }

    String HatGewonnen() //gibt den Sieger zurück: "Kreuz" bzw "Kreis; sonst null
    {

        if (IstGleich(spielfeld[0][0], spielfeld[1][0], spielfeld[2][0])!=null || IstGleich(spielfeld[0][0], spielfeld[0][1], spielfeld[0][2])!=null || IstGleich(spielfeld[0][0], spielfeld[1][1], spielfeld[2][2])!=null){
            return spielfeld[0][0].belegtGeben();
        }else if(IstGleich(spielfeld[1][0], spielfeld[1][1], spielfeld[1][2])!=null ||IstGleich(spielfeld[0][1], spielfeld[1][1], spielfeld[2][1])!=null || IstGleich(spielfeld[0][2], spielfeld[1][1], spielfeld[2][0])!=null){
            return spielfeld[1][1].belegtGeben();
        } else if(IstGleich(spielfeld[2][0], spielfeld[2][1], spielfeld[2][2])!=null || IstGleich(spielfeld[0][2], spielfeld[1][2], spielfeld[2][2])!=null){
            return spielfeld[2][2].belegtGeben();
        } else {
            return null;
        }   

    }

    
    String IstGleich(KÄSTCHEN k1,KÄSTCHEN k2, KÄSTCHEN k3){
        if (k1.belegtGeben().equals(k2.belegtGeben()) && k1.belegtGeben().equals(k3.belegtGeben()) && k1.belegtGeben()!=null){
            return k1.belegtGeben();
        } else {
            return null; 
        }
    }

    void Reset(){
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
    }
    
    int SpielerAmZugGeben(){
        return SpielerAmZug;
    }
    

    KÄSTCHEN[][] SpielfeldGeben(){
        return spielfeld; 
    }
}

