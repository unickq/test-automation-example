using System.Linq;
using Allure.Commons;
using NUnit.Allure.Attributes;
using NUnit.Framework;
using OpenQA.Selenium;

namespace Tests
{
    [TestFixture]
    public class TestFixture2 : BaseTest
    {
        [Test]
        [AllureSeverity(SeverityLevel.minor)]
        public void FailedTest()
        {
            var queryElement = Driver.FindElement(By.Name("q"));
            queryElement.SendKeys("allure-nunit");
            queryElement.SendKeys(Keys.Return);

            var resultsElements = Driver.FindElements(By.CssSelector(".repo-list li h3"));

            Assert.DoesNotThrow(() => resultsElements.Select(el => el.Text).First(t => t.Equals("unickq")));
        }
    }
}