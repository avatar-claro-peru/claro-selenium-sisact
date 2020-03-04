@web

Feature: Iniciar sesion en Tienda Prepago Claro 
	Como usuario Claro quiero loguearme para realizar compras en Tienda Prepago Claro
	
	Scenario: Login con datos incorrectos
		Given el usuario ingreso a la pagina "https://tienda.claro.com.pe/tienda/es/claro"
 		And ingresa a la seccion login
 		When rellena el formulario de login
 			| carlos@avatar-global.com | Avatar123 |
 		And hace clic en boton inicia sesion
 		Then sistema muestra mensaje de error
	
	Scenario: Login con datos correctos
		Given el usuario ingreso a la pagina "https://tienda.claro.com.pe/tienda/es/claro"
 		And ingresa a la seccion login
 		When rellena el formulario de login
 			| eterrones@avatar-global.com | Avatar123 |
 		And hace clic en boton inicia sesion
 		Then el usuario se loguea correctamente
			