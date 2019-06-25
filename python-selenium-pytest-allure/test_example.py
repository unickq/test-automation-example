from selenium import webdriver
from selenium.webdriver.common.keys import Keys

import pytest
import allure
  
@pytest.fixture
def chrome(request):
    global driver
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    if request.node.rep_call.failed:
        allure.attach(driver.get_screenshot_as_png(), name=request.function.__name__, attachment_type=allure.attachment_type.PNG)
    driver.quit()

@allure.step
def search_for(query):
    driver.get("https://github.com")
    qEl = driver.find_element_by_name("q")
    qEl.send_keys(query)
    qEl.send_keys(Keys.RETURN)
    
@allure.step
def get_results(query):
    search_for(query)
    return [el.text for el in driver.find_elements_by_css_selector(".repo-list li h3")]

def test_should_pass(chrome):       
    assert "unickq/allure-nunit" in get_results("allure-nunit")

def test_should_fail(chrome):
    assert "junit" in get_results("allure-nunit")