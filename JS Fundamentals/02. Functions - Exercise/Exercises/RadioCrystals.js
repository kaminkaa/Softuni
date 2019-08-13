function solve(input) {

    let targetThickness = input[0];

    for (let i = 1; i < input.length; i++) {
        console.log('Processing chunk ' + input[i] + ' microns');
        processingCrystal(targetThickness, input[i]);
    }

    function processingCrystal(targetThickness, thickness) {

        let cut = function (thickness) { return thickness/4 };
        let lap = function (thickness) { return thickness - 0.2 * thickness };
        let grind = function (thickness) { return thickness - 20 };
        let etch = function (thickness) { return thickness - 2 };
        let xray = function (thickness) { console.log('X-ray x1'); return thickness + 1 };
        let transportingWashing = function (thickness) { console.log('Transporting and washing'); return Math.floor(thickness) };

        let oneMicronDifference = false;

        // xray operation:
        if (thickness < targetThickness) {
            thickness = xray(thickness);
            console.log('Finished crystal ' + thickness + ' microns');
            return;
        }

        // cut operation:
        let tempThickness = cut(thickness);

        let countCut = 0;
        while (tempThickness >= targetThickness) {
            countCut++;
            thickness = tempThickness;
            tempThickness = cut(thickness);
        }

        if (targetThickness - tempThickness === 1) {
            countCut++;
            thickness = tempThickness;
            oneMicronDifference = true;
        }

        if (countCut !== 0) {
            console.log('Cut x' + countCut);
            thickness = transportingWashing(thickness);
        }

        if (oneMicronDifference) {
            thickness = xray(thickness);
        }

        if (thickness === targetThickness) {
            console.log('Finished crystal ' + thickness + ' microns');
            return;
        } else {
            tempThickness = lap(thickness);
        }

        // lap operation:
        let countLap = 0;
        while (tempThickness >= targetThickness) {
            countLap++;
            thickness = tempThickness;
            tempThickness = lap(thickness);
        }

        if (targetThickness - tempThickness === 1) {
            countLap++;
            thickness = tempThickness;
            oneMicronDifference = true;
        }

        if (countLap !== 0) {
            console.log('Lap x' + countLap);
            thickness = transportingWashing(thickness);
        }

        if (oneMicronDifference) {
            thickness = xray(thickness);
        }

        if (thickness === targetThickness) {
            console.log('Finished crystal ' + thickness + ' microns');
            return;
        } else {
            tempThickness = grind(thickness);
        }

        // grind operation:
        let countGrind = 0;
        while (tempThickness >= targetThickness) {
            countGrind++;
            thickness = tempThickness;
            tempThickness = grind(thickness);
        }

        if (targetThickness - tempThickness === 1) {
            countGrind++;
            thickness = tempThickness;
            oneMicronDifference = true;
        }

        if (countGrind !== 0) {
            console.log('Grind x' + countGrind);
            thickness = transportingWashing(thickness);
        }

        if (oneMicronDifference) {
            thickness = xray(thickness);
        }

        if (thickness === targetThickness) {
            console.log('Finished crystal ' + thickness + ' microns');
            return;
        } else {
            tempThickness = etch(thickness);
        }

        // etch operation:
        let countEtch = 0;
        while (tempThickness >= targetThickness) {
            countEtch++;
            thickness = tempThickness;
            tempThickness = etch(thickness);
        }

        if (targetThickness - tempThickness === 1) {
            countEtch++;
            thickness = tempThickness;
            oneMicronDifference = true;
        }

        if (countEtch !== 0) {
            console.log('Etch x' + countEtch);
            thickness = transportingWashing(thickness);
        }

        if (oneMicronDifference) {
            thickness = xray(thickness);
        }

        if (thickness === targetThickness) {
            console.log('Finished crystal ' + thickness + ' microns');
        }

    }
}

solve([10001, 10000]);