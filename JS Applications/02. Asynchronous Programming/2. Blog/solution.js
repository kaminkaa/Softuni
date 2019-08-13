function attachEvents() {
    let url = "https://baas.kinvey.com/appdata/kid_r18QKDL5z";
    let username = "peter";
    let password = "p";
    let base64auth = btoa(username + ":" + password);
    let authHeaders = {'Authorization': 'Basic ' + base64auth};

    let posts = [];

    $('#btnLoadPosts').on('click',loadPosts);
    $('#btnViewPost').on('click',viewPost);

    function loadPosts() {
       $.ajax({
           url: url + '/posts',
           headers: authHeaders })
           .then(displayPosts)
           .catch(displayError);
    }

    function displayPosts(dataEntry) {
        posts = dataEntry;
        for (let post of posts) {
            $('#posts').append($(`<option value=${post._id}>${post.title}</option>`));
        }
    }

    function displayError(err) {
        console.log(err);
    }

    function viewPost() {
        let postID = $('#posts').val();
        let post = posts.find(p => p._id === postID);
        $('#post-title').text(post.title);
        $('#post-body').text(post.body);
        $.ajax({
            url: url + `/comments/?query={"post_id":"${postID}"}`,
            headers: authHeaders })
            .then(displayComments)
            .catch(displayError);
    }

    function displayComments(comments) {
        $('#post-comments').empty();
        for (let comment of comments) {
            $('#post-comments').append($(`<li>${comment.text}</li>`));
        }
    }
}