from xmlrpc.server import SimpleXMLRPCServer
import logging

# Enable logging
logging.basicConfig(level=logging.INFO)

# Function to compute factorial
def factorial(n):
    if n < 0:
        return "Error: Factorial of negative numbers is not defined."
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

# Create an RPC server
server = SimpleXMLRPCServer(("localhost", 8000), allow_none=True)
logging.info("RPC Server is running on port 8000...")

# Register the factorial function
server.register_function(factorial, "factorial")

# Run the server
server.serve_forever()
