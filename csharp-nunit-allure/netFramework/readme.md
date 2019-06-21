##### Project config
- NetFramework 4.6.1
- NUnit 3
- Selenium 3
- Allure

##### Build
`msbuild netFrameworkTests.csproj`

##### Run tests
`nunit3-console.exe netFrameworkTests.dll`

##### Download Allure CLI from Scoop
`scoop install allure`

##### Serve Allure report
`allure serve allure-results`