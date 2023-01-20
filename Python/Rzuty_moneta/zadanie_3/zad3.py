import matplotlib.pyplot as plt
import numpy
from scipy.stats import arcsine


file = open("wyniki.txt")
str = file.read().split()
N_str = str[::2]
dane_str = str[1::2] 
file.close()

N = []
dane = []
for i in range(len(N_str)):
    N.append(int(N_str[i]))
    dane.append(float(dane_str[i]) / N[i])


plt.figure(1)

plt.title("Wykres gęstości P_N gdzie N=100")
plt.xlabel("Czas \"nad\" osią OX")

plt.hist(dane[:5000], 20, density = "true", label = "Gęstość prawdopodobieństwa P_N")
x = numpy.linspace(.025, .975, 200)
plt.plot(x, arcsine.pdf(x), "r-", label = "Gęstość rozkładu arcusa sinusa")

plt.legend(loc = 9)
plt.savefig("wkresP_100.png", dpi=300)

plt.figure(2)

plt.title("Wykres gęstości P_N gdzie N=1000")
plt.xlabel("Czas \"nad\" osią OX")

plt.hist(dane[5000:10000], 20, density = "true", label = "Gęstość prawdopodobieństwa P_N")
x = numpy.linspace(.025, .975, 200)
plt.plot(x, arcsine.pdf(x), "r-", label = "Gęstość rozkładu arcusa sinusa")

plt.legend(loc = 9)
plt.savefig("wkresP_1000.png", dpi=300)

plt.figure(3)

plt.title("Wykres gęstości P_N gdzie N=10000")
plt.xlabel("Czas \"nad\" osią OX")

plt.hist(dane[10000:], 20, density = "true", label = "Gęstość prawdopodobieństwa P_N")
x = numpy.linspace(.025, .975, 200)
plt.plot(x, arcsine.pdf(x), "r-", label = "Gęstość rozkładu arcusa sinusa")

plt.legend(loc = 9)
plt.savefig("wkresP_10000.png", dpi=300)