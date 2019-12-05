import json
import mysql.connector as mysql


def createTables(Assistant):
    Assistant.execute("show Databases")



def main():
    # Load the keys for the MySql Database

    File = open("../Keys/Setup.config").readlines()
    host = File.pop(0)
    port = File.pop(0)
    user = File.pop(0)
    passwd = File.pop(0)
    database = File.pop(0)

    print("------------------------------------------------------")
    print("Connecting to Database: " + host + " as " + user)
    print("Password: " + passwd)
    print("------------------------------------------------------")

    Database = mysql.connect(
        host=host,
        port=port,
        user=user,
        passwd=passwd,
        database=database
        # auth_plugin='mysql_native_password'
    )

    Assistant = Database.cursor()

    createTables(Assistant)

# Load the Data from the Source Folder
    Files = []
    Files.append(open("./Data/RC_2007-10"))
    Files.append(open("./Data/RC_2011-07"))
    Files.append(open("./Data/RC_2012-12"))

# Load the Data from the given File
    for File in Files:
        datenpunkt = File.readlines()
        for data in datenpunkt:
            encoded = json.loads(data)
            # print (encoded["author"])
            DataToSQLServer(encoded, Database)




# ------------------------------------------------ #

# transfers the given Data to the SQL Server
def DataToSQLServer(JSONFile, DatabaseAssistant):
    pass

# ------------------------------------------------ #


main()
# database = JoinDatabase()





