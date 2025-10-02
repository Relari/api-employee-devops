@echo off
REM Título de la ventana
title Maven CI/CD Menu

:MENU
cls
echo =========================================
echo  MENU DE COMANDOS MAVEN (CI/CD)
echo =========================================
echo.
echo [1] Ejecutar Pruebas y Cobertura (Verify)
echo [2] Limpiar y Compilar (Clean Package)
echo [3] Limpiar, Verificar y Dockerizar (Full Build & Docker)
echo [0] Salir
echo.
set /p OPCION="Selecciona una opcion (0-3): "

REM --- ESTRUCTURA DE SELECCIÓN ---
if "%OPCION%"=="1" goto VERIFY
if "%OPCION%"=="2" goto CLEAN_PACKAGE
if "%OPCION%"=="3" goto FULL_BUILD
if "%OPCION%"=="0" goto SALIR
if not defined OPCION goto MENU_ERROR
goto MENU_ERROR

:VERIFY
echo.
echo Ejecutando: mvn clean verify (Pruebas y JaCoCo)
mvn clean verify
goto PAUSA

:CLEAN_PACKAGE
echo.
echo Ejecutando: mvn clean package -DskipTests (Solo Compilacion)
mvn clean package -DskipTests
goto PAUSA

:FULL_BUILD
echo.
echo Ejecutando: mvn clean verify package docker:build (Full CI/CD)
REM Nota: El comando 'docker:build' depende de que tengas un plugin Docker configurado en tu pom.xml
mvn clean verify package
REM Asumiendo que usas el plugin de Docker que genera la imagen despues del package:
REM mvn docker:build
goto PAUSA

:MENU_ERROR
echo.
echo Opcion invalida. Intenta de nuevo.
goto PAUSA

:PAUSA
echo.
pause
goto MENU

:SALIR
echo.
echo Saliendo del menu. ¡Adios!
exit /b