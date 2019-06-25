const { expect } = require('chai');
const puppeteer = require('puppeteer')

let browser
let page

describe('Github', () => {
  before(async () => {
    browser = await puppeteer.launch({ headless: false, args: ['--start-maximized'] });
    page = await browser.newPage();
    await page.setViewport({ width: 1366, height: 768 });
  })

  after(async () => {
    await browser.close()
  })

  async function getRepos(query) {
    await page.goto('https://github.com', { waitUntil: 'networkidle0' });
    await page.type('.header-search-input', query)
    await page.keyboard.press('Enter');
    await page.waitForSelector(".repo-list li h3 > a");
    return await page.evaluate(() => Array.from(document.querySelectorAll('.repo-list li h3 > a'), el => el.textContent));
  }

  it('should pass', async () => {
    expect(await getRepos("allure-nunit")).to.include("unickq/allure-nunit");
  });

  it('should fail', async () => {
    expect(await getRepos("allure-nunit")).to.include("junit");
  });
});