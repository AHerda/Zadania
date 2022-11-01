from funkcje import *
import numpy as np
import matplotlib.pyplot as plt

n_tab = np.linspace(5000, 100000, 20, dtype=int)

dane, wyniki = [0]*1000, [0]*1000
wyniki_big = [0]*20

for i in range(len(n_tab)):
    wyniki_srednia = [0]*50

    for j in range(50):
        dane[i * 50 + j] = n_tab[i]

        dane_temp = np.random.uniform(0, 2, n_tab[i])
        wyniki_temp = np.random.uniform(0, 2, n_tab[i])

        licznik = 0

        for k in range(n_tab[i]):
            if wyniki_temp[k] < (f4(dane_temp[k])+1) and wyniki_temp[k] > ((-f4(dane_temp[k]))+1):
                licznik += 1

        na_szybko = (licznik/n_tab[i])*2*2
        wyniki_srednia[j] = na_szybko
        wyniki[i * 50 + j] = na_szybko

    wyniki_big[i] = np.average(wyniki_srednia)

# tworzenie wykresu
plt.figure(4)

plt.title("Zadanie 2, funkcja: (x-1)^2+(y-1)^2=1\nPI_average = " + str(np.average(wyniki_big)) + "\nPI_last = " + str(wyniki_big[19]))
plt.xlabel("Ilość losowych punktów")
plt.ylabel("Wyniki")

plt.plot(dane, wyniki, "bo", markersize=0.4)
plt.plot(n_tab, wyniki_big, "r-o", markersize=1, linewidth = 0.5)

plt.savefig("zadanie 2.png", dpi=450)
