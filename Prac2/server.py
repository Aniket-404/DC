import Pyro5.api

@Pyro5.api.expose
class StringService:
    def concatenate(self, str1, str2):
        return str1 + str2

def main():
    daemon = Pyro5.api.Daemon()
    uri = daemon.register(StringService)
    print("Ready. Object URI =", uri)
    daemon.requestLoop()

if __name__ == "__main__":
    main()
