# Java EE Backend

## Tabla de contenidos

<!-- toc -->

- [Configuracion de la base de datos](#configuracion-de-la-base-de-datos)
- [Configuracion de Glassfish](#configuracion-de-glassfish)
- [Usuario](#usuario)
  * [Listar todos los usuarios](#listar-todos-los-usuarios)
  * [Login](#login)
  * [Registrar usuario](#registrar-usuario)
  * [Eliminar usuario](#eliminar-usuario)

<!-- tocstop -->

## Configuracion de la base de datos

1. En la carpeta ```/DB``` se encuentra el modelo (se abre con MySQL Workbench). Este modelo puede compilar codigo.
2. Tambien se encuentra en la carpeta la ultima version del codigo de la estructura de la base de datos (```schema.sql```).
3. Tambien hay un archivo con una poblacion inicial (```poblacion.sql```).
4. La base de datos debe llamarse ```recreu```.


## Configuracion de Glassfish

Crear la siguiente Pool en Glassfish

```
JDBC/recreu_pool
```

## Usuario

### Listar todos los usuarios

```GET /usuarios```


### Login

```POST /usuarios/login```

Retorna codigo de estado ```200 (OK)``` en caso de login correcto, y en caso de login incorrecto, retorna otro codigo. El correo puede tener mayusculas y minusculas (no afecta), pero la password debe ser igual que como se registro.

Alternativa #1: Sin incluir ```@usach.cl```

```json
{
    "correo":"correo",
    "password":"pass"
}
```

Alternativa #2: Con ```@usach.cl```
```json
{
    "correo":"correo@usach.cl",
    "password":"pass"
}
```


### Registrar usuario

```POST /usuarios```

El formato del JSON debe ser:

```json
{
	"apellidoMaterno":"cespedes",
	"apellidoPaterno":"vilches",
	"primerNombre":"felipe",
	"segundoNombre":"chris",
	"correo":"correo.sin.arroba.usach",
	"password":"pass.minimo.6.caracteres",
	"fechaNacimiento":"1991-10-24",	
	"sexo": true
}
```

Al registrar usuario, los siguientes atributos son opcionales (ya que se pueden agregar despues, cuando el usuario quiera configurar su perfil):

1. ```numeroTelefono```
2. ```intereses```
3. ```urlFacebook```
4. ```urlInstagram```
5. ```urlTwitter```
6. ```carrera``` (asume que la BD no tiene todas las carreras, por lo cual algunos usuarios pueden no indicar su carrera, ademas pueden ser profesores, por eso no lo puse como mandatorio)

En caso de querer incorporar la carrera, se pone de esta forma

```json
{
	"correo":"correo.sin.arroba.usach",
	"carrera":{
		"carreraId": 4
	},
	"sexo": true
}
```

Los demas atributos (```disponibilidad```, ```last_update```, etc) no se insertan al registrar usuario (se ignoran).

### Eliminar usuario

```DELETE /usuarios/{id}```

Si lo elimina exitosamente, retorna codigo de estado ```200 (OK)```, y retorna codigo de error en caso que el usuario no existe.