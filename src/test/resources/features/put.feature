# language: es

Característica: Consumo con serenity-rest del verbo PUT

  Esquema del escenario: Escenario: Crear una mascota y luego obtener su información
    Dado se tiene creada una mascota
    Cuando configura la peticion a consumir el recurso "<recurso>" con el nombre "<nombre>" actualizado
    Entonces valida el nombre de la mascota en la respuesta
    Ejemplos:
    |recurso|nombre  |
    |pet    |Firulais|