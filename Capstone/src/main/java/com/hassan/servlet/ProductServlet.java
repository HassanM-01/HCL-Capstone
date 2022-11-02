package com.hassan.servlet;

import com.hassan.dao.ProductDAO;
import com.hassan.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    public void init(){
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/update":
                    System.out.println("not configured");
                    break;
                default:
                    listProduct(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listProduct = productDAO.selectProductList();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }


}
