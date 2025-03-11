# language: es

Característica: Consumo con serenity-rest del verbo GET

  Escenario: Crear una mascota y luego obtener su información
    Dado se tiene creada una mascota
    Cuando configura la peticion a consumir con el recurso "/pet/{petId}" y el id almacenado
    Entonces valida el nombre de la mascota
