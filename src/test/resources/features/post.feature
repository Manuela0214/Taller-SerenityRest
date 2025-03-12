# language: es

Característica: Consumo con serenity-rest del verbo POST

  Esquema del escenario: Crear una mascota
    Dado un usuario obtiene la baseurl de la api
    Cuando envia una solicitud POST para consumir el recurso "<recurso>" con el nombre "<nombre>" y el estado "<estado>"
    Entonces valida el estado de dicha petición
    Ejemplos:
      |recurso|nombre|estado|
      |pet    |Romeo |available|