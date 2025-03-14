# language: es

Característica: Consumo con serenity-rest del verbo DELETE

  Esquema del escenario: Eliminar una mascota
    Dado se tiene creada a una mascota con el recurso "<recurso>" nombre "<nombre>" y estado "<estado>"
    Cuando configura la peticion a consumir con el recurso "<recurso>" y el id de la mascota creada
    Entonces valida el estado de dicha peticion
    Ejemplos:
    |recurso|nombre|estado   |
    |pet    |doggie |available|