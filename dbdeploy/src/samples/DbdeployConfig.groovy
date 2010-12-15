output{
	consolidatedScriptFle = 'consolidated_script.sql'
	consolidatedUndoScriptFle = 'undo_consolidated_script.sql'
}

dbdeploy{
	sqlFolder = './dbdeploy/delta'
}

options{
	applyChanges = 'true'

}
