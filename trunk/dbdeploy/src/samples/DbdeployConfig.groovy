output{
	consolidatedScriptFle = 'consolidated_script.sql'
	consolidatedUndoScriptFle = 'undo_consolidated_script.sql'
}

dbdeploy{
	sqlFolder = './dbdeploy/delta'
	schemaCreationScripts{
		ora = 'createSchemaVersionTable.ora.sql'
	}
}

options{
	applyChanges = 'true'

}
