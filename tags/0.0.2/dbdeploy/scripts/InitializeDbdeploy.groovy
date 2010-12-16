def ant = new AntBuilder()

grailsHome = Ant.project.properties."environment.GRAILS_HOME"    
includeTargets << new File ( "${grailsHome}/scripts/Bootstrap.groovy" )

Properties props = new Properties()
Properties dbdProps = new Properties()


def populateProperties = {

  File dsFile = new File("${basedir}/grails-app/conf/DataSource.groovy")
  def dsConfig = null
  if (dsFile.exists()) {
    dsConfig = new ConfigSlurper(grailsEnv).parse(dsFile.text)
  }

  props.'db.username' = dsConfig?.dataSource?.username 
  props.'db.password' = dsConfig?.dataSource?.password 
  props.'db.driver' = dsConfig?.dataSource?.driverClassName 
  props.'db.url' = dsConfig?.dataSource?.url 

}

def populateDBDProperties = {

  File dbdFile = new File("${basedir}/grails-app/conf/DbdeployConfig.groovy")
  def dbdConfig = null
  if (dbdFile.exists()) {
    dbdConfig = new ConfigSlurper(grailsEnv).parse(dbdFile.text)
  }

  dbdProps.'dbd.dbType' = dbdConfig?.dbdeploy?.dbType 
}

  
target('default':"Initialize DBDeploy") {
	populateProperties ()
	populateDBDProperties ()
	
	ant.sequential {
		sql(driver:props.'db.driver', url:props.'db.url', userid:props.'db.username', password:props.'db.password'){
			fileset(file:'${basedir}/grails-app/dbdeploy/initialize/createSchemaVersionTable.'+dbdProps.'dbd.dbType'+'.sql')
		}
	}	

}
setDefaultTarget('default')