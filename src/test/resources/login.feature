  Feature: login to i.ua
    Scenario: I login to i.ua mail
      Given I on iua main page with russian localization
      When Enter e-mail as testmailswat@i.ua and password as 123456qwerty and press login button
      Then Check my login