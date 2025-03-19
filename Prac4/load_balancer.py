import random
import threading
import time

# Server class to handle requests
class Server:
    def __init__(self, server_id):
        self.server_id = server_id
        self.active_connections = 0  # Track active connections

    def handle_request(self, request_id):
        """ Simulate processing a request """
        self.active_connections += 1
        print(f"Server {self.server_id} handling request {request_id} | Active connections: {self.active_connections}")
        time.sleep(random.uniform(1, 3))  # Simulate processing time
        self.active_connections -= 1
        print(f"Server {self.server_id} finished request {request_id} | Active connections: {self.active_connections}")

# LoadBalancer class implementing different algorithms
class LoadBalancer:
    def __init__(self, servers, algorithm="round_robin"):
        self.servers = servers
        self.algorithm = algorithm
        self.current_index = 0  # For round-robin

    def distribute_request(self, request_id):
        """ Select a server based on the algorithm and assign a request """
        if self.algorithm == "round_robin":
            server = self.round_robin()
        elif self.algorithm == "least_connections":
            server = self.least_connections()
        elif self.algorithm == "random":
            server = self.random_selection()
        else:
            raise ValueError("Unknown algorithm")

        # Simulate sending request to the chosen server using threading
        threading.Thread(target=server.handle_request, args=(request_id,)).start()

    def round_robin(self):
        """ Select servers in circular order """
        server = self.servers[self.current_index]
        self.current_index = (self.current_index + 1) % len(self.servers)
        return server

    def least_connections(self):
        """ Select the server with the least active connections """
        return min(self.servers, key=lambda server: server.active_connections)

    def random_selection(self):
        """ Select a server randomly """
        return random.choice(self.servers)

# Main execution
if __name__ == "__main__":
    num_servers = 3  # Define number of servers
    servers = [Server(i) for i in range(num_servers)]  # Create server instances
    algorithm = "round_robin"  # Change to "least_connections" or "random" for different algorithms

    load_balancer = LoadBalancer(servers, algorithm)  # Initialize load balancer

    num_requests = 10  # Total client requests
    for request_id in range(1, num_requests + 1):
        time.sleep(random.uniform(0.5, 1.5))  # Simulate time between client requests
        load_balancer.distribute_request(request_id)
