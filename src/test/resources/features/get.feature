# language: es

Característica: Consumo con serenity-rest del verbo GET

  Esquema del escenario: Crear una mascota y luego obtener su información
    Dado se tiene creada una mascota
    Cuando configura la peticion a consumir con el recurso "<recurso>" y el id almacenado
    Entonces valida el nombre de la mascota
    Ejemplos:
      |recurso       |
      |pet   |