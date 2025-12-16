# Sistema de Gestión de Préstamos – Crediya_db

Aplicación de consola desarrollada en Java para la gestión de empleados, clientes, préstamos y pagos.  
Permite registrar, consultar y almacenar información usando archivos de texto y una base de datos MySQL mediante JDBC.

## Módulo de Empleados
- Registro de empleados
- Consulta de empleados
- Atributos: id, nombre, documento, rol, correo, salario
- Persistencia en archivo `empleados.txt` y base de datos

## Módulo de Clientes
- Registro de clientes
- Listado de clientes
- Consulta de préstamos asociados
- Persistencia en archivo `clientes.txt` y base de datos

## Módulo de Préstamos
- Creación de préstamos asociando cliente y empleado
- Cálculo automático de interés y cuota
- Cambio de estado del préstamo
- Persistencia en archivo `prestamos.txt` y base de datos

## Módulo de Pagos
- Registro de pagos
- Actualización del saldo pendiente
- Historial de pagos
- Persistencia en archivo `pagos.txt` y base de datos

## Módulo de Reportes
- Consulta de préstamos activos
- Consulta de préstamos vencidos
- Consulta de clientes morosos
- Uso de Stream API y expresiones lambda

## Persistencia
Los datos se almacenan en archivos de texto dentro de la carpeta `archivos`.  
El sistema puede funcionar incluso sin conexión a la base de datos.

## Ejecución
Ejecutar la clase principal:
- com.diego.menu.Main


## Tecnologías
- Java
- Programación Orientada a Objetos
- Archivos de texto
- JDBC
- Stream API
- Maven

## Autor
Diego Diaz 🫧

