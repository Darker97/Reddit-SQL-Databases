import json
import mysql.connector as mysql
import time
from tqdm import tqdm
import sys


def createData(Assistant):
    # Load the Data from the Source Folder
    Files = []
    Files.append(open("./Data/RC_2007-10"))
    Files.append(open("./Data/RC_2011-07"))
    Files.append(open("./Data/RC_2012-12"))

    USER_ID = 0

    # Load the Data from the given File
    for File in Files:
        datenpunkt = File.readlines()

        for data in tqdm(datenpunkt, desc=File.name):
            encoded = json.loads(data)
            # print(encoded["author"])
            USER_ID += 1
            # print (encoded["author"])
            DataToSQLServer(encoded, Assistant, USER_ID)
        print("End of File %s, starting second", File.name)
        print("Starting next...")
        print("--------------------------------------------------")


def main():
    # Load the keys for the MySql Database

    File = open("Setup.config").readlines()
    host = File.pop(0)
    port = File.pop(0)
    user = File.pop(0)
    passwd = File.pop(0)
    database = File.pop(0)

    print("------------------------------------------------------")
    print("Connecting to Database: " + host + " as " + user + " on port " + port)
    print("Password: " + passwd)
    print("------------------------------------------------------")

    Database = mysql.connect(
        host=host,
        port=port,
        user=user,
        # passwd=passwd,
        # unix_socket="../var/run/mysqld/mysqld.sock",
        database=database
        # auth_plugin='mysql_native_password'
    )

    return Database

# ------------------------------------------------ #
# Checks if the Connection is established. If not, we wait.
def startFile():
    time.sleep(20)
    try:
        data = main()
        if data.is_connected():
            if checkTableExists(data, "users"):
                checkIfTablesAreFull(data)
                createData(data)
                print("------------------------------------------------------")
                print("Data is inserted")
                print("------------------------------------------------------")
            else:
                print("------------------------------------------------------")
                print("Tables do not exist yet!!!")
                print("Proceeding...")
                time.sleep(60)
                print("Trying again")
                print("------------------------------------------------------")
    except:
        print("------------------------------------------------------")
        print("Connection is not established!")
        print("Proceeding...")
        time.sleep(60)
        print("Trying again")
        print("------------------------------------------------------")
        startFile()


# ------------------------------------------------ #
def checkTableExists(dbcon, tablename) -> bool:
    dbcur = dbcon.cursor()
    dbcur.execute("""
        SELECT COUNT(*)
        FROM information_schema.tables
        WHERE table_name = '{0}'
        """.format(tablename.replace('\'', '\'\'')))
    if dbcur.fetchone()[0] == 1:
        dbcur.close()
        return True
    dbcur.close()
    return False

def checkIfTablesAreFull(dbase):
    dbcurso = dbase.cursor()
    dbcurso.execute("""
        SELECT COUNT(*)
        FROM reddit.User
        """)
    if dbcurso.fetchone().count > 2:
        sys.exit(0)
    else:
        pass

# transfers the given Data to the SQL Server
def DataToSQLServer(JSONFile, DatabaseAssistant, USER_ID):

    ID = str(JSONFile["id"])
    name = str(JSONFile["name"])
    parentID = str(JSONFile["parent_id"])
    body = str(JSONFile["body"])
    ups = str(JSONFile["ups"])
    downs = str(JSONFile["downs"])
    created = str(JSONFile["created_utc"])
    conttiversiality = str(JSONFile["controversiality"])
    Archived = JSONFile["archived"]
    USER =  str(JSONFile["author"])
    SUBREDDIT =  str(JSONFile["subreddit"])
    Subbredit_ID = str(JSONFile["subreddit_id"])

    querySubreddits = """INSERT INTO Reddit.Subreddits (Name, Subreddit_id) 
                            VALUES (%s, %s)"""
    try:
        DatabaseAssistant.cursor().execute(querySubreddits, (SUBREDDIT, Subbredit_ID))
    except:
        # print("----------------->DOUBLE SUP")
        pass
    queryComments ="""INSERT INTO Reddit.Comments (ID, name, parentID, body ,ups ,downs , created, conttiversiality, Archived ,USER, SUBREDDIT) 
                        VALUES ( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"""

    try:
        DatabaseAssistant.cursor().execute(queryComments, (ID, name, parentID, body, ups, downs, created, conttiversiality, Archived, USER, SUBREDDIT))
    except:
        # print("----------------->DOUBLE COMMENTS<-----------------")
        pass
    USER_ID += 1

    queryUsers = """INSERT INTO Reddit.User (ID, Name) 
                        VALUES (%s,%s)"""
    try:
        DatabaseAssistant.cursor().execute(queryUsers, (str(USER_ID), USER))
    except:
        # print("----------------->DOUBLEUSER")
        pass
# ------------------------------------------------ #


startFile()
# database = JoinDatabase()





