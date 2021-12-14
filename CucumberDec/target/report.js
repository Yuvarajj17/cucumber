$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/TVpurchase.feature");
formatter.feature({
  "name": "TV Purchase",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tv"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch the app",
  "keyword": "Given "
});
formatter.match({
  "location": "TVPurchase.user_launch_the_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login by using credentials",
  "keyword": "And "
});
formatter.match({
  "location": "TVPurchase.user_login_by_using_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "TV Purchase",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tv"
    },
    {
      "name": "@MobTV"
    }
  ]
});
formatter.step({
  "name": "user search the Tv",
  "keyword": "When "
});
formatter.match({
  "location": "TVPurchase.user_search_the_Tv()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on the Tv name",
  "keyword": "And "
});
formatter.match({
  "location": "TVPurchase.user_click_on_the_Tv_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on add tocart",
  "keyword": "Then "
});
formatter.match({
  "location": "TVPurchase.user_click_on_add_tocart()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});