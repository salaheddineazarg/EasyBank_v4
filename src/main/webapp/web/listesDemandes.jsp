<%--
  Created by IntelliJ IDEA.
  User: alaae
  Date: 27/10/2023
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/CostumeCss.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Marcellus+SC&family=Montserrat:ital,wght@0,100;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,300;0,400;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="overflow-y-hidden">
<jsp:include page="../component/navBar.jsp"/>
<h2>Liste des demandes de crédit</h2>
<div class="w-full">
    <table class="min-w-full divide-y divide-gray-200">
        <thead class="bg-gray-50">
        <tr>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Montant
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Duree
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Mensualite
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Client
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Etat
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Operation
            </th>
        </tr>
        </thead>
        <tbody class="bg-white divide-y divide-gray-200">
        <c:forEach var="demande" items="${demandes}">
            <tr>
                <td class="px-6 py-4 whitespace-nowrap">
                        ${demande.montant}
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                        ${demande.dure}
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                        ${demande.mensualite}
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                        ${demande.client.nom}
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                        ${demande.etat}
                </td>
                <c:if test="${demande.etat eq 'EnAttente'}">
                    <td class="px-6 py-4 whitespace-nowrap">
                        <a href="/accepter_demande?id=${demande.id}" class="text-green-600 hover:text-green-900">
                            <i class="fa-sharp fa-solid fa-circle-check fa-beat" style="color: #46d312;"></i>
                        </a>
                        <a href="/rejeter_demande?id=${demande.id}" class="text-red-600 hover:text-red-900">
                            <i class="fa-solid fa-circle-xmark fa-beat" style="color: #e91c1c;"></i>
                        </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--<table>--%>
<%--<tr>--%>
<%--&lt;%&ndash;    <th>ID</th>&ndash;%&gt;--%>
<%--    <th>Montant</th>--%>
<%--    <th>Duree</th>--%>
<%--    <th>Mensualite</th>--%>
<%--    <th>Client</th>--%>
<%--    <th>Etat</th>--%>
<%--    <th>Operation</th>--%>

<%--</tr><c:forEach var="demande" items="${demandes}">--%>
<%--<tr>--%>

<%--&lt;%&ndash;   // <td >${demande.id}</td>&ndash;%&gt;--%>
<%--    <td >${demande.montant}</td>--%>
<%--    <td >${demande.dure}</td>--%>
<%--    <td >${demande.mensualite}</td>--%>
<%--    <td >${demande.client.nom}</td>--%>
<%--    <td >${demande.etat}</td>--%>
<%--    <c:if test="${demande.etat eq 'EnAttente'}">--%>


<%--    <td>--%>
<%--        <a href="/accepter_demande?id=${demande.id}">--%>
<%--            <i class="fa-sharp fa-solid fa-circle-check fa-beat" style="color: #46d312;"></i>--%>
<%--    </a>--%>
<%--        <a href="/rejeter_demande?id=${demande.id}">--%>
<%--            <i class="fa-solid fa-circle-xmark fa-beat" style="color: #e91c1c;"></i>--%>
<%--        </a>--%>
<%--    </td>--%>
<%--    </c:if>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--    </table>--%>
    </body>
    </html>
