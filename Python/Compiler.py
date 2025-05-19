import os
filename = "demo.py"

script = input("Enter a one line python script ")

with open("./Python/demo.py","w") as file:
    file.write(script)
    

os.system(f"python3 ./Python/{filename}")