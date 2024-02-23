@All
Feature: Update dan Delete Data dari List Form

    @Update @Success @List
    Scenario: Update data
    Given User berhasil membuat data
    When User klik salah satu List
    And User isi ulang data
    And User klik button Ubah
    Then Data berhasil diubah

    @Update @Batal @List
    Scenario: Batal update data
    Given User berhasil membuat data
    When User klik salah satu List
    And User klik button Batal
    Then User kembali ke page List Form

    @Detail @List
    Scenario: Lihat detail data
    Given User berhasil membuat data
    When User klik salah satu List
    Then User melihat detail data

    @Delete @List
    Scenario: Delete data
    Given User berhasil membuat data
    When User klik salah satu List
    And User klik button Hapus
    Then User berhasil menghapus data
