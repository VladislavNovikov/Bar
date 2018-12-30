<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Bar</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/animationAndStyle/styles/css.css">

</head>
<body>
<form method="post" action="SaveCocktail">

    <input type="text" placeholder="Введите название коктейля:" id="recipeName" name = "recipeName" size="25">

    <div>
        Кола: <input id="cola" name = "cola" type="range" min="0" max="100" step="10" value="0" >
        <div class="circle"></div>
    </div>
    <div>
        Водка: <input id="vodka" name = "vodka" type="range" min="0" max="100" step="10" value="0" >
        <div class="circle"></div>
    </div>
    <div>
        Виски: <input id="whisky" name="whisky" type="range" min="0" max="100" step="10" value="0"  >
        <div class="circle"></div>
    </div>
    <div>
        Пиво: <input id="beer" name="beer" type="range" min="0" max="100" step="10" value="0" >
        <div class="circle"></div>
    </div>
    <div>
        Джин: <input id="gin" name="gin" type="range" min="0" max="100" step="10" value="0" >
        <div class="circle"></div>
    </div>
    <div>
        Тоник: <input id="tonic" name="tonic" type="range" min="0" max="100" step="10" value="0" >
        <div class="circle"></div>
    </div>


    <div id="percent" >
        Процент алкоголя: 0%. Текущий объём коктейля: 0 мл.
    </div>


    <p><input type="submit" value="Сохранить">

        <input type="submit" form="getList" value="Перейти к списку напитков"></p>

</form>

<form id="getList" method="get" action="ShowCocktailsList"> </form>

<%
    if((request.getAttribute("success")) != null){
        %>
            <div id="status" >Ваш коктейль успешно добавлен в базу данных!</div>
        <%
    }
%>

<script>
    setTimeout(function () {
        document.getElementById("status").style.display = 'none';
    },2000)
</script>

<script src="animationAndStyle/scripts/script.js"></script>

</body>
</html>
