# map-selenium
Small ui test using a simple page object model implementation. Using Junit as a test framework and remote webdriver to avoid having to hardcode the path. 

Google implemented a cookie consent popup which is an Iframe. I decided to tackle that obstacle by setting the cookie so I could avoid the popup instead of using UI actions that can be more flaky and more time consuming. 

As usual with Selenium I had to implement some waits for some of the elements used because the tests would be flaky without the waits.
