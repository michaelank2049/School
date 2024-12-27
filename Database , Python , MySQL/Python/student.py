#!"C:\Python\python.exe"
import cgi
import cgitb
cgitb.enable()
# Import pymysql connector to MySQL
##from dbconfig import *
import pymysql

##db = get_mysql_param(filename='dbconfig.ini')
cnx = pymysql.connect(user=db['lankfordm0772'], password=db['Aggie1510800'],
                      host=db['localhost'],
                      database=db['SWIM'])#,
                    #  port=int(db['port']))
cursor = cnx.cursor()

#   cgi: Support module for Common Gateway Interface (CGI) scripts.
#   cgitb: Traceback manager for CGI scripts
#   cgitb.enable(): enable trace back feature

#   Minimal HTTP Response Header information for
#   delivering HTML content
print("Content-Type: text/html;charset=utf-8")

#   A blank line as the separator of HTTP Response header and body.
print()

print ('''<html>
<head></head>
<body>
''')

query = '''
SELECT DISTINCT s.lname, s.fname, COUNT(e.classId) AS numClasses
FROM student AS s LEFT JOIN enroll AS e ON (s.stuId = e.stuId)
GROUP BY s.lname, s.fname;
'''

cursor.execute(query)

#   Read data and generate code for a HTML table.
print('''
<table border='1'>
<tr><th>Student</th><th>Number of classes</th></tr>
''')

for (lname, fname, numClasses) in cursor:
    print("<tr><td>{} {}</td><td>{}</td></tr>".format(lname, fname, numClasses))

cursor.close()
cnx.close()

print ('''
</table>
</body>
</html>
''')
