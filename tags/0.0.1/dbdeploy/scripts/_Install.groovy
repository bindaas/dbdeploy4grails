//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//

Ant.mkdir(dir:"${basedir}/grails-app/dbdeploy")
Ant.mkdir(dir:"${basedir}/grails-app/dbdeploy/delta")
Ant.mkdir(dir:"${basedir}/grails-app/dbdeploy/initialize")
Ant.mkdir(dir:"${basedir}/grails-app/dbdeploy/output")

Ant.copy(file:"${pluginBasedir}/src/samples/DbdeployConfig.groovy",
         todir:"${basedir}/grails-app/conf")

Ant.copy(file:"${pluginBasedir}/src/samples/createSchemaVersionTable.ora.sql",
         todir:"${basedir}/grails-app/dbdeploy/initialize")
Ant.copy(file:"${pluginBasedir}/src/samples/createSchemaVersionTable.db2.sql",
         todir:"${basedir}/grails-app/dbdeploy/initialize")
Ant.copy(file:"${pluginBasedir}/src/samples/createSchemaVersionTable.hsql.sql",
         todir:"${basedir}/grails-app/dbdeploy/initialize")
Ant.copy(file:"${pluginBasedir}/src/samples/createSchemaVersionTable.mssql.sql",
         todir:"${basedir}/grails-app/dbdeploy/initialize")
Ant.copy(file:"${pluginBasedir}/src/samples/createSchemaVersionTable.mysql.sql",
         todir:"${basedir}/grails-app/dbdeploy/initialize")
Ant.copy(file:"${pluginBasedir}/src/samples/createSchemaVersionTable.syb-ase.sql",
         todir:"${basedir}/grails-app/dbdeploy/initialize")

Ant.copy(file:"${pluginBasedir}/src/samples/001_create_table.sql",
         todir:"${basedir}/grails-app/dbdeploy/delta")
Ant.copy(file:"${pluginBasedir}/src/samples/002_insert_data.sql",
         todir:"${basedir}/grails-app/dbdeploy/delta")
         