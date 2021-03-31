<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form name="frmCadAnimal" action="CadAnimal" method="POST">
            
            <label for="Nome">Nome</label>
            <input type="text" name="Nome" value="" size="50" />
            
            <label for="Idade">Idade</label>
            <input type="text" name="Idade" value="" size="20" />
            
            <label for="Dono">Dono</label>
            <input type="text" name="Dono" value="" size="50" />
            
            
            <input type="submit" value="Salvar" />
            
        </form>
        
    </body>
</html>
