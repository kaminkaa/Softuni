function solution(command) {
    let commands = {
        upvote: () => {
            this.upvotes++;
        },
        downvote: () => {
            this.downvotes++;
        },
        score: () => {
            let currentUpVotes = this.upvotes;
            let currentDownVotes = this.downvotes;
            let totalVotes = currentUpVotes + currentDownVotes;
            let totalScore = currentUpVotes - currentDownVotes;

            let rating = 'new';
            let isNewPost = (totalVotes < 10);
            if (!isNewPost) {
                updateRating();
            }

            if (totalVotes > 50) {
                obfuscatePost();
            }

            return [currentUpVotes, currentDownVotes, totalScore, rating];

            function updateRating() {
                if (currentUpVotes > totalVotes * 0.66) {
                    rating = 'hot';
                } else if ( totalScore >= 0 && (currentUpVotes > 100 || currentDownVotes > 100)) {
                    rating = 'controversial';
                } else if (totalScore < 0) {
                    rating = 'unpopular';
                }
            }
            
            function obfuscatePost() {
                let biggerScore = Math.max(currentUpVotes, currentDownVotes);
                let inflation = Math.ceil(biggerScore * 0.25);
                currentUpVotes += inflation;
                currentDownVotes += inflation;
            }
        }
    };
    return commands[command]();
}

let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};
solution.call(post, 'upvote');
solution.call(post, 'downvote');
let score = solution.call(post, 'score');  // [127, 127, 0, 'controversial']
console.log(score);
for (let i = 0; i < 50; i++) {
    solution.call(post, 'downvote');       // (executed 50 times)
}
score = solution.call(post, 'score');     // [139, 189, -50, 'unpopular']
console.log(score);
