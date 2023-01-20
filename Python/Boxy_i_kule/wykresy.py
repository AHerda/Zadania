import matplotlib.pyplot as plt
from numpy import sqrt, log



def srednie(lista):
    srednia = [0]*100
    for i in range(100):
        suma = 0
        for j in range(50):
            suma += lista[i * 50 + j]
        srednia[i] = (suma/50)
    return srednia


n_poj = range(1000, 100001, 1000)
n_log = log(n_poj)
n_loglog = log(n_log)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
n_str = uchwyt.read().split()[::7]
uchwyt.close()

n = []
for i in range(len(n_str)):
    if(i == 0):
        n.append(int(n_str[i][-4:]))
    else:
        n.append(int(n_str[i]))

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Bn_str = uchwyt.read().split()[1::7]
uchwyt.close()

Bn = []
for i in Bn_str:
    Bn.append(int(i))

bn = srednie(Bn)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Un_str = uchwyt.read().split()[2::7]
uchwyt.close()

Un = []
for i in Un_str:
    Un.append(int(i))

un = srednie(Un)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Ln_str = uchwyt.read().split()[3::7]
uchwyt.close()

Ln = []
for i in Ln_str:
    Ln.append(int(i))

ln = srednie(Ln)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Cn_str = uchwyt.read().split()[4::7]
uchwyt.close()

Cn = []
for i in Cn_str:
    Cn.append(int(i))

cn = srednie(Cn)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Dn_str = uchwyt.read().split()[5::7]
uchwyt.close()

Dn = []
for i in Dn_str:
    Dn.append(int(i))

dn = srednie(Dn)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
DCn_str = uchwyt.read().split()[6::7]
uchwyt.close()

DCn = []
for i in DCn_str:
    DCn.append(int(i))

dcn = srednie(DCn)


plt.figure(1)

plt.title("Wykres Bn")
plt.xlabel("Ilość urn")
plt.ylabel("Bn")

plt.plot(n, Bn, "bo", markersize=1)
plt.plot(n_poj, bn, "ro-", markersize=1, linewidth=1)

plt.savefig("wykres Bn.png", dpi=300)

plt.figure(2)

plt.title("Wykres Un")
plt.xlabel("Ilość urn")
plt.ylabel("Un")

plt.plot(n, Un, "bo", markersize=1)
plt.plot(n_poj, un, "ro-", markersize=1, linewidth=1)

plt.savefig("wykres Un.png", dpi=300)

plt.figure(3)

plt.title("Wykres Ln")
plt.xlabel("Ilość urn")
plt.ylabel("Ln")

plt.hist2d(n, Ln, bins=100, cmap="Blues")
plt.plot(n_poj, ln, "ro-", markersize=1, linewidth=1)

cb = plt.colorbar()
cb.set_label("Ilość prob")

plt.savefig("wykres Ln.png", dpi=300)

plt.figure(4)

plt.title("Wykres Cn")
plt.xlabel("Ilość urn")
plt.ylabel("Cn")

plt.plot(n, Cn, "bo", markersize=1)
plt.plot(n_poj, cn, "ro-", markersize=1, linewidth=1)

plt.savefig("wykres Cn.png", dpi=300)

plt.figure(5)

plt.title("Wykres Dn")
plt.xlabel("Ilość urn")
plt.ylabel("Dn")

plt.plot(n, Dn, "bo", markersize=1)
plt.plot(n_poj, dn, "ro-", markersize=1, linewidth=1)

plt.savefig("wykres Dn.png", dpi=300)

plt.figure(6)

plt.title("Wykres Dn-Cn")
plt.xlabel("Ilość urn")
plt.ylabel("Dn-Cn")

plt.plot(n, DCn, "bo", markersize=1)
plt.plot(n_poj, dcn, "ro-", markersize=1, linewidth=1)

plt.savefig("wykres DCn.png", dpi=300)

for i in range(100):
    dcn[i] = dn[i] - cn[i]

plt.figure(7)

bn1 = [0] * 100
for i in range(100):
    bn1[i] = bn[i]/n_poj[i]

plt.subplot(2, 1, 1)
plt.plot(n_poj, bn1, "yo-", markersize=1, linewidth=1)
plt.ylabel("b(n)/n")

for i in range(100):
    bn[i] = bn[i]/sqrt(n_poj[i])

plt.subplot(2, 1, 2)
plt.plot(n_poj, bn, "go-", markersize=1, linewidth=1)
plt.ylabel("b(n)/sqrt(n)")


