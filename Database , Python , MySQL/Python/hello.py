#!"C:\Python\python.exe"

# she bang: Python interpreter
#enable debugging
##import cgitb
##import cgi
##cgitb.enable()
##
##print("Content-Type: text/html;charset-utf-8")
##print()
##
##print("<html><body bgcolor='#ffccff'>")
##form = cgi.FieldStorage()
##print("<p>name:", form["name"].value)  # need ?name=Michael at end of url
##print("<p>id:", form["id"].value) #follow ?name=Michael with &id=1816337 to make
##                                        # ?name=Michael&id=1816337
##print(", Hello World AGAIN!</body></html>")
##


#--------------------------------------------------------------------------------

#enable debugging
import cgitb
cgitb.enable()

print("Content-Type: text/html;charset-utf-8")
print()
print("<html><body bgcolor='#ffccff'>Hello World AGAIN!</body></html>")

#--------------------------------------------------------------------------------

#enable debugging
##import cgitb
##cgitb.enable()
##
##print("Content-Type: text/plain;charset-utf-8")
##print()
##print("Hello World AGAIN!")

#---------------------------------------------------------------------------------

# enable debugging
##import cgi
##import cgitb
##cgitb.enable()
##
### 1.	HTTP Response header in name-value pairs.
### 2.	An empty line
### 3.	HTTP Response body (optional)
### MIME type
##
##print("Content-Type: text/html;charset=utf-8") # HTTP Response Header
##print() # Blank Line
##
##print("<html><body bgcolor='#ffccff'>")
##form = cgi.FieldStorage()
##print("<p>name:", form["name"].value)
##print("<p>id:", form["id"].value)
##print(", Hello World again!</body></html>") # HTTP Response Body

