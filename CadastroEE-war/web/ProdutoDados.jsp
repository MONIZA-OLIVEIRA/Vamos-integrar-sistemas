<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cadastroee.model.Produto"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Produto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<% Produto p = (Produto) request.getAttribute("produto"); String acao = (String) request.getAttribute("acao"); if (acao == null) acao = "incluir"; %>
<form action="ServletProdutoFC" method="post" class="form">
    <input type="hidden" name="acao" value="<%= acao %>" />
    <% if (p != null) { %>
    <input type="hidden" name="id" value="<%= p.getId() %>" />
    <% } %>
    <div class="mb-3">
        <label class="form-label">Nome:</label>
        <input type="text" name="nome" class="form-control" value="<%= p != null ? p.getNome() : "" %>" />
    </div>
    <div class="mb-3">
        <label class="form-label">Quantidade:</label>
        <input type="number" name="quantidade" class="form-control" value="<%= p != null ? p.getQuantidade() : "" %>" />
    </div>
    <div class="mb-3">
        <label class="form-label">Preço de Venda:</label>
        <input type="text" name="precoVenda" class="form-control" value="<%= p != null ? p.getPrecoVenda() : "" %>" />
    </div>
    <button type="submit" class="btn btn-primary">Salvar</button>
</form>
</body>
</html>
