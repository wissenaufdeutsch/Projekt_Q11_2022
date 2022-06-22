
public class TTTMODEL implements TTTCONSTANTS
{
    private KÄSTCHEN[][] spielfeld;
    int SpielerAmZug;

    TTTMODEL()
    {
        spielfeld=new KÄSTCHEN[3][3];
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
        SpielerAmZug=1; //1:Spieler 1 (Kreuz); 2: Spieler 2 (Kreis)  

    }

    void Zug(int x, int y)
    {
        if(SpielerAmZug==1){
            if(spielfeld[x][y].Belegen(BELEGUNG.KREUZ)==true){
                SpielerAmZug=2;
            }
        } else if (spielfeld[x][y].Belegen(BELEGUNG.KREIS)==true){
            SpielerAmZug=1;
        }

    } 
    
    void ZugAlleine(int x, int y, BELEGUNG s){
        spielfeld[x][y].Belegen(s);
    }


    void Reset(){
        SpielerAmZug=1;
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
    }

    int SpielerAmZugGeben()
    {
        return SpielerAmZug;
    }

    KÄSTCHEN FeldGeben(int x, int y)
    {
        return spielfeld[x][y]; 
        
    }   

    KÄSTCHEN[][]SpielfeldGeben(){

        return spielfeld;

    }


    } 

