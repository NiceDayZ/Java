<%@ page import="com.business.model.Record" %>
<%@ page import="com.business.service.RecordService" %>
<%@ page import="com.business.util.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Records</title>
</head>
<body>
    <table>
        <tr>
            <th>Movie Name</th>
            <th>Director</th>
            <th>Category</th>
        </tr>
        <tbody>
            <%
                RecordService recordService = new RecordService();

                List<Record> recordList;
                Category category = null;
                String cat = request.getParameter("category");

                if(cat == null){
                    for(Cookie cookie: request.getCookies()){
                        if(cookie.getName().equalsIgnoreCase("category")){
                            cat = cookie.getValue();
                        }
                    }
                }

                if(cat == null){
                    recordList = recordService.getRecords();
                }else{
                    category = Category.fromString(cat);

                    if(category != null){
                        recordList = recordService.getRecords(category);
                        response.addCookie(new Cookie("category", category.getCategory()));
                    }else{
                        recordList = recordService.getRecords();
                    }

                }

                for(Record record: recordList){
                    out.println("<tr>");
                    out.println("<td>" + record.getValue() + "</td>");
                    out.println("<td>" + record.getKey() + "</td>");
                    out.println("<td>" + record.getCategory().getCategory() + "</td>");
                    out.println("</tr>");
                }
            %>
        </tbody>
    </table>
</body>
</html>
