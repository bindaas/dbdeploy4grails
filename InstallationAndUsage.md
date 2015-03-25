# Installation #

grails install-plugin dbdeploy

# Configuration #
> All configurations are controlled from  **grails-app/conf/DbdeployConfig.groovy**
> This file will be automatically created by the plugin with defaults

## Properties ##
> _output.consolidatedScriptFle_ Name and path of the file which has all the changes that need to be applied to the database.

> _output.consolidatedUndoScriptFle_ This is the undo SQL script. This is optional.

> _dbdeploy.sqlFolder_ Contains all the SQL files which need to be applied to the database

> _dbdeploy.dbType_ Possible values are ora, mysql, mssql, db2, syb-ase, hsql

# How to use this plugin? #

The plugin comes with two scripts.


## The scripts... ##

  * initialize-dbdeploy
> > Run this script once- to initialize DBDeploy.
> > It will create a table CHANGELOG in the database.
  * generate-db-changes
> > Use this script to generate SQL file with all changes that need to be applied to the database.