import Page from './BasePage';

class SearchPage extends Page {
    open() {
        super.open('/');
    }

    get repoH3list() {return $$('.repo-list li h3')}

}

export default new SearchPage();