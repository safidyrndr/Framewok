package etu2037.framework.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etu1984.framework.Mapping;

public class FrontServlet extends HttpServlet{

    HashMap<String,Mapping> mappingUrls;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        PrintWriter out = resp.getWriter();
        String requete = req.getRequestURI();
        String values = req.getQueryString();
        String[] infoReq = requete.split("/"); 
        out.println("Page: " + infoReq[2]);
        out.println("Les donnees sont:");
        String[] vals = values.split("&&");
        for (String val : vals) {
           out.println(val); 
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}