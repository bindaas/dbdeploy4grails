def ant = new AntBuilder()

grailsHome = Ant.project.properties."environment.GRAILS_HOME"    
includeTargets << new File ( "${grailsHome}/scripts/Bootstrap.groovy" )

Properties props = new Properties()

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
  
target(default:"Initialize DBDeploy") {
	populateProperties ()
	
	ant.sequential {
		sql(driver:props.'db.driver', url:props.'db.url', userid:props.'db.username', password:props.'db.password'){
			fileset(file:'${basedir}/grails-app/dbdeploy/createSchemaVersionTable.ora.sql')
		}
	}	

}