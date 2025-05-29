package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ServletProdutoFC extends HttpServlet {

    @EJB
    ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "ProdutoLista.jsp";

        if (acao != null) {
            switch (acao) {
                case "listar":
                    request.setAttribute("produtos", facade.findAll());
                    break;
                case "formIncluir":
                    destino = "ProdutoDados.jsp";
                    request.setAttribute("acao", "incluir");
                    break;
                case "incluir":
                    Produto novo = new Produto();
                    novo.setNome(request.getParameter("nome"));
                    novo.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                    novo.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));
                    facade.create(novo);
                    request.setAttribute("produtos", facade.findAll());
                    break;
                case "formAlterar":
                    Produto pAlt = facade.find(Integer.parseInt(request.getParameter("id")));
                    destino = "ProdutoDados.jsp";
                    request.setAttribute("produto", pAlt);
                    request.setAttribute("acao", "alterar");
                    break;
                case "alterar":
                    Produto alt = facade.find(Integer.parseInt(request.getParameter("id")));
                    alt.setNome(request.getParameter("nome"));
                    alt.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                    alt.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));
                    facade.edit(alt);
                    request.setAttribute("produtos", facade.findAll());
                    break;
                case "excluir":
                    Produto exc = facade.find(Integer.parseInt(request.getParameter("id")));
                    facade.remove(exc);
                    request.setAttribute("produtos", facade.findAll());
                    break;
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
