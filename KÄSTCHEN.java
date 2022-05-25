
public class KÄSTCHEN
{
    String belegt;
    KÄSTCHEN(){
        belegt="unbelegt"; //"unbelegt"/"Kreuz"/"Kreis"
    }

    void Belegen(String s){
        if(belegt=="unbelegt"){
            belegt=s; 
        } else {
            System.out.println("Schon belegt!");
        }
    }

    String belegtGeben(){
        return belegt;
    }
}

