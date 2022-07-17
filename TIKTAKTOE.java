
/**
 * Beschreiben Sie hier die Klasse TIKTAKTOE.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TIKTAKTOE
{
    int []besetzt;

    public TIKTAKTOE()
    {
        besetzt = new int[9];
    }

    int updated(int where, boolean who){
        if (who){
            besetzt[where-1] = 1;
        }
        else{
            besetzt[where-1] = 2;
        }
        int whowon = whow();

        return whowon;
    }

    int whow(){
        int whowon = 0;
        for(int i= 0; i<3; i++){
            if(besetzt[0+i*3] == 1 &&besetzt[1+i*3] == 1 &&besetzt[2+i*3] ==1){
                whowon = 1;
            }
            if(besetzt[0+i*3] == 2 &&besetzt[1+i*3] == 2 &&besetzt[2+i*3] ==2){
                whowon = 2;
            }
            if(besetzt[0+i] == 1 &&besetzt[3+i] == 1 &&besetzt[6+i] ==1){
                whowon = 1;
            }
            if(besetzt[0+i] == 2 &&besetzt[3+i] == 2 &&besetzt[6+i] ==2){
                whowon = 2;
            }

        }
        if (besetzt[0] == 1 && besetzt[4] == 1 && besetzt[8] == 1){
            whowon = 1;
        } 
        if (besetzt[0] == 2 && besetzt[4] == 2 && besetzt[8] == 2){
            whowon = 2;
        } 
        if (besetzt[6] == 1 && besetzt[4] == 1 && besetzt[2] == 1){
            whowon = 1;
        } 
        if (besetzt[6] == 2 && besetzt[4] == 2 && besetzt[2] == 2){
            whowon = 2;
        } 
        return whowon;
    }
}
