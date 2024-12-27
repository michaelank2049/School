#!"C:\Python\python.exe"

import pymysql
import cgi
import cgitb
cgitb.enable()

# Establish a cursor for MySQL connection.

connection = pymysql.connect(
    user="lankfordm",
    password="Sce1816337!!",
    host="localhost",
    database="SWIM"
)     
cursor = connection.cursor()

# Create HTTP response header

print("Content-Type: text/html;charset=utf-8")
print()

# Create a primitive HTML starter

print ('''<html>
<head></head>
<body>
''')

# Get HTTP parameter, mid(meet id)

form = cgi.FieldStorage()
mid = form.getfirst('mid')

if mid is None:

    # document title

    print('<h3>Information about meets</h3>')     
    print('<ol>')

    # query to get needed information

    query1 = '''SELECT DISTINCT m.meetId, m.Title, COUNT(e.eventId) AS n_events, m.Date, v.Name
        FROM meet AS m INNER JOIN Event AS e ON(m.meetId = e.meetId)
        INNER JOIN Venue AS v ON(m.venueId = v.venueId)
        GROUP BY m.meetId'''
    cursor.execute(query1)

    # for loop to print information on screen

    for(meetId, title, n_events, date, name) in cursor:
        print('<li><a href="?mid=', meetId, '">' + str(title) + '</a>: ' + str(n_events) + ' events on ' + str(date) + ' at ' + str(name) + '.')

    print('</ol>')
    print('</body></html>')
    cursor.close()
    connection.close()		
    quit()

	
if mid is not None:

    # queries for needed information
    
    query2 = '''SELECT DISTINCT l.levelId, l.level, COUNT(e.levelid) as n_levels
        FROM event AS e INNER JOIN level AS l ON(l.levelid= e.levelId)
        WHERE meetid = %s
        GROUP by levelId'''
    query3 = '''SELECT e.eventid, e.title
        FROM event AS e
        WHERE levelid = %s
        AND meetid = %s'''
    query4 = '''SELECT m.title AS mtitle
        FROM meet AS m
        WHERE m.meetId = %s'''

    # print document header
    
    meetId = form['mid'].value
    cursor.execute(query4, (meetId,))
    (mtitle) = cursor.fetchone()

    print('<h3>More information on meet #' + str(mid)[1] + ': ' + str(mtitle)[2:-3] + '</h3>')

    # print document information

    cursor.execute(query2, (meetId,))
    cursor_list = list(cursor)
    print('<ol>')
    
    for (levelId, level, n_levels) in cursor_list:
        print('<li>level ' + str(levelId) + ': ' + str(level) + '; ' + str(n_levels) + ' events<ol>')
        
        cursor.execute(query3, (levelId, meetId,))
        
        for (lvlid, mtid) in cursor:

            print('<li>id: ' + str(lvlid) + ', title: ' + str(mtid) + '</li>')
        print("</ol>")
            
    print("</ol>")

    cursor.close()
    connection.close()
				  
print ('''</body>
</html>''')


