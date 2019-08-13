function solve() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return 'Post: ' + this.title + '\n' + 'Content: ' + this.content;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.likes = Number(likes);
            this.dislikes = Number(dislikes);
            this.comments = [];
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            let baseStr = super.toString();
            let rating = this.likes - this.dislikes;
            let str = baseStr + '\n' + 'Rating: ' + rating;
            if (this.comments.length > 0) {
                str += '\n' + 'Comments:';
                for (let comment of this.comments) {
                    str += '\n' + ' * ' + comment;
                }
            }
            return str;
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this.views = Number(views);
        }

        view() {
            this.views++;
            return this;
        }

        toString() {
            let baseStr = super.toString();
            return baseStr + '\n' + 'Views: ' + this.views;
        }
    }
    return {Post, SocialMediaPost, BlogPost};
}

let classes = solve();

let test = new classes.SocialMediaPost("TestTitle", "TestContent", 5, 10);

console.log(test.toString());

/*expect(test.toString()).to.be.equal(
    "Post: TestTitle\n" +
    "Content: TestContent\n" +
    "Rating: -5",
    "'SocialMediaPost toString()' function does not return correct results");*/