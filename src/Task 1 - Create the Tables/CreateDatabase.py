import json
import mysql.connector as mysql
import time



def createTables(Assistant):
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

    return Database


def startFile():
    while True:
        data = main()
        if data.is_connected():
            createTables()
            print("------------------------------------------------------")
            print("Tables Are Created!!!")
            print("------------------------------------------------------")
            break
        else:
            print("------------------------------------------------------")
            print("Connection is not established!")
            print("Proceeding...")
            time.sleep(60)
            print("Trying again")
            print("------------------------------------------------------")


# ------------------------------------------------ #


startFile()
# database = JoinDatabase()





