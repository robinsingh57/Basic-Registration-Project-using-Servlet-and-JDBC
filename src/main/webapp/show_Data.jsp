<!DOCTYPE html>
<%@page import="com.register.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
        thead{
        background-color: rgb(110, 110, 212) ;
        color: black;
        }

        tbody{
            background-color: yellow;
        }

        tfoot{
            background-color: grey;
        }

</style>
<body>
    <!-- Creating table -->
    <table border="">
        
        <!-- create Table Header -->
            <thead>
                <!-- create Row of Header -->
                <th>Id</th>
                <th>Name</th>
                <th>City</th>
                <th>Email</th>
                <th>Date of Enrollment</th>
                <th>Course</th>
            </thead>

            <!-- create Table Body -->
            <tbody align="center">
                <!-- create row in body -->
                <tr>
                
                <%Student stud =(Student)request.getAttribute("STUDENT"); %>
                
                    <td><%String id = stud.getId();out.print(id);%></td>
                    <td><%String name = stud.getName();out.print(name);%></td>
                    <td><%String city = stud.getCity(); out.print(city); %></td>
                    <td><%String email = stud.getEmail(); out.print(email); %></td>
                    <td><%Date doe = stud.getDoe(); out.print(doe); %></td>
                    <td>
                    <% String course = stud.getCourse(); out.print(course); %>
                    </td>
                </tr>

                
            </tbody>

            <tfoot align="center">
                <td colspan="7">@copywright All right reserved JTC.</td>

            </tfoot>
    </table>
</body>
</html>