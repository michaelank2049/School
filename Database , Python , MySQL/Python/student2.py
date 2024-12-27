import pymysql
import sys

#   Use the school code in command line arguments
#   to list all students majoring in a department
#   in the school.
# [1] Making connection to the MySQL server
cnx = pymysql.connect(user='lankfordm0772', password='Aggie1510800',
    host='localhost',
    database='toyu')

# Create a cursor using the connection.
cursor = cnx.cursor()

# [2] Prepare a SQL query for the problem
query = '''
SELECT CONCAT (s.fname, ' ', s.lname) AS student,
    d.deptName,
    CONCAT(f.fname, ' ', f.lname) as advisor
FROM student AS s LEFT JOIN department AS d
        ON (s.major = d.deptCode)
     LEFT JOIN faculty AS f
        ON (s.advisor = f.facId)
WHERE d.schoolCode = %s;
'''

# [2b] Get input values
school_code = sys.argv[1]

# Execute the query
cursor.execute(query, (school_code,))

# [3] Use the result in the query
for (student, major, advisor) in cursor:
    print("{}: major={}; advisor={}".format(student, major, advisor))

# [4] Housekeeping
cursor.close()
cnx.close()
