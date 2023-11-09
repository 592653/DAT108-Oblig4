<%@ page import = "no.hvl.dat108.Deltager" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltagerliste</title>
</head>
<body> 
    <p>Logged in as: ${currentFornavn} ${currentEtternavn} / ${currentMobil}</p>
        <h2>Deltagerlist</h2>
        <table>
            <tr>
                <th>Kjonn</th>
                <th align="left">Navn</th>
                <th align="left">Mobil</th>
            </tr>
            
            <% for (Deltager deltager : (Iterable <Deltager>)request.getAttribute("AlleBrukere")) { %>
                
                <tr style="<%= deltager.getMobil().equals((String) request.getAttribute("currentMobil")) ? "background-color:#aaffaa;" : ""%> ">
                    
                    <td align="center">
                        <% if (deltager.getKjonn().equals("Kvinne")) { %>
                            &#9792;
                        <% } else { %>
                            &#9794;
                        <% } %>
                    </td>
                    
                    <td><%= deltager.getFornavn() %> <%= deltager.getEtternavn() %></td>
                    <td><%= deltager.getMobil() %></td>
                </tr>
                
            <% } %>
        </table>
        <br>
        <form method="post">
	      <button type="submit">Logg ut</button> 
	</form>
</body>
</html>