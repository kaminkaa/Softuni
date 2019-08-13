// sorting nested maps:
function solve(arrStr) {
    let systemComponents = new Map();

    for (let current of arrStr) {
        let [name,componentName,subcomponentName] = current.split(' | ');

        if(!systemComponents.has(name)) {
            systemComponents.set(name, new Map());
        }

        if(!systemComponents.get(name).has(componentName)) {
            systemComponents.get(name).set(componentName,[]);
        }

        systemComponents.get(name).get(componentName).push(subcomponentName);
    }

    // sorting the systems:
    // sort by amount of components in descending order as first criteria, and alphabetically as second criteria
    systemComponents = new Map([...systemComponents].sort((x,y) => {
        if ([...x[1]].length === [...y[1]].length) {
            if (x[0] > y[0]) {
                return 1
            }
            if (x[0] < y[1]) {
                return -1
            }
            return 0
        }

        return [...x[1]].length > [...y[1]].length ? -1 : 1;
    }));

    // sorting the components:
    // sort by amount of subcomponents in descending order
    for (let [component, subComponents] of systemComponents) {
        systemComponents.set(component, new Map([...subComponents]
            .sort((x, y) => [...y[1]].length - [...x[1]].length)));
    }

    for (const [system, components] of systemComponents) {
        console.log(system);
        for (const [component, subComponents] of components) {
            console.log(`|||${component}`)
            for (const subComponent of subComponents) {
                console.log(`||||||${subComponent}`)
            }
        }
    }
}

solve(['SULS | Main Site | Home Page' ,
'SULS | Main Site | Login Page' ,
'SULS | Main Site | Register Page' ,
'SULS | Judge Site | Login Page' ,
'SULS | Judge Site | Submittion Page' ,
'Lambda | CoreA | A23' ,
'SULS | Digital Site | Login Page' ,
'Lambda | CoreB | B24' ,
'Lambda | CoreA | A24' ,
'Lambda | CoreA | A25' ,
'Lambda | CoreC | C4' ,
'Indice | Session | Default Storage' ,
'Indice | Session | Default Security']);