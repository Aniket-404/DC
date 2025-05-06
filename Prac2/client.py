import Pyro5.api

def main():
    uri = input("Enter the server object URI: ")  # e.g. PYRO:obj_xxxxx@localhost:xxxx
    server = Pyro5.api.Proxy(uri)

    str1 = input("Enter first string: ")
    str2 = input("Enter second string: ")
    result = server.concatenate(str1, str2)
    print("Concatenated string:", result)

if __name__ == "__main__":
    main()
