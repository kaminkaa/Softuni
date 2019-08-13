// regex:
function solve(arrStr) {
    let nums = [];
    let regex = /[\d]+/g;

    for (let str of arrStr) {
        let match = regex.exec(str);
        while (match) {
            nums.push(match);
            match = regex.exec(str);
        }
    }

    console.log(nums.join(' '));
}

solve(['The300',
'What is that?',
'I think it’s the 3rd movie.',
'Lets watch it at 22:45']);

solve(['123a456',
'789b987',
'654c321',
'0']);