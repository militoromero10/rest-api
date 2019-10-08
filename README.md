# rest-api


- En todo caso, responde con un campo adicional indicando la ruta para acceder al objeto creado, modificado


# Ejemplo obtencion
    Trae todos los que hay en base
    1. url: localhost:8080/api/v1/person
    
    Trae un registro en especifico
    2. url: localhost:8080/api/v1/person/id
    
	- metodo: GET
	- respuesta: codigo 200 OK, En caso de no existir arroja NOT_FOUND 404, en otro caso BAD_REQUEST 400

# Ejemplo eliminacion
    Elimina un objeto persona
	- url: localhost:8080/api/v1/person/id
	- metodo: DELETE
	- respuesta: codigo 200 OK, En caso de no existir arroja NOT_FOUND 404, en otro caso BAD_REQUEST 400

# Ejemplo creacion
    Crea un objeto persona
    - url: localhost:8080/api/v1/person
    - metodo: POST
    - respuesta: Codigo CREATED 201 si la creacion salio bien
```
{
 "first_name": "Creado 1",
  "last_name": "Creado 1",
  "identification_number": 1234567890,
  "birth_date": "2019-10-08",
  "observation": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
  "email": "email1@email.com"
}
```
- Si incumple validaciones iniciales.
	La respuesta es un mensaje de 'Malformed Body' con codigo de respuesta BAD_REQUEST 400
	
# Ejemplo atualizacion
##Actualizacion de todo el objeto
    Trae todos los que hay en base
    - url: localhost:8080/api/v1/person
    - metodo: PUT
    - respuesta: codigo 200 OK
```
{
 "id": 2,
 "first_name": "Actualizado 1",
 "last_name": "Creado 1",
 "identification_number": 1234567890,
 "birth_date": "2019-10-08"
}
```
    - si incumple validaciones iniciales. 
	La respuesta es un mensaje de 'Malformed Body' con codigo de respuesta BAD_REQUEST 400
	
##Actualizacion parcial del objeto
    Actualiza solo los campos indicados
    - url: localhost:8080/api/v1/person
    - metodo: PATCH
    - respuesta: codigo 200 OK
```
{
  	"id": 2,
	"first_name": "PATCH 1"
}
```
    - si incumple validaciones iniciales 
	La respuesta es un mensaje de 'Malformed Body' con codigo de respuesta BAD_REQUEST 400
