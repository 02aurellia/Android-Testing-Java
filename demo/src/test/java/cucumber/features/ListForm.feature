@All
Feature: Update dan Delete Data dari List Form

    @Update @Success
    Scenario: Update data
    Given User berhasil membuat data
    When User klik salah satu List
    And User isi ulang data
    And User klik button Ubah
    Then Data berhasil diubah

    @Update @Batal
    Scenario: Batal update data
    Given User berhasil membuat data
    When User klik salah satu List
    And User klik button Batal
    Then User kembali ke page List Form

    @Delete
    Scenario: Delete data
    Given User berhasil membuat data
    When User klik salah satu List
    And User klik button Hapus
    Then User berhasil menghapus data
