function solve(kingdomsInput, fightingInfo) {
    let kingdoms = new Map();

    // store the information about the kingdoms:
    for (let kingdomInput of kingdomsInput) {
        let kingdom = kingdomInput.kingdom;
        let general = kingdomInput.general;
        let army = kingdomInput.army;

        if (!kingdoms.has(kingdom)) {
            kingdoms.set(kingdom, new Map());
        }
        if (!kingdoms.get(kingdom).has(general)) {
            kingdoms.get(kingdom).set(general,{army: 0, wins: 0, loses: 0});
            kingdoms.get(kingdom).get(general).army = army;
        } else {
            kingdoms.get(kingdom).get(general).army += army;
        }
    }

    // start the battles:
    for (let currentFight of fightingInfo) {
        let attackingKingdom = currentFight[0];
        let attackingGeneral = currentFight[1];
        let defendingKingdom = currentFight[2];
        let defendingGeneral = currentFight[3];

        if (attackingKingdom === defendingKingdom) {
            continue;
        }

        // comparing armies:
        if (kingdoms.get(attackingKingdom).get(attackingGeneral).army > kingdoms.get(defendingKingdom).get(defendingGeneral).army) {
            // attackingKingdom winner:
            kingdoms.get(attackingKingdom).get(attackingGeneral).army += kingdoms.get(attackingKingdom).get(attackingGeneral).army * 0.1;
            kingdoms.get(attackingKingdom).get(attackingGeneral).army = Math.floor(kingdoms.get(attackingKingdom).get(attackingGeneral).army);
            kingdoms.get(attackingKingdom).get(attackingGeneral).wins ++;
            // defendingKingdom loser:
            kingdoms.get(defendingKingdom).get(defendingGeneral).army -= kingdoms.get(defendingKingdom).get(defendingGeneral).army * 0.1;
            if (kingdoms.get(defendingKingdom).get(defendingGeneral).army < 0) {kingdoms.get(defendingKingdom).get(defendingGeneral).army = 0;}
            kingdoms.get(defendingKingdom).get(defendingGeneral).army = Math.floor(kingdoms.get(defendingKingdom).get(defendingGeneral).army);
            kingdoms.get(defendingKingdom).get(defendingGeneral).loses ++;
        } else if (kingdoms.get(defendingKingdom).get(defendingGeneral).army > kingdoms.get(attackingKingdom).get(attackingGeneral).army) {
            // defendingKingdom winner:
            kingdoms.get(defendingKingdom).get(defendingGeneral).army += kingdoms.get(defendingKingdom).get(defendingGeneral).army * 0.1;
            kingdoms.get(defendingKingdom).get(defendingGeneral).army = Math.floor(kingdoms.get(defendingKingdom).get(defendingGeneral).army);
            kingdoms.get(defendingKingdom).get(defendingGeneral).wins ++;
            // attackingKingdom loser:
            kingdoms.get(attackingKingdom).get(attackingGeneral).army -= kingdoms.get(attackingKingdom).get(attackingGeneral).army * 0.1;
            kingdoms.get(attackingKingdom).get(attackingGeneral).army = Math.floor(kingdoms.get(attackingKingdom).get(attackingGeneral).army);
            if (kingdoms.get(attackingKingdom).get(attackingGeneral).army < 0) {kingdoms.get(attackingKingdom).get(attackingGeneral).army = 0;}
            kingdoms.get(attackingKingdom).get(attackingGeneral).loses ++;
        }
    }

    // find the winner:
    let result = new Map();
    for (let [kingdom,generalInfo] of kingdoms) {
        let w = 0;
        let l = 0;
        for (let [general,info] of generalInfo) {
            w += info.wins;
            l += info.loses;
        }
        //result.set(kingdom,{wins: w, losses: l});
        result.set(kingdom,[w,l]);
    }


     result = [...result].sort((k1,k2) => {
        if (k1.valueOf()[1][0] === k2.valueOf()[1][0]) {
            if (k1.valueOf()[1][1]=== k2.valueOf()[1][1]) {
                if (k1[0] > k2[0]) {
                    return 1;
                }
                if (k1[0] < k2[1]) {
                    return -1;
                }
                return 0;
            } else {
                // order by losses ascending:
                return k1.valueOf()[1][1] > k2.valueOf()[1][1] ? 1 : -1;
            }
        } else {
            // order by wins descending:
           // console.log(result.get(k1)[0] + ' ' + result.get(k2)[0]);
            return k1.valueOf()[1][0] > k2.valueOf()[1][0] ? -1 : 1;
        }
    });

    let winningKingdom = result[0][0];
    console.log('Winner: ' + winningKingdom);

    // sort the generals:
    let generals = Array.from(kingdoms.get(winningKingdom));
    generals = generals.sort((g1,g2) => {
        return g1[1] > g2[1] ? -1 : 1;
    });
    for (let general of generals) {
        console.log(`/\\general: ` + general[0]);
        console.log(`---army: ` + general[1].army);
        console.log(`---wins: ` + general[1].wins);
        console.log(`---losses: ` + general[1].loses);
    }
}

solve([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
        { kingdom: "Stonegate", general: "Ulric", army: 4900 },
        { kingdom: "Stonegate", general: "Doran", army: 70000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 0 },
        { kingdom: "YorkenShire", general: "Quinn", army: 2000 },
        { kingdom: "Maiden Way", general: "Berinon", army: 100000 } ],
    [ ["YorkenShire", "Quinn", "Maiden Way", "Berinon"],
        ["Maiden Way", "Merek", "YorkenShire", "Quinn"] ]);

/*solve([ { kingdom: "Stonegate", general: "Ulric", army: 5000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 5000 },
        { kingdom: "Maiden Way", general: "Berinon", army: 1000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
        ["Maiden Way", "Berinon", "YorkenShire", "Quinn"] ]);

solve([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
        { kingdom: "Stonegate", general: "Ulric", army: 4900 },
        { kingdom: "Stonegate", general: "Doran", army: 70000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 0 },
        { kingdom: "YorkenShire", general: "Quinn", army: 2000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Doran"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"] ]);*/