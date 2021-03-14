package mistyforest.justsketcher.kernel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UIDManager {
    public static String uidGen(){
        String s=System.currentTimeMillis()+"";
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ssMMmmddyyyy");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        res+= new Random().ints(4);
        return res;
    }
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
