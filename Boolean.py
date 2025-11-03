"""
    When you compare two values, you need to know true or false we can you the Boolean 
    True or False
    """
print(10 > 9) #true 
print(10 == 9) #Flase
print(10 < 9) #Flase

#Using the if else Condition    
a = 200
b = 33

if b > a:
  print("b is greater than a") 
else:
  print("b is not greater than a") #false print this line 

#Evaluate Values and Variables
print(bool("Hello")) #True 
print(bool(15)) #False
print(bool(""))#False
print(bool())#False
a="Hello"
b=15
print(bool(a))
print(bool(b))