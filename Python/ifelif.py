try:
    x = int(input("Enter your age "))
except ValueError:
    print("Please enter a number !!")
else: 
    if (x < 18 and x>0):
        print("You are underage")
    elif(x>=18):
        print("You are a Major")
    else:
        print("Please enter a valid age !")
