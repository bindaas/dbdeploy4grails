output{
	consolidatedScriptFle = './grails-app/dbdeploy/output/consolidated_script.sql'
	consolidatedUndoScriptFle = './grails-app/dbdeploy/output/undo_consolidated_script.sql'
}

dbdeploy{
	sqlFolder = './grails-app/dbdeploy/delta'
	dbType= 'ora' //Possible values are ora, mysql, mssql, db2, syb-ase hsql
}

