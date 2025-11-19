"""-
-->The upper() method returns the string in upper case:     
--.>The lower() method returns the string in lower case:
-->The strip() method removes any whitespace from the beginning or the end:
-->The replace() method replaces a string with another string:
-->The replace() method replaces a string with another string:
-->The split() method returns a list where the text between the specified separator becomes the list items.
"""

a = "Hello, World!"
print(a.upper())    
a = "Hello, World!"
print(a.lower())
a = " Hello, World! "
print(a.strip()) # returns "Hello, World!"

a = "Hello, World!"
print(a.replace("H", "J"))

a = "Hello, World!"
print(a.replace("H", "J"))

a = "Hello, World!"
print(a.split(",")) # returns ['Hello', ' World!']
