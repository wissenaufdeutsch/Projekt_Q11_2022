
public class KÄSTCHEN implements TTTCONSTANTS
{
    BELEGUNG belegt;
    KÄSTCHEN(){
        belegt=BELEGUNG.UNBELEGT; //"unbelegt"/"Kreuz"/"Kreis"
    }

    boolean Belegen(BELEGUNG s){
        if(IstLeer()){
            belegt=s; 
            return true;
        } else {
            return false;
        }
    }
    
    boolean IstBelegt(){
        if(belegt==BELEGUNG.UNBELEGT){
            return false;
        }
        return true;
    }
    
    boolean IstLeer(){
        if(belegt==BELEGUNG.UNBELEGT){
            return true;
        }
        return false;
    }
    
    BELEGUNG belegtGeben(){
        return belegt;
    }
}

