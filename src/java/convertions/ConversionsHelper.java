package convertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConversionsHelper {

    /**
     * Conversion from decimal to binary
     *
     * @param num
     * @return
     */
    public String convertToBinary(int num) {
        String binary = Integer.toBinaryString(num);
        return binary;
    }

    /**
     * Conversion from decimal to hexadecimal
     *
     * @param num
     * @return
     */
    public String convertToHexa(int num) {
        String hexa = Integer.toHexString(num);
        return hexa;
    }

    /**
     * Method to get the current Time
     *
     * @return
     */
    public Date getTime() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date time;
            time = sdf.parse(sdf.format(new Date()));
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(ConversionsHelper.class.getName()).log(Level.SEVERE, null, ex); //logging the exception
        }
        return null;
    }

    /**
     * A String method for displaying in XML format
     *
     * @param result
     * @return
     */
    public String toXML(String result) {
        String toXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<response><code>200</code>"
                + "<result>" + result
                + "</result>"
                + "</response>";
        return toXML;
    }

    /**
     * A String method for displaying in JSON format
     *
     * @param result
     * @return
     */
    public String toJSON(String result) {
        String toJSON = "{\"code\":200,\"convertion\":{\"result:" + result + "}}";
        return toJSON;
    }

    /**
     * Method which takes the error as input an shows up on the screen when is
     * handled for XML format
     *
     * @param error
     * @return
     */
    public String ErrorToXML(String error) {
        String toXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<response><code>500</code>"
                + "<result>" + error + "</result>"
                + "</response>";
        return toXML;
    }

    /**
     * Handling error in JSON format
     *
     * @param error
     * @return
     */
    public String ErrorToJSON(String error) {
        String toJSON = "{\"code\":500,\"convertion\":{\"result:" + error + "}}";
        return toJSON;
    }
}
