# Employee-Mock

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