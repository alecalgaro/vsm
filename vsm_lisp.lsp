;La validacion de la cantidad de modulos que entren en el terreno (20 metros),
;deberia hacerla en la interfaz, para que no me permita seleccionar mas de lo permitido.

;PARA QUE FUNCIONE PRIMERO DEBO CREAR LOS BLOQUES.
;HACER ESO O ARMAR EL TEMPLATE CON TODOS LOS BLOQUES Y USAR SIEMPRE ESE TEMPLATE.

;comando osnap para abrir la configuracion de captura de puntos.

(defun c:vsm ()
  (setq osmodo (getvar "osmode"))
  (setvar "osmode" 0) ;Desactivo el osnap.
  ;(setvar "SURFTAB1" 20)
  ;(setvar "SURFTAB2" 20)
  ;(setvar "isolines" 20)
  (command "ucs" "w") 	;Dejo el ucs en world por si antes el usuario lo cambio (ucs: Sistema de coordenadas de usuario).
			;Establece el origen y la orientación del sistema de coordenadas del usuario actual (UCS).

  ;Isolines, surftab1 y surftab2 son variables de sistema que se usan para configuraciones para que se vea mejor en 3D (explicación de cada una en word).

  ;---CREO CAPAS---.
  (command "-layer" "m" "terreno" "c" 32 "" "") 	;de color marron.
  
  ;(command "clayer" "nombre_capa")	Para cambiar de capa.

  (command "clayer" "0")
  
  ;---Datos que ingresa el usuario---.
  (setq pini (getpoint "Ingrese punto de insercion: ")) (terpri)

  ;---LLamo a la funcion que abre el archivo que genera la interfaz y que indica los modulos a usar.
  (file)
  
  ;---Coordenadas del punto de insercion para simplificar la escritura---.
  (setq xini (nth 0 pini))
  (setq yini (nth 1 pini))
  (setq zini (nth 2 pini))

  ;---DEL ARCHIVO .TXT:---
  ;Con "atoi" convierto la linea leida a un integer para poder compararlo, porque viene como string.
  (setq orientacion linea1)			;la orientacion puede ser "N" de norte, "NE" de noreste, etc. 
  (setq largo (atoi linea2))			;me serviria para armar todo el muro
  (setq ancho (atoi linea3))			
  (setq validacion_largo (atoi linea4))		;la validacion de cantidad de modulos la tendria que hacer en la interfaz para que el usuario no pueda elegir mas del limite.
  (setq cubierta linea5)
  (setq piso linea6)		
  (setq terminacion linea7)
  (setq lc linea8)
  (setq local_comercial (atoi linea9))
  (setq se linea10)
  (setq sala_estar (atoi linea11))
  (setq co linea12)
  (setq comedor (atoi linea13))
  (setq blc linea14)
  (setq ba_lav_coc (atoi linea15))
  (setq hdm linea16)
  (setq hab_matri (atoi linea17))
  (setq hd linea18)
  (setq hab_doble (atoi linea19))
  (setq hs linea20)
  (setq hab_simple (atoi linea21))
  (setq st linea22)
  (setq sala_estudio (atoi linea23))
  (setq de linea24)
  (setq deposito (atoi linea25))
  (setq ta linea26)
  (setq taller (atoi linea27))
  

  ;---------------BORDE DEL TERRENO Y DEFINO EL PUNTO DONDE COMIENZAN LOS MODULOS---------------.
  
  (command "clayer" "terreno")	;Activo capa para terreno
  (command "rectangle" pini (list (+ largo xini) (+ ancho yini) zini))	;Borde del terreno.
  (setq punto_final_terreno (list (+ largo xini) (+ ancho yini) zini))	;"punto_final_terreno" es la esquina superior derecha del borde del terreno.

  (command "clayer" "0")
  
  ;---Punto para comenzar a insertar los modulos---.
  ;Hay tres opciones:
  
  (if (and (= local_comercial 0) (> validacion_largo (- largo 3.66)))	;si no entran los modulos dejando espacio para un futuro local comercial
    (progn
      (setq punto_modulos (list (+ xini 0.075) (+ yini ancho) zini))
      )
    )

  (if (and (= local_comercial 0) (< validacion_largo (- largo 3.66)))	;si los modulos entran dejando lugar para un futuro local comercial, se comienza la casa dejando 3.66 m
    (progn
      (setq punto_modulos (list (+ xini 3.66) (+ yini ancho) zini))
      )
    )

  (if (> local_comercial 0)	;si hay local comercial, comienzo desde el borde del terreno.
    (progn
      (setq punto_modulos (list xini (+ yini ancho) zini))
      )
    )
  
  (setq angulo 0) ;Para ser usado cuando inserto los bloques.

  ;Coordenadas del punto para comenzar a insertar los modulos.
  (setq x (nth 0 punto_modulos))
  (setq y (nth 1 punto_modulos))
  (setq z (nth 2 punto_modulos))

  ;--------------------------------------------------------------------------
  
  ;Lo siguiente es para verificar si hay local comercial o sala de estar, en caso de no haber, deberia comenzar con el comedor dejando ese espacio
  ;para que en un futuro se pueda utilizar si el cliente lo desea. Tambien se debe comprobar si el resto de los modulos entran en el espacio que queda de terreno.
  
  ;Si no hay local comercial
  ;   Si no hay sala de estar y entran los modulos, corro 3.76 + 3.76
  ;   Si hay sala de estar y entran los modulos, corro 3.76
  ;
  ;si los modulos elegidos no entran dejando el espacio libre, no se hace nada de esto y se comienza con el comedor al comienzo del terreno.
     
  	;TENER CUIDADO POR SI HAY PROBLEMA CON COMO ESCRIBO validacion_largo EN EL ARCHIVO POR SI ES FLOAT Y LO MISMO CON EL LARGO DEL TERRENO.
  
  ;(if (= local_comercial 0) ;si no hay local comercial
  ;  (progn
  ;    (if (and (= sala_estar 0) (< validacion_largo (- largo 7.31)) ) ;si no hay sala de estar y los otros modulos entran
  ;    	(progn
  ;	  	(setq punto_modulos (list (+ 7.52 (nth 0 punto_modulos)) y z))
  ;	
  ;  	) 
  ;     )
      
  ;    (if (and (= sala_estar 1) (< validacion_largo (- largo 3.66)) )	;si hay sala de estar y los otros modulos entran
  ;  	(progn
  ;	  	(setq punto_modulos (list (+ 3.66 (nth 0 punto_modulos)) y z))
  ;	
  ;  	)	
  ;    )
  ;  )
  ; )
  
  ;----------------------------------MODULOS----------------------------------------

  ;RECORDAR QUE EN TODOS LOS MODULOS ME MUEVO SU LARGO - 0.1 PARA QUE COINCIDAN LAS COLUMNAS DE LA GALERIA.

  ;Linea que une la galeria con los modulos al comienzo.
  (setq punto_linea (list (- (nth 0 punto_modulos) 0.05) (- (nth 1 punto_modulos) 6.23) (nth 2 punto_modulos)))	;es -0.05 en "x" porque cuando no tiene local el punto_modulo esta corrido 0.075
  (if (> local_comercial 0)
    (progn
        (setq punto_linea (list (+ (nth 0 punto_modulos) 0.025) (- (nth 1 punto_modulos) 6.23) (nth 2 punto_modulos)))	;si hay local, "x" se debe mover 0.025 para que coincida con la galeria.
  	(command "insert" "linea_galeria_local" punto_linea 1 1 0)	;la linea con el local es un poquito mas corta, por eso cree dos distintas.
      )
    (command "insert" "linea_galeria_modulo" punto_linea 1 1 0)
   )
  
  ;---LOCAL COMERCIAL---
  (while (> local_comercial 0)	
  	(command "insert" lc punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 3.66 (nth 0 punto_modulos)) y z))	
    	(setq local_comercial (- local_comercial 1))			
    )

  ;Si no hay local comercial, pongo una ventana al comienzo del pasillo en la sala de estar o comedor, en el que comience la casa.
  (setq local_comercial (atoi linea9))
  (if (= local_comercial 0)
	(progn
  		(command "insert" "ventana_izq" punto_modulos 1 1 0)
	  )
    )
  
  ;---SALA DE ESTAR---
  (while (> sala_estar 0)	
  	(command "insert" se punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 3.66 (nth 0 punto_modulos)) y z))
    	(setq sala_estar (- sala_estar 1))
    )

  ;---COMEDOR---
  (while (> comedor 0)	
  	(command "insert" co punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 3.66 (nth 0 punto_modulos)) y z))
    	(setq comedor (- comedor 1))
    )

  ;---BANO, LAVADERO Y COCINA---	(Va todo junto porque se llama "modulo humedo" o similar, por el tema de las tuberias)
  (while (> ba_lav_coc 0)	
  	(command "insert" blc punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 2.44 (nth 0 punto_modulos)) y z))
    	(setq ba_lav_coc (- ba_lav_coc 1))
    )

  ;---HABITACION DOBLE CON CAMA MATRIMONIAL---.
  (while (> hab_matri 0)	
  	(command "insert" hdm punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 3.66 (nth 0 punto_modulos)) y z))
    	(setq hab_matri (- hab_matri 1))
    )

  ;---HABITACION DOBLE CON DOS CAMAS SIMPLES---.
  (while (> hab_doble 0)	
  	(command "insert" hd punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 3.66 (nth 0 punto_modulos)) y z))
    	(setq hab_doble (- hab_doble 1))
    )

  ;---HABITACION SIMPLE---.
  (while (> hab_simple 0)	
  	(command "insert" hs punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 2.44 (nth 0 punto_modulos)) y z))
    	(setq hab_simple (- hab_simple 1))
    )

  ;---SALA DE ESTUDIO---.
  (while (> sala_estudio 0)	
  	(command "insert" st punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 2.44 (nth 0 punto_modulos)) y z))
    	(setq sala_estudio (- sala_estudio 1))
    )

  ;---DEPOSITO---.
  (while (> deposito 0)	
  	(command "insert" de punto_modulos 1 1 angulo)
	(setq punto_modulos (list (+ 2.44 (nth 0 punto_modulos)) y z))
    	(setq deposito (- deposito 1))
    )

  ;---COLOCO VENTANA AL FINAL DE LA CASA---.
  (command "insert" "ventana_der" punto_modulos 1 1 0)

  ;Linea que une la galeria con los modulos al final.
  (setq punto_linea2 (list (+ (nth 0 punto_modulos) 0.05) (- (nth 1 punto_modulos) 6.23) (nth 2 punto_modulos)))
  (command "insert" "linea_galeria_modulo" punto_linea2 1 1 0)
  
  ;---TALLER---.

  ;El taller siempre se coloca pegado al final del terreno. Si llegara a tener mas de un taller, comienza al final y se van sumando hacia la izquierda.
  (setq punto_taller (list (nth 0 punto_final_terreno) (nth 1 punto_final_terreno) (nth 2 punto_final_terreno)))
  
  (while (> taller 0)	
  	(command "insert" ta punto_taller 1 1 angulo)
    	(setq punto_linea3 (list (- (nth 0 punto_taller) 3.785) (- (nth 1 punto_taller) 6.23) (nth 2 punto_taller)))	;Linea que une la galeria con el comienzo del taller.
 	(command "insert" "linea_galeria_modulo" punto_linea3 1 1 0)
    	(setq punto_linea4 (list (- (nth 0 punto_taller) 0.025) (- (nth 1 punto_taller) 6.23) (nth 2 punto_taller)))	;Linea que une la galeria con el final del taller
  	(command "insert" "linea_galeria_modulo" punto_linea4 1 1 0)
	(setq punto_taller (list (- (nth 0 punto_taller) 3.81) (nth 1 punto_taller) (nth 2 punto_taller)))	
    	(setq taller (- taller 1))		
    )
  
  ;--------------------------------------------------------------------------

  ;m1 a m6 son los distintos modulos en vista lateral, algunos se repiten porque son iguales.
  ;c1: cubierta 1 agua (una pendiente).
  ;c2: cubierta 2 aguas (dos pendientes).
  ;c3: cubierta plana.
  ;p1: piso sobre platea.
  ;p2: piso sobre pilotes.
  ;t1: terminacion placa cementicia.
  ;t2: terminacion tablas madera.

  ;c1 y c2 serían iguales para la vista lateral, así que las uso como "c1". (Luego en la vista frontal son distintas).
  (if (or (= cubierta "1") (= cubierta "2"))
     (progn
	  (setq techo "1")
       )
          (setq techo "2")	;Si es cubierta = 3 (cubierta plana), le pongo techo = 2 porque así estan guardados los bloques (con "c2" en lugar de c3, ya que c1 y c2 estan dentro de "c1")
    )
  
  ;Concateno en un string para formar los distintos tipos de modulos en vista lateral
  (setq m1cpt (strcat "m1" "c" techo "p" piso "t" terminacion))
  (setq m2cpt (strcat "m2" "c" techo "p" piso "t" terminacion))
  (setq m3cpt (strcat "m3" "c" techo "p" piso "t" terminacion))
  (setq m4cpt (strcat "m4" "c" techo "p" piso "t" terminacion))
  (setq m5cpt (strcat "m5" "c" techo "p" piso "t" terminacion))
  (setq m6cpt (strcat "m6" "c" techo "p" piso "t" terminacion))

  ;---Coordenadas del punto de insercion de la vista lateral---.

  (setq xlat x)		;uso "x" porque es la coordenada "x" donde se empieza a dibujar la casa en la vista superior.
  (setq ylat (- (nth 1 pini) 8))
  (setq zlat (nth 2 pini))

  (setq punto_vista_lateral (list xlat ylat zlat))
  (setq angulo 0) ;Para ser usado cuando inserto los bloques.
 
  ;-----------BLOQUES VISTA LATERAL:----------

  ;Vuelvo a cargar los valores porque en este momento estan en cero ya que los use para insertar los bloques en cada while
  (setq local_comercial (atoi linea9))
  (setq sala_estar (atoi linea11))
  (setq comedor (atoi linea13))
  (setq ba_lav_coc (atoi linea15))
  (setq hab_matri (atoi linea17))
  (setq hab_doble (atoi linea19))
  (setq hab_simple (atoi linea21))
  (setq sala_estudio (atoi linea23))
  (setq deposito (atoi linea25))
  (setq taller (atoi linea27))
  
  ;---Local comercial---
  (while (> local_comercial 0)	
  	(command "insert" m3cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 3.66 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq local_comercial (- local_comercial 1))
    )

  ;---Sala de estar--- 
  (while (> sala_estar 0)	
  	(command "insert" m2cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 3.66 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq sala_estar (- sala_estar 1))
    )

  ;---Comedor---
  (while (> comedor 0)	
  	(command "insert" m1cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 3.66 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq comedor (- comedor 1))
    )

  ;---Bano, lavadero y cocina---
  (while (> ba_lav_coc 0)	
  	(command "insert" m6cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 2.44 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq ba_lav_coc (- ba_lav_coc 1))
    )

  ;---Habitacion doble con cama matrimonial---.
  (while (> hab_matri 0)	
  	(command "insert" m2cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 3.66 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq hab_matri (- hab_matri 1))
    )

  ;---Habitacion doble con dos camas simples---.
  (while (> hab_doble 0)	
  	(command "insert" m2cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 3.66 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq hab_doble (- hab_doble 1))
    )

  ;---Habitacion simple---.
  (while (> hab_simple 0)	
  	(command "insert" m4cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 2.44 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq hab_simple (- hab_simple 1))
    )

  ;---Sala de estudio---.
  (while (> sala_estudio 0)	
  	(command "insert" m5cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 2.44 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq sala_estudio (- sala_estudio 1))
    )

  ;---Deposito---.
  (while (> deposito 0)	
  	(command "insert" m4cpt punto_vista_lateral 1 1 angulo)
	(setq punto_vista_lateral (list (+ 2.44 (nth 0 punto_vista_lateral)) ylat zlat))
    	(setq deposito (- deposito 1))
    )
  
  ;---Taller---.
  (setq punto_taller (list (- (nth 0 punto_final_terreno) 3.76) (- (nth 1 punto_final_terreno) 18) (nth 2 punto_final_terreno)))
  (while (> taller 0)	
  	(command "insert" m1cpt punto_taller 1 1 angulo)
	(setq punto_taller (list (- (nth 0 punto_taller) 3.66) (- (nth 1 punto_final_terreno) 18) (nth 2 punto_final_terreno)))
    	(setq taller (- taller 1))
    )

  ;---Nombre de la vista lateral---.
  (setq punto_medio_lateral (list (+ (nth 0 pini) (/ largo 2)) (+ (nth 1 punto_vista_lateral) 6) (nth 2 punto_vista_lateral)))
  (command "insert" "titulo_vista_lateral" punto_medio_lateral 1 1 0)		;para usar un bloque y que sea mas rapido.
  ;(command "text" "j" "m" punto_medio_lateral 0.5 0 "VISTA LATERAL" "") ;"j" "m" para justify middle.	(por si lo necesito hacer sin bloques)
  
  ;--------------------------------------------------------------------------

  ;----------VISTA FRONTAL:---------

  ;m1 y m2 son las dos posibilidades de modulos en vista frontal, "m1" si empieza con sala de estar o comedor y "m2" si empieza con local comercial.
  ;c1: cubierta 1 agua (una pendiente).
  ;c2 cubierta 2 aguas (doble pendiente).
  ;c3: cubierta plana.
  ;p1: piso sobre platea.
  ;p2: piso sobre pilotes.
  ;t1: terminacion placa cementicia.
  ;t2: terminacion tablas madera.

  ;Vuelvo a cargar los valores porque en este momento estan en cero ya que los use para insertar los bloques en cada while
  ;Cargo solo estos tres porque son los las tres posibilidad de comienzo en una casa (la vista de sala de estar y comedor van a ser iguales).
  (setq local_comercial (atoi linea9))
  (setq sala_estar (atoi linea11))
  (setq comedor (atoi linea13))
  
  ;Concateno en un string 
  (setq f-m1cpt (strcat "f-" "m1" "c" cubierta "p" piso "t" terminacion))	;"f-" es por "frontal". A los que son de vista lateral no les puse nada.
  (setq f-m2cpt (strcat "f-" "m2" "c" cubierta "p" piso "t" terminacion))
  
  ;---Punto de insercion de la vista lateral---.
  (setq xfrontal (+ (nth 0 punto_final_terreno) 4))	;"punto_final_terreno" es la esquina superior derecha del borde del terreno.
  (setq yfrontal (- (nth 1 punto_final_terreno) 18))
  (setq zfrontal (nth 2 punto_final_terreno))

  (setq punto_vista_frontal (list xfrontal yfrontal zfrontal))
  (setq angulo 0) ;Para ser usado cuando inserto los bloques.

  ;---Inserto el bloque correspondiente en vista frontal:---.
  (if (> local_comercial 0)	;si empieza con local comercial / estudio, inserto la vista frontal correspondiente. 
    (progn
  	(command "insert" f-m2cpt punto_vista_frontal 1 1 angulo)
      )
    )

  (if (and (= local_comercial 0) (or (> sala_estar 0) (> comedor 0)))	;si empieza con sala de estar o comedor, inserto la vista frontal correspondiente. 
    (progn
  	(command "insert" f-m1cpt punto_vista_frontal 1 1 angulo)
      )
    )

  ;---Nombre de la vista frontal---.
  (setq punto_medio_frontal (list (+ (nth 0 punto_vista_frontal) (/ 6.1 2)) (+ (nth 1 punto_vista_frontal) 6) (nth 2 punto_vista_frontal)))
  (command "insert" "titulo_vista_frontal" punto_medio_frontal 1 1 0)	;para hacerlo con bloques y que sea mas rapido.
  ;(command "text" "j" "m" punto_medio_frontal 0.5 0 "VISTA FRONTAL" "") ;"j" "m" para justify middle.		(por si lo necesito hacer sin bloques).
  
  ;--------------------------------------------------------------------------

  ;------SIMBOLO DE ORIENTACIÓN:-----

  ;Punto para insertar el simbolo:
  (setq punto_orientacion (list (+ xfrontal 3) (+ yfrontal 13) zfrontal))
  
  (if (= orientacion "N")
    (progn
      (command "insert" "norte" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "S")
    (progn
      (command "insert" "sur" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "E")
    (progn
      (command "insert" "este" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "O")
    (progn
      (command "insert" "oeste" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "NE")
    (progn
      (command "insert" "noreste" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "NO")
    (progn
      (command "insert" "noroeste" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "SE")
    (progn
      (command "insert" "sureste" punto_orientacion 1 1 0)
      )
    )

  (if (= orientacion "SO")
    (progn
      (command "insert" "suroeste" punto_orientacion 1 1 0)
      )
    )
  
  ;--------------------------------------------------------------------------
  (command "zoom" "e")
  (setvar "osmode" osmodo) ;Activo el osnap.
  
  ) ;FIN

;-----------------------------------------------------------------------------

;Funcion para leer el archivo que seria escrito por la interfaz grafica.
;Lo hice asi porque en el archivo pienso escribir 18 renglones, primero el nombre del bloque (para insertarlo) y luego la cantidad.
;Uso todos los bloques, aunque varios pueden tener cantidad 0.
(defun file()
	(setq 	archivo (open "C:/Users/aleja/Desktop/VSM/archivo.txt" "r")
		linea1 (read-line archivo)	;orientacion.
		linea2 (read-line archivo)	;largo
		linea3 (read-line archivo)	;ancho
		linea4 (read-line archivo)	;validacion_largo
		linea5 (read-line archivo)	;cubierta
		linea6 (read-line archivo)	;piso
		linea7 (read-line archivo)	;terminacion
		linea8 (read-line archivo)	;lc
		linea9 (read-line archivo)	;cantidad de local_comercial
		linea10 (read-line archivo)	;se
		linea11 (read-line archivo)	;cantidad sala_estar
		linea12 (read-line archivo)	;co
		linea13 (read-line archivo)	;cantidad comedor
		linea14 (read-line archivo)	;blc
		linea15 (read-line archivo)	;cantidad ba_lav_coc
		linea16 (read-line archivo)	;hdm
		linea17 (read-line archivo)	;cantidad hab_matrimonial
		linea18 (read-line archivo)	;hd
		linea19 (read-line archivo)	;cantidad hab_doble
		linea20 (read-line archivo)	;hs
		linea21 (read-line archivo)	;cantidad hab_simple
		linea22 (read-line archivo)	;st
		linea23 (read-line archivo)	;cantidad sala_estudio
		linea24 (read-line archivo)	;de
		linea25 (read-line archivo)	;cantidad deposito
		linea26 (read-line archivo)	;ta
		linea27 (read-line archivo)	;cantidad taller
	)
	(close archivo)
)