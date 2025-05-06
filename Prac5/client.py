import Pyro5.api

# Replace this URI with the one printed by the server
uri = input("Enter the server URI: ")
hotel = Pyro5.api.Proxy(uri)

while True:
    print("\n1. Book Room\n2. Cancel Booking\n3. Exit")
    choice = input("Enter choice: ")
    if choice == "1":
        name = input("Enter guest name: ")
        room = input("Enter room number: ")
        print(hotel.book_room(name, room))
    elif choice == "2":
        name = input("Enter guest name to cancel: ")
        print(hotel.cancel_booking(name))
    else:
        break
