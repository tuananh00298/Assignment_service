/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Transaction;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TransactionJerseyClient;
import service.UserJerseyClient;

/**
 *
 * @author Tuan Anh
 */
public class NewPaymentServlet extends HttpServlet {

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
        String id = (String) request.getParameter("id");
        String partnerId = (String) request.getParameter("partnerId");
        String billId = (String) request.getParameter("billId");
        String accountId = (String) request.getParameter("accountId");
        String accountPin = (String) request.getParameter("accountPin");
        String transactionAmount = (String) request.getParameter("transactionAmount");
        String fee = (String) request.getParameter("fee");
        String receiveAmount = (String) request.getParameter("receiveAmount");
        String sendAmount = (String) request.getParameter("sendAmount");
        String transactionName = (String) request.getParameter("name");

        UserJerseyClient userClient = new UserJerseyClient();
        TransactionJerseyClient transactionClient = new TransactionJerseyClient();
        User u = (User) userClient.find_XML(User.class, id);
        User up = (User) userClient.find_XML(User.class, partnerId);
        Transaction t = new Transaction();
        t.setBillId(billId);
        t.setReceiveAmount(Integer.parseInt(receiveAmount));
        t.setReceiverId(Integer.parseInt(partnerId));
        t.setSendAmount(Integer.parseInt(sendAmount));
        t.setSenderId(Integer.parseInt(id));
        t.setTransactionAmount(Integer.parseInt(transactionAmount));
        t.setTransactionDate(new Date());
        t.setTransactionFee(Integer.parseInt(fee));
        t.setTransactionName(transactionName);
        transactionClient.create_XML(t);
        int uCurBal = u.getBalance();
        int upCurBal = up.getBalance();
        u.setBalance(uCurBal + Integer.parseInt(receiveAmount));
        up.setBalance(upCurBal - Integer.parseInt(sendAmount));
        userClient.edit_XML(u, id);
        userClient.edit_XML(up, partnerId);
        request.setAttribute("id", id);
        request.setAttribute("name", u.getName());
        request.getRequestDispatcher("/menu.jsp").forward(request, response);

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
