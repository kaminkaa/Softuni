function calculateConeVolumeAndArea(r, h) {
    let volume = (1/3) * Math.PI * r * r * h;
    let area = Math.PI * r * (r + Math.sqrt(r * r + h * h));

    console.log('volume = ' + volume);
    console.log('area = ' + area);
}

calculateConeVolumeAndArea(3,5);