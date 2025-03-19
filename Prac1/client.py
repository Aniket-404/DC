import xmlrpc.client

# Connect to the server
server = xmlrpc.client.ServerProxy("http://localhost:8000/")

# Take user input
num = int(input("Enter an integer to calculate factorial: "))

# Request factorial computation from server
try:
    result = server.factorial(num)
    print(f"Factorial of {num} is: {result}")
except Exception as e:
    print(f"Error: {e}")
