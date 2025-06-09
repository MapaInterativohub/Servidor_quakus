@echo off
echo Iniciando API de Frotas...
start cmd /k "cd api_frota && mvn clean quarkus:dev"

echo Iniciando API de Entregas...
start cmd /k "cd api_entregas && mvn clean quarkus:dev"

echo Servidores iniciados em janelas separadas.
pause
