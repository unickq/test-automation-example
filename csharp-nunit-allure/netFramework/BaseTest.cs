using System.Threading;
using Allure.Commons;
using NUnit.Allure.Core;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace netFramework.Test
{
    [AllureNUnit]
    [Parallelizable(ParallelScope.All)]
    public class BaseTest
    {
        private const string BaseUrl = "https://github.com";

        protected static IWebDriver Driver => ThreadLocalContext.Value;
        private static readonly ThreadLocal<IWebDriver> ThreadLocalContext = new ThreadLocal<IWebDriver>();

        [OneTimeSetUp]
        public void ClearAllureDir()
        {
            AllureLifecycle.Instance.CleanupResultDirectory();
        }

        [SetUp]
        public void Setup()
        {
            ThreadLocalContext.Value = new ChromeDriver();
            Driver.Manage().Window.Maximize();
            Driver.Navigate().GoToUrl(BaseUrl);
        }

        [TearDown]
        public void TearDown()
        {
            ThreadLocalContext.Value.Quit();
            ThreadLocalContext.Value = null;
        }
    }
}