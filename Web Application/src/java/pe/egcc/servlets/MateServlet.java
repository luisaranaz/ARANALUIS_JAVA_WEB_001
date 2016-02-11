/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import pe.egcc.service.MateService;

/**
 *
 * @author Luis Arana
 */
@WebServlet(name = "MateServlet", urlPatterns = {"/Suma", "/Resta", "/Multiplica", "/Divide"})
public class MateServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String path = request.getServletPath();
    if (path.equals("/Suma")) {
      suma(request, response);
    } else if (path.equals("/Resta")) {
      resta(request, response);
    } else if (path.equals("/Multiplica")) {
      multiplica(request, response);
    } else if (path.equals("/Divide")) {
      divide(request, response);    
    }
    }
private void suma(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
    // Variables
    double num1, num2, resultado;
    MateService mateService = new MateService();
    try {
        // Obtener Datos
        num1 = Double.parseDouble(request.getParameter("n1"));
        num2 = Double.parseDouble(request.getParameter("n2"));
        // Proceso
        resultado = mateService.sumar(num1, num2);

        //try {
            //Thread.currentThread().sleep(1000);
        //} catch (Exception e) {
        //}
     
        // Preparando la data
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("suma", resultado);
    }catch(java.lang.NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ingrese solo numeros");
          request.setAttribute("num1", 0);
          request.setAttribute("num2", 0);
          request.setAttribute("suma", 0);
    }
        // Haciendo un forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("sumaRpta.jsp");
        rd.forward(request, response);
        // Reporte alternativo
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        //out.println("<p>Num 1: " + num1 + "</p>");
        //out.println("<p>Num 2: " + num2 + "</p>");
        //out.println("<p>Suma: " + resultado + "</p>");
    
  }

  private void resta(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    // Variables
    double num1, num2, resultado;
    MateService mateService = new MateService();
    try {
    // Obtener Datos
    num1 = Double.parseDouble(request.getParameter("n1"));
    num2 = Double.parseDouble(request.getParameter("n2"));
    // Proceso
    resultado = mateService.restar(num1, num2);
    // Preparando la data
    request.setAttribute("num1", num1);
    request.setAttribute("num2", num2);
    request.setAttribute("resta", resultado);
    }catch(java.lang.NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ingrese solo numeros");
          request.setAttribute("num1", 0);
          request.setAttribute("num2", 0);
          request.setAttribute("resta", 0);
    }
    // Haciendo un forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("restaRpta.jsp");
    rd.forward(request, response);
  }

  private void multiplica(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    // Variables
    double num1, num2, resultado;
    MateService mateService = new MateService();
    try {
    // Obtener Datos
    num1 = Double.parseDouble(request.getParameter("n1"));
    num2 = Double.parseDouble(request.getParameter("n2"));
    // Proceso
    resultado = mateService.multiplicar(num1, num2);
    // Preparando la data
    request.setAttribute("num1", num1);
    request.setAttribute("num2", num2);
    request.setAttribute("multiplicacion", resultado);
    }catch(java.lang.NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ingrese solo numeros");
          request.setAttribute("num1", 0);
          request.setAttribute("num2", 0);
          request.setAttribute("multiplicacion", 0);
    }
    // Haciendo un forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("multiplicaRpta.jsp");
    rd.forward(request, response);
  }

  private void divide(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    // Variables
    double num1, num2, resultado;
    MateService mateService = new MateService();
    try {
    // Obtener Datos
    num1 = Double.parseDouble(request.getParameter("n1"));
    num2 = Double.parseDouble(request.getParameter("n2"));
    // Proceso
    if (num2!=0)
        resultado = mateService.dividir(num1, num2);
    else 
        resultado=0;
    // Preparando la data
    request.setAttribute("num1", num1);
    request.setAttribute("num2", num2);
    request.setAttribute("division", resultado);
    }catch(java.lang.NumberFormatException e){
          JOptionPane.showMessageDialog(null, "ingrese solo numeros");
          request.setAttribute("num1", 0);
          request.setAttribute("num2", 0);
          request.setAttribute("division", 0);
    }
    // Haciendo un forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("divideRpta.jsp");
    rd.forward(request, response);
  }

}
