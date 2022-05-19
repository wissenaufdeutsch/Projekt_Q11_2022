
public class KÄSTCHEN
{
    String belegt;
    KÄSTCHEN(){
        belegt=null; //null:nicht belegt, "Kreuz": Kreuz, "Kreis": Kreis
    }

    void Belegen(String s){
        if(belegt!=null){
            belegt=s; 
        } else {
            System.out.println("Schon belegt!");
        }
    }

    String belegtGeben(){
        return belegt;
    }
}

