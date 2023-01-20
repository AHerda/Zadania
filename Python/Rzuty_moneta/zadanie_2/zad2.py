from scipy.stats import norm
import numpy
import matplotlib.pyplot as plt

uchwyt = open("wyniki.txt")
wyniki_5 = uchwyt.readline().split()[1:]

piec = []
suma = 0
for i in wyniki_5:
    suma += int(i) / 100000
    piec.append(suma)

wyniki_10 = uchwyt.readline().split()[1:]
dziesiec = []
suma = 0
for i in wyniki_10:
    suma += int(i) / 100000
    dziesiec.append(suma)

wyniki_15 = uchwyt.readline().split()[1:]
pietnascie = []
suma = 0
for i in wyniki_15:
    suma += int(i) / 100000
    pietnascie.append(suma)

wyniki_20 = uchwyt.readline().split()[1:]
dwadziescia = []
suma = 0
for i in wyniki_20:
    suma += int(i) / 100000
    dwadziescia.append(suma)

wyniki_25 = uchwyt.readline().split()[1:]
dwadziesciapiec = []
suma = 0
for i in wyniki_25:
    suma += int(i) / 100000
    dwadziesciapiec.append(suma)

wyniki_30 = uchwyt.readline().split()[1:]
trzydziesci = []
suma = 0
for i in wyniki_30:
    suma += int(i) / 100000
    trzydziesci.append(suma)

wyniki_100 = uchwyt.readline().split()[1:]
sto = []
suma = 0
for i in wyniki_100:
    suma += int(i) / 1000000
    sto.append(suma)


plt.figure(1)

plt.title("Wykres dystrybuanty S_N dla N=5")
plt.xlabel("x")
plt.ylabel("P(S_5 <= x)")

plt.bar(range(-5, 6), piec, width=0.9, label = "Dystrybuanta S_5")
plt.plot(numpy.linspace(-5, 5, 1000), norm.cdf(numpy.linspace(-5, 5, 1000), scale = 5 ** (1/2)), "r-", label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_5.png", dpi=300)


plt.figure(2)

plt.title("Wykres dystrybuanty S_N dla N=10")
plt.xlabel("x")
plt.ylabel("P(S_10 <= x)")

plt.bar(range(-10, 11), dziesiec, width=0.94, label = "Dystrybuanta S_10")
plt.plot(numpy.linspace(-10,10, 1000), norm.cdf(numpy.linspace(-10, 10, 1000), scale = 10 ** (1/2)), "r-", label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_10.png", dpi=300)


plt.figure(3)

plt.title("Wykres dystrybuanty S_N dla N=15")
plt.xlabel("x")
plt.ylabel("P(S_15 <= x)")

plt.bar(range(-15, 16), pietnascie, width=0.93, label = "Dystrybuanta S_15")
plt.plot(numpy.linspace(-15,15, 1000), norm.cdf(numpy.linspace(-15, 15, 1000), scale = 15 ** (1/2)), "r-", label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_15.png", dpi=300)


plt.figure(4)

plt.title("Wykres dystrybuanty S_N dla N=20")
plt.xlabel("x")
plt.ylabel("P(S_20 <= x)")

plt.bar(range(-20, 21), dwadziescia, width=0.92, label = "Dystrybuanta S_20")
plt.plot(numpy.linspace(-20, 20, 1000), norm.cdf(numpy.linspace(-20, 20, 1000), scale = 20 ** (1/2)), "r-", label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_20.png", dpi=300)


plt.figure(5)

plt.title("Wykres dystrybuanty S_N dla N=25")
plt.xlabel("x")
plt.ylabel("P(S_25 <= x)")

plt.bar(range(-25, 26), dwadziesciapiec, width=0.91, label = "Dystrybuanta S_25")
plt.plot(numpy.linspace(-25, 25, 1000), norm.cdf(numpy.linspace(-25, 25, 1000), scale = 25 ** (1/2)), "r-", label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_25.png", dpi=300)


plt.figure(6)

plt.title("Wykres dystrybuanty S_N dla N=30")
plt.xlabel("x")
plt.ylabel("P(S_30 <= x)")

plt.bar(range(-30, 31), trzydziesci, width=0.89, label = "Dystrybuanta S_30")
plt.plot(numpy.linspace(-30, 30, 1000), norm.cdf(numpy.linspace(-30, 30, 1000), scale = 30 ** (1/2)), "r-", label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_30.png", dpi=300)


plt.figure(7)

plt.title("Wykres dystrybuanty S_N dla N=100")
plt.xlabel("x")
plt.ylabel("P(S_100 <= x)")

plt.bar(range(-100, 101), sto, width=0.85, label = "Dystrybuanta S_100")
plt.plot(numpy.linspace(-100,100, 10000), norm.cdf(numpy.linspace(-100, 100, 10000), scale = 100 ** (1/2)), "r-", linewidth = 1, label = "Dystrybuanta rozkładu normalnego")

plt.legend(loc = 4, fontsize = "xx-small")

plt.savefig("wykres_100.png", dpi=300)