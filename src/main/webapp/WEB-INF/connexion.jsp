
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
    
    <style>
    	h2 {
    		text-align: center;
    		margin-top: 5%;
    	}
    	p {
    		text-align: center;
    	}
		/* Style du formulaire */
		form {
		    max-width: 400px;
		    margin: 0 auto;
		    margin-top: 2%;
		}
		
		/* Style des champs de saisie */
		input[type="text"],
		input[type="password"],
		textarea,
		select {
		    width: 100%;
		    padding: 10px;
		    margin: 8px 0;
		    display: inline-block;
		    border: 1px solid #ccc;
		    box-sizing: border-box;
		}
		
		/* Style des boutons */
		button {
		    background-color: #4caf50;
		    color: white;
		    padding: 10px 15px;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		}
		
		button:hover {
		    background-color: #45a049;
		}
		
		/* Style des messages d'erreur */
		.error-message {
		    color: #ff0000;
		    margin-bottom: 10px;
		}
    </style>
    
</head>
<body>
	<% String messageRecu = (String) request.getAttribute("message"); %>
    <h2>Formulaire de Connexion</h2>
	<p class="error-message"> Message : <%= messageRecu %></p>
    <form method="post">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="login" required><br>

        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required><br>

        <button type="submit">Se connecter</button>
    </form>

</body>
</html>
