package convertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Functions {

    /**
     * A method to convert a decimal number into Binary
     *
     * @param num
     * @return
     */
    public String convertToBinary(int num) {
        String binary = Integer.toBinaryString(num);
        return binary;
    }

    /**
     * A method to convert a decimal number into Hexadecimal
     *
     * @param num
     * @return
     */
    public String convertToHexa(int num) {
        String hexa = Integer.toHexString(num);
        return hexa;
    }

    /**
     * A method to get the current Time
     * @return
     */
    public Date getTime() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date time;
            time = sdf.parse(sdf.format(new Date()));
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex); //logging the exception
        }
        return null;
    }
    
    public String toXML(String result){
        String toXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                        "<response><code>200</code>"+
                        "<result>"+result+ 
                        "</result>"
                        +"</response>";
        return toXML;
    }
    
    public String toJSON(String result){
        String toJSON = "{\"code\":200,\"convertion\":{\"result:" + result + "}}";
        
        return toJSON;
    }
}
