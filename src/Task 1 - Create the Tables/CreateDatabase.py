import json
import mysql.connector as mysql
import time



def createTables(Assistant):
    print("Starting to execute the file")
    File = open("querys.sql")
    Querys = File.read()
    Assistant.execute(Querys)



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

# Checks if the Connection is established. If not, we wait.
def startFile():
    try:
        data = main()
        if data.is_connected():
            createTables(data.cursor())
            print("------------------------------------------------------")
            print("Tables Are Created!!!")
            print("------------------------------------------------------")
    except:
        print("------------------------------------------------------")
        print()
        print("Proceeding...")
        time.sleep(60)
        print("Trying again")
        print("------------------------------------------------------")
        startFile()

# ------------------------------------------------ #


startFile()
# database = JoinDatabase()





