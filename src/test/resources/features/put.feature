# language: es

Característica: Consumo con serenity-rest del verbo PUT

  Esquema del escenario: Actualizar una mascota y luego obtener su información
    Dado se tiene una mascota creada con el recurso "<recurso>" nombre "<nombre>" y estado "<estado>"
    Cuando configura la peticion a consumir el recurso "<recurso>" con el nombre "<nuevo_nombre>" actualizado
    Entonces valida el nombre de la mascota en la respuesta
    Ejemplos:
    |recurso|nombre|nuevo_nombre  |estado   |
    |pet    |doggie|Firulais      |available|