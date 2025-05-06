import Pyro5.api

@Pyro5.api.expose
class HotelBookingSystem:
    def __init__(self):
        self.bookings = {}

    def book_room(self, guest_name, room_number):
        if room_number in self.bookings:
            return f"Room {room_number} is already booked."
        self.bookings[room_number] = guest_name
        return f"Room {room_number} successfully booked for {guest_name}."

    def cancel_booking(self, guest_name):
        for room, guest in list(self.bookings.items()):
            if guest == guest_name:
                del self.bookings[room]
                return f"Booking for {guest_name} canceled."
        return f"No booking found for {guest_name}."

def main():
    daemon = Pyro5.api.Daemon()
    uri = daemon.register(HotelBookingSystem)
    print("Ready. URI:", uri)
    daemon.requestLoop()

if __name__ == "__main__":
    main()
