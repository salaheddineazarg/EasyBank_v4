<%--
  Created by IntelliJ IDEA.
  User: YC£
  Date: 18/10/2023
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/CostumeCss.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Marcellus+SC&family=Montserrat:ital,wght@0,100;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,300;0,400;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="overflow-y-hidden">
<jsp:include page="../component/navBar.jsp" />

<section class="w-full bg-blue-50 h-[100vh] padding-20">
    <div class="d-flex-col mx-auto mt-10 h-auto bg-white w-[70%] border-2 border-blue-400 rounded-md">
    <div class=" d-flex ">
    <div class="w-[50%] border-b  border-r-2 p-5 d-flex-col gap-5 p-4 border-gray-300 h-[200px]">
    <label class="text-xl text-lime-700 font-poppins">Montant(en DH)</label>
        <input id="display-value"  value="5000 DH"   class="border-none w-[100px] rounded-md shadow-inner inset-2 p-1 text-base font-bold text-blue-600 " readonly type="text">
        <input id="default-range" type="range" min="5000" max="600000" onmousemove="switchValue(value)" value="5000" class="w-full h-1 bg-gray-200 rounded-lg appearance-none cursor-pointer dark:bg-gray-700">
        <p class="font-normal text-sm text-gray-600">Min 5000 DH - Max 600000 DH</p>
    </div>
   <div class="w-[50%] border-b  p-5 d-flex-col gap-5 p-4 border-gray-300 h-[200px]">
       <label class="text-xl text-lime-700 font-poppins">Duée (en mois)</label>
       <input id="displayMounth"  value="12"   class="border-none w-[70px] rounded-md shadow-inner inset-2 p-1 text-base font-bold text-blue-600 " readonly type="text">
       <input id="defaultMounth" type="range" step="6" min="12" max="120" onmousemove="switchValue(value)" value="12" class="w-full h-1 bg-gray-200 rounded-lg appearance-none cursor-pointer dark:bg-gray-700">
       <p class="font-normal text-sm text-gray-600">Min 12 mois - Max 120 mois</p>
   </div>
    </div>
    <div class="w-full   d-flex justify-around items-center h-[66px] border-b border-blue-100">
        <div class="d-flex gap-4">
     <p class="text-md font-bold font-poppins text-lime-700">
         Expected monthly payment :
     </p>
      <input id="totalInput" type="text" value="salah" class="border-none w-[100px] rounded-md shadow-inner inset-2 p-1 text-base font-bold text-blue-600 " >

        </div>


       <button class=" w-[100px] shadow-2xl h-[42px] rounded-full  text-white bg-blue-600">
           Next
       </button>
    </div>
    </div>
</section>

<section id="slideInfo" class="w-[300px] h-[98vh] position-absolute top-[13%] left-[78%] bg-white">
  <div class="w-full h-auto">
   <div class="w-full h-[40px] p-2 bg-gray-300 font-semibold ">
       Détails de mon crédit
   </div>
    <div class="w-[91%] pl-2 pt-1 border-b border-slate-300 d-flex  justify-between h-[34px]">
       <p class="text-md font-normal text-slate-600">Montant :</p>
       <span class="text-blue-600 font-semibold text-md  ">1000 Dh</span>
    </div>
  </div>

<span id="buttonSlide" onclick="displaySlide()" class="w-[50px] bg-blue position-absolute rotate-[181deg] top-[40%] left-[-9%] text-center h-[50px] rounded-full"><i class="fa-solid fa-arrow-right text-white mt-3 text-lg"></i></span>
</section>



<script src="../js/main.js"></script>
</body>
</html>
