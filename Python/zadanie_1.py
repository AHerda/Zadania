import matplotlib.pyplot as plt
import numpy as np
from funkcje import *

# obliczenia do wszystkich 3 wykresów

dane, wyniki = [[0 for i1 in range(5000)] for j1 in range(3)], [[0 for i2 in range(5000)] for j2 in range(3)]
dane_big, wyniki_big = [[0 for i3 in range(100)] for j3 in range(3)], [[0 for i4 in range(100)] for j4 in range(3)]
for n in range(100):
    dane_big[0][n] = (n + 1) * 50
    dane_big[1][n] = (n + 1) * 50
    dane_big[2][n] = (n + 1) * 50
    wyniki_srednia = [[0 for i5 in range(50)] for j5 in range(3)]

    for i in range(50):
        dane[0][50 * n + i] = (n + 1) * 50
        dane[1][50 * n + i] = (n + 1) * 50
        dane[2][50 * n + i] = (n + 1) * 50

        dane_temp0 = np.random.uniform(0, 8, ((n + 1) * 50))
        dane_temp1 = np.random.uniform(0, np.pi, ((n + 1) * 50))
        dane_temp2 = np.random.uniform(0, 1, ((n + 1) * 50))

        wyniki_temp0 = np.random.uniform(0, 2, ((n + 1) * 50))
        wyniki_temp1 = np.random.uniform(0, 1, ((n + 1) * 50))
        wyniki_temp2 = np.random.uniform(0, 0.5, ((n + 1) * 50))

        licznik = [0 for i6 in range(3)]
        for j in range(((n + 1) * 50)):
            if wyniki_temp0[j] < f1(dane_temp0[j]):
                licznik[0] += 1
            if wyniki_temp1[j] < f2(dane_temp1[j]):
                licznik[1] += 1
            if wyniki_temp2[j] < f3(dane_temp2[j]):
                licznik[2] += 1

        wyniki_srednia[0][i] = (licznik[0] / ((n + 1) * 50)) * 8 * 2
        wyniki_srednia[1][i] = (licznik[1] / ((n + 1) * 50)) * np.pi
        wyniki_srednia[2][i] = (licznik[2] / ((n + 1) * 50)) * 0.5

        wyniki[0][n * 50 + i] = (licznik[0] / ((n + 1) * 50)) * 8 * 2
        wyniki[1][n * 50 + i] = (licznik[1] / ((n + 1) * 50)) * np.pi
        wyniki[2][n * 50 + i] = (licznik[2] / ((n + 1) * 50)) * 0.5

    wyniki_big[0][n] = np.average(wyniki_srednia[0])
    wyniki_big[1][n] = np.average(wyniki_srednia[1])
    wyniki_big[2][n] = np.average(wyniki_srednia[2])

# Pierwszy wykres

plt.figure(1)

plt.title("Zadanie 1, funkcja = Integral(0, 8, x**(1/3))")
plt.xlabel("Ilość losowych punktów")
plt.ylabel("Wyniki")

plt.plot(dane[0], wyniki[0], "bo", markersize=0.4)
plt.plot(dane_big[0], wyniki_big[0], "ro", markersize=1)
plt.plot((50, 5000), (12, 12), "g-", linewidth=0.8)

plt.savefig("zadanie 1,1.png", dpi=450)

# Drugi wykres

plt.figure(2)

plt.title("Zadanie 1, funkcja = Integral(0, PI, sin(x))")
plt.xlabel("Ilość losowych punktów")
plt.ylabel("Wyniki")

plt.plot(dane[1], wyniki[1], "bo", markersize=0.4)
plt.plot(dane_big[1], wyniki_big[1], "ro", markersize=1)
plt.plot((50, 5000), (2, 2), "g-", linewidth=0.8)

plt.savefig("zadanie 1,2.png", dpi=450)

# Trzeci wykres

plt.figure(3)

plt.title("Zadanie 1, funkcja = Integral(0, 1, 4x(1-x)**3)")
plt.xlabel("Ilość losowych punktów")
plt.ylabel("Wyniki")

plt.plot(dane[2], wyniki[2], "bo", markersize=0.4)
plt.plot(dane_big[2], wyniki_big[2], "ro", markersize=1)
plt.plot((50, 5000), (0.2, 0.2), "g-", linewidth=0.8)

plt.savefig("zadanie 1,3.png", dpi=450)
