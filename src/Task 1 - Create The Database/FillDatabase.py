import json
# import mysql


def main():
    # Load the keys for the MySql Database

    File = open("../Keys/Setup.config").readlines()
    host = File[0]
    user = File[1]
    passwd = File[2]

    Database = ""

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
            print (encoded["author"])
            DataToSQLServer(encoded, Database)


# ------------------------------------------------ #

# transfers the given Data to the SQL Server
def DataToSQLServer(JSONFile, Database):


# ------------------------------------------------ #


main()
# database = JoinDatabase()





