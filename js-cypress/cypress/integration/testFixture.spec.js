/// <reference types="Cypress" />

context('Actions', () => {
    beforeEach(() => {
      cy.visit('https://github.com/search?q=allure-nunit')
      
      //GitHub redirects, so here's a dirty hack preventing do that
      Cypress.on('window:before:load', (win) => {
        Object.defineProperty(win, 'self', {
          get: () => {
            return window.top
          }
        })
      })

      //This is catch for previous error
      Cypress.on('uncaught:exception', (err, runnable) => {
        return false
      })
    })

    it('should fail', () => {
      cy.get('.repo-list li h3').should('contain', 'junit') 
    })

    it('should pass', () => {
      cy.get('.repo-list li h3').should('contain', 'unickq/allure-nunit') 
    })
})
