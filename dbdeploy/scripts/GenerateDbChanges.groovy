import com.dbdeploy.exceptions.UsageException
import com.dbdeploy.DbDeploy
import com.dbdeploy.DbDeployCommandLineParser

def dbUser = '?'
def dbPassword = '?'
def dbURL = 'jdbc:oracle:thin:@localhost:1521:XE'
def dbSID ='XE'
def outputFle = 'consolidated_script.sql'
def applyChanges = 'true'
def dbDriver = 'oracle.jdbc.driver.OracleDriver'

def params = ['-U' ,dbUser,'-P', dbPassword,'-D' ,dbDriver,'-u' ,dbURL,'-d', 'ora' ,'-o' ,outputFle,'-s' ,'/my/SourceCode/tracking-platform/scripts/sql'] as String[]

DbDeployCommandLineParser commandLineParser = new DbDeployCommandLineParser();
DbDeploy dbDeploy = new DbDeploy();
commandLineParser.parse(params, dbDeploy);
dbDeploy.go();
