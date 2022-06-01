
public class TTTMODEL implements TTTCONSTANTS
{
    private KÄSTCHEN[][] spielfeld;
    int SpielerAmZug;

    TTTMODEL(){
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
<<<<<<< HEAD
            spielfeld[x][y].Belegen(BELEGUNG.KREUZ);
            SpielerAmZug=2;
        } else {
            spielfeld[x][y].Belegen(BELEGUNG.KREIS);
=======
            if(spielfeld[x][y].Belegen(BELEGUNG.KREUZ)==true){
                SpielerAmZug=2;
            }
        } else if (spielfeld[x][y].Belegen(BELEGUNG.KREIS)==true){
>>>>>>> 8f0e1bc4a719d07c453cd09237e1bbb533276b7c
            SpielerAmZug=1;
        }

    } 

    void Reset(){
        SpielerAmZug=1;
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
    }

    int SpielerAmZugGeben(){
        return SpielerAmZug;
    }

    KÄSTCHEN FeldGeben(int x, int y){
        return spielfeld[x][y]; 

    } 

<<<<<<< HEAD
   

=======
>>>>>>> 8f0e1bc4a719d07c453cd09237e1bbb533276b7c
    KÄSTCHEN[][]SpielfeldGeben(){
        return spielfeld;

    }

}
