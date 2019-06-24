import Page from './BasePage';

class HomePage extends Page {
    open() {
        super.open('/');
    }

    get searchField() {return $('*[name="q"]')}

    searchFor(value) {
        this.searchField.setValue(value);
        browser.keys("\uE007"); 
    }
}

export default new HomePage();