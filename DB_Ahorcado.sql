-- drop database if exists DB_Ahorcado;
create database DB_Ahorcado;
use DB_Ahorcado;

create table Usuario(
	codigoUsuario int auto_increment,
    nombre varchar(252),
    apellido varchar(252),
    correo varchar(252),
    pass varchar(252),
    primary key PK_usuarios (codigoUsuario)
);

create table Palabra(
	codigoPalabra int auto_increment,
    palabra varchar(252),
    pista1 varchar(252),
    pista2 varchar(252),
    pista3 varchar(252),
    primary key PK_palabra (codigoPalabra)
);

DELIMITER //
create procedure sp_AgregarUsuario(
    _nombre varchar(252),
    _apellido varchar(252),
    _correo varchar(252),
    _pass varchar(252)
)
	begin
		insert into Usuario(nombre, apellido, correo, pass)
			value(_nombre, _apellido, _correo, _pass);
    end //
DELIMITER ;
call sp_AgregarUsuario('hugo','samayoa','hugosam@gmail.com','100');
call sp_AgregarUsuario('eduardo','hor','eduardohor@gmail.com','100');
call sp_AgregarUsuario('Sebastian','Cumatz','sebascum@gmail.com','100');
call sp_AgregarUsuario('diego','leiva','leivadie@gmail.com','100');
call sp_AgregarUsuario('alejandro','pineda','pinedaalejo@gmail.com','100');
call sp_AgregarUsuario('joab','peregil','peregil@gmail.com','100');

DELIMITER //
create procedure sp_VerUsuarios()
	begin
		select codigoUsuario, nombre, apellido, corre, pass from usuario;
    end //
DELIMITER ;
-- call sp_VerUsuarios();

DELIMITER //

DELIMITER //
create procedure sp_BuscarUsuario(idUser int)
	begin
		select codigoUsuario, nombre, apellido, corre, pass from usuario
			where codigoUsuario = idUser;
    end //
DELIMITER ;

DELIMITER //
create procedure sp_EliminarUsuario(idUser int)
	begin
		delete from usuario
			where codigoUsuario = idUser;
    end//
DELIMITER ;

-- call sp_EliminarUsuario(1);

DELIMITER //
create procedure sp_ActualizarUsuario (
    _codigoUsuario int,
    _nombre varchar(252),
    _apellido varchar(252),
    _correo varchar(252),
    _pass varchar(252)
)
	begin
		update usuario
        set nombre = _nombre,
			apellido = _apellido,
            correo = _correo,
            pass = _pass
            where codigoUsuario = _codigoUsuario;			
    end//
DELIMITER ;
call sp_ActualizarUsuario(4,'hugo','samayoa','hugosam@gmail.com','100');

delimiter //
create procedure sp_agregarpalabra(
    _palabra varchar(252),
    _pista1 varchar(252),
    _pista2 varchar(252),
    _pista3 varchar(252)
)
    begin
        insert into palabra(palabra, pista1, pista2, pista3)
            value(_palabra, _pista1, _pista2, _pista3);
    end //
delimiter ;
call sp_agregarpalabra('Computadora', 'Dispositivo para procesar información', 'Tiene teclado y pantalla', 'Se usa para programar');
call sp_agregarpalabra('Television', 'Aparato para ver programas y películas', 'Tiene pantalla grande', 'Requiere control remoto');
call sp_agregarpalabra('Biblioteca', 'Lugar donde se guardan libros', 'Es un lugar silencioso', 'Ideal para estudiar');
call sp_agregarpalabra('Telescopio', 'Instrumento para observar estrellas', 'Usado por astrónomos', 'Permite ver objetos lejanos');
call sp_agregarpalabra('Avioneta', 'Vehículo aéreo pequeño', 'Puede aterrizar en pistas cortas', 'Usada para vuelos privados');



delimiter //
create procedure sp_verpalabras()
    begin
        select codigopalabra, palabra, pista1, pista2, pista3 from palabra;
    end //
delimiter ;
call sp_verpalabras();

delimiter //
create procedure sp_buscarlapalabra(idpalabra int)
    begin
        select codigopalabra, palabra, pista1, pista2, pista3 from palabra
            where codigopalabra = idpalabra;
    end //
delimiter ;
call sp_buscarpalabra(1)

delimiter //
create procedure sp_eliminarpalabra(idpalabra int)
    begin
        delete from palabra
            where codigopalabra = idpalabra;
    end//
delimiter ;
call sp_eliminarpalabra(1);
delimiter //
create procedure sp_actualizarpalabra (
    _codigopalabra int,
    _palabra varchar(252),
    _pista1 varchar(252),
    _pista2 varchar(252),
    _pista3 varchar(252)
)
    begin
        update palabra
        set palabra = _palabra,
            pista1 = _pista1,
            pista2 = _pista2,
            pista3 = _pista3
            where codigopalabra = _codigopalabra;			
    end//
delimiter ;

select * from Usuario; 
select * from Palabra; 