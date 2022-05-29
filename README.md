# Employee-Mock

## Jenkins

Para poder ejecutar el pipeline de Jenkins se deben instalar los siguientes plugins.

* Maven Integration Plugin
* HTML Publisher Plugin
* Pipeline Utility Steps
* JaCoCo
* Slack Notification Plugin
* SonarQube Scanner for Jenkins

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