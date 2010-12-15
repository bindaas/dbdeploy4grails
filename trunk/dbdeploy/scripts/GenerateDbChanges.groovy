import com.dbdeploy.exceptions.UsageException
import com.dbdeploy.DbDeploy
import com.dbdeploy.DbDeployCommandLineParser

def dbUser = 'TRACKINGDBD'
def dbPassword = 'l0bst3r'
def dbURL = 'jdbc:oracle:thin:@localhost:1521:XE'
def dbSID ='XE'
def outputFle = 'consolidated_script.sql'
def applyChanges = 'true'
def dbDriver = 'oracle.jdbc.driver.OracleDriver'
def dbType = 'ora'
def scripts = '/my/SourceCode/tracking-platform/scripts/sql'

def params = ['-U' ,dbUser,'-P', dbPassword,'-D' ,dbDriver,'-u' ,dbURL,'-d', dbType ,'-o' ,outputFle,'-s' ,scripts ] as String[]

DbDeployCommandLineParser commandLineParser = new DbDeployCommandLineParser();
DbDeploy dbDeploy = new DbDeploy();
commandLineParser.parse(params, dbDeploy);
dbDeploy.go();

target(default:"Do nothing target") {
}