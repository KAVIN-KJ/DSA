class Student:
    def __init__(self,name,age):
        self.name = name
        self.age = age
    
    def display(self):
        print(f"Name : {self.name} and Age : {self.age}")
    
students = [Student("KJKR",21),Student("Kavin",21),Student("AJ",21),Student("NSK",21)]

for i in students:
    i.display()
    
    
class account:
    def __init__(self,amt):
        self.__balance = amt
    
    def deposit(self,amt):
        self.__balance+=amt
    
    def getBalance(self):
        print(self.__balance)

a1 = account(200)
a1.deposit(1500)
a1.getBalance()