plt.subplots_adjust(hspace=0.2)
plt.xlabel("n")

plt.savefig("wykres bnn.png", dpi=300)

plt.figure(8)

for i in range(100):
    un[i] = un[i]/n_poj[i]

plt.xlabel("n")
plt.ylabel("u(n)/n")
plt.plot(n_poj, un, "go-", markersize=1)

plt.savefig("wykres unn.png", dpi=300)

plt.figure(9)
plt.xlabel("n")

ln1 = [0] * 100
for i in range(100):
    ln1[i] = ln[i]/n_log[i]

plt.subplot(3, 1, 1)
plt.plot(n_poj, ln1, "yo-", markersize=1, linewidth=1)
plt.ylabel("l(n)/ln(n)")

for i in range(100):
    ln1[i] = ln[i]/(n_log[i]/n_loglog[i])

plt.subplot(3, 1, 2)
plt.plot(n_poj, ln1, "go-", markersize=1, linewidth=1)
plt.ylabel("l(n) / (ln(n)/ln(ln(n)))")

for i in range(100):
    ln1[i] = ln[i]/n_loglog[i]

plt.subplot(3, 1, 3)
plt.plot(n_poj, ln1, "ro-", markersize=1, linewidth=1)
plt.ylabel("l(n)/ln(ln(n))")

plt.subplots_adjust(hspace=0.2)
plt.savefig("wykres lnn.png", dpi=300)

plt.figure(10)
plt.xlabel("n")

cn1 = [0] * 100
for i in range(100):
    cn1[i] = cn[i]/n_poj[i]

plt.subplot(3, 1, 1)
plt.plot(n_poj, cn1, "yo-", markersize=1, linewidth=1)
plt.ylabel("c(n)/n")

for i in range(100):
    cn1[i] = cn[i]/(n_log[i]*n_poj[i])

plt.subplot(3, 1, 2)
plt.plot(n_poj, cn1, "go-", markersize=1, linewidth=1)
plt.ylabel("c(n) / (n*ln(n))")

for i in range(100):
    cn1[i] = cn[i]/(n_poj[i]**2)

plt.subplot(3, 1, 3)
plt.plot(n_poj, cn1, "ro-", markersize=1, linewidth=1)
plt.ylabel("c(n)/n^2")

plt.subplots_adjust(hspace=0.2)
plt.savefig("wykres cnn.png", dpi=300)

plt.figure(11)
plt.xlabel("n")

dn1 = [0] * 100
for i in range(100):
    dn1[i] = dn[i]/n_poj[i]

plt.subplot(3, 1, 1)
plt.plot(n_poj, dn1, "yo-", markersize=1, linewidth=1)
plt.ylabel("d(n)/n")

for i in range(100):
    dn1[i] = dn[i]/(n_log[i]*n_poj[i])

plt.subplot(3, 1, 2)
plt.plot(n_poj, dn1, "go-", markersize=1, linewidth=1)
plt.ylabel("d(n) / (n*ln(n))")

for i in range(100):
    dn1[i] = dn[i]/(n_poj[i]**2)

plt.subplot(3, 1, 3)
plt.plot(n_poj, dn1, "ro-", markersize=1, linewidth=1)
plt.ylabel("d(n)/n^2")

plt.subplots_adjust(hspace=0.2)
plt.savefig("wykres dnn.png", dpi=300)

plt.figure(12)
plt.xlabel("n")

dcn1 = [0] * 100
for i in range(100):
    dcn1[i] = dcn[i]/n_poj[i]

plt.subplot(3, 1, 1)
plt.plot(n_poj, dcn1, "yo-", markersize=1, linewidth=1)
plt.ylabel("(d(n)-c(n))/n")

for i in range(100):
    dcn1[i] = dcn[i]/(n_log[i]*n_poj[i])

plt.subplot(3, 1, 2)
plt.plot(n_poj, dcn1, "go-", markersize=1, linewidth=1)
plt.ylabel("(d(n)-c(n)) / (n*ln(n))")

for i in range(100):
    dcn1[i] = dcn[i]/(n_poj[i]*n_loglog[i])

plt.subplot(3, 1, 3)
plt.plot(n_poj, dcn1, "ro-", markersize=1, linewidth=1)
plt.ylabel("(d(n)-c(n)) / (n*log(log(n)))")

plt.savefig("wykres dcnn.png", dpi=300)