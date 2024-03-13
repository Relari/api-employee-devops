# Employee-Example-Devops

## Jenkins

Para poder ejecutar el pipeline de Jenkins se deben instalar los siguientes plugins.

* Maven Integration Plugin
* HTML Publisher Plugin
* Pipeline Utility Steps
* JaCoCo
* Slack Notification Plugin
* SonarQube Scanner for Jenkins

## Configuration Utility from Jenkins

### Instal plugin
* Manage Jenkins
* Manage Plugins
* All Plugins
* Search -> Pipeline Utility Steps
* Install

## Configuration Maven in Jenkins

### Instal plugin
* Manage Jenkins
* Manage Plugins
* All Plugins
* Search -> Maven Integration Plugin
* Install

### Global Tool Configuration
* Manage Jenkins
* Maven
* Name -> MAVEN_HOME
* Check in Install Automatically
* Install from Apache
* Select Version

## Configuration SonarQube in Jenkins

### Instal plugin
* Manage Jenkins
* Manage Plugins
* All Plugins
* Search -> SonarQube Scanner for Jenkins
* Install

### Configure
* Manage Jenkins
* System Configuration
* SonarQube servers
* Check in Environment variables

|Name      |Server URI                  |Server authetication token      |
|----------|----------------------------|--------------------------------|
|sonarqube |host or ipaddress with port |Credentials (User and Password) |

### Global Tool Configuration
* Manage Jenkins
* SonarQube Scanner
* Name -> sonarqube
* Check in Install Automatically
* Install from Maven Central
* Select Version

## Configuration Slack in Jenkins

### Instal plugin
* Manage Jenkins
* Manage Plugins
* All Plugins
* Search -> Slack Notification Plugin
* Install

### Global Tool Configuration
* Manage Jenkins
* Slack

|Workspace |Server authetication token      |Default channel / member id |
|----------|--------------------------------|----------------------------|
|Your team's workspace name. If you sign in to slack at https://example.slack.com/, your workspace is 'example'. |Credentials (User and Password) |Space where the notifications will arrive. |


# Docker

Install Jenkins
```
docker run -p 8080:8080 -p 50000:50000 -v c:\jenkins\jenkins_home:/var/jenkins -d --name JENKINS_DEV jenkins/jenkins:jdk11
```

Install SonarQube
```
docker run -p 9000:9000 -d --name SONARQUBE_DEV sonarqube:community
```

## Como saco mi usuario en windows

En Windows, puedes verificar tu nombre de usuario de varias maneras, aquí te mostramos tres opciones:

La forma más sencilla de verificar tu nombre de usuario en Windows es simplemente mirar la pantalla de inicio de sesión o en la barra de tareas después de iniciar sesión. Tu nombre de usuario debería estar visible en ambos lugares.

Puedes abrir el símbolo del sistema (CMD) y escribir el siguiente comando para ver el nombre de usuario actual:

```
echo %username%
```
Este comando mostrará tu nombre de usuario actual en la consola.

Otra opción es abrir el Panel de control y buscar la opción de "Cuentas de usuario". En la sección de "Cuentas de usuario", verás una lista de usuarios del sistema, incluyendo el tuyo. El nombre de usuario debe estar claramente visible en esta lista.
Ten en cuenta que para ver la información de usuario en Windows, necesitas tener permisos de administrador en el sistema.

## Como se que mi usuario esta en el grupo de usuarios de docker en windows?

En Windows, puedes verificar si tu usuario está en el grupo de usuarios de Docker utilizando la Consola de PowerShell. Para hacerlo, sigue los siguientes pasos:

Abre la Consola de PowerShell con permisos de administrador. Puedes hacerlo haciendo clic derecho en el icono de Windows en la barra de tareas y seleccionando "Windows PowerShell (Admin)".

En la Consola de PowerShell, escribe el siguiente comando y presiona Enter:

```
Get-LocalGroupMember -Group "docker-users"
```

Este comando mostrará una lista de usuarios y grupos que pertenecen al grupo "docker-users". Si tu usuario aparece en esta lista, significa que está en el grupo de usuarios de Docker en Windows.

Si tu usuario no aparece en la lista, puedes agregarlo ejecutando el siguiente comando en la Consola de PowerShell con permisos de administrador:

```
Add-LocalGroupMember -Group "docker-users" -Member "tu_usuario"
```

Reemplaza "tu_usuario" con el nombre de tu usuario en el sistema. Luego, cierra la sesión actual y vuelve a iniciar sesión para que los cambios surtan efecto.

Después de agregar tu usuario al grupo "docker-users", puedes ejecutar el comando "Get-LocalGroupMember -Group 'docker-users'" nuevamente para verificar que tu usuario ahora aparece en la lista de usuarios y grupos que pertenecen al grupo "docker-users".