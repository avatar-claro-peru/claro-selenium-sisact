@web

Feature: Iniciar sesion en Sisac Avatar 
	Como usuario Avatar quiero loguearme para realizar unas pruebas automatizadas
	
	Scenario: Buscar cliente
		Given el usuario ingreso a la pagina "http://localhost:8080/sisactAvatar/login.htm"
 		When ingresa credenciales en login
 			| administrador | admin |
 		And hace clic en boton ingresar
 		And selecciona la opcion Clientes
 		And ingresa dni del cliente
 			| 474984822 |
 		And hace clic en boton buscar
 		Then se realiza la operacion correctamente
 		
 	Scenario: Registrar cliente
 		Given hace clic en boton Agregar Cliente
 		And rellena el formulario de cliente
 			| miguel llamocca | 47498481 | mllamocca@avatar-global.com |
 		And hace clic en boton Guardar
 		And confirmar registro
 		Then Se guardo
