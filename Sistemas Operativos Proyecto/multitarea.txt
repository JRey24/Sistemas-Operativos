@echo off
echo ¡Bienvenido al script autoejecutable!
pause

echo Verificando la existencia de la carpeta de origen...
if not exist "C:\Users\%USERPROFILE%\Documents"(
	echo [ERROR] La carpeta de origen no existe. >> C:\log.txt
	echo El proceso ha fallado.
	pause
	exit
)

echo La carpeta de origen sí existe.
dir "C:\Users\%USERPROFILE%\Documents" >> C:\log.txt 2>&1
pause

echo Verificando la existencia de la carpeta de destino...
if not exist "C:\Backup"(
	echo La carpeta de destino no existe. Creándola...
	mkdir "C:\Backup"
)

echo Copiando Archivos...
pause

xcopy "C:\Users\%USERPROFILE%\Documents\*.*" "C:\Backup\" /s /e /I /Y >> C:\log.txt 2>&1
echo Copia de Seguridad completada.
pause.