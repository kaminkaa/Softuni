function wikiParser(selector) {
    let input = $(selector);

    let h3Pattern = /===(.*?)===/g;
    let h2Pattern = /==(.*?)==/g;
    let h1Pattern = /=(.*?)=/g;
    let bPattern = /'''(.*?)'''/g;
    let iPattern = /''(.*?)''/g;
    let linkPattern = /\[\[([^\[\]]+?)\]\]/g;
    let linkTextPattern = /\[\[([^\[\]]+?)\|(.+?)\]\]/g;

    let text = input.text();
    input.text('');

    text = text
        .replace(h3Pattern, (match,group) => `<h3>${group}</h3>`)
        .replace(h2Pattern, (match,group) => `<h2>${group}</h2>`)
        .replace(h1Pattern, (match,group) => `<h1>${group}</h1>`)
        .replace(bPattern, (match,group) => `<b>${group}</b>`)
        .replace(iPattern, (match,group) => `<i>${group}</i>`)
        .replace(linkTextPattern, (match,link,text) => `<a href='/wiki/${link}'>${text}</a>`)
        .replace(linkPattern, (match,group) => `<a href='/wiki/${group}'>${group}</a>`);

    input.html(text);
}
