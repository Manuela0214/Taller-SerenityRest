# language: es

Característica: Consumo con serenity-rest del verbo POST

  Esquema del escenario: Crear una mascota
    Dado un usuario obtiene la baseurl de la api
    Cuando envia una solicitud POST para consumir el recurso "<recurso>"
    Entonces valida el cuerpo de la peticion con un campo name con el nombre "<nombre>"
    Ejemplos:
    |recurso|nombre|
    |pet   |doggie|