/*
*Universidad del Valle de Guatemala
*Facultad de Ingenieria
*Programacion orientada a objetos
*Prof. Lynette Garcia Perez
*Seccion 100
*Autor: Fernando Mendoza 
*/

-- Creacion de la base de datos platillos
DROP DATABASE IF EXISTS platillos;
CREATE DATABASE platillos;
USE platillos;

-- Tabla: ingredientes
-- Descripcion: Almacena el detalle de informacion de cada ingrediente
CREATE TABLE ingrediente(
	id_ingrediente			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_ingrediente		VARCHAR(100),
    cantidad_ingrediente 	VARCHAR(100),
    id_receta				INT
);

-- Tabla: receta
-- Descripcion: Contiene el registro de todas las recetas
CREATE TABLE receta(
	id_receta		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_receta	VARCHAR(100),
    pasos	VARCHAR(100)
);

-- Tabla: users
-- Descripcion: Contiene a los usuarios del sistema asi como sus credenciales para ingresar
DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id_user			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_user		VARCHAR(100),
    contr			VARCHAR(100),
    rol				INT default 0
);

-- Procedimiento almacenado: add_receta
-- Descripcion: Agrega nuevas recetas con los datos recibidos como parsmentros
DROP PROCEDURE IF EXISTS add_receta;
DELIMITER //
CREATE PROCEDURE add_receta
(
	IN cnombre_receta    		VARCHAR(100),
	IN cnombre_ingrediente1   	VARCHAR(100),
    IN ccantidad_ingrediente1	VARCHAR(100),
	IN cnombre_ingrediente2   	VARCHAR(100),
    IN ccantidad_ingrediente2	VARCHAR(100),
	IN cnombre_ingrediente3   	VARCHAR(100),
    IN ccantidad_ingrediente3	VARCHAR(100),
    IN cpasos	VARCHAR(100)
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	
	INSERT INTO receta(nombre_receta, pasos) VALUES (cnombre_receta, cpasos);
    
    SET @id_ultima_receta = LAST_INSERT_ID();
    
    INSERT INTO ingrediente(nombre_ingrediente, cantidad_ingrediente, id_receta)
	VALUES
	(cnombre_ingrediente1, ccantidad_ingrediente1, @id_ultima_receta),
	(cnombre_ingrediente2, ccantidad_ingrediente2, @id_ultima_receta),
	(cnombre_ingrediente3, ccantidad_ingrediente3, @id_ultima_receta);

END //
DELIMITER ;

-- Procedimiento almacenado: get_recetas
-- Descripcion: Retorna todas las recetas almacenadas 
DROP PROCEDURE IF EXISTS get_recetas;
DELIMITER //
CREATE PROCEDURE get_recetas()
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    (SELECT id_receta FROM receta r WHERE r.id_receta = i.id_receta) as id_receta
	FROM ingrediente i;
END //
DELIMITER ;

-- Procedimiento almacenado: get_receta
-- Descripcion: Retorna la informacion de una ureceta segun su identificador enviado com parametro 
DROP PROCEDURE IF EXISTS get_recetas_pasos;
DELIMITER //
CREATE PROCEDURE get_recetas_pasos()
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    (SELECT id_receta FROM receta r WHERE r.id_receta = i.id_receta) as id_receta,
    (Select pasos FROM receta r WHERE r.id_receta = i.id_receta) as pasos
	FROM ingrediente i;
END //
DELIMITER ;

-- Procedimiento almacenado: get_users
-- Descripcion: Retorna la informacion de todos los usuarios registrados en el sistema
DROP PROCEDURE IF EXISTS get_receta;
DELIMITER //
CREATE PROCEDURE get_receta(
	IN cid_receta	INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    r.id_receta
	FROM ingrediente i
	WHERE i.id_receta = xcid_receta;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS get_users;
DELIMITER //
CREATE PROCEDURE get_users(

)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT * FROM users;
END //
DELIMITER ;

-- Procedimiento almacenado: create_users
-- Descripcion: agrega nuevos usuarios al sistema
-- donde rol 0=administrador, 1 = visitante
DROP PROCEDURE IF EXISTS create_users;
DELIMITER //
CREATE PROCEDURE create_users(
	pnomb_user		VARCHAR(100),
    pcontrane		VARCHAR(100),
    prol			INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	INSERT INTO users(nombre_user,contr,rol) VALUES(pnomb_user,pcontrane,prol);
END //
DELIMITER ;


-- Procedimiento almacenado: verf_users
-- Descripcion: Determina si existe un usuario que coincida con las credenciales enviadas como parametro
DROP PROCEDURE IF EXISTS verf_users;
DELIMITER //
CREATE PROCEDURE verf_users(
	vnomb_user		VARCHAR(100),
    vcontrane		VARCHAR(100)
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT COUNT(*) FROM users WHERE nombre_user = vnomb_user AND contr = vcontrane;
END //
DELIMITER ;

-- Procedimiento almacenado: obt_rol_users
-- Descripcion: Retorna el rol de usuario segun sus credenciales
DROP PROCEDURE IF EXISTS obt_rol_users;
DELIMITER //
CREATE PROCEDURE obt_rol_users(
	vnomb_user		VARCHAR(100),
    vcontrane		VARCHAR(100)
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT rol FROM users WHERE nombre_user = vnomb_user AND contr = vcontrane;
END //
DELIMITER ;

-- Procedimiento almacenado: drop_receta
-- Descripcion: Elimina la receta que coincida con el identificador enviado como parametro
DROP PROCEDURE IF EXISTS drop_receta;
DELIMITER //
CREATE PROCEDURE drop_receta(
	id_drop		INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SET SQL_SAFE_UPDATES =0;
    DELETE FROM receta where id_receta = id_drop;
    DELETE FROM ingrediente WHERE id_receta = id_drop;
END //
DELIMITER ;



-- Carga de datos iniciales para recetas
CALL add_receta(
'TORTILLA DE PATATA RELLENA DE QUESO Y JAMON',
'Patata Mediana', '3 unidades',
'Huevos', '5 unidades', 
'Cebolla', '1/2 unidad',
'agregar cebolla, batir huevos y freir'
);

CALL add_receta('PALITOS DE QUESO', 'Queso Blando', '500 gramos', '', '', '', '', 'fundir queaso');

CALL get_recetas();

CALL get_receta(1);

CALL get_users();

SELECT * FROM receta where nombre_receta LIKE '%Tortilla%';
SELECT * FROM receta;

-- Carga de datos iniciales para usuarios
INSERT INTO users(nombre_user,contr) VALUES ("test1","123"), ("test2", "456");



CALL create_users("Test1","000",1);
CALL obt_rol_users("Test3","111");
CALL obt_rol_users("Test1","000");

SELECT 
	(SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombre_receta
FROM ingrediente i
WHERE nombre_ingrediente LIKE '%queso%';

CALL drop_receta(3);

DELETE FROM receta where id_receta = null;

SELECT * FROM receta;
