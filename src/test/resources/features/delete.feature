# language: es

Característica: Consumo con serenity-rest del verbo DELETE

  Escenario: Eliminar una mascota
    Dado se tiene creada una mascota
    Cuando configura la peticion a consumir con el recurso "/pet/{petId}" y el id almacenado
    Entonces valida el estado de dicha peticion