output{
	consolidatedScriptFle = 'consolidated_script.sql'
	consolidatedUndoScriptFle = 'undo_consolidated_script.sql'
}

dbdeploy{
	sqlFolder = './dbdeploy/delta'
	dbType= 'ora' //Possible values are ora, mysql, mssql, db2, syb-ase hsql
}

