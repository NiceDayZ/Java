<%@ page import="com.business.util.Category" %>
<%@ page import="java.util.Random" %>
<%@ page import="com.business.service.RecordService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Form</title>
</head>
<body>
    <form method="post">

        <input name="value" placeholder="Movie Name">
        <input name="key" placeholder="Director">
        <select name="category">
            <option hidden disabled selected value> -- select a category -- </option>
            <%
                for(Category category : Category.values()){
                    out.println("<option value=\"" + category.getCategory() +"\">"+ category.getCategory() +"</option>");
                }
            %>
        </select>
        <%
            Random rand = new Random();
            int rand1 = rand.nextInt(10);
            int rand2 = rand.nextInt(10);

            out.println("<input style=\"display: none;\" name=\"capchaAns\" value=\"" + (rand1+rand2) +"\">");
            out.println("<input name=\"capcha\" placeholder=\"" + rand1 + "+" + rand2 +"\">");
            out.println("<input type=\"submit\">");

            // when the form is submitted
            if ("POST".equalsIgnoreCase(request.getMethod())) {

            }
        %>
    </form>
    <form method="get" action="/record">
        <input type="submit" value="Record">
    </form>
</body>
</html>
