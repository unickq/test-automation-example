import { expect } from 'chai';
import HomePage from 'src/pages/Home.Page';
import SearchPage from 'src/pages/Search.Page';

describe('Github', () => {
    beforeEach(() => {
        HomePage.open();
        HomePage.searchFor('allure-nunit')
    })

    it('should pass', () => {
        expect(SearchPage.repoH3list.map(function(el){
            return el.getText()
        })).to.include('unickq/allure-nunit');
    });

    it('should fail', () => {
        expect(SearchPage.repoH3list.map(function(el){
            return el.getText()
        })).to.include('junit');
    });
});