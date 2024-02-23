@All
Feature: Login Functionality

    @Login @Success
    Scenario: Sukses Login
        Given Buka Aplikasi
        When Input Data
        And Klik Tombol Login
        Then User masuk homepage

    @Login @Failed
    Scenario: Gagal Login
        Given Buka Aplikasi
        When Input Data Salah
        And Klik Tombol Login
        Then User dapat alert