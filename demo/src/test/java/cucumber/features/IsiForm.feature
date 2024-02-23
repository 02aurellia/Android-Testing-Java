@All
Feature: Isi Form

    @IsiForm
    Scenario: Isi Form 
    Given User berhasil Login
    When User klik button Isi Form
    And User isi data form
    And User klik button Submit
    Then User berhasil submit form
