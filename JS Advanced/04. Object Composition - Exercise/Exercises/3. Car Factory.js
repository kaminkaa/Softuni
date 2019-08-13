function solve(order) {
    let car = {
        model: order.model,
        engine: selectEngine(order.power),
        carriage: { type: order.carriage, color: order.color },
        wheels: getWheels (order.wheelsize)
    };

    return car;

    function selectEngine(requestedPower) {
        let pow, vol;
        if (requestedPower <= 90){
            pow = 90;
            vol = 1800;
        } else if (requestedPower > 90 && requestedPower <= 120) {
            pow = 120;
            vol = 2400;
        } else if (requestedPower > 120 && requestedPower <= 200) {
            pow = 200;
            vol = 3500;
        }
        return {power: pow, volume: vol};
    }

    function getWheels(size) {
        let wheels = [];
        if (size % 2 === 0) {
            size --;
            wheels.push(size); wheels.push(size); wheels.push(size); wheels.push(size);
            return wheels;
        }
        wheels.push(size); wheels.push(size); wheels.push(size); wheels.push(size);
        return wheels;
    }
}

let order = { model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17 }
;

console.log(solve(order));
