using System.Linq;
using Allure.Commons;
using NUnit.Allure.Attributes;
using NUnit.Framework;
using OpenQA.Selenium;

namespace Tests
{
    [TestFixture]
    public class TestFixture1 : BaseTest
    {
        [Test]
        [AllureSeverity(SeverityLevel.minor)]
        public void PassedTest()
        {
            var queryElement = Driver.FindElement(By.Name("q"));
            queryElement.SendKeys("allure-nunit");
            queryElement.SendKeys(Keys.Return);

            var resultsElements = Driver.FindElements(By.CssSelector(".repo-list li h3"));

            Assert.AreEqual(1, resultsElements.Select(el => el.Text).Count(t => t.Equals("unickq/allure-nunit")));
        }
    }
}