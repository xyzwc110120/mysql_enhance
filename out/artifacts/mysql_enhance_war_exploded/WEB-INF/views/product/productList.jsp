<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/mysql/product" method="post">
        <label>
            商品名称：<input type="text" name="name" value="${query.name}">
        </label>
        <label>
            价格区间：
            <input type="number" name="minPrice" value="${query.minPrice}"> - <input type="number" name="maxPrice" value="${query.maxPrice}">
        </label>
        <label>商品类型：
            <select name="type">
                <option value="">- 全部 -</option>
                <c:forEach items="${productTypes}" var="type" >
                    <option value="${type.id}" <c:if test="${type.id eq query.type}">selected</c:if>>${type.name}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            关键字：
            <input type="text" name="keyword" value="${query.keyword}">
        </label>

        <input type="submit" name="提交">
    </form>

    <table border="1" width="80%" cellpadding="0" cellspacing="0">
        <tr>
            <th>商品名称</th>
            <th>商品品牌</th>
            <th>商品进价</th>
            <th>商品原价</th>
            <th>商品现价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${products}" var="product" varStatus="status">
            <tr <c:if test="${status.count % 2 == 0}">style="background-color: aquamarine" </c:if>>
                <td>${product.name}</td>
                <td>${product.productTypeId}</td>
                <td>${product.brand}</td>
                <td>${product.purchasingPrice}</td>
                <td>${product.originalPrice}</td>
                <td>${product.currentPrice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>