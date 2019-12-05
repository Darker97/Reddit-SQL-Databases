import json
import mysql.connector as mysql


def createTables(Assistant):
    Assistant.execute("show Databases")



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

    Assistant = Database.cursor()

    createTables(Assistant)

# ------------------------------------------------ #


main()
# database = JoinDatabase()





