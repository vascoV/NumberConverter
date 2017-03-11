package convertions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Convertions", urlPatterns = {"/Convertions"})
public class Convertions extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String result = null;
            Date date = new Date();

            Functions func = new Functions();
            RestClient client = new RestClient();
            Convertionservices service = new Convertionservices();

            if (request.getMethod().equals("POST")) {

                /**
                 * Initializing the parameters that have been taken from the
                 * user inside the form
                 */
                String decimal = request.getParameter("decimal");
                String serviceRequest = request.getParameter("services");
                String userID = request.getParameter("userID");
                String formatChoose = request.getParameter("radioFormat");
               
                try{
                    int id = Integer.parseInt(userID);
                    int dec = Integer.parseInt(decimal);
                    
                } catch(NumberFormatException ex){
                    if ("JSON".equals(formatChoose)) {
                        response.setContentType("text/json;charset=UTF-8");
                        out.println(func.ErrorToJSON("Unsupported input Type"));
                    } else {
                        out.println(func.ErrorToXML("Unsupported input Type"));
                    }
                    return;
                }

                /**
                 * Parse the UserID and the decimal input into integer. So they
                 * will always be a number
                 */
                int translateUserID = Integer.parseInt(userID);
                int int_From = Integer.parseInt(decimal);
                
                /**
                 * Check if the drop down menu is either hexa or binary and do
                 * the corresponding methods
                 */
                if ("hexa".equals(serviceRequest)) {
                    result = func.convertToHexa(int_From);
                    service.setResult(result);
                } else {
                    result = func.convertToBinary(int_From);
                    service.setResult(result);
                }

                /**
                 * Check if the response in either XML or JSON for the API
                 */
                if ("JSON".equals(formatChoose)) {
                    response.setContentType("text/json;charset=UTF-8");
                    out.println(func.toJSON(result));
                } else {
                    out.println(func.toXML(result));
                }

                /**
                 * Setting up the user details and store it to the database.
                 */
                service.setId((long) 0);
                service.setCustomerid(translateUserID);
                service.setConvertionservice(serviceRequest);
                service.setSubmittednum(int_From);
                service.setDate(date);
                service.setTime(func.getTime());
                client.create_XML(service);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
