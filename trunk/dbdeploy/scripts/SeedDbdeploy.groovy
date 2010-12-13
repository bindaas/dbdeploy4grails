def ant = new AntBuilder()
ant.sequential {
	sql(driver:'oracle.jdbc.driver.OracleDriver', url:'jdbc:oracle:thin:@localhost:1521:XE',userid:'trackingdbd',password:'l0bst3r'){
	fileset(file:'createSchemaVersionTable.ora.sql')
}
