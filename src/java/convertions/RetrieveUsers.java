package convertions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RetrieveUsers", urlPatterns = {"/RetrieveUsers"})
public class RetrieveUsers extends HttpServlet {

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
        response.setContentType("text/xml; charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            RestClient client = new RestClient();

            if (request.getMethod().equals("POST")) {

                /**
                 * HTTP error handling
                 */
                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatus());
                }

                /**
                 * Initializing the parameters that have been taken from the
                 * user inside the form
                 */
                String userID = request.getParameter("report");
                String formatType = request.getParameter("format");

                /**
                 * Storing the rest methods FindCustomerByID_XML &&
                 * FindCustomerByID_JSON into a string variable to show them up
                 * to the browser
                 */
                String allXML = client.FindCustomerByID_XML(String.class, userID);
                String allJSON = client.FindCustomerByID_JSON(String.class, userID);

                /**
                 * A check if the drop down menu value is either JSON or XML and
                 * print out the corresponding format
                 */
                if ("JSON".equals(formatType)) {
                    response.setContentType("text/json;charset=UTF-8");
                    out.println(allJSON);
                } else {
                    out.println(allXML);
                }
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
