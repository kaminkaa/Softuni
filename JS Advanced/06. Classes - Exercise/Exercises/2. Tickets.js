function solve(tickets,sortCriteria) {
    class Ticket {
        constructor (destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let registeredTickets = [];

    for (let ticket of tickets) {
        let [destination,price,status] = ticket.split('|');
        let newTicket = new Ticket(destination,Number(price),status);
        registeredTickets.push(newTicket);
    }

    switch (sortCriteria){
        case 'destination':
            registeredTickets = registeredTickets.sort((t1,t2) => t1.destination.localeCompare(t2.destination));
            break;
        case 'status':
            registeredTickets = registeredTickets.sort((t1,t2) => t1.status.localeCompare(t2.status));
            break;
        case 'price':
            registeredTickets = registeredTickets.sort((t1,t2) => t1.price - t2.price);
            break;
    }

    return registeredTickets;
}

console.log(solve(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination'
));