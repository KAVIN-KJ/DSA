# used to store key value pairs as in JS objects

student = {
    "name":"KJKR",
    "age":20,
    "Department":"ECE",
    "College":"SKCT",
    "Reg_No":"727822tuec104"
}
print(student)

# we can access elements in a dictionary either by square brackets
print(student["name"])

# or using the get() method
print(student.get("name"))

# use of get method is preferred because if a key doesn't exist [] causes error but get() return 'None'

print(student.get("sldjh"))
# print(student["sldjh"])

print("Print keys alone : ")
for key in student:
    print(key,end=" ")

print("Print keys and values : ")
for key,value in student.items():
    print(key,":",value)

ig = input("Enter your instagram ID")
student["Instagram ID"] = ig



for key,value in student.items():
    print(key,":",value)
    
    
# remove elements from dictionary

student.pop("Instagram ID")

for key,value in student.items():
    print(key,":",value)