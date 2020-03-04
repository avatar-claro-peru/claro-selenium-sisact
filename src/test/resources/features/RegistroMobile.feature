@Mobile
Feature: Se registrara un usuario para Claro

  Scenario: Registro Usuario
    Given el usuario ingreso a la pagina "https://clarowc8-demo.avatar-global.com:8042/tienda/es/claro/"
    And ingresa a la seccion registro mobile
    Then rellenar los datos para el registro datos personales mobile
      | Hamir | Casas | Diaz | DNI | 70655821 | 952571022 | 952571022 |
    