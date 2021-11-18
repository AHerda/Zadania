class Student:
    def __init__(self, imie, nazwisko, id_ucznia):
        self.imie = imie
        self.nazwisko = nazwisko
        self.id = id_ucznia
        self.oceny = {"przedmiot_1": [], "przedmiot_2": [], "przedmiot_3": []}

    def dodaj_ocene(self, przedmiot, ocena):
        self.oceny[przedmiot].append(ocena)

    def zmien_ocene(self, przedmiot, indeks_oceny, ocena):
        self.oceny[przedmiot][indeks_oceny] = ocena

    def wyswietl_ocene(self, przedmiot, indeks_oceny):
        print(self.oceny[przedmiot][indeks_oceny])


ja = Student("Kuba", "Piotrowski", 69420)
ja.dodaj_ocene("przedmiot_1", 1)
ja.dodaj_ocene("przedmiot_2", 1)
ja.dodaj_ocene("przedmiot_3", 1)
ja.dodaj_ocene("przedmiot_1", 2)
ja.dodaj_ocene("przedmiot_2", 2)
ja.dodaj_ocene("przedmiot_3", 2)
ja.dodaj_ocene("przedmiot_1", 1)
ja.dodaj_ocene("przedmiot_2", 1)
ja.dodaj_ocene("przedmiot_3", 1)

ja.wyswietl_ocene("przedmiot_2", 1)
ja.wyswietl_ocene("przedmiot_2", 2)

ja.zmien_ocene("przedmiot_2", 1, 1)
ja.wyswietl_ocene("przedmiot_2", 1)
