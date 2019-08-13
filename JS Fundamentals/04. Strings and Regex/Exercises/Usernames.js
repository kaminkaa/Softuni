function solve(emails) {
    let result = [];

    for (let email of emails) {
        let [alias, domain] = email.split('@');

        let username = alias + '.';

        let domainParts = domain.split('.');
        domainParts.forEach(p => username += p[0]);
        result.push(username);
    }

    console.log(result.join(', '));
}

solve(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com']);