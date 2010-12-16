import com.dbdeploy.exceptions.UsageException
import com.dbdeploy.DbDeploy
import com.dbdeploy.DbDeployCommandLineParser

grailsHome = Ant.project.properties."environment.GRAILS_HOME"    
includeTargets << new File ( "${grailsHome}/scripts/Bootstrap.groovy" )

Properties dsProps = new Properties()
Properties dbdProps = new Properties()

def populateDSProperties = {

  File dsFile = new File("${basedir}/grails-app/conf/DataSource.groovy")
  def dsConfig = null
  if (dsFile.exists()) {
    dsConfig = new ConfigSlurper(grailsEnv).parse(dsFile.text)
  }

  dsProps.'db.username' = dsConfig?.dataSource?.username 
  dsProps.'db.password' = dsConfig?.dataSource?.password 
  dsProps.'db.driver' = dsConfig?.dataSource?.driverClassName 
  dsProps.'db.url' = dsConfig?.dataSource?.url 

}

def populateDBDProperties = {

  File dbdFile = new File("${basedir}/grails-app/conf/DbdeployConfig.groovy")
  def dbdConfig = null
  if (dbdFile.exists()) {
    dbdConfig = new ConfigSlurper(grailsEnv).parse(dbdFile.text)
  }

  dbdProps.'dbd.outputFle' = dbdConfig?.output?.consolidatedScriptFle 
  dbdProps.'dbd.undoOutputFle' = dbdConfig?.output?.consolidatedUndoScriptFle 
  dbdProps.'dbd.scripts' = dbdConfig?.dbdeploy?.sqlFolder 
  dbdProps.'dbd.dbType' = dbdConfig?.dbdeploy?.dbType 

}

target('default':"Slurp properties") {
	populateDSProperties ()
	populateDBDProperties ()

def params = ['-U' ,dsProps.'db.username','-P', dsProps.'db.password','-D' ,dsProps.'db.driver','-u' ,dsProps.'db.url','-d', dbdProps.'dbd.dbType' ,'-o' ,dbdProps.'dbd.outputFle','-s' ,dbdProps.'dbd.scripts' ] as String[]

	DbDeployCommandLineParser commandLineParser = new DbDeployCommandLineParser();
	DbDeploy dbDeploy = new DbDeploy();
	commandLineParser.parse(params, dbDeploy);
	if(dbdProps.'dbd.undoOutputFle'){
		dbDeploy.setUndoOutputfile(new java.io.File(dbdProps.'dbd.undoOutputFle'))
	}
	dbDeploy.go();

}

setDefaultTarget('default')
