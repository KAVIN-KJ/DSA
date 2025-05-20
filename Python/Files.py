# create a new file or override if it exists

content = "🔥 Your Turn!1️⃣ Write a Python script that creates a file called numbers.txt and writes numbers from 1 to 10, each on a new line\n.2️⃣ Read and print all numbers from numbers.txt.Once you’re done, we move to OOP (Classes & Objects)! 🚀"

# Writing and reading files

with open("./Python/newfile.txt","w") as file:
    file.write(content)


with open("./Python/newfile.txt","r") as file:
    content = file.read()
    
print(content)

# APPEND STUFF TO AN EXISTING FILE
append = "\n\nthis content is being appended to the text file !!ASDHFLKSHFLSDHLFSHFLJSDHFLHSDFLSDHFLDKSHFGKLDSFHGKR XD"

with open('./Python/newfile.txt','a') as file:
    file.write(append)

# writing and reading lists (data structure) into files

data = ["KJKR\n","AJ\n","NSK\n"]

with open('data.txt','w') as file:
    file.writelines(data)
    
readData = None
with open('data.txt','r') as file:
    readData = file.readlines()

print(readData)


# upload dictionaries as json to files

import json

# student = {
#     "name":"KJKR",
#     "age":20,
#     "Department":"ECE",
#     "College":"SKCT",
#     "Reg_No":"727822tuec104"
# }

# with open("./Python/dictionary.txt","w") as file:
#     json.dump(student,file)

with open("./Python/dictionary.txt","r") as file:
    readData = json.load(file)

print(readData)