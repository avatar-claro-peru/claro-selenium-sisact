@web
Feature: Se registrara un usuario para Claro

  Scenario: Registro Usuario
    Given el usuario ingreso a la pagina "https://clarowc8-demo.avatar-global.com:8042/tienda/es/claro/"
 		And ingresa a la seccion registro
    Then rellenar los datos para el registro datos personales
      | Hamir | Casas | Diaz | DNI | 70655821 | 952571022 | 952571022 |
    And rellenar los datos de la cuenta
      | hamir18@gmail.com | avatar2019 | avatar2019 |
    Then terminar el registro del usuario
    Then validar el nombre de usuario "Hamir"
    And visualizar detalle de la cuenta
    | Hamir | Casas | Diaz | DNI | 70655820 | 952571022 | 952571022 | hamir718@gmail.com | avatar2019 | avatar2019 |