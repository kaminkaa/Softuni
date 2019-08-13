function solve(arrStr) {
    let destinations = new Map();
    let airplanes = new Map();
    let destinationsToAirplanes = new Map();

    for (let current of arrStr) {
        let [planeId,town,pCount,action] = current.split(' ');
        let passengersCount = Number(pCount);

        // ako nqmame samoleta v spisuka i ako kaza:
        if (!airplanes.has(planeId) && action.toLowerCase() === 'land') {
            // zapisvame go che kaza:
            airplanes.set(planeId,action.toLowerCase());

            // ako nqmame destinaciata v spisuka:
            if (!destinations.has(town)) {
                let passengersInfo = {arrivals: 0, departures: 0};
                passengersInfo.arrivals = passengersCount;
                destinations.set(town,passengersInfo);
            } else {
                destinations.get(town).arrivals += passengersCount;
            }

            // dobavqne na samoleta kum destinaziata:
            addToDestinationsToAirplanes(town,planeId);
        }

        // ako imame samoleta v spisuka kato kaznal i ako izlita:
        if ((airplanes.has(planeId) && airplanes.get(planeId) === 'land') && action.toLowerCase() === 'depart') {
            // zapisvame go che izlita:
            airplanes.set(planeId,action);

            // ako nqmame destinaciata v spisuka:
            if (!destinations.has(town)) {
                let passengersInfo = {arrvials: 0, departures: 0};
                passengersInfo.departures = passengersCount;
                destinations.set(town,passengersInfo);
            } else {
                destinations.get(town).departures += passengersCount;
            }

            // dobavqne na samoleta kum destinaziata:
            addToDestinationsToAirplanes(town,planeId);
        }

        // ako imame samoleta v spisuka kato izletql i ako kaza:
        if (airplanes.has(planeId) && airplanes.get(planeId) === 'depart' && action.toLowerCase() === 'land')
        {
            // zapisvame go che kaza:
            airplanes.set(planeId,action);

            // ako nqmame destinaciata v spisuka:
            if (!destinations.has(town)) {
                let passengersInfo = {arrivals: 0, departures: 0};
                passengersInfo.arrivals = passengersCount;
                destinations.set(town,passengersInfo);
            } else {
                destinations.get(town).arrivals += passengersCount;
            }

            // dobavqne na samoleta kum destinaziata:
            addToDestinationsToAirplanes(town,planeId);
        }
    }

    function addToDestinationsToAirplanes(town, planeId) {
        // ako do destinaziata nqma poleti:
        if (!destinationsToAirplanes.has(town)) {
            destinationsToAirplanes.set(town, new Set());
            destinationsToAirplanes.get(town).add(planeId);
        } else {
            destinationsToAirplanes.get(town).add(planeId);
        }
    }

    console.log('Planes left:');
    let airplanesIds = Array.from(airplanes.keys()).sort();
    for (let k of airplanesIds) {
        if (airplanes.get(k) === 'land') {
            console.log('- ' + k);
        }
    }

    // sort destinations by number of arrivals descending
    let arrivalsSorted = Array.from(destinations.values()).sort((a, b) => {
        if (a.arrivals > b.arrivals) {
            return -1;
        }
        if (a.arrivals < b.arrivals) {
            return 1;
        }
        return 0;
    });

    for (let currentObj of arrivalsSorted) {
        for (let [k,v] of destinations) {
            if (v === currentObj) {
                console.log(k);
                console.log('Arrivals: ' + v.arrivals);
                console.log('Departures: ' + v.departures);
                console.log('Planes:');
                let planes = destinationsToAirplanes.get(k).sort((x,y) => {
                    if (x[0] > y[0]) {
                        return 1
                    }
                    if (x[0] < y[1]) {
                        return -1
                    }
                    return 0
                });
                for (let plane of planes) {
                    console.log('-- ' + plane);
                }

            }
        }
    }
}

solve([ "Boeing474 Madrid 300 land", "AirForceOne WashingtonDC 178 land",
    "Airbus London 265 depart", "ATR72 WashingtonDC 272 land", "ATR72 Madrid 135 depart"
]);