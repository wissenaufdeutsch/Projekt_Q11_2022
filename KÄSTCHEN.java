
public class KÄSTCHEN implements TTTCONSTANTS
{
    BELEGUNG belegt;
    KÄSTCHEN(){
        belegt=BELEGUNG.UNBELEGT; //"unbelegt"/"Kreuz"/"Kreis"
    }

    boolean Belegen(BELEGUNG s){
        if(belegt==BELEGUNG.UNBELEGT){
            belegt=s; 
            return true;
        } else {
            return false;
        }
    }
    
    BELEGUNG belegtGeben(){
        return belegt;
    }
}

