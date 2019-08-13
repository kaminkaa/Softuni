//(function createBook() {
   // let id =1;
    function createBook (selector, title, author, isbn) {
        let bookId = 'book' + 1;
        let bookContainer = $(selector);

        let div = $('<div>');
        div.attr('id', bookId);

        let pTitle = $('<p>');
        pTitle.text(title);
        pTitle.addClass('title');

        let pAuthor = $('<p>');
        pAuthor.text(author);
        pAuthor.addClass('author');

        let pIsbn = $('<p>');
        pIsbn.text(isbn);
        pIsbn.addClass('isbn');

        let selectBtn = $('<button>Select</button>');
        let deselectBtn = $('<button>Deselect</button>');

        selectBtn.on('click', function(){
            div.css('border', '2px solid blue');
        });

        deselectBtn.on('click', function() {
            div.css('border', '');
        });

        pTitle.appendTo(div);
        pAuthor.appendTo(div);
        pIsbn.appendTo(div);
        selectBtn.appendTo(div);
        deselectBtn.appendTo(div);

        bookContainer.append(div);
    }
//}());
