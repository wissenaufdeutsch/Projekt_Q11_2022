
public class TICTACTOE
{
    KÄSTCHEN[][] spielfeld;

    TICTACTOE(){
        spielfeld=new KÄSTCHEN[3][3];
        for (int i=0;i<3;i=i+1){
            for (int j=0;j<3;j=j+1){
                spielfeld[i][j]=new KÄSTCHEN();
            }
        }
    }

    String HatGewonnen(){

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

    void FeldBelegen(KÄSTCHEN k1,String s){
        k1.Belegen(s);
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

    KÄSTCHEN[][] SpielfeldGeben(){
        return spielfeld; 
    }
}


